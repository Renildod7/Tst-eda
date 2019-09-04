import java.util.Scanner;

class CalculoDeEstatisticaDeOrdem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		sc.close();
		calculaEstatistica(numSec);
	}


	private static void calculaEstatistica(int[] v) {
		int pivo = v[0];
		int iAtual = 1;
		int iFinal = v.length-1;
		
		while(iAtual <= iFinal) {
			if(v[iAtual] < pivo) {
				iAtual++;
			} else if(v[iFinal] >= pivo) {
				iFinal--;
			} else {
				swap(v, iAtual, iFinal);
				iAtual++;
				iFinal--;
			}
		}
		swap(v, 0, iFinal);
		
		System.out.println(iFinal+1);
		
	}


	public static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	public static void swap(int[] v, int i, int j) {
		if (v == null)
			throw new IllegalArgumentException();

		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}
