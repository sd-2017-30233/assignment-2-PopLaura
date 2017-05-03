/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package bookstore;
import controllers.Admincontrol;
import controllers.Logincontrol;
import controllers.Usercontrol;
import java.awt.Color;
import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import model.books;
import model.sellings;
import model.user;
import view.AdminPanel;
import view.LOGIN;
import view.UserPanel;

/**
 *
 * @author maria
 */
public class Bookstore {
    
    /**
     * @param args the command line arguments
     * @throws DocumentException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        // TODO code application logic here
        
        
        //------------MODELS-------------
        books b=new books();
        sellings sell=new sellings();
        user u=new user();
        //------------VIEWS-------------
        LOGIN loginpanel=new LOGIN();
        UserPanel userpanel=new UserPanel();
        AdminPanel adminpanel=new AdminPanel();
        //------------CONTROLLS-------------
        Logincontrol logincontrol=new Logincontrol(loginpanel, adminpanel, userpanel, u, b);
        Admincontrol admincontrol=new Admincontrol(adminpanel,loginpanel, b, sell, u);
        Usercontrol usercontrol=new Usercontrol(userpanel,loginpanel, b, sell);
        loginpanel.setVisible(true);
       
        
        
        
        
        Color c=new Color(204,204,255);
        adminpanel.getContentPane().setBackground(c);
        loginpanel.getContentPane().setBackground(c);
        userpanel.getContentPane().setBackground(c);
        //userpanel.setVisible(true);
        //adminpanel.setVisible(true);
        //System.out.println(u.isUser("maria_laura_pop@yahoo.com", "123"));
    }  
}
