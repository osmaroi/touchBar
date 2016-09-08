<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>TouchBar</title>
<!-- 
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.css" />
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script>
-->
<!--
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.js"></script>
        -->

<link rel="stylesheet"
	href="jquery.mobile/jquery.mobile-1.1.1/jquery.mobile-1.1.1.min.css" />
<script src="jquery.mobile/jquery-1.7.1/jquery-1.7.1.min.js">
	
</script>
<script
	src="jquery.mobile/jquery.mobile-1.1.1/jquery.mobile-1.1.1.min.js">
	
</script>
<!--  Mis js's -->
<script src="js/app_client.js">
	
</script>
<!--  Fin js's -->

<!--  Mis css's -->


</head>
<body>
	<!-- Home -->
	<!-- <div data-role="page" id="page1">
		<div data-theme="a" data-role="header" data-position="fixed">
			<h3>TouchBar</h3>
		</div>
		<div data-role="content" style="padding: 15px">
			<div>
				<p>
					<strong> <span data-mce-style="font-size: xx-large;"
						style="font-size: xx-large;"> TouchBar </span>
					</strong> <br />
				</p>
			</div>
			<div>
				<p style="text-align: right;" data-mce-style="text-align: right;">
					<span data-mce-style="text-decoration: underline;"
						style="text-decoration: underline;"> <span
						data-mce-bogus="true" id="_mce_caret"> <span
							style="font-size: medium;"> ​ </span>
					</span> ​​
					</span> <span style="font-size: medium;"> <strong> Una
							nueva forma de salir. </strong>
					</span>
				</p>
			</div>
			<div>
				<p>
					<b> <span data-mce-bogus="true" id="_mce_caret"> <span
							style="color: rgb(153, 153, 153);"> ​ </span>
					</span> <span style="color: rgb(153, 153, 153);">
							&nbsp;________________________________ </span> <br />
					</b>
				</p>
			</div>
			<div style="text-align: center">
				<img style="width: 287px; height: 178px"
					src="http://assets.codiqa.com/ps/25473/a0d3d1d33dc4de32scanerQr2.jpg" />
			</div>
			<a data-role="button" data-transition="slide" href="#page8"
				data-icon="grid" data-iconpos="left"> Escanear mesa </a>
		</div>
	</div>-->
	<!-- page_carta_grupos -->
	<div data-role="page" id="page_carta_grupos">
		<div data-theme="a" data-role="header" data-position="fixed">
			<h3>TouchBar</h3>
			<a data-role="button" data-direction="reverse"
				data-transition="slide" data-theme="a" href="#page1"
				data-icon="arrow-l" data-iconpos="notext" class="ui-btn-left">
				Atras </a> <a data-role="button" data-transition="slide" data-theme="a"
				href="#page_pedido" data-icon="grid" data-iconpos="left"
				class="ui-btn-right contador"> 0 </a>
		</div>
		<div data-role="content" style="padding: 15px">
			<div>
				<p style="text-align: center;" data-mce-style="text-align: center;">
					<b> <span style="font-size: large;"> Carta </span>
					</b>
				</p>
			</div>
			<div class="ui-grid-a" id="group_grid"></div>
		</div>
	</div>
	<!-- pedido -->
	<div data-role="page" id="page_pedido">
		<div data-theme="a" data-role="header" data-position="fixed">
			<h3>TouchBar</h3>
			<a data-role="button" data-direction="reverse"
				data-transition="slide" data-theme="a" href="#page_carta_grupos"
				data-icon="arrow-l" data-iconpos="notext" class="ui-btn-left">
				Atras </a> <a data-role="button" data-transition="slide" data-theme="a"
				href="#" data-icon="grid" data-iconpos="left"
				class="ui-btn-right contador"> 0 </a>
		</div>
		<div data-role="content" style="padding: 15px">
			<ul id="lista_pedido" data-role="listview" data-divider-theme="b"
				data-inset="false">
			</ul>
			<a id="pedir" data-role="button" data-transition="slide"
				href="#page_pedido"> Pagar </a>
		</div>
	</div>
	<!-- carta_productos_pinchos -->
	<div data-role="page" id="page_carta_productos">
		<div data-theme="a" data-role="header" data-position="fixed">
			<h3>TouchBar</h3>
			<a data-role="button" data-direction="reverse"
				data-transition="slide" data-theme="a" href="#page_carta_grupos"
				data-icon="arrow-l" data-iconpos="notext" class="ui-btn-left">
				Atras </a> <a data-role="button" data-transition="slide" data-theme="a"
				href="#page_pedido" data-icon="grid" data-iconpos="left"
				class="ui-btn-right contador"> 0 </a>
		</div>
		<div data-role="content" style="padding: 15px">
			<ul data-role="listview" data-divider-theme="a" data-inset="false"
				id="lista_productos">

			</ul>
		</div>
	</div>
	<!-- carta_productos_pinchos_pincho_tortilla -->
	<div data-role="page" id="page_producto">
		<div data-theme="a" data-role="header" data-position="fixed">
			<h3>TouchBar</h3>
			<a data-role="button" data-direction="reverse"
				data-transition="slide" data-theme="a" href="#page_carta_productos"
				data-icon="arrow-l" data-iconpos="notext" class="ui-btn-left">
				Atras </a> <a data-role="button" data-transition="slide" data-theme="a"
				href="#page_pedido" data-icon="grid" data-iconpos="left"
				class="ui-btn-right contador"> 0 </a>
		</div>
		<div id="content-producto" data-role="content" style="padding: 15px">
		</div>
	</div>
	<!-- Escanear -->
	<div data-role="page" id="page8">
		<div data-role="content" style="padding: 15px">
			<div style="">
				<img style="width: 300px; height: 450px"
					src="http://assets.codiqa.com/ps/25473/9e0969620fa28b60escaneando.jpg" />
			</div>
			<a data-role="button" data-transition="slide"
				href="#page_carta_grupos"> Button </a>
		</div>
	</div>
	<!-- Dialog -->
	<div data-role="dialog" id="alert-dialog">
		<div id="message-dialog"></div>
		<input id="button-dialog" type="button" value="Aceptar" data-theme="c"
			onclick="$('#alert-dialog').dialog('close');" />
	</div>
</body>
</html>