/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author maria
 */
public class PDF implements Report {
     public static Document document = new Document(PageSize.A4, 50, 50, 50, 50);
     private  String filepath = "D:\\Facultate\\Semestrul II\\PS\\Assignment2\\Bookstore\\Books.pdf";
     private  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filepath));

    public PDF() throws FileNotFoundException, DocumentException {
    }

    @Override
    public boolean generateReport(String title,String author) {
        Anchor anchorTarget = new Anchor("Books out of stock:");
        anchorTarget.setName("BackToTop");
        document.open();
        Paragraph paragraph1 = new Paragraph();

        paragraph1.setSpacingBefore(50);

        paragraph1.add(anchorTarget);
        try {
            document.add(paragraph1);
            document.add(new Paragraph("\nThe book:"+title+" written by " +author+" is out of stock!\n",
                FontFactory.getFont(FontFactory.COURIER, 14, Font.ITALIC, new CMYKColor(0, 255, 255, 0))));
            return true;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
       // document.close();
       return false;
    }
}
