import java.util.Scanner;

public class FilaComArray {
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
	
	int[] array;
	int head;
	int tail;
	int size;
	
	public Fila() {
		this.array = new int[20];
		this.head = -1;
		this.tail = -1;
	}
	
	public Fila(int tamanho) {
		this.array = new int[tamanho];
		this.head = -1;
		this.tail = -1;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean isFull() {
		return this.size == this.array.length;
	}
	
	public void add(int i) {
		if(!isFull()) {
			
			if(isEmpty()) {
				this.array[(tail+1) % array.length] = i;
				this.head++;
				this.tail++;
			} else {
				this.array[(tail+1) % array.length] = i;
				this.tail++;
			}
			this.size++;
		}
	}
	
	
}
