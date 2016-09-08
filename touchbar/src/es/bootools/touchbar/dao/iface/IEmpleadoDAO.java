package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.Empleado;

public interface IEmpleadoDAO {

	List<Empleado> getEmpleados();

	void deleteEmpleado(int id);

	Empleado saveEmpleado(Empleado empleado);

	Empleado getByCodigo(String codigo);

	Empleado getEmpleado(int id);

	Empleado getById(Integer id);

	List<Empleado> getEmpleadosOrderByRol();

}
