Here is my SnakeGame with java using terminal as an interface. To win the game you need to collect 15 Apples, dont walk on yourself or you're gonna die.
This is my second project in java, here are the step i followed for creating this project :
I would like to thanks @kuroshire for their invaluable assistance with the project, particularly for their clear explanation of the code and guidance on structuring the code effectively.

# Explanation for creating Snake

## Explanation of the world:
In the `World` class, there are "cells" that are accessible in the 2D array (`int[][] world`). Each of these cells has a value inside, which is currently an int (0 by default). What we can do is say that:
- 0 represents an empty cell
- 1 represents a snake cell
- 2 represents an apple cell  
(We could also use an enum if preferred).

### The snake has the following features:
1. It can be moved by user input.
2. It can eat an apple, and when it does, it grows by 1 cell in size.
3. If it bumps into itself, it dies, and the game ends.

For the apples, there needs to be an `AppleSpawner`, which will take care of finding a random cell in the array to place the apple. This cell must be empty when the apple is created. The apple is automatically created when the snake eats the previous one and grows.

---

## Things to do:

### 1. Create a 2D World class
- Have a 2d array as a world variable. Default value is 0, representing an empty tile in our world.
- 1 representing Snake
- 2 representing Apple
- Have a display function, which is gonna be called each timesteps.

### 2. Create a Snake class with:
- A list of cells representing the snake's body positions in the 2D world.
- Management of the snake's movement. *Note:* Instead of moving the entire body, I can simply create a new head in the new position and remove the tail.
- A function to handle user inputs (If possible, make it a separate class if you're up for it).  
  *Note:* When the user inputs something, the game needs to update to display the world correctly.
- A function that checks if the snake has stepped on an apple, and if so:
  - Eats the apple
  - Grows the snake by 1
  - Spawns a new apple with the help of the `AppleManager`.

### 3. Create an AppleManager class with:
- A reference to the current apple's position.
- A `SpawnApple()` function that looks for a random cell, verifies it's empty, and spawns the apple in that location.  
  *Note:* "Spawning" is simply a change of position.

---

## Note:
- The snake and apples belong to the world, so the `World` class will need them.
- The `DisplayArray` function of `World` must be able to display all the cells with the correct content (empty, snake, or apple).

Possible additionnal feature : Add the graphical interface on top by using your `World` as the base to correctly display the cell colors based on their content.

