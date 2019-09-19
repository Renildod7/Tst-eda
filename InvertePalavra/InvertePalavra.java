import java.util.Scanner;

class InvertePalavra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PilhaString pilha = new PilhaString();
		
		
		do {
			
			String entrada = sc.next();
			pilha.push(entrada);
			
		} while(sc.hasNextShort());

		//System.out.println(pilha.print());
		
	}
}

class PilhaString {
	
	String[] array;
	int topo;
	int size;
	
	
	public PilhaString() {
		this.array = new String[20];
		this.topo = -1;
		this.size = 0;
	}
	
	public PilhaString(int tamanho) {
		this.array = new String[tamanho];
		this.topo = -1;
		this.size = 0;
	}
	
	public boolean isFull() {
		return this.size == this.array.length;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void push(String s) {
		if(!isFull()) {
			this.array[this.size++] = s;
		} else {
			aumentaTamanhoPilha();
			this.array[this.size++] = s;
		}
	}
	
	public String pop() {
		return this.array[--this.size];
	}
	
	public String peek() {
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
	
	private void aumentaTamanhoPilha() {
		String[] aux = new String[this.array.length * 2];
		
		for(int i = 0; i< this.array.length; i++) {
			aux[i] = this.array[i];
		}
		
		this.array = aux;
	}
	
}
