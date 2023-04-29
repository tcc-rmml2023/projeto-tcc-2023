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
		
		RequestDispatcher rd = request.getRequestDispatcher("atualizar_ong.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {

			HttpSession session = request.getSession();
			Ong alterarOng = null;
			alterarOng = (Ong) session.getAttribute("usuarioLogado");
			
			DaoOng ongDao = new DaoOng();
			boolean alterado = false;

			String alt = request.getParameter("cnpj");
			Long cnpj = Long.parseLong(alt);
			String alt2 = request.getParameter("cep");
			Integer cep = Integer.parseInt(alt2);
			String alt3 = request.getParameter("numero");
			Integer numero = Integer.parseInt(alt3);

			alterarOng = new Ong();
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
			alterarOng.setSenha(request.getParameter("id"));
			
			alterado = ongDao.alterarOng(alterarOng);
			
			if (alterado) {
				RequestDispatcher rd = request.getRequestDispatcher("sucess_cadastro.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
