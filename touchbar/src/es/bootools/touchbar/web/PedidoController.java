package es.bootools.touchbar.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.bootools.touchbar.dto.PedidoAltaDto;
import es.bootools.touchbar.model.Pedido;
import es.bootools.touchbar.service.ArithmeticService;
import es.bootools.touchbar.service.PedidoService;

@Controller
public class PedidoController {

	private PedidoService pedidoService;

	@Resource(name = "springService")
	private ArithmeticService springService;

	@RequestMapping(value = "/pedido/add.action")
	public @ResponseBody
	Integer add(@RequestParam Integer inputNumber1,
			@RequestParam Integer inputNumber2) {

		Integer sum = springService.add(inputNumber1, inputNumber2);
		return sum;
	}

	@RequestMapping(value = "/pedido/save.action")
	public @ResponseBody
	Map<String, ? extends Object> savePedidoView(@ModelAttribute("PedidoAltaDto") PedidoAltaDto pedidoAltaDto)
			throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		if (pedidoAltaDto.getProductos() == null || pedidoAltaDto.getProductos().isEmpty()) {
			return getModelMapError("No hay productos en el pedido.");
		} else {
			try {
				Pedido pedido = pedidoService.create(pedidoAltaDto);
				cal.setTime(pedido.getFechaPedido());
				stringBuilder.append("Pedido realizado el: ");
				stringBuilder.append(cal.get(Calendar.DAY_OF_MONTH));
				stringBuilder.append(" - ");
				stringBuilder.append(cal.get(Calendar.MONTH));
				stringBuilder.append(" - ");
				stringBuilder.append(cal.get(Calendar.YEAR));
				stringBuilder.append(" ");
				stringBuilder.append(cal.get(Calendar.HOUR_OF_DAY));
				stringBuilder.append(" : ");
				stringBuilder.append(cal.get(Calendar.MINUTE));
				stringBuilder.append(" : ");
				stringBuilder.append(cal.get(Calendar.SECOND));
				return getModel(stringBuilder.toString());
			} catch (Exception e) {
				e.printStackTrace();
				return getModelMapError("Error retrieving Pedidos from database.");
			}
		}
	}
	
//	@RequestMapping(value = "/pedido/save.action")
//	public @ResponseBody
//	Map<String, ? extends Object> savePedidoView(@RequestParam String productos)
//			throws Exception {
//		StringBuilder stringBuilder = new StringBuilder();
//		Calendar cal = Calendar.getInstance();
//		if (productos == null || productos.isEmpty()) {
//			return getModelMapError("No hay productos en el pedido.");
//		} else {
//			try {
//				Pedido pedido = pedidoService.create(productos);
//				cal.setTime(pedido.getFechaPedido());
//				stringBuilder.append("Pedido realizado el: ");
//				stringBuilder.append(cal.get(Calendar.DAY_OF_MONTH));
//				stringBuilder.append(" - ");
//				stringBuilder.append(cal.get(Calendar.MONTH));
//				stringBuilder.append(" - ");
//				stringBuilder.append(cal.get(Calendar.YEAR));
//				stringBuilder.append(" ");
//				stringBuilder.append(cal.get(Calendar.HOUR_OF_DAY));
//				stringBuilder.append(" : ");
//				stringBuilder.append(cal.get(Calendar.MINUTE));
//				stringBuilder.append(" : ");
//				stringBuilder.append(cal.get(Calendar.SECOND));
//				return getModel(stringBuilder.toString());
//			} catch (Exception e) {
//				e.printStackTrace();
//				return getModelMapError("Error retrieving Pedidos from database.");
//			}
//		}
//	}

	// @RequestMapping(value = "pedido/get_all_by_destino_producto.action")
	// public @ResponseBody
	// Map<String, ? extends Object> getAllByDestinoProducto(@RequestParam
	// Integer idEmpleado) throws Exception {
	//
	// try {
	// //se obtienen todos los pedidos
	// // List<Pedido> pedidos = pedidoService.getPedidoList();
	//
	// //se obtienen los productos de ese pedido si su destino producto coincide
	// con el del empleado.
	// // List<Producto> pedidos = pedidoService.getPedidoList();
	//
	// //se obtinen todos los productos pedido de los pedidos si su destino
	// producto coincide con el del empleado.
	// List<ProductoPedido> pedidos = ProductoPedidoService.getPedidoList();
	//
	// return getMap(pedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error retrieving Pedidos from database.");
	// }
	// }

	@RequestMapping(value = "/pedido/get_all_pedidos.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllView() throws Exception {

		try {

			List<Pedido> pedidos = pedidoService.getPedidoList();

			return getMap(pedidos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Pedidos from database.");
		}
	}

	//
	// @RequestMapping(value="/pedido/create.action")
	// public @ResponseBody Map<String,? extends Object> create(@RequestParam
	// Object data) throws Exception {
	//
	// try{
	//
	// List<Pedido> pedidos = pedidoService.create(data);
	//
	// return getMap(pedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to create pedido.");
	// }
	// }
	//
	// @RequestMapping(value="/pedido/update.action")
	// public @ResponseBody Map<String,? extends Object> update(@RequestParam
	// Object data) throws Exception {
	// try{
	//
	// List<Pedido> pedidos = pedidoService.update(data);
	//
	// return getMap(pedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to update pedido.");
	// }
	// }
	//
	// @RequestMapping(value="/pedido/delete.action")
	// public @ResponseBody Map<String,? extends Object> delete(@RequestParam
	// Object data) throws Exception {
	//
	// try{
	//
	// pedidoService.delete(data);
	//
	// Map<String,Object> modelMap = new HashMap<String,Object>(3);
	// modelMap.put("success", true);
	//
	// return modelMap;
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to delete pedido.");
	// }
	// }

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param pedidos
	 * @return
	 */
	private Map<String, Object> getMap(List<Pedido> pedidos) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", pedidos.size());
		modelMap.put("data", pedidos);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param pedidos
	 * @return
	 */
	private Map<String, Object> getMap(Pedido pedido) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", pedido);
		modelMap.put("success", true);

		return modelMap;
	}

	private Map<String, Object> getModel(String msg) {

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
	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

}
