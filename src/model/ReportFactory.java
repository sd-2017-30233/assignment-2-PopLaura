/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileNotFoundException;
import com.itextpdf.text.DocumentException;
/**
 *
 * @author maria
 */
public class ReportFactory {
	public Report getReport(String reportType) throws FileNotFoundException, DocumentException{
	      if(reportType == null){
	         return null;
	      }		
	      if(reportType.equalsIgnoreCase("PDF")){
	         return new PDF();
	         
	      } else if(reportType.equalsIgnoreCase("CSV")){
	         return new CSV();
	         
	      } 
	      
	      return null;
	   }
}