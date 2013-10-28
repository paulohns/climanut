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
import com.br.climanut.bean.Cliente;
import com.br.climanut.bean.Equipamento;
import com.br.climanut.bean.EquipamentosPorLocal;
import com.br.climanut.bean.Local;
import com.br.climanut.bean.Localizacao;
import com.br.climanut.bean.Pavimento;
import com.br.climanut.bean.Sistema;
import com.br.climanut.facade.ClienteFacade;
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
	Cliente cliente;
	Bloco bloco;
	Pavimento pavimento;
	Local local;
	EquipamentosPorLocal equipamentosPorLocal;
	SistemaFacade sistemaFacade;
	ClienteFacade clienteFacade;
       
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
			}else if (operacao.equalsIgnoreCase("IncluirEquipamentosPorLocal")) {
				System.out.println("IncluirEquipamentosPorLocal");
				incluirEquipamentosPorLocal(request, response);
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
			
			List<Sistema> listaClientes = new ArrayList<Sistema>();
			
			listaClientes = sistemaFacade.filterSistema(idCliente);
	        String msg = "ok";
	        JSONObject json = new JSONObject();
	        
	        if(listaClientes.size() != 0){
		        	msg = "erro";
	        }
	        if(msg.equals("ok")){
	        	
	        	cliente = new Cliente();
				cliente.setIdCliente(idCliente);
				sistema.setCliente(cliente);
				sistema.setStatus(1);
	        	sistemaFacade.create(sistema);
	        }
	        json.put("msg",msg);
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(json);
	        out.close();
			
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
			
			List<Bloco> listaBlocos = new ArrayList<Bloco>();

			listaBlocos = sistemaFacade.filterBloco(idCliente);
			String termo = campoBloco;
	        termo = termo.toLowerCase();
	        String msg = "ok";
	        JSONObject json = new JSONObject();
	        
	        if(listaBlocos.size() != 0){
		        for (int i = 0; i < listaBlocos.size(); i++) {
		        	String nomes = listaBlocos.get(i).getDescricaoBloco().toLowerCase();
		        	if(nomes.equalsIgnoreCase(termo)){
		        		System.out.println(listaBlocos.get(i).getDescricaoBloco());
		        		msg = "erro";
		        	}
				}
	        }
	        if(msg.equals("ok")){
	        	cliente = new Cliente();
				cliente.setIdCliente(idCliente);
				bloco = new Bloco();
				bloco.setCliente(cliente);
				bloco.setDescricaoBloco(campoBloco);
				sistemaFacade.createBloco(bloco);
	        }
	        json.put("msg",msg);
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(json);
	        out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	private void incluirPavimento(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			sistema = new Sistema();
			sistemaFacade = new SistemaFacade();
			
			String campoIdCliente = request.getParameter("idClientePavimento");
			System.out.println("campoIdCliente:"+campoIdCliente);
			int idCliente = Integer.valueOf(campoIdCliente);
			System.out.println("idCliente:"+idCliente);
			String campoIdBlocoPavimento = request.getParameter("idBlocoPavimento");
			System.out.println("campoIdBlocoPavimento:"+campoIdBlocoPavimento);
			int idBloco = Integer.valueOf(campoIdBlocoPavimento);
			System.out.println("idBloco:"+idBloco);
			String campoPavimento = request.getParameter("pavimento");
			System.out.println("campoPavimento:"+campoPavimento);
			
			List<Pavimento> listaPavimentos = new ArrayList<Pavimento>();

			listaPavimentos = sistemaFacade.filterPavimento(idBloco);
			String termo = campoPavimento;
	        termo = termo.toLowerCase();
	        String msg = "ok";
	        JSONObject json = new JSONObject();
	        
	        if(listaPavimentos.size() != 0){
		        for (int i = 0; i < listaPavimentos.size(); i++) {
		        	String nomes = listaPavimentos.get(i).getDescricaoPavimento().toLowerCase();
		        	if(nomes.equalsIgnoreCase(termo)){
		        		System.out.println(listaPavimentos.get(i).getDescricaoPavimento());
		        		msg = "erro";
		        	}
				}
	        }
	        if(msg.equals("ok")){
	        	cliente = new Cliente();
				cliente.setIdCliente(idCliente);
				bloco = new Bloco();
				bloco.setIdBloco(idBloco);
				bloco.setCliente(cliente);
				pavimento = new Pavimento();
				pavimento.setBloco(bloco);
				pavimento.setDescricaoPavimento(campoPavimento);
				sistemaFacade.createPavimento(pavimento);
	        }
	        json.put("msg",msg);
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(json);
	        out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void incluirLocal(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			sistema = new Sistema();
			sistemaFacade = new SistemaFacade();
			
			String campoIdClienteLocal = request.getParameter("idClienteLocal");
			System.out.println("campoIdClienteLocal:"+campoIdClienteLocal);
			int idCliente = Integer.valueOf(campoIdClienteLocal);
			System.out.println("idCliente:"+idCliente);
			String campoIdBlocoLocal = request.getParameter("idBlocoLocal");
			System.out.println("campoIdBlocoLocal:"+campoIdBlocoLocal);
			int idBloco = Integer.valueOf(campoIdBlocoLocal);
			System.out.println("idBloco:"+idBloco);
			String campoIdPavimentoLocal = request.getParameter("idPavimentoLocal");
			System.out.println("campoIdPavimentoLocal:"+campoIdPavimentoLocal);
			int idPavimento = Integer.valueOf(campoIdPavimentoLocal);
			System.out.println("idBloco:"+idPavimento);
			String campoLocal = request.getParameter("local");
			System.out.println("campoLocal:"+campoLocal);
			
			List<Local> listaLocais = new ArrayList<Local>();

			listaLocais = sistemaFacade.filterLocal(idPavimento);
			String termo = campoLocal;
	        termo = termo.toLowerCase();
	        String msg = "ok";
	        JSONObject json = new JSONObject();
	        
	        if(listaLocais.size() != 0){
		        for (int i = 0; i < listaLocais.size(); i++) {
		        	String nomes = listaLocais.get(i).getDescricaoLocal().toLowerCase();
		        	if(nomes.equalsIgnoreCase(termo)){
		        		System.out.println(listaLocais.get(i).getDescricaoLocal());
		        		msg = "erro";
		        	}
				}
	        }
	        if(msg.equals("ok")){
	        	cliente = new Cliente();
				cliente.setIdCliente(idCliente);
				bloco = new Bloco();
				bloco.setIdBloco(idBloco);
				bloco.setCliente(cliente);
				pavimento = new Pavimento();
				pavimento.setIdPavimento(idPavimento);
				pavimento.setBloco(bloco);
				local = new Local();
				local.setDescricaoLocal(campoLocal);
				local.setPavimento(pavimento);
				sistemaFacade.createLocal(local);
	        }
	        json.put("msg",msg);
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(json);
	        out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	private void incluirEquipamentosPorLocal(HttpServletRequest request,HttpServletResponse response) {
		try {
			
			equipamentosPorLocal = new EquipamentosPorLocal();
			sistemaFacade = new SistemaFacade();
			
			String campoIdClienteEquipamento = request.getParameter("idClienteEquipamento");
			String campoIdLocalEquipamento = request.getParameter("idLocalEquipamento");
			String campoIdEquipamento = request.getParameter("idEquipamento");
			String numeroInterno = request.getParameter("numeroInterno");
			
			Integer idCliente = Integer.parseInt(campoIdClienteEquipamento);
			Integer idLocal = Integer.parseInt(campoIdLocalEquipamento);
			Integer idEquipamento = Integer.parseInt(campoIdEquipamento);
			
			Cliente cliente = new Cliente();
			cliente.setIdCliente(idCliente);
			Local local = new Local();
			local.setIdLocal(idLocal);
			Equipamento equipamento = new Equipamento();
			equipamento.setIdEquipamento(idEquipamento);
			
			equipamentosPorLocal.setCliente(cliente);
			equipamentosPorLocal.setLocal(local);
			equipamentosPorLocal.setEquipamento(equipamento);
			equipamentosPorLocal.setStatus(1);
			equipamentosPorLocal.setNumeroInterno(numeroInterno);
			
			List<EquipamentosPorLocal> listaEquipamentos = new ArrayList<EquipamentosPorLocal>();

			listaEquipamentos = sistemaFacade.findAllEquipamentosPorLocal();
			String termo = numeroInterno;
	        termo = termo.toLowerCase();
	        String msg = "ok";
	        JSONObject json = new JSONObject();
	        
	        if(listaEquipamentos.size() != 0){
		        for (int i = 0; i < listaEquipamentos.size(); i++) {
		        	String nomes = listaEquipamentos.get(i).getNumeroInterno().toLowerCase();
		        	if(nomes.equalsIgnoreCase(termo)){
		        		System.out.println(listaEquipamentos.get(i).getNumeroInterno());
		        		msg = "erro";
		        	}
				}
	        }
	        if(msg.equals("ok")){
	        	sistemaFacade.createEquipamentosPorLocal(equipamentosPorLocal);
	        }
	        json.put("msg",msg);
			PrintWriter out = response.getWriter();
	        response.setContentType("text/text;charset=utf-8");
	        out.println(json);
	        out.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
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
