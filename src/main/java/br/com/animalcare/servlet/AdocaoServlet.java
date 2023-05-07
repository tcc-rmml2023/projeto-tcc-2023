package br.com.animalcare.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animalcare.bean.Email;
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
		
		//String id = request.getParameter("id_pet");
		//int id_pet = Integer.parseInt(id);
		
		try {
			//DaoPet petDao = new DaoPet();
			//Ong ong = new Ong();
			//Pet pet = new Pet();
			
			Email mail = new Email();
			
			mail.setEmailAdotante(request.getParameter("email"));
			
			StringBuffer mensagem = new StringBuffer();
			
			mensagem.append("<h2 align='center'>AnimalCare</h2>");
			mensagem.append("Informações Enviadas:<br/>");
			
			mensagem.append("ID pet: ");
			mensagem.append(request.getParameter("id_pet"));
			mensagem.append("<br/>");
			
			mensagem.append("Nome do pet:");
			mensagem.append(request.getParameter("nome_pet"));
			mensagem.append("<br/>");
			
			mensagem.append("Nome: ");
			mensagem.append(request.getParameter("nome_adotante"));
			mensagem.append("<br/>");
			
			mensagem.append("CPF: ");
			mensagem.append(request.getParameter("cpf"));
			mensagem.append("<br/>");
			
			mensagem.append("Email: ");
			mensagem.append(request.getParameter("email"));
			mensagem.append("<br/>");
			
			mensagem.append("Telefone: ");
			mensagem.append(request.getParameter("telefone"));
			mensagem.append("<br/>");
			
			mail.setMensagem(mensagem.toString());
			
			boolean enviou = mail.enviarGmail();
			
			if (enviou) {
	            
				RequestDispatcher rd = request.getRequestDispatcher("Dados enviados com sucesso.");
				request.setAttribute("msg", "Dados enviados com sucesso.");
				rd.forward(request, response);
	           
	        } else {
	            request.setAttribute("msg", "Não foi possível realizar a solicitação.");
	            response.sendRedirect("solicitacao_adocao.jsp");
	        }
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
