package utilities;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.Sheet;
import jxl.Cell;
import jxl.write.*;
import jxl.LabelCell;
import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.IOException;

		public class validation {
			//String data=null;
			String p;
			 String data;
		     File f;
		    Workbook b;
		 //   Workbook bk;
		    WritableWorkbook wwbCopy;
		 public File open(String path) {
			//open the excel file
			p=path;
			  f=new File(p);
			return (f);
		     }
		public String readexcel(int x,int y) throws BiffException, IOException {
			 b=Workbook.getWorkbook(f);
		    Sheet s=  b.getSheet(2);
		      Cell c=s.getCell(x,y );
		     data= c.getContents();
		      b.close();
			return(data);
		}
		public void writexcel(String sheetname,int x,int y,String content) throws BiffException, IOException {
			//b = Workbook.getWorkbook(new File("c:\\corestake\\demoexl.xls"));
		    b=Workbook.getWorkbook(f);
			wwbCopy = Workbook.createWorkbook(f, b);
		  //  Sheet shSheet = wwbCopy.getSheet(1);
			WritableSheet wshTemp = wwbCopy.getSheet("Test case");
		     Label labTemp = new Label(x, y, content);
		             
		         
		     try {
		         wshTemp.addCell(labTemp);
		          
		         // Closing the writable work book
		         wwbCopy.write();
		         wwbCopy.close();

		         // Closing the original work book
		         b.close();
		     } catch (Exception e)

		     {
		         e.printStackTrace();
		     }
		 

		     
		    
		}
		/*public void closexl() {
			
			 bk.close();
		}*/
				 
		

	}

