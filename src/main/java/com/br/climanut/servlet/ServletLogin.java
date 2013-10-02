package com.br.climanut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.br.climanut.bean.Pessoa;
import com.br.climanut.facade.PessoaFacade;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	HttpSession httpSession;
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("acao"); 
		System.out.println("acao:"+operacao);
		if (operacao.equals("Entrar")) {
			validarLogin(request,response);
		}else
		if (operacao.equals("Sair")) {
			logout(request, response);
		}else
		if (operacao.equals("Usuario")) {
			mostraUsuarioLogado(request, response);
		}else if
		(operacao.equals("Redireciona")){
			redireciona(request,response);
		}
	}
	private void redireciona(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/climanut/paginas/login/index.jsp").forward(request, response);
		
	}

	private void mostraUsuarioLogado(HttpServletRequest request,HttpServletResponse response) {
		
		JSONObject jsonObj = new JSONObject();
		HttpSession httpSession = request.getSession();
		Pessoa p = (Pessoa) httpSession.getAttribute("logado");
		
		try {
			
			if(p != null){
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				jsonObj.put("usuario", p.getNome());
				out.print(jsonObj);
			}else{
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				jsonObj.put("usuario", "invalido");
				out.print(jsonObj);
			}
		
		} catch (JSONException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* LOGAR */
	protected void validarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		JSONObject jsonObj = new JSONObject();
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setLogin(usuario);
		pessoa.setSenha(senha);
		System.out.println("validar");
		PessoaFacade pessoaFacade = new PessoaFacade();
		
		try {
		
			Pessoa pessoaV = pessoaFacade.validateLogin(pessoa);
			if(pessoaV == null){
				request.setAttribute("nomeUsuario", "errorLogin");
	    		request.getRequestDispatcher("paginas/login/index.jsp").forward(request, response);
			}else if(pessoaV.getNome()== null || pessoaV.getTipoUsuario()== null){
					request.setAttribute("nomeUsuario", "errorLogin");
					request.getRequestDispatcher("paginas/login/index.jsp").forward(request, response);
			}else{
				
				String tipoUsuario = pessoaV.getTipoUsuario() == 1 ? "técnico" : "cliente";
				String url = pessoaV.getTipoUsuario() == 1 ? "/telaInicial/menuPrincipal.jsp" 
														   : "/areaCliente/areaCliente.jsp";
								
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				jsonObj.put("usuario",pessoaV.getNome());
				jsonObj.put("tipo",1);
				jsonObj.put("url",url);
				out.print(jsonObj);
				request.getSession().setAttribute("logado", pessoaV);
		        System.out.println("JasonArray:"+jsonObj);
				

			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
						

	}
	/* SAIR DO SISTEMA */
	protected void logout(HttpServletRequest request, HttpServletResponse response){
		
		httpSession = request.getSession();
		httpSession.invalidate();
		
		try {
			request.getRequestDispatcher("/climanut/paginas/login/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
	}
	

}
