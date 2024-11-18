-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 18-11-2024 a las 18:07:17
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
('A001', 'Almacén Barcelona', 'Carrer de Pau Claris, 30', 'Barcelona', 'España', 932345679, 150, 500, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T001'),
('A002', 'Almacén Madrid', 'Calle de Vallehermoso, 85', 'Madrid', 'España', 912345679, 200, 600, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T002'),
('A003', 'Almacén Londres', 'Oxford Street, 40', 'Londres', 'Reino Unido', 203456790, 250, 700, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T003'),
('A004', 'Almacén Los Ángeles', 'Hollywood Boulevard, 140', 'Los Ángeles', 'EE.UU.', 213456790, 180, 400, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T004'),
('A005', 'Almacén Tokio', 'Shibuya, 5', 'Tokio', 'Japón', 312345679, 300, 650, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T005'),
('A006', 'Almacén París', 'Avenue des Champs-Élysées, 60', 'París', 'Francia', 142345679, 220, 700, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T006'),
('A007', 'Almacén Berlín', 'Kurfürstendamm, 120', 'Berlín', 'Alemania', 302345679, 160, 450, '{\"lunes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"jueves\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"martes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"viernes\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}, \"miércoles\": {\"cierre\": \"18:00\", \"apertura\": \"10:00\"}}', 'T007');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` varchar(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `imagen` longtext NOT NULL,
  `tipo` enum('Accesorios','Ropa','Zapatillas') NOT NULL,
  `subtipo_ropa` enum('Camiseta','Sudadera','Jersey','Chaqueta','Pantalon_corto','Pantalon_largo','Leggins','Chandals','Falda','Vestido') DEFAULT NULL,
  `subtipo_accesorios` enum('Gorro','Bolso','Mochila','Calcetines','Guantes','Cinturon','Cartera','Gafas de sol') DEFAULT NULL,
  `talla` set('XS','S','M','L','XL','XXL','35','36','37','38','39','40','41','42','43','44','45') DEFAULT NULL,
  `precio` double NOT NULL,
  `stock` int(4) NOT NULL,
  `id_tienda` varchar(20) NOT NULL,
  `id_almacen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `imagen`, `tipo`, `subtipo_ropa`, `subtipo_accesorios`, `talla`, `precio`, `stock`, `id_tienda`, `id_almacen`) VALUES
('P001', 'Nike Shox R4', 'ZapatillaShoxR4.jpg', 'Zapatillas', NULL, NULL, '38,40,41,42', 160.49, 10, 'T001', 'A001'),
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
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 4, 'T003', 'A003'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T004', 'A004'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T005', 'A005'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 2, 'T006', 'A006'),
('P009', 'Gafas Shox XRush', 'GafasShoxXRush.png', 'Accesorios', NULL, 'Gafas de sol', NULL, 80, 0, 'T007', 'A007'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 0, 'T001', 'A001'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 5, 'T002', 'A002'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 10, 'T003', 'A003'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 0, 'T004', 'A004'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 3, 'T005', 'A005'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 20, 'T006', 'A006'),
('P010', 'Gafas Skylon Ace', 'GafasSkylonAce.jpg', 'Accesorios', NULL, 'Gafas de sol', NULL, 30, 0, 'T007', 'A007'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T001', 'A001'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T002', 'A002'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 4, 'T003', 'A003'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T004', 'A004'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 0, 'T005', 'A005'),
('P011', 'Mochila Lakers', 'MochilaLakers.png', 'Accesorios', NULL, 'Mochila', NULL, 60.4, 7, 'T006', 'A006'),
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
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 6, 'T001', 'A001'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 0, 'T002', 'A002'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 12, 'T003', 'A003'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 11, 'T004', 'A004'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 0, 'T005', 'A005'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 6, 'T006', 'A006'),
('P014', 'Gorra Club', 'GorraClub.jpg', 'Accesorios', NULL, 'Gorro', NULL, 34, 16, 'T007', 'A007'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 13, 'T001', 'A001'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 22, 'T002', 'A002'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 0, 'T003', 'A003'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 11, 'T004', 'A004'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 8, 'T005', 'A005'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 0, 'T006', 'A006'),
('P015', 'Gorro Peak Beanie', 'GorroPeakBeanie.jpg', 'Accesorios', NULL, 'Gorro', NULL, 12.9, 1, 'T007', 'A007'),
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
('P024', 'Pantalon Largo Oversize', 'PantalonLargoOversize.jpg', 'Ropa', 'Pantalon_largo', NULL, 'S', 45, 1, 'T007', 'A007');

--
-- Disparadores `productos`
--
DELIMITER $$
CREATE TRIGGER `before_insert_producto` BEFORE INSERT ON `productos` FOR EACH ROW BEGIN
    IF NEW.stock = 0 THEN
        SET NEW.talla = NULL;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `before_update_producto` BEFORE UPDATE ON `productos` FOR EACH ROW BEGIN
    IF NEW.stock = 0 THEN
        SET NEW.talla = NULL;
    END IF;
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
('T007', 'Nike Store Berlin', 'normal', 'Kurfürstendamm, 101', 'Berlín', 'Alemania', 302345678, '{\"lunes\": \"10:00-19:00\", \"jueves\": \"10:00-19:00\", \"martes\": \"10:00-19:00\", \"domingo\": \"Cerrado\", \"sábado\": \"10:00-18:00\", \"viernes\": \"10:00-19:00\", \"miércoles\": \"10:00-19:00\"}');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacenes`
--
ALTER TABLE `almacenes`
  ADD PRIMARY KEY (`id_almacen`),
  ADD KEY `id_almacen` (`id_almacen`),
  ADD KEY `fk_almacen_tienda` (`id_tienda`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`,`id_tienda`,`id_almacen`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `fk_tienda` (`id_tienda`),
  ADD KEY `fk_almacen` (`id_almacen`);

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
  ADD CONSTRAINT `fk_almacen` FOREIGN KEY (`id_almacen`) REFERENCES `almacenes` (`id_almacen`),
  ADD CONSTRAINT `fk_tienda` FOREIGN KEY (`id_tienda`) REFERENCES `tiendas` (`id_tienda`),
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tiendas` (`id_tienda`),
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`id_almacen`) REFERENCES `almacenes` (`id_almacen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
