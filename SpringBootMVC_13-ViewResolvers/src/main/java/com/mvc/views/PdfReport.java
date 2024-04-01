package com.mvc.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.mvc.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@Component("pdf_report")
public class PdfReport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
									HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Get model attribute data
		List<Employee> empList = (List<Employee>) model.get("empList");
		
		//Add header to the report
		Paragraph header = new Paragraph("Employee Report");
		header.setAlignment("CENTER");
		header.setFont(new Font(Font.COURIER, 15, Font.BOLD, Color.RED));
		
		//Add table content
		Table table = new Table(6, empList.size());
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("EMAIL");
		table.addCell("HIRE-DATE");
		table.addCell("DDESIGNATION");
		table.addCell("SALARY");
		
		for(Employee emp : empList) {
			table.addCell(emp.getId().toString());
			table.addCell(emp.getName());
			table.addCell(emp.getEmail());
			table.addCell(emp.getHireDate().toString());
			table.addCell(emp.getJob());
			table.addCell(emp.getSalary().toString());
		}
		
		//Add the content to the Document object
		document.add(header);
		document.add(table);
		
	}

}
