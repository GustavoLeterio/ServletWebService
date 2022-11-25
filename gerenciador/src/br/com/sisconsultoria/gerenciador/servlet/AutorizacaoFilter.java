package br.com.sisconsultoria.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter extends HttpFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {}
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest svReq = (HttpServletRequest) request;
		HttpServletResponse svRes = (HttpServletResponse) response;

		String in = svReq.getParameter("acao");
		HttpSession sessao = svReq.getSession();
		boolean acessandoPaginaFechada = !(in.equals("Login"));

		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		if (usuarioNaoEstaLogado && acessandoPaginaFechada) {
			svRes.sendRedirect("Entrada?acao=Login");
			return;
		}
		chain.doFilter(request, response);
	}
}
