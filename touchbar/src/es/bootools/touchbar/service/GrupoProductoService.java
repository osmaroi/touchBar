package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.converter.GrupoProductoConverter;
import es.bootools.touchbar.dao.GrupoProductoDAO;
import es.bootools.touchbar.model.GrupoProducto;

/**
 * GrupoProducto Service
 */
@Service
public class GrupoProductoService {

	private GrupoProductoDAO grupoProductoDAO;
	private GrupoProductoConverter grupoProductoConverter;

	/**
	 * Get Producto by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public GrupoProducto getGrupoProducto(Integer idGrupoProducto) {

		GrupoProducto grupoProducto = grupoProductoDAO.getById(idGrupoProducto);

		return grupoProducto;
	}

	/**
	 * Get all GrupoProductos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<GrupoProducto> getGrupoProductoList() {

		return grupoProductoDAO.getGruposProducto();
	}

	/**
	 * Create new GrupoProducto/GrupoProductos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created GrupoProductos
	 */
	@Transactional
	public List<GrupoProducto> create(List<GrupoProducto> grupoProductos) {

		List<GrupoProducto> newGrupoProductos = new ArrayList<GrupoProducto>();

		for (GrupoProducto grupoProducto : grupoProductos) {
			newGrupoProductos.add(grupoProductoDAO
					.saveGrupoProducto(grupoProducto));
		}

		return newGrupoProductos;
	}

	/**
	 * Update GrupoProducto/GrupoProductos
	 * 
	 * @param data
	 *            - json data from request
	 * @return updated GrupoProductos
	 */
	@Transactional
	public List<GrupoProducto> update(Object data) {

		List<GrupoProducto> returnGrupoProductos = new ArrayList<GrupoProducto>();

		List<GrupoProducto> updatedGrupoProductos = grupoProductoConverter
				.getGruposProductoFromRequest(data);

		for (GrupoProducto GrupoProducto : updatedGrupoProductos) {
			returnGrupoProductos.add(grupoProductoDAO
					.saveGrupoProducto(GrupoProducto));
		}

		return returnGrupoProductos;
	}

	// /**
	// * Delete GrupoProducto/GrupoProductos
	// * @param data - json data from request
	// */
	// @Transactional
	// public void delete(Object data){
	//
	// //it is an array - have to cast to array object
	// if (data.toString().indexOf('[') > -1){
	//
	// List<Integer> deleteGrupoProductos =
	// grupoProductoConverter.getListIdFromJSON(data);
	//
	// for (Integer id : deleteGrupoProductos){
	// grupoProductoDAO.deleteGrupoProducto(id);
	// }
	//
	// } else { //it is only one object - cast to object/bean
	//
	// Integer id = Integer.parseInt(data.toString());
	//
	// grupoProductoDAO.deleteGrupoProducto(id);
	// }
	// }

	/**
	 * Delete GrupoProducto/GrupoProductos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(Integer id) {
		grupoProductoDAO.deleteGrupoProducto(id);
	}

	/**
	 * Spring use - DI
	 * 
	 * @param grupoProductoDAO
	 */
	@Autowired
	public void setGrupoProductoDAO(GrupoProductoDAO grupoProductoDAO) {
		this.grupoProductoDAO = grupoProductoDAO;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param grupoProductoConverter
	 */
	@Autowired
	public void setGrupoProductoConverter(
			GrupoProductoConverter grupoProductoConverter) {
		this.grupoProductoConverter = grupoProductoConverter;
	}

}
