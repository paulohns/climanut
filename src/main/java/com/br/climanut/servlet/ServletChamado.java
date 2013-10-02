package com.br.climanut.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.climanut.bean.Chamado;
import com.br.climanut.facade.ChamadoFacade;

/**
 * Servlet implementation class ServletChamado
 */
@WebServlet("/ServletChamado")
public class ServletChamado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("acao");
		System.out.println(operacao);
		
		if (operacao.equals("Alterar")) {
			alterarChamado(request, response);
		}
		if (operacao.equals("Excluir")) {
			excluirChamado(request, response);
		}

	}
	/* CASO A MANUTENÇÃO_01 SEJA RELACIONADO A UMA AGENDA_02, QUE É DE UM CHAMADO_03, 
	 * QUANDO FECHAR A MANUTENÇÃO_01, A AGENDA_02 É ALTERADA E O CHAMADO_03 É FECHADO 
	 * CASO O CHAMADO PRECISE SER EXCLUIDO, O MESMO NÃO DEVE TER SIDO AGENDADO
	 * SÓ PODERÁ ALTERAR O STATUS DE CHAMADO */
	private void alterarChamado(HttpServletRequest request,HttpServletResponse response) {
		
	}
	/* SÓ PODERÁ EXCLUIR CHAMADO SE O MESMO ESTIVER COM  STATUS CANCELADO PELO CLIENTE */
	private void excluirChamado(HttpServletRequest request,HttpServletResponse response) {
		
		Chamado chamado = new Chamado();
		ChamadoFacade chamadoFacade = new ChamadoFacade();
		
		String campoChamado = request.getParameter("idChamado");
		int idChamado = Integer.valueOf(campoChamado);
		
		try {
			chamado = chamadoFacade.find(idChamado);
			chamadoFacade.delete(chamado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void pesquisarChamado(HttpServletRequest request,HttpServletResponse response) {
		/* NÃO TERÁ FILTROS DE PESQUISA */
	}
}
