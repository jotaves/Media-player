/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.daos;

import br.ufrn.imd.interfaces.GenericDao;
import br.ufrn.imd.musica.Musica;
import br.ufrn.imd.musica.Playlist;
import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioPremium;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jotave
 */
public class PlaylistsDao implements GenericDao{

    private static ArrayList<Playlist> playlists;
    private static PlaylistsDao uniqueInstance;

    private PlaylistsDao() {

    }

    public static synchronized PlaylistsDao getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PlaylistsDao();
            playlists = new ArrayList<>();
        }
        return uniqueInstance;
    }

    @Override
    public boolean adicionar(Object o) {
        Playlist pl = (Playlist) o;
        if (!jaExiste(pl)) {
            try {
                criarPlaylist(pl);
            } catch (IOException ex) {
                Logger.getLogger(PlaylistsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            playlists.add(pl);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void remover(Object o) {
        Playlist pl = (Playlist) o;
        File file = new File("bancos/playlist_" + pl.getNome() + ".txt");
        file.delete();
        playlists.remove(pl);
    }

    private void criarPlaylist(Playlist pl) throws IOException {
        if (!jaExiste(pl)) {
            File file = new File("bancos/playlist_" + pl.getNome() + ".txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file, true);
            writer.append(pl.getUsuario().getNome() + "\n");
            writer.append(pl.getNome() + "\n");
            for (Musica musica : pl.getMusicas()) {
                writer.append("\n" + musica.getCaminho());
            }
            writer.flush();
            writer.close();
        }
    }

    public void carregarPlaylist(Usuario usuario) throws IOException {
        playlists = new ArrayList<>();
        File f = new File("bancos");
        File[] arquivosPlayList = (f).listFiles();
        boolean plUsurio = false;
        for (File plArq : arquivosPlayList) {
            Playlist pl;
            String nome = plArq.getAbsolutePath();
            nome = nomeFile(nome);
            if (nome.startsWith("playlist_")) {
                String data;
                String nomepl;
                FileReader fileReader = new FileReader(plArq);
                BufferedReader reader = new BufferedReader(fileReader);
                data = reader.readLine();
                if (usuario.getNome().equals(data)) {
                    nomepl = reader.readLine();
                    pl = new Playlist(nomepl, (UsuarioPremium) usuario);

                    while ((data = reader.readLine()) != null) {
                        pl.AdicionarMusica(data);
                    }
                    if (!jaExiste(pl)) {
                        playlists.add(pl);
                    }
                }
            }
        }
    }

    private String nomeFile(String nome) {
        //Concatenar com "/"
        String[] particoes = nome.split("/");
        //retornar parte com .txt
        for (String nomefile : particoes) {
            if (nomefile.endsWith(".txt")) {
                return nomefile;
            }
        }
        return "";
    }

    public static ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public boolean jaExiste(Playlist pl) {
        for (Playlist p : playlists) {
            if (p.getNome().equals(pl.getNome())) {
                return true;
            }
        }
        return false;
    }
}
