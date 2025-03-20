package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
//	public String path = System.getProperty("user.dir") + "\\target\\testData\\UserData.xlsx";
	public String path = System.getProperty("user.dir") + "\\target\\testData\\StoreData.xlsx";

	@DataProvider(name = "Data")
	public String[][] getAllData() throws Exception {

		ExcelUtility excel = new ExcelUtility(path);

		int rownum = excel.getRowCount("Sheet1");
		int cellnum = excel.getCellCount("Sheet1", 1);

		String apidata[][] = new String[rownum][cellnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				apidata[i - 1][j] = excel.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}

	@DataProvider(name = "DeleteData")
	public String[] getDeletionKey() throws Exception {

		ExcelUtility excel = new ExcelUtility(path);

		int rownum = excel.getRowCount("Sheet1");

		String apidata[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {
			apidata[i - 1] = excel.getCellData("Sheet1", i, 0); // Change cell no for username according to excel file
		}

		return apidata;
	}

}
