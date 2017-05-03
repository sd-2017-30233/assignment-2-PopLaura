/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controllers;

import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.PDF;
import model.Report;
import model.ReportFactory;
import model.books;
import model.sellings;
import model.user;
import view.AdminPanel;
import view.LOGIN;

/**
 *
 * @author maria
 */
public class Admincontrol {
    private AdminPanel adminpanel;
    private books b;
    private sellings sell;
    private user u;
    private LOGIN loginpanel;
    private ReportFactory rf=new ReportFactory();
    private Report r1=rf.getReport("CSV");
    private Report r2=rf.getReport("PDF");
    public Admincontrol(AdminPanel adminpanel,LOGIN loginpanel, books b, sellings sell, user u) throws FileNotFoundException, DocumentException
    {
        this.adminpanel=adminpanel;
        this.b=b;
        this.sell=sell;
        this.u=u;
        this.loginpanel=loginpanel;
        this.adminpanel.addBooks(new addbook());
        this.adminpanel.updateBooks(new updatebook());
        this.adminpanel.showBooks(new viewBooks());
        this.adminpanel.deleteBooks(new deletebook() );
        this.adminpanel.addUser(new adduser());
        this.adminpanel.updateUser(new updateuser());
        this.adminpanel.deleteUser(new deleteuser());
        this.adminpanel.showUsers(new viewUsers());
        this.adminpanel.showSellings(new viewSellings());
        this.adminpanel.logut(new log_out());
        this.adminpanel.CSV(new csv());
        this.adminpanel.PDF(new pdf());
    }

   
    //--------------------------------------BOOKS----------------------------------
    class addbook implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String title=adminpanel.getTitleTextField();
            String author=adminpanel.getAutorTextField();
            int year=Integer.parseInt(adminpanel.getYearTextField());
            float price=Float.parseFloat(adminpanel.getPriceTextField());
            String genre=adminpanel.getGenreTextField();
            int amount=Integer.parseInt(adminpanel.getAmountTextField());
            books book=new books(title,author,year,price,genre,amount);
            if(b.ADDBook(book))
                adminpanel.succes();
            else
                adminpanel.eroare();
            
        }
    }
    
    class updatebook implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String title=adminpanel.getTitleTextField();
            
            String author=adminpanel.getAutorTextField();
            int year;
            if(adminpanel.getYearTextField().equals(""))
                year=0;
            else
                year=Integer.parseInt(adminpanel.getYearTextField());
            
            float price;
            if(adminpanel.getPriceTextField().equals(""))
                price=-1;
            else
                price=Float.parseFloat(adminpanel.getPriceTextField());
            String genre=adminpanel.getGenreTextField();
            int amount;
            if(adminpanel.getAmountTextField().equals(""))
                amount=-1;
            else
                amount=Integer.parseInt(adminpanel.getAmountTextField());
            books book=new books(title,author,year,price,genre,amount);
            String booktitle=adminpanel.getChangeBook();
            if(b.UPDATEBooks(booktitle, book))
                adminpanel.succes();
            else
                adminpanel.eroare();
            
        }
    }
    class deletebook implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String booktitle=adminpanel.getChangeBook();
            if(b.DELETEBooks(booktitle))
                adminpanel.succes();
            else
                adminpanel.eroare();
            
        }
    }
    class viewBooks implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=b.viewAllBooks();
            adminpanel.afisareTabel(tabel);
            
        }
    }
    
    //--------------------------------------USERS----------------------------------
    
    class adduser implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=adminpanel.getNameUser();
            String email=adminpanel.getEmailUser();
            String admin=adminpanel.getAdminUser();
            String pwd=adminpanel.getPwdUser();
            user us=new user(name, admin, email, pwd);
            if(u.ADDUser(us))
                adminpanel.succes();
            else
                adminpanel.eroare();
            
        }
    }
    
    class updateuser implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=adminpanel.getNameUser();
            String email=adminpanel.getEmailUser();
            String admin=adminpanel.getAdminUser();
            String pwd=adminpanel.getPwdUser();
            user us=new user(name, admin, email, pwd);
            String em=adminpanel.getChangeUser();
            if(u.UPDATEUser(em,us))
                adminpanel.succes();
            else
                adminpanel.eroare();
            
        }
    }
    
    class deleteuser implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String email=adminpanel.getChangeUser();
            if(u.DELETEUsers(email))
                adminpanel.succes();
            else
                adminpanel.eroare();
            
        }
    }
    
    class viewUsers implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=u.showAllUsers();
            adminpanel.afisareTabel(tabel);
            
        }
    }
    
    class viewSellings implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
            DefaultTableModel tabel=sell.showAllSellings();
            adminpanel.afisareTabel(tabel);
            
        }
    }
    
    class log_out implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
           loginpanel.setVisible(true);
           adminpanel.setVisible(false);
            
        }
    }
    
    class csv implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
           ArrayList<books> book=b.zeroAmount();
           for(int i=0;i<book.size();i++)
           {
               if(r1.generateReport(book.get(i).getTitle(), book.get(i).getAuthor()))
                   adminpanel.succes();
               else
                   adminpanel.eroare();
           }
            
        }
    }
    
    class pdf implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            
           ArrayList<books> book=b.zeroAmount();
           for(int i=0;i<book.size();i++)
           {
               if(r2.generateReport(book.get(i).getTitle(), book.get(i).getAuthor()))
                   adminpanel.succes();
               else adminpanel.eroare();
           }
            PDF.document.close();
        }
    }
}
