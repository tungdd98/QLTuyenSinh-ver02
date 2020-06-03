-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2020 at 09:44 AM
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
-- Database: `java02`
--

-- --------------------------------------------------------

--
-- Table structure for table `diem_thi`
--

CREATE TABLE `diem_thi` (
  `thiSinh_id` varchar(30) NOT NULL,
  `monThi_id` int(11) NOT NULL,
  `diem` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diem_thi`
--

INSERT INTO `diem_thi` (`thiSinh_id`, `monThi_id`, `diem`) VALUES
('2017603573', 2, '7'),
('2017603573', 3, '10'),
('2017603573', 4, '8'),
('2017603573', 5, '9'),
('2017603573', 6, '10'),
('2017896587', 2, '5'),
('2017896587', 3, '6'),
('2017896587', 4, '10'),
('2017896587', 5, '7'),
('2017896587', 6, '8');

-- --------------------------------------------------------

--
-- Table structure for table `diem_tuyen_sinh`
--

CREATE TABLE `diem_tuyen_sinh` (
  `maNganh` varchar(30) NOT NULL,
  `diemChuan` varchar(30) NOT NULL,
  `chiTieu` varchar(30) NOT NULL,
  `namThi` varchar(30) NOT NULL,
  `khoiThi_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diem_tuyen_sinh`
--

INSERT INTO `diem_tuyen_sinh` (`maNganh`, `diemChuan`, `chiTieu`, `namThi`, `khoiThi_id`) VALUES
('cntt', '24', '201', '2020', 1),
('cntt', '21', '200', '2020', 2),
('cntt', '23.5', '200', '2020', 4),
('dulich', '24', '100', '2020', 1);

-- --------------------------------------------------------

--
-- Table structure for table `khoi_thi`
--

CREATE TABLE `khoi_thi` (
  `maKhoi` int(11) NOT NULL,
  `tenKhoi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khoi_thi`
--

INSERT INTO `khoi_thi` (`maKhoi`, `tenKhoi`) VALUES
(1, 'Khối A'),
(2, 'Khối B'),
(3, 'Khối D'),
(4, 'Khối A1');

-- --------------------------------------------------------

--
-- Table structure for table `monthi_khoithi`
--

CREATE TABLE `monthi_khoithi` (
  `id` int(11) NOT NULL,
  `monThi_id` int(11) NOT NULL,
  `khoiThi_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monthi_khoithi`
--

INSERT INTO `monthi_khoithi` (`id`, `monThi_id`, `khoiThi_id`) VALUES
(2, 4, 1),
(3, 5, 1),
(5, 2, 3),
(6, 6, 1),
(7, 6, 3),
(8, 2, 3),
(9, 3, 4),
(10, 4, 4),
(11, 6, 4);

-- --------------------------------------------------------

--
-- Table structure for table `mon_thi`
--

CREATE TABLE `mon_thi` (
  `maMon` int(11) NOT NULL,
  `tenMon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mon_thi`
--

INSERT INTO `mon_thi` (`maMon`, `tenMon`) VALUES
(2, 'Văn'),
(3, 'Anh'),
(4, 'Lý'),
(5, 'Hoá'),
(6, 'Toán');

-- --------------------------------------------------------

--
-- Table structure for table `nganh_thi`
--

CREATE TABLE `nganh_thi` (
  `maNganh` varchar(30) NOT NULL,
  `tenNganh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nganh_thi`
--

INSERT INTO `nganh_thi` (`maNganh`, `tenNganh`) VALUES
('cntt', 'Công nghệ thông tin'),
('dientu', 'Điện tử'),
('dulich', 'Du lịch'),
('httt', 'Hệ thống thông tin'),
('oto', 'Ô tô');

-- --------------------------------------------------------

--
-- Table structure for table `thi_sinh`
--

CREATE TABLE `thi_sinh` (
  `maThiSinh` varchar(30) NOT NULL,
  `hoTen` varchar(255) NOT NULL,
  `ngaySinh` date NOT NULL,
  `gioiTinh` int(2) NOT NULL,
  `CMND` varchar(30) NOT NULL,
  `danToc` varchar(80) DEFAULT NULL,
  `soDienThoai` varchar(30) DEFAULT NULL,
  `queQuan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thi_sinh`
--

INSERT INTO `thi_sinh` (`maThiSinh`, `hoTen`, `ngaySinh`, `gioiTinh`, `CMND`, `danToc`, `soDienThoai`, `queQuan`) VALUES
('2017603573', 'Đặng Đức Tùng', '1998-01-09', 1, '001098009473a', 'Kinh', '0973793711', 'Hà Nội'),
('2017896587', 'Nguyễn Đình Minh Tuấn', '1999-09-05', 1, '009012664478', 'Kinh', '0973796548', 'Hải Phòng');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diem_thi`
--
ALTER TABLE `diem_thi`
  ADD PRIMARY KEY (`thiSinh_id`,`monThi_id`),
  ADD KEY `monThi_id` (`monThi_id`);

--
-- Indexes for table `diem_tuyen_sinh`
--
ALTER TABLE `diem_tuyen_sinh`
  ADD PRIMARY KEY (`maNganh`,`namThi`,`khoiThi_id`) USING BTREE,
  ADD KEY `khoiThi_id` (`khoiThi_id`);

--
-- Indexes for table `khoi_thi`
--
ALTER TABLE `khoi_thi`
  ADD PRIMARY KEY (`maKhoi`);

--
-- Indexes for table `monthi_khoithi`
--
ALTER TABLE `monthi_khoithi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `monThi_id` (`monThi_id`),
  ADD KEY `khoiThi_id` (`khoiThi_id`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khoi_thi`
--
ALTER TABLE `khoi_thi`
  MODIFY `maKhoi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `monthi_khoithi`
--
ALTER TABLE `monthi_khoithi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `mon_thi`
--
ALTER TABLE `mon_thi`
  MODIFY `maMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem_thi`
--
ALTER TABLE `diem_thi`
  ADD CONSTRAINT `diem_thi_ibfk_1` FOREIGN KEY (`monThi_id`) REFERENCES `mon_thi` (`maMon`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `diem_thi_ibfk_2` FOREIGN KEY (`thiSinh_id`) REFERENCES `thi_sinh` (`maThiSinh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `diem_tuyen_sinh`
--
ALTER TABLE `diem_tuyen_sinh`
  ADD CONSTRAINT `diem_tuyen_sinh_ibfk_1` FOREIGN KEY (`maNganh`) REFERENCES `nganh_thi` (`maNganh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `diem_tuyen_sinh_ibfk_2` FOREIGN KEY (`khoiThi_id`) REFERENCES `khoi_thi` (`maKhoi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `monthi_khoithi`
--
ALTER TABLE `monthi_khoithi`
  ADD CONSTRAINT `monthi_khoithi_ibfk_1` FOREIGN KEY (`monThi_id`) REFERENCES `mon_thi` (`maMon`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `monthi_khoithi_ibfk_2` FOREIGN KEY (`khoiThi_id`) REFERENCES `khoi_thi` (`maKhoi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
