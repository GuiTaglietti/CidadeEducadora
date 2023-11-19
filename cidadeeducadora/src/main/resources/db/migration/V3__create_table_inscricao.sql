CREATE TABLE `inscricao`(
    `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `data` datetime(6) NOT NULL,
    `curso_id` bigint NOT NULL,
    `usuario_id` bigint NOT NULL,
    FOREIGN KEY(`curso_id`) REFERENCES `curso`(`id`),
    FOREIGN KEY(`usuario_id`) REFERENCES `usuario`(`id`)
);