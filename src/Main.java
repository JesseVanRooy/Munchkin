import client.Client;

/**
 * Created by Jesse on 6/03/2015.
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.verbindMetServer("localhost",1337);
        client.getServerManager().push("PING");
        System.out.println(client.getServerManager().pull());
    }
}
