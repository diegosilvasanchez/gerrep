--
-- Create schema toga_db
--

CREATE DATABASE IF NOT EXISTS toga_db;
USE toga_db;

--
-- Definition of table `pessoa` MAPPED
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(80) NOT NULL,
  `apelido` varchar(80) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `genero` varchar(1),
  `data_nascimento` date,
  `tipo_documento` varchar(40),
  `numero_documento` varchar(40),
  `email` varchar(80),
  `telefone` varchar(40),
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


--
-- Definition of table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(11) NOT NULL,
  `endereco` varchar(80) NOT NULL,
  `numero` varchar(10),
  `complemento` varchar(40),
  `bairro` varchar(40),
  `cidade` varchar(40),
  `estado` varchar(2),
  `pais` varchar(40),
  `cep` varchar(10), 
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_endereco`),
  KEY `endereco_pessoa` (`id_pessoa`),
  CONSTRAINT `endereco_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


--
-- Definition of table `dado_bancario`
--

DROP TABLE IF EXISTS `dado_bancario`;
CREATE TABLE `dado_bancario` (
  `id_dado_bancario` int(11) NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(11) NOT NULL,
  `apelido` varchar(80),
  `tipo` varchar(20) NOT NULL,
  `codigo_banco` varchar(20) NOT NULL,
  `agencia` varchar(20),
  `conta` varchar(20),
  `principal` varchar(1),
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_dado_bancario`),
  KEY `dadobancario_pessoa` (`id_pessoa`),
  CONSTRAINT `dadobancario_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Definition of table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `id_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `id_republica` int(11) NOT NULL,
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_aluno`),
  KEY `aluno_pessoa` (`id_pessoa`),
  KEY `aluno_endereco` (`id_endereco`),
  KEY `aluno_republica` (`id_republica`),
  CONSTRAINT `aluno_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  CONSTRAINT `aluno_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`),
  CONSTRAINT `aluno_republica` FOREIGN KEY (`id_republica`) REFERENCES `republica` (`id_republica`)
)  ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


--
-- Definition of table `republica`
--

DROP TABLE IF EXISTS `republica`;
CREATE TABLE `republica` (
  `id_republica` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `descricao` varchar(80),
  `genero` varchar(1),
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_republica`),
  KEY `republica_pessoa` (`id_pessoa`),
  KEY `republica_endereco` (`id_endereco`),
  CONSTRAINT `republica_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  CONSTRAINT `republica_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`)
)  ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;



--
-- Definition of table `contrato_locacao`
--

DROP TABLE IF EXISTS `contrato_locacao`;
CREATE TABLE `contrato_locacao` (
  `id_contrato_locacao` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_republica` int(11) NOT NULL,
  `observacao` varchar(200),
  `data_inicio` date, 
  `data_fim` date, 
  `valor` float,
  `dia_vencimento` int(1),
  `status` varchar(20),
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_contrato_locacao`),
  KEY `contratolocacao_republica` (`id_republica`),
  KEY `contratolocacao_aluno` (`id_aluno`),
  CONSTRAINT `contratolocacao_republica` FOREIGN KEY (`id_republica`) REFERENCES `republica` (`id_republica`),
  CONSTRAINT `contratolocacao_aluno` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`)
)  ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


--
-- Definition of table `contrato_locacao`
--

DROP TABLE IF EXISTS `prestador`;
CREATE TABLE `prestador` (
  `id_prestador` int(11) NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `ramo_atividade` varchar(40), 
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80)
  PRIMARY KEY (`id_prestador`),
  KEY `prestador_pessoa` (`id_pessoa`),
  KEY `prestador_endereco` (`id_endereco`),
  CONSTRAINT `prestador_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  CONSTRAINT `prestador_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`)
)  ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


--
-- Definition of table `servico`
--

DROP TABLE IF EXISTS `servico`;
CREATE TABLE `servico` (
  `id_servico` int(11) NOT NULL AUTO_INCREMENT,
  `id_prestador` int(11) NOT NULL,
  `id_republica` int(11) NOT NULL,
  `descricao` varchar(40),  
  `valor` float,  
  `status` varchar(40), 
  `data_execucao` date, 
  `ativo` int(1),
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_servico`),
  KEY `servico_prestador` (`id_prestador`),
  KEY `servico_republica` (`id_republica`),
  CONSTRAINT `servico_republica` FOREIGN KEY (`id_republica`) REFERENCES `republica` (`id_republica`),
  CONSTRAINT `servico_prestador` FOREIGN KEY (`id_prestador`) REFERENCES `prestador` (`id_prestador`)
)  ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


--
-- Definition of table `despesas`
--

DROP TABLE IF EXISTS `despesa`;
CREATE TABLE `despesa` (
  `id_despesa` int(11) NOT NULL AUTO_INCREMENT,  
  `id_republica` int(11) NOT NULL,
  `ativo` int(1),
  `descricao` varchar(40),   
  `valor` float,
  `tipo_frequencia` varchar(40), 
  `status` varchar(40), 
  `data_execucao` date, 
  `data_vencimento` date, 
  `data_criacao` date, 
  `usuario_criacao` varchar(80),
  `data_modificacao` date, 
  `usuario_modificacao` varchar(80),
  PRIMARY KEY (`id_despesa`),
  KEY `despesa_republica` (`id_republica`),
  CONSTRAINT `despesa_republica` FOREIGN KEY (`id_republica`) REFERENCES `republica` (`id_republica`)
)  ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


----- POPULAR TABELA PESSOA

insert into gerrep_db.pessoa
values
(1, 'teste', 1, sysdate(), sysdate(), sysdate(), 'teste@teste.com', 'F', 
'teste@12345', 'Teste Teste', '32928145885', 'ROLE_ADMIN', 
'06883b51a60416797a14083bb4a3903735211cac', '432432432', 'F', 'CPF', 'teste', 'teste');