//**********************************************************
// Variables ***********************************************
//**********************************************************
var mesa;
var codUnicoMovil;
var posicion;
var codigoDispositivo;
var cntPedido = 0;
var pedido = new Array(); // {idGrupo: id, nombreGrupo:regrescos,data
// {idProducto: 1,
// nombre:
// nombregrupo}
var productosAux = new Array(); // mantiene los productos de la vista
var producto = {
	id : -1,
	posicion : "ninguna"
}; // id = id del producto,
// posicion = posicion que ocupa
// el producto dentro de
// productoAux
var grupo = {
	id : -1,
	nombre : "vacio"
}; // Gruardamos {id: idGrupo, nombre:
// nombregrupo}

(function($) {
	query = window.location.search.replace("?","").split("&");
	mesa = query[0].replace("mesa=","");
	codUnicoMovil = query[1].replace("codUnicoMovil=","");
})(jQuery);

// **********************************************************
// Comunicacion con el servidor ****************************
// **********************************************************

// Accion carga los productos
$("#page_carta_productos").live("pageshow", function() {
	// limpiamos producto
	limpiaProductos();
	limpiaProducto();
	$.ajax({
		type : "POST",
		url : "producto/get_all_by_grupo.action",
		dataType : "json",
		data : {
			idGrupo : grupo.id
		},
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			showPopup("Server Internal Error:");
			$.mobile.hidePageLoadingMsg();
		},
		success : function(json_results) {
			if (json_results.success) {
				if (json_results.data.length > 0) {
					loadProductos(json_results);
				} else {
					showPopup("! No hay productos !");
				}

			} else {
				showPopup(json_results.message);
			}
			$.mobile.hidePageLoadingMsg();
		}

	});
});

// funcion carga los productos
function loadProductos(json_results) {
	// se guardan los productos por si se compra alguno
	productosAux = json_results.data;
	$
			.each(
					json_results.data,
					function(key) {
						html = ' '
								+ '<li data-corners="false" data-shadow="false" data-iconshadow="true" data-wrapperels="div" data-icon="false" data-iconpos="right" data-theme="c" class="ui-btn ui-btn-icon-right ui-li ui-li-has-alt ui-li-has-thumb ui-btn-up-c">'
								+ '<div class="ui-btn-inner ui-li ui-li-has-alt">'
								+ '<div class="ui-btn-text">'
								+ '<a href="#page_producto" data-nid = "'
								+ [ json_results.data[key].idProducto ]
								+ ','
								+ key
								+ '" class="ui-link-inherit item_producto" data-transition="slide" >'
								+ '<img src="'
								+ [ json_results.data[key].imagen ]
								+ '" class="ui-li-thumb ui-corner-all">'
								+ '<h3 class="ui-li-heading">'
								+ [ json_results.data[key].nombre ]
								+ '</h3>'
								+ '<p class="ui-li-desc">'
								+ [ json_results.data[key].descripcion ]
								+ '</p>'
								+ '</a>'
								+ '</div></div><a href="#" data-nid = "'
								+ [ json_results.data[key].idProducto ]
								+ ','
								+ key
								+ '" data-rel="popup" data-position-to="window" data-transition="pop" title="Añadir al pedido" class="ui-li-link-alt ui-btn ui-btn-icon-notext ui-btn-up-c anadir_a_pedido" data-corners="false" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="false" data-iconpos="notext" data-theme="c" aria-haspopup="true" aria-owns="#">'
								+ '<span class="ui-btn-inner">'
								+ '<span class="ui-btn-text">'
								+ '</span>'
								+ '<span data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-icon="gear" data-iconpos="notext" data-theme="d" title="Añadir al pedido" class="ui-btn ui-btn-up-d ui-shadow ui-btn-corner-all ui-btn-icon-notext">'
								+ '<span class="ui-btn-inner ui-btn-corner-all">'
								+ '<span class="ui-btn-text">'
								+ '</span>'
								+ '<span class="ui-icon ui-icon-gear ui-icon-shadow">&nbsp;</span></span></span></span>'
								+ '</a>' + '</li>';
						$('#lista_productos').append(html);
					});
	// Need to refresh list after AJAX call
	$('#lista_productos').listview("refresh");
};

// Accion carga los grupos
$("#page_carta_grupos").live("pageshow", function() {
	$.ajax({
		type : "POST",
		url : "grupo_producto/get_all.action",
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			showPopup("Server Internal Error:");
			$.mobile.hidePageLoadingMsg();
		},
		success : function(json_results) {
			if (json_results.success) {
				if (json_results.data.length > 0) {
					loadGrupos(json_results);
				} else {
					showPopup("! No hay productos !");
				}
			} else {
				showPopup(json_results.message);
			}
			$.mobile.hidePageLoadingMsg();
		}

	});
});

// funcion carga grupos
function loadGrupos(json_results) {
	i = 0;
	html = "";
	limpiaGrupos();
	limpiaProductos();
	$
			.each(
					json_results.data,
					function(key) {
						if ((i % 2) == 0) {
							// Botones de grupos parte derecha
							html = html
									+ '<div class="ui-block-a">'
									+ '<a class="item_grupo" data-role="button" data-transition="slide"'
									+ 'href="#page_carta_productos" data-nid = "'
									+ [ json_results.data[key].idGrupoProducto ]
									+ ',' + [ json_results.data[key].nombre ]
									+ '" data-icon="ios-pack-color-home"'
									+ 'data-iconpos="top" data-iconsize="26"> '
									+ [ json_results.data[key].nombre ]
									+ ' </a>' + '<div></div>' + '</div>';
						} else {
							// Botones de grupos parte izquierda
							html = html
									+ '<div class="ui-block-b">'
									+ '<a class="item_grupo" data-role="button" data-transition="slide"'
									+ 'href="#page_carta_productos" data-nid = "'
									+ [ json_results.data[key].idGrupoProducto ]
									+ ',' + [ json_results.data[key].nombre ]
									+ '" data-icon="ios-pack-color-home"'
									+ 'data-iconpos="top" data-iconsize="26"> '
									+ [ json_results.data[key].nombre ]
									+ ' </a>' + '<div></div>' + '</div>';
						}
						i = +i + 1;
					});
	$('#group_grid').append(html);
	// Need to refresh list after AJAX call
	$('#group_grid').trigger('create');
	// $('#group_grid').buttonMarkup();
};

// Accion carga producto
$("#page_producto").live("pageshow", function() {
	$.ajax({
		type : "POST",
		url : "producto/get_producto.action",
		data : {
			idProducto : producto.id
		},
		dataType : "json",
		cache : false,
		beforeSend : $.mobile.showPageLoadingMsg(),
		error : function(json_results) {
			showPopup("Server Internal Error:");
			$.mobile.hidePageLoadingMsg();
		},
		success : function(json_results) {
			if (json_results.success) {
				if (json_results.total == 1) {
					loadProducto(json_results);
				} else {
					showPopup("! No existe producto !");
				}
			} else {
				showPopup(json_results.message);
			}
			$.mobile.hidePageLoadingMsg();
		}

	});
});

// funcion carga producto
function loadProducto(json_results) {
	html = "";
	limpiaProducto();
	html = '<div style="text-align: center;">' + '<h2>'
			+ [ json_results.data.nombre ]
			+ '</h2>'
			+ '</div>'
			+ '<div style="text-align: center">'
			+ '<img style="align: center; width: auto; height: auto" class="ui-corner-all" src="'
			+ [ json_results.data.imagen ] + '"/>' + '</div>' + '<div>'
			+ '<p style="text-align: justify;"'
			+ 'data-mce-style="text-align: justify;">'
			+ [ json_results.data.descripcion ] + '</p>' + '</div>'
			+ '<a data-role="button" data-direction="reverse"'
			+ 'data-transition="slide" href="#page_producto" data-icon="grid"'
			+ 'data-iconpos="left" class= anadir_a_pedido ' + 'data-nid=' + producto.id + ',' + producto.posicion + '> ' + [ json_results.data.precio ]
			+ ' € </a>' ;
//			+ '<div data-role="fieldcontain">';
//			+ '<fieldset data-role="controlgroup" data-type="vertical">'
//			+ '<legend> Pidelo con: </legend>' + '</fieldset>' + '</div>';
	$('#content-producto').append(html);
	// Need to refresh list after AJAX call
	$('#content-producto').trigger('create');
	// $('#group_grid').buttonMarkup();
	actualizarContador();
};

// Muestra popup
function showPopup(msg) {
	$(
			"<div class='ui-loader ui-overlay-shadow ui-body-e ui-corner-all'><h4  align='center'>"
					+ msg + "</h4></div>").css({
		"display" : "block",
		"opacity" : 0.96,
		"top" : $(window).scrollTop() + 50,
		"left" : "10%",
		"width" : "80%",
		"height" : "100px",
	}).appendTo($.mobile.pageContainer).delay(2000).fadeOut(400, function() {
		$(this).remove();
	});
};

// Evento clic de grupos
$('.item_grupo').live('click', function() {
	var srt = $(this).data('nid').split(",");
	grupo = {
		id : srt[0],
		nombre : srt[1]
	};
});

// Evento clic de producto
$('.item_producto').live('click', function() {
	var srt = $(this).data('nid').split(",");
	producto = {
		id : srt[0],
		posicion : srt[1]
	};
});

// Evento clic de producto añadir pedido
$('.anadir_a_pedido').live('click', function() {
	var srt = $(this).data('nid').split(",");
	producto = {
		id : srt[0],
		posicion : srt[1]
	};
	productoAux = productosAux[producto.posicion];
	anadirProducto(productoAux);
});

// Evento clic de producto añadir pedido
$('.borrar_producto_pedido').live('click', function() {
	var srt = $(this).data('nid').split(",");
	var productoBorrar = {
		posGrupo : srt[0],
		posProducto : srt[1]
	};
	borrarProductoPedido(productoBorrar);
	actualizarContador();
	actualizarPedido();

});

// funcion borrar producto pedido
function borrarProductoPedido(productoBorrar) {
	// borra el grupo entero
	// var aux = pedido[productoBorrar.posGrupo].data;
	if (pedido[productoBorrar.posGrupo].data.length > 1) {
		pedido[productoBorrar.posGrupo].data.splice(productoBorrar.posProducto,
				1);
		cntPedido--;
	}
	// borra el producto
	else {
		pedido.splice(productoBorrar.posGrupo, 1);
		cntPedido--;
	}
}

// Evento clic de producto pagar
$('#pedir').live('click', function() {

	var pedidoAltaDto = {
			"codUnicoMovil" : codUnicoMovil,
			"mesa" : mesa,
			"comentario" : "",
			"productos" : "",
				};
	$.mobile.showPageLoadingMsg();
	// generar el pedido para guardarlo en la bd
	$.each(pedido, function(key) {
		$.each(pedido[key].data, function(key2) {
			pedidoAltaDto.productos += pedido[key].data[key2].idProducto + ',';
		});
	});
	$.ajax({
		type : "POST",
		url : "pedido/save.action",
		data : pedidoAltaDto,
		dataType : "json",
		cache : false,
		error : function(json_results) {
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			if (json_results.success) {
				pedido = new Array();
				cntPedido = 0;
				actualizarPedido();
				showPopup(json_results.message);

			} else {
				showPopup(json_results.message);
			}
		}

	});
	$.mobile.hidePageLoadingMsg();
});

// Funcion añadir producto al pedido
function anadirProducto(productoAux) {
	var encontrado = false;
	// buscamos si ya existe el grupo
	$.each(pedido, function(key) {
		if (pedido[key].idGrupo == grupo.id) {
			// encontrado
			pedido[key].data.push(productoAux);
			encontrado = true;
		}
	});
	// encontrado
	if (!encontrado) {
		pedido.push({
			idGrupo : grupo.id,
			nombreGrupo : grupo.nombre,
			data : new Array(productoAux)
		});
	}
	cntPedido = cntPedido + 1;
	actualizarContador();
};


// Accion carga pedido
$("#page_pedido").live("pageshow", function() {
	actualizarPedido();
});

// funcion actualizar pedido
function actualizarPedido() {
	limpiaPedido();
	actualizarContador();
	var total = 0;
	$.each(pedido, function(key) {
		// Grupo
		$('#lista_pedido').append($('<li/>', { // here appendin `<li>`
			'data-role' : "list-divider",
			'text' : pedido[key].nombreGrupo,
			'data-theme' : 'a',
		}));
		$.each(pedido[key].data, function(key_int) {
			// Producto
			$('#lista_pedido').append($('<li/>', {
				'data-theme' : 'c',
			}).append($('<a/>', { // here appending `<a>` into `<li>`
				'href' : '#producto',
				'data-transition' : 'slide',
				'text' : pedido[key].data[key_int].nombre,
			// 'data-icon' : 'close',
			}).append($('<p/>', {
				'text' : pedido[key].data[key_int].precio + ' €',
				'class' : 'ui-li-aside ui-li-desc'
			}))).append($('<a/>', {
				'text' : pedido[key].data[key_int].nombre,
				'href' : '#borrar',
				'data-theme' : 'c',
				'data-icon' : 'delete',
				'class' : 'borrar_producto_pedido',
				'data-nid' : key + ',' + key_int,

			})));
			total += parseFloat(pedido[key].data[key_int].precio);
		});
	});
	// Total
	$('#lista_pedido').append($('<li/>', { // here appendin `<li>`
		'data-role' : "list-divider",
		'data-theme' : 'a',

	})).append($('<li/>', { // here appendin `<li>`
		'data-icon' : 'false',
		'data-theme' : 'e',
	}).append($('<a/>', { // here appending `<a>` into `<li>`
		'text' : 'Total:',
		'data-theme' : 'a',
	}).append($('<p/>', {
		'class' : 'ui-li-aside ui-li-desc',
	}).append($('<strong/>', {
		'text' : total + ' €',
	}))))).append($('<li/>', { // here appendin `<li>`
		'data-role' : "list-divider",
		'data-theme' : 'b',
	}));
	// Need to refresh list after AJAX call
	$('#lista_pedido').listview("refresh");
}

// Actualiza contador de productos de la vista
function actualizarContador() {
	$('.contador').children('.ui-btn-inner').children('.ui-btn-text').text(
			cntPedido);
}

// limpiadores
function limpiaProducto() {
	$('#content-producto').children().remove();
};

function limpiaGrupos() {
	$('#group_grid').children().remove();
};

function limpiaProductos() {
	$('#lista_productos').children().remove();
};

function limpiaPedido() {
	$('#lista_pedido').children().remove();
};

// "/pedido/save.action"
