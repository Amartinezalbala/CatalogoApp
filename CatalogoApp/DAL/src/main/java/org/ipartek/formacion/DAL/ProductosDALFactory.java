package org.ipartek.formacion.DAL;

public class ProductosDALFactory {
	public static ProductosDAL getProductosDAL() {
		return new ProductosDALColeccion();
	}

}
