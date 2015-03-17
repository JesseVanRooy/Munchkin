package server;


import client.exceptions.VerbindingVerstoordException;
import server.model.ClientConnectie;
import server.model.ServerData;


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
public class Server {
    public static final int PORT = 1337;

    private ServerData serverData;

    private ServerSocketChannel spelSocketChannel;
    private Selector spelSelector;

    private static Map<SelectionKey,ClientConnectie> spelMap;

    public Server(){
        this.serverData = new ServerData();
        serverData.getProperties().updateProperties(this);
        setUpSpelConnectie();
    }

    private void setUpSpelConnectie(){
        try {
            this.spelSocketChannel = ServerSocketChannel.open();
            this.spelSocketChannel.configureBlocking(false);
            this.spelSocketChannel.register(this.spelSelector = Selector.open(), SelectionKey.OP_ACCEPT);
            this.spelSocketChannel.bind(new InetSocketAddress("localhost",PORT));

            spelMap = new HashMap<SelectionKey, ClientConnectie>();

            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        loop();
                    }catch (Throwable throwable){
                        throwable.printStackTrace();
                    }
                }
            },0,500, TimeUnit.MILLISECONDS);
        } catch (IOException e) {
            throw new VerbindingVerstoordException();
        }

    }


    private void loop(){
        try {
            spelSelector.selectNow();
        } catch (IOException e) {
            throw new VerbindingVerstoordException();
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
                    spelMap.put(leesKey,new ClientConnectie());
                } catch (IOException e) {
                    throw new VerbindingVerstoordException();
                }

            }
            if(key.isReadable()){
                //spelMap.get(key).read();
            }
        }
        spelSelector.selectedKeys().clear();
    }

    public ServerData getServerData() {
        return serverData;
    }
}
