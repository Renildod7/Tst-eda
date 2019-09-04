import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPassoAPassoQuebrando {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		sc.close();
		mergeSort(numSec);
	}
	
	public static void mergeSort(int[] v) {
		mergeSort(v, 0, v.length - 1);
	}
	
	private static void mergeSort(int[] v, int inicio, int fim) {
		System.out.println(Arrays.toString(v));
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			
			int[] a = new int[meio - inicio +1];
			int[] b = new int[fim - meio];
			
			for(int i = 0; i < a.length; i++) {
				a[i] = v[inicio +i];
			}
			
			for(int j = 0; j < b.length; j++) {
				b[j] = v[meio + 1 + j];
			}
			
			mergeSort(a, 0, a.length-1);
			mergeSort(b, 0, b.length-1);
			merge(v, a, b);
			
		}	
	}
	
	private static void merge(int[] v, int[] a, int[] b) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				v[k] = a[i];
				i++;
			}else {
				v[k] = b[j];
				j++;
			}
			k++;
		}
		
		while(i < a.length) {
			v[k] = a[i];
			i++;
			k++;
		}
		
		while(j < b.length) {
			v[k] = b[j];
			j++;
			k++;
		}
		System.out.println(Arrays.toString(v));
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	


}
