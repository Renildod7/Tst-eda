import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		insertionSortRecursivo(numSec, 1);
		sc.close();
		
	}
	private static void insertionSortRecursivo(int[] v, int i) {
			if(i < v.length) {
				
				int key = v[i];
				int j = i - 1;
				while(j >= 0 && key < v[j]) {
					v[j + 1] = v[j];
					v[j] = key;
					j--;
				}
				System.out.println(Arrays.toString(v));
				insertionSortRecursivo(v, i + 1);
			}
	}
	
	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	private static void insertionSort(int[] v, int esquerda, int direita) {
		for(int i = esquerda; i < direita +1; i++) {
			
			int key = v[esquerda];
			int j = i - 1;
			while(j >= esquerda && key < v[j]) {
				v[j + 1] = v[j];
				v[j] = key;
				j--;
			}
			System.out.println(Arrays.toString(v));
		}
	}
}
