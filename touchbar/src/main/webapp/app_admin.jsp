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
<script src="js/app_admin.js">
	
</script>
<script src="js/app_glob_var.js"></script>
<!--  Fin js's -->

<!--  Mis css's -->
<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	<!-- administrar -->
	<div data-role="page" id="administrar">
		<div data-theme="a" data-role="header" data-position="fixed">
			<a data-role="button" data-direction="reverse"
				data-transition="slide" data-theme="a" href="login.jsp"
				data-icon="arrow-l" data-iconpos="notext" class="ui-btn-left">
				Atras </a>
			<h3>Administrador - TouchBar</h3>
		</div>
		<div data-role="content" style="padding: 15px">

			<div class="content-secondary">
				<div data-role="collapsible-set" data-theme="a"
					data-content-theme="c">
					<div data-role="collapsible" data-collapsed="false">
						<h3>Pedidos</h3>
						<ul id="peidos" data-role="listview" data-divider-theme="c"
							data-inset="false">
							<li id="pedidos_no_servidos" data-theme="e"><a href="#">
									No servidos </a></li>
							<li id="pedidos_de_hoy" data-theme="c"><a href="#"> De
									Hoy </a></li>
						</ul>
					</div>
					<div data-role="collapsible" data-collapsed="true">
						<h3>Carta</h3>
						<ul id="carta" data-role="listview" data-divider-theme="c"
							data-inset="false">
							<li id="grupo_productos" data-theme="c"><a href="#">
									Grupo Productos </a></li>
							<li id="productos" data-theme="c"><a href="#"> Productos
							</a></li>
							<li id="destinos" data-theme="c"><a href="#"> Destinos </a></li>
						</ul>
					</div>
					<div data-role="collapsible" data-collapsed="true">
						<h3>Personal</h3>
						<ul id="personal" data-role="listview" data-divider-theme="c"
							data-inset="false">
							<li id="roles" data-theme="c"><a href="#"> Roles</a></li>
							<li id="empleados" data-theme="c"><a href="#"> Empleados</a></li>
						</ul>
					</div>
					<!-- div data-role="collapsible" data-collapsed="true">
					<h3>Clientes</h3>
					<ul id="clientes" data-role="listview" data-divider-theme="c"
							data-inset="false">
						<li id="grupo_productos" data-theme="c"><a href="#">
									Clientes </a></li>
									</ul>
					</div -->
				</div>
			</div>
			<div class="content-primary">
				<ul id="lista_derecha" data-role="listview" data-divider-theme="e"
					data-inset="true">
				</ul>
				<div id="mantenimiento_producto" data-divider-theme="e"
					class="ui-corner-all ui-shadow show_hide padding" data-inset="true">
					<div data-role="fieldcontain" class="show_hide">
						<label for="id_producto"> Id Producto: </label>
						<textarea id="id_producto" placeholder="">
					</textarea>
					</div>
					<div class="ui-grid-b">
						<div class="ui-block-a"></div>
						<div class="ui-block-b">
							<img id="imagen_producto" class=ui-corner-all
								src="images_app/productos/imagen_default.jpg" width="200"
								height="200" />
						</div>
					</div>
					<div data-role="fieldcontain">
						<!-- 	class="ui-disabled" -->
						<label for="select_grupo_producto" class="select">Grupo
							Producto: </label> <select data-native-menu=false
							name="select_grupo_producto" id="select_grupo_producto">
						</select>
					</div>
					<div data-role="fieldcontain">
						<label for="select_destino_producto" class="select">Destino
							Producto: </label> <select data-native-menu=false
							name="select_destino_producto" id="select_destino_producto">
						</select>
					</div>
					<div data-role="fieldcontain">
						<label for="nombre_producto"> Nombre: </label> <input
							id="nombre_producto" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="descripcion_producto"> Descripcion: </label>
						<textarea id="descripcion_producto" placeholder="">
                    </textarea>
					</div>
					<div data-role="fieldcontain">
						<label for="precio_producto"> Precio: </label> <input
							id="precio_producto" placeholder="" value="" pattern="[0-9]*"
							type="number" />
					</div>
					<div class="ui-grid-b">
						<div class="ui-block-a"></div>
						<div id="cancelar_producto" class="ui-block-b">
							<a href="#" data-role="button">Cancelar</a>
						</div>
						<div class="ui-block-c">
							<a id="aceptar_guardar_producto" href="#" data-role="button"
								data-theme="e">Aceptar</a>
						</div>
					</div>
				</div>
				<div id="mantenimiento_grupo_producto" data-divider-theme="e"
					class="ui-corner-all ui-shadow show_hide padding" data-inset="true">
					<div data-role="fieldcontain" class="show_hide">
						<label for="id_grupo_producto"> Id Grupo Producto: </label>
						<textarea id="id_grupo_producto" placeholder="">
					</textarea>
					</div>
					<div data-role="fieldcontain">
						<label for="nombre_grupo_producto"> Nombre: </label> <input
							id="nombre_grupo_producto" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="descripcion_grupo_producto"> Descripcion: </label>
						<textarea id="descripcion_grupo_producto" placeholder="">
                    </textarea>
					</div>
					<div class="ui-grid-b">
						<div class="ui-block-a"></div>
						<div id="cancelar_grupo_producto" class="ui-block-b">
							<a href="#" data-role="button">Cancelar</a>
						</div>
						<div class="ui-block-c">
							<a id="aceptar_guardar_grupo_producto" href="#"
								data-role="button" data-theme="e">Aceptar</a>
						</div>
					</div>
				</div>
				<div id="mantenimiento_destino_producto" data-divider-theme="e"
					class="ui-corner-all ui-shadow show_hide padding" data-inset="true">
					<div data-role="fieldcontain" class="show_hide">
						<label for="id_destino_producto"> Id Destino Producto: </label>
						<textarea id="id_destino_producto" placeholder="">
					</textarea>
					</div>
					<div data-role="fieldcontain">
						<label for="nombre_destino_producto"> Nombre: </label> <input
							id="nombre_destino_producto" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="descripcion_destino_producto"> Descripcion: </label>
						<textarea id="descripcion_destino_producto" placeholder="">
                    </textarea>
					</div>
					<div class="ui-grid-b">
						<div class="ui-block-a"></div>
						<div id="cancelar_destino_producto" class="ui-block-b">
							<a href="#" data-role="button">Cancelar</a>
						</div>
						<div class="ui-block-c">
							<a id="aceptar_guardar_destino_producto" href="#"
								data-role="button" data-theme="e">Aceptar</a>
						</div>
					</div>
				</div>
				<div id="mantenimiento_rol" data-divider-theme="e"
					class="ui-corner-all ui-shadow show_hide padding" data-inset="true">
					<div data-role="fieldcontain" class="show_hide">
						<label for="id_rol"> Id Rol: </label>
						<textarea id="id_rol" placeholder="">
					</textarea>
					</div>
					<div data-role="fieldcontain">
						<label for="select_destino_producto" class="select">Destino
							Producto: </label> <select data-native-menu=false
							name="select_destino_producto_rol"
							id="select_destino_producto_rol">
						</select>
					</div>
					<div data-role="fieldcontain">
						<label for="nombre_rol"> Nombre: </label> <input id="nombre_rol"
							placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="descripcion_rol"> Descripcion: </label>
						<textarea id="descripcion_rol" placeholder="">
                    </textarea>
					</div>
					<div class="ui-grid-b">
						<div class="ui-block-a"></div>
						<div id="cancelar_rol" class="ui-block-b">
							<a href="#" data-role="button">Cancelar</a>
						</div>
						<div class="ui-block-c">
							<a id="aceptar_guardar_rol" href="#" data-role="button"
								data-theme="e">Aceptar</a>
						</div>
					</div>
				</div>
				<div id="mantenimiento_empleado" data-divider-theme="e"
					class="ui-corner-all ui-shadow show_hide padding" data-inset="true">
					<div data-role="fieldcontain" class="show_hide">
						<label for="id_empleado"> Id Empleado: </label>
						<textarea id="id_empleado" placeholder="">
					</textarea>
					</div>
					<div data-role="fieldcontain">
						<label for="select_rol_empleado" class="select">Rol: </label> <select
							data-native-menu=false name="select_rol_empleado"
							id="select_rol_empleado">
						</select>
					</div>
					<div data-role="fieldcontain">
						<label for="cod_empleado"> Codigo Empleado: </label> <input
							id="cod_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="password_empleado"> Contraseña: </label> <input
							id="password_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="nombre_empleado"> Nombre: </label> <input
							id="nombre_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="apellido1_empleado"> Apellido 1: </label> <input
							id="apellido1_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="apellido2_empleado"> Apellido 2: </label> <input
							id="apellido2_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="telefono_fijo_empleado"> Telefono Fijo: </label> <input
							id="telefono_fijo_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="telefono_movil_empleado"> Telefono Movil: </label> <input
							id="telefono_movil_empleado" placeholder="" value="" type="text" />
					</div>
					<div data-role="fieldcontain">
						<label for="correo_electronico_empleado"> E-mail: </label> <input
							id="correo_electronico_empleado" placeholder="" value=""
							type="text" />
					</div>
					<div class="ui-grid-b">
						<div class="ui-block-a"></div>
						<div id="cancelar_empleado" class="ui-block-b">
							<a href="#" data-role="button">Cancelar</a>
						</div>
						<div class="ui-block-c">
							<a id="aceptar_guardar_empleado" href="#" data-role="button"
								data-theme="e">Aceptar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>