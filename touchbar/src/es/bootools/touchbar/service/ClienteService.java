package es.bootools.touchbar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.bootools.touchbar.converter.ClienteConverter;
import es.bootools.touchbar.dao.ClienteDAO;
import es.bootools.touchbar.model.Cliente;

/**
 * Cliente Service
 * 
 */
@Service
public class ClienteService {

	private ClienteDAO clienteDAO;
	private ClienteConverter clienteConverter;

	/**
	 * Get all Clientes
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Cliente> getClienteList() {

		return clienteDAO.getClientes();
	}

	/**
	 * Get Cliente by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Cliente getClienteById(Integer id) {

		return clienteDAO.getById(id);
	}
	
	/**
	 * Get Cliente by id
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Cliente getClienteByCodUnicoMovil(String id) {

		return clienteDAO.getByCodUnicoMovil(id);
	}

	/**
	 * Create new Cliente/Clientes
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Clientes
	 */
	@Transactional
	public List<Cliente> create(List<Cliente> clientes) {

		List<Cliente> newClientes = new ArrayList<Cliente>();

//		List<Cliente> list = clienteConverter.getClientesFromRequest(data);

		for (Cliente cliente : clientes) {
			newClientes.add(clienteDAO.saveCliente(cliente));
		}

		return newClientes;
	}
	
	/**
	 * Create new Cliente/Clientes
	 * 
	 * @param data
	 *            - json data from request
	 * @return created Clientes
	 */
	@Transactional
	public Cliente create(Cliente cliente) {

			cliente = clienteDAO.saveCliente(cliente);

		return cliente;
	}

	/**
	 * Update Cliente/Clientes
	 * 
	 * @param data
	 *            - json data from request
	 * @return updated Clientes
	 */
	@Transactional
	public List<Cliente> update(Object data) {

		List<Cliente> returnClientes = new ArrayList<Cliente>();

		List<Cliente> updatedClientes = clienteConverter
				.getClientesFromRequest(data);

		for (Cliente Cliente : updatedClientes) {
			returnClientes.add(clienteDAO.saveCliente(Cliente));
		}

		return returnClientes;
	}

	/**
	 * Delete Cliente/Clientes
	 * 
	 * @param data
	 *            - json data from request
	 */
	@Transactional
	public void delete(Object data) {

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			List<Integer> deleteClientes = clienteConverter
					.getListIdFromJSON(data);

			for (Integer id : deleteClientes) {
				clienteDAO.deleteCliente(id);
			}

		} else { // it is only one object - cast to object/bean

			Integer id = Integer.parseInt(data.toString());

			clienteDAO.deleteCliente(id);
		}
	}

	/**
	 * Spring use - DI
	 * 
	 * @param clienteDAO
	 */
	@Autowired
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	/**
	 * Spring use - DI
	 * 
	 * @param clienteConverter
	 */
	@Autowired
	public void setClienteConverter(ClienteConverter clienteConverter) {
		this.clienteConverter = clienteConverter;
	}

}
