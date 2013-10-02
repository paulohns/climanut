package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.br.climanut.bean.Chamado;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Contato;
import com.br.climanut.bean.Pessoa;
import com.br.climanut.facade.ChamadoFacade;
import com.br.climanut.facade.ClienteFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.Gson;



/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
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
		if (operacao.equals("PesquisarAutocompleteCliente")) {
			String termo = request.getParameter("termo");
			try {
				autocompleteCliente(request, response, operacao,termo);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void autocompleteCliente(HttpServletRequest request,HttpServletResponse response, String operacao, String termo) throws IOException, JSONException {
		try {
			List<Cliente> listaClientes = new ArrayList<Cliente>();
			JSONArray arrayObj = new JSONArray();
			ClienteFacade clienteFacade = new ClienteFacade();
			
				listaClientes = clienteFacade.findAll();
			
			
	        termo = termo.toLowerCase();
	        String [] nomesCliente = new String [listaClientes.size()];
	        
	        for (int i = 0; i < listaClientes.size(); i++) {
	        	String nomes = listaClientes.get(i).getNomeAmbiente().toLowerCase();
	        	if(nomes.startsWith(termo)){
	        		System.out.println(listaClientes.get(i).getNomeAmbiente());
	        		nomesCliente[i] = listaClientes.get(i).getNomeAmbiente();
	        		arrayObj.put(nomesCliente[i]);
	        	}
			}
	        
	        System.out.println("Array:"+arrayObj);
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(arrayObj.toString());
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
