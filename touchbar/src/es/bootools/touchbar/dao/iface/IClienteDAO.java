package es.bootools.touchbar.dao.iface;

import java.util.List;

import es.bootools.touchbar.model.Cliente;

public interface IClienteDAO {

	List<Cliente> getClientes();

	void deleteCliente(int id);

	Cliente saveCliente(Cliente cliente);

	Cliente getById(Integer id);

	Cliente getByCodUnicoMovil(String id);

}
