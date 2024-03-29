import java.util.Scanner;

class VerificaçãoDeElementosDuplicados {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		System.out.println(duplicados(numSec));
		sc.close();
		
	}
	
	public static boolean duplicados(int[] v) {
		boolean duplicado = false;
		int i = 0;
		while(i < v.length && !duplicado) {
			int j = i +1;
			while(j < v.length && !duplicado) {
				if(v[i] == v[j]) {
					duplicado = true;
				}else {
					j++;
				}
			}
			i++;
		}
		return duplicado;
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
}
