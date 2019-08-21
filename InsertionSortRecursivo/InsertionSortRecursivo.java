import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		insertionSort(numSec);
		sc.close();
		
	}

	
	private static void insertionSort(int[] v) {
		for(int i = 1; i < v.length; i++) {
			
			int iAtual = i;
			int iAnterior = i - 1;
			while(iAnterior >= 0 && v[iAtual] < v[iAnterior]) {
				int aux = v[iAtual];
				v[iAtual] = v[iAnterior];
				v[iAnterior] = aux;
				iAtual--;
				iAnterior--;
			}
			System.out.println(Arrays.toString(v));
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
