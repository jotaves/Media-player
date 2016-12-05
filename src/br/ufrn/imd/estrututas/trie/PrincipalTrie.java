/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.estrututas.trie;

import br.ufrn.imd.estrututas.trie.TADTrie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que implementa uma árvore Trie.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class PrincipalTrie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TADTrie trie = new TADTrie();
        trie.inserir("João");
        trie.inserir("Joana");
        trie.inserir("Maria");
        trie.inserir("Joaninha");
        trie.inserir("José");

        boolean s = trie.buscar("João");
        boolean a = trie.buscar("Joana");

        System.out.println(s);
        System.out.println(a);

        //trie.deletar("João");
        s = trie.buscar("Joao");
        System.out.println(s);

        //trie.deletar("Joana");
        a = trie.buscar("Joana");
        System.out.println(a);

        s = trie.buscar("Jose");
        a = trie.buscar("Mariana");

        System.out.println(s);
        System.out.println(a);

        ArrayList<String> c = (ArrayList<String>) trie.autoComplete("J");
        String check = "";

        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
            check = check + c.get(i);
            if (trie.buscar(check)) {
                System.out.println(check);
                //check = check;
            }
        }
    }

}
