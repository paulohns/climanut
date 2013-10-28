
package com.br.climanut.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.climanut.bean.EnviarRelatorioViaEmail;
import com.br.climanut.bean.GerarRelatorio;
import com.br.climanut.utils.ClimanutExceptions;
import com.br.climanut.utils.JavaMailClimanut;



/**
 * Servlet implementation class ServletGerarRelatorio
 */
@WebServlet("/ServletGerarRelatorio")
public class ServletGerarRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("wsuagsuagsauogsaogsoau");
		GerarRelatorio gerarRelatorio = new GerarRelatorio();
		
		HashMap<String, String> parameters = new HashMap<String, String>();
		
		/*parameters.put("A", "A");
		parameters.put("B", "B");
		parameters.put("C", "C");
		parameters.put("D", "D");
		parameters.put("E", "E");*/
		
		try{
			gerarRelatorio.geraPdf("src/main/resources/relatorioAnvisa.jrxml", parameters, response, request);
			System.out.println("Relatorio gerado");
		} catch(Exception e){
			System.out.println("Relatorio nao gerado");	
		}
		
	}
}
