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

@WebServlet("/InserirPetServlet")
public class InserirPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InserirPetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DaoPet daoPet = new DaoPet();
			Ong ong = new Ong();
			boolean inserido = false;
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			Pet pet = new Pet();
			pet.setNome_pet(request.getParameter("nome_pet"));
			pet.setIdade(request.getParameter("idade"));
			pet.setGenero(request.getParameter("genero"));
			pet.setObs(request.getParameter("obs"));
			pet.setId_ong(ong.getId_ong());
			
			inserido = daoPet.inserirPet(pet, ong);
			
			if(inserido) {
				request.setAttribute("msg", "Pet incluído com sucesso!!");
			}
			else {
				request.setAttribute("msg", "Erro ao incluir pet!! Tente novamente!");
			}
			RequestDispatcher rd = request.getRequestDispatcher("inserir_pet.jsp");
			rd.forward(request, response);
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
