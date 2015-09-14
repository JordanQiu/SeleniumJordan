package dataDriver;

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class ExcelDataProvider implements Iterator<Map> {
	
	private Workbook workBook;
	private Sheet sheet;
	private int rowNum;
	private int columnNum;
	private int curRowNum;
	private String[] columnName;
	
	public ExcelDataProvider(String fileName,String sheetName) {
		//String fileName="F:\\Jordan\\git reposi\\SeleniumTest-master\\cdp\\src\\test\\java\\resource\\CloudData.xls";
		File  directory = new File(fileName);
		try {
			workBook = Workbook.getWorkbook(directory);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    sheet =workBook.getSheet(sheetName);
	    rowNum = sheet.getRows();
		columnNum =sheet.getColumns();
		Cell[] cl=sheet.getRow(0);
		columnName = new String[cl.length];
		for(int i=0;i<cl.length;i++){
		columnName[i] = cl[i].getContents();
		System.out.println(columnName[i]);
		}
		this.curRowNum++;
		
	}

	public boolean hasNext() {
		if(this.curRowNum>this.rowNum||this.rowNum==0){
			return false;
		}
		return true;
	}

	public Map next() {
		String temp;
	Cell[] cl =sheet.getRow(this.curRowNum);
	Map columnValue = new HashMap<String,String>();
	for(int i=0;i<cl.length;i++){
		 temp=cl[i].getContents().toString();
	columnValue.put(columnName[i], temp);
	}
//	Object[] r = new Object[1];
//	r[0]=columnValue;
	
	this.curRowNum++;
		return columnValue;
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

	
}
