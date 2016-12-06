package br.ufrn.imd.estrututas.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Classe que implementa um nó de uma árvore Trie.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class NodeTrie {

    private Character valor;
    private HashMap<Character, NodeTrie> filhos = new HashMap<Character, NodeTrie>();
    private boolean folha;

    /**
     * Construtor da classe
     */
    public NodeTrie() {
        this.valor = null;
        this.folha = false;
    }

    /**
     * Construtor da classe
     * @param valor O valor que será adicionado
     */
    public NodeTrie(Character valor) {
        this.valor = valor;
        this.folha = false;
    }

    /**
     * Método que retorna o valor do nó
     * @return Valor do nó
     */
    public Character getValor() {
        return valor;
    }

    /**
     * Método que seta o valor do nó
     * @param valor Valor do nó
     */
    public void setValor(Character valor) {
        this.valor = valor;
    }

    /**
     * Método que retorna os filhos do nó
     * @return HashMap com os filhos do nó e suas chaves
     */
    public HashMap<Character, NodeTrie> getFilhos() {
        return filhos;
    }

    /**
     * Método que seta os filhos do nó
     * @param filhos HashMap com os filhos do nó e suas chaves
     */
    public void setFilhos(HashMap<Character, NodeTrie> filhos) {
        this.filhos = filhos;
    }

    /**
     * Método que retorna se o nó é folha
     * @return Booleano que indica se o nó é folha
     */
    public boolean isFolha() {
        return folha;
    }

    /**
     * Método que seta se um nó é folha
     * @param folha Booleano que indica se o nó é folha
     */
    public void setFolha(boolean folha) {
        this.folha = folha;
    }
}
