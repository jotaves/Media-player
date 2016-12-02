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
public class BancoPlaylist {
    ArrayList<Usuario> usuarios;
    private static BancoPlaylist uniqueInstance;
    
    private BancoPlaylist() {
    }
    
    public static synchronized BancoPlaylist getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new BancoPlaylist();
        return uniqueInstance;
    }
    
    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }
}