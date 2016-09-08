package es.bootools.touchbar.converter;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import es.bootools.touchbar.model.Pedido;

/**
 */
@Component
public class PedidoConverter {

	/**
	 * Get list of Impuestos from request.
	 * 
	 * @param data
	 *            - json data from request
	 * @return list of Impuestos
	 */
	public List<Pedido> getPedidosFromRequest(Object data) {

		List<Pedido> list;

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			list = getListPedidoFromJSON(data);

		} else { // it is only one object - cast to object/bean

			Pedido producto = getPedidoFromJSON(data);

			list = new ArrayList<Pedido>();
			list.add(producto);
		}

		return list;
	}

	/**
	 * Transform json data format into Pedido object
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	private Pedido getPedidoFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		Pedido newPedido = (Pedido) JSONObject.toBean(jsonObject, Pedido.class);
		return newPedido;
	}

	/**
	 * Transform json data format into list of Pedido objects
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Pedido> getListPedidoFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Pedido> newPedidos = (List<Pedido>) JSONArray.toCollection(
				jsonArray, Pedido.class);
		return newPedidos;
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
		List<Integer> idPedido = (List<Integer>) JSONArray.toCollection(
				jsonArray, Integer.class);
		return idPedido;
	}
}
