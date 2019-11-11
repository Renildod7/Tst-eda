package elementosmenoresbst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ElementosMenoresBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int num = sc.nextInt();
		sc.nextLine();
		int[] numSec = toArrayInt(sec);
		sc.close();

		BST bst = new BST();
		for (int i : numSec) bst.add(i);
		
		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(bst.qtdMenores(num));

	}

	public static int[] toArrayInt(String[] sec) {
		int[] numSec = new int[sec.length];
		for (int i = 0; i < sec.length; i++) {
			numSec[i] = Integer.parseInt(sec[i]);
		}
		return numSec;
	}

}

class BST {

	private Node root;

	public void add(int value) {
		if (isEmpty()) {
			this.root = new Node(value);
		} else {

			Node aux = this.root;
			boolean adicionou = false;

			while (aux != null && !adicionou) {
				if (value < aux.getValue()) {
					if (aux.getLeft() == null) {
						aux.setLeft(new Node(value));
						adicionou = true;
					} else {
						aux = aux.getLeft();
					}

				} else {
					if (aux.getRight() == null) {
						aux.setRigth(new Node(value));
						adicionou = true;
					} else {
						aux = aux.getRight();
					}
				}
			}

		}

	}

	public int qtdMenores(int value) {
		ArrayList<Integer> list = new ArrayList<>();
		
		qtdMenores(this.root, list, value);
		
		return list.size();
	}

	private void qtdMenores(Node node, ArrayList<Integer> list, int value) {
		if(node.getValue() < value) {
			list.add(node.getValue());			
		}
		if (node.getLeft() != null)
			qtdMenores(node.getLeft(), list, value);
		if (node.getRight() != null)
			qtdMenores(node.getRight(), list, value);
		
	}

	public void buscar(int value) {
		if (isEmpty())
			return;

		ArrayList<Integer> retorno = new ArrayList<>();

		Node aux = this.root;
		boolean encontrou = false;

		while (aux != null && !encontrou) {
			if (aux.getValue() == value) {
				retorno.add(aux.getValue());
				encontrou = true;

			} else {
				retorno.add(aux.getValue());
				if (value < aux.getValue()) {
					aux = aux.getLeft();
				} else {
					aux = aux.getRight();
				}
			}

		}

		System.out.println(Arrays.toString(retorno.toArray()));

	}
	
	public Object[] preOrder() {
		ArrayList<Integer> list = new ArrayList<>();
		preOrder(list, this.root);

		return list.toArray();

	}

	private void preOrder(ArrayList<Integer> list, Node node) {
		if (node != null) {

			list.add(node.getValue());
			if (node.getLeft() != null)
				preOrder(list, node.getLeft());
			if (node.getRight() != null)
				preOrder(list, node.getRight());
		}

	}

	public int altura() {
		return altura(this.root);
	}

	private int altura(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(altura(node.getLeft()), altura(node.getRight()));
	}

	public boolean isEmpty() {
		return this.root == null;
	}

}

class Node {
	private Node left;
	private Node rigth;
	private int value;

	public Node(int value) {
		this.value = value;
	}

	public void a() {
		System.out.println(value);
		if (this.left != null)
			this.left.a();

	}

	public int getValue() {
		return this.value;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.rigth;
	}

	public void setLeft(Node node) {
		this.left = node;
	}

	public void setRigth(Node node) {
		this.rigth = node;
	}

	public boolean ehFolha() {
		return (this.left == null && this.rigth == null);
	}
}
