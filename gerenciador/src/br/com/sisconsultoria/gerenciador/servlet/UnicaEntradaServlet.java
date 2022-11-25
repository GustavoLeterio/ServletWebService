package br.com.sisconsultoria.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisconsultoria.gerenciador.acao.Acao;

@WebServlet("/Entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String in = request.getParameter("acao");

		if (in != null) {

			String path = null;
			try {
				@SuppressWarnings("rawtypes")
				Class classe = Class.forName("br.com.sisconsultoria.gerenciador.acao." + in);
				@SuppressWarnings("deprecation")
				Acao acao = (Acao) classe.newInstance();
				path = acao.exec(request, response);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				throw new ServletException(e);
			}

			String[] pathArray = path.split(":");
			if (pathArray[0].equals("Forward")) {
				request.getRequestDispatcher("WEB-INF/view/" + pathArray[1]).forward(request, response);
				return;
			}
			response.sendRedirect("Entrada?acao=" + pathArray[1]);
			return;
		}
		response.sendRedirect("Entrada?acao=Logout");
	}

}
