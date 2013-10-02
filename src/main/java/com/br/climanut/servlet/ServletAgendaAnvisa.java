package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.ListView;

import com.br.climanut.bean.AgendaAnvisa;
import com.br.climanut.bean.AtividadeAnvisa;
import com.br.climanut.facade.AgendaAnvisaFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ServletAgendaAnvisa
 */
@WebServlet("/ServletAgendaAnvisa")
public class ServletAgendaAnvisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("acao");
		System.out.println(operacao);
		
		if (operacao.equals("Pesquisar")) {
			pesquisarAgendaAnvisa(request, response);
		}
	}
	private void pesquisarAgendaAnvisa(HttpServletRequest request,HttpServletResponse response) throws IOException {
		/* FILTROS DE PESQUISA POR CLIENTE E/OU DATA */
		String cliente = request.getParameter("cliente");
		String dataInicio = request.getParameter("dataInicial");
		String dataFim = request.getParameter("dataFinal");
		String agendado = request.getParameter("agendado");
		String cancelado = request.getParameter("cancelado");
		String fechado = request.getParameter("fechado");
		
		System.out.println("*********************");
		System.out.println(cliente);
		System.out.println(dataFim);
		System.out.println(dataInicio);
		System.out.println("fechado" + fechado);
		System.out.println("cancelado" + cancelado);
		System.out.println("agendado" + agendado);
		System.out.println("*********************");
		
		AgendaAnvisaFacade agendaAnvisaFacade = new AgendaAnvisaFacade();
		//List<Agenda> lista = agendaFacade.filter(cliente, dataInicio, dataFim, agendado, cancelado, fechado);		
		List<AgendaAnvisa> lista;
		JsonArray array = new JsonArray();
		
		try {
			lista = agendaAnvisaFacade.findAll();
			Integer status;
			String statusAgenda;
			String atividade = "" ;
			JsonObject jsonObject = new JsonObject();
			JsonObject atividadeStatus;
			AgendaAnvisa agendaAnvisa = new AgendaAnvisa();
			agendaAnvisa.setIdAgendaAnvisa(lista.get(0).getIdAgendaAnvisa());
			Date dataFinal = lista.get(0).getDataFinal();
			agendaAnvisa.setDataFinal(dataFinal);
			jsonObject.addProperty("idAgendaAnvisa", agendaAnvisa.getIdAgendaAnvisa());
			jsonObject.addProperty("dataFinal",agendaAnvisa.getDataFinal().toString());	
			jsonObject.addProperty("cliente", lista.get(0).getCliente().getPessoa().getNome());
			Integer contaConcluido = 0;
			JsonArray j = new JsonArray();
			
			
				for (int i = 0; i < lista.size(); i++) {
					atividadeStatus = new JsonObject();
					atividade = lista.get(i).getAtividadeAnvisa().getDescricaoAtividade();
					status = lista.get(i).getStatus();
					atividadeStatus.addProperty("atividade",atividade);
					atividadeStatus.addProperty("status",status);
					j.add(atividadeStatus);
					if(status == 1){
						contaConcluido++;
					}else{
						contaConcluido = 0;
					}
				}
				if(contaConcluido == lista.size()){
					statusAgenda = "Fechado";
				}else{
					statusAgenda = "Aberto";
				}
			
			System.out.println("Lista de atividades:" + j);
			jsonObject.addProperty("statusAgenda", statusAgenda);
			jsonObject.add("atividadeAnvisa", j);
			array.add(jsonObject);
			
			PrintWriter out = response.getWriter(); 
	        response.setContentType("text/text;charset=utf-8");
	        System.out.println(array);        
		    out.println(array);
		  

		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		}
						
	}
}
