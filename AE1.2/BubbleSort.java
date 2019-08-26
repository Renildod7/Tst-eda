import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		bobbleSort(numSec, 2 , numSec.length -3);
		System.out.println(Arrays.toString(numSec));
		sc.close();	
	}
	
	private static void bobbleSort(int[] v) {
		
		for(int i = 0; i < v.length - 1; i++) {
			for(int j = i+1; j < v.length; j++) {
				if(v[i] > v[j]) {
					int aux = v[i];
					v[i] = v[j];
					v[j] = aux;
				}
			}
		}	
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	private static void bobbleSort(int[] v, int esquerda, int direita) {
		
		for(int i = esquerda; i < direita; i++) {
			for(int j = i+1; j < direita +1; j++) {
				if(v[i] > v[j]) {
					int aux = v[i];
					v[i] = v[j];
					v[j] = aux;
				}
			}
		}	
	}
	
}
