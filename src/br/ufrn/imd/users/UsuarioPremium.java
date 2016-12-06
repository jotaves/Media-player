/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.users;

import br.ufrn.imd.musica.Playlist;
import java.util.ArrayList;

/**
 * Classe .
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class UsuarioPremium extends Usuario {

    public UsuarioPremium(String nome, String senha) {
        super(nome, senha);
    }

    @Override
    public boolean ePremium() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " true"; //To change body of generated methods, choose Tools | Templates.
    }

}
