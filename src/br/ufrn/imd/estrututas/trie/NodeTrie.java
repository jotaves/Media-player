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
     *
     */
    public NodeTrie() {
        this.valor = null;
        this.folha = false;
    }

    /**
     *
     * @param valor
     */
    public NodeTrie(Character valor) {
        this.valor = valor;
        this.folha = false;
    }

    /**
     *
     * @return
     */
    public Character getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(Character valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public HashMap<Character, NodeTrie> getFilhos() {
        return filhos;
    }

    /**
     *
     * @param filhos
     */
    public void setFilhos(HashMap<Character, NodeTrie> filhos) {
        this.filhos = filhos;
    }

    /**
     *
     * @return
     */
    public boolean isFolha() {
        return folha;
    }

    /**
     *
     * @param folha
     */
    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public Collection<String> autoComplete(String prefix) {
        NodeTrie node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.filhos.containsKey(c)) {
                return Collections.emptyList();
            }
            node = node.filhos.get(c);
        }
        return node.allPrefixes();
    }

    /**
     *
     * @return
     */
    protected Collection<String> allPrefixes() {
        List<String> results = new ArrayList<>();

        if (this.folha) {
            results.add("" + this.valor);
            results.add(".");
        } else {
            results.add("" + this.valor);
        }

        if (this.filhos.size() > 1) {
            results.add("/");
        }

        for (Entry<Character, NodeTrie> entry : filhos.entrySet()) {
            NodeTrie child = entry.getValue();
            Collection<String> childPrefixes = child.allPrefixes();
            results.addAll(childPrefixes);
        }
        return results;

    }
}
