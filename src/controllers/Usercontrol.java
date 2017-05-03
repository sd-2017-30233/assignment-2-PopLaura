/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.books;
import model.sellings;
import view.LOGIN;
import view.UserPanel;

/**
 *
 * @author maria
 */
public class Usercontrol {
    //books b=new books();
    private UserPanel userpanel;
    private books b;
    private sellings sell;
    private LOGIN loginpanel;
    public Usercontrol(UserPanel userpanel, LOGIN loginpanel, books b, sellings sell)
    {
        this.userpanel=userpanel;
        this.b=b;
        this.sell=sell;
        this.loginpanel=loginpanel;
        this.userpanel.Author(new searchAuthor());
        this.userpanel.Genre(new searchGenre());
        this.userpanel.Title(new searchTitle());
        this.userpanel.Sell(new Sells());
        this.userpanel.showSellings(new viewSellings());
        this.userpanel.showBooks(new viewBooks());
        this.userpanel.logut(new log_out());
    }
    
    class searchAuthor implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=b.searchByAuthor(userpanel.getSearchTextField());
            userpanel.afisareTabel(tabel);
            
        }
    }
    
    class searchGenre implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=b.searchByGenre(userpanel.getSearchTextField());
            userpanel.afisareTabel(tabel);
            
        }
    }
    
    class searchTitle implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=b.searchByTitle(userpanel.getSearchTextField());
            userpanel.afisareTabel(tabel);
            
        }
    }
    
    class Sells implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            int am=Integer.parseInt(userpanel.getAmountTextField());
            //System.out.println(userpanel.getBooktitleTextField());
            //System.out.println(userpanel.getEmailTextField());
            //System.out.println(am);
            String booktitle=userpanel.getBooktitleTextField();
            String email=userpanel.getEmailTextField();
            //System.out.println(sell.sellBooks(userpanel.getBooktitleTextField(), userpanel.getEmailTextField(), am));
            if(sell.sellBooks(booktitle, email, am))
                userpanel.succes();
            else 
                userpanel.eroare();
        }
    }
    
    class viewSellings implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=sell.showAllSellings();
            userpanel.afisareTabel(tabel);
            
        }
    }
    
    class viewBooks implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=b.viewAllBooks();
            userpanel.afisareTabel(tabel);
            
        }
    }
    
    class log_out implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
           loginpanel.setVisible(true);
           userpanel.setVisible(false);
            
        }
    }
}
