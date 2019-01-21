package PatientDetails;
import utility.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.corba.se.impl.util.Utility;
import com.sun.rowset.internal.Row;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class Upload extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	
			throws IOException 
			{
		PrintWriter out = response.getWriter();
		try {
			
			boolean flag11=false;
			boolean flag22=false;
			boolean flag33=false;
			boolean flag7=false;
			boolean flag44=false;
			String fileName = "", root = "", md = "";
			String status; 
			String[] name = new String[2];
			int i = 0;
			File uploadedFile = null;
			File uploadedFile1=null;
			ResultSet rs = null;
			boolean flag = false;
			boolean flag_upload = false;
			RequestDispatcher rd = null;
			Random random = new Random();
			int num, num1 = 0;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);//if it has the report
			String name1=request.getParameter("name");
			System.out.println("value of name1 is  "+name1);
			//String grpname=CommonDAO.getGroupName(name1);

	
			
			
			
	
	if (isMultipart)
	{
		FileItemFactory factory = new DiskFileItemFactory();           //taking into the factory
		ServletFileUpload upload = new ServletFileUpload(factory);    //supports multiple files bcz handles multipart type
		try 
		{
			
			java.util.List items = upload.parseRequest(request);
			java.util.Iterator iterator = items.iterator();
			while (iterator.hasNext())
			{
				FileItem item = (FileItem) iterator.next();
				System.out.println("fileitemis:" + item);
				if (item.isFormField())
				{
					name[i] = item.getString();
					i++;
				} 
				else 
				{
					fileName = item.getName();
					System.out.println("filename iss" + fileName);
					root = getServletContext().getRealPath("/upload_reviews");
					
					
					uploadedFile = new File(root +"/"+fileName);
					
					System.out.println("Directory name iss" + uploadedFile);
					item.write(uploadedFile);
				}
			}
		}
		
	catch (Exception e) {
	
	}
	}
	
	
		ArrayList data=new ArrayList();
		String memb_code=null;
		String policy_mem_code="AB";
		int row11=0;
		FileInputStream file=null;
		XSSFWorkbook workbook=null;
		int i1=0;
		try
		{
		file = new FileInputStream(new File(root +"/"+fileName));
			 workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			java.util.Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
			for(org.apache.poi.ss.usermodel.Row row : sheet) 
			{
				StringBuffer sb1= new StringBuffer();
         if(i1==0)
					
				{
				
				 row = rowIterator.next();
				java.util.Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();//assigning cells
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
							break;
						case Cell.CELL_TYPE_STRING:
							break;
					}
				}
				i1=1;	
			  }
               else{
				   for(int cn=0; cn<7; cn++) 
				   {
				       
				       Cell cell = row.getCell(cn, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);//creating row with cell blank//Create cell to force as BLANK when NULL
				       // Print the cell for debugging
				       System.out.println("CELL: " + cn + " --> " + cell.toString());
				       
				       if (cn==0||cn==1||cn==2||cn==3||cn==4||cn==5)
				       {
				    	   if(cell.toString().isEmpty())
				    	   {
				    		   sb1.append("null");
				    	   }
				       }
				       sb1.append(cell.toString());
				       sb1.append("~~");
				       
				   }
				   StringBuffer buf = null;
				   String ss=sb1.toString();//add the values to the string
			         System.out.println("||||||||||||||||||||||||||||||||||||||||||||"+ss);
			         String[] splits = ss.split("~~");//matches with the regex
			         
			         String part1 = splits[0]; 
			         String part2 = splits[1]; 
			         String part3 = splits[2];
						String part4 = splits[3];
						String part5 = splits[4];
						System.out.println("==================PART5================"+part5);
						String part6 = splits[5];
						
						 String path=utility.Utility.getPro("path");
						 
						StringBuilder sb = new StringBuilder();//append and insert
     		    	    
	     		    	 
 		    		    BufferedReader br = new BufferedReader(new FileReader(path+part2+".txt"));
 		    		    try {
 		    		        
 		    		    	String line = br.readLine();

 		    		        while (line != null) {
 		    		            sb.append(line);
 		    		            sb.append("\n");
 		    		            line = br.readLine();
 		    		        }
 		    		       
 		    		    }
 		    		    catch(Exception e)
 		    		    {
 		    		    	e.printStackTrace();
 		    		    }
 		    		    finally {
 		    		        br.close();
 		    		    }
 		    		   String rev=sb.toString();
 		    		   String review=sb.toString().replace("'", "");
 		    		  System.out.println("before replacement======="+review);	
 		    		    System.out.println("=================LINE===================="+review);	
						
						
 		    		  try{
 		    		  Class.forName("com.mysql.jdbc.Driver");
 		 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital","root","admin");
 		 			Statement stom=con.createStatement();
 		    		  int rssss=stom.executeUpdate("insert into new_patient values('"+part1+"','"+part2+"','"+part3+"','"+part4+"','"+part5+"','"+part6+"','"+review+"')");
 		    		  if(rssss==1)
 		    		  {
 		    			
 		    			RequestDispatcher sp=request.getRequestDispatcher("nurseData.jsp");
 		    			sp.include(request, response);
 		 
 		    		  }
 		    		  con.close();
 		    		  }
 		    		  
 		    		  
 		   
 		    		  
 		    		  catch (Exception e) {
						e.printStackTrace();
					}
						
						
						

				 
				
               }
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return;
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			}
}