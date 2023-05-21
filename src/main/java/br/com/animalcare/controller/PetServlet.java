package br.com.animalcare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.bean.Pet;
import br.com.animalcare.dao.DaoPet;

@WebServlet(name="PetServlet", urlPatterns = {"/PetServlet"})
@MultipartConfig
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PetServlet() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		    doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String acao = request.getParameter("action");
		
		if(acao.equals("listarTodosPets")) {
			listarTodosPets(request, response);
		}
		
		if(acao.equals("listarPetsPorOng")) {
			listarPetsPorOng(request, response);
		}
	}
	
	protected void listarTodosPets(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
		    DaoPet daoPet = new DaoPet();
			ArrayList<Pet> lista = new ArrayList<>();
			
			lista = daoPet.buscarPetOng();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista_pets_adocao.jsp");
			rd.forward(request, response);

		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	protected void listarPetsPorOng(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			DaoPet daoPet = new DaoPet();
			ArrayList<Pet> lista = new ArrayList<>();
			Ong ong = null;
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			lista = daoPet.listarPet(ong);
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista_pets_ong.jsp");
			rd.forward(request, response);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
