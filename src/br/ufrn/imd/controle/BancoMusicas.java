/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    private final File diretorio;
    private final File musicas;
    private final ArrayList<String> listDiretorio;
    private ArrayList<String> listMusicas;

    public BancoMusicas() throws IOException {
        this.diretorio = new File("diretorio.txt");
        this.musicas = new File("musicas.txt");
        this.listDiretorio = new ArrayList<String>();
        this.listMusicas = new ArrayList<String>();

        lerDiretorios();
        lerMusicas();
    }

    private void lerDiretorios() throws FileNotFoundException, IOException {
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

    public void addDiretotio(String caminho) throws IOException {
        if (!listDiretorio.contains(caminho)) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.diretorio));
            for(String e : listDiretorio){
                 writer.write(e);
                 writer.newLine();
             }
            writer.write(caminho);
            writer.flush();
            listDiretorio.add(caminho);
        }
    }

    private void lerMusicas() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(musicas);
        BufferedReader reader = new BufferedReader(fileReader);
        String data;
        while ((data = reader.readLine()) != null) {
            System.out.println(data);
            listMusicas.add(data);
        }

        reader.close();
    }

    public ArrayList getListMusicas() {
        return listMusicas;
    }

    public void addMusicas(String caminho) throws IOException {
        if (!listMusicas.contains(caminho)) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.musicas));
             for(String e : listMusicas){
                 writer.write(e);
                 writer.newLine();
             }
            writer.write(caminho);
            writer.flush();
            
            listMusicas.add(caminho);
        }
    }

}
