package server.model;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ClientConnectie {
    private static final InetSocketAddress ip = new InetSocketAddress("localhost",1337);
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public ClientConnectie(){
        try {
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.configureBlocking(false);
            this.serverSocketChannel.register(this.selector = Selector.open(),SelectionKey.OP_ACCEPT);
            this.serverSocketChannel.bind(ip);
        }catch (IOException i){
            i.printStackTrace();
        }
        //open configureblocking register bind
    }
}
