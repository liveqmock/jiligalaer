package sy.common.export;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelHandler {
	
	@SuppressWarnings("deprecation")
	private static HSSFCell createCell(HSSFRow row,short index){
		HSSFCell cell = row.createCell(index);
		return cell;
	}
	
	/**创建表头*/
	private static void createHead(HSSFSheet sheet,String[] titleArr){
		HSSFRow row = sheet.createRow((short)0);
		for(int i=0; i<titleArr.length; i++){
			createCell(row, (short)i).setCellValue(titleArr[i]);
		}
	}

	/**创建表格*/	
	private static void createBody(HSSFSheet sheet, List<Object[]> list) {
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow((short)(i+1));
			Object[] obj = list.get(i);
			for(int j=0; j<obj.length; j++){
				createCell(row, (short)j).setCellValue(null==obj[j] ? "" : obj[j].toString());
			}
		}
	}
	
	public static void excelDownLoad(OutputStream fileOut, String[] titleArr, List<Object[]> list){
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			HSSFSheet sheet = wb.createSheet();
			createHead(sheet,titleArr);
			createBody(sheet,list);				
			wb.write(fileOut);
			
		} catch (IOException e) {
			throw new RuntimeException("Excel导出失败!");
		}finally{
			if(fileOut!=null){
				try {fileOut.close();} catch(IOException e) {/*ignore*/}
			}
		}
	}
}
