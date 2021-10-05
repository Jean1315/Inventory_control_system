-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Out-2021 às 00:06
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `inventorycontrolbd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cor_produto`
--

CREATE TABLE `cor_produto` (
  `id` int(11) NOT NULL,
  `cor_descricao` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cor_produto`
--

INSERT INTO `cor_produto` (`id`, `cor_descricao`) VALUES
(1, 'Azul'),
(2, 'Vermelho'),
(3, 'Amarelo'),
(4, 'Verde'),
(5, 'Roxo'),
(6, 'Laranja'),
(7, 'Preto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca_produto`
--

CREATE TABLE `marca_produto` (
  `id` int(11) NOT NULL,
  `descricao_marca` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `marca_produto`
--

INSERT INTO `marca_produto` (`id`, `descricao_marca`) VALUES
(1, 'Nike'),
(2, 'Adidas'),
(3, 'Lacoste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `movimentacao`
--

CREATE TABLE `movimentacao` (
  `id` int(11) NOT NULL,
  `operacao` varchar(15) NOT NULL,
  `id_produto` varchar(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `movimentacao`
--

INSERT INTO `movimentacao` (`id`, `operacao`, `id_produto`, `quantidade`, `data`) VALUES
(1, 'entrada', '11', 12, '2021-09-26'),
(2, 'saida', '11', 1, '2021-09-26'),
(3, 'entrada', '12', 12, '2021-09-26'),
(4, 'entrada', '14', 50, '2021-09-26'),
(5, 'saida', '14', 1, '2021-09-26'),
(10, 'entrada', '13', 1, '2021-10-05'),
(11, 'entrada', '18', 1, '2021-10-05'),
(12, 'saida', '18', 1, '2021-10-05');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `serial_produto` int(20) NOT NULL,
  `descricao_produto` varchar(100) NOT NULL,
  `preco_produto` decimal(10,2) NOT NULL,
  `id_cor` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `serial_produto`, `descricao_produto`, `preco_produto`, `id_cor`, `id_marca`) VALUES
(11, 4, 'Sapato', '50.00', 1, 1),
(12, 1, 'Camisa', '75.00', 2, 2),
(13, 3, 'Camisa Social', '100.00', 7, 3),
(14, 5, 'Tenis', '150.00', 6, 1),
(18, 10203040, 'Relogio', '100.00', 1, 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cor_produto`
--
ALTER TABLE `cor_produto`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `marca_produto`
--
ALTER TABLE `marca_produto`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_produtos_cor` (`id_cor`),
  ADD KEY `fk_produtos_marca` (`id_marca`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cor_produto`
--
ALTER TABLE `cor_produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `marca_produto`
--
ALTER TABLE `marca_produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produtos_cor` FOREIGN KEY (`id_cor`) REFERENCES `cor_produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produtos_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca_produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
