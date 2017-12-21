package com.sema.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;


public class XLReader {

	public static void main(String[] args) throws IOException {

    	Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("config.properties");
		prop.load(input);

		File folder = new File(prop.getProperty("filedir"));
		String geneCatFile1= prop.getProperty("geneCatFile1");
		String geneCatFile2= prop.getProperty("geneCatFile2");
		String geneCatFile3= prop.getProperty("geneCatFile3");
		String geneCatFile4= prop.getProperty("geneCatFile4");
		
		String geneCatName1= prop.getProperty("geneCatName1");
		String geneCatName2= prop.getProperty("geneCatName2");
		String geneCatName3= prop.getProperty("geneCatName3");
		String geneCatName4= prop.getProperty("geneCatName4");
		File[] listOfFiles = folder.listFiles();
		
		String line1="";
		String extension = "";
		String fileSql = prop.getProperty("fileSql");
		StringBuffer fileBuff = new StringBuffer("");
		StringBuffer colNameBuff = new StringBuffer("");
		StringBuffer recordBuff = new StringBuffer("");
		HashMap<String,String> geneSet = new HashMap<String,String>();
		ArrayList<String> runCombIdList = new ArrayList<String>();
		String temp ="";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileSql)) ;
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(  
					prop.getProperty("database"),prop.getProperty("dbuser"),prop.getProperty("dbpassword")); 
			Statement stmt=con.createStatement();  
			Statement catStmt = con.createStatement();
			Statement geneStmt = con.createStatement();
			ResultSet crs=catStmt.executeQuery("SELECT * FROM genecategory;"); 
			
			for (File file : listOfFiles) {
				if (file.isFile()) {
					int i = file.getName().lastIndexOf('.');
					if (i > 0) {
						extension = file.getName().substring(i+1);
					}


					if(file.getName().substring(0,8).equalsIgnoreCase("geneList")) {
						System.out.println("writing "+file.getName());
						BufferedReader br = new BufferedReader(new FileReader(file));
						while ((line1 = br.readLine()) != null) {
							System.out.println(line1);
							if (file.getName().equalsIgnoreCase(geneCatFile1))
							geneSet.put(line1,geneCatName1);
							if (file.getName().equalsIgnoreCase(geneCatFile2))
								geneSet.put(line1,geneCatName2);
							if (file.getName().equalsIgnoreCase(geneCatFile3))
								geneSet.put(line1,geneCatName3);
							if (file.getName().equalsIgnoreCase(geneCatFile4))
								geneSet.put(line1,geneCatName4);
							/*fileBuff.append(line1);
						fw.write(line1);
						fw.newLine();*/


						}
						br.close();	
					}



				}

			}
//Writing to gene table
			ResultSet rs=stmt.executeQuery("SELECT * FROM run_combination;");  
			while(rs.next())  
			{
			// System.out.println(rs.getInt(1)+"  "+rs.getInt(4)); 
			temp= Integer.toString(rs.getInt(1));
			runCombIdList.add(temp);
			for (String key : geneSet.keySet()) {
			    
				//System.out.println(itr.next());
				fw.write("insert into gene(`name`,`run_combination_id`) values ("+key+","+temp+");");
				fw.newLine();
			}
			} 
//Writing to target table			
			for (File file : listOfFiles) {

				if(file.getName().equalsIgnoreCase("targetList.csv")) {
					System.out.println("writing target file "+file.getName());
					BufferedReader br = new BufferedReader(new FileReader(file));
					colNameBuff.append("INSERT INTO TARGET "+ "(");
					colNameBuff.append(br.readLine()+",run_combination_id)"+" VALUES (");
					while ((line1 = br.readLine()) != null) {

						for(int i=0;i<runCombIdList.size();i++)
						{
							recordBuff.append(colNameBuff);
							recordBuff.append(line1);
							recordBuff.append(","+runCombIdList.get(i)+");");
							fw.write(recordBuff.toString());
							fw.newLine();
							recordBuff.setLength(0);
						}

					}
					br.close();
				}
			}
			
//Writing to GeneGeneCategory 
			ResultSet gst=geneStmt.executeQuery("SELECT * FROM gene;"); 
			int i=1;
			while(gst.next())  
			{
				fw.write("insert into gene_genecategory (`id`,`genecategory_id`,`gene_id`)values ("+ i++ + ","+"(select id from genecategory where category_name='"+ geneSet.get(gst.getString(2))+"')"+ ","+ gst.getInt(1)+");");
				fw.newLine();
			}
			con.close();
			fw.close(); 
		} 
		catch (Exception e) {
			System.out.println(e);
		} 

		/*Target CSV update        

       String csvFile = "/home/pradyumnm/Downloads/targetlistgeneslist/targetList.csv";
       String line = "";
       String cvsSplitBy = ",";
       String fileTarget = "targetNtxt";
       StringBuffer colNameBuff = new StringBuffer("");
       StringBuffer recordBuff = new StringBuffer("");
       BufferedWriter rw = new BufferedWriter(new FileWriter(fileTarget)) ;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	 String columnList []= br.readLine().split(cvsSplitBy);
        	 colNameBuff.append("INSERT INTO target (");
        	 colNameBuff.append(columnList[0]);
        	 int j=0;
        	for(int i=1;i<columnList.length;i++)
        		colNameBuff.append(","+columnList[i]);
        	colNameBuff.append(") VALUES (");
           while ((line = br.readLine()) != null) {

                // use comma as separator
            	recordBuff.append(colNameBuff);
                String[] records = line.split(cvsSplitBy);
                recordBuff.append(records[0]);
            	for(int i=1;i<records.length;i++)
            		recordBuff.append(","+records[i]);

            	recordBuff.append(");");


            	rw.write(recordBuff.toString());
            	rw.newLine();

            	recordBuff.setLength(0);
            }
            System.out.print(j);
            rw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // workbook.close();
        inputStream.close();
		 */
		
//-------------------------------------Excel reading 
		/*       String excelFilePath = "depth_config_stats.xlsx";
        String fileName = "filename.sql";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)) ;
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        //System.out.print(cell.getStringCellValue());
                    	bw.write(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
		 */
	}



}

