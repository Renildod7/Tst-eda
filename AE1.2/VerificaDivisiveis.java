import java.util.Scanner;

public class VerificaDivisiveis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		System.out.println(verificaDivisiveis(numSec));
		sc.close();	
	}
	
	private static boolean verificaDivisiveis(int[] v) {
		boolean achou = false;
		int i = 0;
		while(i< v.length && !achou) {
			int j = 0;
			while(j< v.length && !achou) {
				if(i != j) {
					if(v[i] % v[j] == 0) {
						achou = true;
					}
				}
				j++;
			}
			i++;
		}
		return achou;
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
}
