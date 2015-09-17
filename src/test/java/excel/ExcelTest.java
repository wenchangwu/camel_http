package excel;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class ExcelTest {

	@Test
	public void testExcelDiff() throws Exception{
		InputStream is = new FileInputStream("F:\\1.xls");
		InputStream is2 = new FileInputStream("F:\\2.xls");
		FileWriter fileWriter =null;
		try {
			
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			List<String> list1 = new ArrayList<String>();

			// 循环工作表Sheet
			for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
				if (hssfSheet == null) {
					continue;
				}
				// 循环行Row
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow != null) {
						HSSFCell loginname = hssfRow.getCell(0);
						list1.add(loginname.toString());
					}
				}
			}

			
			HSSFWorkbook hssfWorkbook2 = new HSSFWorkbook(is2);
			List<String> list2 = new ArrayList<String>();
			for (int numSheet = 0; numSheet < hssfWorkbook2.getNumberOfSheets(); numSheet++) {
				HSSFSheet hssfSheet = hssfWorkbook2.getSheetAt(numSheet);
				if (hssfSheet == null) {
					continue;
				}
				// 循环行Row
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow != null) {
						HSSFCell loginname = hssfRow.getCell(0);
						list2.add(loginname.toString());
					}
				}
			}

			is.close();
			is2.close();
			fileWriter = new FileWriter("f:\\Result.txt");

			List<String> list3=new ArrayList<String>();
			for (String l2 : list2) {
				if (list1.contains(l2)) {
				} else {
					if(!list3.contains(l2)){
						list3.add(l2);
						fileWriter.write(l2+"\r\n");	
					}
				}
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {

		} finally {
			is.close();
			is2.close();
			fileWriter.close();
		}
	}
		
}
