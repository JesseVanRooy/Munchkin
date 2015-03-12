package tester;

import controller.MunchkinController;

/**
 * Created by Jesse on 12/03/2015.
 */
public class ClientTester {
    public static void main(String[] args) {
        MunchkinController munchkinController = new MunchkinController();
        munchkinController.getClientController().joinServer("127.0.0.1");
    }
}
