package com.restassuredframework.testutils;


import com.restassuredframework.setup.TestSetUp;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class DataProviderMultiple extends TestSetUp {
    @DataProvider(name="dpmultipletestcasemethod")
    /*@DataProvider(name="dp")*/
	public  Object[][] getData(Method m) {

		System.out.println(configproperties);
		System.out.println("SheetName-->"+configproperties.getSheetName());
		String sheetName=configproperties.getSheetName();
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
	}
}
