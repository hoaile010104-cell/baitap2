CREATE DATABASE QuanLySinhVien;
GO

USE QuanLySinhVien;
GO

CREATE TABLE SinhVien (
    MaSV CHAR(10) PRIMARY KEY,
    HoTen NVARCHAR(100) NOT NULL,
    NgaySinh DATE NOT NULL,
    NganhDaoTao NVARCHAR(10) CHECK (NganhDaoTao IN ('CNTT','KTPM')),
    DiemTB FLOAT CHECK (DiemTB >= 0.0 AND DiemTB <= 10.0),
    LopSinhHoat NVARCHAR(20) NOT NULL
);
