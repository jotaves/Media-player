/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.daos;

import br.ufrn.imd.estrututas.abb.NodeArvore;
import br.ufrn.imd.estrututas.abb.TADArvore;
import br.ufrn.imd.interfaces.GenericDao;
import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioComum;

/**
 * Classe que implementa O banco de Usuarios.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class UsuarioDao implements GenericDao {

    private static TADArvore<Usuario> usuarios;
    private static UsuarioDao uniqueInstance;

    UsuarioDao() {
    }

    /**
     *
     * @return
     */
    public static synchronized UsuarioDao getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UsuarioDao();
            usuarios = new TADArvore<>();
        }
        return uniqueInstance;
    }

    /**
     *
     * @param nome
     * @return
     */
    public boolean verificarUsuario(String nome) {
        Usuario u = new UsuarioComum(nome, "");
        return usuarios.buscarArvore(u) != null;
    }

    /**
     *
     * @param nome
     * @param senha
     * @return
     */
    public boolean verificarUsuarioESenha(String nome, String senha) {
        Usuario u = new UsuarioComum(nome, senha);
        NodeArvore<Usuario> n = usuarios.buscarArvore(u);

        return n != null && nome.equals(n.getConteudo().getNome()) && senha.equals(n.getConteudo().getSenha());
    }

    /**
     *
     * @param nome
     * @param senha
     * @return
     */
    public boolean ePremium(String nome, String senha) {
        Usuario u = new UsuarioComum(nome, senha);
        NodeArvore<Usuario> n = usuarios.buscarArvore(u);
        return nome.equals(n.getConteudo().getNome()) && senha.equals(n.getConteudo().getSenha()) && n.getConteudo().ePremium();
    }

    /**
     *
     * @return
     */
    public TADArvore<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean adicionar(Object o) {
        return usuarios.inserir((Usuario) o);
    }

    /**
     *
     * @param o
     */
    @Override
    public void remover(Object o) {
        usuarios.remover((Usuario) o);
    }
}
