import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private final ItemSpawner item;
    private final World world;
    private final Snake snake;
    boolean isRunning = true;
    private static Game instance = null;

    public Game(int x, int y) {
        item = new ItemSpawner();
        snake = new Snake();
        this.world = new World(x, y, snake);
        instance = this;
    }

    public Game() {
        item = new ItemSpawner();
        snake = new Snake();
        this.world = new World(10, 10, snake);
        instance = this;
    }

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }
    //#region Getter and Setter
    public Snake getSnake(){
        return snake;
    }

    public World getWorld(){
        return world;
    }
    //#endregion

    //UPDATE: Call the snake.move() --> determined to allowed physic for the snake. If the snake did a wrong mouvement gameOver is call.
    public void snakePhysicsLogic() { 
        Point head = snake.getBody().getFirst();
        LinkedList<Point> body = snake.getBody();
        for (int i = 1; i < body.size(); i++) { 
            if (head.equals(body.get(i))) {
                gameOver();
                return;
            }
        }
    }

    public boolean run() {
        world.getworld();
        try (Scanner scanner = new Scanner(System.in)) {
            while(isRunning) {
                if(scanner.hasNextLine()){
                    String input = scanner.nextLine();
                    System.out.println("Input reçu: " + input);
                    switch(input) {
                        case "z": 
                            snake.setDirection(Direction.up); 
                            break;
                        case "s": 
                            snake.setDirection(Direction.down); 
                            break;
                        case "q": 
                            snake.setDirection(Direction.left); 
                            break;
                        case "d": 
                            snake.setDirection(Direction.right); 
                            break;
                    }
                }
                snakePhysicsLogic();
                world.getworld();
                if(checkWinConditon()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Point appleManager() {
        Point applePosition = item.apple(world.getWorldLimit());
        LinkedList<Point> body = snake.getBody();
        for(Point bodyPart : body) {
            if(applePosition.equals(bodyPart)) {
                return appleManager();
            }
        }
        return applePosition;
    }

    private void gameOver(){
        isRunning = false;
    }

    public boolean checkWinConditon() {
        LinkedList<Point> body = snake.getBody();
        return body.size() == 16;
    }
}



