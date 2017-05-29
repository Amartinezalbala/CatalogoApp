package com.ipartek.formacion.DAL;

public class DALFactory {
	public static UsuariosDAL getUsuariosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new UsuariosDalColeccion();
	}

}