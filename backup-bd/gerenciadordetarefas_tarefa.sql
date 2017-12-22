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
-- Table structure for table `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(25) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `tags` varchar(200) DEFAULT NULL,
  `prioridade` int(1) NOT NULL,
  `data_tarefa` varchar(10) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `tarefa_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefa`
--

LOCK TABLES `tarefa` WRITE;
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` VALUES (1,'projeto poo','Projeto valendo a nota da segunda unidade de POO.','#workhard',5,'22/12/2017',0,1),(2,'projeto ihc','Projeto da prodessora Dani, segundo bimestre.','#UX',4,'22/12/2017',1,1),(3,'prova de algoritmo','Segunda avaliação do professor jorgiano','#backtracking',3,'26/12/2017',0,1),(4,'montar escalas maiores','Selecionar as escalas mais importantes para apresentar no recital de clarinete.','#music',5,'25/12/2017',0,1),(5,'criar interface do app','Pensar e desenvoler uma tela intuitiva para o aplicativo que está sendo desenvolvido.','#app',1,'20/12/2018',0,1),(6,'finalizar projeto de ihc','Apenas desenvolver a última interfacedo aplicativo.','ihc',4,'22/12/2017',0,2),(7,'criar logo do wtads','Se reunir com o pessoal para pensar na logo e na identidade visual.','#design',5,'18/12/2019',0,2),(8,'montar cardápio da irmã','Colocar proteínas, carboidratos, e menos lipídios.','AlimentaçãoSaudável',4,'24/12/2017',0,3),(9,'nova receita inovadora','Mostrar ao chefe a novo receita baseada no caldo do alho poró.','alho poró',3,'21/12/2017',1,3);
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-21 22:28:56
