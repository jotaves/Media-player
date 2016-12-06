/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.estrututas.trie;

import java.util.HashMap;

/**
 * Classe que implementa uma árvore Trie.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class TadTrie {

    private NodeTrie raiz;

    /**
     *
     */
    public TadTrie() {
        raiz = new NodeTrie();
    }

    /**
     *
     * @param s
     */
    public void inserir(String s) {
        // Auxiliar para percorrer a árvore.
        HashMap<Character, NodeTrie> aux = raiz.getFilhos();

        // Percorrendo a string.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Nó auxiliar do auxiliar.
            NodeTrie n;

            // Caso c já exista na árvore.
            if (aux.containsKey(c)) {
                // Pega o nó que possui o caractere c.
                n = aux.get(c);
            } else { // Caso não exista caractere c na árvore.
                // Cria um novo nó com o caractere c.
                n = new NodeTrie(c);
                // Insere o nó como filho.
                aux.put(c, n);
            }

            // Avança pros filhos do nó que já existia ou do que foi criado.
            aux = n.getFilhos();

            // Se for o último caractere da string.
            if (i == s.length() - 1) {
                n.setFolha(true);
            }
        }
    }
    

    public boolean ePrefixo(String s) {
        NodeTrie n = buscarNodeTrie(s);
        if (n != null) {
            return true;
        }
        else {
            return false;
        }
    }    

    /**
     *
     * @param s
     * @return
     */
    public boolean buscar(String s) {
        NodeTrie n = buscarNodeTrie(s);
        if (n == null || !n.isFolha()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public NodeTrie buscarNodeTrie(String s) {
        HashMap<Character, NodeTrie> aux = raiz.getFilhos();
        NodeTrie resultado = null;

        // Percorre a string.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Se tiver o caractere.
            if (aux.containsKey(c)) {
                // É pego o nó que possui o caractere.
                resultado = aux.get(c);
                // E avança.
                aux = aux.get(c).getFilhos();
            } else { // Se não tiver.
                return null;
            }
        }
        return resultado;
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean deletar(String s) {
        if (!buscar(s)) {
            return false;
        } else {
            HashMap<Character, NodeTrie> aux = raiz.getFilhos();
            HashMap<Character, NodeTrie> resultado = null;
            Character rIndex = null;

            // Percorre a string.
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // Armazena o último ponto onde um nó possuiu mais de um filho e o char que levou a ele.
                if (aux.size() > 1) {
                    resultado = aux;
                    rIndex = c;
                }
                aux = aux.get(c).getFilhos();
            }

            // Se não houve pontos na árvore em que ela se dividiu é porque há apenas uma palavra.
            if (resultado == null) {
                // Então a árvore é zerada.
                raiz.getFilhos().clear();
            } else { // Caso contrário, é removido o último ponto que um nó possuiu mais de um filho.
                resultado.remove(rIndex);
            }
            return true;
        }
    }
}
