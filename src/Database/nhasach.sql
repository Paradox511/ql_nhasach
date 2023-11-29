-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2023 at 04:15 AM
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
-- Database: `nhasach`
--

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `Mahd` int(10) NOT NULL,
  `Masach` int(10) NOT NULL,
  `Soluong` int(10) NOT NULL,
  `Dongia` int(10) NOT NULL,
  `Thanhtien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`Mahd`, `Masach`, `Soluong`, `Dongia`, `Thanhtien`) VALUES
(1, 47, 1, 27000, 27000),
(2, 119, 5, 30000, 150000),
(3, 120, 50, 30000, 1500000),
(4, 122, 5, 30000, 150000),
(5, 43, 4, 24000, 96000),
(6, 55, 2, 10000, 20000),
(7, 47, 5, 27000, 135000),
(8, 47, 5, 27000, 135000),
(9, 42, 1, 20000, 20000),
(9, 44, 9, 26000, 234000),
(10, 44, 2, 26000, 52000),
(10, 120, 5, 30000, 150000),
(11, 47, 10, 27000, 270000),
(12, 46, 1, 17000, 17000);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `Mapn` int(10) NOT NULL,
  `Masach` int(10) NOT NULL,
  `Soluong` int(10) NOT NULL,
  `Dongia` int(10) NOT NULL,
  `Thanhtien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`Mapn`, `Masach`, `Soluong`, `Dongia`, `Thanhtien`) VALUES
(4, 51, 9, 19200, 172800),
(5, 115, 22, 16800, 369600),
(5, 117, 8, 13600, 108800),
(6, 44, 5, 20800, 104000),
(7, 114, 15, 9600, 144000),
(8, 118, 15, 8000, 120000),
(9, 120, 100, 24000, 2400000),
(10, 121, 100, 24000, 2400000),
(10, 122, 100, 24000, 2400000),
(11, 55, 10, 8000, 80000),
(12, 52, 3, 15200, 45600),
(13, 112, 5, 10400, 52000),
(13, 114, 10, 9600, 96000),
(14, 51, 5, 19200, 96000);

-- --------------------------------------------------------

--
-- Table structure for table `giamgia`
--

CREATE TABLE `giamgia` (
  `Magg` int(11) NOT NULL,
  `Tengg` varchar(50) NOT NULL,
  `Phantramgg` int(11) NOT NULL,
  `Dieukien` int(11) NOT NULL,
  `Trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giamgia`
--

INSERT INTO `giamgia` (`Magg`, `Tengg`, `Phantramgg`, `Dieukien`, `Trangthai`) VALUES
(10, 'Giảm giá 10%', 10, 200000, 1),
(11, 'Giảm giá 20%', 20, 500000, 1),
(12, 'Giảm giá 50%', 50, 2000000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `Mahd` int(10) NOT NULL,
  `Manv` int(10) NOT NULL,
  `Makh` int(10) NOT NULL,
  `Ngaylap` date NOT NULL,
  `Tongtien` int(10) NOT NULL,
  `Ghichu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`Mahd`, `Manv`, `Makh`, `Ngaylap`, `Tongtien`, `Ghichu`) VALUES
(1, 1, 1, '2023-10-22', 27000, 'Đã thanh toán'),
(2, 1, 2, '2023-10-24', 150000, 'Đã thanh toán'),
(3, 1, 1, '2023-11-01', 3000000, 'Đã thanh toán'),
(4, 1, 1, '2023-11-01', 150000, 'Đã thanh toán'),
(5, 1, 4, '2023-11-01', 96000, 'Đã thanh toán'),
(6, 1, 2, '2023-11-02', 60000, 'Đã thanh toán'),
(7, 1, 5, '2023-11-06', 255000, 'Đã thanh toán'),
(8, 1, 4, '2023-11-06', 327000, 'Đã thanh toán'),
(9, 2, 1, '2023-11-06', 254000, 'Đã thanh toán'),
(10, 2, 1, '2023-11-06', 181800, 'Đã thanh toán'),
(11, 1, 2, '2023-11-07', 270000, 'Đã thanh toán'),
(12, 1, 2, '2023-11-14', 17000, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `Ma` int(10) NOT NULL,
  `Ho` varchar(10) NOT NULL,
  `Ten` varchar(20) NOT NULL,
  `Gioitinh` varchar(10) NOT NULL,
  `Diachi` varchar(50) NOT NULL,
  `Sdt` int(10) NOT NULL,
  `TongChiTieu` int(11) NOT NULL DEFAULT 0,
  `Trangthai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`Ma`, `Ho`, `Ten`, `Gioitinh`, `Diachi`, `Sdt`, `TongChiTieu`, `Trangthai`) VALUES
(1, 'Duong', 'Thinh', 'Nam', 'VN', 123456789, 3747800, 1),
(2, 'Trần', 'Vĩ Hào', 'Nam', 'Thành phố Hồ Chí Minh', 921232134, 1540000, 1),
(4, 'Nguyễn', 'Văn A', 'Nam', 'Hà Nội', 123455788, 443000, 1),
(5, 'Trần', 'Thị B', 'Nữ', 'Huế', 909555968, 255000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `Ma` int(11) NOT NULL,
  `Ho` varchar(10) NOT NULL,
  `Ten` varchar(20) NOT NULL,
  `Gioitinh` varchar(3) NOT NULL,
  `phanquyen` varchar(20) NOT NULL,
  `Diachi` varchar(20) NOT NULL,
  `Sdt` int(10) NOT NULL,
  `Trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`Ma`, `Ho`, `Ten`, `Gioitinh`, `phanquyen`, `Diachi`, `Sdt`, `Trangthai`) VALUES
(1, 'Huỳnh', 'Lâm Đức', 'Nam', 'Admin', 'VN', 909460157, 1),
(2, 'Trần', 'Thị B', 'Nữ', 'Bán hàng', 'TP.Hồ Chí Minh', 123456789, 1),
(3, 'Nguyễn', 'Văn C', 'Nam', 'Quản lý', 'Cần Thơ', 909305444, 1),
(4, 'Nguyễn', 'Văn A', 'Nữ', 'Bán hàng', 'Huế', 202023242, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `Quyen` varchar(20) NOT NULL,
  `QLnhanvien` int(1) NOT NULL,
  `QLkhachhang` int(1) NOT NULL,
  `Nhaphang` int(1) NOT NULL,
  `QLsach` int(1) NOT NULL,
  `Thongke` int(1) NOT NULL,
  `Luong` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`Quyen`, `QLnhanvien`, `QLkhachhang`, `Nhaphang`, `QLsach`, `Thongke`, `Luong`) VALUES
('Admin', 1, 1, 1, 1, 1, 0),
('Bán hàng', 0, 1, 0, 0, 1, 0),
('Quản lý', 1, 0, 1, 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `Mapn` int(10) NOT NULL,
  `Manv` int(10) NOT NULL,
  `Ngaylap` date NOT NULL,
  `Tongtien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`Mapn`, `Manv`, `Ngaylap`, `Tongtien`) VALUES
(3, 1, '2023-10-22', 0),
(4, 1, '2023-10-22', 345600),
(5, 1, '2023-10-22', 956800),
(6, 1, '2023-10-22', 208000),
(7, 1, '2023-10-24', 288000),
(8, 1, '2023-10-24', 240000),
(9, 1, '2023-10-31', 2400000),
(10, 1, '2023-10-31', 4800000),
(11, 1, '2023-10-31', 160000),
(12, 1, '2023-10-31', 45600),
(13, 2, '2023-11-06', 148000),
(14, 1, '2023-11-15', 96000);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `Ma` int(10) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `Matacgia` int(10) NOT NULL,
  `Matheloai` int(20) NOT NULL,
  `Namsx` int(4) NOT NULL,
  `Soluong` int(5) NOT NULL,
  `Anh` varchar(50) NOT NULL,
  `Gia` int(11) NOT NULL,
  `Trangthai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`Ma`, `Ten`, `Matacgia`, `Matheloai`, `Namsx`, `Soluong`, `Anh`, `Gia`, `Trangthai`) VALUES
(42, 'The Return of the Ki', 14, 1, 2003, 14, 'null', 20000, 1),
(43, 'Dracula', 19, 2, 1985, 70, 'null', 24000, 1),
(44, 'The Three Musketeers', 20, 4, 1997, 70, 'null', 26000, 1),
(45, 'Brave New World', 21, 1, 1994, 29, 'null', 11000, 1),
(46, 'War and Peace', 22, 3, 2011, 16, 'null', 17000, 1),
(47, 'To Kill a Mockingbir', 23, 4, 1984, 30, 'null', 27000, 1),
(48, 'The Wizard of Oz', 24, 4, 2008, 95, 'null', 12000, 1),
(49, 'Les Misérables', 25, 1, 2003, 25, 'null', 15000, 1),
(50, 'The Secret Garden', 26, 2, 2010, 51, 'null', 13000, 1),
(51, 'Animal Farm', 27, 1, 1980, 100, 'null', 24000, 1),
(52, 'The Great Gatsby', 28, 2, 1986, 50, 'null', 19000, 1),
(53, 'The Little Prince', 29, 3, 1989, 25, 'null', 24000, 1),
(54, 'The Call of the Wild', 30, 3, 1985, 23, 'null', 24000, 1),
(55, '20,000 Leagues Under', 31, 1, 1989, 77, 'null', 10000, 1),
(56, 'Anna Karenina', 22, 2, 1997, 64, 'null', 28000, 1),
(57, 'The Wind in the Will', 32, 4, 2010, 12, 'null', 25000, 1),
(58, 'The Picture of Doria', 33, 4, 1988, 60, 'null', 29000, 1),
(59, 'The Grapes of Wrath', 34, 2, 1982, 14, 'null', 23000, 1),
(60, 'Sense and Sensibilit', 5, 1, 1992, 31, 'null', 20000, 1),
(61, 'The Last of the Mohi', 35, 3, 1990, 97, 'null', 10000, 1),
(62, 'Tess of the d\'Urberv', 36, 4, 1993, 13, 'null', 27000, 1),
(63, 'Harry Potter and the', 37, 1, 2001, 19, 'null', 25000, 1),
(64, 'Heidi', 38, 3, 1987, 50, 'null', 15000, 1),
(65, 'Ulysses', 39, 1, 1980, 23, 'null', 29000, 1),
(66, 'The Complete Sherloc', 40, 3, 1984, 54, 'null', 25000, 1),
(67, 'The Count of Monte C', 20, 2, 2007, 43, 'null', 20000, 1),
(68, 'The Old Man and the ', 41, 3, 1999, 62, 'null', 25000, 1),
(69, 'The Lion, the Witch,', 42, 3, 2002, 74, 'null', 13000, 1),
(70, 'The Hunchback of Not', 25, 1, 1992, 66, 'null', 18000, 1),
(71, 'Pinocchio', 43, 1, 1991, 54, 'null', 12000, 1),
(72, 'One Hundred Years of', 44, 4, 2004, 93, 'null', 13000, 1),
(73, 'Ivanhoe', 45, 3, 1988, 82, 'null', 13000, 1),
(74, 'The Red Badge of Cou', 46, 3, 1986, 47, 'null', 24000, 1),
(75, 'Anne of Green Gables', 47, 2, 2008, 36, 'null', 18000, 1),
(76, 'Black Beauty', 48, 2, 1992, 47, 'null', 22000, 1),
(77, 'Peter Pan', 49, 3, 2011, 47, 'null', 25000, 1),
(78, 'A Farewell to Arms', 41, 1, 2002, 26, 'null', 29000, 1),
(79, 'The House of the Sev', 9, 3, 1980, 97, 'null', 24000, 1),
(80, 'Lord of the Flies', 50, 3, 1994, 92, 'null', 29000, 1),
(81, 'The Prince and the P', 3, 4, 2003, 95, 'null', 22000, 1),
(82, 'A Portrait of the Ar', 39, 1, 1999, 77, 'null', 25000, 1),
(83, 'Lord Jim', 51, 3, 1997, 12, 'null', 17000, 1),
(84, 'Harry Potter and the', 37, 2, 1998, 16, 'null', 13000, 1),
(85, 'The Red & the Black', 52, 2, 1989, 76, 'null', 22000, 1),
(86, 'The Stranger', 53, 2, 1998, 55, 'null', 25000, 1),
(87, 'The Trial', 54, 1, 1985, 52, 'null', 18000, 1),
(88, 'Lady Chatterley\'s Lo', 55, 1, 1993, 34, 'null', 17000, 1),
(89, 'Kidnapped: The Adven', 4, 4, 2010, 36, 'null', 14000, 1),
(90, 'The Catcher in the R', 56, 1, 1981, 17, 'null', 15000, 1),
(91, 'Fahrenheit 451', 57, 3, 1996, 18, 'null', 20000, 1),
(92, 'A Journey to the Cen', 31, 1, 2003, 58, 'null', 25000, 1),
(93, 'Vanity Fair', 58, 4, 2010, 82, 'null', 21000, 1),
(94, 'All Quiet on the Wes', 59, 1, 2000, 24, 'null', 11000, 1),
(95, 'Gone with the Wind', 60, 4, 1980, 22, 'null', 26000, 1),
(96, 'My Ántonia', 61, 3, 1990, 55, 'null', 15000, 1),
(97, 'Of Mice and Men', 34, 4, 2009, 45, 'null', 22000, 1),
(98, 'The Vicar of Wakefie', 62, 3, 1989, 51, 'null', 19000, 1),
(99, 'A Connecticut Yankee', 3, 4, 2009, 75, 'null', 23000, 1),
(100, 'White Fang', 30, 3, 2008, 70, 'null', 19000, 1),
(101, 'Fathers and Sons', 63, 3, 2011, 22, 'null', 10000, 1),
(102, 'Doctor Zhivago', 64, 1, 2009, 90, 'null', 15000, 1),
(103, 'The Decameron', 65, 2, 2007, 40, 'null', 22000, 1),
(104, 'Nineteen Eighty-Four', 27, 2, 2004, 69, 'null', 17000, 1),
(105, 'The Jungle', 66, 1, 2001, 48, 'null', 12000, 1),
(106, 'The Da Vinci Code', 67, 2, 1999, 55, 'null', 13000, 1),
(107, 'Persuasion', 5, 4, 2000, 18, 'null', 29000, 1),
(108, 'Mansfield Park', 5, 1, 1981, 31, 'null', 17000, 1),
(109, 'Candide', 68, 2, 2006, 32, 'null', 26000, 1),
(110, 'For Whom the Bell To', 41, 3, 2005, 58, 'null', 15000, 1),
(111, 'Far from the Madding', 36, 4, 2003, 36, 'null', 26000, 1),
(112, 'The Fellowship of th', 14, 2, 1995, 90, 'null', 13000, 1),
(113, 'The Return of the Na', 36, 3, 1997, 58, 'null', 12000, 1),
(114, 'Sons and Lovers', 55, 2, 1988, 30, 'null', 12000, 1),
(115, 'Charlotte\'s Web', 69, 1, 1989, 22, 'null', 21000, 1),
(116, 'The Swiss Family Rob', 70, 4, 2002, 10, 'null', 28000, 1),
(117, 'Bleak House', 12, 2, 1984, 8, 'null', 17000, 0),
(118, 'Père Goriot', 71, 3, 1986, 15, 'null', 10000, 1),
(119, 'Jujutsu Kaisen 1', 73, 1, 2020, 45, 'jjk1.jpg', 30000, 1),
(120, 'Jujutsu Kaisen Vol.0', 73, 1, 2021, 145, 'Volume_0 (1).jpg', 30000, 1),
(121, 'Attack on Titan Vol.1', 74, 1, 2010, 70, 'Titan1.jpg', 30000, 1),
(122, 'Naruto Vol.72', 75, 1, 2015, 70, 'Naruto 72.jpg', 30000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `Ma` int(10) NOT NULL,
  `Ten` varchar(20) NOT NULL,
  `Gioitinh` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`Ma`, `Ten`, `Gioitinh`) VALUES
(1, 'Miguel de Cervantes', 'Nữ'),
(2, 'Lewis Carroll', 'Nữ'),
(3, 'Mark Twain', 'Nữ'),
(4, 'Robert Louis Stevens', 'Nam'),
(5, 'Jane Austen', 'Nữ'),
(6, 'Emily Brontë', 'Nữ'),
(7, 'Charlotte Brontë', 'Nữ'),
(8, 'Herman Melville', 'Nam'),
(9, 'Nathaniel Hawthorne', 'Nam'),
(10, 'Jonathan Swift', 'Nam'),
(11, 'John Bunyan', 'Nữ'),
(12, 'Charles Dickens', 'Nam'),
(13, 'Louisa May Alcott', 'Nam'),
(14, 'J.R.R. Tolkien', 'Nữ'),
(15, 'Mary Shelley', 'Nam'),
(16, 'Harriet Beecher Stow', 'Nữ'),
(17, 'Fyodor Dostoyevsky', 'Nam'),
(18, 'Gustave Flaubert', 'Nữ'),
(19, 'Bram Stoker', 'Nữ'),
(20, 'Alexandre Dumas', 'Nam'),
(21, 'Aldous Huxley', 'Nữ'),
(22, 'Leo Tolstoy', 'Nam'),
(23, 'Harper Lee', 'Nam'),
(24, 'L. Frank Baum', 'Nữ'),
(25, 'Victor Hugo', 'Nữ'),
(26, 'Frances Hodgson Burn', 'Nam'),
(27, 'George Orwell', 'Nữ'),
(28, 'F. Scott Fitzgerald', 'Nữ'),
(29, 'Antoine de Saint-Exu', 'Nữ'),
(30, 'Jack London', 'Nữ'),
(31, 'Jules Verne', 'Nữ'),
(32, 'Kenneth Grahame', 'Nam'),
(33, 'Oscar Wilde', 'Nữ'),
(34, 'John Steinbeck', 'Nam'),
(35, 'James Fenimore Coope', 'Nam'),
(36, 'Thomas Hardy', 'Nữ'),
(37, 'J.K. Rowling', 'Nam'),
(38, 'Johanna Spyri', 'Nữ'),
(39, 'James Joyce', 'Nữ'),
(40, 'Arthur Conan Doyle', 'Nữ'),
(41, 'Ernest Hemingway', 'Nam'),
(42, 'C.S. Lewis', 'Nữ'),
(43, 'Carlo Collodi', 'Nữ'),
(44, 'Gabriel García Márqu', 'Nam'),
(45, 'Walter Scott', 'Nữ'),
(46, 'Stephen Crane', 'Nam'),
(47, 'L.M. Montgomery', 'Nam'),
(48, 'Anna Sewell', 'Nam'),
(49, 'J.M. Barrie', 'Nữ'),
(50, 'William Golding', 'Nam'),
(51, 'Joseph Conrad', 'Nữ'),
(52, 'Stendhal', 'Nam'),
(53, 'Albert Camus', 'Nam'),
(54, 'Franz Kafka', 'Nữ'),
(55, 'D.H. Lawrence', 'Nam'),
(56, 'J.D. Salinger', 'Nam'),
(57, 'Ray Bradbury', 'Nữ'),
(58, 'William Makepeace Th', 'Nam'),
(59, 'Erich Maria Remarque', 'Nam'),
(60, 'Margaret Mitchell', 'Nam'),
(61, 'Willa Cather', 'Nữ'),
(62, 'Oliver Goldsmith', 'Nữ'),
(63, 'Ivan Sergeevich Turg', 'Nữ'),
(64, 'Boris Leonidovich Pa', 'Nam'),
(65, 'Giovanni Boccaccio', 'Nam'),
(66, 'Upton Sinclair', 'Nữ'),
(67, 'Dan Brown', 'Nữ'),
(68, 'Voltaire', 'Nam'),
(69, 'E.B. White', 'Nam'),
(70, 'Johann David Wyss', 'Nam'),
(71, 'Honoré de Balzac', 'Nam'),
(73, 'Gege Akutami', 'Nam'),
(74, 'Hajime Isayama', 'Nam'),
(75, 'Masashi Kishimoto', 'Nam'),
(76, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `Manv` int(10) NOT NULL,
  `Taikhoan` varchar(20) NOT NULL,
  `Matkhau` varchar(20) NOT NULL,
  `Quyen` varchar(20) NOT NULL,
  `trangthai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`Manv`, `Taikhoan`, `Matkhau`, `Quyen`, `trangthai`) VALUES
(1, 'duc', 'duc', 'Admin', 1),
(2, 'nv01', 'nv01', 'Bán hàng', 1),
(3, 'ql01', 'ql01', 'Quản lý', 1),
(4, 'nva', 'nva', 'Bán hàng', 1);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `Ma` int(10) NOT NULL,
  `Ten` varchar(20) NOT NULL,
  `Trangthai` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`Ma`, `Ten`, `Trangthai`) VALUES
(1, 'Truyện tranh', 1),
(2, 'Sách giáo khoa', 1),
(3, 'Sách tham khảo', 1),
(4, 'Sách văn học', 1),
(5, '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`Mahd`,`Masach`) USING BTREE,
  ADD KEY `Mahd` (`Mahd`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`Mapn`,`Masach`),
  ADD KEY `Masach` (`Masach`);

--
-- Indexes for table `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`Magg`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`Mahd`),
  ADD KEY `Makh` (`Makh`),
  ADD KEY `Manv` (`Manv`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`Ma`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `phanquyen` (`phanquyen`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`Quyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`Mapn`),
  ADD KEY `Manv` (`Manv`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `Ma` (`Ma`),
  ADD KEY `Matheloai` (`Matheloai`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`Ma`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`Manv`),
  ADD KEY `taikhoan_ibfk_1` (`Quyen`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`Ma`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `giamgia`
--
ALTER TABLE `giamgia`
  MODIFY `Magg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `Mahd` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `Ma` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `Mapn` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `Ma` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `Ma` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `Manv` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `theloai`
--
ALTER TABLE `theloai`
  MODIFY `Ma` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_3` FOREIGN KEY (`Mahd`) REFERENCES `hoadon` (`Mahd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`Mapn`) REFERENCES `phieunhap` (`Mapn`),
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`Masach`) REFERENCES `sach` (`Ma`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`Makh`) REFERENCES `khachhang` (`Ma`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`Manv`) REFERENCES `nhanvien` (`Ma`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`phanquyen`) REFERENCES `phanquyen` (`Quyen`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_4` FOREIGN KEY (`Manv`) REFERENCES `nhanvien` (`Ma`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`Quyen`) REFERENCES `phanquyen` (`Quyen`) ON DELETE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`Manv`) REFERENCES `nhanvien` (`Ma`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
