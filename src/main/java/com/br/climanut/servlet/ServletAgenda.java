package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.climanut.bean.Agenda;
import com.br.climanut.bean.Chamado;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Pessoa;
import com.br.climanut.bean.Tecnico;
import com.br.climanut.facade.AgendaFacade;
import com.br.climanut.facade.ChamadoFacade;
import com.br.climanut.facade.ClienteFacade;
import com.br.climanut.facade.TecnicoFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ServletAgenda
 */
@WebServlet("/ServletAgenda")
public class ServletAgenda extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("acao");
		System.out.println("agenda"+operacao);
		if (operacao.equals("Incluir")) {
			incluirAgenda(request, response);
		}else if (operacao.equals("Alterar")) {
			alterarAgenda(request, response);
		}else if (operacao.equals("Excluir")) {
			excluirAgenda(request, response);
		}else if (operacao.equals("Pesquisar")) {
			pesquisarAgenda(request, response);
		}else{
			System.out.println("ERROR");
		}

	}

	@SuppressWarnings("unused")
	private void autocomplete(HttpServletRequest request,HttpServletResponse response, String operacao, String termo) throws IOException {
		
	}

	private void incluirAgenda(HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("*********** INCLUIR ************");
		
		try {
			Agenda agenda = new Agenda();
			AgendaFacade agendaFacade = new AgendaFacade();
			Cliente cliente = new Cliente();
			ClienteFacade clienteFacade = new ClienteFacade();
			Chamado chamado = new Chamado();
			ChamadoFacade chamadoFacade = new ChamadoFacade();
			Tecnico tecnico = new Tecnico();
			TecnicoFacade tecnicoFacade = new TecnicoFacade();
	
			String campoCliente = request.getParameter("cliente");
			String campoTecnico = request.getParameter("tecnico");
			String campoChamado = request.getParameter("chamado");
			String descricaoAtividade = request.getParameter("descricaoAtividade");
			String observacao = request.getParameter("observacao");
			String dataAgenda = request.getParameter("dataAgenda");
			
			System.out.println("cliente:"+campoCliente);
			System.out.println("campoTecnico:"+campoTecnico);
			System.out.println("campoChamado:"+campoChamado);
			System.out.println("descricaoAtividade:"+descricaoAtividade);
			System.out.println("observacao:"+observacao);
			System.out.println("dataAgenda:"+dataAgenda);
			
			HttpSession httpSession = request.getSession();
			Pessoa p = (Pessoa) httpSession.getAttribute("logado");
			Integer incluidoPor =  null;
			if (p != null){
				if(p.getTipoUsuario() == 0){
					//Sistema
					incluidoPor = 0;
				}else{
					//Técnico
					incluidoPor = 1;
				}
			}
	
			/* CONVERSÃO */
			int idCliente = Integer.valueOf(campoCliente);
			int idTecnico = Integer.valueOf(campoTecnico);
			DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			Date date = null;
		
			date = (Date) formatter.parse(dataAgenda);
		
			if(observacao != ""){
				agenda.setObservacao(observacao);
			}
			if(campoChamado != ""){
				int idChamado = Integer.valueOf(campoChamado);
				chamado = chamadoFacade.find(idChamado);
				agenda.setChamado(chamado);
			}
			cliente = clienteFacade.find(idCliente);
			tecnico = tecnicoFacade.find(idTecnico);
			agenda.setCliente(cliente);
			agenda.setTecnico(tecnico);
			agenda.setDescricaoAtividade(descricaoAtividade);
			agenda.setDataAgenda(date);
			agenda.setStatus(1);
			agenda.setIncluidoPor(incluidoPor);
			
			agendaFacade.create(agenda);
			//request.getRequestDispatcher("paginas/agenda/agenda.jsp").forward(request, response);
			System.out.println("Sucesso!");
		
		} catch (ParseException pE) {
			pE.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void alterarAgenda(HttpServletRequest request,HttpServletResponse response) {

		Agenda agenda = new Agenda();
		AgendaFacade agendaFacade = new AgendaFacade();
		Cliente cliente = new Cliente();
		ClienteFacade clienteFacade = new ClienteFacade();
		Chamado chamado = new Chamado();
		ChamadoFacade chamadoFacade = new ChamadoFacade();
		Tecnico tecnico = new Tecnico();
		TecnicoFacade tecnicoFacade = new TecnicoFacade();
		
		String campoAgenda = request.getParameter("agenda");
		String campoCliente = request.getParameter("cliente");
		String campoTecnico = request.getParameter("tecnico");
		String campoChamado = request.getParameter("chamado");
		String descricaoAtividade = request.getParameter("descricaoAtividade");
		String observacao = request.getParameter("observacao");
		String dataAgenda = request.getParameter("dataAgenda");
		String campoStatus = request.getParameter("status");
		
		System.out.println("agenda:"+campoAgenda);
		System.out.println("cliente:"+campoCliente);
		System.out.println("campoTecnico:"+campoTecnico);
		System.out.println("campoChamado:"+campoChamado);
		System.out.println("descricaoAtividade:"+descricaoAtividade);
		System.out.println("observacao:"+observacao);
		System.out.println("dataAgenda:"+dataAgenda);
		System.out.println("campoStatus:"+ campoStatus);

		/* CONVERSÃO */
		int idAgenda = Integer.valueOf(campoAgenda);
		int idCliente = Integer.valueOf(campoCliente);
		int idTecnico = Integer.valueOf(campoTecnico);
		
		
		try {
			//date = (Date) formatter.parse(dataAgenda);
		
			if(observacao != ""){
				agenda.setObservacao(observacao);
			}
			if(campoChamado != ""){
				
				int idChamado = Integer.valueOf(campoChamado);
				chamado = chamadoFacade.find(idChamado);
				agenda.setChamado(chamado);
			}
			cliente = clienteFacade.find(idCliente);
			tecnico = tecnicoFacade.find(idTecnico);
			agenda.setIdAgenda(idAgenda);
			agenda.setCliente(cliente);
			agenda.setTecnico(tecnico);
			agenda.setDescricaoAtividade(descricaoAtividade);
			agenda.setDataAgenda(null);
			
			agendaFacade.update(agenda);
			request.getRequestDispatcher("paginas/agenda/agenda.jsp").forward(request, response);
			System.out.println("Sucesso!");
		
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void excluirAgenda(HttpServletRequest request,HttpServletResponse response) {
		/* NÃO PODERÁ EXCLUIR AGENDA */
	}

	private void pesquisarAgenda(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String cliente = request.getParameter("cliente");
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String agendado = request.getParameter("agendado");
		String cancelado = request.getParameter("cancelado");
		String fechado = request.getParameter("fechado");
		
		AgendaFacade agendaFacade = new AgendaFacade();
		
		//List<Agenda> lista = agendaFacade.filter(cliente, dataInicio, dataFim, agendado, cancelado, fechado);		
		List<Agenda> lista;
		try {
			//lista = agendaFacade.findAll();
			lista = agendaFacade.filter(cliente, dataInicio, dataFim, agendado, cancelado, fechado);
			JsonArray array = new JsonArray();
			String status = "";
			
			for (Agenda agenda : lista) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("idAgenda", agenda.getIdAgenda());
				jsonObject.addProperty("idCliente", agenda.getCliente().getIdCliente());
				jsonObject.addProperty("cliente", agenda.getCliente().getNomeAmbiente());
				/* ESTÁ VINDO O MESMO NOME PARA CLIENTE E TÉCNICO */
				jsonObject.addProperty("idTecnico", agenda.getTecnico().getIdTecnico());
				jsonObject.addProperty("tecnico", agenda.getTecnico().getPessoa().getNome());
				jsonObject.addProperty("chamado", "1");
				Date dataFinal = agenda.getDataAgenda();
				jsonObject.addProperty("dataAgenda", dataFinal.toString());
				jsonObject.addProperty("descricaoAtividade", agenda.getDescricaoAtividade());
				jsonObject.addProperty("observacao", agenda.getObservacao());
				jsonObject.addProperty("incluidoPor", agenda.getIncluidoPor());
				if(agenda.getStatus() == 1){
					status = "Agendado";
				}
				if(agenda.getStatus() == 2){
					status = "Cancelado";
				}
				if(agenda.getStatus() == 3){
					status = "Fechado";
				}
				jsonObject.addProperty("status", status);
				array.add(jsonObject);
			}
			
			PrintWriter out = response.getWriter(); 
	        response.setContentType("text/text;charset=utf-8");
	        System.out.println(array);
	        
	        out.println(array);

		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
