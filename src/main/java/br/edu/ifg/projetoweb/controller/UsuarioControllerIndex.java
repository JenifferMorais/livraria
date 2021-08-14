package br.edu.ifg.projetoweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.projetoweb.DAO.UsuarioDAO;
import br.edu.ifg.projetoweb.core.ProjectHttpServlet;
import br.edu.ifg.projetoweb.model.Usuario;
import br.edu.ifg.projetoweb.utils.Hashing;
import br.edu.ifg.projetoweb.utils.Sessao;

@WebServlet(name = "ListarUsuario", urlPatterns = { "/usuario/*" })
public class UsuarioControllerIndex extends ProjectHttpServlet {

	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");
		UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

		Integer ids = Sessao.getUsuarioId(request);
		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {

			try {
				usuarios = usuarioDAO.listarUsuario();
			} catch (SQLException e) {
				e.printStackTrace();
			}if (ids != null) {
				request.setAttribute("admin", usuarioDAO.isAdmin(ids));
			}
			request.setAttribute("usuarios", usuarios);

			Router.listar(request, response);
			return;
		}

		String[] splits = pathInfo.split("/");

		if (splits.length != 2) {
			return;
		}
		
		if (ids != null) {
			request.setAttribute("admin", usuarioDAO.isAdmin(ids));
		}

		if (splits[1].matches("cadastrar")) {
			Router.cadastrar(request, response);
			return;
		}

		if (splits[1].matches("perfil")) {
			if (ids != null) {
				response.sendRedirect("/projetoweb/usuario/" + ids);
			} else {
				response.sendRedirect("/projetoweb/usuario/logar");
			}
			return;
		}

		if (splits[1].matches("logoff")) {
			request.getSession().invalidate();
			response.sendRedirect("/projetoweb/usuario/logar");
			return;
		}

		String nomeUsuario = Sessao.getUsuarioNome(request);
		request.setAttribute("nomeUsuario", nomeUsuario);

		String imgUsuario = Sessao.getUsuarioImagem(request);
		request.setAttribute("imgUsuario", imgUsuario);

		int idUsuario = Sessao.getUsuarioId(request);

		int id = Integer.parseInt(splits[1]);

		if (idUsuario == id || usuarioDAO.isAdmin(idUsuario)) {
			try {
				Usuario usuario = usuarioDAO.buscarUsuario(id);
				usuario.setPassword("");
				request.setAttribute("usuario", usuario);
				Router.atualizar(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("/projetoweb/usuario");
		}

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");
		UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
		List<Usuario> usuarios = null;

		Integer idUsuario = Sessao.getUsuarioId(request);
		int id = Integer.parseInt(request.getParameter("id"));

		if (idUsuario == id || usuarioDAO.isAdmin(idUsuario)) {
			usuarioDAO.removerUsuario(id);
		}

		try {
			usuarios = usuarioDAO.listarUsuario();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("usuarios", usuarios);
		Router.listar(request, response);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		

		Connection connection = (Connection) request.getAttribute("connection");
		UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
		

		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setImagem(request.getParameter("imagem"));

		if (usuario.getPassword() != null) {
			Hashing hashing = new Hashing(11);
			String password = request.getParameter("password");
			password = hashing.hash(password);
			usuario.setPassword(password);
		}

		usuarioDAO.alterarUsuario(usuario);

		try {
			usuarios = usuarioDAO.listarUsuario();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		request.setAttribute("usuarios", usuarios);
		response.sendRedirect("/projetoweb/usuario");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Connection connection = (Connection) request.getAttribute("connection");
		final UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
		final Usuario usuario = new Usuario();

		usuario.setNome(request.getParameter("nome"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setImagem(request.getParameter("imagem"));
		String password = request.getParameter("password");

		Hashing hashing = new Hashing(11);
		password = hashing.hash(password);
		usuario.setPassword(password);

		try {
			usuarioDAO.inserirUsuario(usuario);
			request.removeAttribute("connection");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/projetoweb/usuario/logar");
	}
}