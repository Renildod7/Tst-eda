package htprobinglinear;

import java.util.Arrays;
import java.util.Scanner;

class HTProbingLinear {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		sc.nextLine();
		
		TabelaHash  tabela = new TabelaHash(tamanho);
		
		String[] entrada = sc.nextLine().split(" ");
		
		while(!entrada[0].equals("end")) {
			
			switch (entrada[0]) {
			case "put":
				System.out.println(tabela.put((Integer.parseInt(entrada[1])), entrada[2]));
				break;
			
			case "remove":
				System.out.println(tabela.remove(Integer.parseInt(entrada[1])));
				break;
			
			case "keys":
				System.out.println(Arrays.toString(tabela.keys()));
				break;
			
			case "values":
				System.out.println(Arrays.toString(tabela.values()));
				break;
	

			default:
				break;
			}
			
			entrada = sc.nextLine().split(" ");
		}
		sc.close();
	}
	

}

class TabelaHash {
	private Pair[] tabela;
	private int qtdElementos;
	
	public TabelaHash(int tamanho) {
		this.tabela = new Pair[tamanho];
		this.qtdElementos = 0;
	}
	
	public boolean isEmpty() {
		return this.qtdElementos == 0;
	}
	
	public boolean isFull() {
		return this.qtdElementos == this.tabela.length;
	}
	
	private int hash(int key) {
		return key % this.tabela.length;
	}
	
	public String put(int key, String value) {
		if(!isFull()) {
			
			int acrecimo = 0;			
			int index;
			boolean adicionou = false;
			
			while(acrecimo < this.tabela.length && !adicionou) {
				index = hash(key + acrecimo++);
				
				if(this.tabela[index] == null || this.tabela[index].isDeleted()) {
					this.tabela[index] = new Pair(key, value);
					this.qtdElementos++;
					adicionou = true;
				
				} else if(this.tabela[index].getKey() == key) {
					this.tabela[index].setValue(value);
					adicionou = true;
				}
			}
		}
		
		return toString();
	}
	
	public String remove(int key) {
		if(!isEmpty()) {
			
			int acrecimo = 0;			
			int index;
			boolean removeu = false;
			
			while(acrecimo < this.tabela.length && !removeu) {
				index = hash(key + acrecimo++);
				
				if(this.tabela[index] != null) {
					if(this.tabela[index].getKey() == key) {
						this.tabela[index].delete();
						this.qtdElementos--;
						removeu = true;
					}
				
				}
			}
		}
		
		return toString();
	}
	
	
	public int[] keys() {
		int[] keys = new int[qtdElementos];
		int j = 0;
		
		for(int i = 0; i < tabela.length ; i++) {
			if(this.tabela[i] != null && !this.tabela[i].isDeleted()) {
				keys[j++] = this.tabela[i].getKey();				
			}
		}
		
		Arrays.sort(keys);
		return keys;
	}
	
	public String[] values() {
		String[] values = new String[this.qtdElementos];
		int j = 0;
		
		for(int i = 0; i < this.tabela.length; i++) {
			if(this.tabela[i] != null && !this.tabela[i].isDeleted()) {
				values[j++] = this.tabela[i].getValue();
			}
		}
		
		Arrays.sort(values);
		return values;
	}
	
	public String toString() {
		return Arrays.toString(this.tabela);
	}
	
}




class Pair {
	private int key;
	private String value;
	private boolean deletado;
	
	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
		this.deletado = false;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public String getValue() {
		if(isDeleted()) {
			return null;
		}
		return this.value;
	}
	
	public void setValue(String newValue) {
		this.value = newValue;
	}
	
	public String toString() {
		String retorno = null;
		
		if(!deletado) {
			retorno = String.format("<%s, %s>", this.key, this.value);
		}
		return retorno;
	}
	
	public void delete() {
		this.deletado = true;
	}
	
	public boolean isDeleted() {
		return this.deletado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (key != other.key)
			return false;
		return true;
	}
}
