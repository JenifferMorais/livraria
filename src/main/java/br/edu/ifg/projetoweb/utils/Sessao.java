package br.edu.ifg.projetoweb.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sessao {

	private final static String USUARIO_ID = "usuarioid";
	private final static String USUARIO_NOME = "nomeUsuario";

	public static void configure(HttpServletRequest request, int id, String nome) {

		HttpSession sessao = request.getSession();
		sessao.setAttribute(USUARIO_ID, id);
		sessao.setAttribute(USUARIO_NOME, nome);

	}

	public static Integer getUsuarioId(HttpServletRequest request) {
		return (Integer) request.getSession().getAttribute(USUARIO_ID);
	}

	public static String getUsuarioNome(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(USUARIO_NOME);
	}
}
