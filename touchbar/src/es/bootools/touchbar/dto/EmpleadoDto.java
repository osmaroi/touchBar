package es.bootools.touchbar.dto;

import java.util.Date;

import es.bootools.touchbar.model.Empleado;

public class EmpleadoDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9208250296577596957L;
	private Integer idEmpleado;
	private RolDto rol;
	private String codEmpleado;
	private String password;
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

	public EmpleadoDto() {
	}

	public EmpleadoDto(Integer idEmpleado, RolDto rol) {
		this.idEmpleado = idEmpleado;
		this.rol = rol;
	}

	public EmpleadoDto(Integer idEmpleado, RolDto rol, String codEmpleado,
			String password, String nombre, String apellido1, String apellido2,
			String telefonoFijo, String telefonoMovil,
			String correoElectronico, String usuCrear, Date fechaCrear,
			String usuModificar, Date fechaModificar, String usuBorrar,
			Date fechaBorrar) {
		this.idEmpleado = idEmpleado;
		this.rol = rol;
		this.codEmpleado = codEmpleado;
		this.password = password;
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

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public RolDto getRol() {
		return this.rol;
	}

	public void setRol(RolDto rol) {
		this.rol = rol;
	}

	public String getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void hidePersonalData() {
		this.password = null;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.telefonoFijo = null;
		this.telefonoMovil = null;
		this.correoElectronico = null;
		this.usuCrear = null;
		this.fechaCrear = null;
		this.usuModificar = null;
		this.fechaModificar = null;
		this.usuBorrar = null;
		this.fechaBorrar = null;
	}

	public static EmpleadoDto buildDto(RolDto rol, Empleado empleado) {
		return new EmpleadoDto(empleado.getIdEmpleado(), rol,
				empleado.getCodEmpleado(), empleado.getPassword(),
				empleado.getNombre(), empleado.getApellido1(),
				empleado.getApellido2(), empleado.getTelefonoFijo(),
				empleado.getTelefonoMovil(), empleado.getCorreoElectronico(),
				empleado.getUsuCrear(), empleado.getFechaCrear(),
				empleado.getUsuModificar(), empleado.getFechaModificar(),
				empleado.getUsuBorrar(), empleado.getFechaBorrar());

	}

}
