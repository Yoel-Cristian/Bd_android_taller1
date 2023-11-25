-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2023 a las 01:58:31
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_android`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `CategoriaID` int(11) NOT NULL,
  `NombreCategoria` text NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`CategoriaID`, `NombreCategoria`, `descripcion`) VALUES
(6, 'sansung', 'gama de celulares'),
(7, 'bbbbbbnbbbbb', 'hola mundo'),
(8, 'hh', 'hhkj');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ClienteID` int(11) NOT NULL,
  `Nombre` text DEFAULT NULL,
  `Apellido` text DEFAULT NULL,
  `Direccion` text DEFAULT NULL,
  `Telefono` text DEFAULT NULL,
  `CorreoElectronico` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallereserva`
--

CREATE TABLE `detallereserva` (
  `ID` int(11) NOT NULL,
  `ID_Cliente` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallereserva`
--

INSERT INTO `detallereserva` (`ID`, `ID_Cliente`, `Nombre`, `Cantidad`) VALUES
(1, 0, '', 33),
(2, 0, '', 33),
(3, 0, 'Paracetamol', 77),
(4, 0, 'Pastillas?', 776),
(5, 0, 'Paracetamol', 7),
(6, 0, 'Cigarrillos', 1),
(7, 0, 'Pastillas?', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ProductoID` int(11) NOT NULL,
  `Nombre` text DEFAULT NULL,
  `Descripcion` text DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `CategoriaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ProductoID`, `Nombre`, `Descripcion`, `Precio`, `Stock`, `CategoriaID`) VALUES
(1, 'prueba1', '192.168.1.10', 1111, 112, 6),
(4, 'prueba1', 'prueba1', 12, 1, 6),
(9, 'mmmmmm', 'bbbbbbn', 333, 1, 7),
(12, 'nnn', 'mmm', 88, 88, 0),
(13, 'nnn', 'mmm', 88, 88, 0),
(14, 'nnn', 'mmm', 88, 88, 6),
(17, 'zzzzzz', 'zzzzzz', 12, 12, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `ProveedorID` int(11) NOT NULL,
  `NombreEmpresa` text DEFAULT NULL,
  `Contacto` text DEFAULT NULL,
  `Direccion` text DEFAULT NULL,
  `Telefono` text DEFAULT NULL,
  `CorreoElectronico` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ursadministrador`
--

CREATE TABLE `ursadministrador` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Contrasenia` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ursadministrador`
--

INSERT INTO `ursadministrador` (`ID`, `Nombre`, `Contrasenia`) VALUES
(1, 'admin', 'admin'),
(2, 'a', '0cc175b9c0f1b6a831c3'),
(3, '5', 'd41d8cd98f00b204e9800998ecf8427e'),
(4, '', 'd41d8cd98f00b204e9800998ecf8427e'),
(5, 'e', 'e1671797c52e15f763380b45e841ec32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `urscliente`
--

CREATE TABLE `urscliente` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Contrasenia` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `urscliente`
--

INSERT INTO `urscliente` (`ID`, `Nombre`, `Contrasenia`) VALUES
(4, 'yoel', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `VentaID` int(11) NOT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `FechaVenta` text DEFAULT NULL,
  `TotalVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadetalle`
--

CREATE TABLE `ventadetalle` (
  `VentaDetalleID` int(11) NOT NULL,
  `VentaID` int(11) DEFAULT NULL,
  `ProductoID` int(11) DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `PrecioUnitario` double DEFAULT NULL,
  `Subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`CategoriaID`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ClienteID`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ProductoID`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`ProveedorID`);

--
-- Indices de la tabla `ursadministrador`
--
ALTER TABLE `ursadministrador`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `urscliente`
--
ALTER TABLE `urscliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`VentaID`);

--
-- Indices de la tabla `ventadetalle`
--
ALTER TABLE `ventadetalle`
  ADD PRIMARY KEY (`VentaDetalleID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `CategoriaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ClienteID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `ProductoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `ProveedorID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ursadministrador`
--
ALTER TABLE `ursadministrador`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `urscliente`
--
ALTER TABLE `urscliente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `VentaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ventadetalle`
--
ALTER TABLE `ventadetalle`
  MODIFY `VentaDetalleID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
