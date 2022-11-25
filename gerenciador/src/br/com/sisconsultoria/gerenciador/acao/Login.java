package br.com.sisconsultoria.gerenciador.acao;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sisconsultoria.modelo.Banco;
import br.com.sisconsultoria.modelo.Usuario;

public class Login implements Acao {
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("GET"))
			return "Forward:formLogin.jsp";

		Map<String, String[]> in = request.getParameterMap();

		Usuario usuario = Banco.findUsuario(in.get("login")[0], in.get("senha")[0]);

		if (usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "Redirect:ListarEmpresa";
		}
		return "Redirect:Login";
	}

}