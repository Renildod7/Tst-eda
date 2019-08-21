import java.util.Arrays;
import java.util.Scanner;

class MarianaEOsLivros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] estante = sc.nextLine().split(",");
		insertionSort(estante);
		sc.close();
		
	}

	
	private static void insertionSort(String[] v) {
		System.out.println(cocatenaArray(v));
		for(int i = 1; i < v.length; i++) {
			
			int iAtual = i;
			int iAnterior = i - 1;
			while(iAnterior >= 0 && (v[iAtual].compareTo(v[iAnterior]) < 0)) {
				String aux = v[iAtual];
				v[iAtual] = v[iAnterior];
				v[iAnterior] = aux;
				iAtual--;
				iAnterior--;
			}
			System.out.println(cocatenaArray(v));
		}
	}
	
	private static String cocatenaArray(String[] array) {
		return Arrays.toString(array).replace("[", "").replace("]", "");
	}

}
