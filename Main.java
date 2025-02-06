public class Main {
    public static void main(String[] args) { 
        Game game = Game.getInstance();
        boolean condition = game.run();
        if(condition){
            System.out.print("\033[35mGame Completed! Congratz ;-;\033[0m");
        }
        else {
            System.out.print("Game Over!");
        }
    }   
} 
