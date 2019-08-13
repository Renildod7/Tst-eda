import java.util.Scanner;

class PotenciaRecursiva {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		sc.nextLine();
		System.out.println(potenciaRecursiva(i,j));
		sc.close();
	}

	public static int potenciaRecursiva(int i, int j) {
		if(i == 0 && j == 0) return -1;
		if(j == 0) return 1;
		return i * potenciaRecursiva(i, j-1);
	}
}