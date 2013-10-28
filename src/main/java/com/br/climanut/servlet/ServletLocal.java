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
import com.br.climanut.bean.Local;
import com.br.climanut.facade.SistemaFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletLocal")
public class ServletLocal extends HttpServlet {
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
		if (operacao.equals("IncluirLocal")) {
			incluirLocal(request, response);
		}
		if (operacao.equals("AlterarLocal")) {
			alterarLocal(request, response);
		}
		if (operacao.equals("ExcluirLocal")) {
			excluirLocal(request, response);
		}
		if (operacao.equals("PesquisarLocal")) {
			pesquisarLocal(request, response);
		}
		if (operacao.equals("PesquisarAutocompleteLocalPorPavimento")) {
			String termo = request.getParameter("termo");
			String campoIdPavimento = request.getParameter("idPavimentoEquipamento");
			System.out.println("campoIdPavimento:"+campoIdPavimento);
			int idPavimento = Integer.valueOf(campoIdPavimento);
			System.out.println("idPavimento:"+idPavimento);
			try {
				autocompleteLocalPorPavimento(request, response, operacao,termo,idPavimento);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void autocompleteLocalPorPavimento(HttpServletRequest request,HttpServletResponse response, String operacao, String termo,Integer idPavimento) throws IOException, JSONException {
		try {
			List<Local> listaLocais = new ArrayList<Local>();
			JsonArray array = new JsonArray();
			JsonObject jsonObject;
			SistemaFacade sistemaFacade = new SistemaFacade();
			
			
			try {
				listaLocais = sistemaFacade.filterLocal(idPavimento);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
	        termo = termo.toLowerCase();
	        String [] nomesLocais = new String [listaLocais.size()];
	        
	        for (int i = 0; i < listaLocais.size(); i++) {
	        	String nomes = listaLocais.get(i).getDescricaoLocal().toLowerCase();
	        	if(nomes.startsWith(termo)){
	        		System.out.println(listaLocais.get(i).getDescricaoLocal());
	        		nomesLocais[i] = listaLocais.get(i).getDescricaoLocal();
	        		jsonObject = new JsonObject();
	        		jsonObject.addProperty("id",listaLocais.get(i).getIdLocal());
	        		jsonObject.addProperty("nome",listaLocais.get(i).getDescricaoLocal());
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

	private void incluirLocal(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarLocal(HttpServletRequest request,HttpServletResponse response) {

	}
	/* SÓ PODERÁ EXCLUIR CLIENTE SE O MESMO NÃO TIVER RELACIONAMENTO */
	private void excluirLocal(HttpServletRequest request,HttpServletResponse response) {
		
		Bloco bloco = new Bloco();
		SistemaFacade sistemaFacade = new SistemaFacade();
		
		String campoIdBloco = request.getParameter("idBloco");
		int idBloco = Integer.valueOf(campoIdBloco);
		
		try {
			bloco = sistemaFacade.findBloco(idBloco);
			sistemaFacade.deleteBloco(bloco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void pesquisarLocal(HttpServletRequest request,HttpServletResponse response) {
		/* NÃO TERÁ FILTROS */
	}
}
