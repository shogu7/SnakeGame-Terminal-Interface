import java.awt.Point;
import java.util.Random;

public class ItemSpawner {
    private Point applePosition;

    public ItemSpawner(){
   
    }

    public Point getapplePosition() {
        return applePosition;
    }
     
    public Point apple(Point worldLimit) { // , int[][] world
        Random random = new Random();
        int x = random.nextInt(worldLimit.x); // Ajouter fonction pour verrif si pomme pas crée dans corp serpent
        int y = random.nextInt(worldLimit.y);
        // applePosition = new Point(x, y);
        // for(applePosition == wolrd[x][y]) {
            
        // }
        return new Point(x, y);
    }

    
}
