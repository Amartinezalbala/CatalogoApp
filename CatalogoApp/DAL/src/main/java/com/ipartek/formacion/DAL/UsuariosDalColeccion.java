package com.ipartek.formacion.DAL;

import java.util.Map;
import java.util.TreeMap;

import com.ipartek.formacion.Tipos.Usuario;

public class UsuariosDalColeccion implements UsuariosDAL {

	// se inicializa el hashmap
	private Map<String, Usuario> usuarios = new TreeMap<String, Usuario>();

	@Override
	public void alta(Usuario usuario) {
		if (usuarios.containsKey(usuario.getNombre())) {
			throw new UsuarioYaExistenteDALException("USUARIO EXISTENTE: " + usuario.getNombre());
		}
		usuarios.put(usuario.getNombre(), usuario);

	}

	@Override
	public boolean validar(Usuario usuario) {
		return usuarios.containsValue(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getNombre())) {
			throw new UsuarioYaExistenteDALException("IMPOSIBLE MODIFICAR: " + usuario + " , NO EXISTENTE");
		}
		usuarios.put(usuario.getNombre(), usuario);

	}

	@Override
	public void borrar(Usuario usuario) {
		usuarios.remove(usuario.getNombre());

	}

	@Override
	public Usuario buscarPorId(String id) {
		return usuarios.get(id);
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {

		return usuarios.values().toArray(new Usuario[usuarios.size()]);
	}

}
