package br.edu.ifg.projetoweb.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter({ "/usuario/*", "/livros/*" })
public class FiltrarAcento implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}

	@Override

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
			throws IOException, ServletException {
		// Respect the client-specified character encoding
		// (see HTTP specification section 3.4.1)

		request.setCharacterEncoding("UTF-8");

		// Set the default response content type and encoding
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		next.doFilter(request, response);
	}

	public void destroy() {
	}

}
