

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animalcare.bean.Pet;
import br.com.animalcare.dao.DaoPet;

@WebServlet("/AdocaoServlet")
public class AdocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdocaoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_pet");
		int id_pet = Integer.parseInt(id);
		try {
			Pet pet = new Pet();
			DaoPet petDao = new DaoPet();
			
			pet.setId_pet(id_pet);
			petDao.buscaPetPorId(pet);
			
			RequestDispatcher rd = request.getRequestDispatcher("solicitacao_adocao.jsp");
			request.setAttribute("id_pet", pet.getId_pet());
			request.setAttribute("nome_pet", pet.getNome_pet());
			rd.forward(request, response);
			
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_pet");
		int id_pet = Integer.parseInt(id);
		
		try {
			DaoPet petDao = new DaoPet();
			Pet pet = new Pet();
			
			
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
