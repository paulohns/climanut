package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.br.climanut.bean.Bloco;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Pavimento;
import com.br.climanut.facade.ClienteFacade;
import com.br.climanut.facade.SistemaFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletPavimento")
public class ServletPavimento extends HttpServlet {
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
		if (operacao.equals("IncluirPavimento")) {
			incluirPavimento(request, response);
		}
		if (operacao.equals("AlterarPavimento")) {
			alterarPavimento(request, response);
		}
		if (operacao.equals("ExcluirPavimento")) {
			excluirPavimento(request, response);
		}
		if (operacao.equals("PesquisarPavimento")) {
			pesquisarPavimento(request, response);
		}
		if (operacao.equals("PesquisarAutocompletePavimentoPorBloco")) {
			String termo = request.getParameter("termo");
			String campoIdBlocoPavimento = request.getParameter("idBlocoPavimento");
			System.out.println("campoIdBlocoPavimento:"+campoIdBlocoPavimento);
			int idBloco = Integer.valueOf(campoIdBlocoPavimento);
			System.out.println("idBloco:"+idBloco);
			try {
				autocompletePavimentoPorBloco(request, response, operacao,termo,idBloco);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void autocompletePavimentoPorBloco(HttpServletRequest request,HttpServletResponse response, String operacao, String termo,Integer idBloco) throws IOException, JSONException {
		try {
			List<Pavimento> listaPavimentos = new ArrayList<Pavimento>();
			JsonArray array = new JsonArray();
			JsonObject jsonObject;
			SistemaFacade sistemaFacade = new SistemaFacade();
			
			
			try {
				listaPavimentos = sistemaFacade.filterPavimento(idBloco);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
	        termo = termo.toLowerCase();
	        String [] nomesCliente = new String [listaPavimentos.size()];
	        
	        for (int i = 0; i < listaPavimentos.size(); i++) {
	        	String nomes = listaPavimentos.get(i).getDescricaoPavimento().toLowerCase();
	        	if(nomes.startsWith(termo)){
	        		System.out.println(listaPavimentos.get(i).getDescricaoPavimento());
	        		nomesCliente[i] = listaPavimentos.get(i).getDescricaoPavimento();
	        		jsonObject = new JsonObject();
	        		jsonObject.addProperty("id",listaPavimentos.get(i).getIdPavimento());
	        		jsonObject.addProperty("nome",listaPavimentos.get(i).getDescricaoPavimento());
	        		array.add(jsonObject);
	        	}
			}
	        
	        System.out.println("Array:"+array);

			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(array.toString());
	        out.close();
		} catch (ClimanutExceptions e) {
			e.printStackTrace();
		}
	}

	private void incluirPavimento(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarPavimento(HttpServletRequest request,HttpServletResponse response) {

	}
	/* SÓ PODERÁ EXCLUIR PAVIMENTO SE O MESMO NÃO TIVER RELACIONAMENTO */
	private void excluirPavimento(HttpServletRequest request,HttpServletResponse response) {
		
		Pavimento pavimento = new Pavimento();
		SistemaFacade sistemaFacade = new SistemaFacade();
		
		String campoIdClientePavimento = request.getParameter("idClientePavimento");
		int idCliente = Integer.valueOf(campoIdClientePavimento);
		
		try {
			pavimento = sistemaFacade.findPavimento(idCliente);
			sistemaFacade.deletePavimento(pavimento);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void pesquisarPavimento(HttpServletRequest request,HttpServletResponse response) {
		/* NÃO TERÁ FILTROS */
	}
}
