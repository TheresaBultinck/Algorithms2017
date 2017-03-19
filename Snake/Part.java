package Snake;

public class Part {
	private int x;
	private int y;
    private Direction direction;
    private boolean isHead;
    private boolean hasEaten = false;
	
	public Part (int x, int y, boolean isHead){
		this.x = x;
		this.y = y;
        this.isHead = isHead;
        hasEaten = false;
	}

    public Part (int x, int y, Direction  direction, boolean isHead){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isHead = isHead;
        hasEaten = false;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(List<Part> snake, Doolhof doolhof, Food food) {
        direction.makeMove(snake,doolhof,food, this);
    }

    public Direction getDirection() {
        return direction;
    }
	
	public int getX(){
		return x; 
	}
	
	public int getY(){
		return y; 
	}
	
	public void setX (int x){
		this.x = x; 
	}
	
	public void setY (int y){
		this.y = y; 
	}

    public boolean isHead() {
        return isHead;
    }

    public boolean hasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }
}

