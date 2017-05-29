package com.ipartek.formacion.alvaromartinez.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.DAL.ProductosDAL;
import com.ipartek.formacion.Tipos.Producto;

@WebServlet("/productocrud")
public class ProductoCRUDServlet extends HttpServlet {

	static final String RUTA_FORMULARIO = "/WEB-INF/vistas/productoform.jsp";
	static final String RUTA_LISTADO = "/WEB-INF/vistas/productocrud.jsp";
	static final String RUTA_SERVLET_LISTADO = "/productocrud";

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		ServletContext application = request.getServletContext();
		ProductosDAL dalProductos = (ProductosDAL) application.getAttribute("dalProductos");

		// if (dalProductos == null) {
		// dalProductos = ProductosDALFactory.getProductosDAL();
		//
		// dalProductos.agregar(new Producto(0, "Boligrafo BIC Blanco", 1.00));
		// dalProductos.agregar(new Producto(1, "Boligrafo BIC Azul", 1.00));
		// dalProductos.agregar(new Producto(2, "Boligrafo BIC Negro", 1.00));
		// dalProductos.agregar(new Producto(3, "Boligrafo BIC Rojo", 1.00));
		// dalProductos.agregar(new Producto(4, "Boligrafo BIC Verde", 1.00));
		// application.setAttribute("dalProductos", dalProductos);
		// }

		String op = request.getParameter("op");

		if (op == null) {

			Producto[] productos = dalProductos.buscarLosProductos();

			request.setAttribute("productos", productos);

			request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
		} else {
			String id = request.getParameter("id");

			Producto producto;

			switch (op) {
			case "modificar":
			case "borrar":
				producto = dalProductos.buscarPorId(Integer.parseInt(id));
				request.setAttribute("producto", producto);
			case "agregar":
				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
			}

		}

	}

}