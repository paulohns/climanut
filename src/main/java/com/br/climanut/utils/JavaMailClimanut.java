package com.br.climanut.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class JavaMailClimanut {
	
	public static String REMETENTE = PropertiesUtil.getProperty("remetente");
	public static String ASSUNTO = PropertiesUtil.getProperty("assunto");
	public static String MENSAGEM = PropertiesUtil.getProperty("mensagem");
	public static String HOST_NAME = PropertiesUtil.getProperty("host");
	public static String AUTH_USER = PropertiesUtil.getProperty("user");
	public static String PASS_USER = PropertiesUtil.getProperty("password");
	
	public void enviaEmail( String destinatario, String relatorio) throws IOException{

		File f = new File(relatorio);   
        
        EmailAttachment attachment = new EmailAttachment();  
        attachment.setPath(f.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);  
        attachment.setDescription("Anexo");  
        attachment.setName(f.getName());

        try {
          MultiPartEmail email = new MultiPartEmail();  
          email.setDebug(true);  
          email.setHostName(HOST_NAME);  
          email.setAuthentication(AUTH_USER,PASS_USER);  
          email.setSSL(true);  
          email.addTo("salyvianna@gmail.com");
          email.setFrom(REMETENTE);
          email.addCc("edson.kageyama@docente.facet.edu.br");
          email.setSubject(ASSUNTO);  
          email.setMsg(MENSAGEM);  
 
          email.attach(attachment);  

          email.send();  
      } catch (EmailException e) {  
          e.printStackTrace();  
      }  
      
	}

}