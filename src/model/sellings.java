/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author maria
 */
public class sellings {
    String booktitle;
    String useremail;
    int amount;
    Date date;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public sellings()
    {
        
    }
    
    public sellings(String booktitle, String useremail, int amount, Date date) {
        this.booktitle = booktitle;
        this.useremail = useremail;
        this.amount = amount;
        this.date = date;
    }
    
    public String getBooktitle() {
        return booktitle;
    }
    
    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    
    public String getUseremail() {
        return useremail;
    }
    
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public DefaultTableModel showAllSellings()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/selling.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/sellings/selling");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Book Title", "User email", "Amount", "Date"});
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Node nNode = nodes.item(i);
                //System.out.println("1");
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                //System.out.println("1");
                Element eElement = (Element) nNode;
                lista.addRow(new Object[]{eElement.getElementsByTagName("booktitle").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("useremail").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("amount").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("date").item(0).getTextContent()+ " "});
            }
            return lista;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }catch( XPathExpressionException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean sellBooks(String booktitle, String useremail, int amount)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
        factory1.setNamespaceAware(true);
        DocumentBuilder builder1;
        Document document = null;
        
        Date date1=new Date();
        System.out.println(sdf.format(date1));
        
        try {
            
            
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/bookstore.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("/bookstore/book[title='"+booktitle+"']");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            for (int i = 0; i < nodes.getLength(); i++)
            {
                
                Node nNode = nodes.item(i);
                //System.out.println("1");
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                //System.out.println("1");
                Element eElement = (Element) nNode;
                
                String autor=new String();
                String categorie=new String();
                int k=0;
                int am=Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent())-amount;
                if(am<0)
                    break;
                else
                {
                    while(eElement.getElementsByTagName("author").item(k)!=null)
                    {
                        k++;
                    }
                    for(int m=0;m<k;m++)
                    {
                        autor=autor+eElement.getElementsByTagName("author").item(m).getTextContent()+ " ";
                    }
                    int j=0;
                    while(eElement.getElementsByTagName("genre").item(j)!=null)
                    {
                        
                        j++;
                    }
                    for(int l=0; l<j; l++)
                    {
                        categorie=categorie+eElement.getElementsByTagName("genre").item(l).getTextContent()+ " ";
                        
                    }
                    
                    //eElement.getElementsByTagName("title").item(0).setTextContent("bla");
                    eElement.getElementsByTagName("amount").item(0).setTextContent((String.valueOf(am)));
                    System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println(autor);
                    System.out.println(eElement.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println(categorie);
                    System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
                    
                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("src/data/bookstore.xml"));
                    transformer.transform(source, result);
                    
                    builder1 = factory.newDocumentBuilder();
                    document = builder1.parse("src/data/selling.xml");
                    XPathFactory xpathFactory1 = XPathFactory.newInstance();
                    XPath xpath1 = xpathFactory1.newXPath();
                    XPathExpression expr1 =xpath1.compile("/sellings/selling");
                    //evaluate expression result on XML document
                    Node nodes1 = (Node) expr1.evaluate(document, XPathConstants.NODE);
                    System.out.println(nodes);
                    if(nodes1!=null)
                    {
                        Node node = document.getDocumentElement();
                        Element selling = document.createElement("selling");
                        node.appendChild(selling);
                        
                        Element booktitle1 = document.createElement("booktitle");
                        booktitle1.appendChild(document.createTextNode(booktitle));
                        selling.appendChild(booktitle1);
                        
                        
                        Element useremail1 = document.createElement("useremail");
                        useremail1.appendChild(document.createTextNode(String.valueOf(useremail)));
                        selling.appendChild(useremail1);
                        
                        Element amount1 = document.createElement("amount");
                        amount1.appendChild(document.createTextNode(String.valueOf(amount)));
                        selling.appendChild(amount1);
                        
                        Element data = document.createElement("date");
                        data.appendChild(document.createTextNode(sdf.format(date1)));
                        selling.appendChild(data);

                        //System.out.println();
                        TransformerFactory tff  = TransformerFactory.newInstance();
                        Transformer transformer1 = tff.newTransformer();
                        
                        DOMSource xmlSource = new DOMSource(document);
                        StreamResult outputTarget = new StreamResult("src/data/selling.xml");
                        transformer1.transform(xmlSource, outputTarget);
                        return true;
                    }
                }
                
                System.out.println("Done");
                
            }
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }catch( XPathExpressionException e)
        {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
