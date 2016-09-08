package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.dao.EmpleadoDAO;
import es.bootools.touchbar.dto.EmpleadoAltaDto;
import es.bootools.touchbar.dto.EmpleadoDto;
import es.bootools.touchbar.dto.RolDto;
import es.bootools.touchbar.model.Empleado;

/**
 * Empleado Service
 * 
 */
@Service
public class EmpleadoService {

	private EmpleadoDAO empleadoDAO;

	/**
	 * Get all Empleados
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Empleado> getEmpleadoList() {

		return empleadoDAO.getEmpleados();
	}

	/**
	 * Get all Empleados
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<EmpleadoDto> getEmpleadosDto() {

		List<Empleado> empleadoList = empleadoDAO.getEmpleados();
		List<EmpleadoDto> empleadoListDto = new ArrayList<EmpleadoDto>();

		for (Empleado empleado : empleadoList) {
			empleadoListDto.add(EmpleadoDto.buildDto(
					RolDto.buildDto(null, empleado.getRol()), empleado));
		}
		return empleadoListDto;
	}

	/**
	 * Get all Empleados
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<EmpleadoDto> getEmpleadosOrderByRolDto() {

		List<Empleado> empleadoList = empleadoDAO.getEmpleadosOrderByRol();
		List<EmpleadoDto> empleadoListDto = new ArrayList<EmpleadoDto>();

		for (Empleado empleado : empleadoList) {
			empleadoListDto.add(EmpleadoDto.buildDto(
					RolDto.buildDto(null, empleado.getRol()), empleado));
		}
		return empleadoListDto;
	}

	/**
	 * Get all Empleados
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public EmpleadoDto getEmpleadoByCod(String codEmpleado) {

		Empleado empleado = empleadoDAO.getByCodigo(codEmpleado);
		EmpleadoDto empleadoDto = EmpleadoDto.buildDto(
				RolDto.buildDto(null, empleado.getRol()), empleado);

		return empleadoDto;
	}

	/**
	 * Get Empleado by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Empleado getEmpleadoById(Integer id) {

		return empleadoDAO.getById(id);
	}

	/**
	 * Get Empleado by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public EmpleadoDto getEmpleadoByIdDto(Integer id) {

		Empleado empleado = empleadoDAO.getById(id);
		EmpleadoDto empleadoDto = EmpleadoDto.buildDto(
				RolDto.buildDto(null, empleado.getRol()), empleado);
		return empleadoDto;
	}

	/**
	 * Create new Rol/Rols
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Rols
	 */
	@Transactional
	public List<Empleado> create(List<EmpleadoAltaDto> empleados) {

		List<Empleado> newEmpleados = new ArrayList<Empleado>();

		for (EmpleadoAltaDto empleado : empleados) {
			Empleado newEmpleado = EmpleadoAltaDto.buildPojo(empleado);
			newEmpleados.add(empleadoDAO.saveEmpleado(newEmpleado));
		}

		return newEmpleados;
	}

	/**
	 * Delete Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(List<Empleado> empleados) {

		for (Empleado empleado : empleados) {
			empleadoDAO.deleteEmpleado(empleado.getIdEmpleado());
		}

	}

	// /**
	// * Create new Empleado/Empleados
	// * @param data - json data from request
	// * @return created Empleados
	// */
	// @Transactional
	// public List<Empleado> create(Object data){
	//
	// List<Empleado> newEmpleados = new ArrayList<Empleado>();
	//
	// List<Empleado> list = empleadoConverter.getEmpleadosFromRequest(data);
	//
	// for (Empleado Empleado : list){
	// newEmpleados.add(empleadoDAO.saveEmpleado(Empleado));
	// }
	//
	// return newEmpleados;
	// }

	// /**
	// * Update Empleado/Empleados
	// * @param data - json data from request
	// * @return updated Empleados
	// */
	// @Transactional
	// public List<Empleado> update(Object data){
	//
	// List<Empleado> returnEmpleados = new ArrayList<Empleado>();
	//
	// List<Empleado> updatedEmpleados =
	// empleadoConverter.getEmpleadosFromRequest(data);
	//
	// for (Empleado Empleado : updatedEmpleados){
	// returnEmpleados.add(empleadoDAO.saveEmpleado(Empleado));
	// }
	//
	// return returnEmpleados;
	// }

	// /**
	// * Delete Empleado/Empleados
	// * @param data - json data from request
	// */
	// @Transactional
	// public void delete(Object data){
	//
	// //it is an array - have to cast to array object
	// if (data.toString().indexOf('[') > -1){
	//
	// List<Integer> deleteEmpleados =
	// empleadoConverter.getListIdFromJSON(data);
	//
	// for (Integer id : deleteEmpleados){
	// empleadoDAO.deleteEmpleado(id);
	// }
	//
	// } else { //it is only one object - cast to object/bean
	//
	// Integer id = Integer.parseInt(data.toString());
	//
	// empleadoDAO.deleteEmpleado(id);
	// }
	// }

	/**
	 * Spring use - DI
	 * 
	 * @param empleadoDAO
	 */
	@Autowired
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}

}
