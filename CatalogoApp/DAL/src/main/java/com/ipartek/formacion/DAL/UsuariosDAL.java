package com.ipartek.formacion.DAL;

import com.ipartek.formacion.Tipos.Usuario;

public interface UsuariosDAL {
	void alta(Usuario usuario);

	public void modificar(Usuario usuario);

	public void borrar(Usuario usuario);

	public Usuario buscarPorId(String id);

	public Usuario[] buscarTodosLosUsuarios();

	boolean validar(Usuario usuario);

}
