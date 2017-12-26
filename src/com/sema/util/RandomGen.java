package com.sema.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;


public class RandomGen {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {}


void writeExcelContentToSQlFile(BufferedWriter fw) throws IOException{


	HashMap<String,String[]> masterConfigMap = new HashMap<String,String[]>();
	HashSet<String> idSet= new HashSet<String>();

	try {
		FileInputStream file = new FileInputStream(new File("/home/pradyumnm/Downloads/targetlistgeneslist/master config - controls - validation.xlsx"));

		//Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		String [] records = new String[13];
		int i=0;


		while (rowIterator.hasNext())

		{
			Row row = rowIterator.next();
			//For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			i=0;
			while (cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();
				//Check the cell type and format accordingly
				switch (cell.getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC:
					records[i++]=Double.toString(cell.getNumericCellValue());
					System.out.println(cell.getNumericCellValue());

					break;
				case Cell.CELL_TYPE_STRING:
					records[i++]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());

					break;
				}

			}
			System.out.println("records"+" "+records[0]+" "+records[2]+" "+records[3]);
			idSet.add(records[0]);
			masterConfigMap.put(records[0]+"_"+records[1]+"_"+records[3]+"_"+records[4]+"_"+records[5], records);
		}
		file.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}



	File folder = new File("/home/pradyumnm/Downloads/targetlistgeneslist/");
	File[] listOfFiles = folder.listFiles();
	for (File file : listOfFiles) {
		if (file.isFile()) {
			System.out.println(file.getName());
		}
	}
	String line1="";
	String extension = "";
	String fileSql = "targetSql.txt";
	StringBuffer fileBuff = new StringBuffer("");
	StringBuffer colNameBuff = new StringBuffer("");
	StringBuffer recordBuff = new StringBuffer("");
	HashMap<String,Integer> geneSet = new HashMap<String,Integer>();
	ArrayList<String> runCombIdList = new ArrayList<String>();
	String temp ="";
	String cvsSplitBy = ",";

	//BufferedWriter fw = new BufferedWriter(new FileWriter(fileSql)) ;




	int flag =0;


	colNameBuff.append("INSERT INTO SAMPLE "+ "(");
	colNameBuff.append("lims_sample_id,sample_type) VALUES  ");
	fw.write(colNameBuff.toString());
	for (String s: idSet) {


		if(flag==0) 
		{
			recordBuff.append("(");
			flag=1;
		}
		else
		{fw.write(",");
		fw.newLine();
		recordBuff.append("(");
		}

		recordBuff.append("'"+s+"'"+","+ "'"+"Control"+"'"+ ")");

		fw.write(recordBuff.toString());
		recordBuff.setLength(0);
	}
	fw.write(";");
	fw.newLine();


	colNameBuff.setLength(0);
	recordBuff.setLength(0);
	flag=0;
	for (File file : listOfFiles) {

		if(file.getName().equalsIgnoreCase("master config - controls - validation.xlsx - Sheet1.csv")) {
			System.out.println("writing target file "+file.getName());

			colNameBuff.append("INSERT INTO control_sample_variants_reference "+ "(");
			colNameBuff.append("sample_id,target_name,chromosome,position,ref_allele,alt_allele,gene,cdna_change,protein_change,expected_al,expected_al_start,expected_al_end) VALUES ");
			fw.write(colNameBuff.toString());
			for (String key : masterConfigMap.keySet()) {

				String[] records = masterConfigMap.get(key);
				if(flag==0) 
				{
					recordBuff.append("(");
					flag=1;
				}
				else
				{fw.write(",");
				fw.newLine();
				recordBuff.append("(");
				}
				recordBuff.append( "(select id from sample where lims_sample_id ='"+records[0]+"')");
				recordBuff.append(","+"'"+records[1]+"'");
				recordBuff.append(","+"'"+records[2]+"'");
				recordBuff.append(","+"'"+records[3]+"'");
				recordBuff.append(","+"'"+records[4]+"'");

				recordBuff.append(","+"'"+records[5]+"'");
				recordBuff.append(","+"'"+records[6]+"'");

				recordBuff.append(","+"'"+records[7]+"'");
				recordBuff.append(","+"'"+records[8]+"'");
				recordBuff.append(","+"'"+records[9]+"'");
				recordBuff.append(","+"'"+records[10]+"'");
				recordBuff.append(","+"'"+records[11]+"'"+")");

				fw.write(recordBuff.toString());
				recordBuff.setLength(0);
			}
			fw.write(";");

		}

	}







	fw.close(); 


}

}



