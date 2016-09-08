package es.bootools.touchbar.dao.iface;

import java.util.Date;
import java.util.List;

import es.bootools.touchbar.model.Empleado;
import es.bootools.touchbar.model.ProductoPedido;

public interface IProductoPedidoDAO {

	List<ProductoPedido> getProductoPedidos();

	void deleteProductoPedido(int id);

	ProductoPedido saveProductoPedido(ProductoPedido cliente);

	ProductoPedido getById(Integer id);

	List<ProductoPedido> getProductoPedidoByEmpleado(Empleado empleado);

	List<ProductoPedido> getProductoPedidoByEmpleadoNoServido(Empleado empleado);

	List<ProductoPedido> getProductoPedidoNoServido();

	List<ProductoPedido> getProductoPedidoByPeriodo(Date inicio, Date fin);

}
