/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.musica;

import br.ufrn.imd.users.UsuarioPremium;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que implementa uma Playlists.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;
    private UsuarioPremium usuario;
    File file;

    /**
     *
     * @param nome Nome da Plalist.
     * @param u Usuario ao qual pertence a Playlist
     * @throws IOException
     */
    public Playlist(String nome, UsuarioPremium u) throws IOException {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.usuario = u;
        this.file = new File("bancos/playlist_" + this.nome + ".txt");

    }

    /**
     * Retorna o nome da Playlist
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna um array com as musicas presentes na Playlist.
     *
     * @return array com as musicas presentes na Playlist.
     */
    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    /**
     * Musica que deseja ser adicionada a playlits
     *
     * @param caminho Caminho do diretorio da musica que se deseja adicionar.
     * @throws IOException
     */
    public void AdicionarMusica(String caminho) throws IOException {
        if (!musicas.contains(caminho)) {
            musicas.add(new Musica(caminho));
            FileWriter writer = new FileWriter(file, false);
            writer.write(usuario.getNome() + "\n");
            writer.write(this.nome + "\n");
            for (Musica m : musicas) {
                writer.write(m.getCaminho() + "\n");
            }
            writer.flush();
            writer.close();
        }
    }

    /**
     * Retorna Usuário dono da Playlist.
     *
     * @return Usuario dono da Playlist
     */
    public UsuarioPremium getUsuario() {
        return usuario;
    }

    /**
     * Remove uma música desejada da Playlist.
     *
     * @param m Musica se deseja deletar.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void removerMusica(Musica m) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String usuario = reader.readLine();
        String data = reader.readLine();
        ArrayList<String> novo = new ArrayList<>();
        while ((data = reader.readLine()) != null) {
            if (!(data.equals(m.getCaminho()))) {
                novo.add(data);
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

    /**
     * Conseguir o nome do arquio sem o caminho do diretorio.
     *
     * @param nome Caminho do diretorio do arquivo.
     * @return Nome do arquivo sem o caminho do direrorio.
     */
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
