import java.util.Arrays;
import java.util.Scanner;

class QuickSortPassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		sc.close();
		quickSort(numSec);
	}
	
	public static void quickSort(int[] v) {
		quickSort(v, 0, v.length-1);
	}
	
	

	private static void quickSort(int[] v, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(v, inicio, fim);
			quickSort(v, inicio, posicaoPivo - 1);
			quickSort(v, posicaoPivo + 1, fim);
       }
 }
	
	private static int separar(int[] v , int inicio, int fim) {
		int pivo = v[inicio];
		int a = inicio+1;
		
		for(int i = inicio +1; i<=fim; i++) {
			if(v[i] < pivo) {
				swap(v, a, i);
				a++;
			}
		}
		swap(v, inicio, a-1);
		
		String saida = "";
		for(int i = 0; i<v.length; i++) {
			if(i == v.length-1) {
				saida+= v[i];
			}else {
				saida+= v[i]+" ";
			}
		}
		System.out.println(saida);
		return a-1;
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	public static void swap(int[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
