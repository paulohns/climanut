package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.climanut.bean.Equipamento;
import com.br.climanut.facade.EquipamentoFacade;
import com.br.climanut.utils.ClimanutExceptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



/**
 * Servlet implementation class ServletEquipamento
 */
@WebServlet("/ServletEquipamento")
public class ServletEquipamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Equipamento equipamento;
	EquipamentoFacade equipamentoFacade;
	
	/**
	 * Recuperando insformacoes de equipamento informados na tela
	 */
	
//	equipamento.setStatus(Integer.valueOf(request.getParameter("status")));

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		System.out.println(request.getParameter("numeroSerie") + " - "+request.getParameter("marca") + " - ");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		String operacao = request.getParameter("acao");
		
		try {
		
			if(operacao != null){
				System.out.println(operacao);
				if (operacao.equalsIgnoreCase("Incluir")) {
					incluirEquipamento(request, response);
				}else if(operacao.equalsIgnoreCase("Alterar")){
					System.out.println("Alterar");
					alterarEquipamento(request, response);
				}else if(operacao.equalsIgnoreCase("Excluir")){
					System.out.println("Excluir");
					excluirEquipamento(request, response);
				}else if(operacao.equalsIgnoreCase("Pesquisar")){
					pesquisarEquipamento(request, response);
				}	
			}
		} catch (Exception e) {
			System.out.println("Operação Desconhecida!");
			e.printStackTrace();
		}
		
	}
	private void incluirEquipamento(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			equipamento = new Equipamento();
			equipamentoFacade = new EquipamentoFacade();
			
			String campoPeriodicidade = request.getParameter("periodicidade");
			String campoBtu = request.getParameter("btu");
			
			double btu = Double.parseDouble(campoBtu);
		    Integer periodicidade =  Integer.valueOf(campoPeriodicidade);  
			
			/* VALIDAR SE CAMPOS QUE ESTÃO VAZIOS PODEM SALVAR VAZIOS - (numeroSerie e modelo) */
			
			if(request.getParameter("numeroSerie") != ""){
				equipamento.setNumeroSerie(request.getParameter("numeroSerie"));
			}
			if(request.getParameter("modelo") != ""){
				equipamento.setModelo(request.getParameter("modelo"));
			}
				equipamento.setMarca(request.getParameter("marca"));
				equipamento.setBtu(btu);
				equipamento.setPeriodicidadeManutencao(periodicidade);
				equipamento.setStatus(1);
				equipamentoFacade.create(equipamento);
		} catch (ClimanutExceptions climaExc) {
			System.out.println(climaExc.getCodigoErro() + " - " + climaExc.getDescricaoErro());
			climaExc.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void alterarEquipamento(HttpServletRequest request,HttpServletResponse response) throws ClimanutExceptions {
		
		equipamento = new Equipamento();
		equipamentoFacade = new EquipamentoFacade();
		
		String campoIdEquipamento = request.getParameter("idEquipamento");
		String campoPeriodicidade = request.getParameter("periodicidade");
		String campoBtu = request.getParameter("btu");
		String campoStatus = request.getParameter("status");
		
		Integer status = Integer.valueOf(campoStatus);
		Integer idEquipamento = Integer.valueOf(campoIdEquipamento);
		double btu = Double.parseDouble(campoBtu);
	    Integer periodicidade =  Integer.valueOf(campoPeriodicidade);   
		
		/* VALIDAR SE CAMPOS QUE ESTÃO VAZIOS PODEM SALVAR VAZIOS - (numeroSerie e modelo) */
		try {
			if(request.getParameter("numeroSerie") != ""){
				equipamento.setNumeroSerie(request.getParameter("numeroSerie"));
			}
			if(request.getParameter("modelo") != ""){
				equipamento.setModelo(request.getParameter("modelo"));
			}
				equipamento.setMarca(request.getParameter("marca"));
				equipamento.setBtu(btu);
				equipamento.setPeriodicidadeManutencao(periodicidade);
				equipamento.setStatus(status);
				equipamento.setIdEquipamento(idEquipamento);
				equipamentoFacade.update(equipamento);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void excluirEquipamento(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			equipamento = new Equipamento();
			equipamentoFacade = new EquipamentoFacade();
			
			String campoEquipamento = request.getParameter("idEquipamento");
			Integer idEquipamento = Integer.valueOf(campoEquipamento);
		
			equipamento = equipamentoFacade.find(idEquipamento);
			equipamentoFacade.delete(equipamento);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private void pesquisarEquipamento(HttpServletRequest request,HttpServletResponse response) throws ClimanutExceptions, IOException {
		
		equipamentoFacade = new EquipamentoFacade();
		List<Equipamento> listaEquipamento = equipamentoFacade.findAll();
		String status = null;
		String periodicidade = null;
		JsonArray array = new JsonArray();
		
		for (Equipamento equipamento : listaEquipamento) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("idEquipamento", equipamento.getIdEquipamento());
			jsonObject.addProperty("numeroSerie", equipamento.getNumeroSerie());
			jsonObject.addProperty("marca", equipamento.getMarca());
			jsonObject.addProperty("modelo", equipamento.getModelo());
			System.out.println("Periodicidadeee:"+equipamento.getPeriodicidadeManutencao());
			int p = equipamento.getPeriodicidadeManutencao();
			System.out.println(p);
			if(equipamento.getPeriodicidadeManutencao() == 1){
				periodicidade = "Mensal";
			}else if(equipamento.getPeriodicidadeManutencao()== 2){
				periodicidade = "Bimestral";
			}
			else if(equipamento.getPeriodicidadeManutencao()== 3){
				periodicidade = "Trimestral";
			}
			else if(equipamento.getPeriodicidadeManutencao()== 6){
				periodicidade = "Semestral";
			}
			else if(equipamento.getPeriodicidadeManutencao()== 12){
				periodicidade = "Anual";
			}
			jsonObject.addProperty("periodicidadeManutencao", periodicidade);
			jsonObject.addProperty("btu", equipamento.getBtu());
			if(equipamento.getStatus()==1){
				status = "Ativo";
			}else{
				status = "Inativo";
			}
			jsonObject.addProperty("status", status);
			array.add(jsonObject);
		}
		
		PrintWriter out = response.getWriter(); 
        response.setContentType("text/text;charset=utf-8");
        out.println(array);
	
	}
		
}	
		


