<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title></title>
<link rel="stylesheet"
	href="jquery.mobile/jquery.mobile-1.1.1/jquery.mobile-1.1.1.min.css" />
<script src="jquery.mobile/jquery-1.7.1/jquery-1.7.1.min.js">
	
</script>
<script
	src="jquery.mobile/jquery.mobile-1.1.1/jquery.mobile-1.1.1.min.js">
	
</script>
<!--  Mis js's -->
<script src="js/app_viewer.js">
	
</script>
<script src="js/app_glob_var.js">
	
</script>
<!--  Fin js's -->

<!--  Mis css's -->

</head>
<body>
	<!-- pedido -->
	<div data-role="page" id="page_pedido_viewer">
		<div data-theme="a" data-role="header" data-position="fixed">
			<h3>TouchBar</h3>
			<a id="atras" data-role="button" data-direction="reverse"
				data-transition="slide" data-theme="a" href="login.jsp"
				data-icon="arrow-l" data-iconpos="notext" class="ui-btn-left">
				Atras </a> 
<!-- 				<a data-role="button" data-transition="slide" data-theme="a" -->
<!-- 				href="#" data-icon="grid" data-iconpos="left" -->
<!-- 				class="ui-btn-right contador"> 0 </a> -->
		</div>
		<div data-role="content" style="padding: 15px">
			<ul id="lista_pedido_viewer" data-role="listview"
				data-divider-theme="b" data-inset="false">
			</ul>
		</div>
	</div>
</body>
</html>