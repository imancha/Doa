-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 17, 2014 at 02:27 AM
-- Server version: 5.5.37-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Doa`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookmark`
--

CREATE TABLE IF NOT EXISTS `bookmark` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `arab` text NOT NULL,
  `terjemah` text NOT NULL,
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doa`
--

CREATE TABLE IF NOT EXISTS `doa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `arab` text CHARACTER SET utf8 NOT NULL,
  `terjemah` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nama` (`nama`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `doa`
--

INSERT INTO `doa` (`id`, `nama`, `arab`, `terjemah`) VALUES
(1, 'Doa Sebelum Makan', 'اللهم بارك لنا فيما رزقتنا وقنا عذاب النار', 'Ya Allah, berkahilah kami terhadap apa yang telah Engkau rizqikan kepada kami dan jagalah kami dari siksa api neraka.'),
(2, 'Doa Setelah Makan', 'الحمدلله الذي اطعمنا وسقانا وجعلنا من المسلمين', 'Segala puji bagi Allah yang telah memberikan kami makan dan ... dan menjadikan kami dari orang-orang muslim.'),
(3, 'Doa Sebelum Tidur', 'بسمك اللهم احيا وبسمك اموت', 'Dengan menyebut Nama-Mu Ya Allah saya hidup dan dengan menyebut Nama-Mu saya mati.'),
(4, 'Doa Bangun Tidur', 'الحمدلله الذي احيانا بعد ما اماتنا واليه النشور', 'Segala puji bagi Allah yang telah menghidupkan kami setelah mematikan kami dan kepada-Nya lah kami kembali.');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookmark`
--
ALTER TABLE `bookmark`
  ADD CONSTRAINT `bookmark_ibfk_1` FOREIGN KEY (`id`) REFERENCES `doa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
