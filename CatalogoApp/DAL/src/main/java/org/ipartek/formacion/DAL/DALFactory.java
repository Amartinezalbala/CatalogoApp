package org.ipartek.formacion.DAL;

public class DALFactory {
	public static UsuariosDAL getUsuriosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new UsuariosDalColeccion();
	}

}