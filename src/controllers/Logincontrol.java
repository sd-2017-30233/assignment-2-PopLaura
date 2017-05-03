/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Logincontrol {
    private LOGIN loginpanel;
    private user u;
    public String adminnotadmin;
    private AdminPanel adminpanel;
    private UserPanel userpanel;
    private books b;
    private sellings sell;
    
    public Logincontrol(LOGIN loginpanel,AdminPanel adminpanel,UserPanel userpanel,user u,books b)
    {
        this.loginpanel=loginpanel;
        this.u=u;
        this.adminpanel=adminpanel;
        this.b=b;
        this.userpanel=userpanel;
        this.loginpanel.LOG_IN(new login());
    }
    class login implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String email=loginpanel.getEmailField();
            String pwd=loginpanel.getPwdField();
            if(u.isUser(email, pwd).equals("admin"))
            {
                //Admincontrol admincontrol=new Admincontrol(adminpanel,b,sell,u);
                adminpanel.setVisible(true);
                loginpanel.setVisible(false);
            }
            else
                if(u.isUser(email, pwd).equals("user"))
                {
                    userpanel.setVisible(true);
                    loginpanel.setVisible(false);
                }
            else
                    loginpanel.loginError();
            
        }
        
    }
    
    
}
