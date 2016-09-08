package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.Pedido;

public interface IPedidoDAO {

	List<Pedido> getPedidos();

	void deletePedido(int id);

	Pedido savePedido(Pedido pedido);

}
