/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author jotave
 */
public class Node {

    private Character valor;
    private HashMap<Character, Node> filhos = new HashMap<Character, Node>();
    private boolean folha;

    public Node() {
        this.valor = null;
        this.folha = false;
    }

    public Node(Character valor) {
        this.valor = valor;
        this.folha = false;
    }

    public Character getValor() {
        return valor;
    }

    public void setValor(Character valor) {
        this.valor = valor;
    }

    public HashMap<Character, Node> getFilhos() {
        return filhos;
    }

    public void setFilhos(HashMap<Character, Node> filhos) {
        this.filhos = filhos;
    }

    public boolean isFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public Collection<String> autoComplete(String prefix) {
        Node node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.filhos.containsKey(c)) {
                return Collections.emptyList();
            }
            node = node.filhos.get(c);
        }
        return node.allPrefixes();
    }

    protected Collection<String> allPrefixes() {
        List<String> results = new ArrayList<>();
            
        if (this.folha) {   
            results.add("" + this.valor);
            results.add(".");
        }
        else {
            results.add("" + this.valor);
        }
        
        if (this.filhos.size() > 1) {
            results.add("/");
        }

        for (Entry<Character, Node> entry : filhos.entrySet()) {
            Node child = entry.getValue();
            Collection<String> childPrefixes = child.allPrefixes();
            results.addAll(childPrefixes);
        }
        return results;

    }
}
