import java.util.Scanner;

class SomaDois {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int target = sc.nextInt();
		sc.hasNextLine();
		int[] numSec = toArrayInt(sec);
		int[] resultado = twoSum(numSec, target);
		if(resultado[0] == 0 && resultado[1] == 0) {
			System.out.println(-1);
		}else {
			System.out.printf("%d %d%s", resultado[0], resultado[1], System.lineSeparator());
		}
		sc.close();	
	}
	
	public static int[] twoSum(int[] v, int target) {
		int[] retorno = new int[2];
		boolean achou = false;
		int i = 0;

		while(i < v.length-1 && !achou) {
			int j = i+1;
			while(j < v.length && !achou) {
				if(v[i] + v[j] == target) {
					retorno[0] = v[i];
					retorno[1] = v[j];
					achou = true;
				}else {
					j++;
				}
			}
			i++;

		}
		return retorno;
	}
	
	private static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
}
