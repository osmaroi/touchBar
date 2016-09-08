package es.bootools.touchbar.dto;

// Generated 30-jul-2012 20:27:59 by Hibernate Tools 4.0.0

import es.bootools.touchbar.model.DestinoProducto;
import es.bootools.touchbar.model.Rol;

/**
 * Rol generated by hbm2java
 */

public class RolAltaDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idRol;
	private Integer idDestinoProducto;
	private String nombre;
	private String descripcion;

	public RolAltaDto() {
	}

	public RolAltaDto(Integer idRol, Integer idDestinoProducto) {
		this.idRol = idRol;
		this.idDestinoProducto = idDestinoProducto;
	}

	public RolAltaDto(Integer idRol, Integer idDestinoProducto, String nombre,
			String descripcion) {
		super();
		this.idRol = idRol;
		this.idDestinoProducto = idDestinoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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

	public static RolAltaDto buildDto(Rol rol) {
		return new RolAltaDto(rol.getIdRol(), rol.getDestinoProducto()
				.getIdDestinoProducto(), rol.getNombre(), rol.getDescripcion());
	}

	public static Rol buildPojo(RolAltaDto rol) {
		return new Rol(rol.getIdRol(), new DestinoProducto(
				rol.getIdDestinoProducto()), rol.getNombre(),
				rol.getDescripcion(), null, null, null, null, null, null);
	}
}