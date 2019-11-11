package isheap;

import java.util.Scanner;

public class IsHeap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int[] numSec = toArrayInt(sec);
		System.out.println(isHeap(numSec));
		sc.close();
	}
	
	public static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for(int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}
	
	public static boolean isHeap(int[] array) {
		boolean isHeap = true;
		int i = array.length-1;
		while(i>0 && isHeap) {
			if(array[i] > array[parent(i)]) {
				isHeap = false;
			}
			i--;
		}
		return isHeap;
	}
	
	public static int parent(int i) {
		return (i-1)/2;
	}
}
