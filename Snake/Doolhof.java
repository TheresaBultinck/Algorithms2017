package Snake;

import java.util.Random;

public class Doolhof {
    private String[][] matrix;
    private int col;
    private int row;
    private boolean run = true;

    public Doolhof(int row, int col) {
        this.col = col;
        this.row = row;
        matrix = new String[row][col];
        initializeDoolhof();
    }

    private void drawVerticalWalls() {
        for (int i = 0; i < row; i++) {
            matrix[i][0] = "|";
            matrix[i][col - 1] = "|";
        }
    }

    private void drawHorizontalWalls() {
        for (int j = 0; j < col; j++) {
            matrix[0][j] = "-";
            matrix[row - 1][j] = "-";
        }
    }

    private void fillWithSpace() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = " ";
            }
        }
    }

    private void initializeDoolhof() {
        fillWithSpace();
        drawHorizontalWalls();
        drawVerticalWalls();
    }

    public void drawSnake(Snake snake) {
        Node<Part> current = snake.getSnake().head();
        Part part = current.get();
        matrix[part.getX()][part.getY()] = snake.getHeadSymbol();

        while (current.next() != null) {
            current = current.next();
            part = current.get();
            matrix[part.getX()][part.getY()] = snake.getBodySymbol();
        }
    }

    public void drawFood(Food food) {
        matrix[food.getX()][food.getY()] = food.getSymbol();
    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void updateField(Snake snake, Food food) {
        clearField();
        drawFood(food);
        drawSnake(snake);
        print();
    }

    private void clearField() {
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!matrix[i][j].equals("*")) {
                    matrix[i][j] = " ";
                }
            }
        }
    }

  public void validateField(Snake snake) {
        Part head = snake.getSnake().head().get();
        //Bovenmuur en ondermuur
        if (head.getX() == 0 || head.getX() == row - 1 || head.getY() == 0 || head.getY() == col - 1) {
            run = false;
        } else {
            run = true;
        }
    }

    public boolean isPositionFree(int x, int y) {
        if (matrix[x][y].equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean foodAtPosition(int x, int y) {
        if (matrix[x][y].equals("*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRunning() {
        return run;
    }

    public int getRows() {
        return row;
    }

    public int getCols() {
        return col;
    }


}
