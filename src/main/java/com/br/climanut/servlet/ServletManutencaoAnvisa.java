package com.br.climanut.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.climanut.bean.AgendaAnvisa;
import com.br.climanut.bean.ManutencaoAnvisa;
import com.br.climanut.bean.Tecnico;
import com.br.climanut.facade.AgendaAnvisaFacade;
import com.br.climanut.facade.ManutencaoAnvisaFacade;
import com.br.climanut.facade.TecnicoFacade;

/**
 * Servlet implementation class ServletManutencaoAnvisa
 */
@WebServlet("/ServletManutencaoAnvisa")
public class ServletManutencaoAnvisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("acao");
		System.out.println("agenda"+operacao);
		if (operacao.equals("Incluir")) {
			incluirManutencaoAnvisa(request, response);
		}
		if (operacao.equals("Alterar")) {
			alterarManutencaoAnvisa(request, response);
		}
		if (operacao.equals("Pesquisar")) {
			pesquisarAgendaAnvisa(request, response);
		}		
	}

	private void incluirManutencaoAnvisa(HttpServletRequest request,HttpServletResponse response) {
		
		ManutencaoAnvisa manutencaoAnvisa = new ManutencaoAnvisa();
		ManutencaoAnvisaFacade manutencaoAnvisaFacade = new ManutencaoAnvisaFacade();
		AgendaAnvisa agendaAnvisa = new AgendaAnvisa();
		AgendaAnvisaFacade agendaAnvisaFacade = new AgendaAnvisaFacade();
		Tecnico tecnicoExecutadoPor = new Tecnico();
		Tecnico tecnicoAprovadoPor = new Tecnico();
		TecnicoFacade tecnicoFacade = new TecnicoFacade();

		String campoIdAgendaAnvisa = request.getParameter("agendaAnvisa");
		String campoIdTecnicoExecutadoPor = request.getParameter("idTecnicoExecutadoPor");
		String campoIdTecnicoAprovadoPor = request.getParameter("idTecnicoAprovadoPor");
		String dataManutencaoAnvisa = request.getParameter("dataManutencaoAnvisa");
		String executadoPor = request.getParameter("executadoPor");
		String aprovadoPor = request.getParameter("aprovadoPor");
		
		System.out.println("idAgendaAnvisa:"+campoIdAgendaAnvisa);
		System.out.println("idTecnicoExecutadoPor:"+campoIdTecnicoExecutadoPor);
		System.out.println("idTecnicoAprovadoPor:"+campoIdTecnicoAprovadoPor);
		System.out.println("dataManutencaoAnvisa:"+dataManutencaoAnvisa);
		System.out.println("executadoPor:"+executadoPor);
		System.out.println("aprovadoPor:"+aprovadoPor);
		
		/* CONVERSÃO */
		Integer idAgendaAnvisa = Integer.valueOf(campoIdAgendaAnvisa);
		Integer idTecnicoExecutadoPor = Integer.valueOf(1);
		Integer idTecnicoAprovadoPor = Integer.valueOf(1);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date date = null;
		try {
			date = (Date) formatter.parse(dataManutencaoAnvisa);
		
			agendaAnvisa = agendaAnvisaFacade.find(idAgendaAnvisa);
			tecnicoExecutadoPor = tecnicoFacade.find(idTecnicoExecutadoPor);
			tecnicoAprovadoPor = tecnicoFacade.find(idTecnicoAprovadoPor);
			
			manutencaoAnvisa.setAgendaAnvisa(agendaAnvisa);
			manutencaoAnvisa.setDataManutencaoAnvisa(date);
			manutencaoAnvisa.setExecutador(tecnicoExecutadoPor);
			manutencaoAnvisa.setAprovador(tecnicoAprovadoPor);
			
			manutencaoAnvisaFacade.create(manutencaoAnvisa);
			System.out.println("Sucesso!");
		
		} catch (ParseException pE) {
			pE.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void alterarManutencaoAnvisa(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void pesquisarAgendaAnvisa(HttpServletRequest request,HttpServletResponse response) {
		
	}

}
