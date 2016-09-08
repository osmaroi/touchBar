package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.converter.ProductoPedidoConverter;
import es.bootools.touchbar.dao.EmpleadoDAO;
import es.bootools.touchbar.dao.ProductoPedidoDAO;
import es.bootools.touchbar.dto.GrupoProductoDto;
import es.bootools.touchbar.dto.PedidoDto;
import es.bootools.touchbar.dto.ProductoDto;
import es.bootools.touchbar.dto.ProductoPedidoDto;
import es.bootools.touchbar.model.Empleado;
import es.bootools.touchbar.model.ProductoPedido;

/**
 * ProductoPedido Service
 * 
 */
@Service
public class ProductoPedidoService {

	private ProductoPedidoDAO productoPedidoDAO;
	private EmpleadoDAO empleadoDAO;
	private ProductoPedidoConverter productoPedidoConverter;

	/**
	 * Get all ProductoPedidos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ProductoPedido> getProductoPedidoList() {

		return productoPedidoDAO.getProductoPedidos();
	}

	/**
	 * Create new ProductoPedido/ProductoPedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created ProductoPedidos
	 */
	@Transactional
	public List<ProductoPedido> createFromJson(Object data) {

		List<ProductoPedido> newProductoPedidos = new ArrayList<ProductoPedido>();

		List<ProductoPedido> list = productoPedidoConverter
				.getProductoPedidosFromRequest(data);

		for (ProductoPedido productoPedido : list) {
			newProductoPedidos.add(productoPedidoDAO
					.saveProductoPedido(productoPedido));
		}

		return newProductoPedidos;
	}

	/**
	 * Create new ProductoPedido/ProductoPedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created ProductoPedidos
	 */
	@Transactional
	public ProductoPedido servirProductoPedido(Integer idProductoPedido) {

		ProductoPedido productoPedido = productoPedidoDAO
				.getById(idProductoPedido);

		productoPedido.setServido(true);

		productoPedido = productoPedidoDAO.saveProductoPedido(productoPedido);

		return productoPedido;
	}

	/**
	 * Create new ProductoPedido/ProductoPedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created ProductoPedidos
	 */
	@Transactional
	public List<ProductoPedido> create(List<ProductoPedido> productoPedidoList) {

		List<ProductoPedido> newProductoPedidos = new ArrayList<ProductoPedido>();
		for (ProductoPedido productoPedido : productoPedidoList) {
			newProductoPedidos.add(productoPedidoDAO
					.saveProductoPedido(productoPedido));
		}

		return newProductoPedidos;
	}

	/**
	 * Obtiene los productosPedidos con el destino producto del empleado
	 * 
	 * @param idEmpleado
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ProductoPedidoDto> getProductoPedidoByEmpleado(
			Integer idEmpleado) {
		List<ProductoPedido> productoPedidos;
		List<ProductoPedidoDto> returnProductoPedidos = new ArrayList<ProductoPedidoDto>();

		Empleado empleado = empleadoDAO.getEmpleado(idEmpleado);

		productoPedidos = productoPedidoDAO
				.getProductoPedidoByEmpleado(empleado);

		// para que el objeto incluya el pedido y el producto
		for (ProductoPedido productoPedido : productoPedidos) {
			returnProductoPedidos.add(ProductoPedidoDto.buildDto(PedidoDto
					.buildDto(null, productoPedido.getPedido()), ProductoDto
					.buildDto(GrupoProductoDto.buildDto(productoPedido
							.getProducto().getGrupoProducto()), null,
							productoPedido.getProducto()), productoPedido));
		}

		return returnProductoPedidos;

	}

	@Transactional(readOnly = true)
	public List<ProductoPedidoDto> getProductoPedidoByEmpleadoNoServido(
			Integer idEmpleado) {
		List<ProductoPedido> productoPedidos;
		List<ProductoPedidoDto> returnProductoPedidos = new ArrayList<ProductoPedidoDto>();

		Empleado empleado = empleadoDAO.getEmpleado(idEmpleado);

		productoPedidos = productoPedidoDAO
				.getProductoPedidoByEmpleadoNoServido(empleado);

		// para que el objeto incluya el pedido y el producto
		for (ProductoPedido productoPedido : productoPedidos) {
			returnProductoPedidos.add(ProductoPedidoDto.buildDto(PedidoDto
					.buildDto(null, productoPedido.getPedido()), ProductoDto
					.buildDto(GrupoProductoDto.buildDto(productoPedido
							.getProducto().getGrupoProducto()), null,
							productoPedido.getProducto()), productoPedido));
		}
		return returnProductoPedidos;
	}

	@Transactional(readOnly = true)
	public List<ProductoPedidoDto> getProductoPedidoNoServido() {
		List<ProductoPedido> productoPedidos;
		List<ProductoPedidoDto> returnProductoPedidos = new ArrayList<ProductoPedidoDto>();

		productoPedidos = productoPedidoDAO.getProductoPedidoNoServido();

		// para que el objeto incluya el pedido y el producto
		for (ProductoPedido productoPedido : productoPedidos) {
			returnProductoPedidos.add(ProductoPedidoDto.buildDto(PedidoDto
					.buildDto(null, productoPedido.getPedido()), ProductoDto
					.buildDto(GrupoProductoDto.buildDto(productoPedido
							.getProducto().getGrupoProducto()), null,
							productoPedido.getProducto()), productoPedido));
		}
		return returnProductoPedidos;
	}

	@Transactional(readOnly = true)
	public List<ProductoPedidoDto> getProductoPedidoByPeriodo(Date inicio,
			Date fin) {
		List<ProductoPedido> productoPedidos;
		List<ProductoPedidoDto> returnProductoPedidos = new ArrayList<ProductoPedidoDto>();

		productoPedidos = productoPedidoDAO.getProductoPedidoByPeriodo(inicio,
				fin);

		// para que el objeto incluya el pedido y el producto
		for (ProductoPedido productoPedido : productoPedidos) {
			returnProductoPedidos.add(ProductoPedidoDto.buildDto(PedidoDto
					.buildDto(null, productoPedido.getPedido()), ProductoDto
					.buildDto(GrupoProductoDto.buildDto(productoPedido
							.getProducto().getGrupoProducto()), null,
							productoPedido.getProducto()), productoPedido));
		}
		return returnProductoPedidos;
	}

	/**
	 * Update ProductoPedido/ProductoPedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return updated ProductoPedidos
	 */
	@Transactional
	public List<ProductoPedido> update(Object data) {

		List<ProductoPedido> returnProductoPedidos = new ArrayList<ProductoPedido>();

		List<ProductoPedido> updatedProductoPedidos = productoPedidoConverter
				.getProductoPedidosFromRequest(data);

		for (ProductoPedido productoPedido : updatedProductoPedidos) {
			returnProductoPedidos.add(productoPedidoDAO
					.saveProductoPedido(productoPedido));
		}

		return returnProductoPedidos;
	}

	/**
	 * Delete ProductoPedido/ProductoPedidos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(Object data) {

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			List<Integer> deleteProductoPedidos = productoPedidoConverter
					.getListIdFromJSON(data);

			for (Integer id : deleteProductoPedidos) {
				productoPedidoDAO.deleteProductoPedido(id);
			}

		} else { // it is only one object - cast to object/bean

			Integer id = Integer.parseInt(data.toString());

			productoPedidoDAO.deleteProductoPedido(id);
		}
	}

	/**
	 * Spring use - DI
	 * 
	 * @param productoPedidoDAO
	 */
	@Autowired
	public void setProductoPedidoDAO(ProductoPedidoDAO productoPedidoDAO) {
		this.productoPedidoDAO = productoPedidoDAO;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param empleadoDAO
	 */
	@Autowired
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param productoPedidoConverter
	 */
	@Autowired
	public void setProductoPedidoConverter(
			ProductoPedidoConverter productoPedidoConverter) {
		this.productoPedidoConverter = productoPedidoConverter;
	}

}
