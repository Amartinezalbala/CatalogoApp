package com.ipartek.formacion.alvaromartinez.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ipartek.formacion.DAL.DALFactory;
import org.ipartek.formacion.DAL.UsuarioYaExistenteDALException;
import org.ipartek.formacion.DAL.UsuariosDAL;

import com.ipartek.formacion.Tipos.Usuario;

@WebServlet("/alta")
public class AltaServlet extends HttpServlet {
	/* package */static final String USUARIOS_DAL = "usuariosDAL";

	private static final long serialVersionUID = 1L;

	/* package */static final String RUTA_ALTA = LoginServlet.RUTA + "alta.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// Inicio sin datos: mostrar formulario
		// Datos incorrectos: sin rellenar, l�mite de caracteres, no coinciden
		// contrase�as
		// Las contrase�as deben ser iguales
		// Datos correctos: guardar

		Usuario usuario = new Usuario(nombre, pass);

		boolean hayDatos = nombre != null && pass != null && pass2 != null;
		boolean datosCorrectos = validarCampo(nombre) && validarCampo(pass) && validarCampo(pass2);
		boolean passIguales = pass != null && pass.equals(pass2);

		if (hayDatos) {
			if (!datosCorrectos) {
				usuario.setErrores("TODOS LOS CAMPOS SON REQUERIDOS Y CON UN M�NIMO DE "
						+ LoginServlet.MINIMO_CARACTERES + " CARACTERES.");
				request.setAttribute("usuario", usuario);
			} else if (!passIguales) {
				usuario.setErrores("LAS CONTRASE�AS TIENEN QUE SER IGUALES.");
				request.setAttribute("usuario", usuario);
			} else {
				ServletContext application = request.getServletContext();

				UsuariosDAL usuariosDAL = (UsuariosDAL) application.getAttribute(USUARIOS_DAL);

				if (usuariosDAL == null) {
					usuariosDAL = DALFactory.getUsuriosDAL();
				}

				try {
					usuariosDAL.alta(usuario);

					request.getRequestDispatcher("/login").forward(request, response);
					return;
				} catch (UsuarioYaExistenteDALException de) {
					usuario.setNombre("");
					usuario.setErrores(de.getMessage());
					request.setAttribute("usuario", usuario);
				} finally {
					application.setAttribute(USUARIOS_DAL, usuariosDAL);
				}

			}
		}
		request.getRequestDispatcher(RUTA_ALTA).forward(request, response);
	}

	private boolean validarCampo(String campo) {
		return campo != null && campo.length() >= LoginServlet.MINIMO_CARACTERES;
	}

}
