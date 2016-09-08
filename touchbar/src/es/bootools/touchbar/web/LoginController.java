package es.bootools.touchbar.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.bootools.touchbar.dto.EmpleadoDto;
import es.bootools.touchbar.service.EmpleadoService;

@Controller
public class LoginController {

	private EmpleadoService empleadoService;

	@RequestMapping(value = "/login/login.action")
	public @ResponseBody
	Map<String, ? extends Object> login(@RequestParam String codEmpleado,
			@RequestParam String password) {
		try {
			EmpleadoDto empleado = empleadoService
					.getEmpleadoByCod(codEmpleado);

			if (empleado == null
					|| empleado.getPassword().compareTo(password) != 0) {
				return getModelMapError("Empleado no registrado.");
			} else {
				String page = "app_viewer.jsp";
				empleado.hidePersonalData();
				if (empleado.getRol().getNombre().compareTo("Admin") == 0) {
					page = "app_admin.jsp";
				}
				return getMap(empleado, page);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error retrieving Empleado from database.");
		}
	}

	// @RequestMapping(value = "/pedido/save.action")
	// public @ResponseBody
	// Map<String, ? extends Object> savePedidoView(@RequestParam String
	// productos)
	// throws Exception {
	//
	// if (productos == null || productos.isEmpty()) {
	// return getModelMapError("No hay productos en el pedido.");
	// } else {
	// try {
	// pedidoService.create(productos);
	// return getModelMapError("Pedido guardado con exito.");
	// } catch (Exception e) {
	// e.printStackTrace();
	// return getModelMapError("Error retrieving Pedidos from database.");
	// }
	// }
	// }
	//
	// @RequestMapping(value = "pedido/get_all_by_destino_producto.action")
	// public @ResponseBody
	// Map<String, ? extends Object> getAllByDestinoProducto(@RequestParam
	// Empleado empleado) throws Exception {
	//
	// try {
	//
	// List<Pedido> pedidos = pedidoService.getPedidoList();
	//
	// return getMap(pedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error retrieving Pedidos from database.");
	// }
	// }
	//
	// @RequestMapping(value = "/pedido/get_all_pedidos.action")
	// public @ResponseBody
	// Map<String, ? extends Object> getAllView() throws Exception {
	//
	// try {
	//
	// List<Pedido> pedidos = pedidoService.getPedidoList();
	//
	// return getMap(pedidos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error retrieving Pedidos from database.");
	// }
	// }

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

	// /**
	// * Generates modelMap to return in the modelAndView
	// *
	// * @param pedidos
	// * @return
	// */
	// private Map<String, Object> getMap(List<Pedido> pedidos) {
	//
	// Map<String, Object> modelMap = new HashMap<String, Object>(3);
	// modelMap.put("total", pedidos.size());
	// modelMap.put("data", pedidos);
	// modelMap.put("success", true);
	//
	// return modelMap;
	// }

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param pedidos
	 * @return
	 */
	private Map<String, Object> getMap(Integer id) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", id);
		modelMap.put("success", true);

		return modelMap;
	}

	private Map<String, Object> getMap(EmpleadoDto empleado, String page) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", empleado);
		modelMap.put("page", page);
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
	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

}
