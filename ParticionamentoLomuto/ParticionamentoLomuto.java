import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoLomuto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		sc.close();
		particionamentoLomuto(numSec);
		System.out.println(Arrays.toString(numSec));
	}
	
	private static void particionamentoLomuto(int[] v) {
		int pivo = v[0];
		int i = 0;
		
		for(int j = 1; j < v.length; j++) {
			if(v[j] < pivo) {
				i++;
				swap(v, i, j);
				System.out.println(Arrays.toString(v));
			}
		}
		swap(v, 0, i);
		System.out.println(Arrays.toString(v));
	}


	public static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	public static void swap(int[] v, int i, int j) {
		if (v == null)
			throw new IllegalArgumentException();

		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}
