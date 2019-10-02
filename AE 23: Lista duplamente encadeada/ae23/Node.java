package ae23;

public class Node {
	private Node next;
	private Node prev;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
	public void setNext(Node newNext) {
		this.next = newNext;
	}
	
	public void setPrev(Node newPrev) {
		this.prev = newPrev;
	}

	public void addLast(int value) {
		if(this.next == null) {
			Node newNode = new Node(value);
			
			this.next = newNode;
			newNode.setPrev(this);
		
		} else {
			this.next.addLast(value);
		}
	}

	public int size() {
		if(this.next == null) {
			return 1;
		
		} else {
			return 1 +this.next.size();
		}
	}

	public int soma() {
		if(this.next == null) {
			return this.value;
		
		} else {
			return value + this.next.soma();
		}
	}

	public boolean isSorted() {
		if(this.next == null) {
			return true;
		
		} else {
			if(this.value < this.next.getValue()) {
				return this.next.isSorted();
				
			} else {
				return false;
			}
		}
	}

	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}

}
