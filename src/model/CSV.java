/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 *
 * @author maria
 */
public class CSV implements Report {
    private PrintWriter pw ;
    private StringBuilder sb = new StringBuilder();
    @Override
    public boolean generateReport(String title,String author) {
        String filepath = "D:\\Facultate\\Semestrul II\\PS\\Assignment2\\Bookstore\\Books.csv";
        try {
            pw = new PrintWriter(new File(filepath));
            sb.append("Title:");
            sb.append(',');
            sb.append(title);
            sb.append('\n');
            
            sb.append("Author:");
            sb.append(',');
            sb.append(author);
            sb.append('\n');
            
            pw.write(sb.toString());
            pw.close();
            return true;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return false;
        
    }
}
