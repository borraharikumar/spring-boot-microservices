package com.mvc.views;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.mvc.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@Component("excel_report")
public class ExcelReport extends AbstractXlsView {
	
	private Integer i = 1;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
									  HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Get model attributes data
		List<Employee> empList = (List<Employee>)model.get("empList");
		
		//Create excel sheet in work
		Sheet sheet = workbook.createSheet("Employee");
		
		//Style header row
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontName("Courier new");
		font.setColor(Font.COLOR_RED);
		cellStyle.setFont(font);
		
		//Create Header to Employee sheet
		Row header = sheet.createRow(0);
		header.setRowStyle(cellStyle);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("NAME");
		header.createCell(2).setCellValue("EMAIL");
		header.createCell(3).setCellValue("HIRE DATE");
		header.createCell(4).setCellValue("DESIGNATION");
		header.createCell(5).setCellValue("SALARY");
		
		empList.forEach(emp->{
			//Add row to excel sheet
			Row row = sheet.createRow(i);
			//Add cells to the row
			row.createCell(0).setCellValue(emp.getId());
			row.createCell(1).setCellValue(emp.getName());
			row.createCell(2).setCellValue(emp.getEmail());
			row.createCell(3).setCellValue(emp.getHireDate());
			row.createCell(4).setCellValue(emp.getJob());
			row.createCell(5).setCellValue(emp.getSalary());
			i++;
		});
	}

}
