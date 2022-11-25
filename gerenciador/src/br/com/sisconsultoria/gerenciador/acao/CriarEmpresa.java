package br.com.sisconsultoria.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisconsultoria.modelo.Banco;
import br.com.sisconsultoria.modelo.Empresa;

public class CriarEmpresa implements Acao{
	public String exec(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if (request.getMethod().equals("GET")) {
			return "Forward:formEmpresa.jsp";
		}

		// Post
		Map<String, String[]> in = request.getParameterMap();

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(in.get("data")[0]);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa(1 + Banco.getEmpresas().size(), in.get("nome")[0], dataAbertura);
		Banco.add(empresa);

		return "Redirect:ListarEmpresa";

	}
}
