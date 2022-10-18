/**
 * 
 */
package com.mypro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author DELL
 *
 */
public class FileLib {
	/*String path="";
	
	public String getDataRowProperties(String key) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
	}*/
	
	public String [][] getExcelData(String ExcelPath, String Sheet) throws EncryptedDocumentException, IOException{
		FileInputStream fs=new FileInputStream(ExcelPath);
		Workbook w=WorkbookFactory.create(fs);
		Sheet s=w.getSheet(Sheet);
		int rows=s.getLastRowNum();
		int columns=s.getRow(1).getLastCellNum();
		String [][] tab=new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tab[i][j]=s.getRow(i).getCell(j).toString();
			}
		}
		return tab;
	}
	
	

}
