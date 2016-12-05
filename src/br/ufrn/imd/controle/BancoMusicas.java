/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.controle;

import br.ufrn.imd.musica.Musica;
import br.ufrn.imd.musica.Playlist;
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
public class BancoMusicas {

    private static BancoMusicas uniqueInstance;
    private static File diretorio;
    private static File musicas;
    private static ArrayList<String> listDiretorio;
    private static ArrayList<String> listMusicas;

    private BancoMusicas() {

    }

    public static synchronized BancoMusicas getInstance() throws IOException {
        if (uniqueInstance == null) {
            uniqueInstance = new BancoMusicas();
            diretorio = new File("bancos/diretorio.txt");
            musicas = new File("bancos/musicas.txt");
            listDiretorio = new ArrayList<String>();
            listMusicas = new ArrayList<String>();
            lerDiretorios();
            lerMusicas();
        }
        return uniqueInstance;
    }

    private static void lerDiretorios() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(diretorio);
        BufferedReader reader = new BufferedReader(fileReader);
        String data;
        while ((data = reader.readLine()) != null) {
            listDiretorio.add(data);
        }
        reader.close();
    }

    public ArrayList getListDiretorio() {
        return listDiretorio;
    }

    // Provavelmente com erros.
    public void addDiretotio(String caminho) throws IOException {
        if (!listDiretorio.contains(caminho)) {
            FileWriter writer = new FileWriter(this.diretorio, true);
//            for (String diretorio : listDiretorio) {
//                writer.append(diretorio);
//            }
            writer.append(caminho);
            writer.flush();
            listDiretorio.add(caminho);
            writer.close();
        }
    }

    private static void lerMusicas() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(musicas);
        BufferedReader reader = new BufferedReader(fileReader);
        String data;
        while ((data = reader.readLine()) != null) {
            if (!listMusicas.contains(data)) {
                listMusicas.add(data);
            }
        }

        reader.close();

    }

    public ArrayList getListMusicas() {
        return listMusicas;
    }

    public void addMusicas(String caminho) throws IOException {
        if (!listMusicas.contains(caminho)) {
            FileWriter writer = new FileWriter(this.musicas, true);

//            for (String musica : listMusicas) {
//                writer.append(musica + "\n");
//            }
            writer.append(caminho + "\n");
            writer.flush();
            writer.close();
            listMusicas.add(caminho);
        }
    }

    public void removerMusicas() {
        listMusicas = new ArrayList<>();
        listDiretorio = new ArrayList<>();

    }

}
