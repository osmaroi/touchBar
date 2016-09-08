package es.bootools.touchbar.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IProductoPedidoDAO;
import es.bootools.touchbar.model.Empleado;
import es.bootools.touchbar.model.ProductoPedido;

@Repository
public class ProductoPedidoDAO implements IProductoPedidoDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public ProductoPedido getById(Integer id) {
		try {
			ProductoPedido instance = (ProductoPedido) hibernateTemplate.get(
					ProductoPedido.class.getName(), id);

			return instance;
			// else
			// throw new RuntimeException("No hay productos con este id");
		} catch (RuntimeException re) {

			throw re;
		}
	}

	/**
	 * Get List of productoPedidos from database
	 * 
	 * @return list of all productoPedidos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoPedido> getProductoPedidos() {
		return hibernateTemplate.find("from ProductoPedido");
	}

	/**
	 * Delete a ProductoPedido with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deleteProductoPedido(int id) {
		Object record = hibernateTemplate.load(ProductoPedido.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new productoPedido on the database or Update productoPedido
	 * 
	 * @param productoPedido
	 * @return productoPedido added or updated in DB
	 */
	@Override
	public ProductoPedido saveProductoPedido(ProductoPedido productoPedido) {
		hibernateTemplate.saveOrUpdate(productoPedido);
		return productoPedido;
	}

	/**
	 * Obtiene los productos pedido que puede ver un empleado
	 * 
	 * @param productoPedido
	 * @return productoPedido added or updated in DB
	 */
	@Override
	public List<ProductoPedido> getProductoPedidoByEmpleado(Empleado empleado) {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(ProductoPedido.class);
		Query query = session
				.createQuery("from ProductoPedido pp where pp.producto.destinoProducto.idDestinoProducto = "
						+ empleado.getRol().getDestinoProducto()
								.getIdDestinoProducto()
						+ " order by pp.pedido.fechaPedido DESC, pp.producto.grupoProducto.nombre ASC , pp.producto.nombre  ASC");

		return query.list();
	}

	@Override
	public List<ProductoPedido> getProductoPedidoByEmpleadoNoServido(
			Empleado empleado) {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(ProductoPedido.class);
		Query query = session
				.createQuery("from ProductoPedido pp where pp.servido <> true and pp.producto.destinoProducto.idDestinoProducto = "
						+ empleado.getRol().getDestinoProducto()
								.getIdDestinoProducto()
						+ "  order by pp.pedido.fechaPedido DESC, pp.producto.grupoProducto.nombre ASC , pp.producto.nombre  ASC");

		return query.list();
	}

	@Override
	public List<ProductoPedido> getProductoPedidoByPeriodo(Date inicio, Date fin) {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(ProductoPedido.class);

		Query query = session
				.createQuery("from ProductoPedido pp where pp.pedido.fechaPedido between :inicio and :fin order by pp.pedido.fechaPedido DESC, pp.producto.grupoProducto.nombre ASC , pp.producto.nombre  ASC");

		query.setParameter("inicio", inicio);
		query.setParameter("fin", fin);

		return query.list();
	}

	@Override
	public List<ProductoPedido> getProductoPedidoNoServido() {

		Session session = hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		session.createCriteria(ProductoPedido.class);
		Query query = session
				.createQuery("from ProductoPedido pp where pp.servido <> true order by pedido.fechaPedido DESC");

		return query.list();
	}

}
