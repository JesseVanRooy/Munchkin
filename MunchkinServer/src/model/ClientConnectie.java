package model;


import server.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ClientConnectie {
    private SelectionKey selectionKey;
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;

    public ClientConnectie(SelectionKey selectionKey,SocketChannel socketChannel){
        this.selectionKey = selectionKey;
        this.socketChannel = socketChannel;
        this.byteBuffer = ByteBuffer.allocate(64);
    }

    public void disconnect(){
        Server.spelMap.remove(selectionKey);
        try {
            if(selectionKey != null){
                selectionKey.cancel();
            }
            if(socketChannel == null){
                return;
            }
            System.out.println((InetSocketAddress) socketChannel.getRemoteAddress() + " disconnected.");
            socketChannel.close();
        }catch (IOException i){

        }
    }

    public String lees(){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            this.socketChannel.read((ByteBuffer)byteBuffer.clear());
            for(byte b : byteBuffer.array()){
                stringBuilder.append((char)b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void schrijf(String commando){
        byteBuffer = ByteBuffer.wrap(commando.getBytes());
        byteBuffer.flip();
        try {
            this.socketChannel.write(byteBuffer);
            byteBuffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
