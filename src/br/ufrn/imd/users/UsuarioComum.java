/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.users;

/**
 *
 * @author pedroarthur-mf
 */
public class UsuarioComum extends Usuario {

    public UsuarioComum(String nome, String senha) {
        super(nome, senha);
    }

    @Override
    public String toString() {
        return super.toString() + " false"; //To change body of generated methods, choose Tools | Templates.
    }

}
