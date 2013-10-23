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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.br.climanut.bean.Bloco;
import com.br.climanut.bean.Chamado;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Contato;
import com.br.climanut.bean.Pessoa;
import com.br.climanut.facade.ChamadoFacade;
import com.br.climanut.facade.ClienteFacade;
import com.br.climanut.facade.SistemaFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletBloco")
public class ServletBloco extends HttpServlet {
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
		if (operacao.equals("Incluir")) {
			incluirCliente(request, response);
		}
		if (operacao.equals("Alterar")) {
			alterarCliente(request, response);
		}
		if (operacao.equals("Excluir")) {
			excluirCliente(request, response);
		}
		if (operacao.equals("Pesquisar")) {
			pesquisarCliente(request, response);
		}
		if (operacao.equals("PesquisarAutocompleteBlocoPorCliente")) {
			String termo = request.getParameter("termo");
			System.out.println("termo:"+termo);
			String campoIdCliente = request.getParameter("idCliente");
			System.out.println("campoIdCliente:"+campoIdCliente);
			int idCliente = Integer.valueOf(campoIdCliente);
			System.out.println("IdCliente:"+idCliente);
			try {
				autocompleteBlocoPorCliente(request, response, operacao,termo,idCliente);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void autocompleteBlocoPorCliente(HttpServletRequest request,HttpServletResponse response, String operacao, String termo,Integer idCliente) throws IOException, JSONException {
		try {
			List<Bloco> listaBlocos = new ArrayList<Bloco>();
			JsonArray array = new JsonArray();
			JsonObject jsonObject;
			SistemaFacade sistemaFacade = new SistemaFacade();
			
			
			try {
				listaBlocos = sistemaFacade.filter(idCliente);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
	        termo = termo.toLowerCase();
	        String [] nomesCliente = new String [listaBlocos.size()];
	        
	        for (int i = 0; i < listaBlocos.size(); i++) {
	        	String nomes = listaBlocos.get(i).getDescricaoBloco().toLowerCase();
	        	if(nomes.startsWith(termo)){
	        		System.out.println(listaBlocos.get(i).getDescricaoBloco());
	        		nomesCliente[i] = listaBlocos.get(i).getDescricaoBloco();
	        		jsonObject = new JsonObject();
	        		jsonObject.addProperty("id",listaBlocos.get(i).getIdBloco());
	        		jsonObject.addProperty("nome",listaBlocos.get(i).getDescricaoBloco());
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

	private void incluirCliente(HttpServletRequest request,HttpServletResponse response) {
		
	}

	private void alterarCliente(HttpServletRequest request,HttpServletResponse response) {

	}
	/* SÓ PODERÁ EXCLUIR CLIENTE SE O MESMO NÃO TIVER RELACIONAMENTO */
	private void excluirCliente(HttpServletRequest request,HttpServletResponse response) {
		
		Cliente cliente = new Cliente();
		ClienteFacade clienteFacade = new ClienteFacade();
		
		String campoCliente = request.getParameter("idCliente");
		int idCliente = Integer.valueOf(campoCliente);
		
		try {
			cliente = clienteFacade.find(idCliente);
			clienteFacade.delete(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void pesquisarCliente(HttpServletRequest request,HttpServletResponse response) {
		/* NÃO TERÁ FILTROS */
	}
}
