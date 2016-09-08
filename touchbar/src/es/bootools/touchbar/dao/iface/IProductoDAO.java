package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.Producto;

public interface IProductoDAO {

	Producto getById(Integer id);

	List<Producto> findByGroup(Integer id);

	List<Producto> getProductos();

	void deleteProducto(int id);

	Producto saveProducto(Producto producto);

	List<Producto> getProductosOrderByGroup();

}
