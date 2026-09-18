package practiceExercises;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllDataFromExcel {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("./src/test/resources/exerciseSheets.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Valuation_Sheet");
		int lastRowNum = sh.getLastRowNum();	
		
		
		String targetTC = "Tc_100";
		
		for(int i = 1; i<=lastRowNum; i++) {
			
			if(sh.getRow(i).getCell(0).toString().equalsIgnoreCase(targetTC)){
				int lastCellNum = sh.getRow(i).getLastCellNum();
				for(int j=0;j<lastCellNum;j++)
					System.out.print(sh.getRow(i).getCell(j).toString()+" ");
				System.out.println();
			}
		}
		
		System.out.println("Invalid Input");	

	}
}
