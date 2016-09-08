package es.bootools.touchbar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IEmpleadoDAO;
import es.bootools.touchbar.model.Empleado;
import es.bootools.touchbar.model.Producto;

@Repository
public class EmpleadoDAO implements IEmpleadoDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Get List of Empleados from database
	 * 
	 * @return list of all Empleados
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> getEmpleados() {
		return hibernateTemplate.find("from Empleado");
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> getEmpleadosOrderByRol() {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(Empleado.class);
		Query query = session
				.createQuery("from Empleado e order by e.rol.idRol");

		return query.list();

	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@Override
	public Empleado getById(Integer id) {
		Empleado instance = (Empleado) hibernateTemplate.get(
				Empleado.class.getName(), id);
		return instance;
	}

	/**
	 * Delete a Empleado with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteEmpleado(int id) {
		Object record = hibernateTemplate.load(Empleado.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Delete a Empleado with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public Empleado getEmpleado(int id) {
		return hibernateTemplate.get(Empleado.class, id);
	}

	/**
	 * Create a new Empleado on the database or Update empleado
	 * 
	 * @param empleado
	 * @return empleado added or updated in DB
	 */
	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		hibernateTemplate.saveOrUpdate(empleado);
		return empleado;
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@Override
	public Empleado getByCodigo(String codigo) {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(Producto.class);
		Query query = session
				.createQuery("from Empleado e where e.codEmpleado like '"
						+ codigo + "'");

		return (Empleado) query.list().get(0);

	}

}
