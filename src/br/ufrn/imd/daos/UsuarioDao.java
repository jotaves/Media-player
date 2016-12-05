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
 *
 * @author jotave
 */
public class UsuarioDao implements GenericDao {

    private static TADArvore<Usuario> usuarios;
    private static UsuarioDao uniqueInstance;

    UsuarioDao() {
    }

    public static synchronized UsuarioDao getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UsuarioDao();
            usuarios = new TADArvore<>();
        }
        return uniqueInstance;
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

    @Override
    public boolean adicionar(Object o) {
        return usuarios.inserir((Usuario) o);
    }

    @Override
    public void remover(Object o) {
        usuarios.remover((Usuario) o);
    }
}
