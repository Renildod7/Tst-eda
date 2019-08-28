import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		sc.close();
		mergeSort(numSec);
		System.out.println(Arrays.toString(numSec));
	}
	
	public static void mergeSort(int[] v) {
		mergeSort(v, 0, v.length - 1);
	}
	
	private static void mergeSort(int[] v, int inicio, int fim) {
		System.out.println(Arrays.toString(v));
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			
			
			
			
			mergeSort(v, inicio, meio);

			mergeSort(v, meio+1, fim);
			merge(v, inicio, fim, meio);
		}		
		
		
	}
	
	private static void merge(int[] v, int inicio, int fim, int meio) {
		
		int[] copy = new int[v.length];
		
		for(int i = 0; i < v.length; i++) {
			copy[i] = v[i];
		}
		
		
		int i = inicio;
		int j = meio+1;
		int k = inicio;
		
		while(i <= meio && j <= fim) {
			if(copy[i] < copy[j]) {
				v[k] = copy[i];
				i++;
			}else {
				v[k] = copy[j];
				j++;
			}
			k++;
		}
		
		while(i <= meio) {
			v[k] = copy[i];
			i++;
			k++;
		}
		
		while(j <= fim) {
			v[k] = copy[j];
			j++;
			k++;
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
