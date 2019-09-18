package linkedlist;

import java.util.Scanner;

class FilaLinkedList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		Fila fila = new Fila();
		
		while(!entrada[0].equals("end")) {
			
			switch (entrada[0]) {
			case "add":
				if(!fila.isFull()) {
					int add = Integer.parseInt(entrada[1]);
					fila.add(add);					
				} else {
					System.out.println("full");
				}
				break;
				
			case "remove":
				if(!fila.isEmpty()) {
					fila.remove();					
				} else {
					System.out.println("empty");
				}
				break;
				
			case "element":
				if(!fila.isEmpty()) {
					System.out.println(fila.element());
				} else {
					System.out.println("empty");
				}
				break;
				
			case "search":
				int search = Integer.parseInt(entrada[1]);
				System.out.println(fila.search(search));
				break;
				
			case "print":
				if(!fila.isEmpty()) {
					System.out.println(fila.print());					
				} else {
					System.out.println("empty");
				}
				break;
				
			default:
				break;
			}
			
			entrada = sc.nextLine().split(" ");
		}
		sc.close();
	}
}


class Fila {
	
	Node head;
	Node tail;
	int size;
	int limite;
	
	public Fila() {
		this.limite = 20;
	}
	
	public Fila(int limite) {
		this.limite = limite;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean isFull() {
		return this.size == this.limite;
	}
	
	public String print() {
		String retorno = "";
		
		if(!isEmpty()) {

			Node aux = this.head;
			while(aux.next != null) {
				retorno += aux.value + " ";
				aux = aux.next;
			}
			retorno += aux.value;
		}
		return retorno;
	}
	
	public void add(int i) {
		if(!isFull()) {
			
			Node newNode = new Node(i);
			
			if(isEmpty()) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.prev = this.tail;
				this.tail = newNode;
			}
			this.size++;
			
		}
	}
	
	public void remove() {
		if(!isEmpty()) {
			this.head = this.head.next;
			this.size--;			
		}
	}
	
	public int element() {
		return this.head.value;
	}
	
	public int search(int i) {
		int retorno = -1;
		int cont = 0;
		
		Node aux = this.head;
		while(aux != null && retorno == -1) {
			if(aux.value == i) {
				retorno = cont;
			}
			aux = aux.next;
			cont++;
		}
		
		return retorno;
	}
	
}

class Node {
	
	int value;
	Node prev;
	Node next;
	
	public Node(int i) {
		this.value = i;
	}
	
}