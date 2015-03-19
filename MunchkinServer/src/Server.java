
import exceptions.ServerConnectieVerstoordException;
import model.ClientConnectie;
import model.ServerData;
import view.ServerErrorScherm;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jesse on 14/03/2015.
 */
public class Server{
    public static final int PORT = 1337;

    private ServerData serverData;

    private ServerSocketChannel spelSocketChannel;
    private Selector spelSelector;

    public static Map<SelectionKey,ClientConnectie> spelMap;

    private ServerErrorScherm serverErrorScherm;

    public Server(){
        this.serverData = new ServerData();
        //serverData.getProperties().updateProperties(this);
        this.serverErrorScherm = new ServerErrorScherm();
        setUpSpelConnectie();
    }

    private void setUpSpelConnectie(){
        try {
            this.spelSocketChannel = ServerSocketChannel.open();
            this.spelSocketChannel.configureBlocking(false);
            this.spelSocketChannel.register(this.spelSelector = Selector.open(), SelectionKey.OP_ACCEPT);
            this.spelSocketChannel.bind(new InetSocketAddress("localhost",PORT));

            spelMap = new HashMap<SelectionKey, ClientConnectie>();
            System.out.println("server opgestart");
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        loop();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }, 0, 500, TimeUnit.MILLISECONDS);
        } catch (IOException e) {
            throw new ServerConnectieVerstoordException();
        }

    }


    private void loop(){
        System.out.println("looping\n");
        serverErrorScherm.update(serverData.getLog().leesOutputLog());
        try {
            spelSelector.selectNow();
        } catch (IOException e) {
            throw new ServerConnectieVerstoordException();
        }
        for(SelectionKey key : spelSelector.selectedKeys()){
            if(!key.isValid()){
                continue;
            }
            if(key.isAcceptable()){
                try {
                    SocketChannel acceptedChannel = spelSocketChannel.accept();
                    if(acceptedChannel == null){
                        continue;
                    }
                    acceptedChannel.configureBlocking(false);
                    SelectionKey leesKey = acceptedChannel.register(spelSelector,SelectionKey.OP_READ);
                    spelMap.put(leesKey,new ClientConnectie(leesKey,acceptedChannel));
                    System.out.println("client connected");
                } catch (IOException e) {
                    throw new ServerConnectieVerstoordException();
                }

            }
            if(key.isReadable()){
                System.out.println(spelMap.get(key).lees());
            }
        }
        spelSelector.selectedKeys().clear();
    }

    public ServerData getServerData() {
        return serverData;
    }
}
