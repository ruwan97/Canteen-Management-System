-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 05, 2021 at 06:26 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `ad_user_account_create_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ad_user_account_create_procedure` (IN `id` VARCHAR(6), IN `name` VARCHAR(255), IN `email` VARCHAR(100), IN `role` INT(1))  BEGIN
INSERT INTO `user`(`user_id`, `user_name`, `user_email`, `user_role`) VALUES (id , name, email, role);
END$$

DROP PROCEDURE IF EXISTS `ad_user_account_update_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ad_user_account_update_procedure` (IN `id` VARCHAR(6), IN `name` VARCHAR(255), IN `email` VARCHAR(100), IN `role` INT(1))  BEGIN
UPDATE `user` 
SET 
`user_id` = id, 
`user_name` = name, 
`user_email` = email, 
`user_role` = role
WHERE `user_id` = id;
END$$

DROP PROCEDURE IF EXISTS `delete_inventory_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_inventory_procedure` (IN `id` VARCHAR(6))  BEGIN
DELETE FROM `inventory` WHERE `inv_id` = id;
END$$

DROP PROCEDURE IF EXISTS `delete_item_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_item_procedure` (IN `itm_id` VARCHAR(6))  BEGIN
DELETE FROM `item` WHERE `item_id` = itm_id;
END$$

DROP PROCEDURE IF EXISTS `delete_order_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_order_procedure` (IN `or_id` VARCHAR(6))  BEGIN
DELETE FROM `orders` WHERE `order_id` = or_id;
END$$

DROP PROCEDURE IF EXISTS `insert_inventory_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_inventory_procedure` (IN `itm_id` VARCHAR(6), IN `quantity` INT(5))  BEGIN
INSERT INTO `inventory`(`item_id`, `quantity`) VALUES (itm_id, quantity);
END$$

DROP PROCEDURE IF EXISTS `insert_item_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_item_procedure` (IN `itm_id` VARCHAR(6), IN `itm_name` VARCHAR(255), IN `price` FLOAT(2), IN `image` VARCHAR(255))  BEGIN
INSERT INTO `item`(`item_id`, `item_name`, `unit_price`, `item_image`) VALUES (itm_id , itm_name, price, image);
END$$

DROP PROCEDURE IF EXISTS `insert_order_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_order_procedure` (IN `u_id` VARCHAR(6), IN `itm_id` VARCHAR(6), IN `quantity` INT(5))  BEGIN
DECLARE price FLOAT(2);
DECLARE total FLOAT(2); 
SELECT unit_price INTO price FROM item WHERE item_id = itm_id;
SET total = price * quantity;
INSERT INTO orders (`user_id`, `item_id`, `quantity`, `order_amount`) VALUES (u_id, itm_id, quantity, total);
END$$

DROP PROCEDURE IF EXISTS `insert_transaction_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_transaction_procedure` (IN `or_id` INT)  BEGIN
DECLARE u_id VARCHAR(6);
DECLARE itm_id VARCHAR(6);
DECLARE tr_date DATE;
DECLARE total FLOAT(2); 
SELECT `user_id`, `item_id`, curdate(), `order_amount` INTO u_id, itm_id, tr_date, total
FROM `orders` 
WHERE `order_id` = or_id;
INSERT INTO `transaction`(`order_id`, `user_id`, `item_id`, `order_amount`, `transaction_date`) VALUES (or_id, u_id, itm_id, total, tr_date);
END$$

DROP PROCEDURE IF EXISTS `update_inventory_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_inventory_procedure` (IN `id` INT, IN `itm_id` VARCHAR(6), IN `quantity` INT(5))  BEGIN
UPDATE `inventory` 
SET 
`item_id` = itm_id,
`quantity` = quantity
WHERE `inv_id` = id;
END$$

DROP PROCEDURE IF EXISTS `update_item_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_item_procedure` (IN `itm_id` VARCHAR(6), IN `itm_name` VARCHAR(255), IN `price` FLOAT(2), IN `image` VARCHAR(255))  BEGIN
UPDATE `item` 
SET 
`item_id` = itm_id,
`item_name` = itm_name,
`unit_price` = price,
`item_image` = image 
WHERE `item_id` = itm_id;
END$$

DROP PROCEDURE IF EXISTS `user_account_create_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_account_create_procedure` (IN `id` VARCHAR(6), IN `name` VARCHAR(255), IN `email` VARCHAR(100), IN `password` VARCHAR(50), IN `role` INT(1), IN `contact` INT(10), IN `image` VARCHAR(255))  BEGIN
INSERT INTO `user`(`user_id`, `user_name`, `user_email`, user_password, `user_role`, `user_contact`, `user_image`) VALUES (id , name, email, password, role, contact, image);
END$$

DROP PROCEDURE IF EXISTS `user_account_delete_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_account_delete_procedure` (IN `id` VARCHAR(6))  BEGIN
DELETE FROM `user` WHERE `user_id` = id;
END$$

DROP PROCEDURE IF EXISTS `user_account_update_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_account_update_procedure` (IN `id` VARCHAR(6), IN `name` VARCHAR(255), IN `email` VARCHAR(100), IN `password` VARCHAR(50), IN `role` INT(1), IN `contact` INT(10), IN `image` VARCHAR(255))  BEGIN
UPDATE `user` 
SET 
`user_id` = id, 
`user_name` = name, 
`user_email` = email, 
`user_password` = password,
`user_role` = role, 
`user_contact` = contact,
`user_image` = image
WHERE `user_id` = id;
END$$

DROP PROCEDURE IF EXISTS `user_view_invoice_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_view_invoice_procedure` (IN `o_id` VARCHAR(6))  BEGIN
SELECT o.`user_id`, o.`item_id`, i.`item_name`, i.`unit_price`, o.`quantity`, o.`order_amount`, o.`date_and_time`
FROM `orders` o, `item` i  
WHERE  o.`item_id` = i.`item_id` AND o.`order_id` = o_id;
END$$

DROP PROCEDURE IF EXISTS `user_view_orders_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_view_orders_procedure` (IN `u_id` VARCHAR(6))  BEGIN
SELECT o.`user_id`, o.`item_id`, i.`item_name`, i.`unit_price`, o.`quantity`, o.`order_amount`, o.`date_and_time`, i.`item_image`
FROM `orders` o, `item` i  
WHERE  o.`item_id` = i.`item_id` AND o.`user_id` = u_id;
END$$

--
-- Functions
--
DROP FUNCTION IF EXISTS `calculate_daily_transactions_count_function`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calculate_daily_transactions_count_function` () RETURNS INT(11) BEGIN
DECLARE daily_transactions_count INT;
SELECT COUNT(transaction_id) INTO daily_transactions_count
FROM `transaction` 
WHERE DATE(`transaction_date`) = DATE(NOW()) 
GROUP BY `transaction_date`;
RETURN (daily_transactions_count);
END$$

DROP FUNCTION IF EXISTS `calculate_total_transaction_amount_function`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calculate_total_transaction_amount_function` () RETURNS FLOAT BEGIN
DECLARE transactions_amount FLOAT DEFAULT 0.0;
SELECT SUM(order_amount) INTO transactions_amount 
FROM `transaction` 
WHERE DATE(`transaction_date`) = DATE(NOW()) 
GROUP BY `transaction_date`;
RETURN (transactions_amount);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `ad_view_inventory`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `ad_view_inventory`;
CREATE TABLE IF NOT EXISTS `ad_view_inventory` (
`inv_id` int(11)
,`item_id` varchar(6)
,`item_name` varchar(255)
,`unit_price` float
,`quantity` int(5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `ad_view_orders`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `ad_view_orders`;
CREATE TABLE IF NOT EXISTS `ad_view_orders` (
`order_id` int(11)
,`user_id` varchar(6)
,`item_id` varchar(6)
,`item_name` varchar(255)
,`unit_price` float
,`quantity` int(5)
,`order_amount` float
,`date_and_time` timestamp
,`item_image` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `ad_view_users`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `ad_view_users`;
CREATE TABLE IF NOT EXISTS `ad_view_users` (
`user_id` varchar(6)
,`user_name` varchar(255)
,`user_email` varchar(100)
,`user_password` varchar(50)
,`user_role` int(1)
,`user_contact` int(10)
,`user_image` varchar(255)
);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE IF NOT EXISTS `inventory` (
  `inv_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(6) DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  PRIMARY KEY (`inv_id`),
  KEY `item_id` (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inv_id`, `item_id`, `quantity`) VALUES
(31, 'itm005', 385),
(30, 'itm004', 145),
(29, 'itm003', 610),
(28, 'itm002', 455),
(27, 'itm001', 186),
(33, 'itm006', 150),
(34, 'itm007', 459);

--
-- Triggers `inventory`
--
DROP TRIGGER IF EXISTS `after_insert_inventory_trigger`;
DELIMITER $$
CREATE TRIGGER `after_insert_inventory_trigger` AFTER INSERT ON `inventory` FOR EACH ROW BEGIN

DECLARE iv_id INT;
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET iv_id = new.inv_id;
SET data  = CONCAT_WS(', ', new.item_id, new.quantity);
SET user = CURRENT_USER;
SET operation = 'INSERT';
SET changedat = now();

INSERT INTO inventory_log (inv_id, data, user, operation, changed_at)
VALUES
(iv_id, data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `after_update_inventory_trigger`;
DELIMITER $$
CREATE TRIGGER `after_update_inventory_trigger` AFTER UPDATE ON `inventory` FOR EACH ROW BEGIN

DECLARE iv_id INT;
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET iv_id = new.inv_id;
SET data  = CONCAT_WS(', ', new.item_id, new.quantity);
SET user = CURRENT_USER;
SET operation = 'UPDATE';
SET changedat = now();

INSERT INTO inventory_log (inv_id, data, user, operation, changed_at)
VALUES
(iv_id, data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `before_delete_inventory_trigger`;
DELIMITER $$
CREATE TRIGGER `before_delete_inventory_trigger` BEFORE DELETE ON `inventory` FOR EACH ROW BEGIN

DECLARE iv_id INT;
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET iv_id = old.inv_id;
SET data  = CONCAT_WS(', ', old.item_id, old.quantity);
SET user = CURRENT_USER;
SET operation = 'DELETE';
SET changedat = now();

INSERT INTO inventory_log (inv_id, data, user, operation, changed_at)
VALUES
(iv_id, data, user, operation, changedat);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `inventory_log`
--

DROP TABLE IF EXISTS `inventory_log`;
CREATE TABLE IF NOT EXISTS `inventory_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `inv_id` int(11) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `operation` varchar(8) DEFAULT NULL,
  `changed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_log`
--

INSERT INTO `inventory_log` (`log_id`, `inv_id`, `data`, `user`, `operation`, `changed_at`) VALUES
(11, 27, 'itm001, 200', 'root@localhost', 'INSERT', '2021-06-29 22:14:53'),
(12, 28, 'itm002, 500', 'root@localhost', 'INSERT', '2021-06-29 22:16:13'),
(13, 29, 'itm003, 650', 'root@localhost', 'INSERT', '2021-06-29 22:17:13'),
(14, 30, 'itm004, 150', 'root@localhost', 'INSERT', '2021-06-29 22:17:42'),
(15, 31, 'itm005, 400', 'root@localhost', 'INSERT', '2021-06-29 22:17:51'),
(16, 32, 'itm006, 42', 'root@localhost', 'INSERT', '2021-06-29 22:18:03'),
(17, 32, 'itm001, 50', 'root@localhost', 'UPDATE', '2021-06-29 22:19:11'),
(18, 32, 'itm001, 50', 'root@localhost', 'DELETE', '2021-06-29 22:19:30'),
(19, 29, 'itm003, 630', 'root@localhost', 'UPDATE', '2021-06-29 22:29:07'),
(20, 27, 'itm001, 175', 'root@localhost', 'UPDATE', '2021-06-29 22:30:04'),
(21, 27, 'itm001, 145', 'root@localhost', 'UPDATE', '2021-06-29 22:30:26'),
(22, 30, 'itm004, 147', 'root@localhost', 'UPDATE', '2021-06-29 22:30:58'),
(23, 31, 'itm005, 399', 'root@localhost', 'UPDATE', '2021-06-29 22:32:00'),
(24, 31, 'itm005, 395', 'root@localhost', 'UPDATE', '2021-06-29 22:32:12'),
(25, 28, 'itm002, 493', 'root@localhost', 'UPDATE', '2021-06-29 22:35:08'),
(26, 29, 'itm003, 650', 'root@localhost', 'UPDATE', '2021-06-29 22:45:00'),
(27, 27, 'itm001, 170', 'root@localhost', 'UPDATE', '2021-06-29 22:46:02'),
(28, 30, 'itm004, 144', 'root@localhost', 'UPDATE', '2021-06-29 23:11:18'),
(29, 29, 'itm003, 639', 'root@localhost', 'UPDATE', '2021-06-29 23:17:15'),
(30, 29, 'itm003, 628', 'root@localhost', 'UPDATE', '2021-06-29 23:27:34'),
(31, 29, 'itm003, 624', 'root@localhost', 'UPDATE', '2021-06-29 23:42:48'),
(32, 27, 'itm001, 200', 'root@localhost', 'UPDATE', '2021-06-30 00:08:16'),
(33, 30, 'itm004, 147', 'root@localhost', 'UPDATE', '2021-06-30 00:19:35'),
(34, 33, 'itm006, 150', 'root@localhost', 'INSERT', '2021-06-30 01:32:02'),
(35, 34, 'itm007, 460', 'root@localhost', 'INSERT', '2021-06-30 01:32:21'),
(36, 35, 'itm007, 50', 'root@localhost', 'INSERT', '2021-06-30 01:32:28'),
(37, 35, 'itm008, 500', 'root@localhost', 'UPDATE', '2021-06-30 01:33:27'),
(38, 35, 'itm008, 500', 'root@localhost', 'DELETE', '2021-06-30 01:34:14'),
(39, 33, 'itm006, 148', 'root@localhost', 'UPDATE', '2021-06-30 01:42:34'),
(40, 34, 'itm007, 457', 'root@localhost', 'UPDATE', '2021-06-30 01:46:01'),
(41, 31, 'itm005, 396', 'root@localhost', 'UPDATE', '2021-06-30 01:50:23'),
(42, 33, 'itm006, 150', 'root@localhost', 'UPDATE', '2021-06-30 02:02:07'),
(43, 34, 'itm007, 460', 'root@localhost', 'UPDATE', '2021-06-30 02:02:11'),
(44, 29, 'itm003, 622', 'root@localhost', 'UPDATE', '2021-06-30 02:04:09'),
(45, 34, 'itm007, 459', 'root@localhost', 'UPDATE', '2021-06-30 02:04:23'),
(46, 31, 'itm005, 393', 'root@localhost', 'UPDATE', '2021-06-30 02:04:39'),
(47, 28, 'itm002, 500', 'root@localhost', 'UPDATE', '2021-06-30 02:05:26'),
(48, 29, 'itm003, 626', 'root@localhost', 'UPDATE', '2021-06-30 02:07:47'),
(49, 28, 'itm002, 465', 'root@localhost', 'UPDATE', '2021-06-30 14:31:54'),
(50, 27, 'itm001, 199', 'root@localhost', 'UPDATE', '2021-06-30 14:33:02'),
(51, 29, 'itm003, 623', 'root@localhost', 'UPDATE', '2021-06-30 14:34:17'),
(52, 31, 'itm005, 389', 'root@localhost', 'UPDATE', '2021-06-30 14:59:43'),
(53, 31, 'itm005, 387', 'root@localhost', 'UPDATE', '2021-06-30 14:59:51'),
(54, 30, 'itm004, 145', 'root@localhost', 'UPDATE', '2021-06-30 15:00:24'),
(55, 31, 'itm005, 385', 'root@localhost', 'UPDATE', '2021-06-30 15:00:54'),
(56, 28, 'itm002, 460', 'root@localhost', 'UPDATE', '2021-07-01 04:23:06'),
(57, 28, 'itm002, 455', 'root@localhost', 'UPDATE', '2021-07-01 04:26:33'),
(58, 29, 'itm003, 617', 'root@localhost', 'UPDATE', '2021-07-03 00:29:46'),
(59, 29, 'itm003, 610', 'root@localhost', 'UPDATE', '2021-07-03 00:33:00'),
(60, 27, 'itm001, 186', 'root@localhost', 'UPDATE', '2021-07-03 01:38:04');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` varchar(6) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `item_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `item_name`, `unit_price`, `item_image`) VALUES
('itm003', 'apple', 22, 'images/roll.png'),
('itm008', 'cake', 18, 'Screenshot (169).png'),
('itm001', 'roll', 28, 'images/bun.png'),
('itm004', 'eggs', 22, 'images/egg.png'),
('itm005', 'bread', 55, 'images/bread.png'),
('itm006', 'buiscuit', 45, 'images/buiscuit.png'),
('itm007', 'soap', 68, 'Screenshot (167).png');

--
-- Triggers `item`
--
DROP TRIGGER IF EXISTS `after_insert_item_trigger`;
DELIMITER $$
CREATE TRIGGER `after_insert_item_trigger` AFTER INSERT ON `item` FOR EACH ROW BEGIN

DECLARE itm_id VARCHAR(6);
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET itm_id =  new.item_id;
SET data  = CONCAT_WS(', ', new.item_name, new.unit_price, new.item_image);
SET user = CURRENT_USER;
SET operation = 'INSERT';
SET changedat = now();

INSERT INTO item_log (item_id, data, user, operation, changed_at)
VALUES
(itm_id, data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `after_update_item_trigger`;
DELIMITER $$
CREATE TRIGGER `after_update_item_trigger` AFTER UPDATE ON `item` FOR EACH ROW BEGIN

DECLARE itm_id VARCHAR(6);
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET itm_id =  new.item_id;
SET data  = CONCAT_WS(', ', new.item_name, new.unit_price, new.item_image);
SET user = CURRENT_USER;
SET operation = 'UPDATE';
SET changedat = now();

INSERT INTO item_log (item_id, data, user, operation, changed_at)
VALUES
(itm_id, data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `before_delete_item_trigger`;
DELIMITER $$
CREATE TRIGGER `before_delete_item_trigger` BEFORE DELETE ON `item` FOR EACH ROW BEGIN

DECLARE itm_id VARCHAR(6);
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET itm_id =  old.item_id;
SET data  = CONCAT_WS(', ', old.item_name, old.unit_price, old.item_image);
SET user = CURRENT_USER;
SET operation = 'DELETE';
SET changedat = now();

INSERT INTO item_log (item_id, data, user, operation, changed_at)
VALUES
(itm_id, data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `ord_update_item_trigger`;
DELIMITER $$
CREATE TRIGGER `ord_update_item_trigger` AFTER UPDATE ON `item` FOR EACH ROW BEGIN
UPDATE `orders` SET `order_amount`= (`quantity` * NEW.`unit_price`) WHERE `item_id` = NEW.`item_id`;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `item_log`
--

DROP TABLE IF EXISTS `item_log`;
CREATE TABLE IF NOT EXISTS `item_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(6) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `operation` varchar(8) DEFAULT NULL,
  `changed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_log`
--

INSERT INTO `item_log` (`log_id`, `item_id`, `data`, `user`, `operation`, `changed_at`) VALUES
(4, 'itm001', 'bun, 15, images/item1.png', 'root@localhost', 'INSERT', '2021-06-29 22:20:13'),
(5, 'itm002', 'patis, 10, images/item2.png', 'root@localhost', 'INSERT', '2021-06-29 22:20:32'),
(6, 'itm003', 'egg, 20, images/item3.png', 'root@localhost', 'INSERT', '2021-06-29 22:20:48'),
(7, 'itm004', 'roll, 30, images/item4.png', 'root@localhost', 'INSERT', '2021-06-29 22:21:16'),
(8, 'itm005', 'bread, 50, images/item5.png', 'root@localhost', 'INSERT', '2021-06-29 22:21:43'),
(9, 'itm006', 'bread, 50, images/item5.png', 'root@localhost', 'INSERT', '2021-06-29 22:21:55'),
(10, 'itm006', 'toffy, 5, images/toffy.png', 'root@localhost', 'UPDATE', '2021-06-29 22:22:59'),
(11, 'itm006', 'toffy, 5, images/toffy.png', 'root@localhost', 'DELETE', '2021-06-29 22:23:40'),
(12, 'itm001', 'bun, 15, images/bun.png', 'root@localhost', 'UPDATE', '2021-06-29 22:24:46'),
(13, 'itm002', 'patis, 10, images/patis.png', 'root@localhost', 'UPDATE', '2021-06-29 22:25:10'),
(14, 'itm003', 'egg, 10, images/egg.png', 'root@localhost', 'UPDATE', '2021-06-29 22:25:30'),
(15, 'itm004', 'roll, 35, images/roll.png', 'root@localhost', 'UPDATE', '2021-06-29 22:25:54'),
(16, 'itm005', 'bread, 55, images/bread.png', 'root@localhost', 'UPDATE', '2021-06-29 22:26:15'),
(17, 'itm004', 'eggs, 22, images/egg.png', 'root@localhost', 'UPDATE', '2021-06-29 23:11:18'),
(18, 'itm003', 'roll, 35, images/roll.png', 'root@localhost', 'UPDATE', '2021-06-29 23:15:21'),
(19, 'itm003', 'roll, 25, images/roll.png', 'root@localhost', 'UPDATE', '2021-06-29 23:27:34'),
(20, 'itm006', 'buiscuit, 45, images/buiscuit.png', 'root@localhost', 'INSERT', '2021-06-30 01:36:53'),
(21, 'itm007', 'soap, 58, images/soap.png', 'root@localhost', 'INSERT', '2021-06-30 01:39:17'),
(22, 'itm007', 'soap, 48, images/soap.png', 'root@localhost', 'UPDATE', '2021-06-30 01:40:42'),
(23, 'itm007', 'soap, 48, images/soap.png', 'root@localhost', 'DELETE', '2021-06-30 01:41:09'),
(24, 'itm007', 'soap, 58, images/soap.png', 'root@localhost', 'INSERT', '2021-06-30 01:41:26'),
(25, 'itm007', 'soap, 48, images/soap.png', 'root@localhost', 'UPDATE', '2021-06-30 01:48:16'),
(26, 'itm002', 'eggs, 15, images/patis.png', 'root@localhost', 'UPDATE', '2021-07-05 06:26:05'),
(27, 'itm002', 'eggs, 15, images/patis.png', 'root@localhost', 'DELETE', '2021-07-05 06:27:18'),
(28, 'itm003', 'roll, 30, images/roll.png', 'root@localhost', 'UPDATE', '2021-07-05 06:28:46'),
(29, 'itm003', 'aaa, 30, images/roll.png', 'root@localhost', 'UPDATE', '2021-07-05 06:30:28'),
(30, 'itm001', 'buiscuit, 15, images/bun.png', 'root@localhost', 'UPDATE', '2021-07-05 06:34:55'),
(31, 'itm001', 'buiscuit, 25, images/bun.png', 'root@localhost', 'UPDATE', '2021-07-05 06:37:19'),
(32, 'itm001', 'roll, 25, images/bun.png', 'root@localhost', 'UPDATE', '2021-07-05 14:06:57'),
(33, 'itm007', 'soap, 48, images/soap.png', 'root@localhost', 'UPDATE', '2021-07-05 14:09:12'),
(34, 'itm001', 'roll, 28, images/bun.png', 'root@localhost', 'UPDATE', '2021-07-05 14:27:19'),
(35, 'itm003', 'apple, 22, images/roll.png', 'root@localhost', 'UPDATE', '2021-07-05 14:30:50'),
(36, 'itm007', 'soap, 68, 81746748_3645233252168578_272144658476302336_n.jpg', 'root@localhost', 'UPDATE', '2021-07-05 15:57:18'),
(37, 'itm007', 'soap, 68, Screenshot (167).png', 'root@localhost', 'UPDATE', '2021-07-05 15:57:52'),
(38, 'itm008', 'cake, 18, Screenshot (169).png', 'root@localhost', 'INSERT', '2021-07-05 23:53:54');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(6) DEFAULT NULL,
  `item_id` varchar(6) DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  `order_amount` float DEFAULT NULL,
  `date_and_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `item_id` (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `user_id`, `item_id`, `quantity`, `order_amount`, `date_and_time`) VALUES
(25, 'TG0002', 'itm004', 2, 44, '2021-06-30 09:30:24'),
(26, 'TG0003', 'itm005', 2, 110, '2021-06-30 09:30:54'),
(28, 'TG0005', 'itm002', 5, 75, '2021-06-30 22:56:33'),
(30, 'TG0004', 'itm003', 7, 154, '2021-07-02 19:03:00'),
(31, 'TG0001', 'itm001', 13, 364, '2021-07-02 20:08:04');

--
-- Triggers `orders`
--
DROP TRIGGER IF EXISTS `after_insert_order_trigger`;
DELIMITER $$
CREATE TRIGGER `after_insert_order_trigger` AFTER INSERT ON `orders` FOR EACH ROW BEGIN

DECLARE o_id INT;
DECLARE order_data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET o_id = new.order_id;
SET order_data  = CONCAT_WS(', ', new.user_id, new.item_id, new.quantity, new.order_amount, new.date_and_time);
SET user = CURRENT_USER;
SET operation = 'INSERT';
SET changedat = now();

INSERT INTO order_log (order_id, order_details, user, operation, changed_at)
VALUES
(o_id, order_data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `after_update_order_trigger`;
DELIMITER $$
CREATE TRIGGER `after_update_order_trigger` AFTER UPDATE ON `orders` FOR EACH ROW BEGIN

DECLARE o_id INT;
DECLARE order_data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET o_id = new.order_id;
SET order_data  = CONCAT_WS(', ', new.user_id, new.item_id, new.quantity, new.order_amount, new.date_and_time);
SET user = CURRENT_USER;
SET operation = 'UPDATE';
SET changedat = now();

INSERT INTO order_log (order_id, order_details, user, operation, changed_at)
VALUES
(o_id, order_data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `before_delete_order_trigger`;
DELIMITER $$
CREATE TRIGGER `before_delete_order_trigger` BEFORE DELETE ON `orders` FOR EACH ROW BEGIN

DECLARE o_id INT;
DECLARE order_data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET o_id = old.order_id;
SET order_data  = CONCAT_WS(', ', old.user_id, old.item_id, old.quantity, old.order_amount, old.date_and_time);
SET user = CURRENT_USER;
SET operation = 'DELETE';
SET changedat = now();

INSERT INTO order_log (order_id, order_details, user, operation, changed_at)
VALUES
(o_id, order_data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `inv_insert_order_trigger`;
DELIMITER $$
CREATE TRIGGER `inv_insert_order_trigger` AFTER INSERT ON `orders` FOR EACH ROW BEGIN
UPDATE `inventory` SET `quantity`= (`quantity`- NEW.`quantity`) WHERE `item_id` = NEW.`item_id` ;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `order_log`
--

DROP TABLE IF EXISTS `order_log`;
CREATE TABLE IF NOT EXISTS `order_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `order_details` varchar(255) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `operation` varchar(8) DEFAULT NULL,
  `changed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_log`
--

INSERT INTO `order_log` (`log_id`, `order_id`, `order_details`, `user`, `operation`, `changed_at`) VALUES
(3, 8, 'TG0001, itm003, 20, 200, 2021-06-29 22:29:07', 'root@localhost', 'INSERT', '2021-06-29 22:29:07'),
(4, 9, 'TG0001, itm001, 25, 375, 2021-06-29 22:30:04', 'root@localhost', 'INSERT', '2021-06-29 22:30:04'),
(5, 10, 'TG0002, itm001, 30, 450, 2021-06-29 22:30:26', 'root@localhost', 'INSERT', '2021-06-29 22:30:26'),
(6, 11, 'TG0002, itm004, 3, 105, 2021-06-29 22:30:58', 'root@localhost', 'INSERT', '2021-06-29 22:30:58'),
(7, 12, 'TG0002, itm005, 1, 55, 2021-06-29 22:32:00', 'root@localhost', 'INSERT', '2021-06-29 22:32:00'),
(8, 13, 'TG0001, itm005, 4, 220, 2021-06-29 22:32:12', 'root@localhost', 'INSERT', '2021-06-29 22:32:12'),
(9, 13, 'TG0001, itm002, 7, 70, 2021-06-29 22:32:12', 'root@localhost', 'UPDATE', '2021-06-29 22:35:08'),
(10, 8, 'TG0001, itm003, 20, 200, 2021-06-29 22:29:07', 'root@localhost', 'DELETE', '2021-06-29 22:45:00'),
(11, 9, 'TG0001, itm001, 25, 375, 2021-06-29 22:30:04', 'root@localhost', 'DELETE', '2021-06-29 22:46:02'),
(12, 11, 'TG0002, itm004, 3, 66, 2021-06-29 22:30:58', 'root@localhost', 'UPDATE', '2021-06-29 23:11:18'),
(13, 14, 'stu002, itm003, 11, 385, 2021-06-29 23:17:15', 'root@localhost', 'INSERT', '2021-06-29 23:17:15'),
(14, 14, 'stu002, itm003, 11, 275, 2021-06-29 23:17:15', 'root@localhost', 'UPDATE', '2021-06-29 23:27:34'),
(15, 14, 'TG0001, itm003, 4, 100, 2021-06-29 23:17:15', 'root@localhost', 'UPDATE', '2021-06-29 23:42:48'),
(16, 10, 'TG0002, itm001, 30, 450, 2021-06-29 22:30:26', 'root@localhost', 'DELETE', '2021-06-30 00:08:16'),
(17, 11, 'TG0002, itm004, 3, 66, 2021-06-29 22:30:58', 'root@localhost', 'DELETE', '2021-06-30 00:19:35'),
(18, 15, 'stu003, itm006, 2, 90, 2021-06-30 01:42:34', 'root@localhost', 'INSERT', '2021-06-30 01:42:34'),
(19, 16, 'stu003, itm007, 3, 174, 2021-06-30 01:46:01', 'root@localhost', 'INSERT', '2021-06-30 01:46:01'),
(20, 16, 'stu003, itm007, 3, 144, 2021-06-30 01:46:01', 'root@localhost', 'UPDATE', '2021-06-30 01:48:16'),
(21, 12, 'TG0002, itm005, 1, 55, 2021-06-29 22:32:00', 'root@localhost', 'DELETE', '2021-06-30 01:50:23'),
(22, 15, 'stu003, itm006, 2, 90, 2021-06-30 01:42:34', 'root@localhost', 'DELETE', '2021-06-30 02:02:07'),
(23, 16, 'stu003, itm007, 3, 144, 2021-06-30 01:46:01', 'root@localhost', 'DELETE', '2021-06-30 02:02:11'),
(24, 17, 'TG0001, itm003, 2, 50, 2021-06-30 02:04:09', 'root@localhost', 'INSERT', '2021-06-30 02:04:09'),
(25, 18, 'TG0003, itm007, 1, 48, 2021-06-30 02:04:23', 'root@localhost', 'INSERT', '2021-06-30 02:04:23'),
(26, 19, 'TG0002, itm005, 3, 165, 2021-06-30 02:04:39', 'root@localhost', 'INSERT', '2021-06-30 02:04:39'),
(27, 13, 'TG0001, itm002, 7, 70, 2021-06-29 22:32:12', 'root@localhost', 'DELETE', '2021-06-30 02:05:26'),
(28, 14, 'TG0001, itm003, 4, 100, 2021-06-29 23:17:15', 'root@localhost', 'DELETE', '2021-06-30 02:07:47'),
(29, 17, 'TG0001, itm003, 2, 50, 2021-06-30 02:04:09', 'root@localhost', 'DELETE', '2021-06-30 11:14:26'),
(30, 20, 'TG0001, itm002, 35, 350, 2021-06-30 14:31:54', 'root@localhost', 'INSERT', '2021-06-30 14:31:54'),
(31, 21, 'TG0003, itm001, 1, 15, 2021-06-30 14:33:02', 'root@localhost', 'INSERT', '2021-06-30 14:33:02'),
(32, 22, 'TG0002, itm003, 3, 75, 2021-06-30 14:34:17', 'root@localhost', 'INSERT', '2021-06-30 14:34:17'),
(33, 19, 'TG0002, itm005, 3, 165, 2021-06-30 02:04:39', 'root@localhost', 'DELETE', '2021-06-30 14:35:17'),
(34, 18, 'TG0003, itm007, 1, 48, 2021-06-30 02:04:23', 'root@localhost', 'DELETE', '2021-06-30 14:50:35'),
(35, 23, 'TG0001, itm005, 4, 220, 2021-06-30 14:59:43', 'root@localhost', 'INSERT', '2021-06-30 14:59:43'),
(36, 24, 'TG000, itm005, 2, 110, 2021-06-30 14:59:51', 'root@localhost', 'INSERT', '2021-06-30 14:59:51'),
(37, 25, 'TG0002, itm004, 2, 44, 2021-06-30 15:00:24', 'root@localhost', 'INSERT', '2021-06-30 15:00:24'),
(38, 26, 'TG0003, itm005, 2, 110, 2021-06-30 15:00:54', 'root@localhost', 'INSERT', '2021-06-30 15:00:54'),
(39, 24, 'TG000, itm005, 2, 110, 2021-06-30 14:59:51', 'root@localhost', 'DELETE', '2021-06-30 15:01:25'),
(40, 20, 'TG0001, itm002, 35, 350, 2021-06-30 14:31:54', 'root@localhost', 'DELETE', '2021-06-30 15:02:21'),
(41, 27, 'TG0005, itm002, 5, 2021-07-01 04:23:06', 'root@localhost', 'INSERT', '2021-07-01 04:23:06'),
(42, 27, 'TG0005, itm002, 5, 2021-07-01 04:23:06', 'root@localhost', 'DELETE', '2021-07-01 04:24:48'),
(43, 28, 'TG0005, itm002, 5, 50, 2021-07-01 04:26:33', 'root@localhost', 'INSERT', '2021-07-01 04:26:33'),
(44, 21, 'TG0003, itm001, 1, 15, 2021-06-30 14:33:02', 'root@localhost', 'DELETE', '2021-07-01 04:28:00'),
(45, 29, 'TG0005, itm003, 6, 2021-07-03 00:29:46', 'root@localhost', 'INSERT', '2021-07-03 00:29:46'),
(46, 30, 'TG0004, itm003, 7, 175, 2021-07-03 00:33:00', 'root@localhost', 'INSERT', '2021-07-03 00:33:00'),
(47, 29, 'TG0005, itm003, 6, 2021-07-03 00:29:46', 'root@localhost', 'DELETE', '2021-07-03 00:33:13'),
(48, 31, 'TG0001, itm001, 13, 195, 2021-07-03 01:38:04', 'root@localhost', 'INSERT', '2021-07-03 01:38:04'),
(49, 22, 'TG0002, itm003, 3, 75, 2021-06-30 14:34:17', 'root@localhost', 'DELETE', '2021-07-04 23:23:55'),
(50, 23, 'TG0001, itm005, 4, 220, 2021-06-30 14:59:43', 'root@localhost', 'DELETE', '2021-07-04 23:24:00'),
(51, 28, 'TG0005, itm002, 5, 75, 2021-07-01 04:26:33', 'root@localhost', 'UPDATE', '2021-07-05 06:26:05'),
(52, 30, 'TG0004, itm003, 7, 210, 2021-07-03 00:33:00', 'root@localhost', 'UPDATE', '2021-07-05 06:28:46'),
(53, 30, 'TG0004, itm003, 7, 210, 2021-07-03 00:33:00', 'root@localhost', 'UPDATE', '2021-07-05 06:30:28'),
(54, 31, 'TG0001, itm001, 13, 195, 2021-07-03 01:38:04', 'root@localhost', 'UPDATE', '2021-07-05 06:34:55'),
(55, 31, 'TG0001, itm001, 13, 325, 2021-07-03 01:38:04', 'root@localhost', 'UPDATE', '2021-07-05 06:37:19'),
(56, 31, 'TG0001, itm001, 13, 325, 2021-07-03 01:38:04', 'root@localhost', 'UPDATE', '2021-07-05 14:06:57'),
(57, 31, 'TG0001, itm001, 13, 364, 2021-07-03 01:38:04', 'root@localhost', 'UPDATE', '2021-07-05 14:27:19'),
(58, 30, 'TG0004, itm003, 7, 154, 2021-07-03 00:33:00', 'root@localhost', 'UPDATE', '2021-07-05 14:30:50');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `user_id` varchar(6) DEFAULT NULL,
  `item_id` varchar(6) DEFAULT NULL,
  `order_amount` float DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `order_id` (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `item_id` (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `order_id`, `user_id`, `item_id`, `order_amount`, `transaction_date`) VALUES
(4, 9, 'TG0001', 'itm001', 375, '2021-06-29'),
(5, 10, 'TG0002', 'itm001', 450, '2021-06-30'),
(6, 11, 'TG0002', 'itm004', 66, '2021-06-30'),
(7, 12, 'TG0002', 'itm005', 55, '2021-06-30'),
(8, 14, 'TG0001', 'itm003', 100, '2021-06-30'),
(9, 17, 'TG0001', 'itm003', 50, '2021-06-30'),
(10, 19, 'TG0002', 'itm005', 165, '2021-06-30'),
(11, 18, 'TG0003', 'itm007', 48, '2021-06-30'),
(12, 20, 'TG0001', 'itm002', 350, '2021-06-30'),
(13, 21, 'TG0003', 'itm001', 15, '2021-07-01'),
(14, 22, 'TG0002', 'itm003', 75, '2021-07-04'),
(15, 23, 'TG0001', 'itm005', 220, '2021-07-04');

--
-- Triggers `transaction`
--
DROP TRIGGER IF EXISTS `after_insert_transaction_trigger`;
DELIMITER $$
CREATE TRIGGER `after_insert_transaction_trigger` AFTER INSERT ON `transaction` FOR EACH ROW BEGIN

DECLARE tr_id INT;
DECLARE data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET tr_id =  new.transaction_id;
SET data  = CONCAT_WS(', ', new.order_id, new.user_id, new.item_id, new.order_amount, new.transaction_date);
SET user = CURRENT_USER;
SET operation = 'INSERT';
SET changedat = now();

INSERT INTO transaction_log (transaction_id, transaction_details, user, operation, changed_at)
VALUES
(tr_id, data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `or_after_insert_transaction_trigger`;
DELIMITER $$
CREATE TRIGGER `or_after_insert_transaction_trigger` AFTER INSERT ON `transaction` FOR EACH ROW BEGIN
DELETE FROM `orders` WHERE `order_id` = NEW.`order_id`;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `transactions_summary`
--

DROP TABLE IF EXISTS `transactions_summary`;
CREATE TABLE IF NOT EXISTS `transactions_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `transactions_count` int(11) DEFAULT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions_summary`
--

INSERT INTO `transactions_summary` (`id`, `date`, `total_amount`, `transactions_count`, `transaction_date`) VALUES
(2, '2021-07-04', 295, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_log`
--

DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE IF NOT EXISTS `transaction_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(11) DEFAULT NULL,
  `transaction_details` varchar(255) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `operation` varchar(8) DEFAULT NULL,
  `changed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_log`
--

INSERT INTO `transaction_log` (`log_id`, `transaction_id`, `transaction_details`, `user`, `operation`, `changed_at`) VALUES
(1, 12, '20, TG0001, itm002, 350, 2021-06-30', 'root@localhost', 'INSERT', '2021-06-30 15:02:21'),
(2, 13, '21, TG0003, itm001, 15, 2021-07-01', 'root@localhost', 'INSERT', '2021-07-01 04:28:00'),
(3, 14, '22, TG0002, itm003, 75, 2021-07-04', 'root@localhost', 'INSERT', '2021-07-04 23:23:55'),
(4, 15, '23, TG0001, itm005, 220, 2021-07-04', 'root@localhost', 'INSERT', '2021-07-04 23:24:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(6) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_role` int(1) DEFAULT NULL COMMENT 'admin = 1 , \r\nuser = 2',
  `user_contact` int(10) DEFAULT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_password`, `user_role`, `user_contact`, `user_image`) VALUES
('TG0001', 'zulmi', 'zulmi@gmail.com', NULL, 2, NULL, NULL),
('TG0002', 'rifnas', 'rifnas@gmail.com', '78945', 2, 714523652, 'Screenshot (168).png'),
('adm003', 'ruwan', 'ruwan@gmail.com', '123456', 1, 717307044, 'Screenshot (167).png'),
('TG0003', 'ravindu', 'wraviya30@gmail.com', NULL, 2, NULL, NULL);

--
-- Triggers `user`
--
DROP TRIGGER IF EXISTS `after_insert_user_trigger`;
DELIMITER $$
CREATE TRIGGER `after_insert_user_trigger` AFTER INSERT ON `user` FOR EACH ROW BEGIN

DECLARE user_data VARCHAR(255);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET user_data  = CONCAT_WS(', ', new.user_id, new.user_name, new.user_email, new.user_password, new.user_role, new.user_contact);
SET user = CURRENT_USER;
SET operation = 'INSERT';
SET changedat = now();

INSERT INTO user_log (user_details, user, operation, changed_at)
VALUES
(user_data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `after_update_user_trigger`;
DELIMITER $$
CREATE TRIGGER `after_update_user_trigger` AFTER UPDATE ON `user` FOR EACH ROW BEGIN

DECLARE user_data VARCHAR(100);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET user_data  = CONCAT_WS(', ', new.user_id, new.user_name, new.user_email, new.user_password, new.user_role, new.user_contact);
SET user = CURRENT_USER;
SET operation = 'UPDATE';
SET changedat = now();

INSERT INTO user_log (user_details, user, operation, changed_at)
VALUES
(user_data, user, operation, changedat);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `before_delete_user_trigger`;
DELIMITER $$
CREATE TRIGGER `before_delete_user_trigger` BEFORE DELETE ON `user` FOR EACH ROW BEGIN

DECLARE user_data VARCHAR(100);
DECLARE user VARCHAR(50);
DECLARE operation VARCHAR(8);
DECLARE changedat DATETIME;

SET user_data  = CONCAT_WS(', ', old.user_id, old.user_name, old.user_email, old.user_password, old.user_role, old.user_contact);
SET user = CURRENT_USER;
SET operation = 'DELETE';
SET changedat = now();

INSERT INTO user_log (user_details, user, operation, changed_at)
VALUES
(user_data, user, operation, changedat);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
CREATE TABLE IF NOT EXISTS `user_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_details` varchar(255) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `operation` varchar(8) DEFAULT NULL,
  `changed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=86 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_log`
--

INSERT INTO `user_log` (`log_id`, `user_details`, `user`, `operation`, `changed_at`) VALUES
(14, 'adm001, saman, adm1@gmail.com, 12345, admin, 765874856', 'root@localhost', 'INSERT', '2021-06-29 22:11:25'),
(15, 'TG0001, dasun, dasun@gmail.com, 12345, student, 765254578', 'root@localhost', 'INSERT', '2021-06-29 22:12:42'),
(16, 'TG0002, kasun, kasun@gmail.com, 45678, staff, 714578982', 'root@localhost', 'INSERT', '2021-06-29 22:13:38'),
(17, 'TG0003, namal, namal@gmail.com, 12345, student, 778956451', 'root@localhost', 'INSERT', '2021-06-30 01:26:06'),
(18, 'TG0003, kasuni, kasuni@gmail.com, 23456, student, 778951256', 'root@localhost', 'UPDATE', '2021-06-30 01:27:48'),
(19, 'TG0004, namal, namal@gmail.com, 12345, student, 778956451', 'root@localhost', 'INSERT', '2021-06-30 01:28:41'),
(20, 'TG0004, namal, namal@gmail.com, 12345, student, 778956451', 'root@localhost', 'DELETE', '2021-06-30 01:29:43'),
(21, 'TG0005, sumith, sumith@gmail.com, s12345, staff, 714589654', 'root@localhost', 'INSERT', '2021-07-01 01:31:56'),
(22, 'TG0001, dasun, dasun@gmail.com, 12345, user, 765254578', 'root@localhost', 'UPDATE', '2021-07-04 03:26:04'),
(23, 'TG0002, kasun, kasun@gmail.com, 45678, user, 714578982', 'root@localhost', 'UPDATE', '2021-07-04 03:26:26'),
(24, 'TG0003, kasuni, kasuni@gmail.com, 23456, user, 778951256', 'root@localhost', 'UPDATE', '2021-07-04 03:26:39'),
(25, 'adm002, sumith, admin2@gmail.com, s12345, admin, 714589654', 'root@localhost', 'UPDATE', '2021-07-04 03:27:14'),
(26, 'TG0004, darshana, darshana@gmail.com, 12345, 2, 758965874', 'root@localhost', 'INSERT', '2021-07-04 16:09:59'),
(27, 'adm003, Ruwan Chamikara, ruwan@gmail.com, , 1, 717307044', 'root@localhost', 'INSERT', '2021-07-04 16:39:14'),
(28, 'Tg0005, damith, damith@gmail.com, 12345, 2, 714568954', 'root@localhost', 'INSERT', '2021-07-04 17:06:44'),
(29, 'TG0006, kalana, kalana@gmail.com, 12345, 2, 712563457', 'root@localhost', 'INSERT', '2021-07-04 17:11:39'),
(30, 'TG006, pasan, pasan@gmail.com, 12342, 2, 789658965', 'root@localhost', 'INSERT', '2021-07-04 17:14:24'),
(31, 'TG006, pasan, pasan@gmail.com, 12342, 2, 789658965', 'root@localhost', 'DELETE', '2021-07-04 17:14:39'),
(32, 'adm001, saman, adm1@gmail.com, 12345, admin, 765874856', 'root@localhost', 'DELETE', '2021-07-04 17:14:53'),
(33, 'TG0001, dasun, dasun@gmail.com, 12345, user, 765254578', 'root@localhost', 'DELETE', '2021-07-04 17:15:01'),
(34, 'TG0002, kasun, kasun@gmail.com, 45678, user, 714578982', 'root@localhost', 'DELETE', '2021-07-04 17:15:05'),
(35, 'TG0003, kasuni, kasuni@gmail.com, 23456, user, 778951256', 'root@localhost', 'DELETE', '2021-07-04 17:15:07'),
(36, 'TG0004, darshana, darshana@gmail.com, 12345, 2, 758965874', 'root@localhost', 'DELETE', '2021-07-04 17:15:23'),
(37, 'adm002, sumith, admin2@gmail.com, s12345, admin, 714589654', 'root@localhost', 'DELETE', '2021-07-04 17:15:26'),
(38, 'adm003, Ruwan Chamikara, ruwan@gmail.com, , 1, 717307044', 'root@localhost', 'DELETE', '2021-07-04 17:15:31'),
(39, 'Tg0005, damith, damith@gmail.com, 12345, 2, 714568954', 'root@localhost', 'DELETE', '2021-07-04 17:15:35'),
(40, 'TG0001, kalana, kalana@gmail.com, 12345, 2, 712563457', 'root@localhost', 'UPDATE', '2021-07-04 17:16:10'),
(41, 'adm001, kamal, kamal@gmail.com, 12345, 1, 712365478', 'root@localhost', 'INSERT', '2021-07-04 17:23:45'),
(42, 'TG0002, damith, damith@gmail.com, 12345, 2, 758478542', 'root@localhost', 'INSERT', '2021-07-04 17:30:35'),
(43, 'TG0003, pawan, ruwan@gmail.com, 12345, 2, 718965412', 'root@localhost', 'INSERT', '2021-07-04 20:13:27'),
(44, 'adm002, namal, namal@gmail.com, 12345, 1, 747896587', 'root@localhost', 'INSERT', '2021-07-04 20:33:44'),
(45, 'adm003, ravindu, ravindu@gmail.com, 12345, 1, 717304125', 'root@localhost', 'INSERT', '2021-07-04 20:41:21'),
(46, 'adm004, rifnas, rifnas@gmail.com, 12345, 1, 758965412', 'root@localhost', 'INSERT', '2021-07-04 20:47:30'),
(47, 'TG0006, kamal, kamal@gmai.com, 11111, 2, 717307044', 'root@localhost', 'INSERT', '2021-07-04 22:32:16'),
(48, 'adm005, sameera, sameera@gmail.com, 12345, , 752563214', 'root@localhost', 'INSERT', '2021-07-04 22:45:54'),
(49, 'adm005, sameera, sameera@gmail.com, 12345, , 752563214', 'root@localhost', 'DELETE', '2021-07-04 22:47:37'),
(50, 'adm003, ravindu, ravindu@gmail.com, 12345, 1, 717304125', 'root@localhost', 'DELETE', '2021-07-04 22:54:23'),
(51, 'adm002, namal, namal@gmail.com, 12345, 1, 747896587', 'root@localhost', 'DELETE', '2021-07-04 22:54:28'),
(52, 'TG0002, damith, damith@gmail.com, 12345, 2, 758478542', 'root@localhost', 'DELETE', '2021-07-04 22:54:31'),
(53, 'TG0003, pawan, ruwan@gmail.com, 12345, 2, 718965412', 'root@localhost', 'DELETE', '2021-07-04 22:54:33'),
(54, 'adm001, kamal, kamal@gmail.com, 12345, 1, 712365478', 'root@localhost', 'DELETE', '2021-07-04 22:54:35'),
(55, 'TG0001, kalana, kalana@gmail.com, 12345, 2, 712563457', 'root@localhost', 'DELETE', '2021-07-04 22:54:37'),
(56, 'adm004, rifnas, rifnas@gmail.com, 12345, 1, 758965412', 'root@localhost', 'DELETE', '2021-07-04 22:54:40'),
(57, 'TG0006, kamal, kamal@gmai.com, 11111, 2, 717307044', 'root@localhost', 'DELETE', '2021-07-04 22:54:43'),
(58, 'adm001, ruwan, ruwan@gmail.com, 12345, 1, 717307044', 'root@localhost', 'INSERT', '2021-07-04 22:57:55'),
(59, 'adm002, ravindu, ravindu@gmail.com, 12345, 1, 715483652', 'root@localhost', 'INSERT', '2021-07-04 23:16:21'),
(60, 'adm002, ravindu, ravindu@gmail.com, 12345, 1, 715483652', 'root@localhost', 'DELETE', '2021-07-04 23:16:40'),
(61, 'adm002, ravindu, ravindu@gmail.com, , 1, 715483652', 'root@localhost', 'INSERT', '2021-07-04 23:16:49'),
(62, 'adm002, ravindu, ravindu@gmail.com, , 1, 715483652', 'root@localhost', 'DELETE', '2021-07-04 23:17:14'),
(63, 'adm002, ravindu, ravindu@gmail.com, 12345, 1, 715483652', 'root@localhost', 'INSERT', '2021-07-04 23:17:34'),
(64, 'TG0003, pawan, pawan@gmail.com, 12345, 2, 712548965', 'root@localhost', 'INSERT', '2021-07-04 23:46:16'),
(65, 'adm001, dasun, dasun@gmail.com, 12345, 1, 717307044', 'root@localhost', 'UPDATE', '2021-07-05 02:06:49'),
(66, 'TG0001, kalani, kalani@gmail.com, 45678, 2, 757852136', 'root@localhost', 'INSERT', '2021-07-05 02:30:34'),
(67, 'adm001, dasuni, dasun@gmail.com, 12345, 1, 717307044', 'root@localhost', 'UPDATE', '2021-07-05 06:22:49'),
(68, 'TG0001, kalan, kalani@gmail.com, 45678, 2, 757852136', 'root@localhost', 'UPDATE', '2021-07-05 06:27:58'),
(69, 'TG0001, kalana, kalani@gmail.com, 45678, 2, 757852136', 'root@localhost', 'UPDATE', '2021-07-05 06:28:14'),
(70, 'adm001, dasun, dasun@gmail.com, 12345, 1, 717307044', 'root@localhost', 'UPDATE', '2021-07-05 06:34:12'),
(71, 'TG0001, kalani, kalani@gmail.com, 45678, 2, 757852136', 'root@localhost', 'UPDATE', '2021-07-05 14:07:37'),
(72, 'adm002, ravindu, wraviya@gmail.com, 12345, 1, 715483652', 'root@localhost', 'UPDATE', '2021-07-05 15:56:26'),
(73, 'TG0003, pawan, pawan97@gmail.com, 12345, 2, 712548965', 'root@localhost', 'UPDATE', '2021-07-05 16:05:14'),
(74, 'TG0003, pawan, pawan@gmail.com, 12345, 2, 712548965', 'root@localhost', 'UPDATE', '2021-07-05 16:06:26'),
(75, 'adm001, dasun, dasun@gmail.com, 12345, 1, 717307044', 'root@localhost', 'DELETE', '2021-07-05 16:28:20'),
(76, 'TG0003, pawan, pawan@gmail.com, 12345, 2, 712548965', 'root@localhost', 'DELETE', '2021-07-05 16:32:02'),
(77, 'adm003, ruwan, ruwan@gmail.com, 123456, 1, 717307044', 'root@localhost', 'INSERT', '2021-07-05 16:35:20'),
(78, 'TG0001, kalani, kalani@gmail.com, 45678, 2, 757852136', 'root@localhost', 'DELETE', '2021-07-05 16:35:56'),
(79, 'TG0001, zulmi, zulmi@gmail.com, 2', 'root@localhost', 'INSERT', '2021-07-05 17:38:22'),
(80, 'TG0002, rifnas, rifnas@gmail.com, 78945, 2, 714523652', 'root@localhost', 'INSERT', '2021-07-05 22:30:00'),
(81, 'adm002, ravindu, wraviya@gmail.com, 12345, 1, 715483652', 'root@localhost', 'UPDATE', '2021-07-05 22:32:18'),
(82, 'adm002, ravindu, wraviya@gmail.com, 12345, 1, 715483652', 'root@localhost', 'DELETE', '2021-07-05 22:32:25'),
(83, 'ssss, sssss, d@gmail.com, 1', 'root@localhost', 'INSERT', '2021-07-05 22:59:08'),
(84, 'TG0003, ravindu, wraviya30@gmail.com, 2', 'root@localhost', 'INSERT', '2021-07-05 23:01:47'),
(85, 'ssss, sssss, d@gmail.com, 1', 'root@localhost', 'DELETE', '2021-07-05 23:01:54');

-- --------------------------------------------------------

--
-- Stand-in structure for view `user_view_items`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `user_view_items`;
CREATE TABLE IF NOT EXISTS `user_view_items` (
`item_id` varchar(6)
,`item_name` varchar(255)
,`unit_price` float
,`quantity` int(5)
,`item_image` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_all_items`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `view_all_items`;
CREATE TABLE IF NOT EXISTS `view_all_items` (
`item_id` varchar(6)
,`item_name` varchar(255)
,`unit_price` float
,`quantity` int(5)
,`item_image` varchar(255)
);

-- --------------------------------------------------------

--
-- Structure for view `ad_view_inventory`
--
DROP TABLE IF EXISTS `ad_view_inventory`;

DROP VIEW IF EXISTS `ad_view_inventory`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ad_view_inventory`  AS  select `inv`.`inv_id` AS `inv_id`,`itm`.`item_id` AS `item_id`,`itm`.`item_name` AS `item_name`,`itm`.`unit_price` AS `unit_price`,`inv`.`quantity` AS `quantity` from (`item` `itm` join `inventory` `inv`) where (`itm`.`item_id` = `inv`.`item_id`) group by `inv`.`inv_id` ;

-- --------------------------------------------------------

--
-- Structure for view `ad_view_orders`
--
DROP TABLE IF EXISTS `ad_view_orders`;

DROP VIEW IF EXISTS `ad_view_orders`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ad_view_orders`  AS  select `o`.`order_id` AS `order_id`,`o`.`user_id` AS `user_id`,`o`.`item_id` AS `item_id`,`i`.`item_name` AS `item_name`,`i`.`unit_price` AS `unit_price`,`o`.`quantity` AS `quantity`,`o`.`order_amount` AS `order_amount`,`o`.`date_and_time` AS `date_and_time`,`i`.`item_image` AS `item_image` from (`orders` `o` join `item` `i`) where (`o`.`item_id` = `i`.`item_id`) group by `o`.`order_id` ;

-- --------------------------------------------------------

--
-- Structure for view `ad_view_users`
--
DROP TABLE IF EXISTS `ad_view_users`;

DROP VIEW IF EXISTS `ad_view_users`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ad_view_users`  AS  select `user`.`user_id` AS `user_id`,`user`.`user_name` AS `user_name`,`user`.`user_email` AS `user_email`,`user`.`user_password` AS `user_password`,`user`.`user_role` AS `user_role`,`user`.`user_contact` AS `user_contact`,`user`.`user_image` AS `user_image` from `user` ;

-- --------------------------------------------------------

--
-- Structure for view `user_view_items`
--
DROP TABLE IF EXISTS `user_view_items`;

DROP VIEW IF EXISTS `user_view_items`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_view_items`  AS  select `itm`.`item_id` AS `item_id`,`itm`.`item_name` AS `item_name`,`itm`.`unit_price` AS `unit_price`,`inv`.`quantity` AS `quantity`,`itm`.`item_image` AS `item_image` from (`item` `itm` join `inventory` `inv`) where (`itm`.`item_id` = `inv`.`item_id`) group by `itm`.`item_id` ;

-- --------------------------------------------------------

--
-- Structure for view `view_all_items`
--
DROP TABLE IF EXISTS `view_all_items`;

DROP VIEW IF EXISTS `view_all_items`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_all_items`  AS  select `itm`.`item_id` AS `item_id`,`itm`.`item_name` AS `item_name`,`itm`.`unit_price` AS `unit_price`,`inv`.`quantity` AS `quantity`,`itm`.`item_image` AS `item_image` from (`item` `itm` join `inventory` `inv`) where (`itm`.`item_id` = `inv`.`item_id`) group by `itm`.`item_id` ;

DELIMITER $$
--
-- Events
--
DROP EVENT `daily_transaction_summery_event`$$
CREATE DEFINER=`root`@`localhost` EVENT `daily_transaction_summery_event` ON SCHEDULE EVERY 1 DAY STARTS '2021-07-02 23:59:59' ON COMPLETION PRESERVE ENABLE DO INSERT INTO `transactions_summary`
(`date`, `total_amount`, `transactions_count`)
VALUES
(DATE(NOW()), calculate_total_transaction_amount_function(), calculate_daily_transactions_count_function())$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
