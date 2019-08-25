import java.util.Scanner;

class VetorCircular {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int qtdVezes = sc.nextInt();
		sc.nextLine();
		int[] numSec = toArrayInt(sec);
		System.out.println(vetorCircular(numSec, qtdVezes));

		sc.close();	
	}
	
	private static String vetorCircular(int[] v, int qtdVezes) {
		String retorno = "";
		for(int i = 0; i < qtdVezes; i++) {
			if(i >= v.length) {
				retorno+= v[i % v.length] + " ";
			}else {
				retorno+= v[i] + " ";
			}
		}
		return retorno.substring(0, retorno.length()-1);
	}

	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
}
