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

@WebServlet("/ExcluirPetServlet")
public class ExcluirPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirPetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DaoPet daoPet = new DaoPet();
			
			HttpSession session = request.getSession();
			Ong ong = (Ong) session.getAttribute("usuarioLogado"); 
			
			String id = request.getParameter("id_pet"); 
			int id_pet = Integer.parseInt(id);
			
			Pet pet = new Pet();
			pet.setId_pet(id_pet);
			pet.setId_ong(ong.getId_ong());
			
			boolean excluido = daoPet.excluirPet(pet, ong);
			if(excluido) {
				request.setAttribute("msg", "Pet excluído com sucesso!!");	
			}
			else {
				request.setAttribute("msg", "Erro ao tentar excluír pet!! Tente novamente");			
			}
			RequestDispatcher rd = request.getRequestDispatcher("PetServlet?action=listarPetsPorOng");
			rd.forward(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
