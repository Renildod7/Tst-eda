import java.util.Scanner;

class BuscaLinearRecursiva {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int num = sc.nextInt();
		sc.nextLine();
		int[] numSec = toArrayInt(sec);
		System.out.println(buscaLinearRecursiva(numSec, num));
		sc.close();
	}
	
	private static int buscaLinearRecursiva(int[] numSec, int num) {
		return buscaLinearRecursiva(numSec, num, 0);
	}

	private static int buscaLinearRecursiva(int[] sec, int num, int indice) {
		if(indice == sec.length) return -1;
		if(sec[indice] == num) return 0;
		
		int proxIndide = buscaLinearRecursiva(sec, num, indice+1);
		
		if(proxIndide == -1) return -1;
		return 1 + proxIndide;
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}

}
