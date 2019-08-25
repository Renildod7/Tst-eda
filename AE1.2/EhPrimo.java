import java.util.Scanner;

public class EhPrimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println(ehPrimo(num));
		sc.close();	
	}

	private static boolean ehPrimo(int num) {
		boolean ehPrimo = true;
		
		int i = 2;
		while(i < num && ehPrimo) {
			if(num % i == 0) {
				ehPrimo = false;
			}
			i++;
		}

		return ehPrimo;
	}
}
