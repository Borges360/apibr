CREATE TABLE `cidade` (
  `ID_CIDADE` int(11) NOT NULL,
  `CIDADE` varchar(100) DEFAULT NULL,
  `UF` varchar(100) DEFAULT NULL,
  `COD_IBGE` varchar(100) DEFAULT NULL,
  `AREA` double DEFAULT NULL,
  PRIMARY KEY (`ID_CIDADE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `endereco` (
    `CEP` varchar(8) NOT NULL,
    `LOGRADOURO` varchar(100) DEFAULT NULL,
    `TIPO_LOGRADOURO` varchar(100) DEFAULT NULL,
    `COMPLEMENTO` varchar(100) DEFAULT NULL,
    `LOCAL` varchar(100) DEFAULT NULL,
    `ID_CIDADE` int(11) NOT NULL,
    `ID_BAIRRO` int(11) DEFAULT NULL,
    PRIMARY KEY (`CEP`),
    KEY `endereco_FK` (`ID_CIDADE`),
    CONSTRAINT `endereco_FK` FOREIGN KEY (`ID_CIDADE`) REFERENCES `cidade` (`ID_CIDADE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;