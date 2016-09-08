package es.bootools.touchbar.dto;

// Generated 30-jul-2012 20:27:59 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;

import es.bootools.touchbar.model.Cliente;

public class ClienteDto implements java.io.Serializable {

	private Integer idCliente;
	private String codCliente;
	private String password;
	private String codUnicoMovil;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefonoFijo;
	private String telefonoMovil;
	private String correoElectronico;
	private String usuCrear;
	private Date fechaCrear;
	private String usuModificar;
	private Date fechaModificar;
	private String usuBorrar;
	private Date fechaBorrar;

	public ClienteDto() {
	}

	public ClienteDto(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public ClienteDto(Integer idCliente, String codCliente, String password,
			String codUnicoMovil, String nombre, String apellido1,
			String apellido2, String telefonoFijo, String telefonoMovil,
			String correoElectronico, String usuCrear, Date fechaCrear,
			String usuModificar, Date fechaModificar, String usuBorrar,
			Date fechaBorrar) {
		this.idCliente = idCliente;
		this.codCliente = codCliente;
		this.password = password;
		this.codUnicoMovil = codUnicoMovil;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
		this.correoElectronico = correoElectronico;
		this.usuCrear = usuCrear;
		this.fechaCrear = fechaCrear;
		this.usuModificar = usuModificar;
		this.fechaModificar = fechaModificar;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodUnicoMovil() {
		return this.codUnicoMovil;
	}

	public void setCodUnicoMovil(String codUnicoMovil) {
		this.codUnicoMovil = codUnicoMovil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return this.telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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

	@Column(name = "usu_borrar", length = 45)
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

	public static ClienteDto buildDto(Cliente cliente) {
		return new ClienteDto(cliente.getIdCliente(), cliente.getCodCliente(),
				cliente.getPassword(), cliente.getCodUnicoMovil(),
				cliente.getNombre(), cliente.getApellido1(),
				cliente.getApellido2(), cliente.getTelefonoFijo(),
				cliente.getTelefonoMovil(), cliente.getCorreoElectronico(),
				cliente.getUsuCrear(), cliente.getFechaCrear(),
				cliente.getUsuModificar(), cliente.getFechaModificar(),
				cliente.getUsuBorrar(), cliente.getFechaBorrar());
	}

}
