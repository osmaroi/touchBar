package es.bootools.touchbar.converter;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import es.bootools.touchbar.model.ProductoPedido;

/**
 */
@Component
public class ProductoPedidoConverter {

	/**
	 * Get list of ProductoPedidos from request.
	 * 
	 * @param data
	 *            - json data from request
	 * @return list of ProductoPedidos
	 */
	public List<ProductoPedido> getProductoPedidosFromRequest(Object data) {

		List<ProductoPedido> list;

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			list = getListProductoPedidosFromJSON(data);

		} else { // it is only one object - cast to object/bean

			ProductoPedido cliente = getProductoPedidoFromJSON(data);

			list = new ArrayList<ProductoPedido>();
			list.add(cliente);
		}

		return list;
	}

	/**
	 * Transform json data format into ProductoPedido object
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	private ProductoPedido getProductoPedidoFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		ProductoPedido newProductoPedido = (ProductoPedido) JSONObject.toBean(
				jsonObject, ProductoPedido.class);
		return newProductoPedido;
	}

	/**
	 * Transform json data format into list of ProductoPedido objects
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<ProductoPedido> getListProductoPedidosFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<ProductoPedido> newProductoPedidos = (List<ProductoPedido>) JSONArray
				.toCollection(jsonArray, ProductoPedido.class);
		return newProductoPedidos;
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
		List<Integer> idProductoPedidos = (List<Integer>) JSONArray
				.toCollection(jsonArray, Integer.class);
		return idProductoPedidos;
	}
}
