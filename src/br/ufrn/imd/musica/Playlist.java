/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.musica;

import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioPremium;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pedroarthur-mf
 */
public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;
    private UsuarioPremium usuario;

    public Playlist(String nome, UsuarioPremium u) throws IOException {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.usuario = u;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void AdicionarMusica(String caminho) throws IOException {
        if (!musicas.contains(caminho)) {
            File file = new File("bancos/playlist_" + this.nome + ".txt");
            FileWriter writer = new FileWriter(file, true);

            writer.append(caminho + "\n");
            writer.flush();
            writer.close();
            musicas.add(new Musica(caminho));
        }
    }

    public UsuarioPremium getUsuario() {
        return usuario;
    }

    public void removerMusica(Musica m) throws FileNotFoundException, IOException {
        File file = new File("bancos/playlist_" + this.nome + ".txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String usuario = reader.readLine();
        String data = reader.readLine();
        ArrayList<String> novo = new ArrayList<>();
        while ((data = reader.readLine()) != null) {
            if (!data.equals(m.getCaminho())) {
                novo.add(m.getCaminho());
            }
        }
        FileWriter writer = new FileWriter(file, false);
        writer.write(usuario + "\n");
        writer.write(this.nome + "\n");
        for (String nome : novo) {
            writer.write(nome + "\n");
        }
        writer.flush();
        writer.close();
    }

    @Override

    public String toString() {
        return nome;
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
}
