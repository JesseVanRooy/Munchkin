import controller.MunchkinController;
import model.DeurStapel;
import model.TreasureStapel;

/**
 * Created by Jesse on 6/03/2015.
 */
public class Main {
    public static void main(String[] args) {
        //MunchkinController munchkinController = new MunchkinController();

        DeurStapel deurStapel = new DeurStapel();
        deurStapel.print();

        TreasureStapel treasureStapel = new TreasureStapel();
        treasureStapel.print();
    }
}
