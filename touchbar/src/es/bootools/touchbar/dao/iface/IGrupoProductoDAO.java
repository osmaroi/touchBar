package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.GrupoProducto;

public interface IGrupoProductoDAO {

	List<GrupoProducto> getGruposProducto();

	void deleteGrupoProducto(int id);

	GrupoProducto saveGrupoProducto(GrupoProducto grupoProducto);

	GrupoProducto getById(Integer id);

}
