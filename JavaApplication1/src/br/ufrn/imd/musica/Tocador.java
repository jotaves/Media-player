/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.musica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Tocador implements Runnable {

    private FileInputStream arquivo = null;
    private Player musica;

    /**
     *
     * @param caminho
     * @throws FileNotFoundException
     */
    public Tocador(String caminho) throws FileNotFoundException {
        try {
            arquivo = new FileInputStream(caminho);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void run() {
        try {
            musica = new Player(arquivo);
            musica.play();
        } catch (JavaLayerException ex) {
            Logger.getLogger(Tocador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
