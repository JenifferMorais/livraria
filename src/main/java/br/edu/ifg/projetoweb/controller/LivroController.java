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

import br.edu.ifg.projetoweb.DAO.LivroDAO;
import br.edu.ifg.projetoweb.DAO.UsuarioDAO;
import br.edu.ifg.projetoweb.core.ProjectHttpServlet;
import br.edu.ifg.projetoweb.model.Livro;
import br.edu.ifg.projetoweb.utils.Sessao;

@WebServlet(name = "ListarLivro", value = "/livros/*")
public class LivroController extends ProjectHttpServlet {

	private static final long serialVersionUID = 1L;
	private List<Livro> livros = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Connection connection = (Connection) request.getAttribute("connection");
		LivroDAO livroDAO = new LivroDAO(connection);
		
		int idUsuario = Sessao.getUsuarioId(request);

		UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {
			if (usuarioDAO.isAdmin(idUsuario)) {
				try {
					livros = livroDAO.listarLivros();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("livros", livros);
			}
			Router.listarLivros(request, response);
			return;
		}

		String[] splits = pathInfo.split("/");

		if (splits.length != 2) {
			return;
		}

		if (splits[1].matches("cadastrar")) {
			if (usuarioDAO.isAdmin(idUsuario)) {
				Router.cadastrarLivro(request, response);
			} else {
				response.sendRedirect("/projetoweb/livros");
			}
			return;
		}

		if (splits[1].matches("home")) {
			Router.home(request, response);
			return;
		}

		int id = Integer.parseInt(splits[1]);

		if (usuarioDAO.isAdmin(idUsuario)) {
			try {
				Livro livro = livroDAO.buscarLivro(id);
				request.setAttribute("livro", livro);
				Router.atualizarLivro(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("/projetoweb/livros");
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Connection connection = (Connection) request.getAttribute("connection");
		LivroDAO livroDAO = new LivroDAO(connection);

		Livro livro = new Livro();
		livro.setId(Integer.parseInt(request.getParameter("id")));
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDescricao(request.getParameter("descricao"));
		livro.setValor(Double.parseDouble(request.getParameter("valor")));
		livro.setISBN(request.getParameter("isbn"));
		livro.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		livroDAO.alterarLivro(livro);

		try {
			livros = livroDAO.listarLivros();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("livros", livros);
		response.sendRedirect("/projetoweb/livros");

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("connection");
		LivroDAO livroDAO = new LivroDAO(connection);
		List<Livro> livros = null;

		int id = Integer.parseInt(request.getParameter("id"));
		int idUsuario = Sessao.getUsuarioId(request);

		UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

		if (usuarioDAO.isAdmin(idUsuario)) {
			livroDAO.removerLivro(id);
		}

		try {
			livros = livroDAO.listarLivros();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("livros", livros);
		Router.listarLivros(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Connection connection = (Connection) request.getAttribute("connection");
		final LivroDAO livroDAO = new LivroDAO(connection);
		final Livro livro = new Livro();

		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDescricao(request.getParameter("descricao"));
		livro.setValor(Double.parseDouble(request.getParameter("valor")));
		livro.setISBN(request.getParameter("isbn"));
		livro.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		try {
			livroDAO.inserirLivro(livro);
			request.removeAttribute("connection");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		response.sendRedirect("/projetoweb/livros");
	}

}
