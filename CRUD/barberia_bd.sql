-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2023 a las 18:25:16
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pos`
--
DROP DATABASE IF EXISTS `pos`;
CREATE DATABASE IF NOT EXISTS `pos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `pos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

DROP TABLE IF EXISTS `almacen`;
CREATE TABLE `almacen` (
  `id_almacen` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
CREATE TABLE `detalle_pedido` (
  `id_detalle` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_inventario` int(11) DEFAULT NULL,
  `cant` int(11) DEFAULT NULL,
  `costo` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `g_menu`
--

DROP TABLE IF EXISTS `g_menu`;
CREATE TABLE `g_menu` (
  `id_seccion` int(11) NOT NULL,
  `id_modulo` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  `estado` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `g_menu`
--

INSERT INTO `g_menu` (`id_seccion`, `id_modulo`, `orden`, `estado`) VALUES
(1, 1, 1, '1'),
(2, 2, 1, '1'),
(3, 2, 1, '1'),
(4, 2, 1, '1'),
(5, 2, 1, '1'),
(6, 2, 1, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `g_page`
--

DROP TABLE IF EXISTS `g_page`;
CREATE TABLE `g_page` (
  `id_page` int(11) NOT NULL,
  `nombre` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `url` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `estado` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '1',
  `title` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcion` text NOT NULL,
  `url_discord` varchar(250) NOT NULL,
  `url_facebook` varchar(500) NOT NULL,
  `url_bot` varchar(700) NOT NULL,
  `pie` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `logo_empresa` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `logo_pagina` varchar(250) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `logo_fondo` varchar(250) NOT NULL,
  `logo_loading` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `g_page`
--

INSERT INTO `g_page` (`id_page`, `nombre`, `url`, `estado`, `title`, `descripcion`, `url_discord`, `url_facebook`, `url_bot`, `pie`, `logo_empresa`, `logo_pagina`, `logo_fondo`, `logo_loading`) VALUES
(1, 'GUIA DE PRICONNE', 'priconne.helperplay.com', '1', 'HELPER PLAY | PRICONNE', '¡Una wiki de Princess Connect Re:Dive! ¡Además de la última información útil del juego, encontraras una amplia gama de artículos de los personajes, imágenes y clasificaciones!', 'https://discord.com/invite/PXf2c5vvpm', 'https://www.facebook.com/profile.php?id=100088348201355', 'https://discord.com/api/oauth2/authorize?client_id=1035977993757143081&permissions=500364208192&scope=bot%20applications.commands', 'Copyright © 2023 Todos los derechos reservados a Helper Play', 'img/sistema/logos/logo_helper_play.png', 'img/sistema/logos/logo_priconne.png', 'img/sistema/fondos/fondo2.jpg', 'img/sistema/loading/peco.gif');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `g_seccion`
--

DROP TABLE IF EXISTS `g_seccion`;
CREATE TABLE `g_seccion` (
  `id_seccion` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `url` varchar(250) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `resumen` text DEFAULT NULL,
  `icono` varchar(200) NOT NULL,
  `abreviatura` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `g_seccion`
--

INSERT INTO `g_seccion` (`id_seccion`, `nombre`, `url`, `titulo`, `resumen`, `icono`, `abreviatura`) VALUES
(1, 'PRINCIPAL', 'index.php', 'BIENVENIDO A MI PAGINA', 'Es la Pagina principal', 'fas fa-home', 'Pagina Principal'),
(2, 'INICIO', 'admin.php', 'DASHBOARD GENERAL', NULL, 'fas fa-home', 'Pagina Principal'),
(3, 'USUARIOS', 'usuarios.php', 'MANTENIMIENTO DE USUARIOS\r\n', NULL, 'fas fa-home', 'Pagina Principal'),
(4, 'PRODUCTOS', 'productos.php', 'MANTENIMIENTO DE PRODUCTOS\r\n\r\n', NULL, 'fas fa-home', 'Pagina Principal'),
(5, 'INVENTARIO', 'inventario.php', 'MANTENIMIENTO DEL INVENTARIO\r\n\r\n', NULL, 'fas fa-home', 'Pagina Principal'),
(6, 'PEDIDOS', 'pedidos.php', 'MANTENIMIENTO DEL INVENTARIO\r\n\r\n', NULL, 'fas fa-home', 'Pagina Principal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

DROP TABLE IF EXISTS `inventario`;
CREATE TABLE `inventario` (
  `id_inventario` int(11) NOT NULL,
  `id_almacen` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `tipo_mov` int(11) DEFAULT NULL,
  `cant` int(11) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

DROP TABLE IF EXISTS `metodo_pago`;
CREATE TABLE `metodo_pago` (
  `id_metodo_pago` int(11) NOT NULL,
  `metodo_pago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `monto_total` decimal(10,0) NOT NULL,
  `id_metodo_pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `producto` varchar(50) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `estado` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_categoria`
--

DROP TABLE IF EXISTS `producto_categoria`;
CREATE TABLE `producto_categoria` (
  `id_categoria` int(11) NOT NULL,
  `categoria` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_galeria`
--

DROP TABLE IF EXISTS `producto_galeria`;
CREATE TABLE `producto_galeria` (
  `id_galeria` int(11) NOT NULL,
  `url_imagen` varchar(255) DEFAULT NULL,
  `estado` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL,
  `tipo_usuario` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE `transacciones` (
  `id_transacciones` int(11) NOT NULL,
  `id_inventario` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_mov` int(11) DEFAULT NULL,
  `cant` int(11) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `id_tipo_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id_almacen`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle`);

--
-- Indices de la tabla `g_menu`
--
ALTER TABLE `g_menu`
  ADD PRIMARY KEY (`id_seccion`,`id_modulo`) USING BTREE;

--
-- Indices de la tabla `g_page`
--
ALTER TABLE `g_page`
  ADD PRIMARY KEY (`id_page`);

--
-- Indices de la tabla `g_seccion`
--
ALTER TABLE `g_seccion`
  ADD PRIMARY KEY (`id_seccion`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodo_pago`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedido`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `producto_galeria`
--
ALTER TABLE `producto_galeria`
  ADD PRIMARY KEY (`id_galeria`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indices de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD PRIMARY KEY (`id_transacciones`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `g_page`
--
ALTER TABLE `g_page`
  MODIFY `id_page` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `g_seccion`
--
ALTER TABLE `g_seccion`
  MODIFY `id_seccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
