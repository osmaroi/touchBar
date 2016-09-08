package es.bootools.touchbar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IGrupoProductoDAO;
import es.bootools.touchbar.model.GrupoProducto;

@Repository
public class GrupoProductoDAO implements IGrupoProductoDAO {

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
	public GrupoProducto getById(Integer id) {
		GrupoProducto instance = (GrupoProducto) hibernateTemplate.get(
				GrupoProducto.class.getName(), id);

		return instance;

	}

	/**
	 * Get List of GrupoProductos from database
	 * 
	 * @return list of all GrupoProductos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GrupoProducto> getGruposProducto() {
		return hibernateTemplate.find("from GrupoProducto");
	}

	/**
	 * Delete a GrupoProducto with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteGrupoProducto(int id) {
		Object record = hibernateTemplate.load(GrupoProducto.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new GrupoProducto on the database or Update grupoProducto
	 * 
	 * @param grupoProducto
	 * @return grupoProducto added or updated in DB
	 */
	@Override
	public GrupoProducto saveGrupoProducto(GrupoProducto grupoProducto) {
		hibernateTemplate.saveOrUpdate(grupoProducto);
		return grupoProducto;
	}

}
