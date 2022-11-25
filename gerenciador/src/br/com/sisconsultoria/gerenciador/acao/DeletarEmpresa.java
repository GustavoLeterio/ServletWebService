package br.com.sisconsultoria.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisconsultoria.modelo.Banco;

public class DeletarEmpresa implements Acao{
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco.delete(id);
		
		return "Redirect:ListarEmpresa";
	}
}
