package es.bootools.touchbar.dto;

import es.bootools.touchbar.model.Empleado;
import es.bootools.touchbar.model.Rol;

public class EmpleadoAltaDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5673846738853673279L;
	private Integer idEmpleado;
	private Integer idRol;
	private String codEmpleado;
	private String password;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefonoFijo;
	private String telefonoMovil;
	private String correoElectronico;

	public EmpleadoAltaDto() {
	}

	public EmpleadoAltaDto(Integer idEmpleado, Integer idRol) {
		this.idEmpleado = idEmpleado;
		this.idRol = idRol;
	}

	public EmpleadoAltaDto(Integer idEmpleado, Integer idRol,
			String codEmpleado, String password, String nombre,
			String apellido1, String apellido2, String telefonoFijo,
			String telefonoMovil, String correoElectronico) {
		super();
		this.idEmpleado = idEmpleado;
		this.idRol = idRol;
		this.codEmpleado = codEmpleado;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
		this.correoElectronico = correoElectronico;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void hidePersonalData() {
		this.password = null;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.telefonoFijo = null;
		this.telefonoMovil = null;
		this.correoElectronico = null;
	}

	public static EmpleadoAltaDto buildDto(Empleado empleado) {
		return new EmpleadoAltaDto(empleado.getIdEmpleado(), empleado.getRol()
				.getIdRol(), empleado.getCodEmpleado(), empleado.getPassword(),
				empleado.getNombre(), empleado.getApellido1(),
				empleado.getApellido2(), empleado.getTelefonoFijo(),
				empleado.getTelefonoMovil(), empleado.getCorreoElectronico());
	}

	public static Empleado buildPojo(EmpleadoAltaDto empleado) {
		return new Empleado(empleado.getIdEmpleado(), new Rol(
				empleado.getIdRol(), null), empleado.getCodEmpleado(),
				empleado.getPassword(), empleado.getNombre(),
				empleado.getApellido1(), empleado.getApellido2(),
				empleado.getTelefonoFijo(), empleado.getTelefonoMovil(),
				empleado.getCorreoElectronico(), null, null, null, null, null,
				null);
	}

}
