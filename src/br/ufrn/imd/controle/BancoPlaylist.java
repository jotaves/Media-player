/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.controle;

import br.ufrn.imd.musica.Playlist;
import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioComum;
import br.ufrn.imd.users.UsuarioPremium;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jotave
 */
public class BancoPlaylist {

    ArrayList<Playlist> playlists;
    private static BancoPlaylist uniqueInstance;

    private BancoPlaylist() {
    }

    public static synchronized BancoPlaylist getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BancoPlaylist();
        }
        return uniqueInstance;
    }

    public void adicionarPlaylist(Playlist p) {
        playlists.add(p);
    }

    public void removerPlaylist(Playlist p) {
        playlists.remove(p);
    }

    public void carregarPlaylists(File file) throws FileNotFoundException {
        // Essa função será chamada a partir de Login. Quando ele logar, serão carregadas
        // suas playlists chamando essa função. Ou seja, será lido um arquivo com os endereços
        // das músicas da playlist.
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
    }
}
