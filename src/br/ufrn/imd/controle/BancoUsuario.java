/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.controle;

import br.ufrn.imd.users.Usuario;
import java.util.ArrayList;

/**
 *
 * @author jotave
 */
public class BancoUsuario {

    private static ArrayList<Usuario> usuarios;
    private static BancoUsuario uniqueInstance;

    BancoUsuario() {
    }

    public static synchronized BancoUsuario getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BancoUsuario();
            usuarios = new ArrayList<>();
        }
        return uniqueInstance;
    }

    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public boolean verificarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (nome.equals(usuario.getNome())) {
                return true;
            }
        }
        return false;
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
        for (Usuario usuario : usuarios) {
            if (nome.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
                return true;
            }
        }
        return false;
    }

    public boolean ePremium(String nome, String senha) {
        for (Usuario usuario : usuarios) {
            if (nome.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
                if (usuario.ePremium()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
