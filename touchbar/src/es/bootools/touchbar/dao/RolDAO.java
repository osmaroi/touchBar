package es.bootools.touchbar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IRolDAO;
import es.bootools.touchbar.model.Rol;

@Repository
public class RolDAO implements IRolDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Get List of Rols from database
	 * 
	 * @return list of all Rols
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> getRoles() {
		return hibernateTemplate.find("from Rol");
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@Override
	public Rol getById(Integer id) {
		Rol instance = (Rol) hibernateTemplate.get(Rol.class.getName(), id);
		return instance;
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> getRolesOrderByDestino() {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(Rol.class);
		Query query = session
				.createQuery("from Rol r order by r.destinoProducto.idDestinoProducto");

		return query.list();

	}

	/**
	 * Delete a Rol with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteRol(int id) {
		Object record = hibernateTemplate.load(Rol.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new Rol on the database or Update rol
	 * 
	 * @param rol
	 * @return rol added or updated in DB
	 */
	@Override
	public Rol saveRol(Rol rol) {
		hibernateTemplate.saveOrUpdate(rol);
		return rol;
	}

}
