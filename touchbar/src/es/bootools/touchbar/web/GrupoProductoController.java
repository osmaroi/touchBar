package es.bootools.touchbar.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.bootools.touchbar.model.GrupoProducto;
import es.bootools.touchbar.service.ArithmeticService;
import es.bootools.touchbar.service.GrupoProductoService;

@Controller
public class GrupoProductoController {

	private GrupoProductoService grupoProductoService;

	@Resource(name = "springService")
	private ArithmeticService springService;

	@RequestMapping(value = "/grupo_producto/add.action")
	public @ResponseBody
	Integer add(@RequestParam Integer inputNumber1,
			@RequestParam Integer inputNumber2) {

		Integer sum = springService.add(inputNumber1, inputNumber2);
		return sum;
	}

	@RequestMapping(value = "/grupo_producto/get.action")
	public @ResponseBody
	Map<String, ? extends Object> getProductoAdmin(
			@RequestParam Integer idGrupoProducto) throws Exception {

		try {

			GrupoProducto grupoProducto = grupoProductoService
					.getGrupoProducto(idGrupoProducto);

			return getMap(grupoProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/grupo_producto/get_all.action")
	public @ResponseBody
	Map<String, ? extends Object> getAll() throws Exception {

		try {

			List<GrupoProducto> grupoProductos = grupoProductoService
					.getGrupoProductoList();

			return getMap(grupoProductos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving GrupoProductos from database.");
		}
	}

	@RequestMapping(value = "/grupo_producto/create.action")
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("GrupoProducto") GrupoProducto grupoProducto)
			throws Exception {

		List<GrupoProducto> grupoProductos = new ArrayList<GrupoProducto>();
		grupoProductos.add(grupoProducto);

		try {

			grupoProductoService.create(grupoProductos);

			return getModelMap("El Grupo '" + grupoProducto.getNombre()
					+ "' se ha guardado correctamente. ");

		} catch (Exception e) {

			return getModelMapError("Error trying to create grupoProducto.");
		}
	}

	@RequestMapping(value = "/grupo_producto/update.action")
	public @ResponseBody
	Map<String, ? extends Object> update(@RequestParam Object data)
			throws Exception {
		try {

			List<GrupoProducto> grupoProductos = grupoProductoService
					.update(data);

			return getMap(grupoProductos);

		} catch (Exception e) {

			return getModelMapError("Error trying to update grupoProducto.");
		}
	}

	// @RequestMapping(value="/grupo_producto/delete.action")
	// public @ResponseBody Map<String,? extends Object> delete(@RequestParam
	// Object data) throws Exception {
	//
	// try{
	//
	// grupoProductoService.delete(data);
	//
	// Map<String,Object> modelMap = new HashMap<String,Object>(3);
	// modelMap.put("success", true);
	//
	// return modelMap;
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to delete grupoProducto.");
	// }
	// }

	@RequestMapping(value = "/grupo_producto/delete.action")
	public @ResponseBody
	Map<String, ? extends Object> delete(@RequestParam Integer idGrupoProducto)
			throws Exception {

		try {

			grupoProductoService.delete(idGrupoProducto);

			return getModelMap("El grupo se ha eliminado. ");

		} catch (DataIntegrityViolationException c) {
			return getModelMapError("Existen Productos en este grupo. Cambie o elimine los productos dependientes.");
		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error trying to delete grupoProducto.");
		}
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param grupoProductos
	 * @return
	 */
	private Map<String, Object> getMap(List<GrupoProducto> grupoProductos) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", grupoProductos.size());
		modelMap.put("data", grupoProductos);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param grupoProductos
	 * @return
	 */
	private Map<String, Object> getMap(GrupoProducto grupoProducto) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", grupoProducto);
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

	/**
	 * Generates modelMap to return in the modelAndView in case of exception
	 * 
	 * @param msg
	 *            message
	 * @return
	 */
	private Map<String, Object> getModelMap(String msg) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", true);

		return modelMap;
	}

	@Autowired
	public void setGrupoProductoService(
			GrupoProductoService grupoProductoService) {
		this.grupoProductoService = grupoProductoService;
	}

}
