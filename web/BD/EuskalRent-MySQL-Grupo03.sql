-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: euskalrent03
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apartamento`
--

DROP TABLE IF EXISTS `apartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartamento` (
  `IdApartamento` int(11) NOT NULL AUTO_INCREMENT,
  `IdEmail` varchar(255) NOT NULL,
  `TipoPropiedad` varchar(255) DEFAULT NULL,
  `NumeroHuespedes` int(11) NOT NULL,
  `Barrio` varchar(255) DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `Tarifa` float NOT NULL,
  `TipoCancelacion` varchar(255) DEFAULT NULL,
  `fechaDisponibilidad` datetime DEFAULT NULL,
  `imgApartamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdApartamento`),
  KEY `FKApartament529612` (`IdEmail`),
  CONSTRAINT `FKApartament529612` FOREIGN KEY (`IdEmail`) REFERENCES `usuario` (`IdEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartamento`
--

LOCK TABLES `apartamento` WRITE;
/*!40000 ALTER TABLE `apartamento` DISABLE KEYS */;
INSERT INTO `apartamento` VALUES (1,'laprimaera@hotmail.com','Apartamento',8,'Zabalgana','vcb',45,NULL,'2016-01-01 20:47:23',NULL),(3,'elPrimero@hotmail.com','Chalet',6,'Zabalgana',' calle Nieves Cano',80.5,NULL,'2016-01-01 21:12:50',NULL),(4,'elSegundo@hotmail.com','Apartamento',4,'Zabalgana',' Viena Kalea Vitoria ',100,'Flexible','2016-01-01 21:12:53',NULL),(5,'laSegunda@hotmail.com','Chalet',10,'Aranbizkarra',' Zalburu Kalea Aranbizkarra',120,'Premium',NULL,NULL),(6,'aaaa@aaa.aa','Chalet',6,'Aranbizkarra','qqqq',8.2,'Premium',NULL,NULL),(7,'lapruebadef@hotmail.com','Apartamento',10,'Zabalgana','fgnfgnnull',20,'Flexible','2016-01-28 00:00:00',NULL),(8,'pruebaFinal@gmail.com','Chalet',10,'Zabalgana','ahedo del butron',2,'Flexible','2016-01-23 00:00:00',NULL);
/*!40000 ALTER TABLE `apartamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentabancaria`
--

DROP TABLE IF EXISTS `cuentabancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentabancaria` (
  `IdCuenta` int(11) NOT NULL AUTO_INCREMENT,
  `IdEmail` varchar(255) NOT NULL,
  `Saldo` float NOT NULL,
  PRIMARY KEY (`IdCuenta`,`IdEmail`),
  KEY `FKCuentaBanc914323` (`IdEmail`),
  CONSTRAINT `FKCuentaBanc914323` FOREIGN KEY (`IdEmail`) REFERENCES `usuario` (`IdEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentabancaria`
--

LOCK TABLES `cuentabancaria` WRITE;
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` VALUES (1,'lapruebadef@hotmail.com',1060),(2,'pruebaFinal@gmail.com',670);
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `IdReserva` int(11) NOT NULL AUTO_INCREMENT,
  `IdEmail` varchar(255) NOT NULL,
  `IdApartamento` int(11) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinal` date NOT NULL,
  PRIMARY KEY (`IdReserva`),
  KEY `FKReserva349891` (`IdApartamento`),
  KEY `FKReserva883948` (`IdEmail`),
  CONSTRAINT `FKReserva349891` FOREIGN KEY (`IdApartamento`) REFERENCES `apartamento` (`IdApartamento`),
  CONSTRAINT `FKReserva883948` FOREIGN KEY (`IdEmail`) REFERENCES `usuario` (`IdEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'pruebaFinal@gmail.com',1,'2016-01-24','2016-01-30'),(2,'pruebaFinal@gmail.com',7,'2016-02-29','2016-03-03');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `IdEmail` varchar(255) NOT NULL DEFAULT '',
  `Nombre` varchar(255) DEFAULT NULL,
  `Apellido` varchar(255) DEFAULT NULL,
  `Contraseña` varchar(255) DEFAULT NULL,
  `NumeroTelefono` int(11) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT 'NULL',
  `imgUsuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('aaaa@aaa.aa','aaa','aaa','aaaa',699844487,'',NULL),('elPrimero@hotmail.com','Luis','Lopez Perez','soyelprimero',636656232,'',NULL),('elSegundo@hotmail.com','Joseba','Sedano Gallo','Platon',645478948,'',NULL),('laprimaera@hotmail.com','Pepa','Pig','1234',679632146,'calle 9',NULL),('lapruebadef@hotmail.com','pruebA','PRUEBA','prueba',669663665,'2365236',NULL),('laSegunda@hotmail.com','Edurne','Gallo Senarriaga','tato',632478952,'',NULL),('pruebaFinal@gmail.com','Saioa','Montero Cueva','1234',663658695,'Ahedo del butron ',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-23 17:03:29
