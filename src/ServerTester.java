import controller.MunchkinController;

/**
 * Created by Jesse on 12/03/2015.
 */
public class ServerTester {
    public static void main(String[] args) {
        MunchkinController munchkinController = new MunchkinController();
        munchkinController.getClientController().hostServer();
    }

}
