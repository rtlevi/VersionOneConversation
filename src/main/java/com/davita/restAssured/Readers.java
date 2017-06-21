package com.davita.restAssured;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.davita.config.DataConfig;
import com.davita.config.HostConfiguration;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.RandomAccess;



public class Readers extends HostConfiguration{
	
	public static Response response;
    public static String xmlAsString;
	
	
	 
	  @DataProvider(name = "DP1")
	    public Object[][] createData1() throws Exception{
	        Object[][] retObjArr=getTableArray(DataConfig.INPUT_FILE,
	                DataConfig.TABLE_NAME, DataConfig.SHEET_NAME);
	        return(retObjArr);
	    }
	 
	 public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
	        String[][] tabArray=null;

	            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	            Sheet sheet = workbook.getSheet(sheetName); 
	            int startRow,startCol, endRow, endCol,ci,cj;
	            Cell tableStart=sheet.findCell(tableName);
	            startRow=tableStart.getRow();
	            startCol=tableStart.getColumn();

	            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

	            endRow=tableEnd.getRow();
	            endCol=tableEnd.getColumn();
	            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
	                    "startCol="+startCol+", endCol="+endCol);
	            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
	            ci=0;

	            for (int i=startRow+1;i<endRow;i++,ci++){
	                cj=0;
	                for (int j=startCol+1;j<endCol;j++,cj++){
	                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
	                }
	            }


	        return(tabArray);
	    }

	
	
	public static Document stringToDocument(final String xmlString)
		    throws SAXException, ParserConfigurationException, IOException {

		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    factory.setNamespaceAware(true);
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document document = builder.parse(new InputSource(new StringReader(xmlString)));

		    return document;
		}
	
	private void printlnCommon(Node n) {
		System.out.print(" nodeName=\"" + n.getNodeName() + "\"");

	    String val = n.getNamespaceURI();
	    if (val != null) {
	    	System.out.print(" uri=\"" + val + "\"");
	    }

	    val = n.getPrefix();

	    if (val != null) {
	    	System.out.print(" pre=\"" + val + "\"");
	    }

	    val = n.getLocalName();
	    if (val != null) {
	    	System.out.print(" local=\"" + val + "\"");
	    }

	    val = n.getNodeValue();
	    if (val != null) {
	    	System.out.print(" nodeValue=");
	        if (val.trim().equals("")) {
	            // Whitespace
	        	System.out.print("[WS]");
	        }
	        else {
	        	System.out.print("\"" + n.getNodeValue() + "\"");
	        }
	    }
	    System.out.println();
	}

	 @Test(dataProvider = "DP1")
     public void getUserConversation(String id) throws Exception {
		 
		if (id.contains("B")){
		 response =
         given().auth()
         .preemptive().basic(AuthUserName, AuthPassWord)
         .when().get(HostServerpreStory+id+HostServerpost)
         .then()
         .contentType(ContentType.XML)
         .extract().response();
        // .statusCode(200);
		}else if (id.contains("TK")){
			 response =
			         given().auth()
			         .preemptive().basic(AuthUserName, AuthPassWord)
			         .when().get(HostServerpreTask+id+HostServerpost)
			         .then()
			         .contentType(ContentType.XML)
			         .extract().response();
		}else if (id.contains("D")){
			 response =
			         given().auth()
			         .preemptive().basic(AuthUserName, AuthPassWord)
			         .when().get(HostServerpreDefect+id+HostServerpost)
			         .then()
			         .contentType(ContentType.XML)
			         .extract().response();
		}else if (id.contains("AT")){
			 response =
			         given().auth()
			         .preemptive().basic(AuthUserName, AuthPassWord)
			         .when().get(HostServerpreTest+id+HostServerpost)
			         .then()
			         .contentType(ContentType.XML)
			         .extract().response();
		}else if (id.contains("E")){
			 response =
			         given().auth()
			         .preemptive().basic(AuthUserName, AuthPassWord)
			         .when().get(HostServerpreEpic+id+HostServerpost)
			         .then()
			         .contentType(ContentType.XML)
			         .extract().response();
		}
		 
		 xmlAsString = response.asString();
		 Document document=stringToDocument(xmlAsString);
	//XPath xPath =XPathFactory.newInstance().newXPath();
		 Element docEle = document.getDocumentElement();	
	     NodeList nl = docEle.getChildNodes();
	     Node n=null;
	     Element eElement=null;
	     
	     for (int i = 0; i < nl.getLength(); i++) {           
	    	  //System.out.println(nl.getLength());     
	    	  n= nl.item(i);                            
	    	  //System.out.println("\nCurrent Element :" + n.getNodeName());
	    	  	

	    	  if (n.getNodeType() == Node.ELEMENT_NODE) {
	    		//  printlnCommon(n);
	    	    eElement = (Element) n.getChildNodes();
	    	    //System.out.println("\nCurrent Element :" + n.getNodeName());
	   
	    	//    String name = eElement.getElementsByTagName("Attribute").item(i).getTextContent(); //here throws null pointer exception after printing staff1 tag
	    	 //   System.out.println(name);
	    	    
	    	    
	    	    
	    	    if (eElement.getNodeName().equals("Asset")) {
                    String Attribute = eElement.getElementsByTagName("Attribute").item(0).getTextContent();
                    String AuthoredAt = eElement.getElementsByTagName("Attribute").item(1).getTextContent();
                    String BelongsToChangeDate = eElement.getElementsByTagName("Attribute").item(2).getTextContent();
                    
                    String AuthorName = eElement.getElementsByTagName("Attribute").item(3).getTextContent();
                    String AuthorNickname = eElement.getElementsByTagName("Attribute").item(4).getTextContent();
                                        
                    System.out.println(AuthorName);
                    System.out.println(BelongsToChangeDate);
                    System.out.println(Attribute);
                    
                    String texToWriteInFile = AuthorName+" , "+BelongsToChangeDate+" , "+Attribute;
                    
                    MyCsvFile.WriteToCsvFile(id, texToWriteInFile);
        

                }
	    	    
	    	  }
	    	  
	    	  n.getNextSibling();
	    	}		 

     }
	 
	 
	 
	

}
