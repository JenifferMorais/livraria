package br.edu.ifg.projetoweb.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("_method") != null) {
			if (request.getParameter("_method").equals("DELETE")) {
				doDelete(request, response);
				return;
			} else if (request.getParameter("_method").equals("PUT")) {
				doPut(request, response);
			}
		} else {
			super.service(request, response);
		}
	}
}
