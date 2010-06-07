package com.easymorse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.Logger;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelTest {

	private static final Logger logger = Logger.getLogger(ExcelTest.class);
	
	List<TestBean> list = new ArrayList<TestBean>();
	TestBean testBean = null;

	/**
	 * 读取Excel文件的内容
	 * 
	 * @param file
	 *            待读取的文件
	 * @return
	 */
	public String readExcel(File file) {
		StringBuffer sb = new StringBuffer();

		Workbook wb = null;
		try {
			// 构造Workbook（工作薄）对象
			wb = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (wb == null)
			return null;

		// 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
		Sheet[] sheet = wb.getSheets();

		if (sheet != null && sheet.length > 0) {
			// 对每个工作表进行循环
			for (int i = 0; i < sheet.length; i++) {
				// 得到当前工作表的行数
				int rowNum = sheet[i].getRows();
				for (int j = 1; j < rowNum; j++) {
					// 得到当前行的所有单元格
					Cell[] cells = sheet[i].getRow(j);
					if (cells != null && cells.length > 0) {
						// 对每个单元格进行循环
						testBean = new TestBean();

						for (int k = 0; k < cells.length; k++) {
							// 读取当前单元格的值
							String cellValue = cells[k].getContents();

							testBean.setChName(cells[0].getContents());
							testBean.setEnName(cells[1].getContents());

							logger.debug("_---------" + cellValue
									+ "------------");

						}
						list.add(testBean);
					}

				}

			}
		}
		// 最后关闭资源，释放内存
		wb.close();
		return sb.toString();
	}

	public static void main(String[] args) {
		ExcelTest excelTest = new ExcelTest();
		logger.debug(excelTest.readExcel(new File("my.xls")));
		logger.debug("list size is ----" + excelTest.list.size());
		for(TestBean bean:excelTest.list){
			logger.debug(">>>>"+bean.getChName());
			
			
		}
	}
}
