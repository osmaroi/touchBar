package es.bootools.touchbar.converter;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import es.bootools.touchbar.model.Cliente;

/**
 */
@Component
public class ClienteConverter {

	/**
	 * Get list of Clientes from request.
	 * 
	 * @param data
	 *            - json data from request
	 * @return list of Clientes
	 */
	public List<Cliente> getClientesFromRequest(Object data) {

		List<Cliente> list;

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			list = getListClientesFromJSON(data);

		} else { // it is only one object - cast to object/bean

			Cliente cliente = getClienteFromJSON(data);

			list = new ArrayList<Cliente>();
			list.add(cliente);
		}

		return list;
	}

	/**
	 * Transform json data format into Cliente object
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	private Cliente getClienteFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		Cliente newCliente = (Cliente) JSONObject.toBean(jsonObject,
				Cliente.class);
		return newCliente;
	}

	/**
	 * Transform json data format into list of Cliente objects
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Cliente> getListClientesFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Cliente> newClientes = (List<Cliente>) JSONArray.toCollection(
				jsonArray, Cliente.class);
		return newClientes;
	}

	/**
	 * Tranform array of numbers in json data format into list of Integer
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idClientes = (List<Integer>) JSONArray.toCollection(
				jsonArray, Integer.class);
		return idClientes;
	}
}
