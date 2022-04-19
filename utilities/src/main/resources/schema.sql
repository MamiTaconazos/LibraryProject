-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2020 at 06:55 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bandhub`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Avatar` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `band`
--

CREATE TABLE `band` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `FoundedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bandevent`
--

CREATE TABLE `bandevent` (
  `Event` int(11) NOT NULL,
  `Band` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bandmusicalgenre`
--

CREATE TABLE `bandmusicalgenre` (
  `Band` int(11) NOT NULL,
  `MusicalGenre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bandmusician`
--

CREATE TABLE `bandmusician` (
  `Band` int(11) NOT NULL,
  `Musician` int(11) NOT NULL,
  `Since` datetime NOT NULL,
  `To` datetime DEFAULT NULL,
  `Active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bandpost`
--

CREATE TABLE `bandpost` (
  `Id` int(11) NOT NULL,
  `Band` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enventtype`
--

CREATE TABLE `enventtype` (
  `Id` int(11) NOT NULL,
  `Description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `Id` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  `Name` longtext NOT NULL,
  `Start` datetime NOT NULL,
  `End` datetime DEFAULT NULL,
  `Place` int(11) DEFAULT NULL,
  `Description` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `eventpost`
--

CREATE TABLE `eventpost` (
  `Id` int(11) NOT NULL,
  `Event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `Id` smallint(6) NOT NULL,
  `Description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instrument`
--

CREATE TABLE `instrument` (
  `Id` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `musicalgenre`
--

CREATE TABLE `musicalgenre` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `musician`
--

CREATE TABLE `musician` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `Genre` smallint(6) NOT NULL,
  `BornOn` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `musicianinstrument`
--

CREATE TABLE `musicianinstrument` (
  `Musician` int(11) NOT NULL,
  `Instrument` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `musicianmusicalgenre`
--

CREATE TABLE `musicianmusicalgenre` (
  `Musician` int(11) NOT NULL,
  `MusicalGenre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `Id` int(11) NOT NULL,
  `Author` int(11) NOT NULL,
  `Content` longtext NOT NULL,
  `Likes` int(11) NOT NULL DEFAULT 0,
  `PuplishedOn` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `band`
--
ALTER TABLE `band`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `bandevent`
--
ALTER TABLE `bandevent`
  ADD PRIMARY KEY (`Event`,`Band`),
  ADD KEY `FK_BandEvent_Band` (`Band`);

--
-- Indexes for table `bandmusicalgenre`
--
ALTER TABLE `bandmusicalgenre`
  ADD PRIMARY KEY (`Band`,`MusicalGenre`),
  ADD KEY `FK_BandMusicalGenre_MusicalGenre` (`MusicalGenre`);

--
-- Indexes for table `bandmusician`
--
ALTER TABLE `bandmusician`
  ADD PRIMARY KEY (`Band`,`Musician`),
  ADD KEY `FK_BandMusician_Musician` (`Musician`);

--
-- Indexes for table `bandpost`
--
ALTER TABLE `bandpost`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_BandPost_Band` (`Band`);

--
-- Indexes for table `enventtype`
--
ALTER TABLE `enventtype`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `eventpost`
--
ALTER TABLE `eventpost`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `instrument`
--
ALTER TABLE `instrument`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `musicalgenre`
--
ALTER TABLE `musicalgenre`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `musician`
--
ALTER TABLE `musician`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Musician_BandMusician` (`Genre`);

--
-- Indexes for table `musicianinstrument`
--
ALTER TABLE `musicianinstrument`
  ADD PRIMARY KEY (`Musician`,`Instrument`),
  ADD KEY `FK_MusicianInstrument_Instrument` (`Instrument`);

--
-- Indexes for table `musicianmusicalgenre`
--
ALTER TABLE `musicianmusicalgenre`
  ADD PRIMARY KEY (`Musician`,`MusicalGenre`),
  ADD KEY `FK_MusicianMusicalGenre_MusicalGenre` (`MusicalGenre`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `enventtype`
--
ALTER TABLE `enventtype`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `musicalgenre`
--
ALTER TABLE `musicalgenre`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bandevent`
--
ALTER TABLE `bandevent`
  ADD CONSTRAINT `FK_BandEvent_Band` FOREIGN KEY (`Band`) REFERENCES `band` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_BandEvent_Event` FOREIGN KEY (`Event`) REFERENCES `event` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bandmusicalgenre`
--
ALTER TABLE `bandmusicalgenre`
  ADD CONSTRAINT `FK_BandMusicalGenre_Band` FOREIGN KEY (`Band`) REFERENCES `band` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_BandMusicalGenre_MusicalGenre` FOREIGN KEY (`MusicalGenre`) REFERENCES `musicalgenre` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bandmusician`
--
ALTER TABLE `bandmusician`
  ADD CONSTRAINT `FK_BandMusician_Band` FOREIGN KEY (`Band`) REFERENCES `band` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_BandMusician_Musician` FOREIGN KEY (`Musician`) REFERENCES `musician` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bandpost`
--
ALTER TABLE `bandpost`
  ADD CONSTRAINT `FK_BandPost_Band` FOREIGN KEY (`Band`) REFERENCES `band` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_BandPost_Post` FOREIGN KEY (`Id`) REFERENCES `post` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK_Event_EnventType` FOREIGN KEY (`Id`) REFERENCES `enventtype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `eventpost`
--
ALTER TABLE `eventpost`
  ADD CONSTRAINT `FK_EventPost_Post` FOREIGN KEY (`Id`) REFERENCES `post` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `musician`
--
ALTER TABLE `musician`
  ADD CONSTRAINT `FK_Musician_BandMusician` FOREIGN KEY (`Genre`) REFERENCES `genre` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `musicianinstrument`
--
ALTER TABLE `musicianinstrument`
  ADD CONSTRAINT `FK_MusicianInstrument_Instrument` FOREIGN KEY (`Instrument`) REFERENCES `instrument` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_MusicianInstrument_Musician` FOREIGN KEY (`Musician`) REFERENCES `musician` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `musicianmusicalgenre`
--
ALTER TABLE `musicianmusicalgenre`
  ADD CONSTRAINT `FK_MusicianMusicalGenre_MusicalGenre` FOREIGN KEY (`MusicalGenre`) REFERENCES `musicalgenre` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_MusicianMusicalGenre_Musician` FOREIGN KEY (`Musician`) REFERENCES `musician` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Post_Author` FOREIGN KEY (`Id`) REFERENCES `author` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
