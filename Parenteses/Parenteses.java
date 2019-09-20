import java.util.Scanner;

class Parenteses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		sc.close();
		
		System.out.println(ehValido(entrada));
		
		
	}
	
	public static String ehValido(String s) {
		
		char[] array = s.toCharArray();
		
		if(array.length % 2 == 0) {
			for(int i = 0; i < array.length/2; i++) {
				if(array[i] != '(' || array[array.length-1-i] != ')') {
					return "N";
				}
			}
			return "S";
		} else {
			return "N";
		}
			
	} 
}
