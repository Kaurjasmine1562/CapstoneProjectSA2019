package Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	XSSFWorkbook wb;

	@DataProvider(name="excelfile")
	public Object [][] DataRead() {

		File f1=new File(System.getProperty("user.dir")+"//TestData//data.xlsx");
		FileInputStream fs;
		Object data[][] = null;
		try {
			fs = new FileInputStream(f1);
			wb =new XSSFWorkbook(fs);

			//number of rows
			int rows = wb.getSheet("userdata").getPhysicalNumberOfRows();
			System.out.println("The number of rows are:"+rows);

			//number of cells
			int cells = wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
			System.out.println("The number of cells are:"+cells);


			//create array as per size of a file
			data = new Object[rows][cells];

			for(int i=0;i<rows;i++) 
			{

				for(int j=0;j<cells;j++)
				{
					data[i][j]= wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         return data;
	}
}
