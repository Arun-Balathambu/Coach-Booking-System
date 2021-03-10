-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2021 at 06:32 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `europebus_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_ID` int(11) NOT NULL,
  `customer_First_Name` varchar(45) NOT NULL,
  `customer_Last_Name` varchar(45) NOT NULL,
  `customer_Email` varchar(45) NOT NULL,
  `customer_Password` varchar(45) NOT NULL,
  `customer_Gender` varchar(45) NOT NULL,
  `customer_DOB` varchar(45) NOT NULL,
  `customer_PNumber` varchar(15) NOT NULL,
  `customer_Add_Street` varchar(45) NOT NULL,
  `customer_Add_City` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_ID`, `customer_First_Name`, `customer_Last_Name`, `customer_Email`, `customer_Password`, `customer_Gender`, `customer_DOB`, `customer_PNumber`, `customer_Add_Street`, `customer_Add_City`) VALUES
(1, 'siva', 'krishna', 'sk@example.com', '123', 'Male', '18-Apr-1999', '123456789', '99, hills wood', 'colombo'),
(2, 'arun', 'krish', 'arun@gmail.com', '456', 'Male', '30-Sep-1999', '1111111111', '54, town dtreet', 'kandy'),
(12, 'Kumar', 'sangakkara', 'sanga@cricket.com', '789', 'Male', '04-Mar-1985', '12457896', '56, lane', 'galle'),
(13, 'mahela', 'jayawardena', 'mj@gmail.com', '741', 'Male', '21-Aug-1984', '5555555555', '45 lane ', 'jaffna'),
(14, 'Malavika', 'mohan', 'mm@yahoo.com', '55555', 'Female', '03-Mar-2021', '784512369', '45 street', 'colombo'),
(17, 'ANU', 'PRIYA', 'anupriya@email.com', '909505404606303', 'Female', '03-Mar-1999', '0766043211', 'wellawaththe', 'colombo'),
(18, 'john', 'peter', 'jp@example.com', '753159', 'Male', '17-Jun-1998', '124578963', '25, lane', 'colombo');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_ID` int(11) NOT NULL,
  `emp_Name` varchar(45) NOT NULL,
  `emp_Username` varchar(45) NOT NULL,
  `emp_Password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_ID`, `emp_Name`, `emp_Username`, `emp_Password`) VALUES
(1, 'Arun Balathambu', 'arunbalathambu', '123'),
(2, 'Vijay', 'vijay', '456');

-- --------------------------------------------------------

--
-- Table structure for table `journey`
--

CREATE TABLE `journey` (
  `journey_ID` int(11) NOT NULL,
  `journey_Date` date NOT NULL,
  `no_Of_Seats_Available` int(11) NOT NULL,
  `route_route_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `journey_has_customer`
--

CREATE TABLE `journey_has_customer` (
  `journey_journey_ID` int(11) NOT NULL,
  `customer_customer_ID` int(11) NOT NULL,
  `no_Of_Seats` varchar(45) NOT NULL,
  `seat1` int(11) DEFAULT NULL,
  `seat2` int(11) DEFAULT NULL,
  `seat3` int(11) DEFAULT NULL,
  `seat4` int(11) DEFAULT NULL,
  `seat5` int(11) DEFAULT NULL,
  `seat6` int(11) DEFAULT NULL,
  `seat7` int(11) DEFAULT NULL,
  `seat8` int(11) DEFAULT NULL,
  `seat9` int(11) DEFAULT NULL,
  `seat10` int(11) DEFAULT NULL,
  `seat11` int(11) DEFAULT NULL,
  `seat12` int(11) DEFAULT NULL,
  `seat13` int(11) DEFAULT NULL,
  `seat14` int(11) DEFAULT NULL,
  `seat15` int(11) DEFAULT NULL,
  `seat16` int(11) DEFAULT NULL,
  `seat17` int(11) DEFAULT NULL,
  `seat18` int(11) DEFAULT NULL,
  `seat19` int(11) DEFAULT NULL,
  `seat20` int(11) DEFAULT NULL,
  `seat21` int(11) DEFAULT NULL,
  `seat22` int(11) DEFAULT NULL,
  `seat23` int(11) DEFAULT NULL,
  `seat24` int(11) DEFAULT NULL,
  `seat25` int(11) DEFAULT NULL,
  `seat26` int(11) DEFAULT NULL,
  `seat27` int(11) DEFAULT NULL,
  `seat28` int(11) DEFAULT NULL,
  `seat29` int(11) DEFAULT NULL,
  `seat30` int(11) DEFAULT NULL,
  `seat31` int(11) DEFAULT NULL,
  `seat32` int(11) DEFAULT NULL,
  `seat33` int(11) DEFAULT NULL,
  `seat34` int(11) DEFAULT NULL,
  `seat35` int(11) DEFAULT NULL,
  `seat36` int(11) DEFAULT NULL,
  `seat37` int(11) DEFAULT NULL,
  `seat38` int(11) DEFAULT NULL,
  `seat39` int(11) DEFAULT NULL,
  `seat40` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `route_ID` int(11) NOT NULL,
  `departure_Country` varchar(45) NOT NULL,
  `departure_Town` varchar(45) NOT NULL,
  `destination_Country` varchar(45) NOT NULL,
  `destination_Town` varchar(45) NOT NULL,
  `week` varchar(45) NOT NULL,
  `departure_Time` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `capacity` int(11) NOT NULL DEFAULT 40,
  `employee_emp_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_ID`, `departure_Country`, `departure_Town`, `destination_Country`, `destination_Town`, `week`, `departure_Time`, `price`, `capacity`, `employee_emp_ID`) VALUES
(1, 'France', 'Paris', 'Spain', 'Madrid', 'Monday', '1:0 AM', 1500, 40, 1),
(2, 'France', 'Lyon', 'Germany', 'Munich', 'Wednesday', '6:30 AM', 2000, 40, 1),
(3, 'France', 'Lyon', 'Germany', 'Frankfurt', 'Friday', '6:30 AM', 2400, 40, 1),
(6, 'Spain', 'Madrid', 'Germany', 'Berlin', 'Saturday', '7:15 PM', 1200, 40, 2),
(7, 'France', 'Paris', 'Spain', 'Madrid', 'Friday', '2:0 PM', 1500, 40, 1),
(9, 'Germany', 'Munich', 'France', 'Lyon', 'Thursday', '11:0 AM', 1950, 40, 1),
(10, 'Germany', 'Frankfurt', 'Spain', 'Madrid', 'Friday', '8:0 AM', 740, 40, 2),
(12, 'France', 'Lyon', 'Spain', 'Barcelona', 'Friday', '5:45 PM', 1450, 40, 1),
(13, 'France', 'Lyon', 'Spain', 'Barcelona', 'Sunday', '5:45 PM', 1450, 40, 1),
(17, 'Germany', 'Berlin', 'France', 'Paris', 'Sunday', '12:35 PM', 755.5, 40, 1),
(19, 'Spain', 'Barcelona', 'France', 'Lyon', 'Thursday', '9:0 AM', 1250, 40, 1),
(20, 'Spain', 'Barcelona', 'France', 'Lyon', 'Sunday', '9:0 AM', 1250, 40, 1),
(21, 'Spain', 'Barcelona', 'France', 'Lyon', 'Thursday', '9:0 AM', 1350, 40, 1),
(22, 'Spain', 'Bilbao', 'Germany', 'Munich', 'Wednesday', '7:15 PM', 580, 40, 2),
(23, 'Spain', 'Bilbao', 'Germany', 'Munich', 'Friday', '7:15 PM', 580, 40, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_ID`),
  ADD UNIQUE KEY `customer_Email` (`customer_Email`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_ID`),
  ADD UNIQUE KEY `emp_Username` (`emp_Username`);

--
-- Indexes for table `journey`
--
ALTER TABLE `journey`
  ADD PRIMARY KEY (`journey_ID`),
  ADD KEY `fk_journey_route1_idx` (`route_route_ID`);

--
-- Indexes for table `journey_has_customer`
--
ALTER TABLE `journey_has_customer`
  ADD PRIMARY KEY (`journey_journey_ID`,`customer_customer_ID`),
  ADD KEY `fk_journey_has_customer_customer1_idx` (`customer_customer_ID`),
  ADD KEY `fk_journey_has_customer_journey1_idx` (`journey_journey_ID`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_ID`),
  ADD KEY `fk_route_employee1_idx` (`employee_emp_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `journey`
--
ALTER TABLE `journey`
  MODIFY `journey_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `route_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `journey`
--
ALTER TABLE `journey`
  ADD CONSTRAINT `fk_journey_route1` FOREIGN KEY (`route_route_ID`) REFERENCES `route` (`route_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `journey_has_customer`
--
ALTER TABLE `journey_has_customer`
  ADD CONSTRAINT `fk_journey_has_customer_customer1` FOREIGN KEY (`customer_customer_ID`) REFERENCES `customer` (`customer_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_journey_has_customer_journey1` FOREIGN KEY (`journey_journey_ID`) REFERENCES `journey` (`journey_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `route`
--
ALTER TABLE `route`
  ADD CONSTRAINT `fk_route_employee1` FOREIGN KEY (`employee_emp_ID`) REFERENCES `employee` (`emp_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
