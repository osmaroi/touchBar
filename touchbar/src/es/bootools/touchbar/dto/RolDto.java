package es.bootools.touchbar.dto;

// Generated 30-jul-2012 20:27:59 by Hibernate Tools 4.0.0

import java.util.Date;

import es.bootools.touchbar.model.Rol;

/**
 * Rol generated by hbm2java
 */

public class RolDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5992463067457856123L;
	private Integer idRol;
	private DestinoProductoDto destinoProducto;
	private String nombre;
	private String descripcion;
	private String usuCrear;
	private Date fechaCrear;
	private String usuModificar;
	private Date fechaModificar;
	private String usuBorrar;
	private Date fechaBorrar;

	public RolDto() {
	}

	public RolDto(Integer idRol, DestinoProductoDto destinoProducto) {
		this.idRol = idRol;
		this.destinoProducto = destinoProducto;
	}

	public RolDto(Integer idRol, DestinoProductoDto destinoProducto,
			String nombre, String descripcion, String usuCrear,
			Date fechaCrear, String usuModificar, Date fechaModificar,
			String usuBorrar, Date fechaBorrar) {
		this.idRol = idRol;
		this.destinoProducto = destinoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuCrear = usuCrear;
		this.fechaCrear = fechaCrear;
		this.usuModificar = usuModificar;
		this.fechaModificar = fechaModificar;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public DestinoProductoDto getDestinoProducto() {
		return this.destinoProducto;
	}

	public void setDestinoProducto(DestinoProductoDto destinoProducto) {
		this.destinoProducto = destinoProducto;
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

	public static RolDto buildDto(DestinoProductoDto destinoProductoDto, Rol rol) {
		return new RolDto(rol.getIdRol(), destinoProductoDto, rol.getNombre(),
				rol.getDescripcion(), rol.getUsuCrear(), rol.getFechaCrear(),
				rol.getUsuModificar(), rol.getFechaModificar(),
				rol.getUsuBorrar(), rol.getFechaBorrar());

	}

}