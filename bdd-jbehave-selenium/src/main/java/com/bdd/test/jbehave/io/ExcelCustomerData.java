package com.bdd.test.jbehave.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelCustomerData {

	public ExcelCustomerData() {
		// TODO Auto-generated constructor stub

	}

	public List<String> getColumnFromExcelSheet(String filePath, int sheetNumber, int columnNumber) {

		List<String> columnDataList = new ArrayList<String>();
		String cellData = null;

		try {

			FileInputStream file = new FileInputStream(new File(filePath));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
			DataFormatter formatter = new DataFormatter(Locale.US);
			System.out.println(sheet.getLastRowNum());

			for (int rowCounter = 1; rowCounter <= 500; rowCounter++) {
				try {
					cellData = formatter.formatCellValue(sheet.getRow(rowCounter).getCell(columnNumber));
					columnDataList.add(cellData);

				}

				catch (NullPointerException npe) {

					System.out.println("reached to the Row which has no data (NULL Row)");
					break;

				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return columnDataList;
	}
}
