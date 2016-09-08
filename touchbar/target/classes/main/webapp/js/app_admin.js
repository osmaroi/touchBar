//**********************************************************
// Variables ***********************************************
//**********************************************************
var temporizador;
var estadoActual = PEDIDOS_NO_SERVIDOS;
var estadoAnterior = PEDIDOS_NO_SERVIDOS;

// Auxiliares
// var datos;

// url's
var URL = {
	"PEDIDOS_NO_SERVIDOS" : "producto_pedido/get_all_no_servido.action",
	"PEDIDOS_DE_HOY" : "producto_pedido/get_all_de_hoy.action",
	"GRUPO_PRODUCTOS" : "grupo_producto/get_all.action",
	"GRUPO" : "grupo_producto/get.action",
	"PRODUCTOS" : "producto/get_all_order_by_group.action",
	"PRODUCTO" : "producto/get.action",
	"DESTINOS" : "destino_producto/get_all.action",
	"DESTINO" : "destino_producto/get.action",
	"EMPLEADOS" : "empleado/get_all_order_by_rol.action",
	"EMPLEADO" : "empleado/getDto.action",
	"ROLES" : "rol/get_all_order_by_destino.action",
	"ROL" : "rol/get.action"
};

// estados
var PEDIDOS_NO_SERVIDOS = "PEDIDOS_NO_SERVIDOS";
var PEDIDOS_DE_HOY = "PEDIDOS_DE_HOY";
var GRUPO_PRODUCTOS = "GRUPO_PRODUCTOS";
var GRUPO = "GRUPO";
var PRODUCTOS = "PRODUCTOS";
var PRODUCTO = "PRODUCTO";
var DESTINOS = "DESTINOS";
var DESTINO = "DESTINO";
var EMPLEADOS = "EMPLEADOS";
var EMPLEADO = "EMPLEADO";
var ROLES = "ROLES";
var ROL = "ROL";

// **********************************************************
// Funciones ****************************
// **********************************************************

// (function($) {
// setInterval(function() {
// cargarPedidos();
// }, 1000);
// })(jQuery);

// Evento click back
$('#atras').live('click', function() {
	pararTemporizador();
});

// Evento click pedidos de hoy
$('#pedidos_de_hoy')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					estadoActual = PEDIDOS_DE_HOY;
					temporizador = setInterval(function() {
						cargarPedidos(URL[estadoActual]);
					}, 20000);
					cargarPedidos(URL[estadoActual]);
					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");
					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento click pedidos no servidos
$('#pedidos_no_servidos')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					temporizador = setInterval(function() {
						cargarPedidos(URL[estadoActual]);
					}, 20000);
					estadoActual = PEDIDOS_NO_SERVIDOS;
					cargarPedidos(URL[estadoActual]);

					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento click gropo productos
$('#grupo_productos')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					estadoActual = GRUPO_PRODUCTOS;
					cargarGrupos(URL[estadoActual]);
					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento click productos
$('#productos')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					estadoActual = PRODUCTOS;
					cargarProductos(URL[estadoActual]);
					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento click productos
$('#destinos')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					estadoActual = DESTINOS;
					cargarDestinos(URL[estadoActual]);
					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento click empleados
$('#empleados')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					estadoActual = EMPLEADOS;
					cargarEmpleados(URL[estadoActual]);
					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento click roles
$('#roles')
		.live(
				'click',
				function() {
					ocultarMantenimientoProducto();
					ocultarMantenimientoGrupoProducto();
					ocultarMantenimientoDestinoProducto();
					ocultarMantenimientoRol();
					ocultarMantenimientoEmpleado();
					mostrarLista();
					pararTemporizador();
					estadoActual = ROLES;
					cargarRoles(URL[estadoActual]);
					$('#pedidos_no_servidos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#pedidos_de_hoy')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#pedidos').listview("refresh");

					$('#grupo_productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#productos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#destinos')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");

					$('#carta').listview("refresh");

					$('#empleados')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'c').trigger("mouseout");
					$('#roles')
							.removeClass(
									'ui-btn-up-a ui-btn-up-b ui-btn-up-c ui-btn-up-d ui-btn-up-e ui-btn-hover-a ui-btn-hover-b ui-btn-hover-c ui-btn-hover-d ui-btn-hover-e')
							.attr('data-theme', 'e').trigger("mouseout");

					$('#personal').listview("refresh");
				});

// Evento pagina pedido viewer
$("#administrar").live("pageshow", function() {
	estadoActual = PEDIDOS_NO_SERVIDOS;
	temporizador = setInterval(function() {
		cargarPedidos(URL[estadoActual]);
	}, 20000);
	cargarPedidos(URL[estadoActual]);
});

// Evento clic servir pedido
$('.servido_producto_pedido').live('click', function() {
	var idProductoPedido = $(this).data('nid');
	servirProductoPedido(idProductoPedido);
});

// Evento clic servir pedido
$('.eliminar_grupo_producto').live('click', function() {
	var idGrupoProducto = $(this).data('nid');
	eliminarGrupoProducto(idGrupoProducto);
});

//Evento clic servir pedido
$('.eliminar_destino_producto').live('click', function() {
	var idDestinoProducto = $(this).data('nid');
	eliminarDestinoProducto(idDestinoProducto);
});

//Evento clic servir pedido
$('.eliminar_rol').live('click', function() {
	var idRol = $(this).data('nid');
	eliminarRol(idRol);
});

// Evento clic servir pedido
$('.vista_crear_grupo_producto').live('click', function() {
	vistaCrearGrupoProducto($(this));
});

//Evento clic servir pedido
$('.vista_crear_rol').live('click', function() {
	vistaCrearRol($(this));
});

// Evento clic mostrar producto
$('.editar_producto').live('click', function() {
	vistaEditarProducto($(this));
});

//Evento clic mostrar producto
$('.vista_editar_grupo_producto').live('click', function() {
	vistaEditarGrupoProducto($(this));
});

//Evento clic mostrar producto
$('.vista_editar_destino_producto').live('click', function() {
	vistaEditarDestinoProducto($(this));
});

// Evento clic crear producto
$('.vista_crear_producto').live('click', function() {
	vistaCrearProducto($(this));
});

//Evento clic crear destino
$('.vista_crear_destino_producto').live('click', function() {
	vistaCrearDestinoProducto($(this));
});

//Evento clic crear destino
$('.vista_editar_rol').live('click', function() {
	vistaEditarRol($(this));
});

//Evento clic crear destino
$('.vista_crear_empleado').live('click', function() {
	vistaCrearEmpleado($(this));
});

//Evento clic crear destino
$('.vista_editar_empleado').live('click', function() {
	vistaEditarEmpleado($(this));
});

//// Evento clic crear producto
//$('.crear_producto').live('click', function() {
//	vistaCrearProducto($(this));
//});

// Evento clic eliminar producto
$('.eliminar_producto').live('click', function() {
	var idProducto = $(this).data('nid');
	eliminarProducto(idProducto);
});

//Evento clic eliminar producto
$('.eliminar_empleado').live('click', function() {
	var idEmpleado = $(this).data('nid');
	eliminarEmpleado(idEmpleado);
});

// Evento cancelar devuelve a la vista anterior
$("#cancelar_producto").live("click", function() {
	ocultarMantenimientoProducto();
	mostrarLista();
	cargarProductos(URL[estadoActual]);
});

//Evento cancelar devuelve a la vista anterior
$("#cancelar_grupo_producto").live("click", function() {
	ocultarMantenimientoGrupoProducto();
	mostrarLista();
	cargarGrupos(URL[estadoActual]);
});

//Evento cancelar devuelve a la vista anterior
$("#cancelar_destino_producto").live("click", function() {
	ocultarMantenimientoDestinoProducto();
	mostrarLista();
	cargarDestinos(URL[estadoActual]);
});

//Evento cancelar devuelve a la vista anterior
$("#cancelar_rol").live("click", function() {
	ocultarMantenimientoRol();
	mostrarLista();
	cargarRoles(URL[estadoActual]);
});

//Evento cancelar devuelve a la vista anterior
$("#cancelar_empleado").live("click", function() {
	ocultarMantenimientoEmpleado();
	mostrarLista();
	cargarEmpleados(URL[estadoActual]);
});

// Evento clic eliminar producto
$('#aceptar_guardar_producto').live('click', function() {
	var producto = getVarProducto();
	producto.idProducto = $('#id_producto').val();
	producto.imagen = $('#imagen_producto').attr("src");
	producto.idGrupoProducto = $('#select_grupo_producto').val();
	producto.idDestinoProducto = $('#select_destino_producto').val();
	producto.nombre = $('#nombre_producto').val();
	producto.descripcion = $('#descripcion_producto').val();
	producto.precio = $('#precio_producto').val();

	guardarProducto(producto);
});

// Evento clic eliminar producto
$('#aceptar_guardar_grupo_producto').live('click', function() {
	var grupoProducto = getVarGrupoProducto();
	grupoProducto.idGrupoProducto = $('#id_grupo_producto').val();
	grupoProducto.nombre = $('#nombre_grupo_producto').val();
	grupoProducto.descripcion = $('#descripcion_grupo_producto').val();

	guardarGrupoProducto(grupoProducto);
});

//Evento clic eliminar producto
$('#aceptar_guardar_destino_producto').live('click', function() {
	var destinoProducto = getVarDestinoProducto();
	destinoProducto.idDestinoProducto = $('#id_destino_producto').val();
	destinoProducto.nombre = $('#nombre_destino_producto').val();
	destinoProducto.descripcion = $('#descripcion_destino_producto').val();

	guardarDestinoProducto(destinoProducto);
});

//Evento clic eliminar producto
$('#aceptar_guardar_rol').live('click', function() {
	var rol = getVarRol();
	rol.idDestinoProducto = $('#select_destino_producto_rol').val();
	rol.idRol = $('#id_rol').val();
	rol.nombre = $('#nombre_rol').val();
	rol.descripcion = $('#descripcion_rol').val();

	guardarRol(rol);
});

//Evento clic eliminar producto
$('#aceptar_guardar_empleado').live('click', function() {
	var empleado = getVarEmpleado();
	
	empleado.idEmpleado = $('#id_empleado').val();
	empleado.idRol = $('#select_rol_empleado').val();
	empleado.codEmpleado = $('#cod_empleado').val();
	empleado.password = $('#password_empleado').val();
	empleado.nombre = $('#nombre_empleado').val();
	empleado.apellido1 = $('#apellido1_empleado').val();
	empleado.apellido2 = $('#apellido2_empleado').val();
	empleado.telefonoFijo = $('#telefono_fijo_empleado').val();
	empleado.telefonoMovil = $('#telefono_movil_empleado').val();
	empleado.correoElectronico = $('#correo_electronico_empleado').val();
	
	guardarEmpleado(empleado);
});

function eliminarProducto(idProducto) {
	$.ajax({
		type : "POST",
		url : "producto/delete.action",
		dataType : "json",
		data : {
			"idProducto" : idProducto
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoProducto();
				mostrarLista();
				cargarProductos(URL[estadoActual]);
				showPopup(json_results.data);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function eliminarGrupoProducto(idGrupoProducto) {
	$.ajax({
		type : "POST",
		url : "grupo_producto/delete.action",
		dataType : "json",
		data : {
			"idGrupoProducto" : idGrupoProducto
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoGrupoProducto();
				mostrarLista();
				cargarGrupos(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function eliminarDestinoProducto(idDestinoProducto) {
	$.ajax({
		type : "POST",
		url : "destino_producto/delete.action",
		dataType : "json",
		data : {
			"idDestinoProducto" : idDestinoProducto
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoDestinoProducto();
				mostrarLista();
				cargarDestinos(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function eliminarRol(idRol) {
	$.ajax({
		type : "POST",
		url : "rol/delete.action",
		dataType : "json",
		data : {
			"idRol" : idRol
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoRol();
				mostrarLista();
				cargarRoles(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function eliminarEmpleado(idEmpleado) {
	$.ajax({
		type : "POST",
		url : "empleado/delete.action",
		dataType : "json",
		data : {
			"idEmpleado" : idEmpleado
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoEmpleado();
				mostrarLista();
				cargarEmpleados(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function guardarProducto(producto) {
	$.ajax({
		type : "POST",
		url : "producto/create.action",
		dataType : "json",
		data : producto,
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoProducto();
				mostrarLista();
				cargarProductos(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function guardarGrupoProducto(grupoProducto) {
	$.ajax({
		type : "POST",
		url : "grupo_producto/create.action",
		dataType : "json",
		data : grupoProducto,
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoGrupoProducto();
				mostrarLista();
				cargarGrupos(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function guardarDestinoProducto(destinoProducto) {
	$.ajax({
		type : "POST",
		url : "destino_producto/create.action",
		dataType : "json",
		data : destinoProducto,
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoDestinoProducto();
				mostrarLista();
				cargarDestinos(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function guardarRol(rol) {
	$.ajax({
		type : "POST",
		url : "rol/create.action",
		dataType : "json",
		data : rol,
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoRol();
				mostrarLista();
				cargarRoles(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

function guardarEmpleado(empleado) {
	$.ajax({
		type : "POST",
		url : "empleado/create.action",
		dataType : "json",
		data : empleado,
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error.");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				ocultarMantenimientoEmpleado();
				mostrarLista();
				cargarEmpleados(URL[estadoActual]);
				showPopup(json_results.message);
			} else {
				showPopup(json_results.message);
			}
		}

	});
}

// Comunicacion con el servidor servirProductoPedido
function servirProductoPedido(idProductoPedido) {
	$.ajax({
		type : "POST",
		url : "producto_pedido/servir_producto.action",
		dataType : "json",
		data : {
			"idProductoPedido" : idProductoPedido
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				cargarPedidos(URL[estadoActual]);
			} else {
				showPopup(json_results.message);
			}
		}
	});
}

// Comunicacion con el servidor cargarPedido
function cargarPedidos(url) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
			pararTemporizador();
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarPedidos(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Pedidos.");
				}

			} else {
				showPopup(json_results.message);
				pararTemporizador();
			}
		}

	});
}

// Comunicacion con el servidor cargarGrupos
function cargarGrupos(url) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
			pararTemporizador();
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarGrupos(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Grupos.");
				}

			} else {
				showPopup(json_results.message);
				pararTemporizador();
			}
		}

	});
}

// Comunicacion con el servidor eliminar grupo
function eliminarGrupo(idGrupoProducto) {
	$.ajax({
		type : "POST",
		url : "grupo_producto/delete.action",
		dataType : "json",
		cache : false,
		data : {
			"idGrupoProducto" : idGrupoProducto
		},
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
			pararTemporizador();
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarGrupos(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Grupos.");
				}

			} else {
				showPopup(json_results.message);
				pararTemporizador();
			}
		}

	});
}

// Comunicacion con el servidor cargarProductos
function cargarProductos(url) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarProductos(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Productos.");
				}

			} else {
				showPopup(json_results.message);
			}
		}

	});
}

// Comunicacion con el servidor cargarProductos
function cargarEditarProducto(url, idProducto) {
	$
			.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				cache : false,
				data : {
					"idProducto" : idProducto
				},
				beforeSend : $.mobile.showPageLoadingMsg(),
				error : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					showPopup("Server Internal Error:");
				},
				success : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					if (json_results.success) {
						if (json_results.total > 0) {
							$('#id_producto').val(json_results.data.idProducto);
							$('#imagen_producto').attr("src", json_results.data.imagen);
							cargarComboGrupos(
									URL[GRUPO_PRODUCTOS],
									json_results.data.grupoProducto.idGrupoProducto);
							cargarComboDestinos(
									URL[DESTINOS],
									json_results.data.destinoProducto.idDestinoProducto, ($('#select_destino_producto')));
							$('#nombre_producto').val(json_results.data.nombre);
							$('#descripcion_producto').val(
									json_results.data.descripcion);
							$('#precio_producto').val(json_results.data.precio);
						}
					} else {
						showPopup(json_results.message);
					}
				}

			});
}

//Comunicacion con el servidor cargarProductos
function cargarEditarEmpleado(url, idEmpleado) {
	$
			.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				cache : false,
				data : {
					"idEmpleado" : idEmpleado
				},
				beforeSend : $.mobile.showPageLoadingMsg(),
				error : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					showPopup("Server Internal Error:");
				},
				success : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					if (json_results.success) {
						if (json_results.total > 0) {
							$('#id_empleado').val(json_results.data.idEmpleado);
							cargarComboRoles(
									URL[ROLES],
									json_results.data.rol.idRol, ($('#select_rol_empleado')));
							$('#cod_empleado').val(json_results.data.codEmpleado);
							$('#password_empleado').val(json_results.data.password);
							$('#nombre_empleado').val(json_results.data.nombre);
							$('#apellido1_empleado').val(json_results.data.apellido1);
							$('#apellido2_empleado').val(json_results.data.apellido2);
							$('#telefono_fijo_empleado').val(json_results.data.telefonoFijo);
							$('#telefono_movil_empleado').val(json_results.data.telefonoMovil);
							$('#correo_electronico_empleado').val(json_results.data.correoElectronico);

						}
					} else {
						showPopup(json_results.message);
					}
				}

			});
}

//Comunicacion con el servidor cargarProductos
function cargarEditarRol(url, idRol) {
	$
			.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				cache : false,
				data : {
					"idRol" : idRol
				},
				beforeSend : $.mobile.showPageLoadingMsg(),
				error : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					showPopup("Server Internal Error:");
				},
				success : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					if (json_results.success) {
						if (json_results.total > 0) {
							$('#id_rol').val(json_results.data.idRol);
							cargarComboDestinos(
									URL[DESTINOS],
									json_results.data.destinoProducto.idDestinoProducto, ($('#select_destino_producto_rol')));
							$('#nombre_rol').val(json_results.data.nombre);
							$('#descripcion_rol').val(
									json_results.data.descripcion);
							$('#precio_rol').val(json_results.data.precio);
						}
					} else {
						showPopup(json_results.message);
					}
				}

			});
}

//Comunicacion con el servidor cargarProductos
function cargarEditarGrupoProducto(url, idGrupoProducto) {
	$
			.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				cache : false,
				data : {
					"idGrupoProducto" : idGrupoProducto
				},
				beforeSend : $.mobile.showPageLoadingMsg(),
				error : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					showPopup("Server Internal Error:");
				},
				success : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					if (json_results.success) {
						if (json_results.total > 0) {
							$('#id_grupo_producto').val(json_results.data.idGrupoProducto);
							$('#nombre_grupo_producto').val(json_results.data.nombre);
							$('#descripcion_grupo_producto').val(
									json_results.data.descripcion);
						}
					} else {
						showPopup(json_results.message);
					}
				}

			});
}

//Comunicacion con el servidor cargarProductos
function cargarEditarDestinoProducto(url, idDestinoProducto) {
	$
			.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				cache : false,
				data : {
					"idDestinoProducto" : idDestinoProducto
				},
				beforeSend : $.mobile.showPageLoadingMsg(),
				error : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					showPopup("Server Internal Error:");
				},
				success : function(json_results) {
					$.mobile.hidePageLoadingMsg();
					if (json_results.success) {
						if (json_results.total > 0) {
							$('#id_destino_producto').val(json_results.data.idDestinoProducto);
							$('#nombre_destino_producto').val(json_results.data.nombre);
							$('#descripcion_destino_producto').val(
									json_results.data.descripcion);
						}
					} else {
						showPopup(json_results.message);
					}
				}

			});
}

// Comunicacion con el servidor cargarDestinos
function cargarDestinos(url) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarDestinos(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Destinos.");
				}

			} else {
				showPopup(json_results.message);
			}
		}

	});
}

// Comunicacion con el servidor cargarDestinos
function cargarComboDestinos(url, idDestinoProducto, comboDestino) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				cargarComboDestinoProducto(json_results.data, idDestinoProducto, comboDestino);
			} else {
				showPopup(json_results.message);
			}
		},

	});
}

// Comunicacion con el servidor cargarDestinos
function cargarComboGrupos(url, idGrupoProducto) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				cargarComboGrupoProducto(json_results.data, idGrupoProducto);
			} else {
				showPopup(json_results.message);
			}
		},
	});
}

//Comunicacion con el servidor cargarDestinos
function cargarComboRoles(url, idRol, comboRol) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				cargarComboRol(json_results.data, idRol, comboRol);
			} else {
				showPopup(json_results.message);
			}
		},
	});
}

// Comunicacion con el servidor cargarDestinos
function cargarEmpleados(url) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarEmpleados(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Empleados.");
				}

			} else {
				showPopup(json_results.message);
			}
		}

	});
}

// Comunicacion con el servidor cargarDestinos
function cargarRoles(url) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			$.mobile.hidePageLoadingMsg();
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarRoles(json_results.data);
				} else {
					limpiaLista();
					listaNoHayElementos("No hay Roles.");
				}

			} else {
				showPopup(json_results.message);
			}
		}

	});
}

// Procesos
function actualizarPedidos(data) {
	limpiaLista();
	var idPedido = -1;
	$.each(data, function(key) {
		if (data[key].pedido.idPedido != idPedido) {
			var date = new Date(data[key].pedido.fechaPedido);
//			var day = checkTime(date.getDate());
//			var month = checkTime(date.getMonth());
//			var year = checkTime(date.getFullYear());
			var hour = checkTime(date.getHours());
			var minute = checkTime(date.getMinutes());
			var second = checkTime(date.getSeconds());
			idPedido = data[key].pedido.idPedido;
			// Grupo
			$('#lista_derecha').append(
					$('<li/>', {
						'data-role' : "list-divider",
						'text' : " Mesa: " + data[key].pedido.mesa + ".    Pedido realizado a las: " + hour + ":" + minute, 
					}));
		}
		// Producto
		if (data[key].servido == true) {
			$('#lista_derecha').append($('<li/>', {
				'data-theme' : 'c',
			}).append($('<a/>', {
				'href' : '#',
				'data-transition' : 'slide',
				'text' : data[key].producto.nombre,
			// 'data-icon' : 'close',
			})).append($('<a/>', {
				'text' : 'servir',
				'href' : '#',
				'data-theme' : 'a',
				'data-icon' : 'check',
				'class' : 'servido_producto_pedido',
				'data-nid' : data[key].idProductoPedido,

			})));
		} else {
			$('#lista_derecha').append($('<li/>', {
				'data-theme' : 'c',
			}).append($('<a/>', {
				'href' : '#',
				'data-transition' : 'slide',
				'text' : data[key].producto.nombre,
			// 'data-icon' : 'close',
			})).append($('<a/>', {
				'text' : 'servir',
				'href' : '#',
				'data-theme' : 'c',
				'data-icon' : 'check',
				'class' : 'servido_producto_pedido',
				'data-nid' : data[key].idProductoPedido,

			})));
		}
	});
	$('#lista_derecha').listview("refresh");
};

// Procesos
function actualizarGrupos(data) {
	limpiaLista();
	// Titulo
	$('#lista_derecha').append($('<li/>', {
		'data-theme' : 'e',
	}).append($('<a/>', {
		'href' : '#',
		'text' : 'Grupos de Productos',
	// 'data-icon' : 'close',
	})).append($('<a/>', {
		'text' : 'Añadir grupo',
		'href' : '#',
		'data-theme' : 'c',
		'data-icon' : 'plus',
		'class' : 'vista_crear_grupo_producto',
	})));
	$.each(data, function(key) {
		// Grupo
		$('#lista_derecha').append($('<li/>', {
			'data-theme' : 'c',
		}).append($('<a/>', {
			'href' : '#',
			'data-transition' : 'slide',
			'text' : data[key].nombre,
			'class' : 'vista_editar_grupo_producto',
			'data-nid' : data[key].idGrupoProducto,
		})).append($('<a/>', {
			'text' : 'Eliminar grupo',
			'href' : '#',
			'data-theme' : 'c',
			'data-icon' : 'minus',
			'class' : 'eliminar_grupo_producto',
			'data-nid' : data[key].idGrupoProducto,

		})));
	});
	$('#lista_derecha').listview("refresh");
};

// Procesos
function actualizarProductos(data) {
	limpiaLista();
	var idGrupo = -1;
	$.each(data, function(key) {
		if (data[key].grupoProducto.idGrupoProducto != idGrupo) {
			idGrupo = data[key].grupoProducto.idGrupoProducto;
			// Grupo
			$('#lista_derecha').append($('<li/>', {
				'data-theme' : 'e',
			// 'data-role' : 'fieldcontain',
			}).append($('<a/>', {
				'href' : '#',
				'data-transition' : 'slide',
				'text' : data[key].grupoProducto.nombre,
			})).append($('<a/>', {
				'text' : 'Añadir Producto',
				'href' : '#',
				'data-theme' : 'c',
				'data-icon' : 'plus',
				'class' : 'vista_crear_producto',
				'data-nid' : data[key].grupoProducto.idGrupoProducto,
			})));
		}
		// Producto
		$('#lista_derecha').append($('<li/>', {
			'data-theme' : 'c',
		}).append($('<a/>', {
			'href' : '#',
			'data-transition' : 'slide',
			'text' : data[key].nombre,
			'class' : 'editar_producto',
			'data-nid' : data[key].idProducto,
		})).append($('<a/>', {
			'text' : 'Eliminar Producto',
			'href' : '#',
			'data-theme' : 'c',
			'data-icon' : 'minus',
			'class' : 'eliminar_producto',
			'data-nid' : data[key].idProducto,

		})));
	});
	$('#lista_derecha').listview("refresh");
};

// Procesos
function actualizarDestinos(data) {
	limpiaLista();
	// Cabecera
	$('#lista_derecha').append($('<li/>', {
		'data-theme' : 'e',
	}).append($('<a/>', {
		'href' : '#',
		'data-transition' : 'slide',
		'text' : 'Destinos de producto',
	})).append($('<a/>', {
		'text' : 'Añadir Destino',
		'href' : '#',
		'data-theme' : 'c',
		'data-icon' : 'plus',
		'class' : 'vista_crear_destino_producto',
	})));
	$.each(data, function(key) {

		// DestinoProducto
		$('#lista_derecha').append($('<li/>', {
			'data-theme' : 'c',
		}).append($('<a/>', {
			'href' : '#',
			'data-transition' : 'slide',
			'text' : data[key].nombre,
			'class' : 'vista_editar_destino_producto',
			'data-nid' : data[key].idDestinoProducto,
		})).append($('<a/>', {
			'text' : 'Eliminar Destino',
			'href' : '#',
			'data-theme' : 'c',
			'data-icon' : 'minus',
			'class' : 'eliminar_destino_producto',
			'data-nid' : data[key].idDestinoProducto,

		})));
	});
	$('#lista_derecha').listview("refresh");
};

//Procesos
function actualizarRoles(data) {
	limpiaLista();
	var idDestinoProducto = -1;
	$.each(data, function(key) {
		if (data[key].destinoProducto.idDestinoProducto != idDestinoProducto) {
			idDestinoProducto = data[key].destinoProducto.idDestinoProducto;
			// Grupo
			$('#lista_derecha').append($('<li/>', {
				'data-theme' : 'e',
			}).append($('<a/>', {
				'href' : '#',
				'data-transition' : 'slide',
				'text' : data[key].destinoProducto.nombre,
			})).append($('<a/>', {
				'text' : 'Añadir Rol',
				'href' : '#',
				'data-theme' : 'c',
				'data-icon' : 'plus',
				'class' : 'vista_crear_rol',
				'data-nid' : data[key].destinoProducto.idDestinoProducto,
			})));
		}
		// Producto
		$('#lista_derecha').append($('<li/>', {
			'data-theme' : 'c',
		}).append($('<a/>', {
			'href' : '#',
			'data-transition' : 'slide',
			'text' : data[key].nombre,
			'class' : 'vista_editar_rol',
			'data-nid' : data[key].idRol,
		})).append($('<a/>', {
			'text' : 'Eliminar Rol',
			'href' : '#',
			'data-theme' : 'c',
			'data-icon' : 'minus',
			'class' : 'eliminar_rol',
			'data-nid' : data[key].idRol,

		})));
	});
	$('#lista_derecha').listview("refresh");
};

// Procesos
function actualizarEmpleados(data) {
	limpiaLista();
	var idRol = -1;
	$.each(data, function(key) {
		if (data[key].rol.idRol != idRol) {
			idRol = data[key].rol.idRol;
			// Grupo
			$('#lista_derecha').append($('<li/>', {
				'data-theme' : 'e',
			}).append($('<a/>', {
				'href' : '#',
				'data-transition' : 'slide',
				'text' : data[key].rol.nombre,
			})).append($('<a/>', {
				'text' : 'Añadir Empleado',
				'href' : '#',
				'data-theme' : 'c',
				'data-icon' : 'plus',
				'class' : 'vista_crear_empleado',
				'data-nid' : data[key].rol.idRol,
			})));
		}
		// Producto
		$('#lista_derecha').append($('<li/>', {
			'data-theme' : 'c',
		}).append($('<a/>', {
			'href' : '#',
			'data-transition' : 'slide',
			'text' : data[key].nombre,
			'class' : 'vista_editar_empleado',
			'data-nid' : data[key].idEmpleado,
		})).append($('<a/>', {
			'text' : 'Eliminar Empleado',
			'href' : '#',
			'data-theme' : 'c',
			'data-icon' : 'minus',
			'class' : 'eliminar_empleado',
			'data-nid' : data[key].idEmpleado,

		})));
	});
	$('#lista_derecha').listview("refresh");
};

function limpiaLista() {
	$('#lista_derecha').children().remove();
};

function mostrarLista() {
	$('#lista_derecha').show();
};

function ocultarMantenimientoProducto() {
	limpiarVistaMantenimientoProducto();
	$('#mantenimiento_producto').hide();
};

function ocultarMantenimientoGrupoProducto() {
	limpiarVistaMantenimientoGrupoProducto();
	$('#mantenimiento_grupo_producto').hide();
};

function ocultarMantenimientoDestinoProducto() {
	limpiarVistaMantenimientoDestinoProducto();
	$('#mantenimiento_destino_producto').hide();
};

function ocultarMantenimientoRol() {
	limpiarVistaMantenimientoRol();
	$('#mantenimiento_rol').hide();
};

function ocultarMantenimientoEmpleado() {
	limpiarVistaMantenimientoEmpleado();
	$('#mantenimiento_empleado').hide();
};


function listaNoHayElementos(str) {
	$('#lista_derecha').append($('<li/>', {
		'data-role' : "list-divider",
		'text' : str,
		'data-theme' : 'a',
	}));
	$('#lista_derecha').listview("refresh");
}

// Procesos
function vistaCrearProducto(datos) {
	var idGrupoProducto = datos.data('nid');
	$(datos).parent().parent().hide();
	$('#mantenimiento_producto').show();
//	deshabilitarComboGrupo();
	cargarComboGrupos(URL[GRUPO_PRODUCTOS], idGrupoProducto);
	cargarComboDestinos(URL[DESTINOS], undefined, ($('#select_destino_producto')));
};

//Procesos
function vistaCrearDestinoProducto(datos) {
	$(datos).parent().parent().hide();
	$('#mantenimiento_destino_producto').show();
};

// Procesos
function vistaCrearGrupoProducto(datos) {
	$(datos).parent().parent().hide();
	$('#mantenimiento_grupo_producto').show();
};

//Procesos
function vistaCrearRol(datos) {
	$(datos).parent().parent().hide();
	$('#mantenimiento_rol').show();
	cargarComboDestinos(URL[DESTINOS], undefined ,($('#select_destino_producto_rol')));
};

//Procesos
function vistaCrearEmpleado(datos) {
	$(datos).parent().parent().hide();
	$('#mantenimiento_empleado').show();
	cargarComboRoles(URL[ROLES], undefined ,($('#select_rol_empleado')));
};

//Procesos
function vistaEditarRol(datos) {
	var idRol = datos.data('nid');
	$(datos).parent().parent().parent().parent().hide();
	$('#mantenimiento_rol').show();
//	habilitarComboGrupo();
	cargarEditarRol(URL[ROL], idRol);
};

//Procesos
function vistaEditarEmpleado(datos) {
	var idEmpleado = datos.data('nid');
	$(datos).parent().parent().parent().parent().hide();
	$('#mantenimiento_empleado').show();
	cargarEditarEmpleado(URL[EMPLEADO], idEmpleado);
};

// Procesos
function vistaEditarProducto(datos) {
	var idProducto = datos.data('nid');
	$(datos).parent().parent().parent().parent().hide();
	$('#mantenimiento_producto').show();
//	habilitarComboGrupo();
	cargarEditarProducto(URL[PRODUCTO], idProducto);
};

//Procesos
function vistaEditarGrupoProducto(datos) {
	var idGrupoProducto = datos.data('nid');
	$(datos).parent().parent().parent().parent().hide();
	$('#mantenimiento_grupo_producto').show();
//	habilitarComboGrupo();
	cargarEditarGrupoProducto(URL[GRUPO], idGrupoProducto);
};

//Procesos
function vistaEditarDestinoProducto(datos) {
	var idDestinoProducto = datos.data('nid');
	$(datos).parent().parent().parent().parent().hide();
	$('#mantenimiento_destino_producto').show();
	cargarEditarDestinoProducto(URL[DESTINO], idDestinoProducto);
};

function cargarComboGrupoProducto(datos, idGrupoProducto) {
	var seleccion = 0;
	$('#select_grupo_producto').children().remove();
	$.each(datos, function(key) {
		$('#select_grupo_producto').append(
				'<option value="' + datos[key].idGrupoProducto + '">'
						+ datos[key].nombre + '</option>');
		if (datos[key].idGrupoProducto == idGrupoProducto) {
			seleccion = key;
		}
	});
	$("#select_grupo_producto")[0].selectedIndex = seleccion;
	$('#select_grupo_producto').selectmenu('refresh');
}

function cargarComboDestinoProducto(datos, idDestinoProducto, comboDestino) {
	
	var seleccion = 0;
	comboDestino.children().remove();
	$.each(datos, function(key) {
		comboDestino.append(
				'<option value="' + datos[key].idDestinoProducto + '">'
						+ datos[key].nombre + '</option>');
		if (datos[key].idDestinoProducto == idDestinoProducto) {
			seleccion = key;
		}
	});
	comboDestino[0].selectedIndex = seleccion;
	comboDestino.selectmenu('refresh');
}

function cargarComboRol(datos, idRol) {
	var seleccion = 0;
	$('#select_rol_empleado').children().remove();
	$.each(datos, function(key) {
		$('#select_rol_empleado').append(
				'<option value="' + datos[key].idRol + '">'
						+ datos[key].nombre + '</option>');
		if (datos[key].idRol == idRol) {
			seleccion = key;
		}
	});
	$('#select_rol_empleado')[0].selectedIndex = seleccion;
	$('#select_rol_empleado').selectmenu('refresh');
}

function pararTemporizador() {
	clearInterval(temporizador);
}

function limpiarVistaMantenimientoProducto(){
	$('#id_producto').val("");
	$('#select_grupo_producto').children().remove();
	$('#select_grupo_producto').selectmenu('refresh');
	$('#select_destino_producto').children().remove();
	$('#select_destino_producto').selectmenu('refresh');
	$('#imagen_producto').attr("src", "images_app/productos/imagen_default.jpg");
	$('#nombre_producto').val("");
	$('#descripcion_producto').val("");
	$('#precio_producto').val("");
}

function limpiarVistaMantenimientoGrupoProducto(){
	$('#id_grupo_producto').val("");
	$('#nombre_grupo_producto').val("");
	$('#descripcion_grupo_producto').val("");
}

function limpiarVistaMantenimientoDestinoProducto(){
	$('#id_destino_producto').val("");
	$('#nombre_destino_producto').val("");
	$('#descripcion_destino_producto').val("");
}

function limpiarVistaMantenimientoRol(){
	$('#id_rol').val("");
	$('#nombre_rol').val("");
	$('#descripcion_rol').val("");
}

function limpiarVistaMantenimientoEmpleado(){
	$('#id_empleado').val("");
	$('#select_rol_empleado').children().remove();
	$('#select_rol_empleado').selectmenu('refresh');
	$('#cod_empleado').val("");
	$('#password_empleado').val("");
	$('#nombre_empleado').val("");
	$('#apellido1_empleado').val("");
	$('#apellido2_empleado').val("");
	$('#telefono_fijo_empleado').val("");
	$('#telefono_movil_empleado').val("");
	$('#correo_electronico_empleado').val("");
}

function checkTime(n) {
	if (n < 10) {
		n = "0" + n;
	}
	return n;
}

function getVarProducto() {
	var producto = {
		"idProducto" : null,
		"idGrupoProducto" : null,
		"idDestinoProducto" : null,
		"nombre" : null,
		"descripcion" : null,
		"precio" : null,
		"imagen" : null,
	};
	return producto;
}

function getVarGrupoProducto() {
	var grupoProducto = {
			"idGrupoProducto":null,
			"nombre": null,
			"descripcion": null,
	};
	return grupoProducto;
}

function getVarDestinoProducto() {
	var destinoProducto = {
			"idDestinoProducto":null,
			"nombre": null,
			"descripcion": null,
	};
	return destinoProducto;
}

function getVarRol() {
	var rol = {
			"idRol": null,
			"idDestinoProducto" : null, 
			"nombre" : null,
			"descripcion" : null,
	};
	return rol;
}

function getVarEmpleado() {
	var empleado = {
			"idEmpleado": null,
			"idRol": null,
			"codEmpleado" : null, 
			"password" : null,
			"nombre" : null,
			"apellido1" : null,
			"apellido2" : null,
			"telefonoFijo" : null,
			"telefonoMovil" : null,
			"correoElectronico" : null,
	};
	return empleado;
}

function getVarProductoCopia() {
	var producto = {
		"idProducto" : null,
		"grupoProducto" : {
			"idGrupoProducto" : null,
			"nombre" : null,
			"descripcion" : null,
			"imagen" : null,
			"usuCrear" : null,
			"fechaCrear" : null,
			"usuModificar" : null,
			"fechaModificar" : null,
			"usuBorrar" : null,
			"fechaBorrar" : null
		},
		"destinoProducto" : {
			"idDestinoProducto" : null,
			"nombre" : null,
			"descripcion" : null,
			"impresora" : null,
			"usuCrear" : null,
			"fechaModificar" : null,
			"usuModificar" : null,
			"fechaCrear" : null,
			"usuBorrar" : null,
			"fechaBorrar" : null
		},
		"publicado" : true,
		"nombre" : null,
		"descripcion" : null,
		"precio" : null,
		"imagen" : null,
		"usuCrear" : null,
		"fechaCrear" : null,
		"usuModificar" : null,
		"fechaModificar" : null,
		"usuBorrar" : null,
		"fechaBorrar" : null
	};
	return producto;
}