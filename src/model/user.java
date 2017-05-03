/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import java.io.File;
import java.io.IOException;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author maria
 */
public class user {
    String name;
    String admin;
    String email;
    String pwd;
    
    public user()
    {
        
    }
    
    public user(String name, String admin, String email, String pwd) {
        this.name = name;
        this.admin = admin;
        this.email = email;
        this.pwd = pwd;
    }
    
    
    public String getName() {
        return name;
    }
    
    public String getAdmin() {
        return admin;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    //-----------------------------------------------------------Admin OP-----------------------------------------------------------------
    //1.---------------ADD------------------------------------------------
    public boolean ADDUser(user u)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("src/data/users.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//users[user='"+u.getEmail()+"']/bookstore/text()");
            //evaluate expression result on XML document
            Node nodes = (Node) expr.evaluate(document, XPathConstants.NODE);
            System.out.println(nodes);
            if(nodes==null)
            {
                Node node = document.getDocumentElement();
                Element user = document.createElement("user");
                node.appendChild(user);
                
                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(u.getName()));
                user.appendChild(name);
                
                Element admin = document.createElement("admin");
                admin.appendChild(document.createTextNode(u.getAdmin()));
                user.appendChild(admin);
                
                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(u.getEmail()));
                user.appendChild(email);
                
                Element pwd = document.createElement("pwd");
                pwd.appendChild(document.createTextNode(u.getPwd()));
                user.appendChild(pwd);
                
                //System.out.println();
                TransformerFactory tff  = TransformerFactory.newInstance();
                Transformer transformer = tff.newTransformer();
                
                DOMSource xmlSource = new DOMSource(document);
                StreamResult outputTarget = new StreamResult("src/data/users.xml");
                transformer.transform(xmlSource, outputTarget);
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    //2.---------------DELETE---------------------------------------------
    public boolean DELETEUsers(String email)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
        try {
            
            
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/users.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("/users/user[email='"+email+"']");
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
                
                nNode.removeChild(eElement.getElementsByTagName("name").item(0));
                nNode.removeChild(eElement.getElementsByTagName("email").item(0));
                nNode.removeChild(eElement.getElementsByTagName("admin").item(0));
                nNode.removeChild(eElement.getElementsByTagName("pwd").item(0));
                
                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/data/users.xml"));
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
    public boolean UPDATEUser(String email, user u)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
        try {
            
            
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/users.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("/users/user[email='"+email+"']");
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
                
                if(!u.getName().equals(""))
                    eElement.getElementsByTagName("name").item(0).setTextContent((u.getName()));
                if(!u.getEmail().equals(""))
                    eElement.getElementsByTagName("email").item(0).setTextContent((u.getEmail()));
                if(!u.getAdmin().equals(""))
                    eElement.getElementsByTagName("admin").item(0).setTextContent((u.getAdmin()));
                if(!u.getPwd().equals(""))
                    eElement.getElementsByTagName("pwd").item(0).setTextContent((u.getPwd()));
                System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("email").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("admin").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("pwd").item(0).getTextContent());
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/data/users.xml"));
                transformer.transform(source, result);
                System.out.println("Done");
                
                return true;
            }
        }catch (ParserConfigurationException | SAXException | IOException e) {
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
    //4.--------------------------------VIEW ALL USERS-----------------------
    public DefaultTableModel showAllUsers()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/users.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =
                    xpath.compile("/users/user");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            //System.out.println(nodes.getLength());
            DefaultTableModel lista=new DefaultTableModel(null, new Object[] {"Name", "Email", "Admin"});
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Node nNode = nodes.item(i);
                //System.out.println("1");
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                //System.out.println("1");
                Element eElement = (Element) nNode;
                lista.addRow(new Object[]{eElement.getElementsByTagName("name").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("email").item(0).getTextContent()+ " ",
                    eElement.getElementsByTagName("admin").item(0).getTextContent()+ " "});
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
    
    //-------------------------------LOGIN------------------------------------------------
    public String isUser(String email, String pwd)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        
        try {
            
            
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/data/users.xml");
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            
            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("/users/user[email='"+email+"'] | /users/user[pwd='"+pwd+"']");
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
                System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("email").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("admin").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("pwd").item(0).getTextContent());
                if(eElement.getElementsByTagName("email").item(0).getTextContent().equals(email)&& eElement.getElementsByTagName("pwd").item(0).getTextContent().equals(pwd))
                {
                    if(eElement.getElementsByTagName("admin").item(0).getTextContent().equals("yes"))
                        return "admin";
                    else
                        return "user";
                }
                
                
                /*TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/data/users.xml"));
                transformer.transform(source, result);*/
                
                
            }
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }catch( XPathExpressionException e)
        {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e);
        }
        return "error";
    }
    
}
