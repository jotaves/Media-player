/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.musica;

/**
 * Classe que guarda as iformações de uma música.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class Musica {

    String nome;
    String caminho;

    /**
     * Construtor da classe música
     *
     * @param caminho Caminho do diretorio ao qual a musica pertence.
     */
    public Musica(String caminho) {
        this.caminho = caminho;
        this.nome = concatenar();
    }

    /**
     * Separa o caminho em / e pega o final que termina com ".mp3". Usado para
     * conseguir o nome do arquivo de musica a partir do caminho.
     *
     * @return nome da música.
     */
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

    /**
     * Retorna o nome da música.
     *
     * @return nome da música.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o caminho do diretorio onde a música se encontra.
     *
     * @return caminho do diretorio onde a música se encontra.
     */
    public String getCaminho() {
        return caminho;
    }
}
