package br.edu.ifg.projetoweb.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class FiltrarConexao implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection connection = null;
		try {
			connection = Conexao.getConnection();
			request.setAttribute("connection", connection);
			chain.doFilter(request, response);
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
