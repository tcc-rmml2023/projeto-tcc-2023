package br.com.animalcare.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.dao.DaoOng;

@WebServlet("/AtualizarOngServlet")
public class AtualizarOngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AtualizarOngServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Ong ong = new Ong();
			DaoOng ongDao = new DaoOng();
			
			HttpSession session = request.getSession();
			ong = (Ong) session.getAttribute("usuarioLogado");
			
			ongDao.buscarOngPorId(ong);
			
			RequestDispatcher rd = request.getRequestDispatcher("atualizar_ong.jsp");
			
			request.setAttribute("id_ong", ong.getId_ong());
			request.setAttribute("nome_ong", ong.getNome_ong());
			request.setAttribute("telefone", ong.getTelefone());
			request.setAttribute("cnpj", ong.getCnpj());
			request.setAttribute("cep", ong.getCep());
			request.setAttribute("logradouro", ong.getLogradouro());
			request.setAttribute("numero", ong.getNumero());
			request.setAttribute("complemento", ong.getComplemento());
			request.setAttribute("bairro", ong.getBairro());
			request.setAttribute("cidade", ong.getCidade());
			request.setAttribute("uf", ong.getUf());
			request.setAttribute("email", ong.getEmail());
			request.setAttribute("senha", ong.getSenha());
			
			rd.forward(request, response);	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {

			HttpSession session = request.getSession();
			Ong alterarOng = null;
			alterarOng = (Ong) session.getAttribute("usuarioLogado");
			
			DaoOng ongDao = new DaoOng();
			boolean alterado = false;

			String id = request.getParameter("id_ong");
			int id_ong = Integer.parseInt(id);
			String alt = request.getParameter("cnpj");
			Long cnpj = Long.parseLong(alt);
			String alt2 = request.getParameter("cep");
			Integer cep = Integer.parseInt(alt2);
			String alt3 = request.getParameter("numero");
			Integer numero = Integer.parseInt(alt3);

			alterarOng = new Ong();
			alterarOng.setId_ong(id_ong);;
			alterarOng.setNome_ong(request.getParameter("nome_ong"));
			alterarOng.setTelefone(request.getParameter("telefone"));
			alterarOng.setCnpj(cnpj);
			alterarOng.setCep(cep);
			alterarOng.setLogradouro(request.getParameter("logradouro"));
			alterarOng.setNumero(numero);
			alterarOng.setComplemento(request.getParameter("complemento"));
			alterarOng.setBairro(request.getParameter("bairro"));
			alterarOng.setCidade(request.getParameter("cidade"));
			alterarOng.setUf(request.getParameter("uf"));
			alterarOng.setEmail(request.getParameter("email"));
			alterarOng.setSenha(request.getParameter("senha"));
			
			alterado = ongDao.alterarOng(alterarOng);
			
			if (alterado) {
				request.setAttribute("msg", "Pet alterado com sucesso!!");
			}
			else {
				request.setAttribute("msg", "Erro ao excluir pet!! Tente novamente!");
			}
			response.sendRedirect("PetServlet?action=listarPetsPorOng");
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
