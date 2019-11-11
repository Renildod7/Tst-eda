package vmpbst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ValorMaisProximoBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sec = sc.nextLine().split(" ");
		int num = sc.nextInt();
		sc.nextLine();
		int[] numSec = toArrayInt(sec);
		sc.close();

		BST bst = new BST();
		for (int i : numSec)
			bst.add(i);

		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(
				bst.maisProximo(num));
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
	private int size;

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

			this.size++;

		}

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

	public int distancia(int i, int j) {
		return Math.abs(i - j);			
	}

	public int maisProximo(int value) {

		Node aux = this.root;
		int maisProximo = this.root.getValue();
		int menorDistancia = distancia(this.root.getValue(), value);
		

		while (aux != null) {
			int distanciaAux = distancia(aux.getValue(), value);
			if(distanciaAux < menorDistancia) {
				menorDistancia = distanciaAux;
				maisProximo = aux.getValue();
			}
			
			if(aux.getLeft() != null || aux.getRight() != null) {
				
				if(aux.getLeft() != null && aux.getRight() != null) {
					int distanciaLeft = distancia(aux.getLeft().getValue(), value);
					int distanciaRight = distancia(aux.getRight().getValue(), value);
					
					if(distanciaLeft < distanciaRight) {
						if(distanciaLeft < distanciaAux) {
							aux = aux.getLeft();
						} else {
							break;
						}
					} else {
						if(distanciaRight < distanciaAux) {
							aux = aux.getRight();
						} else {
							break;
						}
					}
					
				} else if(aux.getLeft() != null){
					int distanciaLeft = distancia(aux.getLeft().getValue(), value);
					if(distanciaLeft < distanciaAux) {
						aux = aux.getLeft();
					} else {
						break;
					}
				
				} else {
					int distanciaRight = distancia(aux.getRight().getValue(), value);
					if(distanciaRight < distanciaAux) {
						aux = aux.getRight();
					} else {
						break;
					}
				}
				
			} else {
				break;
			}

		}
		
		return maisProximo;
		
		

	}
}

class Node {
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
