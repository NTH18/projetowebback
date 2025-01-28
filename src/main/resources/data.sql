CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         nome VARCHAR(255) NOT NULL,
                         senha VARCHAR(255) NOT NULL
);

INSERT INTO usuario (email, nome, senha) VALUES
                                             ('joao.silva@email.com', 'João Silva', 'senha123'),
                                             ('maria.santos@email.com', 'Maria Santos', 'senha456'),
                                             ('carlos.almeida@email.com', 'Carlos Almeida', 'senha789');
