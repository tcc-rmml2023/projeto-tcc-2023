package br.com.animalcare.servlet;

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

@WebServlet("/AlterarPetServlet")
public class AlterarPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AlterarPetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DaoPet daoPet = new DaoPet();
			Ong ong = new Ong();
			boolean alterado = false;
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			String id = request.getParameter("id_pet"); 
			int id_pet = Integer.parseInt(id);
			
			Pet pet = new Pet();
			pet.setNome_pet(request.getParameter("nome_pet"));
			pet.setIdade(request.getParameter("idade"));
			pet.setGenero(request.getParameter("genero"));
			pet.setObs(request.getParameter("obs"));
			pet.setId_pet(id_pet);
			pet.setId_ong(ong.getId_ong());
			
			alterado = daoPet.alterarPet(pet, ong);
			
			if(alterado) {
				request.setAttribute("msg", "Pet alterado com sucesso!!");
			}
			else {
				request.setAttribute("msg", "Erro ao excluir pet!! Tente novamente!");
			}
			RequestDispatcher rd = request.getRequestDispatcher("PetServlet?action=listarPetsPorOng");
			rd.forward(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
