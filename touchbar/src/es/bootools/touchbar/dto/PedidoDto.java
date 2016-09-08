package es.bootools.touchbar.dto;

import java.util.Date;

import es.bootools.touchbar.model.Pedido;

public class PedidoDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 211442859014067576L;
	private int idPedido;
	private ClienteDto cliente;
	private Date fechaPedido;
	private String mesa;
	private Boolean servido;
	private String comentario;
	private String usuCrear;
	private Date fechaCrear;
	private String usuModificar;
	private Date fechaModificar;
	private String usuBorrar;
	private Date fechaBorrar;

	public PedidoDto() {
	}

	public PedidoDto(int idPedido, ClienteDto cliente) {
		this.idPedido = idPedido;
		this.cliente = cliente;
	}

	public PedidoDto(int idPedido, ClienteDto cliente, Date fechaPedido,
			String mesa, Boolean servido, String comentario, String usuCrear,
			Date fechaCrear, String usuModificar, Date fechaModificar,
			String usuBorrar, Date fechaBorrar) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.mesa = mesa;
		this.servido = servido;
		this.comentario = comentario;
		this.usuCrear = usuCrear;
		this.fechaCrear = fechaCrear;
		this.usuModificar = usuModificar;
		this.fechaModificar = fechaModificar;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteDto getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getMesa() {
		return this.mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public Boolean getServido() {
		return this.servido;
	}

	public void setServido(Boolean servido) {
		this.servido = servido;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public static PedidoDto buildDto(ClienteDto cliente, Pedido pedido) {
		return new PedidoDto(pedido.getIdPedido(), cliente,
				pedido.getFechaPedido(), pedido.getMesa(), pedido.getServido(),
				pedido.getComentario(), pedido.getUsuCrear(),
				pedido.getFechaCrear(), pedido.getUsuModificar(),
				pedido.getFechaModificar(), pedido.getUsuBorrar(),
				pedido.getFechaBorrar());

	}
}
