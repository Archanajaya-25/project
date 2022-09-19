package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import utilities.invalidLogin;
public class invalidpostLoginTest {
  @Test
  public void f() throws BiffException, IOException {
	  
	  invalidLogin log=new invalidLogin();
	  log.nullPassword();
	  log.incorrectPassword();
	  log.nullUsername();
	  
  }
}
