package com.br.climanut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "Tela inicial do sistema ", urlPatterns = { "/Acesso" })
public class Acesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		System.out.println("area tecnico");
		request.getRequestDispatcher("paginas/telaInicial/menuPrincipal.jsp").forward(request, response);
	}

}
