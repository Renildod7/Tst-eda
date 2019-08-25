import java.util.Arrays;
import java.util.Scanner;

public class TrocaVizinhos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		trocaVizinhos(numSec);
		System.out.println(Arrays.toString(numSec));
		sc.close();	
	}
	
	public static void trocaVizinhos(int[] v) {
		int fim;
		if(v.length % 2 == 0) {
			fim = v.length - 1;
		}else {
			fim = v.length - 2;
		}
		
		for(int i = 0; i < fim; i+=2) {
			int aux = v[i];
			v[i] = v[i+1];
			v[i+1] = aux;
		}
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
}
