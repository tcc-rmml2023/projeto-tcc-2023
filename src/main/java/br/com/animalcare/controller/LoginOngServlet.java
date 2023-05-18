package br.com.animalcare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.dao.DaoOng;

@WebServlet(name = "LoginOngServlet", urlPatterns = { "/LoginOngServlet" })
public class LoginOngServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginOngServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		try {
			DaoOng ongDao = new DaoOng();
			Ong loginOng = new Ong();
			loginOng = ongDao.buscarOngPorEmail(email, senha);

			boolean loginSucesso = false;

			if (loginOng != null && loginOng.getSenha().equals(senha)) {
				loginSucesso = true;
			}
			
			if (loginSucesso) {
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", loginOng);
				
				response.sendRedirect("PetServlet?action=listarPetsPorOng");
			}

			else {
				request.setAttribute("msg", "Email e/ou senha incorretos! Tente novamente.");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
