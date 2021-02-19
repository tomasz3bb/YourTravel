-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 17 Lut 2021, 09:09
-- Wersja serwera: 10.4.17-MariaDB
-- Wersja PHP: 7.3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `yourtravel`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `torder`
--

CREATE TABLE `torder` (
  `id` int(11) NOT NULL,
  `price` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `torder`
--

INSERT INTO `torder` (`id`, `price`, `status`, `user_id`) VALUES
(1, 1360, 'ENDED', 1),
(2, 4566, 'ACCEPTED', 1),
(3, 663, 'ENDED', 1),
(4, 1666, 'ENDED', 2),
(5, 3706, 'ACCEPTED', 1),
(6, 340, 'ENDED', 1),
(7, 356.5, 'ENDED', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `torderposition`
--

CREATE TABLE `torderposition` (
  `id` int(11) NOT NULL,
  `pieces` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `tour_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `torderposition`
--

INSERT INTO `torderposition` (`id`, `pieces`, `order_id`, `tour_id`) VALUES
(1, 4, 1, 2),
(2, 6, 2, 2),
(3, 1, 2, 4),
(4, 2, 2, 3),
(5, 1, 3, 3),
(6, 2, 4, 3),
(7, 1, 4, 2),
(8, 2, 5, 3),
(9, 7, 5, 2),
(10, 1, 6, 2),
(11, 1, 7, 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `torder_torderposition`
--

CREATE TABLE `torder_torderposition` (
  `torder_id` int(11) NOT NULL,
  `positions_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `torder_torderposition`
--

INSERT INTO `torder_torderposition` (`torder_id`, `positions_id`) VALUES
(1, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 5),
(4, 6),
(4, 7),
(5, 8),
(5, 9),
(6, 10),
(7, 11);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ttour`
--

CREATE TABLE `ttour` (
  `id` int(11) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `price` double NOT NULL,
  `seats` int(11) NOT NULL,
  `startDate` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `ttour`
--

INSERT INTO `ttour` (`id`, `country`, `endDate`, `price`, `seats`, `startDate`, `title`) VALUES
(2, 'Egipt', '2021-02-14', 340, 454, '2021-02-10', 'Szlakiem faraonów'),
(3, 'Austria', '2021-02-10', 663, 85, '2021-01-27', 'Alpy'),
(4, 'USA', '2021-02-07', 1200, 10, '2021-01-25', 'Kalifornia'),
(6, 'Włochy', '2021-02-24', 356.5, 20, '2021-02-10', 'Rzym i Wenecja');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuser`
--

CREATE TABLE `tuser` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `tuser`
--

INSERT INTO `tuser` (`id`, `login`, `pass`, `role`) VALUES
(1, 'admin', 'admin', 'ADMIN'),
(2, 'tomek', 'tomek2', 'USER'),
(5, 'admin2', 'admin2', 'USER'),
(4, 'logintest', 'passtest', 'USER');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `torder`
--
ALTER TABLE `torder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi0sl4qov8ir81scpposomkot4` (`user_id`);

--
-- Indeksy dla tabeli `torderposition`
--
ALTER TABLE `torderposition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj462bcsf63kvrcwt4em8wg2sn` (`order_id`),
  ADD KEY `FKm72rb1dl95bxjm1sow417tvv9` (`tour_id`);

--
-- Indeksy dla tabeli `torder_torderposition`
--
ALTER TABLE `torder_torderposition`
  ADD PRIMARY KEY (`torder_id`,`positions_id`),
  ADD UNIQUE KEY `UK_h6sm1jt33ofi8cyl668ho17uy` (`positions_id`);

--
-- Indeksy dla tabeli `ttour`
--
ALTER TABLE `ttour`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `torder`
--
ALTER TABLE `torder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `torderposition`
--
ALTER TABLE `torderposition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `ttour`
--
ALTER TABLE `ttour`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `tuser`
--
ALTER TABLE `tuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
