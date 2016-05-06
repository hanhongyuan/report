package com.yunxinlink.report;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		String reportfile = "testbean.jasper";
		String outFileName = "E://test.pdf";
		File sourceFile = new File(reportfile);
		Map<String, Object> map = new HashMap<>();
		map.put("id", "id");
		map.put("name", "name");
		map.put("address", "address");
		List<UserInfo> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			UserInfo info = new UserInfo();
			info.setId(i + 1);
			info.setName("测试名称" + i);
			info.setAddress("大家好发电机房" + i);
			
			list.add(info);
		}
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		try {
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(sourceFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportfile, map, dataSource);
			File destFile = new File(sourceFile.getParent(), jasperReport.getName() + ".jrprint");
			JRSaver.saveObject(jasperPrint, destFile);
			JasperExportManager.exportReportToPdfFile(destFile.getAbsolutePath());
//			JRPdfExporter exporter = new JRPdfExporter();
//			
//			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            exporter.exportReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
