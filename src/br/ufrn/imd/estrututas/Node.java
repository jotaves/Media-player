package br.imd.Arvore;

/**
 * Classe que implementa um nó de uma árvore.
 * 
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 *
 * @param <T>
 *            Uma tipo qualquer q queira ser armazenado no nó.
 */
public class Node<T> {
	private Node<T> l;
	private Node<T> r;
	private T obj;

	/**
	 * Construtor vazio da classe Node
	 */
	public Node() {
		this.l = null;
		this.r = null;
		this.obj = null;
	}

	/**
	 * Construtor da classe Node
	 * 
	 * @param obj
	 *            O objeto do tipo T a ser armazenado.
	 */
	public Node(T obj) {
		this.l = null;
		this.r = null;
		this.obj = obj;
	}

	/**
	 * Retorna o conteúdo do nó
	 * 
	 * @return Conteúdo do nó
	 */
	public T getConteudo() {
		return this.obj;
	}

	/**
	 * Altera o conteúdo do nó
	 * 
	 * @param obj
	 *            Conteúdo que será colocado
	 */
	public void setConteudo(T obj) {
		this.obj = obj;
	}

	/**
	 * Retorna o filho do lado esquerdo do nó
	 * 
	 * @return Filho do lado esquerdo do nó
	 */
	public Node<T> getLeft() {
		return this.l;
	}

	/**
	 * Retorna o filho do lado direito do nó
	 * 
	 * @return Filho do lado direito do nó
	 */
	public Node<T> getRight() {
		return this.r;
	}

	/**
	 * Altera o filho do lado esquerdo do nó
	 * 
	 * @param newNode
	 *            Filho que será colocado do lado esquero do nó
	 */
	public void setLeft(Node<T> newNode) {
		this.l = newNode;
	}

	/**
	 * Altera o filho do lado direito do nó
	 * 
	 * @param newNode
	 *            Filho que será colocado do lado direito do nó
	 */
	public void setRight(Node<T> newNode) {
		this.r = newNode;
	}
};
