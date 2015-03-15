package connectie;


/**
 * Created by Jesse on 14/03/2015.
 */
public class ConnectieStream {

    private String ip;
    private int port;

    private InputPipeLine inputPipeLine;
    private OutputPipeLine outputPipeLine;

    public ConnectieStream(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
