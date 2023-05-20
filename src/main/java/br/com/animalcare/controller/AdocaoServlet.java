package br.com.animalcare.controller;


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
			request.setAttribute("idade", pet.getIdade());
			request.setAttribute("genero", pet.getGenero());
			request.setAttribute("obs", pet.getObs());
			request.setAttribute("nome_ong", pet.getOng_nome());
			request.setAttribute("emailOng", pet.getEmailOng());
			
			rd.forward(request, response);
			
		}		
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Email mail = new Email();
			
			mail.setEmailCC(request.getParameter("emailOng"));
			mail.setEmailTo(request.getParameter("email"));
			mail.setAssunto("Solicitação de adoção");
			
			
			StringBuffer mensagem = new StringBuffer();
			
			mensagem.append("<h2 align='center'>AnimalCare - Solicitação de adoção</h2>");
			mensagem.append("<br/>");
			
			mensagem.append("<img src=\"cid:image\">");
			
			mensagem.append("<h5>Informações do pet</h5>");
			mensagem.append("ID pet: ");
			mensagem.append(request.getParameter("id_pet"));
			mensagem.append("<br/>");
			
			mensagem.append("Nome do pet: ");
			mensagem.append(request.getParameter("nome_pet"));
			mensagem.append("<br/>");
			
			mensagem.append("Ong: ");
			mensagem.append(request.getParameter("nome_ong"));
			mensagem.append("<br/>");
			
			mensagem.append("Email ong: ");
			mensagem.append(request.getParameter("emailOng"));
			mensagem.append("<br>");
			
			mensagem.append("<h5>Informações do adotante</h5>");
			mensagem.append("Nome do adotante: ");
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
			
			mail.setMessage(mensagem.toString());
			
			boolean enviou = mail.enviarGmail();
			
			if (enviou) {
	            
				RequestDispatcher rd = request.getRequestDispatcher("solicitacao_adocao.jsp");
				request.setAttribute("msg", "Solicitação enviada com enviada com sucesso."
						+ " Aguarde contato.");
				rd.forward(request, response);
	           
	        } 
			else {
				
				RequestDispatcher rd = request.getRequestDispatcher("solicitacao_adocao.jsp");
				request.setAttribute("msg", "Não foi possível realizar sua solicitação."
						+ " Tente de novo.");
				rd.forward(request, response);
	            
	        }
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
