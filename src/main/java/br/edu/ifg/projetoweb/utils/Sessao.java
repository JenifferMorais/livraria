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

	public static int getUsuarioId(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		Integer idUsuario = (Integer) sessao.getAttribute(USUARIO_ID);

		if (idUsuario == null) {
			return 0;
		}
		
		return idUsuario;
	}

	public static String getUsuarioNome(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		String nomeUsuario = (String) sessao.getAttribute(USUARIO_NOME);
		return nomeUsuario;

	}

}
