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

import com.br.climanut.bean.Agenda;
import com.br.climanut.bean.Localizacao;
import com.br.climanut.bean.Manutencao;
import com.br.climanut.facade.AgendaFacade;
import com.br.climanut.facade.LocalizacaoFacade;
import com.br.climanut.facade.ManutencaoFacade;

/**
 * Servlet implementation class ServletManutencao
 */
@WebServlet("/ServletManutencao")
public class ServletManutencao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("acao");
		System.out.println(operacao);
		if (operacao.equals("Incluir")) {
			incluirManutencao(request, response);
		}
		if (operacao.equals("Alterar")) {
			alterarManutencao(request, response);
		}
		if (operacao.equals("Excluir")) {
			excluirManutencao(request, response);
		}
		if (operacao.equals("Pesquisar")) {
			pesquisarManutencao(request, response);
		}

	}

	private void incluirManutencao(HttpServletRequest request,HttpServletResponse response) {

		Manutencao manutencao = new Manutencao();
		ManutencaoFacade manutencaoFacade = new ManutencaoFacade();
		Localizacao localizacao = new Localizacao();
		LocalizacaoFacade localizacaoFacade = new LocalizacaoFacade();
		Agenda agenda = new Agenda();
		AgendaFacade agendaFacade = new AgendaFacade();

		String campoLocalizacao = request.getParameter("localizacao");
		String campoAgenda = request.getParameter("agenda");
		String dataAgenda = request.getParameter("dataAgenda");

		String corrente = request.getParameter("statusCorrente");
		manutencao.setCorrente(corrente);
		if (corrente.equals("1")) {
			String obsCorrente = request.getParameter("obsCorrente");
			manutencao.setObsCorrente(obsCorrente);
		}

		String pressaoHi = request.getParameter("statusPressaoHi");
		manutencao.setPressaoHi(pressaoHi);
		if (pressaoHi.equals("1")) {
			String obsPressaoHi = request.getParameter("obsPressaoHi");
			manutencao.setObsPressaoHi(obsPressaoHi);
		}
		String pressaoLow = request.getParameter("statusPressaoLow");
		manutencao.setPressaoLow(pressaoLow);
		if (pressaoHi.equals("1")) {
			String obsPressaoLow = request.getParameter("obsPressaoLow");
			manutencao.setObsPressaoLow(obsPressaoLow);
		}
		String filtros = request.getParameter("statusFiltros");
		manutencao.setFiltros(filtros);
		if (filtros.equals("1")) {
			String obsFiltros = request.getParameter("obsFiltros");
			manutencao.setObsFiltros(obsFiltros);
		}
		String temperatura = request.getParameter("statusTemperatura");
		manutencao.setTemperatura(temperatura);
		if (temperatura.equals("1")) {
			String obsTemperatura = request.getParameter("obsTemperatura");
			manutencao.setObsFiltros(obsTemperatura);
		}

		/* CONVERSÃO */
		int idLocalizacao = Integer.valueOf(campoLocalizacao);
		int idAgenda = Integer.valueOf(campoAgenda);
		DateFormat formatter = new SimpleDateFormat(dataAgenda);
		Date date = null;
		try {
			date = (Date) formatter.parse(dataAgenda);
		} catch (ParseException exc) {
			exc.printStackTrace();
		}
		manutencao.setLocalizacao(localizacao);
		manutencao.setAgenda(agenda);
		manutencao.setDataManutencao(date);
		try {
			localizacao = localizacaoFacade.find(idLocalizacao);
			agenda = agendaFacade.find(idAgenda);
			manutencaoFacade.create(manutencao);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private void alterarManutencao(HttpServletRequest request,HttpServletResponse response) {
		
		Manutencao manutencao = new Manutencao();
		ManutencaoFacade manutencaoFacade = new ManutencaoFacade();
		Localizacao localizacao = new Localizacao();
		LocalizacaoFacade localizacaoFacade = new LocalizacaoFacade();
		Agenda agenda = new Agenda();
		AgendaFacade agendaFacade = new AgendaFacade();

		String campoLocalizacao = request.getParameter("localizacao");
		String campoAgenda = request.getParameter("agenda");
		String dataAgenda = request.getParameter("dataAgenda");

		String corrente = request.getParameter("statusCorrente");
		manutencao.setCorrente(corrente);
		if (corrente.equals("1")) {
			String obsCorrente = request.getParameter("obsCorrente");
			manutencao.setObsCorrente(obsCorrente);
		}

		String pressaoHi = request.getParameter("statusPressaoHi");
		manutencao.setPressaoHi(pressaoHi);
		if (pressaoHi.equals("1")) {
			String obsPressaoHi = request.getParameter("obsPressaoHi");
			manutencao.setObsPressaoHi(obsPressaoHi);
		}
		String pressaoLow = request.getParameter("statusPressaoLow");
		manutencao.setPressaoLow(pressaoLow);
		if (pressaoHi.equals("1")) {
			String obsPressaoLow = request.getParameter("obsPressaoLow");
			manutencao.setObsPressaoLow(obsPressaoLow);
		}
		String filtros = request.getParameter("statusFiltros");
		manutencao.setFiltros(filtros);
		if (filtros.equals("1")) {
			String obsFiltros = request.getParameter("obsFiltros");
			manutencao.setObsFiltros(obsFiltros);
		}
		String temperatura = request.getParameter("statusTemperatura");
		manutencao.setTemperatura(temperatura);
		if (temperatura.equals("1")) {
			String obsTemperatura = request.getParameter("obsTemperatura");
			manutencao.setObsFiltros(obsTemperatura);
		}

		/* CONVERSÃO */
		int idLocalizacao = Integer.valueOf(campoLocalizacao);
		int idAgenda = Integer.valueOf(campoAgenda);
		DateFormat formatter = new SimpleDateFormat(dataAgenda);
		Date date = null;
		try {
			date = (Date) formatter.parse(dataAgenda);
		} catch (ParseException exc) {
			exc.printStackTrace();
		}
		manutencao.setLocalizacao(localizacao);
		manutencao.setAgenda(agenda);
		manutencao.setDataManutencao(date);
		try {
			localizacao = localizacaoFacade.find(idLocalizacao);
			agenda = agendaFacade.find(idAgenda);
			manutencaoFacade.update(manutencao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void excluirManutencao(HttpServletRequest request,HttpServletResponse response) {
		/* NÃO PODERÁ EXCLUIR ATIVIDADE ANVISA */
	}

	private void pesquisarManutencao(HttpServletRequest request,HttpServletResponse response) {
		/* FILTROS DE PESQUISA POR DATA, CLIENTE E STATUS */
	}
}
