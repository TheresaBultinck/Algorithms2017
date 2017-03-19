package Snake;

import java.util.Scanner;

public class Main {

	public static void main (String args[]){
		Doolhof doolhof = null;
		Scanner scanner = new Scanner(System.in);

        System.out.println("*** Snake ***");
        System.out.println("Enter dimension");

        String input = scanner.next();

        try {
            int dimension = Integer.parseInt(input);
            doolhof = new Doolhof(dimension, dimension);
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
            System.exit(0);
        }

        Snake snake = new Snake(doolhof.getRows(), doolhof.getCols());

        Food food =  new Food(doolhof.getRows(),doolhof.getCols());
        food.spawnRandomFood(doolhof);

        doolhof.drawSnake(snake);
        doolhof.drawFood(food);

        doolhof.print();

		while(doolhof.isRunning()){
			System.out.println("Give direction? (zqsd)");
			input = scanner.next();
			snake.doMove(input,doolhof, food);
            doolhof.updateField(snake, food);
            doolhof.validateField(snake);
		}
		
		System.out.println("game over");		
	}
}