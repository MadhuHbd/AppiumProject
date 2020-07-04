package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class AmazonDataprovider {

	@DataProvider(name="TS_BookProduct")
	public static Object[][] RetailerPageVerificationByFSR() throws Throwable
	{
		Object[][] obj = getData("PurchaseProduct");
		return obj;
	}
	
	/**
	 * getData(String SheetName): Reads test data supplied from excel sheet for test case run
	 * @param SheetName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static HashMap<String, String>[][] getData(String SheetName) 
	{
		HashMap[][] myEntries = null;
		try 
		{
			
//			File fileName=new File(CommonUtils.getPresentWorkingDir()+ File.separator +"testdata.fileName");
//			InputStream input = new FileInputStream(fileName);
			
			System.out.println("Reading test data from xl : sheet name : "+SheetName);
			File dataDir = new File(".");
		     File data = new File(dataDir.getParent(), "Data" + File.separator + "TestData.xlsx");
		     System.out.println(data.getAbsolutePath());;
			InputStream input = new FileInputStream(data.getAbsolutePath());
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheet(SheetName);

			int NoOfRows = sheet.getLastRowNum();
			ArrayList<Object> arrayList = new ArrayList<Object>();

			XSSFRow rowpointer = null;
			XSSFRow rowpointer2 = null;

			for (int row = 2; row <= NoOfRows; row++)
			{
				rowpointer = sheet.getRow(row);
				XSSFCell value = rowpointer.getCell(0);
				//value.setCellType(0);
				int RunValue = (int)value.getNumericCellValue();

				if (RunValue != 1)
					continue;
				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
				for (int col = 1; col <= rowpointer.getLastCellNum() - 1; col++)
				{
					XSSFCell Fvalue = rowpointer.getCell(col);
					//Fvalue.setCellType(1);
					System.out.println(Fvalue);
					
					String FieldValue = Fvalue.getStringCellValue();;
					rowpointer2 = sheet.getRow(1);
					XSSFCell FName = rowpointer2.getCell(col);
					//FName.setCellType(1);

					String FieldName = FName.getStringCellValue();
					FieldName = FieldName.replaceAll("\\s{1,}", "");

					/* if ((FieldValue != null) && (FieldValue != "") && (!FieldValue.isEmpty())) {
		      map.put(FieldName, FieldValue);
		    }*/

					if (FieldValue != null) {
						map.put(FieldName, FieldValue);
					}
				}

				arrayList.add(map);
			}

			myEntries = new HashMap[arrayList.size()][1];
			for (int i = 0; i < arrayList.size(); i++) {
				myEntries[i][0] = ((HashMap)arrayList.get(i));
			}
			wb.close();
		} catch (Exception e) {
			System.out.println("Exception in testdataprovider, getdata() "+e.getLocalizedMessage());
		}
		return myEntries;
	}
}
