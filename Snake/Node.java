package Snake;

public class Node<E>  { //wordt generics genoemd
	private E element;  
	private Node<E> next; //verwijzingen in de lijst
	
	public Node(E element){
		this.element = element; 
		next = null; 
	}
	
	public E get(){
		return element;
	}
	
	public Node<E> next(){
		return next; 
	}
	
	public void setNext(Node <E> node){
			next = node;
	}
	
	public int hashCode(){
		return 41 * (41*element.hashCode()) + next.hashCode();
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Node<?>){
			Node<?> that =(Node<?>) obj; 
			return (this.element == that.element)&& (this.next == that.next);
		}
		return false; 
	}
	
	public String toString(){
		return "("+ element +")";
	}
}
