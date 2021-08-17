package br.edu.ifg.projetoweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Router extends HttpServlet {

	public static void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/usuario/update.jsp").forward(request, response);
	}
	
	public static void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/usuario/index.jsp").forward(request, response);
	}
	
	public static void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/usuario/cadastrar.jsp").forward(request, response);
	}
	
	public static void listarLivros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/livro/index.jsp").forward(request, response);
	
	}
	
	public static void atualizarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/livro/update.jsp").forward(request, response);
	}
	
	public static void cadastrarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/livro/cadastrar.jsp").forward(request, response);
	}
	
	public static void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/livro/home.jsp").forward(request, response);
	}
	
	public static void detalhes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/livro/detalhes.jsp").forward(request, response);
	}
	public static void carrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/livro/carrinho.jsp").forward(request, response);
	}
}
