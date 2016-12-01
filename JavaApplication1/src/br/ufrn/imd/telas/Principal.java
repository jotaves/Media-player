/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.telas;

import br.ufrn.imd.musica.Musica;
import br.ufrn.imd.musica.Tocador;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pedroarthur-mf
 */
public class Principal extends javax.swing.JFrame {

    private String caminho;
    private Thread thMusica;
    private int estado; //0-parado, 1-pausado, 2-tocando
    DefaultListModel listModel;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.estado = 0;
        btnParar.setEnabled(false);
        btnPausar.setEnabled(false);
        btnPlay.setEnabled(false);
        
        listModel = new DefaultListModel();
        ListaMusicas.setModel(listModel);
        ListaMusicas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlay = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaMusicas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaPlaylist = new javax.swing.JList<>();
        playlist = new javax.swing.JLabel();
        btnPausar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaMusPlaylist = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        btnPlay.setBackground(java.awt.Color.lightGray);
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/play-button.png"))); // NOI18N
        btnPlay.setBorderPainted(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/stop.png"))); // NOI18N
        btnParar.setBorderPainted(false);
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        ListaMusicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMusicasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaMusicas);

        jScrollPane2.setViewportView(ListaPlaylist);

        playlist.setText("Playlist");

        btnPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/pause-button.png"))); // NOI18N
        btnPausar.setBorderPainted(false);
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(ListaMusPlaylist);

        jLabel2.setText("Músicas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(80, 80, 80)
                        .addComponent(playlist, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnParar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnAbrir)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPausar)
                    .addComponent(btnParar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playlist, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
      /* if(!thMusica.isAlive()){
            thMusica.stop();
        }//Não tente tocar 2 musicas*/
        if (estado == 1) {
            this.thMusica.resume();
            estado = 2;
        }
        else {
            Tocador p1;
            try {
                
                p1 = new Tocador(this.caminho);
                this.thMusica = new Thread(p1);
                this.thMusica.start();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.estado = 2;
        btnParar.setEnabled(true);
        btnPausar.setEnabled(true);
        btnPlay.setEnabled(false);
        
        

    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        if (estado != 0) {
            this.thMusica.stop();
            this.estado = 0;
            btnParar.setEnabled(false);
            btnPlay.setEnabled(true);
            
        }
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        if (this.estado != 1) {
            this.thMusica.suspend();
            this.estado = 1;
            btnPausar.setEnabled(false);
            btnPlay.setEnabled(true);
        }
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquvos MP3", "mp3");
        JFileChooser arquivo = new JFileChooser();
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        arquivo.setAcceptAllFileFilterUsed(false);
        arquivo.addChoosableFileFilter(filtro);

        int r = arquivo.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            //this.caminho = arquivo.getSelectedFile().getAbsolutePath();
            //System.out.println(this.caminho);
            listModel.addElement(new Musica(arquivo.getSelectedFile().getAbsolutePath()));
            ListaMusicas.setModel(listModel);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void ListaMusicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMusicasMouseClicked
        int index = ListaMusicas.getSelectedIndex();
        Musica musica = (Musica) listModel.getElementAt(index);
        this.caminho = musica.getCaminho();
        btnPlay.setEnabled(true);
        System.out.println(caminho);
    }//GEN-LAST:event_ListaMusicasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaMusPlaylist;
    private javax.swing.JList<String> ListaMusicas;
    private javax.swing.JList<String> ListaPlaylist;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel playlist;
    // End of variables declaration//GEN-END:variables
}
