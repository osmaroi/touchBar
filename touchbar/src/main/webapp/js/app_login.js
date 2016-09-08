//**********************************************************
// Variables ***********************************************
//**********************************************************

// **********************************************************
// Comunicacion con el servidor ****************************
// **********************************************************


// Evento clic de producto pagar
$('#boton_acceder').live('click', function() {
	
	$.ajax({
		type : "POST",
		url : "login/login.action",
		data : {
			codEmpleado :  $("#username").val(), 
			password :  $("#password").val()
		},
		dataType : "json",
		cache : false,
		error : function(json_results) {
			showPopup("Server Internal Error:");
		},
		success : function(json_results) {
			if (json_results.success) {
				if (json_results.total == 1) {
					//Se gurada el codigo de usuario en las variables globales
					globUsuario = json_results.data;
					$.mobile.changePage(json_results.page,  {
						transition: "slide",
						reverse: false,
						changeHash: true
					});
					} else {
					showPopup("! " + json_results.message + " !");
				}
			} else {
				showPopup("! " + json_results.message + " !");
			}
		}

	});
	$.mobile.hidePageLoadingMsg();
});


