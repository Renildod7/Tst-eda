package bsf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import sun.misc.Queue;

public class BSF {
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String numeros = sc.nextLine();
		sc.close();
		
		BST bst = new BST();
		
		for(String s: numeros.split(" ")) bst.add(Integer.parseInt(s));

		bst.bfs();
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
	
	public void bfs() throws InterruptedException {
		if(isEmpty()) return;
		ArrayList<Integer> list = new ArrayList<>();
		Node aux = this.root;
		boolean root = true;
		Queue<Node> fila = new Queue<>();
		fila.enqueue(aux);
		
		while(!fila.isEmpty()) {
			aux = fila.dequeue();

			list.add(aux.getValue());
			
			if(aux.getLeft() != null)fila.enqueue(aux.getLeft());
			if(aux.getRigth() != null)fila.enqueue(aux.getRigth());

		}
		String s = "";

		for(int i = 0; i < list.size()-1; i++) {
			s += list.get(i) + " ";
		}
		s += list.get(list.size()-1);
		
		System.out.println(s);
		
	}
	
	public void max() {
		if(isEmpty()) return;
		
		ArrayList<Integer> list = new ArrayList<>();
		Node aux = this.root;
		
		while(aux != null) {
			list.add(aux.getValue());
			aux = aux.getRigth();
		}
		
		String s = "";

		for(int i = 0; i < list.size()-1; i++) {
			s += list.get(i) + " ";
		}
		s += list.get(list.size()-1);
		
		System.out.println(s);
	}
	
	public int altura() {
		return altura(this.root);
	}
	
	private int altura(Node node) {
		if(node == null) return -1;
		return 1 + Math.max(altura(node.getLeft()), altura(node.getRigth()));
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
	
	public void a() {
		System.out.println(value);
		if(this.left != null) this.left.a();

		
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
	
	public boolean ehFolha() {
		return (this.left == null &&
				this.rigth == null);
	}
}
