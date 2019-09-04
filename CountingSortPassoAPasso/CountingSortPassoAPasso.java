
import java.util.Scanner;

class CountingSortPassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int k = sc.nextInt();
		sc.nextLine();
		int[] numSec = toArrayInt(sec);
		sc.close();
		countingSort(numSec, k);
	}



	private static void countingSort(int[] v, int k) {
		int[] a = new int[k + 1];
		int[] b = new int[v.length];
		
		for(int i : v) {
			a[i]++;
			System.out.println(print(a));
		}
		
		for(int i = 1; i < a.length; i++) { 
			a[i]+= a[i-1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + print(a));
		
		
		for(int i = v.length-1; i >= 0; i--) {
			b[a[v[i]]-1] = v[i];
			a[v[i]]--;
		}
		System.out.println(print(a));
		
		for(int i = 0; i < v.length; i++) {
			v[i] = b[i];
		}
		System.out.println(print(v));
		
	}
	
	
	
	private static String print(int[] v) {
		String retorno = "";
		
		for(int i = 0; i < v.length; i++) {
			if(i == v.length-1) {
				retorno += v[i];
			}else {
				retorno+= v[i] + " ";
			}
		}
		return retorno;
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