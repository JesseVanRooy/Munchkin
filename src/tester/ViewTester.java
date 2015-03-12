package tester;

import view.SplashScreen;
import view.client.ClientScherm;
import view.server.ServerScherm;

/**
 * Created by Jesse on 12/03/2015.
 */
public class ViewTester {
    public static void main(String[] args) {
        new SplashScreen();
        ClientScherm clientScherm = new ClientScherm(null);
    }
}
