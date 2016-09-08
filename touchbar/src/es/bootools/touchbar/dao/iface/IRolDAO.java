package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.Rol;

public interface IRolDAO {

	List<Rol> getRoles();

	void deleteRol(int id);

	Rol saveRol(Rol rol);

	Rol getById(Integer id);

	List<Rol> getRolesOrderByDestino();

}
