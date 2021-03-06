/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class UserPanel extends javax.swing.JFrame {
    
    /**
     * Creates new form UserPanel
     */
    
    public UserPanel() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        istructionLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        genreButton = new javax.swing.JButton();
        titleButton = new javax.swing.JButton();
        authorButton = new javax.swing.JButton();
        booktitleLabel = new javax.swing.JLabel();
        amountTextField1 = new javax.swing.JTextField();
        booktitleTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        istructionLabel4 = new javax.swing.JLabel();
        sellButton = new javax.swing.JButton();
        emailTextField = new javax.swing.JTextField();
        viewSellingsButton = new javax.swing.JButton();
        viewBooksButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bookstore-UserPanel");
        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(255, 204, 204));

        istructionLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        istructionLabel.setText("You can search a book by genre, title or author:");

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        genreButton.setBackground(new java.awt.Color(255, 204, 204));
        genreButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        genreButton.setText("Genre");
        genreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreButtonActionPerformed(evt);
            }
        });

        titleButton.setBackground(new java.awt.Color(255, 204, 204));
        titleButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        titleButton.setText("Title");
        titleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleButtonActionPerformed(evt);
            }
        });

        authorButton.setBackground(new java.awt.Color(255, 204, 204));
        authorButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        authorButton.setText("Author");
        authorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorButtonActionPerformed(evt);
            }
        });

        booktitleLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        booktitleLabel.setText("Book title:");

        amountTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTextField1ActionPerformed(evt);
            }
        });

        booktitleTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        booktitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booktitleTextFieldActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        emailLabel.setText("Your e-mail:");

        amountLabel.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        amountLabel.setText("Amount:");

        istructionLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        istructionLabel4.setText("You can sell a book:");

        sellButton.setBackground(new java.awt.Color(255, 204, 204));
        sellButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        sellButton.setText("Sell it!");
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        viewSellingsButton.setBackground(new java.awt.Color(255, 204, 204));
        viewSellingsButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        viewSellingsButton.setText("View Sellings");
        viewSellingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSellingsButtonActionPerformed(evt);
            }
        });

        viewBooksButton.setBackground(new java.awt.Color(255, 204, 204));
        viewBooksButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        viewBooksButton.setText("View Books");
        viewBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBooksButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 204, 204));
        logoutButton.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        logoutButton.setText("LOG-OUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(istructionLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(sellButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(genreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(istructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 433, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleButton)
                                .addGap(137, 137, 137)
                                .addComponent(authorButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewBooksButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(booktitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(booktitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewSellingsButton)))
                .addGap(69, 69, 69))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {authorButton, genreButton, sellButton, titleButton, viewBooksButton, viewSellingsButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {booktitleTextField, emailTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(istructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleButton)
                            .addComponent(authorButton))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(booktitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(booktitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewBooksButton)
                        .addGap(33, 33, 33)
                        .addComponent(viewSellingsButton)
                        .addGap(63, 63, 63)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(istructionLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sellButton))
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {authorButton, genreButton, sellButton, titleButton, viewBooksButton, viewSellingsButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {booktitleTextField, emailTextField});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed
    
    private void titleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleButtonActionPerformed
    
    
    //JDialog dialog=showbooks()
    private void genreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_genreButtonActionPerformed
    
    private void authorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorButtonActionPerformed
    // TODO add your handling code here:
    
    }//GEN-LAST:event_authorButtonActionPerformed

    private void amountTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTextField1ActionPerformed

    private void booktitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booktitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_booktitleTextFieldActionPerformed

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellButtonActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void viewSellingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSellingsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewSellingsButtonActionPerformed

    private void viewBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBooksButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewBooksButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed
    
    public void logut(ActionListener metoda)
    {
        logoutButton.addActionListener(metoda);
    }
    
    public String getSearchTextField()
    {
        return searchTextField.getText();
    }
    
    public String getBooktitleTextField()
    {
        return booktitleTextField.getText();
    }
    
     public String getEmailTextField()
    {
        return emailTextField.getText();
    }
    
    public String getAmountTextField()
    {
        return amountTextField1.getText();
    }
    
    public void eroare()
    {
        JOptionPane.showMessageDialog(null, "Eroare");
    }
    
    public void succes()
    {
        JOptionPane.showMessageDialog(null, "Operatie efectuata cu succes");
    }
    
    public void showSellings(ActionListener metoda)
    {
        viewSellingsButton.addActionListener(metoda);
    }
    public void showBooks(ActionListener metoda)
    {
        viewBooksButton.addActionListener(metoda);
    }
    public void Sell(ActionListener metoda)
    {
        sellButton.addActionListener(metoda);
    }
    public void Author(ActionListener metoda)
    {
        authorButton.addActionListener(metoda);
    }
    public void Genre(ActionListener metoda)
    {
        genreButton.addActionListener(metoda);
    }
    public void Title(ActionListener metoda)
    {
        titleButton.addActionListener(metoda);
    }
    public void afisareTabel(DefaultTableModel tabel)
    {
        JTable userTable=new JTable(tabel);
        JDialog dialog=new JDialog();
        dialog.setPreferredSize(new Dimension(650,300));
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Books");
        JScrollPane scrollPane3 = new JScrollPane(userTable);
        scrollPane3.setBounds(10, 50, 950, 120);
        scrollPane3.setEnabled(false);
        dialog.add(scrollPane3);
        dialog.pack();
        dialog.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserPanel u=new UserPanel();
                Color c=new Color(255,153,153);
                u.getContentPane().setBackground(c);
                u.setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField1;
    private javax.swing.JButton authorButton;
    private javax.swing.JLabel booktitleLabel;
    private javax.swing.JTextField booktitleTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton genreButton;
    private javax.swing.JLabel istructionLabel;
    private javax.swing.JLabel istructionLabel4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton sellButton;
    private javax.swing.JButton titleButton;
    private javax.swing.JButton viewBooksButton;
    private javax.swing.JButton viewSellingsButton;
    // End of variables declaration//GEN-END:variables
}
