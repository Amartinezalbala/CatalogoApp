package org.ipartek.formacion.DAL;

import com.ipartek.formacion.Tipos.Producto;

public interface ProductosDAL {

	void agregar(Producto producto);

	public void modificar(Producto producto);

	public void borrar(Producto producto);

	public Producto buscarPorId(int id);

	public Producto[] buscarLosProductos();

	boolean validar(Producto producto);

}
