import java.util.Scanner;


class BuscaBinariaRecursiva {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int num = sc.nextInt();
		sc.nextLine();
		int[] numSec = toArrayInt(sec);
		System.out.println(buscaBinariaRecursiva(numSec, num, 0, numSec.length-1));
		sc.close();
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	public static int buscaBinariaRecursiva(int[] sec, int num, int esquerda, int direita) {
		int meio = (esquerda + direita) / 2;
		
		if(sec[meio] == num) return meio;
		System.out.println(meio);
		
		if(num > sec[meio] && meio < direita) {
			return buscaBinariaRecursiva(sec, num, meio+1, direita);
		}
		if(num < sec[meio] && meio > esquerda) {
			return buscaBinariaRecursiva(sec, num, esquerda, meio-1);
		}
		return -1;
	}
}
