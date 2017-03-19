package Snake;

public class List<E> {

	private Node<E> head;
	private int size = 1;
	
	List(E element){
		head = new Node<E>(element);
	}
	
	public int size(){
		return size;
	}
	
	public Node<E> head(){
		return head; 
	}
	
	public void prepend(Node<E> node){
		node.setNext(head);
		head = node;
		size++; 
	}
	
	public void append(Node<E> node) {
		size++;
		Node<E> cursor = head;
		while(cursor.next() != null) {
			cursor = cursor.next();
		}
		cursor.setNext(node);
		System.out.println("New part added");
	}
	
	public Node<E> getTail() {
		Node<E> cursor = head;
		while(cursor.next() != null) {
			cursor = cursor.next();
		}
		return cursor;
	}
		
	//public void prepend(List<E> list){
		//size = size + list.size; 
		//Node<E> cursor = list.head();
		//while(cursor.next() != null){
			//cursor = cursor.next();
		//}
		//cursor.setNext(head); 
		//head = list.head; 
	//}
	public List <E> prepend (List<E> list){
		size = size + list.size;
		last (list.head).setNext(head);
		head = list.head;
		
		return this; 
		
	}
	
	private Node<E> last(Node<E> cursor){
		if(cursor.next() == null)
			return cursor;
		return last(cursor.next());
	}
}
//Linked list omkeren via recursie of via while - lus 
//of omgekeerd 
//examen