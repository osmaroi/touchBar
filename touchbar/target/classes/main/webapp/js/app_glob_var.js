//**********************************************************
// Variables Globales **************************************
//**********************************************************

//var globCodUsuario = -1; //Codigo de usuario despues del login.
var globUsuario = -1; //Usuario despues del login.

//**********************************************************
//Funciones Globales **************************************
//**********************************************************

/**
 * Muestra popup con el texto del mensaje
 */
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

/**
 * A–ade un 0 a la izquierda al numero si es menor de 10
 * @param n
 * @returns
 */
function checkTime(n) {
	if (n < 10) {
		n = "0" + n;
	}
	return n;
}

