/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
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
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author maria
 */
public class books {
    String title;
    String author;
    int year;
    float price;
    String genre;
    int amount;
    
    public books()
    {
        
    }
    
    public books(String title, String author, int year, float price, String genre, int amount) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.genre = genre;
        this.amount = amount;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    public float getPrice() {
        return price;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    //-----------------------------------------------------------Users OP-----------------------------------------------------------------
    //1.---------------SEARCH BY A GENRE---------------------------------------------
    public DefaultTableModel searchByGenre(String genre)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/bookstore.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/bookstore/book[genre='"+genre+"']");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Title", "Author", "Year", "Price", "Genre", "Amount"});
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
                lista.addRow(new Object[]{eElement.getElementsByTagName("title").item(0).getTextContent()+ " ",
                    autor,
                    eElement.getElementsByTagName("year").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("price").item(0).getTextContent()+ " ",
                    categorie,
                    eElement.getElementsByTagName("amount").item(0).getTextContent()+ " "});
                System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(autor);
                System.out.println(eElement.getElementsByTagName("year").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                System.out.println(categorie);
                System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
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
    
    //2.---------------SEARCH BY A TITLE---------------------------------------------
    public DefaultTableModel searchByTitle(String title)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/bookstore.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/bookstore/book[title='"+title+"']");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Title", "Author", "Year", "Price", "Genre", "Amount"});
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
                lista.addRow(new Object[]{eElement.getElementsByTagName("title").item(0).getTextContent()+ " ",
                    autor,
                    eElement.getElementsByTagName("year").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("price").item(0).getTextContent()+ " ",
                    categorie,
                    eElement.getElementsByTagName("amount").item(0).getTextContent()+ " "});
                System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(autor);
                System.out.println(eElement.getElementsByTagName("year").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                System.out.println(categorie);
                System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
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
    //3.---------------SEARCH BY A AUTHOR---------------------------------------------
    public DefaultTableModel searchByAuthor(String author)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/bookstore.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/bookstore/book[author='"+author+"']");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Title", "Author", "Year", "Price", "Genre", "Amount"});
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
                lista.addRow(new Object[]{eElement.getElementsByTagName("title").item(0).getTextContent()+ " ",
                    autor,
                    eElement.getElementsByTagName("year").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("price").item(0).getTextContent()+ " ",
                    categorie,
                    eElement.getElementsByTagName("amount").item(0).getTextContent()+ " "});
                System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(autor);
                System.out.println(Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent())-10);
                System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                System.out.println(categorie);
                System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
                
                /*TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/data/bookstore.xml"));
                transformer.transform(source, result);*/
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
    //4.---------------VIEW ALL BOOKS---------------------------------------------
    public DefaultTableModel viewAllBooks()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/bookstore.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/bookstore/book");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Title", "Author", "Year", "Price", "Genre", "Amount"});
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
                lista.addRow(new Object[]{eElement.getElementsByTagName("title").item(0).getTextContent()+ " ",
                    autor,
                    eElement.getElementsByTagName("year").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("price").item(0).getTextContent()+ " ",
                    categorie,
                    eElement.getElementsByTagName("amount").item(0).getTextContent()+ " "});
                System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(autor);
                System.out.println(Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent())-10);
                System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                System.out.println(categorie);
                System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
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
    //-----------------------------------------------------------Admin OP-----------------------------------------------------------------
    //1.---------------ADD------------------------------------------------
    public boolean ADDBook(books b)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("src/data/bookstore.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//bookstore[book='"+b.getTitle()+"']/bookstore/text()");
            //evaluate expression result on XML document
            Node nodes = (Node) expr.evaluate(document, XPathConstants.NODE);
            System.out.println(nodes);
            if(nodes==null)
            {
                Node node = document.getDocumentElement();
                Element book = document.createElement("book");
                node.appendChild(book);
                
                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(b.getTitle()));
                book.appendChild(title);
                
                Element author = document.createElement("author");
                author.appendChild(document.createTextNode(b.getAuthor()));
                book.appendChild(author);
                
                Element year = document.createElement("year");
                year.appendChild(document.createTextNode(String.valueOf(b.getYear())));
                book.appendChild(year);
                
                Element price = document.createElement("price");
                price.appendChild(document.createTextNode(String.valueOf(b.getPrice())));
                book.appendChild(price);
                
                Element genre = document.createElement("genre");
                genre.appendChild(document.createTextNode(b.getGenre()));
                book.appendChild(genre);
                
                Element amount = document.createElement("amount");
                amount.appendChild(document.createTextNode(String.valueOf(b.getAmount())));
                book.appendChild(amount);
                //System.out.println();
                TransformerFactory tff  = TransformerFactory.newInstance();
                Transformer transformer = tff.newTransformer();
                
                DOMSource xmlSource = new DOMSource(document);
                StreamResult outputTarget = new StreamResult("src/data/bookstore.xml");
                transformer.transform(xmlSource, outputTarget);
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    //2.---------------DELETE---------------------------------------------
    public boolean DELETEBooks(String booktitle)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
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
                
                nNode.removeChild(eElement.getElementsByTagName("title").item(0));
                String autor=new String();
                String categorie=new String();
                int k=0;
                while(eElement.getElementsByTagName("author").item(k)!=null)
                {
                    k++;
                }
                for(int m=0;m<k;m++)  
                {
                    nNode.removeChild(eElement.getElementsByTagName("author").item(0));
                }
                nNode.removeChild(eElement.getElementsByTagName("year").item(0));
                nNode.removeChild(eElement.getElementsByTagName("price").item(0));
                int j=0;
                while(eElement.getElementsByTagName("genre").item(j)!=null)
                {
                    
                    j++;
                }
                for(int l=0; l<j; l++)
                {
                    nNode.removeChild(eElement.getElementsByTagName("genre").item(0));
                    
                }
                nNode.removeChild(eElement.getElementsByTagName("amount").item(0));
                
                
                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/data/bookstore.xml"));
                transformer.transform(source, result);
                System.out.println("Done");
                
                return true;
                
            }
            
            System.out.println("Done");
            
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }catch( XPathExpressionException e)
        {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    //3.---------------UPDATE---------------------------------------------
    public boolean UPDATEBooks(String booktitle, books b)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
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
                
                if(!b.getTitle().equals(""))
                    eElement.getElementsByTagName("title").item(0).setTextContent((b.getTitle()));
                if(!b.getAuthor().equals(""))
                    eElement.getElementsByTagName("author").item(0).setTextContent((b.getAuthor()));
                if(b.getYear()!=0)
                    eElement.getElementsByTagName("year").item(0).setTextContent((String.valueOf(b.getYear())));
                if(b.getPrice()!=-1)
                    eElement.getElementsByTagName("price").item(0).setTextContent((String.valueOf(b.getPrice())));
                if(!b.getGenre().equals(""))
                    eElement.getElementsByTagName("genre").item(0).setTextContent((b.getGenre()));
                if(b.getAmount()!=-1)
                    eElement.getElementsByTagName("amount").item(0).setTextContent((String.valueOf(b.getAmount())));
                
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
                    
                    System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println(autor);
                    System.out.println(eElement.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println(categorie);
                    System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
                    //eElement.getElementsByTagName("amount").item(0).removeChild(eElement.getElementsByTagName("amount").item(0));
                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("src/data/bookstore.xml"));
                    transformer.transform(source, result);
                    System.out.println("Done");
                    
                    return true;
                }
            }
            
            System.out.println("Done");
            
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }catch( XPathExpressionException e)
        {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    //4.---------------Amount 0---------------------------------------------
    public ArrayList<books> zeroAmount()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        ArrayList<books> b=new ArrayList<books>();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/bookstore.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/bookstore/book[amount=0]");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc , XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Title", "Author", "Year", "Price", "Genre", "Amount"});
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
                String title=eElement.getElementsByTagName("title").item(0).getTextContent();
                int an=Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent());
                Float pret=Float.parseFloat(eElement.getElementsByTagName("price").item(0).getTextContent());
                int cantitate=Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent());
                 books e=new books(title,autor,an,pret,categorie,cantitate);
                 b.add(e);
                lista.addRow(new Object[]{eElement.getElementsByTagName("title").item(0).getTextContent()+ " ",
                    autor,
                    eElement.getElementsByTagName("year").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("price").item(0).getTextContent()+ " ",
                    categorie,
                    eElement.getElementsByTagName("amount").item(0).getTextContent()+ " "});
                System.out.println(eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(autor);
                System.out.println(Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent())-10);
                System.out.println(eElement.getElementsByTagName("price").item(0).getTextContent());
                System.out.println(categorie);
                System.out.println(eElement.getElementsByTagName("amount").item(0).getTextContent());
                
                /*TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/data/bookstore.xml"));
                transformer.transform(source, result);*/
            }
            return b;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }catch( XPathExpressionException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}