-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gerenciadordetarefas
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `meta`
--

DROP TABLE IF EXISTS `meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(25) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `tags` varchar(200) DEFAULT NULL,
  `prioridade` int(1) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `meta_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meta`
--

LOCK TABLES `meta` WRITE;
/*!40000 ALTER TABLE `meta` DISABLE KEYS */;
INSERT INTO `meta` VALUES (1,'Estudar fotografia','Aprender técnicas de enquadramento e etc.','#photo',4,0,1),(2,'Estudar arranjo','Criar composições com técnicas de arranjadores renascentistas.','arranjo',2,0,1),(3,'Estudar origem do Design','Como e poque o design é tão importante atualmente','design',1,1,2),(4,'Pensar na logo ABC','Empresa que trabalho com crianças de 3 a 10 anos.','design',5,1,2),(5,'Divulgar page no FB','Criar cartaz para divulgar os produtos oferecidos.','design',3,0,2),(6,'Entender método sort','Futuramente implementar o método no algoritmo de ordenação de arranjos.','back-end',2,0,2),(7,'Manter na Dieta','Comer só frutas, verduras e legumes','alimentação do bem',5,0,3),(8,'Ver benefícios da cover','Perceber as utilidades do legume e aplicar em receitas.','cover',4,1,3),(9,'Analisar vitaminas','Montar cardápio a partir da análise das vitaminas encontrada nos alimentos.','vitaminas',3,1,3),(10,'Cultivar a própria horta','Alimentos naturais são mais saudáveis que industrializados.','horta do bem',1,0,3),(11,'Vitamina do abacate','Estudar a nova receita da vatimina da fruta ao leite.','abacate do bem',3,0,3),(12,'Estudar canto','Hobbie de cantar com os amigos no karaoke. Músicas clássicas do MPB.','canto, mpb',4,0,3);
/*!40000 ALTER TABLE `meta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-21 22:28:57
