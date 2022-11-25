package br.com.sisconsultoria.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	public String exec(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
