package Snake;

public enum Direction {
    UP {
        @Override
        public void makeMove(List<Part> snake, Doolhof doolhof, Food food, Part part) {

            //Move the part
            part.setX(part.getX() - 1);

            //Only do this if the part is the head of the snake
            if (part.isHead()) {
                //Check if something to eat
                if (doolhof.foodAtPosition(part.getX(), part.getY())) {
                    part.setHasEaten(true);
                } else {
                    part.setHasEaten(false);
                }
            }
        }

        @Override
        public List<Part> addNewPiece(Part tailPart, List<Part> snake) {
            //Append new piece to tail
            Node<Part> newPiece = new Node<Part>(new Part(tailPart.getX() + 1, tailPart.getY(), tailPart.getDirection(), false));
            snake.append(newPiece);
            return snake;
        }

    }, DOWN {
        @Override
        public void makeMove(List<Part> snake, Doolhof doolhof, Food food, Part part) {

            //Move the snake
            part.setX(part.getX() + 1);

            //Only do this if the part is the head of the snake
            if (part.isHead()) {
                //Check if something to eat
                if (doolhof.foodAtPosition(part.getX(), part.getY())) {
                    part.setHasEaten(true);
                } else {
                    part.setHasEaten(false);
                }
            }
        }

        @Override
        public List<Part> addNewPiece(Part tailPart, List<Part> snake) {
            //Append new piece to tail
            Node<Part> newPiece = new Node<Part>(new Part(tailPart.getX() - 1, tailPart.getY(), tailPart.getDirection(), false));
            snake.append(newPiece);
            return snake;
        }
    }, LEFT {
        @Override
        public void makeMove(List<Part> snake, Doolhof doolhof, Food food, Part part) {

            //Move the snake
            part.setY(part.getY() - 1);

            //Only do this if the part is the head of the snake
            if (part.isHead()) {
                //Check if something to eat
                if (doolhof.foodAtPosition(part.getX(), part.getY())) {
                    part.setHasEaten(true);
                } else {
                    part.setHasEaten(false);
                }
            }
        }

        @Override
        public List<Part> addNewPiece(Part tailPart, List<Part> snake) {
            //Append new piece to tail
            Node<Part> newPiece = new Node<Part>(new Part(tailPart.getX(), tailPart.getY() + 1, tailPart.getDirection(), false));
            snake.append(newPiece);
            return snake;
        }
    },
    RIGHT {
        @Override
        public void makeMove(List<Part> snake, Doolhof doolhof, Food food, Part part) {

            //Move the snake
            part.setY(part.getY() + 1);

            //Only do this if the part is the head of the snake
            if (part.isHead()) {
                //Check if something to eat
                if (doolhof.foodAtPosition(part.getX(), part.getY())) {
                    part.setHasEaten(true);
                } else {
                    part.setHasEaten(false);
                }
            }
        }

        @Override
        public List<Part> addNewPiece(Part tailPart, List<Part> snake) {;
            Node<Part> newPiece = new Node<Part>(new Part(tailPart.getX(), tailPart.getY() - 1, tailPart.getDirection(), false));
            snake.append(newPiece);
            return snake;

        }
    };

    public abstract void makeMove(List<Part> snake, Doolhof doolhof, Food food, Part part);

    public abstract List<Part> addNewPiece(Part tailPart, List<Part> snake);
}
