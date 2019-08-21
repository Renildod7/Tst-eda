import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		selectionSortRecursivo(numSec);
		sc.close();
	}
	
	private static void selectionSortRecursivo(int[] v) {
		selectionSortRecursivo(v, 0);
	}
	
	private static void selectionSortRecursivo(int[] v, int i) {
		int iMenor = i;
		boolean houveTroca = false;
		for(int j = i+1; j < v.length; j++) {
			if(v[j] < v[iMenor]) {
				iMenor = j;
				
			}
		}
		
		int aux = v[i];
		v[i] = v[iMenor];
		v[iMenor] = aux;
		System.out.println(Arrays.toString(v));				
		
		if(i < v.length - 2) {
			selectionSortRecursivo(v, i+1);
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
