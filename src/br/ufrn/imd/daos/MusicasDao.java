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

    /**
     * Construtor da classe
     * @return @throws IOException
     */
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

    /**
     * Ler diretórios e armazenar
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void lerDiretorios() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(diretorio);
        BufferedReader reader = new BufferedReader(fileReader);
        String data;
        while ((data = reader.readLine()) != null) {
            listDiretorio.add(data);
        }
        reader.close();
    }

    /**
     * Retorna a lista de diretórios
     * @return Lista de diretórios
     */
    public ArrayList getListDiretorio() {
        return listDiretorio;
    }

    /**
     * Adicionar diretório
     * @param caminho String com endereço do diretório a ser adicionado
     * @throws IOException
     */
    public void adicionarDiretorio(String caminho) throws IOException {
        if (!listDiretorio.contains(caminho)) {
            FileWriter writer = new FileWriter(this.diretorio, true);
            writer.append(caminho);
            writer.flush();
            listDiretorio.add(caminho);
            writer.close();
        }
    }

    /**
     * Carregar/ler músicas
     * @throws FileNotFoundException
     * @throws IOException
     */
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

    /**
     * Retorna a lista de músicas
     * @return Lista de músicass
     */
    public ArrayList getListMusicas() {
        return listMusicas;
    }

    /**
     * Adiciona uma música à lista de músicas
     * @param o Música a ser inserida
     * @return true, se foi inserida; false, se não
     */
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

    /**
     * Remove todos os elementos de todas listas
     */
    public void removerTudo() {
        listMusicas = new ArrayList<>();
        listDiretorio = new ArrayList<>();
    }

    /**
     * Remove um elemento da lista de música
     * @param o
     */
    @Override
    public void remover(Object o) {
        listMusicas.remove((String) o);
    }

}
