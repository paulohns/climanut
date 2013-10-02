	package com.br.climanut.servlet;

	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.br.climanut.bean.Cliente;
import com.br.climanut.dao.ClienteDao;



	/**
	 * Servlet implementation class ServletCidade
	 */
	@WebServlet("/ServletCidade")
	public class ServletCidade extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		}
	}
