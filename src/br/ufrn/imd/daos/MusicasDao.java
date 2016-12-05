/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.daos;

import br.ufrn.imd.interfaces.GenericDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que implementa o banco de Musicas.
 * 
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class MusicasDao implements GenericDao {

    private static MusicasDao uniqueInstance;
    private static File diretorio;
    private static File musicas;
    private static ArrayList<String> listDiretorio;
    private static ArrayList<String> listMusicas;

    private MusicasDao() {

    }

    public static synchronized MusicasDao getInstance() throws IOException {
        if (uniqueInstance == null) {
            uniqueInstance = new MusicasDao();
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
    public void adicionarDiretorio(String caminho) throws IOException {
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

    @Override
    public boolean adicionar(Object o) {
        String caminho = (String) o;
        if (!listMusicas.contains(caminho)) {
            FileWriter writer;
            try {
                writer = new FileWriter(this.musicas, true);
                writer.append(caminho + "\n");
                writer.flush();
                writer.close();                
            } catch (IOException ex) {
                Logger.getLogger(MusicasDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            listMusicas.add(caminho);
            return true;
        }
        return false;
    }

    public void removerTudo() {
        listMusicas = new ArrayList<>();
        listDiretorio = new ArrayList<>();
    }

    @Override
    public void remover(Object o) {
        listMusicas.remove((String) o);
        // Apagar do arquivo tbm.
    }

}
