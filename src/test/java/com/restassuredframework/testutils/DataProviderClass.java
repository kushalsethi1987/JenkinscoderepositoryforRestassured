package com.restassuredframework.testutils;
import java.lang.reflect.Method;
import java.util.Hashtable;
import com.restassuredframework.setup.TestSetUp;
import org.testng.annotations.DataProvider;

public class DataProviderClass extends TestSetUp {
	
	@DataProvider(name="dpsingletestcasemethod")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excelReader.getRowCount(sheetName);//5
		int cols = excelReader.getColumnCount(sheetName);//2

		System.out.println(rows);
		System.out.println(cols);

		Object[][] data = new Object[rows - 1][1];
		//int[] array= new int[1][1];
		//array[0][0]=10

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {//rows=3

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {//cols=2

				table.put(excelReader.getCellData(sheetName, colNum, 1), excelReader.getCellData(sheetName, colNum,rowNum ));
				data[rowNum - 2][0] = table;//{endPoint=/customer,expectedCode=200}
			}

		}
		return data;

		// System.out.println(data); return data;

	}
	

	/*@DataProvider(name="dp")
	public  Object[][] getData(Method m) {

		System.out.println(configProperties);
		System.out.println("SheetName-->"+configProperties.getSheetName());
		String sheetName=configProperties.getSheetName();
		int rows = excelReader.getRowCount(sheetName);//100
		String testName = m.getName();
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excelReader.getCellData(sheetName, 0, testCaseRowNum);
			//System.out.println("TestCase name in excel-->"+testCaseName);
			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}// Checking total rows in test case

		int dataStartRowNum = testCaseRowNum + 2;//dataStartRowNum=8

		int testRows = 0;
		while (!excelReader.getCellData(sheetName, 0, dataStartRowNum + testRows).equals("endOfTestData")) {

			testRows++;
		}
		// Checking total cols in test case

		//System.out.println("Total no of rows:"+testRows);
		int colStartColNum = testCaseRowNum + 1;//7
		int testCols = 0;

		while (!excelReader.getCellData(sheetName, testCols, colStartColNum).equals("")) {

			testCols++;

		}
		//[2][1]
		
		Object[][] data = new Object[testRows][1];
		//object[][] data= new Object[2][1];
		//data[0][0]=
		//data[1][0]=

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

		
			for (int cNum = 0; cNum < testCols; cNum++) {

				String colName = excelReader.getCellData(sheetName, cNum, colStartColNum);
				String testData = excelReader.getCellData(sheetName, cNum, rNum);
				

				table.put(colName, testData);

			}

			data[i][0] = table;
			i++;

		}

		return data;
	}*/

}
