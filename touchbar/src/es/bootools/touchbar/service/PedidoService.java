package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.converter.PedidoConverter;
import es.bootools.touchbar.dao.PedidoDAO;
import es.bootools.touchbar.dto.PedidoAltaDto;
import es.bootools.touchbar.model.Cliente;
import es.bootools.touchbar.model.Pedido;
import es.bootools.touchbar.model.Producto;
import es.bootools.touchbar.model.ProductoPedido;

/**
 * Pedido Service
 * 
 */
@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;
	private PedidoConverter pedidoConverter;
	private ClienteService clienteService;
	private ProductoService productoService;
	private ProductoPedidoService productoPedidoService;

	/**
	 * Get all Pedidos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Pedido> getPedidoList() {

		List<Pedido> pedidos = pedidoDAO.getPedidos();

		return pedidos;
	}

	/**
	 * Get all Pedidos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Pedido> getPedidoViewList() {

		return pedidoDAO.getPedidos();
	}

	/**
	 * Create new Pedido/Pedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Pedidos
	 */
	@Transactional
	public Pedido create(PedidoAltaDto pedidoAltaDto) {

		String[] productosArray = ((String) pedidoAltaDto.getProductos())
				.split(",");
		Calendar cal = Calendar.getInstance();

		// Cliente cliente = (Cliente) clienteService.getClienteById(1);

		Cliente cliente = (Cliente) clienteService
				.getClienteByCodUnicoMovil(pedidoAltaDto.getCodUnicoMovil());
		if (cliente == null) {
			cliente = new Cliente();
			if (pedidoAltaDto.getCodUnicoMovil() != null) {
				cliente.setCodUnicoMovil(pedidoAltaDto.getCodUnicoMovil());
				cliente.setCodCliente(pedidoAltaDto.getCodUnicoMovil());
			}
			cliente = clienteService.create(cliente);
		}

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setComentario("esto es una prueba");
		pedido.setFechaCrear(cal.getTime());
		pedido.setFechaPedido(cal.getTime());
		pedido.setMesa(pedidoAltaDto.getMesa());
		pedido.setServido(false);
		pedido = pedidoDAO.savePedido(pedido);

		List<ProductoPedido> productoPedidoList = new ArrayList<ProductoPedido>();
		for (int i = 0; i < productosArray.length; i++) {
			Producto producto = new Producto();
			producto.setIdProducto(Integer.parseInt(productosArray[i]));
			ProductoPedido productoPedido = new ProductoPedido(null, pedido,
					productoService.getProducto(producto.getIdProducto()));
			productoPedido.setServido(false);
			productoPedidoList.add(productoPedido);
		}

		productoPedidoList = productoPedidoService.create(productoPedidoList);

		return pedido;
	}

	// /**
	// * Create new Pedido/Pedidos
	// *
	// * @param data
	// * - json data from request
	// * @return created Pedidos
	// */
	// @Transactional
	// public Pedido create(Object data) {
	//
	// String[] productosArray = ((String) data).split(",");
	// Calendar cal = Calendar.getInstance();
	//
	// Cliente cliente = (Cliente) clienteService.getClienteById(1);
	//
	// Pedido pedido = new Pedido();
	// pedido.setCliente(cliente);
	// pedido.setComentario("esto es una prueba");
	// pedido.setFechaCrear(cal.getTime());
	// pedido.setFechaPedido(cal.getTime());
	// pedido.setMesa("4");
	// pedido.setServido(false);
	// pedido = pedidoDAO.savePedido(pedido);
	//
	// List<ProductoPedido> productoPedidoList = new
	// ArrayList<ProductoPedido>();
	// for (int i = 0; i < productosArray.length; i++) {
	// Producto producto = new Producto();
	// producto.setIdProducto(Integer.parseInt(productosArray[i]));
	// ProductoPedido productoPedido = new ProductoPedido(null, pedido,
	// productoService.getProducto(producto.getIdProducto()));
	// productoPedido.setServido(false);
	// productoPedidoList.add(productoPedido);
	// }
	//
	// productoPedidoList = productoPedidoService.create(productoPedidoList);
	//
	// return pedido;
	// }

	/**
	 * Create new Pedido/Pedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Pedidos
	 */
	// @Transactional
	// public List<Pedido> createFromJson(Object data){
	//
	// List<Pedido> newPedidos = new ArrayList<Pedido>();
	//
	// List<Pedido> list = pedidoConverter.getPedidosFromRequest(data);
	//
	// for (Pedido Pedido : list){
	// newPedidos.add(pedidoDAO.savePedido(Pedido));
	// }
	//
	// return newPedidos;
	// }

	/**
	 * Update Pedido/Pedidos
	 * 
	 * @param data
	 *            - json data from request
	 * @return updated Pedidos
	 */
	@Transactional
	public List<Pedido> update(Object data) {

		List<Pedido> returnPedidos = new ArrayList<Pedido>();

		List<Pedido> updatedPedidos = pedidoConverter
				.getPedidosFromRequest(data);

		for (Pedido Pedido : updatedPedidos) {
			returnPedidos.add(pedidoDAO.savePedido(Pedido));
		}

		return returnPedidos;
	}

	/**
	 * Delete Pedido/Pedidos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(Object data) {

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			List<Integer> deletePedidos = pedidoConverter
					.getListIdFromJSON(data);

			for (Integer id : deletePedidos) {
				pedidoDAO.deletePedido(id);
			}

		} else { // it is only one object - cast to object/bean

			Integer id = Integer.parseInt(data.toString());

			pedidoDAO.deletePedido(id);
		}
	}

	/**
	 * Spring use - DI
	 * 
	 * @param pedidoDAO
	 */
	@Autowired
	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param pedidoConverter
	 */
	@Autowired
	public void setPedidoConverter(PedidoConverter pedidoConverter) {
		this.pedidoConverter = pedidoConverter;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param clienteService
	 */
	@Autowired
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param clienteService
	 */
	@Autowired
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param clienteService
	 */
	@Autowired
	public void setProductoPedidoService(
			ProductoPedidoService productoPedidoService) {
		this.productoPedidoService = productoPedidoService;
	}

}
