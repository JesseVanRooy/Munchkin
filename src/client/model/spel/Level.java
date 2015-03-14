package client.model.spel;

/**
 * Created by Jesse on 6/03/2015.
 */
public class Level {
    private int level;

    public Level(){
        this.level = 1;
    }

    public void gaLevelOmhoog(){
        this.level++;
    }

    public void gaLevelOmlaag(){
        this.level--;
    }

    public void resetLevel(){
        this.level = 1;
    }

    public boolean is10(){
        return this.level==10;
    }

    public int getLevel(){
        return this.level;
    }
}
