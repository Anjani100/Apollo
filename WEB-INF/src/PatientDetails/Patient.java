package PatientDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Utility;

@SuppressWarnings("serial")
public class Patient extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String review = "";
				String part2 = "";
				try {
					
					boolean flag11=false;
					boolean flag22=false;
					boolean flag33=false;
					boolean flag7=false;
					boolean flag44=false;
					String fileName = "", root = "", md = "";
					String status1; 
					String[] name = new String[2];
					int i3 = 0;
					File uploadedFile = null;
					File uploadedFile1=null;
					ResultSet rs = null;
					boolean flag = false;
					boolean flag_upload = false;
					RequestDispatcher rd = null;
					Random random = new Random();
					int num, num1 = 0;
					boolean isMultipart = ServletFileUpload.isMultipartContent(request);//if it has the report
					String name1=request.getParameter("Username");
					System.out.println("value of name1 is  "+name1);
					//String grpname=CommonDAO.getGroupName(name1);

			
					
					
					
			
			if (isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();           //taking into the  factory
				ServletFileUpload upload = new ServletFileUpload(factory);    //supports multiple files bcz handles multipart type
				try 
				{
					
					List items = upload.parseRequest(request);
					Iterator iterator = items.iterator();
					while (iterator.hasNext())
					{
						FileItem item = (FileItem) iterator.next();
						System.out.println("fileitem is:" + item);
						if (item.isFormField())
						{
							name[i3] = item.getString();
							i3++;
						} 
						else 
						{
							fileName = item.getName();
							System.out.println("filename is " + fileName);
							root = getServletContext().getRealPath("/upload_reviews");
							
							
							uploadedFile = new File(root +"/"+fileName);
							
							System.out.println("Directory name is " + uploadedFile);
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
				int i5=0;
				try
				{
				file = new FileInputStream(new File(root +"/"+fileName));
					 workbook = new XSSFWorkbook(file);

					XSSFSheet sheet = workbook.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.iterator();
					for(Row row : sheet) 
					{
						StringBuffer sb1= new StringBuffer();
		         if(i5==0)
							
						{
						
						 row = rowIterator.next();
						Iterator<Cell> cellIterator = row.cellIterator();
						
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
						i5=1;	
					  }
		               else{
						   for(int cn = 0; cn < 7; cn++) 
						   {
						       
						       Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);//creating row with cell blank//Create cell to force as BLANK when NULL
						       // Print the cell for debuggingCREATE_NULL_AS_BLANK
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
					         part2 = splits[1]; 
					         String part3 = splits[2];
							 String part4 = splits[3];
						  	 String part5 = splits[4];
						  	 System.out.println("==================PART5================"+part5);
						  	 String part6 = splits[5];
								
								 String path=Utility.getPro("path");
								
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
		 		    		   review=sb.toString().replace("'", "");
		 		    		  System.out.println("before replacement======="+review);	
		 		    		    System.out.println("=================LINE===================="+review);	
		               }
					
				String n = part2;
				String d = review;
				FileWriter fw = new FileWriter("C:\\Users\\anjan\\Desktop\\Anjani\\Home\\SQL\\File.txt");
				for(int i11 = 0; i11 < 101; i11++) { 
					fw.write(Integer.toString(i11));
					fw.write("\n");
				}
				fw.close();
				FileReader fr = new FileReader("C:\\Users\\anjan\\Desktop\\Anjani\\Home\\SQL\\File.txt");
				BufferedReader br1 = new BufferedReader(fr);
				String[] numbers = new String[2000];
				String cur_lin;
				int k = 0;
				String s2;
				while((cur_lin = br1.readLine()) != null) {
					s2 = cur_lin.toUpperCase();
					numbers[k] = s2;
					k++;
				}
				StringBuilder builder = new StringBuilder(d);
				String[] words = builder.toString().split("\\s");
				ArrayList<String> wordsList = new ArrayList<String>();
				Set<String> NumberSet = new HashSet<String>();
				ArrayList<String> wordsList1 = new ArrayList<String>();
				Set<String> diseaseSet = new HashSet<String>();
				ArrayList<String> wordsList2 = new ArrayList<String>();
				Set<String> occupationSet = new HashSet<String>();
				for(int j = 0; j < numbers.length; j++) {
					NumberSet.add(numbers[j]);
				}
				int[] number = new int[100];
				int i = 0;
				for(int k1 = 0; k1 < words.length; k1++) {
					System.out.println(words[k1]);
					if(words[k1].equals("zero")) {
						number[i] = 0;
						i = i + 1;
					}
					else if(words[k1].equals("one")) {
						number[i] = 1;
						i = i + 1;
					}
					else if(words[k1].equals("two")) {
						number[i] = 2;
						i = i + 1;
					}
					else if(words[k1].equals("three")) {
						number[i] = 3;
						i = i + 1;
					}
					else if(words[k1].equals("four")) {
						number[i] = 4;
						i = i + 1;
					}
					else if(words[k1].equals("five")) {
						number[i] = 5;
						i = i + 1;
					}
					else if(words[k1].equals("six")) {
						number[i] = 6;
						i = i + 1;
					}
					else if(words[k1].equals("seven")) {
						number[i] = 7;
						i = i + 1;
					}
					else if(words[k1].equals("eight")) {
						number[i] = 8;
						i = i + 1;
					}
					else if(words[k1].equals("nine")) {
						number[i] = 9;
						i = i + 1;
					}
					else if(words[k1].equals("ten")) {
						number[i] = 10;
						i = i + 1;
					}
					else if(words[k1].equals("eleven")) {
						number[i] = 11;
						i = i + 1;
					}
					else if(words[k1].equals("twelve")) {
						number[i] = 12;
						i = i + 1;
					}
					else if(words[k1].equals("thirteen")) {
						number[i] = 13;
						i = i + 1;
					}
					else if(words[k1].equals("fourteen")) {
						number[i] = 14;
						i = i + 1;
					}
					else if(words[k1].equals("fifteen")) {
						number[i] = 15;
						i = i + 1;
					}
					else if(words[k1].equals("sixteen")) {
						number[i] = 16;
						i = i + 1;
					}
					else if(words[k1].equals("seventeen")) {
						number[i] = 17;
						i = i + 1;
					}
					else if(words[k1].equals("eighteen")) {
						number[i] = 18;
						i = i + 1;
					}
					else if(words[k1].equals("nineteen")) {
						number[i] = 19;
						i = i + 1;
					}
					else if(words[k1].equals("twenty")) {
						number[i] = 20;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("thirty")) {
						number[i] = 30;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("fourty")) {
						number[i] = 40;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("fifty")) {
						number[i] = 50;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("sixty")) {
						number[i] = 60;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("seventy")) {
						number[i] = 70;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("eighty")) {
						number[i] = 80;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else if(words[k1].equals("ninety")) {
						number[i] = 90;
						if(words[k1+1].equals("one"))
							number[i] = number[i] + 1;
						else if(words[k1 + 1].equals("two"))
							number[i] = number[i] + 2;
						else if(words[k1 + 1].equals("three"))
							number[i] = number[i] + 3;
						else if(words[k1 + 1].equals("four"))
							number[i] = number[i] + 4;
						else if(words[k1 + 1].equals("five"))
							number[i] = number[i] + 5;
						else if(words[k1 + 1].equals("six"))
							number[i] = number[i] + 6;
						else if(words[k1 + 1].equals("seven"))
							number[i] = number[i] + 7;
						else if(words[k1 + 1].equals("eight"))
							number[i] = number[i] + 8;
						else if(words[k1 + 1].equals("nine"))
							number[i] = number[i] + 9;
						i = i + 1;
					}
					else {
						int a = 5;
					}
				}
				for(String word : words) {
					if(NumberSet.contains(word)){
						number[i] = Integer.parseInt(word);
						i++;
					}	
				}
				int age = 0, mrate = 0, label = 0;
				double intensity = 0.0;
				for(int i1 = 0; i1 < number.length; i1++) {
					if(number[i1] >= 12) {
						age = number[i1];
					}
					else if(number[i1] >=1 && number[i1] < 12) {
						intensity = number[i1] * 6;
						intensity = intensity/7;
						//intensity = Math.round(intensity*100)/100;
						if(intensity >= 1 && intensity <= 1.5)
							mrate = -12;
						else if(intensity > 1.5 && intensity <= 2)
							mrate = -11;
						else if(intensity > 2 && intensity <= 2.5)
							mrate = -10;
						else if(intensity > 2.5 && intensity <= 3)
							mrate = -9;
						else if(intensity > 3 && intensity <= 3.5)
							mrate = -8;
						else if(intensity > 3.5 && intensity <= 4)
							mrate = -7;
						else if(intensity > 4 && intensity <= 4.5)
							mrate = -6;
						else if(intensity > 4.5 && intensity <= 5)
							mrate = -5;
						else if(intensity > 5 && intensity <= 5.5)
							mrate = -4;
						else {
							mrate = -3;
						}
							
					}
				}
				if(mrate > -12)
					label = 1;
				String status = null, respiratory = "None", hlabour = "No";
				int flag1 = 0;
				for(String word : words) {
					if(word.toUpperCase().equals("CURRENTLY")) {
						status = "Current";
						flag1 = 1;
					}
					else if(word.toUpperCase().equals("PREVIOUSLY")) {
						status = "Previous";
						flag1 = 1;
					}
					else if(word.toUpperCase().equals("MODERATE")) {
						respiratory = word;
					}
					else if(word.toUpperCase().equals("MILD")) {
						respiratory = word;
					}
					else if(word.toUpperCase().equals("NONE")) {
						respiratory = word;
					}
					else if(word.toUpperCase().equals("NO HEAVY LABOUR")) {
						hlabour = "No";
					}
					else if(word.toUpperCase().equals("HEAVY")) {
						hlabour = "Yes";
					}
				}
				if(flag1 == 0)
					status = "No Smoking Status";
				String cough = "Not a Problem", mucus = "Normal", breathing = "No", tired = "No", r_infection = "No", c_infection = "No", lips = "Normal";
				for(String word : words) {
					if(word.toUpperCase().equals("SOMETIME"))
						cough = "Sometime";
					else if(word.toUpperCase().equals("REGULAR"))
						cough = "Regular";
					else if(word.toUpperCase().equals("LOW"))
						mucus = "Low";
					else if(word.toUpperCase().equals("MEDIUM"))
						mucus = "Medium";
					else if(word.toUpperCase().equals("HIGH"))
						mucus = "High";
					else if(word.toUpperCase().equals("RANDOM"))
						breathing = "Random";
					else if(word.toUpperCase().equals("ALWAYS"))
						breathing = "Always";
					else if(word.toUpperCase().equals("TIREDNESS")) {
						tired = "Yes";
					}
					else if(word.toUpperCase().equals("NORMAL")) {
						lips = "Normal";
					}
					else if(word.toUpperCase().equals("RED")) {
						lips = "Red";
					}
					else if(word.toUpperCase().equals("PINK")) {
						lips = "Pink";
					}
					else if(word.toUpperCase().equals("BLUE")) {
						lips = "Blue";
					}
				}
				int weight = 0;
				for(int k1 = 0; k1 < words.length - 1; k1++) {
					if(words[k1 + 1].toUpperCase().equals("KG"))
						weight = Integer.parseInt(words[k1]);
					else if(words[k1].toUpperCase().equals("RESPIRATORY") && words[k1 + 1].toUpperCase().equals("INFECTION"))
						r_infection = "Yes";
					else if(words[k1].toUpperCase().equals("CHRONIC") && words[k1 + 1].toUpperCase().equals("INFECTION"))
						c_infection = "Yes";
				}
				String fev = "75-85";
				int Stage = 1;
				if(mrate > -12 && mrate < -9) {
					Stage = 1;
					fev = "75-85";
				}
				if(mrate > -9 & mrate < -7) {
					Stage = 2;
					fev = "50-75";
				}
				if(mrate > -7 && mrate < -4) {
					Stage = 3;
					fev = "30-50";
				}
				if(mrate > -4) {
					Stage = 4;
					fev = "<30";
				}
				System.out.println("Intensity = " + intensity);
				try{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/apollohospital", "root", "admin");
					Statement stm = con.createStatement();
					ResultSet rs1 = stm.executeQuery("select * from tests");
					while(rs1.next()) {
						String ds = rs1.getString(2).toUpperCase();
						diseaseSet.add(ds);
						String occ = rs1.getString(5).toUpperCase();
						occupationSet.add(occ);
					}
					for(int l1 = 0; l1 < words.length - 6; l1++) {
						if(words[l1].toUpperCase().equals("FAMILY")) {
							String wordCompare = words[l1 + 6].toUpperCase();
							if(diseaseSet.contains(wordCompare)) {
								wordsList.add(words[l1 + 6]);
							}
							String wordCompare1 = words[l1 + 2].toUpperCase();
							if(diseaseSet.contains(wordCompare1)) {
								wordsList.add(words[l1 + 2]);
							}
							String wordCompare2 = words[l1 + 3].toUpperCase();
							if(diseaseSet.contains(wordCompare2)) {
								wordsList.add(words[l1 + 3]);
							}
							String wordCompare3 = words[l1 + 4].toUpperCase();
							if(diseaseSet.contains(wordCompare3)) {
								wordsList.add(words[l1 + 4]);
							}
							String wordCompare4 = words[l1 + 5].toUpperCase();
							if(diseaseSet.contains(wordCompare4)) {
								wordsList.add(words[l1 + 5]);
								words[l1 + 5] = "";
							}
						}
					}
					for(int l1 = 0; l1 < words.length - 6; l1++) {
						String wordCompare5 = words[l1].toUpperCase();
						if(diseaseSet.contains(wordCompare5)) {
							wordsList1.add(words[l1]);
						}
					}
					String dsf = "";
					int flag2 = 0;
					for(String word : wordsList) {
						dsf = dsf + word + ";";
						flag2 = 1;
					}
					if(flag2 == 0) {
						dsf = "No Family Diseases Mentioned";
					}
					String ds1 = "";
					int flag3 = 0;
					for(String word : wordsList1) {
						ds1 = ds1 + word + ";";
						flag3 = 1;
					}
					if(flag3 == 0) {
						ds1 = "No Diseases Mentioned";
					}
					for(String word : words) {
						String wordCompare = word.toUpperCase();
						if(occupationSet.contains(wordCompare))
							wordsList2.add(word);
					}
					String oc = "";
					for(String word : wordsList2) {
						oc = oc + word + " ";
					}
					int i1 = stm.executeUpdate("insert into smoker(Name, Age, Intensity, Mortality_Rate, Label) values('"+n+"', '"+age+"', '"+intensity+"', '"+mrate+"', '"+label+"')");
					int i2 = stm.executeUpdate("insert into diagnosis(Name, Age, Smoking_Status, Family_Disease, Occupation, Health_history, Respiratory, Heavy_Labour, Label) values('"+n+"', '"+age+"', '"+status+"', '"+dsf+"', '"+oc+"', '"+ds1+"', '"+respiratory+"', '"+hlabour+"', '"+label+"')");
					int i4 = stm.executeUpdate("insert into stage(Name, Coughing, Mucus, Breathing, Weight, Tiredness, Respiratory_infection, Lips, Chronic_respiratory, FEV_FEC, Stage) values('"+n+"', '"+cough+"', '"+mucus+"', '"+breathing+"', '"+weight+"', '"+tired+"', '"+r_infection+"', '"+lips+"', '"+c_infection+"', '"+fev+"', '"+Stage+"')");
					if(i1 == 1) {
						System.out.print("Data Uploaded Successfully");
						RequestDispatcher rd1 = request.getRequestDispatcher("Home_Page.jsp");
						rd1.forward(request, response);
					}
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				}
				catch(Exception e) {
					System.out.println(e);
				}
	}
}