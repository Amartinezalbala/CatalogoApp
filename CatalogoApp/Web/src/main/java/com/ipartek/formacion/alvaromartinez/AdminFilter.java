package com.ipartek.formacion.alvaromartinez;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.Tipos.Usuario;

public class AdminFilter implements Filter {

	final static String admin = "admin";
	final static String RUTA_LOGIN = "/login";

	public AdminFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		System.out.println("DENTRO DEL FILTRO");
		Usuario usuario;
		HttpSession session = ((HttpServletRequest) request).getSession();
		usuario = (Usuario) session.getAttribute("usuario");
		// ¿¿Esta logeado??
		if (usuario == null) {
			System.out.println("NO HAY USUARIO LOGEADO");
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			httpRequest.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
		} else {
			System.out.println("USUARIO: " + usuario.getNombre());
			// admin usuarios

			if (usuario.getNombre().substring(0, 5).equals(admin)) {
				System.out.println("¡¡BIENVENIDO " + usuario.getNombre() + "¡¡");
			} else {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				httpRequest.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}