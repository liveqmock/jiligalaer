package sy.common.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


public class ExcelUtil {
	
	/**
	 * 表格头样式（水平居左）
	 */
	public static HSSFCellStyle cellStyleHeaderLeft(HSSFWorkbook workbook) {
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);  // 水平居左
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);	// 垂直居中
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);// 设置背景色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	// 设置填充模式
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		
		return cellStyle;
	}

	/**
	 * 表格头样式（水平居中）
	 */
	public static HSSFCellStyle cellStyleHeaderCenter(HSSFWorkbook workbook) {
		
		HSSFCellStyle cellStyle = cellStyleHeaderLeft(workbook);
		
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  // 水平居中
		
		return cellStyle;
	}

	/**
	 * 表格主体样式（水平居左）
	 */
	public static HSSFCellStyle cellStyleBodyLeft(HSSFWorkbook workbook) {
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);  // 水平居左
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);	// 垂直居中
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		cellStyle.setWrapText(true); 
		
		return cellStyle;
	}

	/**
	 * 表格主体样式（水平居中）
	 */
	public static HSSFCellStyle cellStyleBodyCenter(HSSFWorkbook workbook) {
		
		HSSFCellStyle cellStyle = cellStyleBodyLeft(workbook);
		
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  // 水平居中
		
		return cellStyle;
	}

	/**
	 * 表格主体样式（水平居右）
	 */
	public static HSSFCellStyle cellStyleBodyRight(HSSFWorkbook workbook) {
		
		HSSFCellStyle cellStyle = cellStyleBodyLeft(workbook);
		
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);  // 水平居右
		
		return cellStyle;
	}
}
