package br.com.animalcare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.animalcare.bean.Ong;
import br.com.animalcare.bean.Pet;
import br.com.animalcare.dao.DaoPet;

@WebServlet("/GerarRelatorioServlet")
public class GerarRelatorioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GerarRelatorioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		DaoPet daoPet = new DaoPet();
		
		Document doc = new Document();
		try {
			HttpSession session = request.getSession();
			Ong ong = (Ong) session.getAttribute("usuarioLogado");
			
			response.setContentType("apllication/pdf");
			
			response.addHeader("Content-Disposition", "inline; filename=" + "relatório.pdf");
			
			PdfWriter.getInstance(doc, response.getOutputStream());
			
			doc.open();
			doc.add(new Paragraph("Lista de pets cadastrdos na AnimalCare:"));
			doc.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(5);
			
			PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Genero"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Idade"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Observações"));
			
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			
			ArrayList<Pet> lista = daoPet.listarPet(ong);
			for (int i = 0; i < lista.size(); i++) {
				
				tabela.addCell(lista.get(i).getId_pet().toString());
				tabela.addCell(lista.get(i).getNome_pet());
				tabela.addCell(lista.get(i).getGenero());
				tabela.addCell(lista.get(i).getIdade());
				tabela.addCell(lista.get(i).getObs());
			}
			
			doc.add(tabela);
			doc.close();
		} 
		catch (Exception e) {
			System.out.println(e);
			doc.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
}
