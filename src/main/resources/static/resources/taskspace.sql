-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 27, 2019 at 01:45 AM
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
  `PROJECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `MEMBERS` varchar(255) NOT NULL,
  PRIMARY KEY (`PROJECT_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`PROJECT_ID`, `NAME`, `DESCRIPTION`, `MEMBERS`) VALUES
(1, 'Test', 'Testing Adding Project', 'Thomas, Bob'),
(2, 'Test Project 2', 'Testing Adding New Project', 'Thomas'),
(3, 'Showing Jasmine', 'Testing Testing 123', 'Jasmine,Thomas, Bubbles'),
(4, 'Testing Modal Adding Project', 'Test 32', 'Test, Thomas');

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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`TASK_ID`, `PRIORITY`, `DESCRIPTION`, `ASSIGNED_TO`, `PROJECT_ID`, `TASK_COLOR`) VALUES
(1, 3, 'Another Test for Adding', 'Thomas', 10, '#4A9FF9'),
(2, 5, 'Test Adding Task', 'Thomas', 10, '#4A9FF9'),
(3, 3, 'Test 4', 'Thomas', 10, '#4A9FF9'),
(4, 3, 'Test Adding Task to Project', 'Bob', 10, '#4A9FF9'),
(5, 2, 'Another Test for Adding', 'Bob', 10, '#4A9FF9'),
(6, 3, 'Another Test for Adding', 'Bob', 1, '#4A9FF9'),
(7, 4, 'Test 4', 'Thomas', 1, '#4A9FF9'),
(8, 4, 'Test Adding Task to Project', 'Thomas', 1, '#4A9FF9'),
(9, 1, 'dcscc', 'Bob', 1, '#4A9FF9'),
(10, 1, 'Another Test', 'Bob', 2, '#4A9FF9'),
(11, 5, 'Cuddling Bubbles', 'Jasmine', 3, '#4A9FF9'),
(12, 1, '', '', 1, '#4A9FF9');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
