package Snake;

public class Snake {

    private List snake;
    private String bodySymbol = "x";
    private String headSymbol = "O";
    private Part head;


    public Snake(int row, int col) {
        head = new Part(row / 2, col / 2, true);
        snake = new List<Part>(head);
    }

    public void doMove(String input, Doolhof doolhof, Food food) {
        Direction direction = null;
        switch (input) {
            case "z":
                direction = Direction.UP;
                break;
            case "q":
                direction = Direction.LEFT;
                break;
            case "s":
                direction = Direction.DOWN;
                break;
            case "d":
                direction = Direction.RIGHT;
                break;
            default:
                System.out.println("Please use valid input");
                break;
        }

        if (direction != null) {
            setIndiviualPartDirections(direction);
            move(doolhof, food);
            if (head.hasEaten()) {
                snakeEat();
                food.spawnRandomFood(doolhof);
            }
        }
    }

    private void setIndiviualPartDirections(Direction direction) {

        Node<Part> start = snake.head();
        Direction copyTo = start.get().getDirection();

        while (start.next() != null) {
            Node<Part> newNode = start.next();
            Direction saveDirection = newNode.get().getDirection();

            newNode.get().setDirection(copyTo);
            copyTo = saveDirection;
            start = newNode;
        }

        Node<Part> head = snake.head();
        head.get().setDirection(direction);

    }

    private void move(Doolhof doolhof, Food food) {
        Node<Part> node = snake.head();
        Part part = node.get();
        part.move(snake, doolhof, food);

        while (node.next() != null) {
            node = node.next();
            part = node.get();
            part.move(snake, doolhof, food);
        }
    }

    private void snakeEat() {
        Node<Part> tail = snake.getTail();
        Part tailPart = tail.get();
        snake = tailPart.getDirection().addNewPiece(tailPart, snake);

    }

    public List<Part> getSnake() {
        return snake;
    }

    public String getBodySymbol() {
        return bodySymbol;
    }

    public String getHeadSymbol() {
        return headSymbol;
    }
}
