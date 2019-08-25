import java.util.Scanner;

public class Palindromo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split("");
		System.out.println(ehPalindromo(sec));

		sc.close();	
	}

	private static boolean ehPalindromo(String[] v) {
		boolean result = true;
		
		int i = 0;
		while(i < (v.length / 2) && result) {
			if(!v[i].equals(v[v.length - 1 - i])) {
				result = false;
			}
			i++;
		}
		return result;
	}

}
