package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.validation;

public class validpostCreate {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	  validation v=new validation();
	    v.open("C:\\Users\\Archana J\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestData.xls");
	    String baseURI = v.readexcel(1,1);
	    RestAssured.baseURI = baseURI;
	    String endpoint = v.readexcel(7,7);
	    System.out.println(endpoint);
	     String name=v.readexcel(2, 7) ;
	     System.out.println(name);
	     String job=v.readexcel(3, 7) ;
	     System.out.println(job);
	      String jsonString = "{\n"
	                + "    \"name\": \""+ name +"\",\n"
	                + "    \"job\": \""+ job + "\"\n"
	                + "}";
	          RequestSpecification requestSpecification= RestAssured.given();
	          requestSpecification.contentType(ContentType.JSON);
	          requestSpecification.body(jsonString);
	          Response response1 = requestSpecification.post(endpoint);
	          System.out.println(response1.getStatusCode());
	          String responsestring = response1.asPrettyString();
	          System.out.println(responsestring);
	          if(response1.statusCode()==201)
	          {
	        	  v.writexcel("Test case",11, 10, "Passed");
	          }
	          else
	          {
	        	  v.writexcel("Test case",11, 10, "Failed");
	          }
	     
	      

  }
}
