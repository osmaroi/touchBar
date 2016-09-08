package es.bootools.touchbar.converter;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import es.bootools.touchbar.model.GrupoProducto;

/**
 */
@Component
public class GrupoProductoConverter {

	/**
	 * Get list of Impuestos from request.
	 * 
	 * @param data
	 *            - json data from request
	 * @return list of Impuestos
	 */
	public List<GrupoProducto> getGruposProductoFromRequest(Object data) {

		List<GrupoProducto> list;

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			list = getListGruposProductoFromJSON(data);

		} else { // it is only one object - cast to object/bean

			GrupoProducto grupoProducto = getGrupoProductoFromJSON(data);

			list = new ArrayList<GrupoProducto>();
			list.add(grupoProducto);
		}

		return list;
	}

	/**
	 * Transform json data format into GrupoProducto object
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	private GrupoProducto getGrupoProductoFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		GrupoProducto newGrupoProducto = (GrupoProducto) JSONObject.toBean(
				jsonObject, GrupoProducto.class);
		return newGrupoProducto;
	}

	/**
	 * Transform json data format into list of GrupoProducto objects
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<GrupoProducto> getListGruposProductoFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<GrupoProducto> newGrupoProductos = (List<GrupoProducto>) JSONArray
				.toCollection(jsonArray, GrupoProducto.class);
		return newGrupoProductos;
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
		List<Integer> idGrupoProducto = (List<Integer>) JSONArray.toCollection(
				jsonArray, Integer.class);
		return idGrupoProducto;
	}
}
