-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2020 at 05:31 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qltuyensinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `diem_chuan`
--

CREATE TABLE `diem_chuan` (
  `maNganh` varchar(30) NOT NULL,
  `maKhoi` varchar(30) NOT NULL,
  `namThi` varchar(30) NOT NULL,
  `chiTieu` int(11) DEFAULT NULL,
  `diemChuan` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diem_chuan`
--

INSERT INTO `diem_chuan` (`maNganh`, `maKhoi`, `namThi`, `chiTieu`, `diemChuan`) VALUES
('cntt', 'kA', '2020', 300, 21),
('cntt', 'kA1', '2020', 100, 22),
('httt', 'kA', '2020', 200, 21);

-- --------------------------------------------------------

--
-- Table structure for table `diem_tuyen_sinh`
--

CREATE TABLE `diem_tuyen_sinh` (
  `maThiSinh` varchar(30) NOT NULL,
  `maMon` varchar(30) NOT NULL,
  `diem` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diem_tuyen_sinh`
--

INSERT INTO `diem_tuyen_sinh` (`maThiSinh`, `maMon`, `diem`) VALUES
('2017603573', 'anh', 10),
('2017603573', 'ly', 10),
('2017603573', 'toan', 10);

-- --------------------------------------------------------

--
-- Table structure for table `khoi_thi`
--

CREATE TABLE `khoi_thi` (
  `maKhoi` varchar(30) NOT NULL,
  `tenKhoi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khoi_thi`
--

INSERT INTO `khoi_thi` (`maKhoi`, `tenKhoi`) VALUES
('kA', 'Khối A'),
('kA1', 'Khối A1'),
('kD', 'Khối D');

-- --------------------------------------------------------

--
-- Table structure for table `monthi_khoithi`
--

CREATE TABLE `monthi_khoithi` (
  `maMon` varchar(30) NOT NULL,
  `maKhoi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monthi_khoithi`
--

INSERT INTO `monthi_khoithi` (`maMon`, `maKhoi`) VALUES
('anh', 'kA1'),
('anh', 'kD'),
('hoa', 'kA'),
('ly', 'kA'),
('ly', 'kA1'),
('toan', 'kA'),
('toan', 'kA1'),
('toan', 'kD'),
('van', 'kD');

-- --------------------------------------------------------

--
-- Table structure for table `mon_thi`
--

CREATE TABLE `mon_thi` (
  `maMon` varchar(30) NOT NULL,
  `tenMon` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mon_thi`
--

INSERT INTO `mon_thi` (`maMon`, `tenMon`) VALUES
('anh', 'Anh'),
('hoa', 'Hoá'),
('ly', 'Lý'),
('toan', 'Toán'),
('van', 'Văn');

-- --------------------------------------------------------

--
-- Table structure for table `nganh_thi`
--

CREATE TABLE `nganh_thi` (
  `maNganh` varchar(30) NOT NULL,
  `tenNganh` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nganh_thi`
--

INSERT INTO `nganh_thi` (`maNganh`, `tenNganh`) VALUES
('cntt', 'Công nghệ thông tin'),
('httt', 'Hệ thống thông tin');

-- --------------------------------------------------------

--
-- Table structure for table `thi_sinh`
--

CREATE TABLE `thi_sinh` (
  `maThiSinh` varchar(30) NOT NULL,
  `hoTen` varchar(100) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `gioiTinh` int(2) NOT NULL DEFAULT 0,
  `CMND` varchar(30) DEFAULT NULL,
  `danToc` varchar(100) DEFAULT NULL,
  `soDienThoai` varchar(30) DEFAULT NULL,
  `queQuan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thi_sinh`
--

INSERT INTO `thi_sinh` (`maThiSinh`, `hoTen`, `ngaySinh`, `gioiTinh`, `CMND`, `danToc`, `soDienThoai`, `queQuan`) VALUES
('2017603573', 'Đặng Đức Tùng', '1998-01-09', 1, '001098009473', 'Kinh', '0973793711', 'Hà Nội'),
('2018603549', 'Nguyễn Đình Minh Tuấn', '1999-01-09', 1, '01236475526', 'Kinh', '0123564789', 'Hà Nội');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diem_chuan`
--
ALTER TABLE `diem_chuan`
  ADD PRIMARY KEY (`maNganh`,`maKhoi`,`namThi`),
  ADD KEY `maKhoi` (`maKhoi`);

--
-- Indexes for table `diem_tuyen_sinh`
--
ALTER TABLE `diem_tuyen_sinh`
  ADD PRIMARY KEY (`maThiSinh`,`maMon`),
  ADD KEY `maMon` (`maMon`);

--
-- Indexes for table `khoi_thi`
--
ALTER TABLE `khoi_thi`
  ADD PRIMARY KEY (`maKhoi`);

--
-- Indexes for table `monthi_khoithi`
--
ALTER TABLE `monthi_khoithi`
  ADD PRIMARY KEY (`maMon`,`maKhoi`),
  ADD KEY `maKhoi` (`maKhoi`);

--
-- Indexes for table `mon_thi`
--
ALTER TABLE `mon_thi`
  ADD PRIMARY KEY (`maMon`);

--
-- Indexes for table `nganh_thi`
--
ALTER TABLE `nganh_thi`
  ADD PRIMARY KEY (`maNganh`);

--
-- Indexes for table `thi_sinh`
--
ALTER TABLE `thi_sinh`
  ADD PRIMARY KEY (`maThiSinh`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem_chuan`
--
ALTER TABLE `diem_chuan`
  ADD CONSTRAINT `diem_chuan_ibfk_1` FOREIGN KEY (`maNganh`) REFERENCES `nganh_thi` (`maNganh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `diem_chuan_ibfk_2` FOREIGN KEY (`maKhoi`) REFERENCES `khoi_thi` (`maKhoi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `diem_tuyen_sinh`
--
ALTER TABLE `diem_tuyen_sinh`
  ADD CONSTRAINT `diem_tuyen_sinh_ibfk_1` FOREIGN KEY (`maThiSinh`) REFERENCES `thi_sinh` (`maThiSinh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `diem_tuyen_sinh_ibfk_2` FOREIGN KEY (`maMon`) REFERENCES `mon_thi` (`maMon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `monthi_khoithi`
--
ALTER TABLE `monthi_khoithi`
  ADD CONSTRAINT `monthi_khoithi_ibfk_1` FOREIGN KEY (`maKhoi`) REFERENCES `khoi_thi` (`maKhoi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `monthi_khoithi_ibfk_2` FOREIGN KEY (`maMon`) REFERENCES `mon_thi` (`maMon`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
