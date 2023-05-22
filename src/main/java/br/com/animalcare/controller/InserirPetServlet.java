package br.com.animalcare.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import br.com.animalcare.bean.Imagem;
import br.com.animalcare.bean.Ong;
import br.com.animalcare.bean.Pet;
import br.com.animalcare.dao.DaoImagem;
import br.com.animalcare.dao.DaoPet;


@WebServlet(name="InserirPetServlet",  urlPatterns = "/InserirPetServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 16)
public class InserirPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public InserirPetServlet() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("inserir_pet.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
		    Ong ong = new Ong();
		    
		    Imagem imagem = new Imagem();
			DaoImagem daoImagem = new DaoImagem();
			
			Pet pet = new Pet();
			DaoPet daoPet = new DaoPet();
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			pet.setNome_pet(request.getParameter("nome_pet"));
			pet.setIdade(request.getParameter("idade"));
			pet.setGenero(request.getParameter("genero"));
			pet.setObs(request.getParameter("obs"));
			pet.setId_ong(ong.getId_ong());
			
			List<String> imagensBase64 = new ArrayList<>();
			List<String> extencoes = new ArrayList<>();
			
			if(request.getParts() != null) {
				
				List<Part> parts = request.getParts().stream().toList();
				
				for(Part p : parts) {
					
					if(p.getContentType() != null && p.getContentType().startsWith("image") ) {
						
						byte[] foto = IOUtils.toByteArray(p.getInputStream());
						@SuppressWarnings("static-access")
						String imagemBase64 = "data:image/" + p.getContentType()
						.split("\\/")[1] + ";base64," 
						+ new Base64().encodeBase64String(foto);
						
						imagensBase64.add(imagemBase64);
						extencoes.add(p.getContentType().split("\\/")[1] );
					}
				}
			}
			
			imagem.setImagemBase64(imagensBase64);
			imagem.setExtencao(extencoes);
			
			int id_pet = daoPet.inserirPet(pet);
			
			daoImagem.inserir(id_pet, imagem);
			
			if(id_pet > 0) {
				request.setAttribute("msg", "Pet incluído com sucesso!!");
			}
			else {
				request.setAttribute("msg", "Erro ao incluir pet!! Tente novamente!");
			}
			RequestDispatcher rd = request.getRequestDispatcher("inserir_pet.jsp");
			rd.forward(request, response);
		}	
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
