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
import com.br.climanut.bean.Bloco;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Equipamento;
import com.br.climanut.bean.EquipamentosPorLocal;
import com.br.climanut.bean.Local;
import com.br.climanut.bean.Localizacao;
import com.br.climanut.bean.Pavimento;
import com.br.climanut.bean.Sistema;
import com.br.climanut.facade.AgendaFacade;
import com.br.climanut.facade.EquipamentoFacade;
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
	
	Sistema sistema;
	Bloco bloco;
	Pavimento pavimento;
	Local local;
	EquipamentosPorLocal equipamentosPorLocal;
	SistemaFacade sistemaFacade;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String operacao = request.getParameter("acao");
			System.out.println("Ação"+operacao);
			if (operacao.equals("IncluirCliente")) {
				incluirCliente(request, response);
			}else if (operacao.equals("IncluirBloco")) {
				incluirBloco(request, response);
			}else if (operacao.equals("IncluirPavimento")) {
				incluirPavimento(request, response);
			}else if (operacao.equals("IncluirLocal")) {
				incluirLocal(request, response);
			}else if (operacao.equals("IncluirEquipamento")) {
				incluirEquipamento(request, response);
			}else if (operacao.equals("AlterarBloco")) {
				alterarBloco(request, response);
			}else if (operacao.equals("AlterarPavimento")) {
				alterarPavimento(request, response);
			}else if (operacao.equals("AlterarLocal")) {
				alterarLocal(request, response);
			}else if (operacao.equals("AlterarEquipamento")) {
				alterarEquipamento(request, response);
			}else if (operacao.equals("PesquisarSistema")) {
				pesquisarSistema(request, response);
			}
		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		}
	}

	
	private void incluirCliente(HttpServletRequest request,HttpServletResponse response) throws ClimanutExceptions {
		
		try {
			sistema = new Sistema();
			sistemaFacade = new SistemaFacade();
			
			String campoIdCliente = request.getParameter("idCliente");
			System.out.println("id>>>"+campoIdCliente);
			int idCliente = Integer.valueOf(campoIdCliente);
			System.out.println("id>>>"+idCliente);
			
			Cliente cliente = new Cliente();
			cliente.setIdCliente(idCliente);
			sistema.setCliente(cliente);
			sistema.setStatus(1);
			sistemaFacade.create(sistema);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void incluirBloco(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			sistema = new Sistema();
			sistemaFacade = new SistemaFacade();
			
			String campoIdCliente = request.getParameter("idCliente");
			System.out.println("id>>>"+campoIdCliente);
			int idCliente = Integer.valueOf(campoIdCliente);
			System.out.println("id>>>"+idCliente);
			String campoBloco = request.getParameter("bloco");
			System.out.println("id>>>"+campoBloco);
			
			Cliente cliente = new Cliente();
			cliente.setIdCliente(idCliente);
			bloco = new Bloco();
			bloco.setCliente(cliente);
			bloco.setDescricaoBloco(campoBloco);
			
			sistemaFacade.createBloco(bloco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	private void incluirPavimento(HttpServletRequest request,HttpServletResponse response) {
		
	}
	private void incluirLocal(HttpServletRequest request,HttpServletResponse response) {
		
	}
	private void incluirEquipamento(HttpServletRequest request,HttpServletResponse response) {
		
	}
	
	private void alterarBloco(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarPavimento(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarLocal(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarEquipamento(HttpServletRequest request,HttpServletResponse response) {
		
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
