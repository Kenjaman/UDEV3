package fr.spoonless.jasper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class Application {
	
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("personnes.jrxml");
		JasperReport report = JasperCompileManager.compileReport(in);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("AUTEUR", "David Gayerie");
		JRCsvDataSource dataSource = new JRCsvDataSource("personnes.csv");
		dataSource.setUseFirstRowAsHeader(true);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
		
		JRPdfExporter pdfExporter = new JRPdfExporter();
		pdfExporter.setExporterInput(new SimpleExporterInput(print));
		pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput("rapport.pdf"));
		pdfExporter.exportReport();
	}

}
