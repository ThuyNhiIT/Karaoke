﻿-- Tạo cơ sở dữ liệu KaraokeAPLUS
CREATE DATABASE KaraokeAPLUS;
GO

-- Sử dụng cơ sở dữ liệu KaraokeAPLUS
USE KaraokeAPLUS;
GO

-- Tạo bảng LoaiNhanVien
CREATE TABLE LoaiNhanVien (
    maLoai VARCHAR(50) PRIMARY KEY,
    tenLoai VARCHAR(255)
);
GO

INSERT INTO LoaiNhanVien (maLoai, tenLoai) VALUES ('NVQL', N'Nhân viên quản lý');
INSERT INTO LoaiNhanVien (maLoai, tenLoai) VALUES ('NVTN', N'Nhân viên thu ngân');
INSERT INTO LoaiNhanVien (maLoai, tenLoai) VALUES ('Khac', N'Nhân viên khác');

-- Tạo bảng LoaiPhong
CREATE TABLE LoaiPhong (
    maLoaiPhong VARCHAR(50) PRIMARY KEY,
    tenLoaiPhong VARCHAR(255),
    Gia FLOAT
);
GO

INSERT INTO LoaiPhong (maLoaiPhong, tenLoaiPhong, Gia) VALUES ('LP001', 'VIP', 100000);
INSERT INTO LoaiPhong (maLoaiPhong, tenLoaiPhong, Gia) VALUES ('LP002', 'THUONG', 60000);


-- Tạo bảng MatHang
CREATE TABLE MatHang (
    maMH VARCHAR(50) PRIMARY KEY,
    tenMH NVARCHAR(255),
    Gia FLOAT,
	trangThai BIT
);
GO

INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH001', 'Bia Heineken lon 330ml', 20000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH002', 'Bia Heineken chai 330ml', 50000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH003', 'Bia Tiger lon 330ml', 17000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH004', 'Bia Tiger Crystal lon 330ml', 19000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH005', 'Bia Budweiser lon 330ml', 18000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH006', 'Bia Budweiser chai 330ml', 22000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH007', 'Bia Sapporo lon 330ml', 19000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH008', 'Nước suối Aquafina', 10000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH009', 'Nước ngọt Cocacola', 12000, 1);
INSERT INTO MatHang (maMH, tenMH, Gia, trangThai) VALUES ('MH010', 'Nước ngọt Pepsi', 12000, 1);


-- Tạo bảng DichVu
CREATE TABLE DichVu (
    maDV VARCHAR(50) PRIMARY KEY,
    tenDV VARCHAR(255),
	maMH VARCHAR(50),
	FOREIGN KEY (maMH) REFERENCES MatHang(maMH)
);
GO

INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV001', 'Bia Heineken lon 330ml', 'MH001');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV002', 'Bia Heineken chai 330ml', 'MH002');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV003', 'Bia Tiger lon 330ml', 'MH003');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV004', 'Bia Tiger Crystal lon 330ml', 'MH004');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV005', 'Bia Budweiser lon 330ml', 'MH005');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV006', 'Bia Budweiser chai 330ml', 'MH006');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV007', 'Bia Sapporo lon 330ml', 'MH007');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV008', 'Nước suối Aquafina', 'MH008');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV009', 'Nước ngọt Cocacola', 'MH009');
INSERT INTO DichVu (maDV, tenDV, maMH) VALUES ('DV010', 'Nước ngọt Pepsi', 'MH010');


-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    maKH VARCHAR(50) PRIMARY KEY,
    tenKH NVARCHAR(255),
    SDT VARCHAR(20),
    GioiTinh BIT
);
GO

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH001', N'Nguyễn Văn An', '0912345678', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH002', N'Trần Thị Bé', '0912345679', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH003', N'Lê Văn Cường', '0912345680', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH004', N'Nguyễn Thị Duyên', '09121234567', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH005', N'Nguyễn Văn Đức', '0394937937', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH006', N'Trần Mỹ Ngọc', '0398999999', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH007', N'Lê Trung Dũng', '0399888888', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH008', N'Nguyễn Thị Duyên', '0904868686', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH009', N'Nguyễn Quốc Huy', '0908888888', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH010', N'Trần Ngọc Giang', '0909999999', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH011', N'Lê Thị Thanh Trang', '0914666666', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH012', N'Nguyễn Thanh Bảo', '0924444444', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH013', N'Trương Thanh Hoài Phương', '0936543321', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH014', N'Khưu Ngọc Lân', '0937453865', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH015', N'Thái Hoàng Trung', '0939221267', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH016', N'Nguyễn Thị Bảo Châu', '0931778990', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH017', N'Lưu Quốc Hùng', '0909111333', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH018', N'Trần Ngọc Giang', '0908567432', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH019', N'Phạm Văn Tuấn', '0914544124', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH020', N'Đặng Tuấn Minh', '0929765435', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH021', N'Hồ Duy Khanh', '034876459', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH022', N'Trần Mỹ Kiều', '0710655433', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH023', N'Phan Thùy Vy', '0887652356', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH024', N'Nguyễn Phương Thùy', '0456789875', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH025', N'Nguyễn Hoàng Tuấn', '0398777777', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH026', N'Trần Đức Hiếu', '0904555555', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH027', N'Hoàng Quốc Huy Vũ', '0924111111', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH028', N'Nguyễn Huy Vỹ', '0919666666', 1);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH029', N'Nguyễn Huy Hoàng', '0782322321', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH030', N'Trần Gia Huy Hùng', '0792132134', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH031', N'Châu Thị Bảo My', '0919555666', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH032', N'Đào Châu Kim Thùy', '0789453214', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH033', N'Hồ Tuấn Nam', '0654222222', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH034', N'Đặng Thanh Thảo', '0854111111', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH035', N'Phạm Việt Đăng', '0909150844', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH036', N'Nguyễn Phương Trang', '0377773456', 0);

INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH037', N'Hồ Tuấn Nam', '0908888789', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH038', N'Đặng Thanh Thảo', '0559999999', 0);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH039', N'Phạm Việt Đăng', '0911222643', 1);
INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES ('KH040', N'Nguyễn Phương Trang', '0375643215', 0);


-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    maNV VARCHAR(50) PRIMARY KEY,
    tenNV NVARCHAR(255),
    gioiTinh BIT,
    CCCD VARCHAR(20),
    SDT VARCHAR(20),
    diaChi NVARCHAR(255),
    caLam VARCHAR(50),
    loaiNV VARCHAR(50),
    FOREIGN KEY (loaiNV) REFERENCES LoaiNhanVien(maLoai)
);
GO

INSERT INTO NhanVien (maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV) 
VALUES ('NV001', N'Phạm Thị Thùy Nhi', 0, '079333444555', '0912345678', N'123 Dương Quảng Hàm quận Gò vấp', 'CA 1', 'NVQL');

INSERT INTO NhanVien (maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV) 
VALUES ('NV002', N'Nguyễn Thị Quỳnh Giang', 0, '079666777888', '0909666888', N'124 Chu Văn An quận Bình Thạnh', 'CA 2', 'NVQL');

INSERT INTO NhanVien (maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV) 
VALUES ('NV003', N'Hồ Minh Hậu', 1, '079999111222', '0963444121', N'125 Quang Trung quận Gò Vấp', 'CA 3', 'NVQL');

INSERT INTO NhanVien (maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV) 
VALUES ('NV004', N'Võ Minh Nhựt', 1, '079888999444', '0972143563', N'126 Lê Lợi quận Gò Vấp', 'CA 3', 'NVQL');

INSERT INTO NhanVien (maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV) 
VALUES ('NV005', N'Châu Thanh Huy', 1, '079567432123', '0979834347', N'3 Nguyễn An Ninh quận Bình Thạnh', 'CA 2', 'NVTN');


-- Tạo bảng PhongHat
CREATE TABLE PhongHat (
    maPhong VARCHAR(50) PRIMARY KEY,
    tenPhong VARCHAR(255),
    maLoaiPhong VARCHAR(50),
    tinhTrangPhong VARCHAR(255),
    FOREIGN KEY (maLoaiPhong) REFERENCES LoaiPhong(maLoaiPhong)
);
GO

INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P001', 'Phong hat 001 ', 'LP001', 'Trong');
INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P002', 'Phong hat 002 ', 'LP001', 'Cho');
INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P003', 'Phong hat 003 ', 'LP001', 'Dang su dung');

INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P004', 'Phong hat 004 ', 'LP002', 'Trong');
INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P005', 'Phong hat 005 ', 'LP002', 'Cho');
INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P006', 'Phong hat 006 ', 'LP002', 'Dang su dung');

INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P007', 'Phong hat 007 ', 'LP002', 'Trong');
INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P008', 'Phong hat 008 ', 'LP002', 'Cho');
INSERT INTO PhongHat (maPhong, tenPhong, maLoaiPhong, tinhTrangPhong)
VALUES ('P009', 'Phong hat 009 ', 'LP002', 'Dang su dung');

-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan (
    maNV VARCHAR(50) PRIMARY KEY,
    Password VARCHAR(50),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

INSERT INTO TaiKhoan (maNV, Password) VALUES ('NV001', '123456A');
INSERT INTO TaiKhoan (maNV, Password) VALUES ('NV002', '123456A');
INSERT INTO TaiKhoan (maNV, Password) VALUES ('NV003', '123456A');
INSERT INTO TaiKhoan (maNV, Password) VALUES ('NV004', '123456A');
INSERT INTO TaiKhoan (maNV, Password) VALUES ('NV005', '123456A');

-- Tạo bảng DonDatPhong
CREATE TABLE DonDatPhong (
    maDonDatPhong VARCHAR(50) PRIMARY KEY,
    ngayDat DATE,
    ngayNhan DATE,
    maPhong VARCHAR(50),
    maKH VARCHAR(50),
    FOREIGN KEY (maPhong) REFERENCES PhongHat(maPhong),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
);
GO

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP001', '2023-10-31', '2023-11-01', 'P001', 'KH001');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP002', '2023-11-05', '2023-11-06', 'P002', 'KH002');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP003', '2023-11-10', '2023-11-11', 'P003', 'KH003');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP004', '2023-11-15', '2023-11-16', 'P004', 'KH004');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP005', '2023-11-25', '2023-11-26', 'P005', 'KH005');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP006', '2023-11-29', '2023-11-30', 'P006', 'KH006');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP007', '2023-12-01', '2023-12-02', 'P007', 'KH007');

INSERT INTO DonDatPhong (maDonDatPhong, ngayDat, ngayNhan, maPhong, maKH)
VALUES ('DDP008', '2023-12-05', '2023-12-06', 'P008', 'KH008');

-- Tạo bảng HoaDon
CREATE TABLE HoaDon (
    maHD VARCHAR(50) PRIMARY KEY,
    ngayLapHD DATE,
    maKH VARCHAR(50),
    maNV VARCHAR(50),
    maDV VARCHAR(50),
    maPhong VARCHAR(50),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
   /* FOREIGN KEY (maDV) REFERENCES DichVu(maDV),
    FOREIGN KEY (maPhong) REFERENCES PhongHat(maPhong)
	*/
);
GO

INSERT INTO HoaDon (maHD, ngayLapHD, maKH, maNV, maDV, maPhong)
VALUES ('HD001', '2023-10-30', 'KH001', 'NV001', 'DV001', 'P001');

INSERT INTO HoaDon (maHD, ngayLapHD, maKH, maNV, maDV, maPhong)
VALUES ('HD002', '2023-10-31', 'KH002', 'NV002', 'DV002', 'P002');

INSERT INTO HoaDon (maHD, ngayLapHD, maKH, maNV, maDV, maPhong)
VALUES ('HD003', '2023-11-01', 'KH003', 'NV003', 'DV003', 'P003');

INSERT INTO HoaDon (maHD, ngayLapHD, maKH, maNV, maDV, maPhong)
VALUES ('HD004', '2023-11-02', 'KH004', 'NV004', 'DV004', 'P004');


-- Tạo bảng ChiTietHoaDonDV
CREATE TABLE ChiTietHoaDonDV (
    maHD VARCHAR(50),
    maDV VARCHAR(50),
    soLuong INT,
    gia FLOAT,
    PRIMARY KEY (maHD, maDV),
    FOREIGN KEY (maHD) REFERENCES HoaDon(maHD),
    FOREIGN KEY (maDV) REFERENCES DichVu(maDV)
);
GO

INSERT INTO ChiTietHoaDonDV (maHD, maDV, soLuong, gia)
VALUES ('HD001', 'DV001', 1, 100000);

INSERT INTO ChiTietHoaDonDV (maHD, maDV, soLuong, gia)
VALUES ('HD002', 'DV002', 1, 120000);

INSERT INTO ChiTietHoaDonDV (maHD, maDV, soLuong, gia)
VALUES ('HD003', 'DV003', 1, 130000);

INSERT INTO ChiTietHoaDonDV (maHD, maDV, soLuong, gia)
VALUES ('HD004', 'DV004', 1, 140000);

-- Tạo bảng ChiTietHoaDonPhong
CREATE TABLE ChiTietHoaDonPhong (
    maHD VARCHAR(50),
    maPhong VARCHAR(50),
    gia FLOAT,
    gioVao DATETIME,
    gioRa DATETIME,
    maGiamGia VARCHAR(50),
    PRIMARY KEY (maHD, maPhong),
    FOREIGN KEY (maHD) REFERENCES HoaDon(maHD),
    FOREIGN KEY (maPhong) REFERENCES PhongHat(maPhong)
);
GO

INSERT INTO ChiTietHoaDonPhong (maHD, maPhong, gia, gioVao, gioRa, maGiamGia)
VALUES ('HD001', 'P001', 100000, '2023-10-30 13:00:00', '2023-10-30 15:00:00', 'VIP');

INSERT INTO ChiTietHoaDonPhong (maHD, maPhong, gia, gioVao, gioRa, maGiamGia)
VALUES ('HD002', 'P002', 100000, '2023-10-30 15:00:00', '2023-10-30 17:00:00', 'VIP');

INSERT INTO ChiTietHoaDonPhong (maHD, maPhong, gia, gioVao, gioRa, maGiamGia)
VALUES ('HD003', 'P003', 60000, '2023-10-30 12:00:00', '2023-10-30 15:00:00', 'VIP');

INSERT INTO ChiTietHoaDonPhong (maHD, maPhong, gia, gioVao, gioRa, maGiamGia)
VALUES ('HD004', 'P004', 60000, '2023-10-30 11:00:00', '2023-10-30 13:00:00', 'VIP');

INSERT INTO ChiTietHoaDonPhong (maHD, maPhong, gia, gioVao, gioRa, maGiamGia)
VALUES ('HD005', 'P005', 60000, '2023-10-30 13:30:00', '2023-10-30 15:300:00', 'VIP');