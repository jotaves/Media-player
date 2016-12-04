/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.controle;

import br.imd.Arvore.NodeArvore;
import br.imd.Arvore.TADArvore;
import br.ufrn.imd.trie.Node;
import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioComum;
import java.util.ArrayList;

/**
 *
 * @author jotave
 */
public class BancoUsuario {

    private static TADArvore<Usuario> usuarios;
    private static BancoUsuario uniqueInstance;

    BancoUsuario() {
    }

    public static synchronized BancoUsuario getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BancoUsuario();
            usuarios = new TADArvore<>();
        }
        return uniqueInstance;
    }

    public void adicionarUsuario(Usuario u) {
        usuarios.inserir(u);
    }

    public boolean verificarUsuario(String nome) {
        Usuario u = new UsuarioComum(nome, "");
        return usuarios.buscarArvore(u) != null;
        
//        for (Usuario usuario : usuarios) {
//            if (nome.equals(usuario.getNome())) {
//                return true;
//            }
//        }
//        return false;
    }

//    public Usuario pegarUsuario(String nome) {
//        for (Usuario usuario : usuarios) {
//            if (nome.equals(usuario.getNome())) {
//                return usuario;
//            }
//        }
//        return null;
//    }

    public boolean verificarUsuarioESenha(String nome, String senha) {
        Usuario u = new UsuarioComum(nome, senha);
        NodeArvore<Usuario> n = usuarios.buscarArvore(u);
        
        return n != null && nome.equals(n.getConteudo().getNome()) && senha.equals(n.getConteudo().getSenha());
    }

    public boolean ePremium(String nome, String senha) {
        Usuario u = new UsuarioComum(nome, senha);
        NodeArvore<Usuario> n = usuarios.buscarArvore(u);
        return nome.equals(n.getConteudo().getNome()) && senha.equals(n.getConteudo().getSenha()) && n.getConteudo().ePremium();
    }

    public TADArvore<Usuario> getUsuarios() {
        return usuarios;
    }
}
