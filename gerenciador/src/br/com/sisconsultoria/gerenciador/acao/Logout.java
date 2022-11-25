package br.com.sisconsultoria.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession sessao = request.getSession();
		sessao.invalidate(); //Invalida a sessão, matando todas suas ramificações, códigos, cookies. Gerando uma nova sessão, deslogada!
		
		return "Redirect:entrada?acao=Login";
		
	}
	
}
