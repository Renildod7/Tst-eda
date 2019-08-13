/**
 * Cobertura de exoente negativo e exceções.
 */

import java.util.Scanner;

public class PotenciaRecursivaV2 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		sc.nextLine();
		System.out.println(potenciaRecursiva(i,j));
		sc.close();
	}

	public static double potenciaRecursiva(int i, int j) {
		if(i == 0 && j == 0) throw new IllegalArgumentException("Indeterminação: zero elevado a zero");
		if(i == 0 && j < 0) throw new IllegalArgumentException("Indeterminação: zero elevado a expoente negativo");
		if(j == 0) return 1;
		if(j < 0) return 1 / (i * potenciaRecursiva(i, Math.abs(j)-1));
		return i * potenciaRecursiva(i, j-1);
	}
}