/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.users.execoes;

/**
 * Classe de tratamento de Exceção para classe tela de Login.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class LoginExeption extends Exception {

    public LoginExeption() {
    }

    public LoginExeption(String message) {
        super(message);
    }

    public LoginExeption(Throwable cause) {
        super(cause);
    }

    public LoginExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
