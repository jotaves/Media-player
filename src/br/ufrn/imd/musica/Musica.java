/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.musica;

/**
 *
 * @author pedroarthur-mf
 */
public class Musica {

    String nome;
    String caminho;

    public Musica(String caminho) {
        this.caminho = caminho;
        this.nome = concatenar();
    }

    private String concatenar() {
        //Concatenar com "/"
        String[] particoes = this.caminho.split("/");
        //retornar parte com .mp3
        for (String nomeMusica : particoes) {
            if (nomeMusica.endsWith(".mp3")) {
                return nomeMusica;
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
    
}
