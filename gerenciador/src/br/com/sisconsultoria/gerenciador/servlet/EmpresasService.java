package br.com.sisconsultoria.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.sisconsultoria.modelo.Banco;
import br.com.sisconsultoria.modelo.Empresa;

@WebServlet("/Empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String header = request.getHeader("Accept");

		System.out.println(header);

		// Retorno em JSON
		if (header.contains("json")) {
			response.setContentType("application/json");
			response.getWriter().print(new Gson().toJson(Banco.getEmpresas()));
			return;
		}

		// Retorno em XML
		if (header.contains("xml")) {
			ArrayList<Empresa> empresas = new ArrayList<>(Banco.getEmpresas());
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			return;
		}

		response.setContentType("application/json");
		response.getWriter().print("{'message':'no content'}");
	}

}
