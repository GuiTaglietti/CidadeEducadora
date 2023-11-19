CREATE TABLE `curso`(
    `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `data` date NOT NULL,
    `data_fim` datetime(6) NOT NULL,
    `data_inicio` datetime(6) NOT NULL,
    `descricao` varchar(255) DEFAULT NULL,
    `nome` varchar(255) NOT NULL,
    `status` enum('ABERTO','CANCELADO','ENCERRADO','PREVISTO') DEFAULT NULL
);