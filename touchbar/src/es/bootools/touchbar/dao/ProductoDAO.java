package es.bootools.touchbar.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IProductoDAO;
import es.bootools.touchbar.model.Producto;

@Repository
public class ProductoDAO implements IProductoDAO {

	private static final Log log = LogFactory.getLog(ProductoDAO.class);
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@Override
	public Producto getById(Integer id) {
		log.debug("getting Producto instance with id: " + id);
		try {
			Producto instance = (Producto) hibernateTemplate.get(
					Producto.class.getName(), id);// findByExample(producto);
			log.debug("get successful");
			// if(!instance.isEmpty())
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByGroup(Integer id) {
		log.debug("getting Producto instance with Groupid: " + id);

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(Producto.class);
		Query query = session
				.createQuery("from Producto p where p.grupoProducto.idGrupoProducto = "
						+ id);

		log.debug("get successful");

		return query.list();

	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getProductosOrderByGroup() {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(Producto.class);
		Query query = session
				.createQuery("from Producto p order by p.grupoProducto.idGrupoProducto");

		return query.list();

	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getProductos() {
		return hibernateTemplate.find("from Producto");
	}

	/**
	 * Delete a Producto with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteProducto(int id) {
		Object record = hibernateTemplate.load(Producto.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new Producto on the database or Update producto
	 * 
	 * @param producto
	 * @return producto added or updated in DB
	 */
	@Override
	public Producto saveProducto(Producto producto) {
		hibernateTemplate.saveOrUpdate(producto);
		return producto;
	}

}
