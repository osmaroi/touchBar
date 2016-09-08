

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `touchbar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `cod_cliente` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `password` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `cod_unico_movil` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido1` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido2` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono_fijo` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono_movil` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `correo_electronico` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `usu_crear` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cod_unico_movil_UNIQUE` (`cod_unico_movil`),
  UNIQUE KEY `cod_cliente_UNIQUE` (`cod_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=26 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destino_producto`
--

CREATE TABLE IF NOT EXISTS `destino_producto` (
  `id_destino_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `impresora` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL COMMENT 'Impresora de barra,cocina,piezzeria.',
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_destino_producto`),
  UNIQUE KEY `id_destino_producto_UNIQUE` (`id_destino_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `destino_producto`
--

INSERT INTO `destino_producto` (`id_destino_producto`, `nombre`, `descripcion`, `impresora`, `usu_crear`, `fecha_modificar`, `usu_modificar`, `fecha_crear`, `usu_borrar`, `fecha_borrar`) VALUES
(0, 'systema', 'systema', 'systema', NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Pizzeria', 'Visible desde Pizzeria', 'pizzeria.ps', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Barra', 'Visible desde Barra', 'barra.ps', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Cocina', 'Visible desde Cocina', 'cocina.ps', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'prueba', 'prueba', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `id_rol` int(11) NOT NULL,
  `cod_empleado` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido1` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido2` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono_fijo` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono_movil` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `correo_electronico` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `id_empleado_UNIQUE` (`id_empleado`),
  UNIQUE KEY `cod_empleado_UNIQUE` (`cod_empleado`),
  KEY `fk_empleado_rol` (`id_rol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `id_rol`, `cod_empleado`, `password`, `nombre`, `apellido1`, `apellido2`, `telefono_fijo`, `telefono_movil`, `correo_electronico`, `usu_crear`, `fecha_crear`, `usu_modificar`, `fecha_modificar`, `usu_borrar`, `fecha_borrar`) VALUES
(2, 2, 'usu_system', 'usu_system', 'systema', 'systema', 'systema', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 3, 'co_elena', 'co_elena', 'elena', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 4, 'ba_leo', 'ba_leo', 'leo', 'leo', 'leo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 5, 'ca_sergio', 'ca_sergio', 'sergio', 'sergio', 'sergio', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(17, 1, 'Administrador', 'administrador', 'Administrador', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
(18, 1, 'ad_oscar', 'ad_oscar', 'Oscar', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
(19, 1, 'ad_lenin', 'ad_lenin', 'Lenin', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL),
(20, 6, 'pi_lenin', 'pi_lenin', 'Lenin', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo_producto`
--

CREATE TABLE IF NOT EXISTS `grupo_producto` (
  `id_grupo_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `imagen` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_grupo_producto`),
  UNIQUE KEY `id_grupo_producto_UNIQUE` (`id_grupo_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `grupo_producto`
--

INSERT INTO `grupo_producto` (`id_grupo_producto`, `nombre`, `descripcion`, `imagen`, `usu_crear`, `fecha_crear`, `usu_modificar`, `fecha_modificar`, `usu_borrar`, `fecha_borrar`) VALUES
(1, 'Refrescos', 'Refrescos no alcoholicos', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Vinos', 'Vinos', 'g_vinos.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Pizzas', 'Pizzas gourmet', 'g_pizzas.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'vacio', 'grupo vacio', 'vacio', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'pescados', 'pescados', 'pescado', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'carnes', 'carnes', 'carnes', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `fecha_pedido` datetime DEFAULT NULL,
  `mesa` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `servido` tinyint(1) DEFAULT NULL COMMENT 'Servido al cliente',
  `comentario` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  UNIQUE KEY `id_pedido_UNIQUE` (`id_pedido`),
  KEY `fk_pedido_cliente1` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=69 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_grupo_producto` int(11) NOT NULL,
  `id_destino_producto` int(11) NOT NULL,
  `publicado` tinyint(1) DEFAULT NULL COMMENT 'visible desde la parte del cliente',
  `nombre` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `precio` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `imagen` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`),
  KEY `fk_id_grupo_producto` (`id_grupo_producto`),
  KEY `fk_id_destino_producto` (`id_destino_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `id_grupo_producto`, `id_destino_producto`, `publicado`, `nombre`, `descripcion`, `precio`, `imagen`, `usu_crear`, `fecha_crear`, `usu_modificar`, `fecha_modificar`, `usu_borrar`, `fecha_borrar`) VALUES
(1, 3, 1, 1, 'Pizza Tonno', 'Deliciosa pizza de masa fina con tomate, mozzarella, cebolla y atun.', '7,5', 'images_app/productos/pizza_tonno_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 3, 1, 1, 'Pizza Funghi', 'Deliciosa pizza de masa fina con tomate, mozzarella, cebolla y champi?±ones.', '7,5', 'images_app/productos/pizza_funghi_pequena.jpeg', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 3, 1, 1, 'Pizza Diavola', 'Deliciosa pizza de masa fina con tomate, mozzarella, cebolla y chorizo picante.', '8,5', 'images_app/productos/pizza_diavola_pequena.jpeg', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 1, 2, 1, 'Cocacola', 'cocacola de 250cl', '2', 'images_app/productos/cacacola_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 1, 2, 1, 'Fanta naranja', 'fanta naranja 250cl', '2,5', 'images_app/productos/fanta_naranja_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 2, 2, 1, 'Lagunilla', 'Botella vino Lagunilla reserva 750cl', '11', 'images_app/productos/lagunilla_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 2, 2, 1, 'Fragolino', 'Botella vino fragolino vino tinto dulce espumoso 750cl', '15', 'images_app/productos/fragolino_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(8, 5, 3, 1, 'Merluza con gambas', 'Deliciosa merluza con una fina campa de tempura aderezada con ajo y perjil acompañada de unas fantasticas gambas peladas', '10.5', 'images_app/productos/merluza_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(9, 6, 3, 1, 'Entrecot al punto de sal', 'Delicioso entrecot de 275 gramos con patatas y esparragos de gruarnicion', '15.5', 'images_app/productos/entrecot_pequena.jpg', NULL, NULL, NULL, NULL, NULL, NULL),
(22, 2, 2, 1, 'Vino de la Casa', 'Botella de 250ccl del mejor vino de la casa', '7.5', 'images_app/productos/imagen_default.jpg', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_pedido`
--

CREATE TABLE IF NOT EXISTS `producto_pedido` (
  `id_producto_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `comentario` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `servido` tinyint(1) DEFAULT NULL COMMENT 'Servido al cliente',
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_producto_pedido`),
  UNIQUE KEY `id_producto_pedido_UNIQUE` (`id_producto_pedido`),
  KEY `fk_id_pedido` (`id_pedido`),
  KEY `fk_id_producto_1` (`id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=163 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `id_destino_producto` int(11) NOT NULL,
  `nombre` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `usu_crear` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_crear` datetime DEFAULT NULL,
  `usu_modificar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_modificar` datetime DEFAULT NULL,
  `usu_borrar` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_borrar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_rol`),
  UNIQUE KEY `id_rol_UNIQUE` (`id_rol`),
  KEY `fk_rol_destino_producto1` (`id_destino_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `id_destino_producto`, `nombre`, `descripcion`, `usu_crear`, `fecha_crear`, `usu_modificar`, `fecha_modificar`, `usu_borrar`, `fecha_borrar`) VALUES
(1, 0, 'Admin', 'administrador del sistema', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 0, 'system', 'usuario systema o aplicacion', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 3, 'cocinero', 'cocinero del restaurante', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 2, 'barman', 'barman del restaurante', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 2, 'camarero', 'camarero del restaurante', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 1, 'pizzero', 'pizzeria', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_USUARIO_ROL1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_id_destino_producto` FOREIGN KEY (`id_destino_producto`) REFERENCES `destino_producto` (`id_destino_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_producto` FOREIGN KEY (`id_grupo_producto`) REFERENCES `grupo_producto` (`id_grupo_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto_pedido`
--
ALTER TABLE `producto_pedido`
  ADD CONSTRAINT `fk_id_pedido_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_producto_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `fk_rol_destino_producto1` FOREIGN KEY (`id_destino_producto`) REFERENCES `destino_producto` (`id_destino_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
