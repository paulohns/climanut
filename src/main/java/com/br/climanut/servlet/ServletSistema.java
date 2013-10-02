package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.climanut.bean.Agenda;
import com.br.climanut.bean.Localizacao;
import com.br.climanut.bean.Sistema;
import com.br.climanut.facade.AgendaFacade;
import com.br.climanut.facade.LocalizacaoFacade;
import com.br.climanut.facade.SistemaFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ServletSistema
 */
@WebServlet("/ServletSistema")
public class ServletSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("acao");
		System.out.println("Ação"+operacao);
		if (operacao.equals("Incluir")) {
			incluirSistema(request, response);
		}
		if (operacao.equals("Alterar")) {
			alterarSistema(request, response);
		}
		if (operacao.equals("Pesquisar")) {
			pesquisarSistema(request, response);
		}
		
	}

	private void incluirSistema(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarSistema(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void pesquisarSistema(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String cliente = request.getParameter("clientePesq");
		String dataInstalacaoInicialPesq = request.getParameter("dataInstalacaoInicialPesq");
		String dataInstalacaoFinalPesq = request.getParameter("dataInstalacaoFinalPesq");
		String ativo = request.getParameter("ativoPesq");
		String inativo = request.getParameter("inativoPesq");
		
		System.out.println("*********************");
		System.out.println(cliente);
		System.out.println(dataInstalacaoInicialPesq);
		System.out.println(dataInstalacaoFinalPesq);
		System.out.println("ativo" + ativo);
		System.out.println("cancelado" + inativo);
		System.out.println("*********************");
		
		LocalizacaoFacade localizacaoFacade = new LocalizacaoFacade();
		
		//List<Agenda> lista = agendaFacade.filter(cliente, dataInicio, dataFim, agendado, cancelado, fechado);		
		List<Localizacao> lista;
		try {
			lista = localizacaoFacade.findAll();
			JsonArray array = new JsonArray();
			JsonObject jsonObject;
			
			for (Localizacao localizacao : lista) {
				jsonObject = new JsonObject();
				jsonObject.addProperty("dataInstalacao", localizacao.getSistema().getDataInstalacao().toString());
				jsonObject.addProperty("status", localizacao.getStatus());
				jsonObject.addProperty("idLocalizacao", localizacao.getIdLocalizacao());
				jsonObject.addProperty("bloco", localizacao.getBloco());
				jsonObject.addProperty("pavimento", localizacao.getPavimento());
				jsonObject.addProperty("local", localizacao.getLocal());
				jsonObject.addProperty("equipamento", localizacao.getEquipamento().getModelo());
				array.add(jsonObject);
			}
				
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        System.out.println(array);
	        
	        out.println(array);

		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		}

	}

}
