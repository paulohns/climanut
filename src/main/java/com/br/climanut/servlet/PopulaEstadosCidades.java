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





import org.json.JSONObject;

import com.br.climanut.bean.Bloco;
import com.br.climanut.bean.Cidade;
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Estado;
import com.br.climanut.facade.CidadeFacade;
import com.br.climanut.facade.EstadoFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * Servlet implementation class PopulaEstadosCidades
 */
@WebServlet("/PopulaEstadosCidades")
public class PopulaEstadosCidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulaEstadosCidades() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		//String campoIdEstado = request.getParameter("idEstado");
		//Integer idEstado = Integer.valueOf(campoIdEstado);
		System.out.println("ação:"+acao);
			
			if(acao.equals("Estados")){
				populaEstados(response,request);
				
			}else if(acao.equals("Cidades")){
				System.out.println("Cidadesssss");
				populaCidades(response,request);
			}
		
		/*String nomeEstado = request.getParameter("estado");
		List <Estado> nomeCidades = new EnderecoDao().buscaCidades("PR");
	
		OutputStream out = response.getOutputStream();
		out.write(nomeCidades.toString().getBytes());*/
	
	}

	private void populaCidades(HttpServletResponse response,HttpServletRequest request) throws IOException {
		try {
			
			String estado = request.getParameter("sigla");
			JsonArray arrayCidades = new JsonArray();
			JsonObject jsonObj;
			CidadeFacade cidadeFacade = new CidadeFacade();
			
			List<Cidade> listaCidades = new ArrayList<Cidade>();
		
			listaCidades = cidadeFacade.findAll();
			String termo = estado;
	       // termo = termo.toLowerCase();
	        
	        if(listaCidades.size() != 0){
		        for (int i = 0; i < listaCidades.size(); i++) {
		        	String nomes = listaCidades.get(i).getEstado().getSigla().toLowerCase();
		        	if(nomes.equalsIgnoreCase(termo)){
		        		System.out.println(listaCidades.get(i).getEstado().getSigla());
		        		jsonObj = new JsonObject();
						jsonObj.addProperty("idCidade", listaCidades.get(i).getIdCidade());
						jsonObj.addProperty("nomeCidade",listaCidades.get(i).getNomeCidade());
						arrayCidades.add(jsonObj);
		        	}
				}
	        }
			
			PrintWriter out = response.getWriter(); 
		    response.setContentType("text/text;charset=utf-8");
		    out.println(arrayCidades);
			System.out.println(arrayCidades);
			
		} catch (ClimanutExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void populaEstados(HttpServletResponse response,HttpServletRequest request) throws IOException {
		try {
			
			JsonArray arrayEstados = new JsonArray();
			JsonObject jsonObj;
			EstadoFacade estadoFacade = new EstadoFacade();
			
			List<Estado> listaEstados = new ArrayList<Estado>();
			
				listaEstados = estadoFacade.findAll();
				
				for (Estado estado : listaEstados) {
					jsonObj = new JsonObject();
					jsonObj.addProperty("sigla", estado.getSigla());
					jsonObj.addProperty("nomeEstado",estado.getEstado());
					arrayEstados.add(jsonObj);
				}
				
				PrintWriter out = response.getWriter(); 
		        response.setContentType("text/text;charset=utf-8");
		        out.println(arrayEstados);
				System.out.println(arrayEstados);
				
			} catch (ClimanutExceptions e) {
				e.printStackTrace();
			}
		
	}

	
}
