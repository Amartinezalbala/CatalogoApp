package com.ipartek.formacion.alvaromartinez.controladores;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.DAL.DALFactory;
import com.ipartek.formacion.DAL.ProductosDAL;
import com.ipartek.formacion.DAL.ProductosDALFactory;
import com.ipartek.formacion.DAL.UsuariosDAL;
import com.ipartek.formacion.Tipos.Producto;
import com.ipartek.formacion.Tipos.Usuario;

/**
 * Application Lifecycle Listener implementation class Arranque
 *
 */
public class Arranque implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public Arranque() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("LISTA DESTRUIDA");
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		UsuariosDAL usuarioDAL = null;
		usuarioDAL = DALFactory.getUsuariosDAL();
		usuarioDAL.alta(new Usuario("usuario1", "pass11"));
		usuarioDAL.alta(new Usuario("usuario2", "pass22"));
		application.setAttribute("dalUsuarios", usuarioDAL);
		System.out.println("USUARIOS CARGADOS");

		ProductosDAL productoDAL = null;
		productoDAL = ProductosDALFactory.getProductosDAL();
		productoDAL.agregar(new Producto(0, "Boligrafo BIC Blanco", 1.00));
		productoDAL.agregar(new Producto(1, "Boligrafo BIC Azul", 1.00));
		productoDAL.agregar(new Producto(2, "Boligrafo BIC Negro", 1.00));
		productoDAL.agregar(new Producto(3, "Boligrafo BIC Rojo", 1.00));
		productoDAL.agregar(new Producto(4, "Boligrafo BIC Verde", 1.00));
		application.setAttribute("dalProductos", productoDAL);
		System.out.println("PRODUCTOS CARGADOS");
	}
}
