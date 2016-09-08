package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.dao.RolDAO;
import es.bootools.touchbar.dto.DestinoProductoDto;
import es.bootools.touchbar.dto.RolAltaDto;
import es.bootools.touchbar.dto.RolDto;
import es.bootools.touchbar.model.Rol;

/**
 * Rol Service
 * 
 */
@Service
public class RolService {

	private RolDAO rolDAO;

	/**
	 * Get all Rols
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Rol> getRolList() {

		return rolDAO.getRoles();
	}

	/**
	 * Get all Rols
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Rol> getRolDtoList() {

		return rolDAO.getRoles();
	}

	/**
	 * Get all Productos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<RolDto> getRolOrderByDestinoProducto() {

		List<Rol> roles = rolDAO.getRolesOrderByDestino();

		List<RolDto> newRoles = new ArrayList<RolDto>();

		for (Rol rol : roles) {
			newRoles.add(RolDto.buildDto(
					DestinoProductoDto.buildDto(rol.getDestinoProducto()), rol));
		}

		return newRoles;
	}

	// /**
	// * Get all Rols
	// * @return
	// */
	// @Transactional(readOnly=true)
	// public RolDto getRolByCod(String codRol){
	//
	// Rol rol = rolDAO.getByCodigo(codRol);
	//
	// RolDto rolDto =
	// RolDto.buildDto(DestinoProductoDto.buildDto(rol.getDestinoProducto()),
	// rol);
	//
	// return rolDto;
	// }

	/**
	 * Get Rol by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public RolDto getRolById(Integer id) {

		Rol rol = rolDAO.getById(id);

		RolDto rolDto = RolDto.buildDto(
				DestinoProductoDto.buildDto(rol.getDestinoProducto()), rol);

		return rolDto;
	}

	/**
	 * Create new Rol/Rols
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Rols
	 */
	@Transactional
	public List<Rol> create(List<RolAltaDto> roles) {

		List<Rol> newRoles = new ArrayList<Rol>();

		for (RolAltaDto rol : roles) {
			Rol newRol = RolAltaDto.buildPojo(rol);
			newRoles.add(rolDAO.saveRol(newRol));
		}

		return newRoles;
	}

	// /**
	// * Update Rol/Rols
	// * @param data - json data from request
	// * @return updated Rols
	// */
	// @Transactional
	// public List<Rol> update(Object data){
	//
	// List<Rol> returnRols = new ArrayList<Rol>();
	//
	// List<Rol> updatedRols = rolConverter.getRolsFromRequest(data);
	//
	// for (Rol Rol : updatedRols){
	// returnRols.add(rolDAO.saveRol(Rol));
	// }
	//
	// return returnRols;
	// }

	// /**
	// * Delete Rol/Rols
	// * @param data - json data from request
	// */
	// @Transactional
	// public void delete(Object data){
	//
	// //it is an array - have to cast to array object
	// if (data.toString().indexOf('[') > -1){
	//
	// List<Integer> deleteRols = rolConverter.getListIdFromJSON(data);
	//
	// for (Integer id : deleteRols){
	// rolDAO.deleteRol(id);
	// }
	//
	// } else { //it is only one object - cast to object/bean
	//
	// Integer id = Integer.parseInt(data.toString());
	//
	// rolDAO.deleteRol(id);
	// }
	// }

	/**
	 * Delete Producto/Productos
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(List<Rol> roles) {

		for (Rol rol : roles) {
			rolDAO.deleteRol(rol.getIdRol());
		}

	}

	/**
	 * Spring use - DI
	 * 
	 * @param rolDAO
	 */
	@Autowired
	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

}
