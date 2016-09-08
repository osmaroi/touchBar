package es.bootools.touchbar.dto;

import java.util.Date;

import es.bootools.touchbar.model.GrupoProducto;

public class GrupoProductoDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1129699740091007962L;
	private Integer idGrupoProducto;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String usuCrear;
	private Date fechaCrear;
	private String usuModificar;
	private Date fechaModificar;
	private String usuBorrar;
	private Date fechaBorrar;

	public GrupoProductoDto() {
	}

	public GrupoProductoDto(Integer idGrupoProducto) {
		this.idGrupoProducto = idGrupoProducto;
	}

	public GrupoProductoDto(Integer idGrupoProducto, String nombre,
			String descripcion, String imagen, String usuCrear,
			Date fechaCrear, String usuModificar, Date fechaModificar,
			String usuBorrar, Date fechaBorrar) {
		this.idGrupoProducto = idGrupoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.usuCrear = usuCrear;
		this.fechaCrear = fechaCrear;
		this.usuModificar = usuModificar;
		this.fechaModificar = fechaModificar;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public Integer getIdGrupoProducto() {
		return this.idGrupoProducto;
	}

	public void setIdGrupoProducto(Integer idGrupoProducto) {
		this.idGrupoProducto = idGrupoProducto;
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

	public static GrupoProductoDto buildDto(GrupoProducto grupoProducto) {
		return new GrupoProductoDto(grupoProducto.getIdGrupoProducto(),
				grupoProducto.getNombre(), grupoProducto.getDescripcion(),
				grupoProducto.getImagen(), grupoProducto.getUsuCrear(),
				grupoProducto.getFechaCrear(), grupoProducto.getUsuModificar(),
				grupoProducto.getFechaModificar(),
				grupoProducto.getUsuBorrar(), grupoProducto.getFechaBorrar());

	}

}
