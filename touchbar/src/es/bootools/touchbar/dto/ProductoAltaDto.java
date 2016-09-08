package es.bootools.touchbar.dto;

// Generated 30-jul-2012 20:27:59 by Hibernate Tools 4.0.0

import es.bootools.touchbar.model.DestinoProducto;
import es.bootools.touchbar.model.GrupoProducto;
import es.bootools.touchbar.model.Producto;

public class ProductoAltaDto implements java.io.Serializable {

	/**
	 * 
	 */
	private Integer idProducto;
	private Integer idGrupoProducto;
	private Integer idDestinoProducto;
	private String nombre;
	private String descripcion;
	private String precio;
	private String imagen;

	public ProductoAltaDto() {
	}

	public ProductoAltaDto(Integer idProducto, Integer idGrupoProducto,
			Integer idDestinoProducto) {
		this.idProducto = idProducto;
		this.idGrupoProducto = idGrupoProducto;
		this.idDestinoProducto = idDestinoProducto;
	}

	public ProductoAltaDto(Integer idProducto, Integer idGrupoProducto,
			Integer idDestinoProducto, String nombre, String descripcion,
			String precio, String imagen) {
		super();
		this.idProducto = idProducto;
		this.idGrupoProducto = idGrupoProducto;
		this.idDestinoProducto = idDestinoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdGrupoProducto() {
		return idGrupoProducto;
	}

	public void setIdGrupoProducto(Integer idGrupoProducto) {
		this.idGrupoProducto = idGrupoProducto;
	}

	public Integer getIdDestinoProducto() {
		return idDestinoProducto;
	}

	public void setIdDestinoProducto(Integer idDestinoProducto) {
		this.idDestinoProducto = idDestinoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public static ProductoAltaDto buildDto(Producto producto) {
		return new ProductoAltaDto(producto.getIdProducto(), producto
				.getGrupoProducto().getIdGrupoProducto(), producto
				.getDestinoProducto().getIdDestinoProducto(),
				producto.getNombre(), producto.getDescripcion(),
				producto.getPrecio(), producto.getImagen());

	}

	public static Producto buildPojo(ProductoAltaDto producto) {
		return new Producto(producto.getIdProducto(), new GrupoProducto(
				producto.getIdGrupoProducto()), new DestinoProducto(
				producto.getIdDestinoProducto()), true, producto.getNombre(),
				producto.getDescripcion(), producto.getPrecio(),
				producto.getImagen(), null, null, null, null, null, null);
	}

}
