package es.bootools.touchbar.converter;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import es.bootools.touchbar.model.Producto;

/**
 */
@Component
public class ProductoConverter {

	/**
	 * Get list of Impuestos from request.
	 * 
	 * @param data
	 *            - json data from request
	 * @return list of Impuestos
	 */
	public List<Producto> getProductosFromRequest(Object data) {

		List<Producto> list;

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			list = getListProductoFromJSON(data);

		} else { // it is only one object - cast to object/bean

			Producto producto = getProductoFromJSON(data);

			list = new ArrayList<Producto>();
			list.add(producto);
		}

		return list;
	}

	/**
	 * Transform json data format into Producto object
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	private Producto getProductoFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		Producto newProducto = (Producto) JSONObject.toBean(jsonObject,
				Producto.class);
		return newProducto;
	}

	/**
	 * Transform json data format into list of Producto objects
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Producto> getListProductoFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Producto> newProductos = (List<Producto>) JSONArray.toCollection(
				jsonArray, Producto.class);
		return newProductos;
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
		List<Integer> idProducto = (List<Integer>) JSONArray.toCollection(
				jsonArray, Integer.class);
		return idProducto;
	}
}
