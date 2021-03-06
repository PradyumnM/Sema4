package com.sema.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RandomGen {

	public static void main(String[] args) {}


void writeExcelContentToSQlFile(BufferedWriter fw, String type) throws IOException{


	HashMap<String,String[]> masterConfigMap = new HashMap<String,String[]>();
	HashSet<String> idSet= new HashSet<String>();

	try {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("config.properties");
		prop.load(input);
		String controlSampleFileName = prop.getProperty("controlsamplefileName");
		File folder = new File(prop.getProperty("filedir"));
		FileInputStream file = new FileInputStream(new File(folder+"/"+controlSampleFileName));

		//Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		
		int i=0;

int flag=0;
		while (rowIterator.hasNext())

		{String [] records = new String[13];
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
				case Cell.CELL_TYPE_BLANK:
					records[i++]=null;
					break;
				}

			}
			
			
			if(flag==1)
			{
				System.out.println("records"+" "+records[0]+" "+records[2]+" "+records[3]);
				idSet.add(records[0]);
			masterConfigMap.put(records[0]+"_"+records[1]+"_"+records[3]+"_"+records[4]+"_"+records[5], records);
		//	System.out.println("recordsFull"+records);
			}
			flag=1;
		}
		file.close();
		workbook.close();
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
	
	StringBuffer colNameBuff = new StringBuffer("");
	StringBuffer recordBuff = new StringBuffer("");


	//BufferedWriter fw = new BufferedWriter(new FileWriter(fileSql)) ;




	int flag =0;


	colNameBuff.append("INSERT INTO sample "+ "(");
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

		recordBuff.append("'"+s+"'"+","+ "'"+type+"'"+ ")");

		fw.write(recordBuff.toString());
		recordBuff.setLength(0);
	}
	fw.write(";");
	fw.newLine();


	colNameBuff.setLength(0);
	recordBuff.setLength(0);
	flag=0;
	

			colNameBuff.append("INSERT INTO control_sample_variants_reference "+ "(");
			colNameBuff.append("sample_id,target_name,chromosome,position,ref_allele,alt_allele,gene,cdna_change,protein_change,expected_al,expected_al_start,expected_al_end) VALUES ");
			fw.write(colNameBuff.toString());
			String s="";
			for (String key : masterConfigMap.keySet()) {
				//System.out.println("Key"+key);
				
				String[] records = masterConfigMap.get(key);
			//	System.out.println("records"+" "+records[0]+" "+records[2]+" "+records[3]);
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
				
				recordBuff.append(","+"'"+records[3].replaceAll(",", "")+"'");
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



