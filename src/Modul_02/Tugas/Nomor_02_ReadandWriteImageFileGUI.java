/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Nomor_02_ReadandWriteImageFileGUI.java
 *
 * Created on 11 Sep 18, 19:47:54
 */

package Modul_02.Tugas;

/**
 *
 * @author CHP_SONE
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Nomor_02_ReadandWriteImageFileGUI extends javax.swing.JFrame {

    /** Creates new form Nomor_02_ReadandWriteImageFileGUI */
    public Nomor_02_ReadandWriteImageFileGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        pilih_gambar = new javax.swing.JLabel();
        importfile = new javax.swing.JButton();
        gambar = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        dir = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pilih_gambar.setText("Pilih File Gambar");

        importfile.setText("Import");
        importfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importfileActionPerformed(evt);
            }
        });

        save.setText("SaveTo");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(pilih_gambar)
                        .addGap(132, 132, 132)
                        .addComponent(importfile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importfile)
                    .addComponent(pilih_gambar))
                .addGap(18, 18, 18)
                .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String gbr;

    private void importfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importfileActionPerformed
        BufferedImage img = null;
        try{
            JFileChooser file= new JFileChooser();
//            file.setSelectedFile(null);
            file.setFileFilter(new javax.swing.filechooser.FileFilter(){
               @Override
               public String getDescription() {
                   return "All image Support!";
               }

               @Override
               public boolean accept(File f) {
                   if (f.isDirectory()) {
                       return true;
                   } else {
                       return f.getName().toLowerCase().endsWith(".png")
                               || f.getName().toLowerCase().endsWith(".jpeg")
                               || f.getName().toLowerCase().endsWith(".jpg")
                               || f.getName().toLowerCase().endsWith(".gif"); // lets try it
                   }
               }
            });
            
            if (file.showOpenDialog(this)== file.APPROVE_OPTION) {
                gbr = file.getSelectedFile().toString();
                
                img = ImageIO.read(new File(gbr));
                Image image = img.getScaledInstance(gambar.getWidth(), gambar.getHeight(), Image.SCALE_DEFAULT);

                ImageIcon icon = new ImageIcon(image);
                gambar.setIcon(icon);
            }
        }catch(Exception e){
            System.out.println(e);
        }
}//GEN-LAST:event_importfileActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
            Rectangle rec = gambar.getBounds();
            BufferedImage bi = new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
            gambar.paint(bi.getGraphics());

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int save = chooser.showSaveDialog(this);
            if (save == chooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                dir.setText(" "+chooser.getSelectedFile()+"\\");
                try {
                    ImageIO.write(bi, "jpg", f);
                    JOptionPane.showMessageDialog(this, "Gambar Berhasil Disimpan", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
}//GEN-LAST:event_saveActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomor_02_ReadandWriteImageFileGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dir;
    private javax.swing.JLabel gambar;
    private javax.swing.JButton importfile;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel pilih_gambar;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

}
