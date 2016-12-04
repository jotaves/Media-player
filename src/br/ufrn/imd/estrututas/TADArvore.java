package br.imd.Arvore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe que implementa a TAD Tree
 * 
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 *
 * @param <T>
 *            objeto quealquer a ser armazenado dentro dos nós que formam a
 *            árvore.
 */
public class TADArvore<T extends Comparable<T>> {
	private NodeArvore<T> raiz;

	/**
	 * Construtor da TAD Árvore
	 */
	public TADArvore() {
		this.raiz = null;
	}

	/**
	 * Wrapper para função de inserção de um nó na Árvore
	 * 
	 * @param t
	 *            Nó que será inserido
	 */
	public void inserir(T t) {
		NodeArvore<T> n = new NodeArvore<T>(t);

		if (raiz == null) {
			this.raiz = n;
		} else {
			this.inserir(raiz, n);
		}
	}

	/**
	 * Inserção de um nó na Árvore
	 * 
	 * @param pai
	 *            Candidato a pai do nó que será inserido
	 * @param n
	 *            Nó a ser inserido
	 */
	private void inserir(NodeArvore<T> pai, NodeArvore<T> n) {
		// modificado
		int compR = n.getConteudo().compareTo(pai.getConteudo());

		if (compR < 0 && pai.getLeft() == null) {
			pai.setLeft(n);
		} else if (compR < 0 && pai.getLeft() != null) {
			inserir(pai.getLeft(), n);
		} else if (compR > 0 && pai.getRight() == null) {
			pai.setRight(n);
		} else if (compR > 0 && pai.getRight() != null) {
			inserir(pai.getRight(), n);
		}
	}

	/**
	 * 
	 * @param obj
	 *            O objeto que se procura dentro da árvore.
	 * @return Nó do objeto que foi buscado ou null, caso não haja objeto
	 */
	public NodeArvore<T> buscarLargura(T obj) {
		if (obj == null || this.raiz == null) {
			return null;
		}

		Queue<NodeArvore<T>> fila = new LinkedList<NodeArvore<T>>();
		fila.add(this.raiz);

		while (!fila.isEmpty()) {
			if (obj.compareTo(fila.element().getConteudo()) == 0) {
				return fila.element();
			}
			if (fila.element().getLeft() != null) {
				fila.add(fila.element().getLeft());
			}
			if (fila.element().getRight() != null) {
				fila.add(fila.element().getRight());
			}
			fila.remove();
		}
		return null;
	}

	/**
	 * Busca na árvore
	 * 
	 * @param obj
	 *            Objeto a ser buscado
	 * @return Nó do objeto que foi buscado ou null, caso não haja objeto
	 */
	public NodeArvore<T> buscarArvore(T obj) {
		return this.buscarArvore(raiz, obj);
	}

	private NodeArvore<T> buscarArvore(NodeArvore<T> n, T obj) {
		if (n == null || raiz == null)
			return null;

		int compR = n.getConteudo().compareTo(obj);

		if (compR == 0)
			return n;
		else if (compR > 0)
			return buscarArvore(n.getLeft(), obj);
		else if (compR < 0)
			return buscarArvore(n.getRight(), obj);
		else
			return null;
	}

	/**
	 * Wrapper para função de busca em profundidade de um objeto na árvore
	 * 
	 * @param obj
	 *            Objeto a ser buscado
	 * @return Nó do objeto que foi buscado ou null, caso não haja objeto
	 */
	public NodeArvore<T> buscarProfundidade(T obj) {
		if (obj == null || raiz == null) {
			return null;
		}
		if (raiz.getConteudo().compareTo(obj) == 0) {
			return raiz;
		} else {
			NodeArvore<T> resultado = buscarProfundidade(raiz.getLeft(), obj);
			if (resultado == null) {
				resultado = buscarProfundidade(raiz.getRight(), obj);
			}
			return resultado;
		}
	}

	/**
	 * Busca em profundidade de um objeto na árvore
	 * 
	 * @param n
	 *            Nó a ser buscado
	 * @param obj
	 *            Objeto a ser buscado
	 * @return Nó do objeto que foi buscado ou null, caso não haja objeto
	 */
	private NodeArvore<T> buscarProfundidade(NodeArvore<T> n, T obj) {
		if (n == null)
			return null;
		if (n.getConteudo().compareTo(obj) == 0) {
			return n;
		} else {
			NodeArvore<T> resultado = buscarProfundidade(n.getLeft(), obj);
			if (resultado == null)
				resultado = buscarProfundidade(n.getRight(), obj);
			return resultado;
		}
	}

	/**
	 * Remoção de um objeto da árvore
	 * 
	 * @param obj
	 *            Objeto a ser removido
	 * @return True, se o objeto foi removido; false, se não
	 */
	public boolean remover(T obj) {
		if (obj == null || raiz == null || buscarArvore(obj) == null) {
			return false;
		}
		NodeArvore<T> pai = raiz;
		NodeArvore<T> rm = raiz;

		int compR = obj.compareTo(pai.getConteudo());

		while ((pai.getLeft() != null || pai.getRight() != null) && compR != 0) {
			pai = rm;
			if (compR < 0) {
				rm = rm.getLeft();
			} else
				rm = rm.getRight();
			compR = obj.compareTo(rm.getConteudo());
		}

		// elemento a ser removido não está na árvore
		if (obj.compareTo(rm.getConteudo()) != 0)
			return false;

		else if (rm.getLeft() == null && rm.getRight() == null) {
			compR = pai.getConteudo().compareTo(rm.getConteudo());
			if (compR == 0) {
				raiz = null;
			}
			if (compR < 0) {
				pai.setRight(null);
			} else {
				pai.setLeft(null);
			}
			return true;
		}

		else if ((rm.getLeft() == null && rm.getRight() != null)) {
			compR = pai.getConteudo().compareTo(rm.getConteudo());
			if (compR == 0) {
				raiz = pai.getRight();
			}
			if (compR < 0) {
				pai.setRight(rm.getRight());
			} else {
				pai.setLeft(rm.getRight());
			}
			return true;
		}

		else if (rm.getLeft() != null && rm.getRight() == null) {
			compR = pai.getConteudo().compareTo(rm.getConteudo());
			if (compR == 0) {
				raiz = pai.getLeft();
			}
			if (compR < 0) {
				pai.setRight(rm.getLeft());
			} else {
				pai.setLeft(rm.getLeft());
			}
			return true;
		} else {
			T subs = this.getMenor(rm.getRight()).getConteudo();
			this.remover(subs);
			rm.setConteudo(subs);
			return true;
		}

	}

	/**
	 * Wrapper para a função que retorna a profundidade de um nó na árvore
	 * 
	 * @param n
	 *            Nó a ser buscada a profundidade
	 * @return Profundidade do nó
	 */
	public int getProfundidade(NodeArvore<T> n) {
		if (n == null || raiz == null || buscarArvore(n.getConteudo()) == null) {
			return -1;
		}

		int compR = n.getConteudo().compareTo(raiz.getConteudo());

		if (compR == 0) {
			return 0;
		}

		else if (compR < 0) {
			return 1 + this.getProfundidade(n, raiz.getLeft());
		} else {
			return 1 + this.getProfundidade(n, raiz.getRight());
		}
	}

	/**
	 * Retorna a profundidade de um nó na árvore
	 * 
	 * @param n
	 *            Nó a ser buscada a profundidade
	 * @param pai
	 *            Um nó qualquer anterior ao nó n (para busca da profundidade)
	 * @return Profundidade do nó
	 */
	private int getProfundidade(NodeArvore<T> n, NodeArvore<T> pai) {
		int compR = n.getConteudo().compareTo(pai.getConteudo());

		if (compR == 0) {
			return 0;
		} else if (compR < 0) {
			return 1 + this.getProfundidade(n, pai.getLeft());
		} else {
			return 1 + this.getProfundidade(n, pai.getRight());
		}
	}

	/**
	 * Retorna a altura de um nó
	 * 
	 * @param n
	 *            Nó que será buscada a altura
	 * @return Altura do nó
	 */
	public int getAltura(NodeArvore<T> n) {
		if (n == null || raiz == null) {
			return -1;
		} else {
			n = this.buscarArvore(n.getConteudo());
			// altura da sub-árvore esquerda
			int ae = 1 + getAltura(n.getLeft());
			// altura da sub-árvore direita
			int ad = 1 + getAltura(n.getRight());

			// retorna a maior altura entre as sub-árvores
			if (ae < ad) {
				return ad;
			} else {
				return ae;
			}
		}
	}

	/**
	 * Retorna o nó com menor valor da árvore
	 * 
	 * @return Nó com menor valor da árvore ou null, se a árvore não tiver
	 *         elementos
	 */
	public NodeArvore<T> getMenor() {
		if (raiz == null)
			return null;

		NodeArvore<T> n = this.raiz;

		while (n.getLeft() != null) {
			n = n.getLeft();
		}

		return n;
	}

	/**
	 * Retorna o nó com menor valor depois de um determinado nó
	 * 
	 * @param raiz
	 *            Nó que fará papel de "raiz"
	 * @return Nó com menor valor depois do nó "raiz"
	 */
	private NodeArvore<T> getMenor(NodeArvore<T> raiz) {
		if (raiz == null)
			return null;

		NodeArvore<T> n = raiz;

		while (n.getLeft() != null) {
			n = n.getLeft();
		}

		return n;
	}

	/**
	 * Retorna o nó com maior valor da árvore
	 * 
	 * @return Nó com maior valor da árvore ou null, se a árvore não tiver
	 *         elementos
	 */
	public NodeArvore<T> getMaior() {
		if (raiz == null)
			return null;

		NodeArvore<T> n = raiz;

		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n;
	}

	/**
	 * Imprime um nó da árvore na notação pré-fixa
	 * 
	 * @param n
	 *            Nó a ser impresso
	 */
	private void imprimirPre(NodeArvore<T> n) {
		if (n != null) {
			System.out.print("\t" + n.getConteudo());
			imprimirPre(n.getLeft());
			imprimirPre(n.getRight());
		}
	}

	/**
	 * Wrapper para a função que imprime a árvore em notação pré-fixa
	 */
	public void imprimirPre() {
		// System.out.print("Arvore em pré-fixo: [\n");
		System.out.print("[\n");
		if (raiz != null)
			imprimirPre(raiz);
		System.out.println("]");
	}

	/**
	 * Wrapper para a função que imprime a árvore em notação pós-fixa
	 */
	public void imprimirPos() {
		// System.out.print("Arvore em pós-fixo: [\n");
		System.out.print("[\n");
		if (raiz != null)
			imprimirPos(raiz);
		System.out.println("]");
	}

	/**
	 * Imprime um nó da árvore em notação pós-fixa
	 * 
	 * @param n
	 *            Nó a ser impresso
	 */
	private void imprimirPos(NodeArvore<T> n) {
		if (n != null) {
			imprimirPos(n.getLeft());
			imprimirPos(n.getRight());
			System.out.print("\t" + n.getConteudo());
		}
	}
}