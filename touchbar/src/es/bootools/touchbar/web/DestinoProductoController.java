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

import es.bootools.touchbar.dto.DestinoProductoDto;
import es.bootools.touchbar.model.DestinoProducto;
import es.bootools.touchbar.service.ArithmeticService;
import es.bootools.touchbar.service.DestinoProductoService;

@Controller
public class DestinoProductoController {

	private DestinoProductoService destinoProductoService;

	@Resource(name = "springService")
	private ArithmeticService springService;

	@RequestMapping(value = "/destino_producto/add.action")
	public @ResponseBody
	Integer add(@RequestParam Integer inputNumber1,
			@RequestParam Integer inputNumber2) {

		Integer sum = springService.add(inputNumber1, inputNumber2);
		return sum;
	}

	@RequestMapping(value = "/destino_producto/get.action")
	public @ResponseBody
	Map<String, ? extends Object> getDestinoProducto(
			@RequestParam Integer idDestinoProducto) throws Exception {

		try {

			DestinoProducto destinoProducto = destinoProductoService
					.getDestinoProducto(idDestinoProducto);

			return getMap(destinoProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/destino_producto/delete.action")
	public @ResponseBody
	Map<String, ? extends Object> delete(@RequestParam Integer idDestinoProducto)
			throws Exception {

		try {
			destinoProductoService.delete(idDestinoProducto);

			return getMap("Destino eliminado correctamente.");

		} catch (DataIntegrityViolationException c) {
			return getModelMapError("Existen Productos en este Destino. Cambie o elimine los productos dependientes.");
		} catch (Exception e) {

			return getModelMapError("Error trying to create producto.");
		}
	}

	@RequestMapping(value = "/destino_producto/create.action")
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("DestinoProducto") DestinoProducto destinoProducto)
			throws Exception {

		List<DestinoProducto> destinoProductos = new ArrayList<DestinoProducto>();
		destinoProductos.add(destinoProducto);

		try {

			destinoProductoService.create(destinoProductos);

			if (destinoProducto.getIdDestinoProducto() != null) {
				return getMap("Destino " + destinoProducto.getNombre()
						+ " creado correctamente. ");
			} else {
				return getMap("Destino  " + destinoProducto.getNombre()
						+ " actualizado correctamente. ");
			}

		} catch (Exception e) {

			return getModelMapError("Error trying to create producto.");
		}
	}

	@RequestMapping(value = "/destino_producto/get_all.action")
	public @ResponseBody
	Map<String, ? extends Object> getAll() throws Exception {

		try {

			List<DestinoProducto> destinosProducto = destinoProductoService
					.getAllDestinosProducto();

			return getMap(destinosProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(List<DestinoProducto> destinosProducto) {

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
	private Map<String, Object> getMapDto(
			List<DestinoProductoDto> destinosProducto) {

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
	private Map<String, Object> getMap(DestinoProducto destinoProducto) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", destinoProducto);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(String msg) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
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
	public void setProductoService(DestinoProductoService destinoProductoService) {
		this.destinoProductoService = destinoProductoService;
	}

}
