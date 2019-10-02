package ae23;

public class List {
	private Node head;

	
	public List() {
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	// Metodos Recursivos
	
	public void addLast(int value) {
		
		if(isEmpty()) {
			Node newNode = new Node(value);
			this.head = newNode;
		} else {
			this.head.addLast(value);
		}
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return this.head.size();
		}
	}
	
	public int soma() {
		if(isEmpty()) {
			return 0;
		
		} else {
			return this.head.soma();
		}
	}
	
	public boolean isSorted() {
		if(isEmpty()) {
			return true;
		
		} else {
			return this.head.isSorted();
		}
	}
	
	
	// Metodos Iterativos
	
	public void add(int index, int elemento) {
		Node newNode = new Node(elemento);

		if(index == 0) {
			newNode.setNext(this.head);
			this.head.setPrev(newNode);
			this.head = newNode;
		}
		
		Node aux = this.head;
		int cont = 1;
			
		while(aux.getNext() != null && cont != index) {
				aux = aux.getNext();
				cont++;
		}
		
		if(cont == index) {
			newNode.setNext(aux.getNext());
			if(aux.getNext() != null) {
				aux.getNext().setPrev(newNode);				
			}
			
			newNode.setPrev(aux);
			aux.setNext(newNode);
			
		} else if(cont +1 == index) {
			aux.setNext(newNode);
			newNode.setPrev(aux);
		}
	}
	
	public void remove(int index) {
		if(index >= 0) {
			
			if(!isEmpty()) {
				
				if(index == 0) {
					this.head = this.head.getNext();
					if(!isEmpty()) {
						this.head.setPrev(null);					
					}
					
				} else {
					
					
					Node aux = this.head;
					int cont = 0;
					
					while(aux.getNext() != null && cont != index) {
						aux = aux.getNext();
						cont++;
					}
					
					if(cont == index) {
						if(aux.getNext() == null) {
							aux.getPrev().setNext(null);
							aux.setPrev(null);
							
						} else {
							Node next = aux.getNext();
							Node prev = aux.getPrev();
							
							prev.setNext(next);
							next.setPrev(prev);
						}
					}
					
				}
				
			}
		}
	}
	
}
