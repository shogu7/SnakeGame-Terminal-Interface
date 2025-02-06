import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    LinkedList<Point> body; // LinkedList = an list of elements which will designate the next element from the last // Point: containt X;Y position represant a game plan
    Direction direction;
    
    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(5, 5)); // Snake default position
        direction = Direction.right; // Snake default direction
    }

    //setDirection: the player will not able to do 180° deplacement. This function will dectect if this is possible my the ,physic of the snake if yes, direction = newDirection;
    public void setDirection(Direction newDirection){
        if ((newDirection == Direction.up && direction != Direction.down) ||
            (newDirection == Direction.down && direction != Direction.up) ||
            (newDirection == Direction.left && direction != Direction.right) ||
            (newDirection == Direction.right && direction != Direction.left)) {
            direction = newDirection;
            move(direction);
        }
    }

    //checkLimit: Modolo of my x, y for my maps to avoid negative position.
    public Point checkLimit(Point newhead, Point worldLimit) {
        int containedWorldX = (newhead.x + worldLimit.x) % worldLimit.x;
        int containedWorldY = (newhead.y + worldLimit.y) % worldLimit.y;
        return new Point(containedWorldX, containedWorldY);
    }

   //move(): function to move the snake using char direction which is the deplacement variable input user.
    public void move(Direction direction) {
        this.direction = direction;
        Point head = body.getFirst();
        Point newhead = new Point(head.x, head.y);
        switch(direction) {
            case left:
                newhead.y--;
                break;
            case right:
                newhead.y++;
                break;
            case up:
                newhead.x--;
                break;
            case down:
                newhead.x++;
                break;
            default:
                System.out.println("Invalid direction");
                break;
        }
        newhead = checkLimit(newhead, Game.getInstance().getWorld().getWorldLimit());
        body.addFirst(newhead);
        body.removeLast();
    }

    public LinkedList<Point> getBody(){
        return body;
    } 

    public void extendBodySnake() { // Take the last c/o of the snake and assign to the new tail.
        Point tail = body.getLast();
        Point newTail = new Point(tail.x, tail.y);
        body.addLast(newTail);
    }
}
