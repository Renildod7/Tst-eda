package buscabst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BuscaBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numeros = sc.nextLine();
		int buscado = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		BST bst = new BST();
		
		for(String s: numeros.split(" ")) bst.add(Integer.parseInt(s));
		bst.buscar(buscado);
		
	}

}

class BST{
	
	private Node root;
	
	public void add(int value) {
		if(isEmpty()) {
			this.root = new Node(value);
		} else {
			
			Node aux = this.root;
			boolean adicionou = false;
			
			while(aux != null && !adicionou) {
				if(value < aux.getValue()) {
					if(aux.getLeft() == null) {
						aux.setLeft(new Node(value));
						adicionou = true;
					} else {
						aux = aux.getLeft();
					}
				
				} else {
					if(aux.getRigth() == null) {
						aux.setRigth(new Node(value));
						adicionou = true;
					} else {
						aux = aux.getRigth();
					}
				}
			}

		}

	}
	
	public void buscar(int value) {
		if(isEmpty()) return;
		
		ArrayList<Integer> retorno = new ArrayList<>();
		
		Node aux = this.root;
		boolean encontrou = false;
		
		while(aux != null && !encontrou) {
			if(aux.getValue() == value) {
				retorno.add(aux.getValue());
				encontrou = true;
			
			} else {
				retorno.add(aux.getValue());
				if(value < aux.getValue()) {
					aux = aux.getLeft();
				} else {
					aux = aux.getRigth();
				}
			}
			
		}
		
		System.out.println(Arrays.toString(retorno.toArray()));
		
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
}

class Node{
	private Node left;
	private Node rigth;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRigth() {
		return this.rigth;
	}
	
	public void setLeft(Node node) {
		this.left = node;
	}
	
	public void setRigth(Node node) {
		this.rigth = node;
	}
}
