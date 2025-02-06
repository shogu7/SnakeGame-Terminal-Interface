import java.awt.Point;
import java.util.LinkedList;

public class World {
    private final Snake snake;
    private final int x;
    private final int y;
    private final int[][] world;
    private int score = 0;

    public World(int x, int y, Snake snake) {
        this.world = new int[x][y];
        this.snake = snake;
        this.x = x;
        this.y = y;
    }

    public int[][] getWorld() {
        return world;
    }

    public Snake getsnake(){
        return snake;
    }
    
    public Point getWorldLimit() {
        return new Point(x, y);
    }

    public void updateWorld() {
        for (int[] world1 : world) {
            for (int j = 0; j < world1.length; j++) {
                if(world1[j] == 0 || world1[j] == 1)
                    world1[j] = 0;
            } 
        }
        getNewApple();
        boolean snakeOnApple = findSnake(snake); // SankeOnApple variable used to determiend if our snake are eating an apple if yes so we need to add one more body to our snake
        System.out.println(snakeOnApple);
        if(snakeOnApple) {
            score++;
            snake.extendBodySnake();
        }
        
    }

    public void DisplayArray() { // PROBLEM: affiche deux world a la place de tout suprimer et n'ent aficher qu'un seul.
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\033[43mScore = " + score + "\033[0m");

        int i, j;
        for(i=0; i < world.length; i++) {
            for(j=0; j < world[i].length; j++) {
                switch (world[i][j]) {
                    case 2:
                        System.out.print("\033[31m" + world[i][j] + "\033[0m, ");
                        break;
                    case 1:
                        System.out.print("\033[32m" + world[i][j] + "\033[0m, ");
                        break;
                    default:
                        System.out.print(world[i][j] + ", ");
                        break;
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String result = "";
        int i, j;
        for(i=0; i < world.length; i++ ) {
            for(j=0; j < world[i].length; j++) {
                    result += Integer.toString(world[i][j]) + ", "; 
            }
            result += "\n";
        }
        return result;
    }

    public boolean findSnake(Snake snake){
        boolean snakeOnApple = false;
        LinkedList<Point> body = snake.getBody();
        for(Point p : body){
            if(world[p.x][p.y] == 2) {
                snakeOnApple = true;
            }
            world[p.x][p.y] = 1; 
        }
        return snakeOnApple;
    }

    public void findApple(Point applePosition) {
        world[applePosition.x][applePosition.y] = 2;
    }
        
    public void getworld(){
        updateWorld();
        DisplayArray();
    }

    public void getNewApple() {
        for(int i=0; i < world.length; i++ ) {
            for(int j=0; j < world[i].length; j++) {
                if (world[i][j] == 2) {
                    return;
                }
            } 
        }
        findApple(Game.getInstance().appleManager());
    }
}