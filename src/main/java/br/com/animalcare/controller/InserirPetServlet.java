package br.com.animalcare.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationPart;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.bean.Pet;
import br.com.animalcare.dao.DaoPet;


@WebServlet("/InserirPetServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 16)
public class InserirPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public InserirPetServlet() {
        super();
    }
  
    private DaoPet daoPet;
    private Ong ong;
    private ApplicationPart imagem;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("inserir_pet.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		try {
			daoPet = new DaoPet();
		} 
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		super.init();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			
			Pet pet = new Pet();
			
			boolean inserido = false;
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			pet.setNome_pet(request.getParameter("nome_pet"));
			pet.setIdade(request.getParameter("idade"));
			pet.setGenero(request.getParameter("genero"));
			pet.setObs(request.getParameter("obs"));
			pet.setId_ong(ong.getId_ong());
			
			 String caminhoImagem = "";
			
			if(imagem != null && imagem.getSubmittedFileName() != null) {
				
				caminhoImagem = "C:\\temp\\imagens\\" + imagem.getSubmittedFileName();
				
				try {
					
					byte[] byteImagem = new byte[(int) imagem.getSize()];
					imagem.getInputStream().read(byteImagem);
					File file = new File(caminhoImagem);
					OutputStream outStream = new BufferedOutputStream(new FileOutputStream(file));
					outStream.write(byteImagem);
					outStream.flush();
					outStream.close();
				} 
				
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		    
		    pet.setCaminhoImagem(caminhoImagem);
			inserido = daoPet.inserirPet(pet);
			
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
			System.out.println(e.getMessage());
		}
	}
}
