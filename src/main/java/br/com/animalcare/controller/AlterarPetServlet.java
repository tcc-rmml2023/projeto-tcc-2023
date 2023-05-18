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
import br.com.animalcare.bean.Pet;
import br.com.animalcare.dao.DaoPet;

@WebServlet(name = "AlterarPetServlet", urlPatterns = {"/AlterarPetServlet"})
public class AlterarPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AlterarPetServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Pet pet = new Pet();
			DaoPet daoPet = new DaoPet();
			
			String id = request.getParameter("id_pet");
			int id_pet = Integer.parseInt(id);
			
			pet.setId_pet(id_pet);
			
			daoPet = new DaoPet();
			daoPet.buscaPetPorId(pet);
			
			RequestDispatcher rd = request.getRequestDispatcher("alterar_pet.jsp");
			
			request.setAttribute("id_pet", pet.getId_pet());
			request.setAttribute("nome_pet",pet.getNome_pet());
			request.setAttribute("idade", pet.getIdade());
			request.setAttribute("genero", pet .getGenero());
			request.setAttribute("obs", pet.getObs());
			
			rd.forward(request, response);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			DaoPet daoPet = new DaoPet();
			Ong ong = new Ong();
			Pet pet = new Pet();
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			String id = request.getParameter("id_pet"); 
			int id_pet = Integer.parseInt(id);	
			
			pet = new Pet();
			pet.setId_pet(id_pet);
			pet.setNome_pet(request.getParameter("nome_pet"));
			pet.setIdade(request.getParameter("idade"));
			pet.setGenero(request.getParameter("genero"));
			pet.setObs(request.getParameter("obs"));
			pet.setId_ong(ong.getId_ong());
			
			boolean alterado = daoPet.alterarPet(pet);
			if(alterado) {
				RequestDispatcher rd = request.getRequestDispatcher("sucess_alterar_pet.jsp");
				request.setAttribute("msg", "Pet alterado com sucesso!!");
				rd.forward(request, response);
			}
			
			else {
				response.sendRedirect("PetServlet?action=listarPetsPorOng");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
