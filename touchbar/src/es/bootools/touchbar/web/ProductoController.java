package es.bootools.touchbar.web;

import java.util.ArrayList;
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

import es.bootools.touchbar.dto.ProductoAltaDto;
import es.bootools.touchbar.dto.ProductoDto;
import es.bootools.touchbar.model.Producto;
import es.bootools.touchbar.service.ArithmeticService;
import es.bootools.touchbar.service.ProductoService;

@Controller
public class ProductoController {

	private ProductoService productoService;

	@Resource(name = "springService")
	private ArithmeticService springService;

	@RequestMapping(value = "/producto/add.action")
	public @ResponseBody
	Integer add(@RequestParam Integer inputNumber1,
			@RequestParam Integer inputNumber2) {

		Integer sum = springService.add(inputNumber1, inputNumber2);
		return sum;
	}

	@RequestMapping(value = "/producto/get_producto.action")
	public @ResponseBody
	Map<String, ? extends Object> getProductoView(
			@RequestParam Integer idProducto) throws Exception {

		try {

			Producto producto = productoService.getProducto(idProducto);

			return getMap(producto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/producto/get.action")
	public @ResponseBody
	Map<String, ? extends Object> getProductoAdmin(
			@RequestParam Integer idProducto) throws Exception {

		try {

			ProductoDto producto = productoService.getProductoDto(idProducto);

			return getMapDto(producto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/producto/get_all_productos.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllView() throws Exception {

		try {

			List<Producto> productos = productoService.getProductoList();

			return getMap(productos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/producto/get_all_order_by_group.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllOrderByProducto() throws Exception {

		try {

			List<ProductoDto> productos = productoService
					.getProductoOrderByGroup();

			return getMapDto(productos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/producto/get_all_by_grupo.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllByGroupView(
			@RequestParam Integer idGrupo) throws Exception {

		try {

			List<Producto> productos = productoService
					.getProductosByGroupList(idGrupo);

			return getMap(productos);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/producto/create.action")
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("ProductoAltaDto") ProductoAltaDto producto)
			throws Exception {

		List<ProductoAltaDto> productos = new ArrayList<ProductoAltaDto>();
		productos.add(producto);

		try {

			productoService.createFromAltaDto(productos);

			if (producto.getIdProducto() != null) {
				return getModelMap("Producto  " + producto.getNombre()
						+ " creado correctamente. ");
			} else {
				return getModelMap("Producto  " + producto.getNombre()
						+ " actualizado correctamente. ");
			}

		} catch (Exception e) {

			return getModelMapError("Error trying to create producto.");
		}
	}

	@RequestMapping(value = "/producto/create_or_update.action")
	public @ResponseBody
	Map<String, ? extends Object> createOrUpdate(
			@ModelAttribute("ProductoAltaDto") ProductoAltaDto producto)
			throws Exception {

		List<ProductoAltaDto> productos = new ArrayList<ProductoAltaDto>();
		productos.add(producto);

		try {

			List<Producto> productosNew = productoService
					.createFromAltaDto(productos);

			return getMap(productosNew);

		} catch (Exception e) {

			return getModelMapError("Error trying to create producto.");
		}
	}

	//
	// @RequestMapping(value="/producto/update.action")
	// public @ResponseBody Map<String,? extends Object> update(@RequestParam
	// Object data) throws Exception {
	// try{
	//
	// List<Producto> productos = productoService.update(data);
	//
	// return getMap(productos);
	//
	// } catch (Exception e) {
	//
	// return getModelMapError("Error trying to update producto.");
	// }
	// }
	//
	@RequestMapping(value = "/producto/delete.action")
	public @ResponseBody
	Map<String, ? extends Object> delete(@RequestParam Integer idProducto)
			throws Exception {

		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto(idProducto, null, null));

		try {
			productoService.delete(productos);

			return getMap("Producto eliminado correctamente.");

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
	private Map<String, Object> getMap(List<Producto> productos) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", productos.size());
		modelMap.put("data", productos);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMapDto(List<ProductoDto> productos) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", productos.size());
		modelMap.put("data", productos);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMapDto(ProductoDto producto) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", producto);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(Producto producto) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", producto);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(String str) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", str);
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
	private Map<String, Object> getModelMap(String msg) {

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
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

}
