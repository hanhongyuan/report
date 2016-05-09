package com.yunxinlink.report;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		String reportfile = "exam_export.jasper";
//		String reportfile = "Blank_A4.jasper";
//		String reportfile = "testbean.jasper";
//		String reportfile = "HorizontalListReport.jasper";
		String outFileName = "E://test.pdf";
		File sourceFile = new File(reportfile);
		Map<String, Object> map = new HashMap<>();
		
		boolean haveIllness = true;
		
		map.put("sno", "SN00000000014856");
		map.put("realName", "张三");
		map.put("cardType", "身份证");
		map.put("gender", "男");
		map.put("birthday", getBirthday());
		map.put("nationality", "中国");
		map.put("cardNumber", "422802197805123124");
		map.put("censusType", "本地户籍");
		map.put("height", 173);
		map.put("eyesightLeft", "4.8");
		map.put("applyLicenceType", "C1");
		map.put("alreadyLicenceType", "无");
		map.put("postAddress", "广东省深圳市南山区xxx街道152号");
		map.put("phoneNumber", "18975621456");
		map.put("eyesightRight", "4.6");
		map.put("hospital", "深圳市人民医院");
		map.put("examDate", getExamDate());
		map.put("limbLeftTop", "正常");
		map.put("limbRightTop", "正常");
		map.put("limbLeftBottom", "正常");
		map.put("limbRightBottom", "正常");
		map.put("principal", "无");
		map.put("principalAddress", "无");
		map.put("principalIdCard", "无");
		map.put("principalPhone", "无");
		map.put("principalCardType", "无");
		map.put("doctor", "李圣杰");
		map.put("isCorrectionLeftEye", false);
		map.put("isCorrectionRightEye", true);
		map.put("hasHearingAids", false);
		map.put("isLeftEarQualified", true);
		map.put("isRightEarQualified", false);
		map.put("isTrunkNeckPerfect", true);
		map.put("isMotorDysfunction", false);
		map.put("haveIllness", haveIllness);
		map.put("isColorBlindness", true);
		map.put("hasProxy", false);
		
		try {
			Image image = Toolkit.getDefaultToolkit().createImage(JRLoader.loadBytes(new File("E:/timg.jpg")));
			MediaTracker traker = new MediaTracker(new Panel());
			traker.addImage(image, 0);
			traker.waitForID(0);
			map.put("avatar", image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (haveIllness) {
			map.put("hasHeartTrouble", false);
			map.put("hasEpilepsy", true);
			map.put("hasEpilepsy", true);
			map.put("hasMeniere", true);
			map.put("hasDizziness", false);
			map.put("hasHysterism", true);
			map.put("hasShakingPalsy", true);
			map.put("hasPsychosis", false);
			map.put("hasDementia", true);
			map.put("hasActivityTrouble", false);
			map.put("hasDrug", false);
		}
		
//		map.put("id", "id");
//		map.put("name", "nameValue");
//		map.put("address", "address");
		/*List<Address> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Address info = new Address();
			info.setId(i + 1);
			info.setCity("city" + i);
			info.setFirstName("firstName" + i);
			info.setLastName("lastName" + i);
			info.setStreet("street" + i);
			
			list.add(info);
		}*/
		/*List<InessInfo> list = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			InessInfo info = new InessInfo();
			info.setIllnessType("疾病类型" + i);
			
			list.add(info);
		}*/
//		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JRDataSource dataSource = new JREmptyDataSource(1);
		try {
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(sourceFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportfile, map, dataSource);
			File destFile = new File(sourceFile.getParent(), jasperReport.getName() + ".jrprint");
			JRSaver.saveObject(jasperPrint, destFile);
			JasperExportManager.exportReportToPdfFile(destFile.getAbsolutePath());
			JasperExportManager.exportReportToHtmlFile(destFile.getAbsolutePath());
//			JRPdfExporter exporter = new JRPdfExporter();
			
//			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            
            
//            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outFileName));
//            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//            exporter.exportReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static String getBirthday() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}
	
	public static String getExamDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
		return dateFormat.format(new Date());
	}
}
