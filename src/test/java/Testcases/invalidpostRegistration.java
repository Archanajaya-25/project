package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.Workbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.validation;
public class invalidpostRegistration {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	  
	  validation v=new validation();
	    v.open("C:\\Users\\Archana J\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestData.xls");
	    String baseURI = v.readexcel(1,1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = v.readexcel(7,12);
	    System.out.println(endpoint);
	     String Email=v.readexcel(4, 12) ;
	     System.out.println(Email);
	   
	      /*Cell c4 = sheet.getCell(5, 12);
	      String Password = c4.getContents();
	      System.out.println("Password: "+Password);*/
	      String jsonString =  "{\n"
                  + "    \"email\": \""+ Email + "\"\n"
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
        	  v.writexcel("Test case",11, 15, "Passed");
          }
          else
          {
        	  v.writexcel("Test case",11, 15, "Failed");
          }
	      
	      
	    		  
	      
	      
	      
	 

  }
}
