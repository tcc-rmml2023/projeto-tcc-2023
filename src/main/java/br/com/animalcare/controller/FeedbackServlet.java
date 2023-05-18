package br.com.animalcare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.animalcare.bean.Email;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedbackServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			final String myMail = "animalcare.tcc@gmail.com";
			final String assunto = "Dúvidas, sugestões, reclamações";
			
			Email mail = new Email();

			mail.setEmailCC(myMail);
			mail.setEmailTo(request.getParameter("email"));
			mail.setAssunto(assunto);

			StringBuffer mensagem = new StringBuffer();

			mensagem.append("<h2 align='center'>AnimalCare - Dúvidas, sugestões, reclamações.</h2>");
			mensagem.append("<br/>");

			mensagem.append("<img src=\"cid:image\">");

			mensagem.append("<h5>Feedback</h5>");
			mensagem.append("Nome: ");
			mensagem.append(request.getParameter("nome"));
			mensagem.append("<br/>");

			mensagem.append("Mensagem: ");
			mensagem.append(request.getParameter("feedback"));
			mensagem.append("<br/>");

			mail.setMessage(mensagem.toString());

			boolean enviou = mail.enviarGmail();

			if (enviou) {

				RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
				request.setAttribute("msg", "Mensagem enviada com sucesso."
						+ "Obrigado por enviar seu feedback.");
				rd.forward(request, response);

			} 
			else {

				RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
				request.setAttribute("msg", "Não foi possível enviar sua mensagem."
						+ "Tente novamente.");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
