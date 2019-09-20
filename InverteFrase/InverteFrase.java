
import java.util.Scanner;
import java.util.Stack;

class InverteFrase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> pilha = new Stack<>();
		String entrada = sc.nextLine();

		sc.close();
		
		

		String aux = "";
		
		for(char c : entrada.toCharArray()) {
			if(c == ' ') {
				pilha.push(aux);
				aux = "";

			} else {
				aux += c;
			}
		}
		pilha.push(aux);
		
		
		
		String entradaInvertida = "";
		
		while(pilha.size() > 1) {
			entradaInvertida += pilha.pop() + " ";
		}
		entradaInvertida += pilha.pop();
		
		System.out.println(entradaInvertida);
		
	}
}

