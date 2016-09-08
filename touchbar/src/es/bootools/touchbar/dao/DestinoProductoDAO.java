package es.bootools.touchbar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IDestinoProductoDAO;
import es.bootools.touchbar.model.DestinoProducto;

@Repository
public class DestinoProductoDAO implements IDestinoProductoDAO {

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
	public DestinoProducto getById(Integer id) {
		DestinoProducto instance = (DestinoProducto) hibernateTemplate.get(
				DestinoProducto.class.getName(), id);
		return instance;
	}

	/**
	 * Get List of destinoProductos from database
	 * 
	 * @return list of all destinoProductos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DestinoProducto> getDestinosProducto() {
		return hibernateTemplate.find("from DestinoProducto");
	}

	/**
	 * Delete a DestinoProducto with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteDestinoProducto(int id) {
		Object record = hibernateTemplate.load(DestinoProducto.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new destinoProducto on the database or Update destinoProducto
	 * 
	 * @param destinoProducto
	 * @return destinoProducto added or updated in DB
	 */
	@Override
	public DestinoProducto saveDestinoProducto(DestinoProducto destinoProducto) {
		hibernateTemplate.saveOrUpdate(destinoProducto);
		return destinoProducto;
	}

}
