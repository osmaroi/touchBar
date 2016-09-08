package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.DestinoProducto;

public interface IDestinoProductoDAO {

	void deleteDestinoProducto(int id);

	DestinoProducto saveDestinoProducto(DestinoProducto destinoProducto);

	List<DestinoProducto> getDestinosProducto();

	DestinoProducto getById(Integer id);

}
