package br.edu.ifg.projetoweb.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifg.projetoweb.DAO.UsuarioDAO;
import br.edu.ifg.projetoweb.core.ProjectHttpServlet;
import br.edu.ifg.projetoweb.model.Usuario;


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
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioid", usuario.getId());
				
				response.addCookie(new Cookie("usuariologado", usuario.getNome()));
			    response.sendRedirect("/projetoweb/usuario");
			}else {
				 System.out.println("Erro ao logar!");
				 response.sendRedirect("/projetoweb/usuario/logar");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
