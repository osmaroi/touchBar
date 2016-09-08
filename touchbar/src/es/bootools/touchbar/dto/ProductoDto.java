package es.bootools.touchbar.dto;

// Generated 30-jul-2012 20:27:59 by Hibernate Tools 4.0.0

import java.util.Date;

import es.bootools.touchbar.model.Producto;

public class ProductoDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3930628140849828576L;
	private Integer idProducto;
	private GrupoProductoDto grupoProducto;
	private DestinoProductoDto destinoProducto;
	private Boolean publicado;
	private String nombre;
	private String descripcion;
	private String precio;
	private String imagen;
	private String usuCrear;
	private Date fechaCrear;
	private String usuModificar;
	private Date fechaModificar;
	private String usuBorrar;
	private Date fechaBorrar;

	public ProductoDto() {
	}

	public ProductoDto(Integer idProducto, GrupoProductoDto grupoProducto,
			DestinoProductoDto destinoProducto) {
		this.idProducto = idProducto;
		this.grupoProducto = grupoProducto;
		this.destinoProducto = destinoProducto;
	}

	public ProductoDto(Integer idProducto, GrupoProductoDto grupoProducto,
			DestinoProductoDto destinoProducto, Boolean publicado,
			String nombre, String descripcion, String precio, String imagen,
			String usuCrear, Date fechaCrear, String usuModificar,
			Date fechaModificar, String usuBorrar, Date fechaBorrar) {
		this.idProducto = idProducto;
		this.grupoProducto = grupoProducto;
		this.destinoProducto = destinoProducto;
		this.publicado = publicado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.usuCrear = usuCrear;
		this.fechaCrear = fechaCrear;
		this.usuModificar = usuModificar;
		this.fechaModificar = fechaModificar;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public GrupoProductoDto getGrupoProducto() {
		return this.grupoProducto;
	}

	public void setGrupoProducto(GrupoProductoDto grupoProducto) {
		this.grupoProducto = grupoProducto;
	}

	public DestinoProductoDto getDestinoProducto() {
		return this.destinoProducto;
	}

	public void setDestinoProducto(DestinoProductoDto destinoProducto) {
		this.destinoProducto = destinoProducto;
	}

	public Boolean getPublicado() {
		return this.publicado;
	}

	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUsuCrear() {
		return this.usuCrear;
	}

	public void setUsuCrear(String usuCrear) {
		this.usuCrear = usuCrear;
	}

	public Date getFechaCrear() {
		return this.fechaCrear;
	}

	public void setFechaCrear(Date fechaCrear) {
		this.fechaCrear = fechaCrear;
	}

	public String getUsuModificar() {
		return this.usuModificar;
	}

	public void setUsuModificar(String usuModificar) {
		this.usuModificar = usuModificar;
	}

	public Date getFechaModificar() {
		return this.fechaModificar;
	}

	public void setFechaModificar(Date fechaModificar) {
		this.fechaModificar = fechaModificar;
	}

	public String getUsuBorrar() {
		return this.usuBorrar;
	}

	public void setUsuBorrar(String usuBorrar) {
		this.usuBorrar = usuBorrar;
	}

	public Date getFechaBorrar() {
		return this.fechaBorrar;
	}

	public void setFechaBorrar(Date fechaBorrar) {
		this.fechaBorrar = fechaBorrar;
	}

	public static ProductoDto buildDto(GrupoProductoDto grupoProducto,
			DestinoProductoDto destinoProducto, Producto producto) {
		return new ProductoDto(producto.getIdProducto(), grupoProducto,
				destinoProducto, producto.getPublicado(), producto.getNombre(),
				producto.getDescripcion(), producto.getPrecio(),
				producto.getImagen(), producto.getUsuCrear(),
				producto.getFechaCrear(), producto.getUsuModificar(),
				producto.getFechaModificar(), producto.getUsuBorrar(),
				producto.getFechaBorrar());

	}

}
