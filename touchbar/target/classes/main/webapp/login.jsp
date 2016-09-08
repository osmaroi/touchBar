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
<script src="js/app_login.js"></script>
<script src="js/app_viewer.js"></script>
<script src="js/app_admin.js"></script>
<script src="js/app_glob_var.js"></script>

<!--  Fin js's -->

<!--  Mis css's -->
<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	<!-- Login -->
	<div data-role="page" id="login">
		<div data-theme="a" data-role="header">
			<h3>TouchBar</h3>
		</div>
		<div data-role="content" style="padding: 5% 10% 10% 10%">

			<label for="username">Codigo Empleado:</label> <input type="text"
				name="username" id="username" value="" placeholder="Codigo Empleado" />

			<label for="username">Password:</label> <input type="password"
				name="password" id="password" value="" placeholder="Password" /> <a
				id="boton_acceder" data-role="button" data-transition="slide"
				href="#"> Acceder </a>
			<p></p>
			<a href="clientApps/touchbar.apk" target="_blank" data-role="button"
			data-icon="arrow-d" data-iconpos="bottom" data-inline="true"
			style="margin: 0 auto"><p>Descarga</p><p>el Cliente TouchBar para</p><p>Android</p></a>
		</div>
		
	</div>
</body>
</html>