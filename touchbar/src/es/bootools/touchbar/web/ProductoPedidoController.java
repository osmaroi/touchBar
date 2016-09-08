package es.bootools.touchbar.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.bootools.touchbar.dto.ProductoPedidoDto;
import es.bootools.touchbar.model.ProductoPedido;
import es.bootools.touchbar.service.ProductoPedidoService;

@Controller
public class ProductoPedidoController {

	private ProductoPedidoService productoPedidoService;

	// @Resource(name="springService")
	// private ArithmeticService springService;
	//
	// @RequestMapping(value = "/clienteMovil/add.action")
	// public @ResponseBody Integer add(@RequestParam Integer inputNumber1,
	// @RequestParam Integer inputNumber2) {
	//
	// Integer sum = springService.add(inputNumber1, inputNumber2);
	// return sum;
	// }
	//
	// @RequestMapping(value="/productoPedido/view.action")
	// public @ResponseBody Map<String,? extends Object> view() throws Exception
	// {
	//
	// try{
	//
	// List<ProductoPedido> productoPedidos =
	// productoPedidoService.getProductoPedidoList();
	//
	// return getMap(productoPedidos);
	//
	// } catch (Exception e) {
	//
	// return
	// getModelMapError("Error retrieving ProductoPedidos from database.");
	// }
	// }

	@RequestMapping(value = "producto_pedido/get_all_by_destino_producto.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllByDestinoProducto(
			@RequestParam Integer idEmpleado) throws Exception {

		try {

			// se obtinen todos los productos pedido de los pedidos si su
			// destino producto coincide con el del empleado.
			List<ProductoPedidoDto> productoPedidos = productoPedidoService
					.getProductoPedidoByEmpleado(idEmpleado);

			return getMapDto(productoPedidos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Pedidos from database.");
		}
	}

	@RequestMapping(value = "producto_pedido/get_all_by_destino_producto_no_servido.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllByDestinoProductoNoServido(
			@RequestParam Integer idEmpleado) throws Exception {

		try {

			// se obtinen todos los productos pedido de los pedidos si su
			// destino producto coincide con el del empleado.
			List<ProductoPedidoDto> productoPedidos = productoPedidoService
					.getProductoPedidoByEmpleadoNoServido(idEmpleado);

			return getMapDto(productoPedidos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Pedidos from database.");
		}
	}

	@RequestMapping(value = "producto_pedido/get_all_no_servido.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllNoServido() throws Exception {

		try {

			// se obtinen todos los productos pedido de los pedidos si su
			// destino producto coincide con el del empleado.
			List<ProductoPedidoDto> productoPedidos = productoPedidoService
					.getProductoPedidoNoServido();

			return getMapDto(productoPedidos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Pedidos from database.");
		}
	}

	@RequestMapping(value = "producto_pedido/get_all_de_hoy.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllDeHoy() throws Exception {

		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();

		calendarInicio.set(Calendar.HOUR_OF_DAY, 0);
		calendarInicio.set(Calendar.MINUTE, 0);
		calendarInicio.set(Calendar.SECOND, 0);

		calendarFin.set(Calendar.HOUR_OF_DAY, 24);
		calendarFin.set(Calendar.MINUTE, 59);
		calendarFin.set(Calendar.SECOND, 59);

		try {

			// se obtinen todos los productos pedido de los pedidos si su
			// destino producto coincide con el del empleado.
			List<ProductoPedidoDto> productoPedidos = productoPedidoService
					.getProductoPedidoByPeriodo(calendarInicio.getTime(),
							calendarFin.getTime());

			return getMapDto(productoPedidos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Pedidos from database.");
		}
	}

	@RequestMapping(value = "producto_pedido/servir_producto.action")
	public @ResponseBody
	Map<String, ? extends Object> servirProducto(
			@RequestParam Integer idProductoPedido) throws Exception {

		try {

			productoPedidoService.servirProductoPedido(idProductoPedido);

			return getMap("Producto servido.");

		} catch (Exception e) {

			return getModelMapError("Error retrieving Pedidos from database.");
		}
	}

	//
	// @RequestMapping(value="/clienteMovil/create.action")
	// public @ResponseBody Map<String,? extends Object> create(@RequestParam
	// Object data) throws Exception {
	//
	// try{
	//
	// List<ProductoPedido> productoPedidos =
	// productoPedidoService.create(data);
	//
	// return getMap(productoPedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to create productoPedido.");
	// }
	// }
	//
	// @RequestMapping(value="/clienteMovil/update.action")
	// public @ResponseBody Map<String,? extends Object> update(@RequestParam
	// Object data) throws Exception {
	// try{
	//
	// List<ProductoPedido> productoPedidos =
	// productoPedidoService.update(data);
	//
	// return getMap(productoPedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to update productoPedido.");
	// }
	// }
	//
	// @RequestMapping(value="/clienteMovil/delete.action")
	// public @ResponseBody Map<String,? extends Object> delete(@RequestParam
	// Object data) throws Exception {
	//
	// try{
	//
	// productoPedidoService.delete(data);
	//
	// Map<String,Object> modelMap = new HashMap<String,Object>(3);
	// modelMap.put("success", true);
	//
	// return modelMap;
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to delete productoPedido.");
	// }
	// }

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productoPedidos
	 * @return
	 */
	private Map<String, Object> getMapDto(
			List<ProductoPedidoDto> productoPedidos) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", productoPedidos.size());
		modelMap.put("data", productoPedidos);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productoPedidos
	 * @return
	 */
	private Map<String, Object> getMap(List<ProductoPedido> productoPedidos) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", productoPedidos.size());
		modelMap.put("data", productoPedidos);
		modelMap.put("success", true);

		return modelMap;
	}

	private Map<String, Object> getMap(String msg) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView in case of exception
	 * 
	 * @param msg
	 *            message
	 * @return
	 */
	private Map<String, Object> getModelMapError(String msg) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	}

	@Autowired
	public void setProductoPedidoService(
			ProductoPedidoService productoPedidoService) {
		this.productoPedidoService = productoPedidoService;
	}

}
