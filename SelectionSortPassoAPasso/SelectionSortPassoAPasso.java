import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoAPasso {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		selectionSortPassoAPasso(numSec, 2, numSec.length -3);
		sc.close();
	}
	
	private static void selectionSortPassoAPasso(int[] v ) {
		for(int i = 0; i < v.length - 1; i++) {
			int iMenor = i;
			boolean houveTroca = false;
			for(int j = i+1; j < v.length; j++) {
				if(v[j] < v[iMenor]) {
					iMenor = j;
					houveTroca = true;
					
				}
			}
			if(houveTroca) {
				int aux = v[i];
				v[i] = v[iMenor];
				v[iMenor] = aux;
				
				System.out.println(Arrays.toString(v));				
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
	
	private static void selectionSortPassoAPasso(int[] v , int esquerda, int direita) {
		for(int i = esquerda; i < direita; i++) {
			int iMenor = i;
			boolean houveTroca = false;
			for(int j = i+1; j < direita +1; j++) {
				if(v[j] < v[iMenor]) {
					iMenor = j;
					houveTroca = true;
					
				}
			}
			if(houveTroca) {
				int aux = v[i];
				v[i] = v[iMenor];
				v[iMenor] = aux;
				
				System.out.println(Arrays.toString(v));				
			}
		}
		
	}
}
