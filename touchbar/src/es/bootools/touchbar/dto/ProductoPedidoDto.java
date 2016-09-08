package es.bootools.touchbar.dto;

import java.util.Date;

import javax.persistence.Column;

import es.bootools.touchbar.model.ProductoPedido;

public class ProductoPedidoDto implements java.io.Serializable {

	private static final long serialVersionUID = 1558871668837035529L;
	private Integer idProductoPedido;
	private PedidoDto pedido;
	private ProductoDto producto;
	private String comentario;
	private Boolean servido;
	private String usuCrear;
	private Date fechaCrear;
	private String usuModificar;
	private Date fechaModificar;
	private String usuBorrar;
	private Date fechaBorrar;

	public ProductoPedidoDto() {
	}

	public ProductoPedidoDto(Integer idProductoPedido, PedidoDto pedido,
			ProductoDto producto) {
		this.idProductoPedido = idProductoPedido;
		this.pedido = pedido;
		this.producto = producto;
	}

	public ProductoPedidoDto(Integer idProductoPedido, PedidoDto pedido,
			ProductoDto producto, String comentario, Boolean servido,
			String usuCrear, Date fechaCrear, String usuModificar,
			Date fechaModificar, String usuBorrar, Date fechaBorrar) {
		this.idProductoPedido = idProductoPedido;
		this.pedido = pedido;
		this.producto = producto;
		this.comentario = comentario;
		this.servido = servido;
		this.usuCrear = usuCrear;
		this.fechaCrear = fechaCrear;
		this.usuModificar = usuModificar;
		this.fechaModificar = fechaModificar;
		this.usuBorrar = usuBorrar;
		this.fechaBorrar = fechaBorrar;
	}

	public Integer getIdProductoPedido() {
		return this.idProductoPedido;
	}

	public void setIdProductoPedido(Integer idProductoPedido) {
		this.idProductoPedido = idProductoPedido;
	}

	public PedidoDto getPedido() {
		return this.pedido;
	}

	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}

	public ProductoDto getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getServido() {
		return this.servido;
	}

	public void setServido(Boolean servido) {
		this.servido = servido;
	}

	@Column(name = "usu_crear", length = 45)
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

	public static ProductoPedidoDto buildDto(PedidoDto pedidoDto,
			ProductoDto productoDto, ProductoPedido productoPedido) {
		return new ProductoPedidoDto(productoPedido.getIdProductoPedido(),
				pedidoDto, productoDto, productoPedido.getComentario(),
				productoPedido.getServido(), productoPedido.getUsuCrear(),
				productoPedido.getFechaCrear(),
				productoPedido.getUsuModificar(),
				productoPedido.getFechaModificar(),
				productoPedido.getUsuBorrar(), productoPedido.getFechaBorrar());

	}
}
