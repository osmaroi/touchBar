package es.bootools.touchbar.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.bootools.touchbar.dto.RolAltaDto;
import es.bootools.touchbar.dto.RolDto;
import es.bootools.touchbar.model.Rol;
import es.bootools.touchbar.service.RolService;

@Controller
public class RolController {

	private RolService rolService;

	@RequestMapping(value = "/rol/get.action")
	public @ResponseBody
	Map<String, ? extends Object> getRol(@RequestParam Integer idRol)
			throws Exception {

		try {

			RolDto rol = rolService.getRolById(idRol);

			return getMap(rol);

		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error retrieving Roles from database.");
		}
	}

	@RequestMapping(value = "/rol/get_all.action")
	public @ResponseBody
	Map<String, ? extends Object> getAll() throws Exception {

		try {

			List<Rol> destinosProducto = rolService.getRolList();

			return getMap(destinosProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/rol/get_all_order_by_destino.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllOrderByDestino() throws Exception {

		try {

			List<RolDto> destinosProducto = rolService
					.getRolOrderByDestinoProducto();

			return getMapDto(destinosProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/rol/create.action")
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("RolAltaDto") RolAltaDto rol) throws Exception {

		if (rol.getIdRol() != null) {
			if (rol.getIdRol() == 1) 
			return getModelMapError("Rol Admin no se puede modificar.");
		}

		List<RolAltaDto> roles = new ArrayList<RolAltaDto>();
		roles.add(rol);

		try {

			rolService.create(roles);

			if (rol.getIdRol() != null) {
				return getMap("Rol  " + rol.getNombre()
						+ " creado correctamente. ");
			} else {
				return getMap("Rol  " + rol.getNombre()
						+ " actualizado correctamente. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error trying to create producto.");
		}
	}

	@RequestMapping(value = "/rol/delete.action")
	public @ResponseBody
	Map<String, ? extends Object> delete(@RequestParam Integer idRol)
			throws Exception {

		if (idRol == 1) {
			return getModelMapError("Rol Admin no se puede eliminar.");
		}

		List<Rol> rol = new ArrayList<Rol>();
		rol.add(new Rol(idRol, null));

		try {
			rolService.delete(rol);

			return getMap("Rol eliminado correctamente.");

		} catch (Exception e) {

			return getModelMapError("Error trying to create producto.");
		}
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(List<Rol> destinosProducto) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", destinosProducto.size());
		modelMap.put("data", destinosProducto);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMapDto(List<RolDto> destinosProducto) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", destinosProducto.size());
		modelMap.put("data", destinosProducto);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(RolDto rol) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", rol);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(Rol rol) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", rol);
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
	public void setProductoService(RolService rolService) {
		this.rolService = rolService;
	}

}
