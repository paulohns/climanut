package com.br.climanut.bean;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import com.br.climanut.utils.HibernateUtil;

/**
 * Classe responsável por gerar o relatório ANVISA.
 * @author PauloHenrique
 *
 * */
public class GerarRelatorio {
	
	public static String FILE_PATH;

	/** Método que gera o relatório ANVISA */
	public void gerarRelatorioAnvisa(){

	}
	
	/** Método que gera o relatório Manutencao*/
	public void gerarRelatorioManutencao(){
		
	}
	
	/**
	 * Método para gerar o PDF.
	 * dos ManagedBeans.
	 * 
	 * @param nomeRelatorio
	 * @param parameters
	 */
	public void geraPdf(String nomeRelatorio, HashMap parameters, HttpServletResponse response, HttpServletRequest request) {
		String nomeArquivoGerado = "";
		Map<String, Object> parameters2 = new HashMap<String, Object>();

		Connection conn = null;
		try {
			conn = ((SessionFactoryImplementor) HibernateUtil.getSessionFactory()).getConnectionProvider().getConnection(); 
			
			File reportFile = new File(request.getRealPath("/reportAnvisa.jasper"));
			
			JasperPrint impressoraJasper = new JasperPrint();
			
			try{
				
				parameters2.put("idCliente", "2");
				parameters2.put("nomeEmpresa", "Central Climatização");
				parameters2.put("enderecoEmpresa", "Endereco Empresa");
				parameters2.put("cnpjEmpresa", "C.N.P.J.: 92.779.503-0001/25");
				parameters2.put("ieEmpresa", "I.E.: 37284342-2");
				parameters2.put("imEmpresa", "I.M.: 7534758324324-32");
				parameters2.put("foneFaxEmpresa", "Fone/Fax: (41)33309393");
				parameters2.put("celularEmpresa", "Cel.: (41)89828394");
				parameters2.put("sloganEmpresa", "Soluções em climatização");
				parameters2.put("idTecnico", "1");
				
				impressoraJasper = JasperFillManager.fillReport(reportFile.getPath(), parameters2, conn);
				
			} catch(Exception e){
				e.printStackTrace();
			}

			Date d = new Date();

			ServletOutputStream streamDeSaida = null;

			response.setContentType("application/pdf");

			nomeArquivoGerado = "Relatorio_ANVISA_" + Long.toString(d.getTime()) + ".pdf";
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ nomeArquivoGerado + "\"");

			streamDeSaida = response.getOutputStream();

			String caminhoRelatorio = "C:\\relatorios\\Relatorio_ANVISA_" + Long.toString(d.getTime()) + ".pdf";
			JasperExportManager.exportReportToPdfFile(impressoraJasper, caminhoRelatorio);
			
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT,
//					impressoraJasper);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
//					streamDeSaida);
//			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
//					nomeArquivoGerado);

			streamDeSaida.flush();
			streamDeSaida.close();
			
			enviaEmail(caminhoRelatorio);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void enviaEmail(String relatorio) {  
		  
	        File f = new File("C:\\relatorios\\Relatorio_ANVISA_1380667571865.pdf");   
	                  
	        EmailAttachment attachment = new EmailAttachment();  
	        attachment.setPath(f.getPath()); // Obtem o caminho do arquivo  
	        attachment.setDisposition(EmailAttachment.ATTACHMENT);  
	        attachment.setDescription("Anexo");  
	        attachment.setName(f.getName());

	        try {
	          MultiPartEmail email = new MultiPartEmail();  
	          email.setDebug(true);  
	          email.setHostName("smtp.gmail.com");  
	          email.setAuthentication("silva.venceslau2@gmail.com","phns@2012");  
	          email.setSSL(true);  
	          email.addTo("salyvianna@gmail.com");
	          email.setFrom("silva.venceslau2@gmail.com");
	          email.addCc("paulo_neves2@hotmail.com");
	          email.addCc("edson.kageyama@docente.facet.edu.br");
	          email.setSubject("Apresentação parcial do TCC - Paulo e Silvana - Relatório ANVISA Climanut");  
	          email.setMsg("Olá. Este é um email teste com relatorio Climanut.");  
	 
	          email.attach(attachment);  

	          email.send();  
	      } catch (EmailException e) {  
	          e.printStackTrace();  
	      }  
	  }  
}
