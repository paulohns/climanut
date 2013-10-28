package com.br.climanut.utils;

import java.io.File;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailClimanut {  

  /**
    * @param args
    */  
  public static void enviaEmail(String relatorio) {  
	  
	  String nome = PropertiesUtil.getProperty("remetente");
      String sobrenome = PropertiesUtil.getProperty("assunto");

      System.out.println("HelloWorld, " + nome + " " + sobrenome);
      
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
          email.setSubject("Teste envio de Email Climanut.");  
          email.setMsg("Olá. Este é um email teste com relatorio Climanut.");  
 
          email.attach(attachment);  

          email.send();  
      } catch (EmailException e) {  
          e.printStackTrace();  
      }  
  }  

}