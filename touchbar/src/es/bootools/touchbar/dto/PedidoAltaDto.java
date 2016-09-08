package es.bootools.touchbar.dto;

import es.bootools.touchbar.model.Pedido;

public class PedidoAltaDto implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1952337608919245947L;
	private String codUnicoMovil;
	private String mesa;
	private String comentario;
	private String productos;

	public PedidoAltaDto() {
	}

	public PedidoAltaDto(String codUnicoMovil) {
		this.codUnicoMovil = codUnicoMovil;
	}

	public PedidoAltaDto(String codUnicoMovil, String mesa,
			String comentario, String productos) {
		super();
		this.codUnicoMovil = codUnicoMovil;
		this.mesa = mesa;
		this.comentario = comentario;
		this.productos = productos;
	}

	public String getCodUnicoMovil() {
		return codUnicoMovil;
	}

	public void setCodUnicoMovil(String codUnicoMovil) {
		this.codUnicoMovil = codUnicoMovil;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	public static Pedido buildPojo(PedidoAltaDto pedido) {
		return new Pedido(null, null, null, pedido.getMesa(), null, pedido.getComentario(), null, null, null, null, null, null);
	}
}
