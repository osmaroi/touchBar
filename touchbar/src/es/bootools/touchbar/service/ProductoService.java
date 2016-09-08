package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.converter.ProductoConverter;
import es.bootools.touchbar.dao.ProductoDAO;
import es.bootools.touchbar.dto.DestinoProductoDto;
import es.bootools.touchbar.dto.GrupoProductoDto;
import es.bootools.touchbar.dto.ProductoAltaDto;
import es.bootools.touchbar.dto.ProductoDto;
import es.bootools.touchbar.model.Producto;

/**
 * Producto Service
 * 
 */
@Service
public class ProductoService {

	private ProductoDAO productoDAO;
	private ProductoConverter productoConverter;

	/**
	 * Get Productos by id group
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Producto> getProductosByGroupList(Integer id) {

		List<Producto> productos = productoDAO.findByGroup(id);

//		for (Producto producto : productos) {
//
//		}

		return productos;
	}

	/**
	 * Get Producto by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Producto getProducto(Integer id) {

		Producto producto = productoDAO.getById(id);

		return producto;
	}

	/**
	 * Get Producto by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public ProductoDto getProductoDto(Integer id) {

		Producto producto = productoDAO.getById(id);

		ProductoDto productoDto = ProductoDto.buildDto(
				GrupoProductoDto.buildDto(producto.getGrupoProducto()),
				DestinoProductoDto.buildDto(producto.getDestinoProducto()),
				producto);

		return productoDto;
	}

	/**
	 * Get all Productos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Producto> getProductoList() {

		List<Producto> productos = productoDAO.getProductos();

		return productos;
	}

	/**
	 * Get all Productos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ProductoDto> getProductoOrderByGroup() {

		List<Producto> productos = productoDAO.getProductosOrderByGroup();

		List<ProductoDto> productosDto = new ArrayList<ProductoDto>();

		for (Producto producto : productos) {
			productosDto.add(ProductoDto.buildDto(
					GrupoProductoDto.buildDto(producto.getGrupoProducto()),
					null, producto));
		}

		return productosDto;
	}

	/**
	 * Get all Productos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Producto> getProductoViewList() {

		return productoDAO.getProductos();
	}

	/**
	 * Create new Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Productos
	 */
	@Transactional
	public List<Producto> create(List<Producto> Productos) {

		List<Producto> newProductos = new ArrayList<Producto>();

		for (Producto producto : Productos) {
			newProductos.add(productoDAO.saveProducto(producto));
		}

		return newProductos;
	}

	/**
	 * Create new Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Productos
	 */
	@Transactional
	public List<Producto> createFromAltaDto(List<ProductoAltaDto> Productos) {

		List<Producto> newProductos = new ArrayList<Producto>();

		for (ProductoAltaDto producto : Productos) {
			Producto newProducto = ProductoAltaDto.buildPojo(producto);
			newProductos.add(productoDAO.saveProducto(newProducto));
		}

		return newProductos;
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

		List<Producto> updatedProductos = productoConverter
				.getProductosFromRequest(data);

		for (Producto Producto : updatedProductos) {
			returnProductos.add(productoDAO.saveProducto(Producto));
		}

		return returnProductos;
	}

	/**
	 * Delete Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(List<Producto> productos) {

		for (Producto producto : productos) {
			productoDAO.deleteProducto(producto.getIdProducto());
		}

	}

	/**
	 * Spring use - DI
	 * 
	 * @param productoDAO
	 */
	@Autowired
	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param productoConverter
	 */
	@Autowired
	public void setProductoConverter(ProductoConverter productoConverter) {
		this.productoConverter = productoConverter;
	}

}
