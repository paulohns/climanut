package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.climanut.bean.AtividadeAnvisa;
import com.br.climanut.facade.AtividadeAnvisaFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ServletAtividadeAnvisa
 */
@WebServlet("/ServletAtividadeAnvisa")
public class ServletAtividadeAnvisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AtividadeAnvisaFacade atividadeAnvisaFacade;
	AtividadeAnvisa atividadeAnvisa;

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
		System.out.println(operacao);
		try {
			if (operacao.equals("Incluir")) {
				incluirAtividadeAnvisa(request, response);
			}
			if (operacao.equals("Alterar")) {
				alterarAtividadeAnvisa(request, response);
			}
			if (operacao.equals("Excluir")) {
				excluirAtividadeAnvisa(request, response);
			}
			if (operacao.equals("Pesquisar")) {
				pesquisarAtividadeAnvisa(request, response);
			}
		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		}

	}

	private void incluirAtividadeAnvisa(HttpServletRequest request,HttpServletResponse response) throws ClimanutExceptions {

		AtividadeAnvisa atividadeAnvisa = new AtividadeAnvisa();
		AtividadeAnvisaFacade atividadeAnvisaFacade = new AtividadeAnvisaFacade();
	
		String descricaoAtividade = request.getParameter("descricaoAtividade");
		String campoPeriodicidade = request.getParameter("periodicidade");
	
		/* CONVERSÃO */
		int periodicidade = Integer.valueOf(campoPeriodicidade);
	
		atividadeAnvisa.setDescricaoAtividade(descricaoAtividade);
		atividadeAnvisa.setPeriodicidadeManutencao(periodicidade);
			
		atividadeAnvisaFacade.create(atividadeAnvisa);
		
	}
	private void alterarAtividadeAnvisa(HttpServletRequest request,HttpServletResponse response) throws ClimanutExceptions {
		
		System.out.println("Alterar");
		atividadeAnvisa = new AtividadeAnvisa();
		atividadeAnvisaFacade = new AtividadeAnvisaFacade();

		String campoIdAtividadeAnvisa = request.getParameter("idAtividadeAnvisa");
		String descricaoAtividade = request.getParameter("descricaoAtividade");
		String campoPeriodicidade = request.getParameter("periodicidade");

		/* CONVERSÃO */
		Integer periodicidade = Integer.valueOf(campoPeriodicidade);
		Integer idAtividadeAnvisa = Integer.valueOf(campoIdAtividadeAnvisa);

		atividadeAnvisa.setIdAtividadeAnvisa(idAtividadeAnvisa);
		atividadeAnvisa.setDescricaoAtividade(descricaoAtividade);
		atividadeAnvisa.setPeriodicidadeManutencao(periodicidade);

		atividadeAnvisaFacade.update(atividadeAnvisa);
	}
	private void excluirAtividadeAnvisa(HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("excluir");
		try {
			atividadeAnvisa = new AtividadeAnvisa();
			atividadeAnvisaFacade = new AtividadeAnvisaFacade();
			
			String campoIdAtividadeAnvisa = request.getParameter("idAtividadeAnvisa");
			Integer idAtividadeAnvisa = Integer.valueOf(campoIdAtividadeAnvisa);
		
			atividadeAnvisa = atividadeAnvisaFacade.find(idAtividadeAnvisa);
			atividadeAnvisaFacade.delete(atividadeAnvisa);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void pesquisarAtividadeAnvisa(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			atividadeAnvisaFacade = new AtividadeAnvisaFacade();
			List<AtividadeAnvisa> listaAtividadesAnvisa;
			listaAtividadesAnvisa = atividadeAnvisaFacade.findAll();
			String periodicidade = null;
			JsonArray array = new JsonArray();
		
			for (AtividadeAnvisa atividadeAnvisa : listaAtividadesAnvisa) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("idAtividadeAnvisa", atividadeAnvisa.getIdAtividadeAnvisa());
				jsonObject.addProperty("descricaoAtividade", atividadeAnvisa.getDescricaoAtividade());
				System.out.println("Periodicidade:"+atividadeAnvisa.getPeriodicidadeManutencao());
				int p = atividadeAnvisa.getPeriodicidadeManutencao();
				System.out.println(p);
				if(atividadeAnvisa.getPeriodicidadeManutencao() == 1){
					periodicidade = "Mensal";
				}else if(atividadeAnvisa.getPeriodicidadeManutencao()== 2){
					periodicidade = "Bimestral";
				}
				else if(atividadeAnvisa.getPeriodicidadeManutencao()== 3){
					periodicidade = "Trimestral";
				}
				else if(atividadeAnvisa.getPeriodicidadeManutencao()== 6){
					periodicidade = "Semestral";
				}
				else if(atividadeAnvisa.getPeriodicidadeManutencao()== 12){
					periodicidade = "Anual";
				}
				jsonObject.addProperty("periodicidadeManutencao", periodicidade);
				array.add(jsonObject);
				
				
			}
			PrintWriter out = response.getWriter();
			response.setContentType("text/text;charset=utf-8");
	        out.println(array);
        
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		}
		
	
	}
}
