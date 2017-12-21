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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;


public class RandomGen {

	public static void main(String[] args) throws IOException {
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




		File folder = new File("/home/pradyumnm/Downloads/targetlistgeneslist/");
		String geneCatFile1= "geneList.hgnc.cds.txt";
		String geneCatFile2= "geneList.hgnc.cnv.txt";
		String geneCatFile3= "geneList.hgnc.fusion.txt";
		String geneCatFile4= "geneList.hgnc.hotspot.txt";
		
		String geneCatName1= "All Coding Exons Sequenced";
		String geneCatName2= "Copy Number Abnnormalities Queried";
		String geneCatName3= "Rearrangements/Fusions Queried";
		String geneCatName4= "Hotspot Regions Sequenced";
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
		
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileSql)) ;
			
			
		

		
			
		for (File file : listOfFiles) {

				if(file.getName().equalsIgnoreCase("master config - controls - validation.xlsx - Sheet1.csv")) {
					System.out.println("writing target file "+file.getName());
					BufferedReader br = new BufferedReader(new FileReader(file));
					line1 = br.readLine();
					colNameBuff.append("INSERT INTO SAMPLE "+ "(");
					colNameBuff.append("lims_sample_id,sample_type) VALUES ( ");
					while ((line1 = br.readLine()) != null) {

						
							recordBuff.append(colNameBuff);
							recordBuff.append("'"+line1.split(cvsSplitBy)[0]+"'"+","+ "'"+"Control"+"'"+ ");");
						
							fw.write(recordBuff.toString());
							fw.newLine();
							recordBuff.setLength(0);
						}
					br.close();
					}
					
				} 
		colNameBuff.setLength(0);
		recordBuff.setLength(0);
			for (File file : listOfFiles) {

				if(file.getName().equalsIgnoreCase("master config - controls - validation.xlsx - Sheet1.csv")) {
					System.out.println("writing target file "+file.getName());
					BufferedReader br = new BufferedReader(new FileReader(file));
					line1 = br.readLine();
					colNameBuff.append("INSERT INTO control_sample_variants_reference "+ "(");
					colNameBuff.append("sample_id,target_name,chromosome,position,ref_allele,alt_allele,gene,cdna_change,protein_change,expected_al,expected_al_start,expected_al_end) VALUES ( ");
					while ((line1 = br.readLine()) != null) {

						 String[] records = line1.split(cvsSplitBy);
							recordBuff.append(colNameBuff);
							recordBuff.append( "(select id from sample where lims_sample_id ='"+records[0]+"')");
							if(records[1].charAt(0)=='"')
							{
								recordBuff.append(","+"'"+records[1].substring(1)+","+records[2].substring(0,records[2].length()-1)+"'");
								recordBuff.append(","+"'"+records[3]+"'");
								recordBuff.append(","+"'"+records[4]+"'");
								recordBuff.append(","+"'"+records[5]+"'");
								
								recordBuff.append(","+"'"+records[6]+"'");
								recordBuff.append(","+"'"+records[7]+"'");
								
								recordBuff.append(","+"'"+records[8]+"'");
								recordBuff.append(","+"'"+records[9]+"'");
								recordBuff.append(","+"'"+records[10]+"'");
								recordBuff.append(","+"'"+records[11]+"'");
								recordBuff.append(","+"'"+records[12]+"'");
							}
							else{recordBuff.append(","+"'"+records[1]+"'");
							recordBuff.append(","+"'"+records[2]+"'");
							recordBuff.append(","+"'"+records[3]+"'");
							recordBuff.append(","+"'"+records[4]+"'");
							
							recordBuff.append(","+"'"+records[5]+"'");
							recordBuff.append(","+"'"+records[6]+"'");
							
							recordBuff.append(","+"'"+records[7]+"'");
							recordBuff.append(","+"'"+records[8]+"'");
							recordBuff.append(","+"'"+records[9]+"'");
							recordBuff.append(","+"'"+records[10]+"'");
							recordBuff.append(","+"'"+records[11]+"'"+");");
							}
							fw.write(recordBuff.toString());
							fw.newLine();
							recordBuff.setLength(0);
						}
					br.close();
					}
					
				}
			
			
			
			
			
		
			
			fw.close(); 
	
		
	}
	



}



