package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;//inbuilt class- to input an external excel file from outside
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String getStringData(int a,int b, String sheetName) throws IOException 
	{
		f=new FileInputStream("C:\\Users\\Maria\\git\\GroceryApplication\\GroceryApplication\\src\\test\\resources\\TestData.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheetName);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	public static String getIntegerData(int a,int b, String sheetName) throws IOException 
	{
		f=new FileInputStream("C:\\Users\\Maria\\git\\GroceryApplication\\GroceryApplication\\src\\test\\resources\\TestData.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheetName);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		int y=(int) c.getNumericCellValue();//type casting
		return String.valueOf(y);
	}


}
