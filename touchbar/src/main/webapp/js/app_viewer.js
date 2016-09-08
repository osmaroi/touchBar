//**********************************************************
// Variables ***********************************************
//**********************************************************
var temporizadorViewer;

// **********************************************************
// Funciones ****************************
// **********************************************************

// (function($) {
// setInterval(function() {
// cargarPedidosViewer();
// }, 1000);
// })(jQuery);

// Evento click back
$('#atras').live('click', function() {
	pararTemporizadorViewer();
});

// Evento pagina pedido viewer
$("#page_pedido_viewer").live("pageshow", function() {
	temporizadorViewer = setInterval(function() {
		cargarPedidosViewer();
	}, 10000);
	cargarPedidosViewer();
});

// Evento clic servir pedido
$('.servido_producto_pedido_viewer').live('click', function() {
	var idProductoPedido = $(this).data('nid');
	servirProductoPedidoViewer(idProductoPedido);
});

// Comunicacion con el servidor servirProductoPedidoViewer
function servirProductoPedidoViewer(idProductoPedido) {
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
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			if (json_results.success) {
				cargarPedidosViewer();
			} else {
				showPopup(json_results.message);
			}
		},
	});
	$.mobile.hidePageLoadingMsg();
}

// Comunicacion con el servidor cargarPedido
function cargarPedidosViewer() {
	$.ajax({
		type : "POST",
		url : "producto_pedido/get_all_by_destino_producto_no_servido.action",
		dataType : "json",
		data : {
			idEmpleado : globUsuario.idEmpleado
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			showPopup("Server Internal Error:");
			pararTemporizadorViewer();
		},
		success : function(json_results) {
			if (json_results.success) {
				if (json_results.data.length > 0) {
					actualizarPedidosViewer(json_results.data);
				} else {
					limpiaPedidoViewer();
					listaNoPedidosViewer();
					// showPopup("! No hay productos !");
				}

			} else {
				showPopup(json_results.message);
				pararTemporizadorViewer();
			}
		}

	});
	$.mobile.hidePageLoadingMsg();
}

// Procesos
function actualizarPedidosViewer(data) {
	limpiaPedidoViewer();
	var idPedido = -1;
	$.each(data, function(key) {
		if (data[key].pedido.idPedido != idPedido) {
			var date = new Date(data[key].pedido.fechaPedido);
			var day = checkTime(date.getDate());
			var month = checkTime(date.getMonth());
			var year = checkTime(date.getFullYear());
			var hour = checkTime(date.getHours());
			var minute = checkTime(date.getMinutes());
			var second = checkTime(date.getSeconds());
			idPedido = data[key].pedido.idPedido;
			// Grupo
			$('#lista_pedido_viewer').append(
					$('<li/>', {
						'data-role' : "list-divider",
						'text' : day + " - " + month + " - " + year + " / "
								+ hour + " : " + minute + " : " + second,
						'data-theme' : 'a',
					}));
		}
		// Producto
		$('#lista_pedido_viewer').append($('<li/>', {
			'data-theme' : 'c',
		}).append($('<a/>', {
			'href' : '#producto',
			'data-transition' : 'slide',
			'text' : data[key].producto.nombre,
		// 'data-icon' : 'close',
		})).append($('<a/>', {
			'text' : 'servir',
			'href' : '#',
			'data-theme' : 'c',
			'data-icon' : 'check',
			'class' : 'servido_producto_pedido_viewer',
			'data-nid' : data[key].idProductoPedido,

		})));
	});
	$('#lista_pedido_viewer').listview("refresh");
};

function limpiaPedidoViewer() {
	$('#lista_pedido_viewer').children().remove();
};

function listaNoPedidosViewer() {
	$('#lista_pedido_viewer').append($('<li/>', {
		'data-role' : "list-divider",
		'text' : "No hay pedidos.",
		'data-theme' : 'a',
	}));
	$('#lista_pedido_viewer').listview("refresh");
}

function pararTemporizadorViewer() {
	clearInterval(temporizadorViewer);
}

