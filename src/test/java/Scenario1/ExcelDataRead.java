package Scenario1;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRead {
	@Test
	public void dataFromFile() throws IOException {

		File f1=new File(System.getProperty("user.dir")+"//TestData//data.xlsx");
		FileInputStream fs = new FileInputStream(f1);

		XSSFWorkbook wb =new XSSFWorkbook(fs);

		//number of rows
		int rows = wb.getSheet("userdata").getPhysicalNumberOfRows();
		System.out.println("The number of rows are:"+rows);

		//number of cells
		int cells = wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
		System.out.println("The number of cells are:"+cells);

		//create array as per size of a file
		Object data[][] = new Object[rows][cells];  //3,2

		for(int i=0;i<rows;i++) 
		{

			for(int j=0;j<cells;j++)
			{
				data[i][j]= wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}


	}
}

