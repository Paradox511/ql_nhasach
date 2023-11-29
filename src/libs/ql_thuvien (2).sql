-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2023 at 08:52 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ql_thuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `MaPhieuMuon` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`MaPhieuMuon`, `MaSach`, `SoLuong`) VALUES
(1, 1, 2),
(1, 3, 2),
(2, 4, 3),
(2, 8, 2),
(3, 7, 1),
(4, 8, 10);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPhieuNhap`, `MaSach`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
(1, 1, 2000, 10000, 20000000),
(1, 3, 2000, 150000, 300000000),
(2, 4, 100, 150000, 15000000),
(2, 5, 100, 150000, 15000000),
(3, 11, 100, 10000, 1000000),
(3, 15, 100, 12000, 1200000);

-- --------------------------------------------------------

--
-- Table structure for table `docgia`
--

CREATE TABLE `docgia` (
  `Ma` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `GioiTinh` varchar(30) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `docgia`
--

INSERT INTO `docgia` (`Ma`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `SoDienThoai`) VALUES
(1, 'Tỏm', 'Tỏm', '07/11/2022', 'Nữ', '0909460157'),
(2, 'Trần', 'Tèo', '05/11/2003', 'nu', '0333220808'),
(3, 'Nguyễn', 'Tún', '04/04/2003', 'nu', '0985555999'),
(4, 'Huynh', 'Lam Duc', '05/04/2023', 'Nam', '0909460156');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`Ma`, `Ten`, `DiaChi`, `SoDienThoai`) VALUES
(1, 'nha cung cap 1', 'Bình Hưng Hòa , Bình Tân', '0789412346'),
(2, 'nha cung cap 2', 'Bình Dương', '0789412556'),
(3, 'nha cung cap 3', 'Bình nuyên vô tận', '0789412336');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `Ma` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `Luong` int(11) NOT NULL,
  `DiaChi` text NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `GioiTinh` varchar(30) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`Ma`, `Ho`, `Ten`, `Luong`, `DiaChi`, `NgaySinh`, `GioiTinh`, `SoDienThoai`) VALUES
(1, 'Huỳnh', 'Đức', 5000000, '273 An Dương Vương', '2023-04-01', 'nam', '0243820333'),
(2, 'Huỳnh', 'Tùng', 5000000, '274 An Dương Vương', '2003-05-01', 'nam', '0143822333'),
(3, 'Huỳnh', 'Minh', 10000000, '273 An Dương Vương', '2000-04-01', 'nu', '0113820333'),
(45, 'Nguyen', 'Lam Tam Nhu', 1000000000, 'Xi Grand Court', '04/04/2023', 'Nữ', '0835902722');

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `SoDienThoai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`Ma`, `Ten`, `DiaChi`, `SoDienThoai`) VALUES
(1, 'Nha xuat ban 1', 'Dia Chi 1', 985546985),
(2, 'Nha xuat ban 2', 'Dia chi 2', 333222333),
(3, 'Nha xuat ban 3', 'Dia chi 3', 455444666);

-- --------------------------------------------------------

--
-- Table structure for table `noiquyphat`
--

CREATE TABLE `noiquyphat` (
  `Ma` int(11) NOT NULL,
  `NoiDung` varchar(255) NOT NULL,
  `CongThuc` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `noiquyphat`
--

INSERT INTO `noiquyphat` (`Ma`, `NoiDung`, `CongThuc`) VALUES
(1, 'mat', '3'),
(2, 'hong nang', '2'),
(3, 'hong nhe', '1'),
(4, 'tre nhe', '0.2'),
(5, 'tre nang', '1');

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

CREATE TABLE `phieumuon` (
  `Ma` int(11) NOT NULL,
  `MaNhanVien` int(11) NOT NULL,
  `MaDocGia` int(11) NOT NULL,
  `NgayMuon` date NOT NULL,
  `NgayTran` date NOT NULL,
  `NgayTraThuc` date DEFAULT NULL,
  `TrangThai` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieumuon`
--

INSERT INTO `phieumuon` (`Ma`, `MaNhanVien`, `MaDocGia`, `NgayMuon`, `NgayTran`, `NgayTraThuc`, `TrangThai`) VALUES
(1, 1, 1, '2023-04-02', '2023-04-05', '2023-04-04', b'01'),
(2, 2, 3, '2023-04-02', '2023-04-21', '2023-04-20', b'01'),
(3, 3, 1, '2023-04-02', '2023-04-05', '0000-00-00', b'00'),
(4, 2, 2, '2023-04-02', '2023-04-05', '0000-00-00', b'00');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `Ma` int(11) NOT NULL,
  `MaNhaCungCap` int(11) NOT NULL,
  `NgayNhap` date NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `MaNhanVien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`Ma`, `MaNhaCungCap`, `NgayNhap`, `TongTien`, `MaNhanVien`) VALUES
(1, 1, '2023-04-02', NULL, 1),
(2, 2, '2023-04-11', NULL, 3),
(3, 3, '2023-04-06', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `phieuphat`
--

CREATE TABLE `phieuphat` (
  `MaSach` int(11) NOT NULL,
  `MaViPham` int(11) NOT NULL,
  `NgayViPham` date NOT NULL,
  `SoTienPhat` int(11) DEFAULT NULL,
  `MaPhieuMuon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuphat`
--

INSERT INTO `phieuphat` (`MaSach`, `MaViPham`, `NgayViPham`, `SoTienPhat`, `MaPhieuMuon`) VALUES
(1, 2, '2023-04-22', NULL, 1),
(7, 4, '2023-04-22', NULL, 3),
(8, 5, '2023-04-22', NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `MaTacGia` int(11) NOT NULL,
  `MaTheLoai` int(11) NOT NULL,
  `MaNhaSanXuat` int(11) NOT NULL,
  `NamSanXuat` date NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Anh` varchar(255) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`Ma`, `Ten`, `MaTacGia`, `MaTheLoai`, `MaNhaSanXuat`, `NamSanXuat`, `SoLuong`, `Anh`, `Gia`) VALUES
(1, 'Doreamon 1', 1, 2, 2, '2023-04-04', 200, '#', 120000),
(2, 'Doreamon', 1, 2, 3, '2023-03-20', 100, '#', 199000),
(3, 'Conan 2', 4, 2, 3, '2023-04-02', 120, '#', 160000),
(4, 'Giải tích và đại số 11', 4, 1, 2, '2023-03-05', 200, '#', 170000),
(5, 'Tiếng việt 2', 4, 1, 1, '2022-10-09', 19, '#', 180000),
(6, 'Toán 7', 3, 1, 1, '2019-04-02', 290, '#', 1220000),
(7, 'Sách tham khảo toán 5', 4, 3, 1, '2013-04-03', 180, '#', 12000),
(8, 'Những bài văn hay 6', 1, 3, 1, '2016-04-05', 120, '#', 10000),
(9, 'Sách giải bài tập 3', 3, 3, 3, '2015-04-08', 100, '#', 1320000),
(10, 'Sách kỹ năng ăn nói', 4, 4, 3, '2014-04-09', 111, '#', 128800),
(11, 'Sách dạy cách ăn cơm', 1, 4, 2, '2011-11-13', 120, '#', 111111),
(12, 'Kỹ năng tin học', 5, 4, 1, '2017-08-05', 144, '#', 17890),
(13, 'Truyện kiều', 1, 5, 1, '2023-04-20', 270, '#', 128800),
(14, 'Tắt đèn', 3, 5, 2, '2015-04-07', 200, '#', 128800),
(15, 'Tôi khổ quá', 2, 5, 3, '2023-04-01', 199, '#', 12800),
(16, 'Lười làm đồ án java', 1, 5, 2, '2023-05-31', 111, '#', 12008800);

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `Ma` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `GioiTinh` varchar(30) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`Ma`, `Ho`, `Ten`, `GioiTinh`, `SoDienThoai`) VALUES
(1, 'Tac', 'Gia 1', 'nam', '0985555000'),
(2, 'Tac', 'Gia 2', 'nu', '0985555001'),
(3, 'Tac', 'Gia 3', 'nam', '0985555055'),
(4, 'Tac', 'Gia 4', 'nam', '0985543688'),
(5, 'Tac', 'Gia 5', 'nu', '0808550844');

-- --------------------------------------------------------

--
-- Table structure for table `theloaisach`
--

CREATE TABLE `theloaisach` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `theloaisach`
--

INSERT INTO `theloaisach` (`Ma`, `Ten`) VALUES
(1, 'Sách Giáo Khoa'),
(2, 'Sách truyện tranh'),
(3, 'Sách Tham Khảo'),
(4, 'Sách kỹ năng'),
(5, 'Sách văn học');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD PRIMARY KEY (`MaPhieuMuon`,`MaSach`) USING BTREE,
  ADD KEY `MaSach` (`MaSach`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`,`MaSach`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Indexes for table `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Indexes for table `noiquyphat`
--
ALTER TABLE `noiquyphat`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `NoiDung` (`NoiDung`);

--
-- Indexes for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaDocGia` (`MaDocGia`),
  ADD KEY `MaNhanVien` (`MaNhanVien`);

--
-- Indexes for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNhaCungCap` (`MaNhaCungCap`),
  ADD KEY `MaNhanVien` (`MaNhanVien`);

--
-- Indexes for table `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD PRIMARY KEY (`MaPhieuMuon`,`MaSach`) USING BTREE,
  ADD KEY `MaViPham` (`MaViPham`),
  ADD KEY `phieuphat_ibfk_3` (`MaSach`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNhaSanXuat` (`MaNhaSanXuat`),
  ADD KEY `MaTacGia` (`MaTacGia`),
  ADD KEY `MaTheLoai` (`MaTheLoai`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Indexes for table `theloaisach`
--
ALTER TABLE `theloaisach`
  ADD PRIMARY KEY (`Ma`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `chitietphieumuon_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`),
  ADD CONSTRAINT `chitietphieumuon_ibfk_2` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`Ma`);

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhaphang` (`Ma`);

--
-- Constraints for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `phieumuon_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`Ma`),
  ADD CONSTRAINT `phieumuon_ibfk_2` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`Ma`),
  ADD CONSTRAINT `phieumuon_ibfk_3` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`Ma`);

--
-- Constraints for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`Ma`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`Ma`);

--
-- Constraints for table `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD CONSTRAINT `phieuphat_ibfk_1` FOREIGN KEY (`MaViPham`) REFERENCES `noiquyphat` (`Ma`),
  ADD CONSTRAINT `phieuphat_ibfk_2` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `chitietphieumuon` (`MaPhieuMuon`),
  ADD CONSTRAINT `phieuphat_ibfk_3` FOREIGN KEY (`MaSach`) REFERENCES `chitietphieumuon` (`MaSach`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaNhaSanXuat`) REFERENCES `nhaxuatban` (`Ma`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`Ma`),
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`MaTheLoai`) REFERENCES `theloaisach` (`Ma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
