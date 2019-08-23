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
		boolean retorno = false;
		int i = 0;
		while(i < v.length && retorno == false) {
			int j = i +1;
			while(j < v.length && retorno == false) {
				if(v[i] == v[j]) {
					retorno = true;
				}else {
					j++;
				}
			}
			i++;
		}
		return retorno;
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
}
