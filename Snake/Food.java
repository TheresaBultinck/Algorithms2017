package Snake;

import java.util.Random;

public class Food {

    private int x = 0;
    private int y = 0;
    private int rows;
    private int cols;
    private String symbol = "*";

    public Food(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        return symbol;
    }

    public void spawnRandomFood(Doolhof doolhof) {
        Random rgX = new Random();
        Random rgY = new Random();

        x = rgX.nextInt(rows - 1);
        y = rgY.nextInt(cols - 1);

        while (!doolhof.isPositionFree(x, y)) {
            x = rgX.nextInt(rows - 1);
            y = rgY.nextInt(cols - 1);
        }

        //check if board is completely full
    }

}
