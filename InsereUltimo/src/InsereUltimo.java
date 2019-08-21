import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		insereUltimo(numSec);
		System.out.println(Arrays.toString(numSec));
		sc.close();
	}
	
	

	private static void insereUltimo(int[] v) {
		int iUltimo = v.length - 1;
		for (int i = iUltimo -1; i >= 0; i--) {
			if(v[iUltimo] < v[i]) {
				int aux = v[iUltimo];
				v[iUltimo] = v[i];
				v[i] = aux;
				iUltimo--;
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
}
