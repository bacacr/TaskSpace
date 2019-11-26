-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 26, 2019 at 10:18 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taskspace`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `projectID` int(11) NOT NULL,
  `projectName` varchar(255) NOT NULL,
  `projectDescription` varchar(255) NOT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `TASK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRIORITY` int(11) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `ASSIGNED_TO` varchar(255) NOT NULL,
  `PROJECT_ID` int(11) NOT NULL,
  `TASK_COLOR` varchar(50) NOT NULL,
  PRIMARY KEY (`TASK_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`TASK_ID`, `PRIORITY`, `DESCRIPTION`, `ASSIGNED_TO`, `PROJECT_ID`, `TASK_COLOR`) VALUES
(1, 3, 'Another Test for Adding', 'Thomas', 10, '#4A9FF9'),
(2, 5, 'Test Adding Task', 'Thomas', 10, '#4A9FF9'),
(3, 3, 'Test 4', 'Thomas', 10, '#4A9FF9');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
