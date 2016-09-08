package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.dao.DestinoProductoDAO;
import es.bootools.touchbar.model.DestinoProducto;
import es.bootools.touchbar.model.Producto;

/**
 * Producto Service
 * 
 */
@Service
public class DestinoProductoService {

	private DestinoProductoDAO destinoProductoDAO;

	/**
	 * Get Producto by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public DestinoProducto getDestinoProducto(Integer id) {

		DestinoProducto destinoProducto = destinoProductoDAO.getById(id);

		return destinoProducto;
	}

	/**
	 * Get all Productos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DestinoProducto> getAllDestinosProducto() {

		return destinoProductoDAO.getDestinosProducto();
	}

	// /**
	// * Create new Producto/Productos
	// * @param data - json data from request
	// * @return created Productos
	// */
	// @Transactional
	// public List<Producto> create(Object data){
	//
	// List<Producto> newProductos = new ArrayList<Producto>();
	//
	// for (Producto Producto : list){
	// newProductos.add(destinoProductoDAO.saveProducto(Producto));
	// }
	//
	// return newProductos;
	// }

	/**
	 * Create new Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Productos
	 */
	@Transactional
	public List<DestinoProducto> create(List<DestinoProducto> destinosProductos) {

		List<DestinoProducto> newDestinoProductos = new ArrayList<DestinoProducto>();

		for (DestinoProducto destinoProducto : destinosProductos) {
			newDestinoProductos.add(destinoProductoDAO
					.saveDestinoProducto(destinoProducto));
		}

		return newDestinoProductos;
	}

	/**
	 * Update Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 * @return updated Productos
	 */
	@Transactional
	public List<Producto> update(Object data) {

		List<Producto> returnProductos = new ArrayList<Producto>();

		// for (Producto Producto : updatedProductos){
		// returnProductos.add(destinoProductoDAO.saveProducto(Producto));
		// }

		return returnProductos;
	}

	/**
	 * Delete Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(Integer id) {
		destinoProductoDAO.deleteDestinoProducto(id);
	}

	/**
	 * Spring use - DI
	 * 
	 * @param destinoProductoDAO
	 */
	@Autowired
	public void setDestinoProductoDAO(DestinoProductoDAO destinoProductoDAO) {
		this.destinoProductoDAO = destinoProductoDAO;
	}
}
