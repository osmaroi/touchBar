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

import es.bootools.touchbar.dto.EmpleadoAltaDto;
import es.bootools.touchbar.dto.EmpleadoDto;
import es.bootools.touchbar.model.Empleado;
import es.bootools.touchbar.service.EmpleadoService;

@Controller
public class EmpleadoController {

	private EmpleadoService empleadoService;

	@RequestMapping(value = "/empleado/get.action")
	public @ResponseBody
	Map<String, ? extends Object> getEmpleado(@RequestParam Integer idEmpleado)
			throws Exception {

		try {

			Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);

			return getMap(empleado);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/empleado/getDto.action")
	public @ResponseBody
	Map<String, ? extends Object> getEmpleadoDto(
			@RequestParam Integer idEmpleado) throws Exception {

		try {

			EmpleadoDto empleado = empleadoService
					.getEmpleadoByIdDto(idEmpleado);

			return getMap(empleado);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/empleado/get_all.action")
	public @ResponseBody
	Map<String, ? extends Object> getAll() throws Exception {

		try {

			List<EmpleadoDto> destinosProducto = empleadoService
					.getEmpleadosDto();

			return getMapDto(destinosProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/empleado/get_all_order_by_rol.action")
	public @ResponseBody
	Map<String, ? extends Object> getAllOrderByRol() throws Exception {

		try {

			List<EmpleadoDto> destinosProducto = empleadoService
					.getEmpleadosOrderByRolDto();

			return getMapDto(destinosProducto);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Productos from database.");
		}
	}

	@RequestMapping(value = "/empleado/create.action")
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("EmpleadoAltaDto") EmpleadoAltaDto empleado)
			throws Exception {

		List<EmpleadoAltaDto> empleados = new ArrayList<EmpleadoAltaDto>();
		empleados.add(empleado);

		try {

			empleadoService.create(empleados);

			if (empleado.getIdEmpleado() == null) {
				return getMap("Empleado  " + empleado.getNombre()
						+ " creado correctamente. ");
			} else {
				return getMap("Empleado  " + empleado.getNombre()
						+ " actualizado correctamente. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error. El Codigo del Empleado ya existe.");
		}
	}

	@RequestMapping(value = "/empleado/delete.action")
	public @ResponseBody
	Map<String, ? extends Object> delete(@RequestParam Integer idEmpleado)
			throws Exception {

		List<Empleado> empleado = new ArrayList<Empleado>();
		empleado.add(new Empleado(idEmpleado, null));

		try {
			empleadoService.delete(empleado);

			return getMap("Empleado eliminado correctamente.");

		} catch (Exception e) {

			return getModelMapError("Error trying to create producto.");
		}
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
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(List<Empleado> empleados) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", empleados.size());
		modelMap.put("data", empleados);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(EmpleadoDto empleado) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", empleado);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMapDto(List<EmpleadoDto> Empleados) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", Empleados.size());
		modelMap.put("data", Empleados);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param productos
	 * @return
	 */
	private Map<String, Object> getMap(Empleado empleado) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", empleado);
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
	public void setProductoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

}
