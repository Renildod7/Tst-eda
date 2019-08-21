import java.util.Arrays;
import java.util.Scanner;

public class MarianaEOsLivros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] estante = sc.nextLine().split(",");
		insertionSort(estante);
		sc.close();
	}
	
	private static void insertionSort(String[] v) {
		for(int i = 1; i < v.length; i++) {
			int iUltimo = i;
			for (int j = iUltimo -1; j >= 0; j--) {
				if((v[j].compareTo(v[iUltimo]) == -1)) {
					String aux = v[iUltimo];
					v[iUltimo] = v[j];
					v[j] = aux;
					iUltimo--;
				}
			}
			System.out.println(Arrays.toString(v));
		}
	}

}
