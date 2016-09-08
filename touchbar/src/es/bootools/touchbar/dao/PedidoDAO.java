package es.bootools.touchbar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.bootools.touchbar.dao.iface.IPedidoDAO;
import es.bootools.touchbar.model.Pedido;

@Repository
public class PedidoDAO implements IPedidoDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Get List of Pedidos from database
	 * 
	 * @return list of all Pedidos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getPedidos() {
		return hibernateTemplate.find("from Pedido");
	}

	/**
	 * Delete a Pedido with the id passed as parameter
	 * 
	 * @param id
	 */
	@Override
	public void deletePedido(int id) {
		Object record = hibernateTemplate.load(Pedido.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new Pedido on the database or Update pedido
	 * 
	 * @param pedido
	 * @return pedido added or updated in DB
	 */
	@Override
	public Pedido savePedido(Pedido pedido) {
		hibernateTemplate.save(pedido);
		return pedido;
	}

}
