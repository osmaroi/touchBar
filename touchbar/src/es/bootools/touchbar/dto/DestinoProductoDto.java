package es.bootools.touchbar.dto;

import java.util.Date;

import es.bootools.touchbar.model.DestinoProducto;

public class DestinoProductoDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019217767254023612L;
	private Integer idDestinoProducto;
	private String nombre;
	private String descripcion;
	private String impresora;
	private String usuCrear;
	private Date fechaModificar;
	private String usuModificar;
	private Date fechaCrear;
	private String usuBorrar;
	private Date fechaBorrar;

	public DestinoProductoDto() {
	}

	public DestinoProductoDto(Integer idDestinoProducto) {
		this.idDestinoProducto = idDestinoProducto;
	}

	public DestinoProductoDto(Integer idDestinoProducto, String nombre,
			String descripcion, String impresora, String usuCrear,
			Date fechaModificar, String usuModificar, Date fechaCrear,
			String usuBorrar, Date fechaBorrar) {
		this.idDestinoProducto = idDestinoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.impresora = impresora;
		this.usuCrear = usuCrear;
		this.fechaModificar = fechaModificar;
		this.usuModificar = usuModificar;
		this.fechaCrear = fechaCrear;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public Integer getIdDestinoProducto() {
		return this.idDestinoProducto;
	}

	public void setIdDestinoProducto(Integer idDestinoProducto) {
		this.idDestinoProducto = idDestinoProducto;
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

	public String getImpresora() {
		return this.impresora;
	}

	public void setImpresora(String impresora) {
		this.impresora = impresora;
	}

	public String getUsuCrear() {
		return this.usuCrear;
	}

	public void setUsuCrear(String usuCrear) {
		this.usuCrear = usuCrear;
	}

	public Date getFechaModificar() {
		return this.fechaModificar;
	}

	public void setFechaModificar(Date fechaModificar) {
		this.fechaModificar = fechaModificar;
	}

	public String getUsuModificar() {
		return this.usuModificar;
	}

	public void setUsuModificar(String usuModificar) {
		this.usuModificar = usuModificar;
	}

	public Date getFechaCrear() {
		return this.fechaCrear;
	}

	public void setFechaCrear(Date fechaCrear) {
		this.fechaCrear = fechaCrear;
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

	public static DestinoProductoDto buildDto(DestinoProducto destinoProducto) {
		return new DestinoProductoDto(destinoProducto.getIdDestinoProducto(),
				destinoProducto.getNombre(), destinoProducto.getDescripcion(),
				destinoProducto.getImpresora(), destinoProducto.getUsuCrear(),
				destinoProducto.getFechaModificar(),
				destinoProducto.getUsuModificar(),
				destinoProducto.getFechaCrear(),
				destinoProducto.getUsuBorrar(),
				destinoProducto.getFechaBorrar());
	}

}
