import java.util.Scanner;

class PilhaComArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		sc.nextLine();
		String[] entrada = sc.nextLine().split(" ");
		Pilha fila = new Pilha(tamanho);
		
		while(!entrada[0].equals("end")) {
			
			switch (entrada[0]) {
			case "push":
				if(!fila.isFull()) {
					int add = Integer.parseInt(entrada[1]);
					fila.push(add);					
				} else {
					System.out.println("full");
				}
				break;
				
			case "pop":
				if(!fila.isEmpty()) {
					fila.pop();					
				} else {
					System.out.println("empty");
				}
				break;
				
			case "peek":
				if(!fila.isEmpty()) {
					System.out.println(fila.peek());
				} else {
					System.out.println("empty");
				}
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

class Pilha {
	
	int[] array;
	int topo;
	int size;
	
	
	public Pilha() {
		this.array = new int[20];
		this.topo = -1;
		this.size = 0;
	}
	
	public Pilha(int tamanho) {
		this.array = new int[tamanho];
		this.topo = -1;
		this.size = 0;
	}
	
	public boolean isFull() {
		return this.size == this.array.length;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void push(int num) {
		if(!isFull()) {
			this.array[this.size++] = num;
		}
	}
	
	public int pop() {
		return this.array[--this.size];
	}
	
	public int peek() {
		return this.array[this.size-1];
	}
	
	public String print() {
		String retorno = "";
		
		int i;
		for (i = 0 ; i<this.size-1; i++) {
			retorno += this.array[i] + " ";
		}
		retorno += this.array[i];
		
		return retorno;
	}
	
}
