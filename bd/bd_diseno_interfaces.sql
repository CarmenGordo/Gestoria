-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-12-2024 a las 20:02:39
-- Versión del servidor: 5.7.35-0ubuntu0.18.04.2
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_diseno_interfaces`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacenes`
--

CREATE TABLE `almacenes` (
  `id_almacen` varchar(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `ciudad` varchar(150) NOT NULL,
  `pais` varchar(150) NOT NULL,
  `telefono` int(9) NOT NULL,
  `capacidad_ocupada` int(5) NOT NULL,
  `capacidad_total` int(5) NOT NULL,
  `horario` json NOT NULL,
  `id_tienda` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `almacenes`
--

INSERT INTO `almacenes` (`id_almacen`, `nombre`, `direccion`, `ciudad`, `pais`, `telefono`, `capacidad_ocupada`, `capacidad_total`, `horario`, `id_tienda`) VALUES
('A001', 'Almacén Barcelona', 'Carrer de Pau Claris, 30', 'Barcelona', 'España', 932345679, 165, 500, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T001'),
('A002', 'Almacén Madrid', 'Calle de Vallehermoso, 85', 'Madrid', 'España', 912345679, 163, 600, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T002'),
('A003', 'Almacén Londres', 'Oxford Street, 40', 'Londres', 'Reino Unido', 203456790, 144, 700, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T003'),
('A004', 'Almacén Los Ángeles', 'Hollywood Boulevard, 140', 'Los Ángeles', 'EE.UU.', 213456790, 217, 400, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T004'),
('A005', 'Almacén Tokio', 'Shibuya, 5', 'Tokio', 'Japón', 312345679, 116, 650, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T005'),
('A006', 'Almacén París', 'Avenue des Champs-Élysées, 60', 'París', 'Francia', 142345679, 125, 700, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T006'),
('A007', 'Almacén Berlín', 'Kurfürstendamm, 120', 'Berlín', 'Alemania', 302345679, 44, 450, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T007');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` varchar(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `imagen` longtext,
  `tipo` enum('Accesorios','Ropa','Zapatillas') NOT NULL,
  `subtipo_ropa` enum('Camiseta','Sudadera','Jersey','Chaqueta','Pantalon_corto','Pantalon_largo','Leggins','Chandals','Falda','Vestido') DEFAULT NULL,
  `subtipo_accesorios` enum('Gorro','Bolso','Mochila','Calcetines','Guantes','Cinturon','Cartera','Gafas de sol') DEFAULT NULL,
  `talla` set('XS','S','M','L','XL','XXL','35','36','37','38','39','40','41','42','43','44','45','-') DEFAULT NULL,
  `precio` double NOT NULL,
  `stock` int(4) NOT NULL,
  `id_tienda` varchar(20) NOT NULL,
  `id_almacen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `imagen`, `tipo`, `subtipo_ropa`, `subtipo_accesorios`, `talla`, `precio`, `stock`, `id_tienda`, `id_almacen`) VALUES
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, '35,36', 160.49, 3, 'T002', 'A002'),
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, '45', 160.49, 20, 'T003', 'A003'),
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, '35,37,44', 160.49, 4, 'T004', 'A004'),
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, '35,43,44', 160.49, 9, 'T005', 'A005'),
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, '43', 160.49, 1, 'T006', 'A006'),
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, NULL, 160.49, 0, 'T007', 'A007'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, '41,42', 99.9, 5, 'T001', 'A001'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, '35,36', 99.9, 2, 'T002', 'A002'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, '40,43,44', 99.9, 8, 'T003', 'A003'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, '35,37,39', 99.9, 5, 'T004', 'A004'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, NULL, 99.9, 0, 'T005', 'A005'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, '35,37,44,45', 99.9, 4, 'T006', 'A006'),
('P002', 'Zapatilla Dunk', 'ZapatillaDunk.png', 'Zapatillas', NULL, NULL, '35', 99.9, 1, 'T007', 'A007'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, NULL, 170, 0, 'T001', 'A001'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, '45', 170, 1, 'T002', 'A002'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, '40,41,42', 170, 7, 'T003', 'A003'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, NULL, 170, 0, 'T004', 'A004'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, '37,38,40,41', 170, 9, 'T005', 'A005'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, '36,38,41,45', 170, 4, 'T006', 'A006'),
('P003', 'Zapatilla Shox R6', 'ZapatillaShoxR6.jpg', 'Zapatillas', NULL, NULL, '40', 170, 1, 'T007', 'A007'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, '38,39,42,44,45', 156.8, 10, 'T001', 'A001'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, '36,37,42', 156.8, 4, 'T002', 'A002'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, '40,41,42', 156.8, 3, 'T003', 'A003'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, '43,45', 156.8, 2, 'T004', 'A004'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, '37,38,40,41', 156.8, 6, 'T005', 'A005'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, '36,37,38,40,41,45', 156.8, 10, 'T006', 'A006'),
('P004', 'Zapatilla V2K Run', 'ZapatillaV2KRun.jpeg', 'Zapatillas', NULL, NULL, NULL, 156.8, 0, 'T007', 'A007'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', 'S', 19.5, 20, 'T001', 'A001'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', 'S', 19.5, 10, 'T002', 'A002'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', 'S', 19.5, 3, 'T003', 'A003'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', 'S', 19.5, 16, 'T004', 'A004'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', 'S', 19.5, 10, 'T005', 'A005'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', 'S', 19.5, 12, 'T006', 'A006'),
('P005', 'Bandolera Strip', 'BandoleraStrip.png', 'Accesorios', NULL, 'Bolso', NULL, 19.5, 0, 'T007', 'A007'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', 'S', 23, 20, 'T001', 'A001'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', 'S', 23, 10, 'T002', 'A002'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', 'S', 23, 3, 'T003', 'A003'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', 'S', 23, 16, 'T004', 'A004'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', 'S', 23, 10, 'T005', 'A005'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', 'S', 23, 12, 'T006', 'A006'),
('P006', 'Bolso Cross', 'BolsoCross.png', 'Accesorios', NULL, 'Bolso', NULL, 23, 0, 'T007', 'A007'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', 'XS', 15.6, 2, 'T001', 'A001'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', 'XS', 15.6, 5, 'T002', 'A002'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', 'XS', 15.6, 3, 'T003', 'A003'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', 'XS', 15.6, 8, 'T004', 'A004'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', 'XS', 15.6, 4, 'T005', 'A005'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', NULL, 15.6, 0, 'T006', 'A006'),
('P007', 'Cartera Heritage', 'CarteraHeritage.jpg', 'Accesorios', NULL, 'Bolso', NULL, 15.6, 0, 'T007', 'A007'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', NULL, 23.9, 0, 'T001', 'A001'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', 'XS', 23.9, 9, 'T002', 'A002'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', 'XS', 23.9, 17, 'T003', 'A003'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', NULL, 23.9, 0, 'T004', 'A004'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', 'XS', 23.9, 1, 'T005', 'A005'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', 'XS', 23.9, 2, 'T006', 'A006'),
('P008', 'Cartera Icon Ace', 'CarteraIconAce.jpg', 'Accesorios', NULL, 'Cartera', NULL, 23.9, 0, 'T007', 'A007'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T001', 'A001'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T002', 'A002'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', '-', 80, 4, 'T003', 'A003'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T004', 'A004'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T005', 'A005'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', '-', 80, 2, 'T006', 'A006'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T007', 'A007'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 0, 'T001', 'A001'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', '-', 30, 5, 'T002', 'A002'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', '-', 30, 10, 'T003', 'A003'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 0, 'T004', 'A004'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', '-', 30, 3, 'T005', 'A005'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', '-', 30, 20, 'T006', 'A006'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 0, 'T007', 'A007'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T001', 'A001'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T002', 'A002'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', '-', 60.4, 4, 'T003', 'A003'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T004', 'A004'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T005', 'A005'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', '-', 60.4, 7, 'T006', 'A006'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T007', 'A007'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', 'M', 26.9, 20, 'T001', 'A001'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', 'M', 26.9, 15, 'T002', 'A002'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', NULL, 26.9, 0, 'T003', 'A003'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', 'M', 26.9, 4, 'T004', 'A004'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', 'M', 26.9, 8, 'T005', 'A005'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', NULL, 26.9, 0, 'T006', 'A006'),
('P012', 'Mochila Mini', 'MochilaMini.png', 'Accesorios', NULL, 'Mochila', 'M', 26.9, 12, 'T007', 'A007'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', '40,41,43', 29.8, 20, 'T001', 'A001'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', '35,37,38,39,44', 29.8, 20, 'T002', 'A002'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', NULL, 29.8, 0, 'T003', 'A003'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', '36,40,41', 29.8, 19, 'T004', 'A004'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', '36,37,38', 29.8, 8, 'T005', 'A005'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', NULL, 29.8, 0, 'T006', 'A006'),
('P013', 'Calcetines Everyday Plus', 'CalcetinesEverydayPlus.png', 'Accesorios', NULL, 'Calcetines', '35,38,39,45', 29.8, 12, 'T007', 'A007'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', '-', 34, 6, 'T001', 'A001'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 0, 'T002', 'A002'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', '-', 34, 12, 'T003', 'A003'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', '-', 34, 11, 'T004', 'A004'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 0, 'T005', 'A005'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', '-', 34, 6, 'T006', 'A006'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', '-', 34, 16, 'T007', 'A007'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', '-', 12.9, 13, 'T001', 'A001'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', '-', 12.9, 22, 'T002', 'A002'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 0, 'T003', 'A003'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', '-', 12.9, 11, 'T004', 'A004'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', '-', 12.9, 8, 'T005', 'A005'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 0, 'T006', 'A006'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', '-', 12.9, 1, 'T007', 'A007'),
('P016', 'Guantes Pack', 'GuantesPeakBeanie.jpg', 'Accesorios', NULL, 'Guantes', 'M,XL', 47.9, 5, 'T003', 'A003'),
('P016', 'Guantes Pack', 'GuantesPeakBeanie.jpg', 'Accesorios', NULL, 'Guantes', 'M,L,XL', 47.9, 15, 'T006', 'A006'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'XS,S,XL', 23.6, 13, 'T001', 'A001'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'S,M,L', 23.6, 22, 'T002', 'A002'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'XL', 23.6, 5, 'T003', 'A003'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'XS,S', 23.6, 3, 'T004', 'A004'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'XL,XXL', 23.6, 9, 'T005', 'A005'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'M', 23.6, 2, 'T006', 'A006'),
('P017', 'Camiseta M90 Sega', 'CamisetaM90Sega.jpg', 'Ropa', 'Camiseta', NULL, 'XS,M,XXL', 23.6, 1, 'T007', 'A007'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, 'XS,S,XL', 23.9, 10, 'T001', 'A001'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, 'S,M', 23.9, 7, 'T002', 'A002'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, 'XL', 23.9, 5, 'T003', 'A003'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, NULL, 23.9, 0, 'T004', 'A004'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, 'XL,XXL', 23.9, 9, 'T005', 'A005'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, 'M', 23.9, 2, 'T006', 'A006'),
('P018', 'Camiseta Max 90', 'CamisetaMax90.png', 'Ropa', 'Camiseta', NULL, NULL, 23.9, 0, 'T007', 'A007'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, 'XS,S,XL', 34.9, 4, 'T001', 'A001'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, NULL, 34.9, 0, 'T002', 'A002'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, 'XL', 34.9, 1, 'T003', 'A003'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, 'M,L,XL', 34.9, 7, 'T004', 'A004'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, NULL, 34.9, 0, 'T005', 'A005'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, 'S', 34.9, 2, 'T006', 'A006'),
('P019', 'Camiseta PS', 'CamisetaPS.jpg', 'Ropa', 'Camiseta', NULL, NULL, 34.9, 0, 'T007', 'A007'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, 'XS,S,XL', 67.9, 4, 'T001', 'A001'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, NULL, 67.9, 0, 'T002', 'A002'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, 'XL', 67.9, 1, 'T003', 'A003'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, 'M,L,XL', 67.9, 7, 'T004', 'A004'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, NULL, 67.9, 0, 'T005', 'A005'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, 'S', 67.9, 2, 'T006', 'A006'),
('P020', 'Chaqueta Running', 'ChaquetaRunning.jpg', 'Ropa', 'Sudadera', NULL, NULL, 67.9, 0, 'T007', 'A007'),
('P021', 'Sudadera Bronzine', 'SudaderaBronzine.jpg', 'Ropa', 'Sudadera', NULL, 'XS,S,M,XL', 21, 24, 'T002', 'A002'),
('P021', 'Sudadera Bronzine', 'SudaderaBronzine.jpg', 'Ropa', 'Sudadera', NULL, 'M,L,XXL', 21, 10, 'T005', 'A005'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, 'XS,S,XL', 33.2, 4, 'T001', 'A001'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, 'XS,S,M,XL', 33.2, 2, 'T002', 'A002'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, 'XS,S,M,XL', 33.2, 9, 'T003', 'A003'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, 'M,L,XL', 33.2, 7, 'T004', 'A004'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, 'M,L,XXL', 33.2, 1, 'T005', 'A005'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, 'S', 33.2, 2, 'T006', 'A006'),
('P022', 'Falta Estampada FE', 'FaltaEstampadaFE.jpg', 'Ropa', 'Falda', NULL, NULL, 33.2, 0, 'T007', 'A007'),
('P023', 'Pantalon Corto Pc', 'PantalonCorto.jpg', 'Ropa', 'Pantalon_corto', NULL, 'XS,S,L', 33.2, 12, 'T003', 'A003'),
('P023', 'Pantalon Corto Pc', 'PantalonCorto.jpg', 'Ropa', 'Pantalon_corto', NULL, 'S,M', 33.2, 10, 'T006', 'A006'),
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'XS,S', 45, 12, 'T001', 'A001'),
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'XS,S,M,XL', 45, 2, 'T002', 'A002'),
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'XS,S,L', 45, 12, 'T003', 'A003'),
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'M,L,XL', 45, 97, 'T004', 'A004'),
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'S,M,L', 45, 11, 'T005', 'A005'),
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'S,M', 45, 10, 'T006', 'A006'),
('P030', 'a', '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', 'Zapatillas', NULL, NULL, 'XS', 1, 1, 'T001', 'A001');

--
-- Disparadores `productos`
--
DELIMITER $$
CREATE TRIGGER `actualizar_capacidad_ocupada_actualizar_producto` AFTER UPDATE ON `productos` FOR EACH ROW BEGIN
    -- Si el producto cambia de almacen:
    IF OLD.`id_almacen` <> NEW.`id_almacen` THEN
        -- le restamos al almacen inicial
        UPDATE `almacenes`
        SET `capacidad_ocupada` = `capacidad_ocupada` - OLD.`stock`
        WHERE `id_almacen` = OLD.`id_almacen`;

        -- le sumamos el stock al nuevvo almacen 
        UPDATE `almacenes`
        SET `capacidad_ocupada` = `capacidad_ocupada` + NEW.`stock`
        WHERE `id_almacen` = NEW.`id_almacen`;

    -- Pero si el producto cambia el stock del producto, acutaliza la cap. ocupada del almacen:
    ELSEIF OLD.`stock` <> NEW.`stock` THEN
        -- actulizar la cap. ocupada
        UPDATE `almacenes`
        SET `capacidad_ocupada` = `capacidad_ocupada` - OLD.`stock` + NEW.`stock`
        WHERE `id_almacen` = NEW.`id_almacen`;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_capacidad_ocupada_borrar_producto` AFTER DELETE ON `productos` FOR EACH ROW BEGIN
    -- Se borrra el producto, y cambia la cap. ocupada
    UPDATE `almacenes`
    SET `capacidad_ocupada` = `capacidad_ocupada` - OLD.`stock`
    WHERE `id_almacen` = OLD.`id_almacen`;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_capacidad_ocupada_insertar_producto` AFTER INSERT ON `productos` FOR EACH ROW BEGIN
    UPDATE `almacenes`
    SET `capacidad_ocupada` = `capacidad_ocupada` + NEW.`stock`
    WHERE `id_almacen` = NEW.`id_almacen`;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiendas`
--

CREATE TABLE `tiendas` (
  `id_tienda` varchar(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `tipo` enum('normal','outlet','premium') NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `ciudad` varchar(150) NOT NULL,
  `pais` varchar(150) NOT NULL,
  `telefono` int(9) NOT NULL,
  `horario` json NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tiendas`
--

INSERT INTO `tiendas` (`id_tienda`, `nombre`, `tipo`, `direccion`, `ciudad`, `pais`, `telefono`, `horario`) VALUES
('T001', 'Nike Store Barcelona', 'normal', 'Carrer de Pau Claris, 25', 'Barcelona', 'España', 932345678, '{\"lunes\": \"10:00-20:00\", \"jueves\": \"10:00-20:00\", \"martes\": \"10:00-20:00\", \"domingo\": \"Cerrado\", \"sábado\": \"11:00-19:00\", \"viernes\": \"10:00-20:00\", \"miércoles\": \"10:00-20:00\"}'),
('T002', 'Nike Outlet Madrid', 'outlet', 'Calle de Vallehermoso, 72', 'Madrid', 'España', 912345678, '{\"lunes\": \"10:00-19:00\", \"jueves\": \"10:00-19:00\", \"martes\": \"10:00-19:00\", \"domingo\": \"Cerrado\", \"sábado\": \"10:00-18:00\", \"viernes\": \"10:00-19:00\", \"miércoles\": \"10:00-19:00\"}'),
('T003', 'Nike Premium London', 'premium', 'Oxford Street, 34', 'Londres', 'Reino Unido', 203456789, '{\"lunes\": \"10:00-21:00\", \"jueves\": \"10:00-21:00\", \"martes\": \"10:00-21:00\", \"domingo\": \"Cerrado\", \"sábado\": \"10:00-21:00\", \"viernes\": \"10:00-21:00\", \"miércoles\": \"10:00-21:00\"}'),
('T004', 'Nike Store Los Angeles', 'normal', 'Hollywood Boulevard, 123', 'Los Angeles', 'Estados Unidos', 213456789, '{\"lunes\": \"09:00-20:00\", \"jueves\": \"09:00-20:00\", \"martes\": \"09:00-20:00\", \"domingo\": \"Cerrado\", \"sábado\": \"10:00-18:00\", \"viernes\": \"09:00-20:00\", \"miércoles\": \"09:00-20:00\"}'),
('T005', 'Nike Outlet Tokyo', 'outlet', 'Shibuya, 1', 'Tokio', 'Japón', 312345678, '{\"lunes\": \"11:00-19:00\", \"jueves\": \"11:00-19:00\", \"martes\": \"11:00-19:00\", \"domingo\": \"Cerrado\", \"sábado\": \"10:00-18:00\", \"viernes\": \"11:00-19:00\", \"miércoles\": \"11:00-19:00\"}'),
('T006', 'Nike Premium Paris', 'premium', 'Avenue des Champs-Élysées, 55', 'París', 'Francia', 142345678, '{\"lunes\": \"10:00-20:00\", \"jueves\": \"10:00-20:00\", \"martes\": \"10:00-20:00\", \"domingo\": \"Cerrado\", \"sábado\": \"10:00-20:00\", \"viernes\": \"10:00-20:00\", \"miércoles\": \"10:00-20:00\"}'),
('T007', 'Nike Store Berlin', 'normal', 'Kurfürstendamm, 101', 'Sevilla', 'Alemania', 302345, '{\"lunes\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}, \"jueves\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}, \"martes\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}, \"sabado\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}, \"domingo\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}, \"viernes\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}, \"miercoles\": {\"cierre\": \"obtenerHorarioDia c\", \"apertura\": \"obtenerHorarioDia a\"}}');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacenes`
--
ALTER TABLE `almacenes`
  ADD PRIMARY KEY (`id_almacen`),
  ADD KEY `fk_almacen_tienda` (`id_tienda`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`,`id_tienda`,`id_almacen`),
  ADD KEY `fk_tienda` (`id_tienda`),
  ADD KEY `fk_almacen` (`id_almacen`);
ALTER TABLE `productos` ADD FULLTEXT KEY `id_almacen` (`id_almacen`);

--
-- Indices de la tabla `tiendas`
--
ALTER TABLE `tiendas`
  ADD PRIMARY KEY (`id_tienda`),
  ADD KEY `id_tienda` (`id_tienda`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `almacenes`
--
ALTER TABLE `almacenes`
  ADD CONSTRAINT `fk_almacen_tienda` FOREIGN KEY (`id_tienda`) REFERENCES `tiendas` (`id_tienda`) ON DELETE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tiendas` (`id_tienda`),
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`id_almacen`) REFERENCES `almacenes` (`id_almacen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
