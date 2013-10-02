package com.br.climanut.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.climanut.bean.Cidade;
import com.br.climanut.bean.Estado;
import com.br.climanut.bean.Pessoa;
import com.br.climanut.bean.Tecnico;
import com.br.climanut.facade.PessoaFacade;
import com.br.climanut.facade.TecnicoFacade;
import com.br.climanut.utils.ClimanutExceptions;

/**
 * Servlet implementation class ServletTecnico
 */
@WebServlet("/ServletTecnico")
public class ServletTecnico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String operacao = request.getParameter("acao");
		System.out.println("operação:"+operacao);
		
		try {
		
			if(operacao != null){
				
				Pessoa pessoa = new Pessoa();
				Tecnico tecnico = new Tecnico();
				Cidade cidade = new Cidade();
				Estado estado = new Estado();
				
				/**
				 * Recuperando insformacoes de estado informados na tela
				 * 
				 * RECUPERAR O ID DO ESTADO ATRAVES DO SELECT
				 */
				if(request.getParameter("estado") != null){
					String campoEstado = request.getParameter("estado");
					
				} else {
					throw new ClimanutExceptions("Estado nao foi recuperada", 404);
				}
				//				estado.setIdEstado(18);
				
				/**
				 * Recuperando insformacoes de cidade informados na tela
				 * 
				 * RECUPERAR O ID DA CIDADE ATRAVES DO SELECT
				 */
				if(request.getParameter("cidade") != null){
					String campoCidade = request.getParameter("cidade");
				} else {
					throw new ClimanutExceptions("Cidade nao foi recuperada", 404);
				}
//				cidade.setIdCidade(5915);
				cidade.setEstado(estado);
				
				/**
				 * Recuperando insformacoes de pessoa informados na tela
				 */
				pessoa.setNome(request.getParameter("nome"));
				pessoa.setLogin(request.getParameter("login"));
				pessoa.setSenha(request.getParameter("senha"));
				
				if(request.getParameter("cpf") != null){
					pessoa.setIdFederal(Long.valueOf(
							request.getParameter("cpf").replace(".", "").replace("-", "")
							));
				} else {
					throw new ClimanutExceptions("CPF/CNPJ NÃO INFORMADO",404);
				}
				
				if(request.getParameter("telefoneCelular") != null){
					pessoa.setTelefoneCelular(
							request.getParameter("telefoneCelular").replace("(", "").replace(")", "").replace("-", "")
							);
				}
				
				if(request.getParameter("telefoneFixo") != null){
					pessoa.setTelefoneFixo(
							request.getParameter("telefoneFixo").replace("(", "").replace(")", "").replace("-", "")
							);
				}
				
				pessoa.setTipoUsuario(1);
				
				pessoa.setBairro(request.getParameter("bairro"));
				pessoa.setComplemento(request.getParameter("complemento"));
				pessoa.setNumero(request.getParameter("numero"));
				pessoa.setCidade(cidade);
				
				/**
				 * Recuperando insformacoes de tecnico informados na tela
				 */
				if(request.getParameter("art") != null){
					tecnico.setArt(Long.valueOf(request.getParameter("art")));
				} else {
					throw new ClimanutExceptions("ART não informado", 404);
				}
				
				if(request.getParameter("registro") != null){
					tecnico.setRegistro(Long.valueOf(request.getParameter("registro")));
				} else {
					throw new ClimanutExceptions("REGISTRO não informado", 404);
				}
				
				System.out.println(request.getParameter("engenheiro"));
				
				if(request.getParameter("engenheiro") != null){
					tecnico.setEngenheiro(true);
				} else {
					tecnico.setEngenheiro(false);
				}
				tecnico.setPessoa(pessoa);
				
				
				if("Pesquisar".equals(operacao)){
					pesquisarTecnico(request, response, tecnico);
					
				} else if("Incluir".equals(operacao)){
					
					incluirPessoa(request, response, pessoa);
					incluirTecnico(request, response, tecnico);
					
				} else if("Alterar".equals(operacao)){
					
					if(tecnico != null){
						alterarTecnico(request, response, tecnico);
					}
						
				} else if("Excluir".equals(operacao)){
					
					if(tecnico != null && tecnico.getIdTecnico() != null){
						excluirTecnico(request, response, tecnico);
					} else {
						throw new ClimanutExceptions("Codigo do Tecnico nao informado", 100);
					}
				}
			}
		} catch (ClimanutExceptions e) {
			System.out.println("Operação Desconhecida! "+e.getCodigoErro()+"-"+e.getMessage());
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("paginas/menuPrincipal.jsp").forward(request, response);
	}
	
	private void excluirTecnico(HttpServletRequest request,
			HttpServletResponse response, Tecnico tecnico) throws ClimanutExceptions {

		TecnicoFacade tecnicoFacade = new TecnicoFacade();
		
		if(tecnico != null){
			try{
				tecnicoFacade.delete(tecnico);
			} catch(ClimanutExceptions e){
				e.printStackTrace();
			}
		}
		
	}

	private void alterarTecnico(HttpServletRequest request,
			HttpServletResponse response, Tecnico tecnico) throws ClimanutExceptions {
		
		TecnicoFacade tecnicoFacade = new TecnicoFacade();
		
		tecnicoFacade.update(tecnico);
		
	}

	private void incluirTecnico(HttpServletRequest request,
			HttpServletResponse response, Tecnico tecnico) throws ClimanutExceptions {
		
		TecnicoFacade tecnicoFacade = new TecnicoFacade();
		
		try {
			tecnicoFacade.create(tecnico);
		} catch (ClimanutExceptions e) {
			System.out.println(e.getCodigoErro() + " - " + e.getDescricaoErro());
			e.printStackTrace();
		}
		
	}
	
	private void incluirPessoa(HttpServletRequest request,
			HttpServletResponse response, Pessoa pessoa) throws ClimanutExceptions {

		PessoaFacade pessoaFacade = new PessoaFacade();
		
		try {
			pessoaFacade.create(pessoa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private List<Tecnico> pesquisarTecnico(HttpServletRequest request,
			HttpServletResponse response, Tecnico tecnico)throws ClimanutExceptions {

		TecnicoFacade tecnicoFacade = new TecnicoFacade();
		
		List<Tecnico> listaTecnico = new ArrayList<Tecnico>();
		
		try {
			
			listaTecnico = tecnicoFacade.findAll();
			
		} catch (ClimanutExceptions e) {
			System.out.println(e.getCodigoErro() + " - " + e.getDescricaoErro());
			e.printStackTrace();
			return null;
		}
		
		return listaTecnico;
	}
	
}
