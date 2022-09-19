package utilities;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;

public class invalidLogin {

	public void nullPassword() throws BiffException, IOException{
	
		validation v=new validation();
	    v.open("C:\\Users\\Archana J\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestData.xls");
	    String baseURI = v.readexcel(1,1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = v.readexcel(7,14);
	    System.out.println(endpoint);
	    
	    
	    
	    String Email=v.readexcel(4, 14) ;
	     System.out.println(Email);
	     String jsonString = "{\n"
                  + "\"email\": \""+ Email + "\"\n"
                  + "}";
	     RequestSpecification requestSpecification= RestAssured.given();
         requestSpecification.contentType(ContentType.JSON);
         requestSpecification.body(jsonString);
         Response response1 = requestSpecification.post(endpoint);
         System.out.println(response1.getStatusCode());
         String responsestring = response1.asPrettyString();
         System.out.println(responsestring);
         if(response1.statusCode()==400)
         {
       	  v.writexcel("Test case",11, 17, "Passed");
         }
         else
         {
       	 v.writexcel("Test case",11, 17, "Failed");
         }
	}
	public void incorrectPassword() throws BiffException, IOException{
		validation v=new validation();
	    v.open("C:\\Users\\Archana J\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestData.xls");
	    String baseURI = v.readexcel(1,1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = v.readexcel(7,16);
	    System.out.println(endpoint);
	     String Email=v.readexcel(4, 16) ;
	     System.out.println(Email);
	     String password=v.readexcel(5, 16) ;
	     System.out.println(password);
	
	     
	      String jsonString = "{\n"
	                + "    \"email\": \""+ Email +"\",\n"
	                + "    \"password\": \""+ password + "\"\n"
	                + "}";
	      RequestSpecification requestSpecification= RestAssured.given();
          requestSpecification.contentType(ContentType.JSON);
          requestSpecification.body(jsonString);
          Response response1 = requestSpecification.post(endpoint);
          System.out.println(response1.getStatusCode());
          String responsestring = response1.asPrettyString();
          System.out.println(responsestring);
          if(response1.statusCode()==400)
          {
        	  v.writexcel("Test case",11, 23, "Passed");
          }
          else
          {
        	  v.writexcel("Test case",11, 23, "Failed");
          }
	}
          
          public void nullUsername() throws BiffException, IOException{
      		validation v=new validation();
      	    v.open("C:\\Users\\Archana J\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestData.xls");
      	    String baseURI = v.readexcel(1,1);
      	    RestAssured.baseURI = baseURI;
      	    String endpoint = v.readexcel(7,17);
      	    System.out.println(endpoint);
	        String password=v.readexcel(5, 17) ;
	        System.out.println(password);
	        String jsonString = "{\n"
	               + "    \"password\": \""+ password + "\"\n"
	                + "}";
	          RequestSpecification requestSpecification= RestAssured.given();
	          requestSpecification.contentType(ContentType.JSON);
	          requestSpecification.body(jsonString);
	          Response response1 = requestSpecification.post(endpoint);
	          System.out.println(response1.getStatusCode());
	          String responsestring = response1.asPrettyString();
	          System.out.println(responsestring);
	          
	          if(response1.statusCode()==400)
	          {
	        	  v.writexcel("Test case",11, 22, "Passed");
	          }
	          else
	          {
	        	  v.writexcel("Test case",11, 22, "Failed");
	          }
	          

	}

}
