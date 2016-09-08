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

import es.bootools.touchbar.dao.iface.IClienteDAO;
import es.bootools.touchbar.model.Cliente;
import es.bootools.touchbar.model.Producto;

@Repository
public class ClienteDAO implements IClienteDAO {

	private static final Log log = LogFactory.getLog(ClienteDAO.class);
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Get List of clientes from database
	 * 
	 * @return list of all clientes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getClientes() {
		return hibernateTemplate.find("from Cliente");
	}

	/**
	 * Get List of Productos from database
	 * 
	 * @return list of all Productos
	 */
	@Override
	public Cliente getById(Integer id) {
		log.debug("getting Producto instance with id: " + id);

		try {
			Cliente instance = (Cliente) hibernateTemplate.get(
					Cliente.class.getName(), id);
			log.debug("get successful");
			// if(!instance.isEmpty())
			return instance;
			// else
			// throw new RuntimeException("No hay productos con este id");
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
	@Override
	public Cliente getByCodUnicoMovil(String id) {
		log.debug("getting Producto instance with Groupid: " + id);

		List<Cliente> clientes;
		
		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();
		
		session.createCriteria(Cliente.class);
		Query query = session
				.createQuery("from Cliente c where c.codUnicoMovil = '"
						+ id + "'");

		log.debug("get successful");

		clientes =  query.list();
		
		if(clientes.size() == 0 )
			return null;
		
		return (Cliente) query.list().get(0);
	}
	
	

	/**
	 * Delete a Cliente with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteCliente(int id) {
		Object record = hibernateTemplate.load(Cliente.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new cliente on the database or Update cliente
	 * 
	 * @param cliente
	 * @return cliente added or updated in DB
	 */
	@Override
	public Cliente saveCliente(Cliente cliente) {
		hibernateTemplate.saveOrUpdate(cliente);
		return cliente;
	}

}
