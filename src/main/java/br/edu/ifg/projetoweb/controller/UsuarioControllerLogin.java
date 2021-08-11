package br.edu.ifg.projetoweb.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.edu.ifg.projetoweb.DAO.UsuarioDAO;
import br.edu.ifg.projetoweb.core.ProjectHttpServlet;
import br.edu.ifg.projetoweb.model.Usuario;
import br.edu.ifg.projetoweb.utils.Sessao;


@WebServlet(name = "loginUsuario", urlPatterns = { "/usuario/logar" })
public class UsuarioControllerLogin extends ProjectHttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/usuario/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Connection connection = (Connection) request.getAttribute("connection");
		final UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	
		try {
			final Usuario usuario = usuarioDAO.login(email, password);
			request.removeAttribute("connection");
			
			if (usuario != null) {
				Sessao.configure(request, usuario.getId(), usuario.getNome());
				
				response.addCookie(new Cookie("usuariologado", usuario.getNome()));
			    response.sendRedirect("/projetoweb/usuario");
			}else {
				 request.setAttribute("erro", "Erro ao logar!");
				 request.getRequestDispatcher("/WEB-INF/usuario/login.jsp").forward(request, response);
				 return;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
