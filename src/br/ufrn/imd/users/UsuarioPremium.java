/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.users;

import br.ufrn.imd.musica.Playlist;
import java.util.ArrayList;

/**
 *
 * @author pedroarthur-mf
 */
public class UsuarioPremium extends Usuario {

    private ArrayList<Playlist> playlists;

    public UsuarioPremium(String nome, String senha) {
        super(nome, senha);
    }
    
    public void addPlaylist(Playlist p) {
        playlists.add(p);
    }
    
    public void removePlaylist(Playlist p){
        playlists.remove(p);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
    
    public Playlist getPlaylist(Playlist p) {
        for(Playlist pl : playlists) {
            if (pl == p) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " true"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
