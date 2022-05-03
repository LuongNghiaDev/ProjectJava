package com.company;

import java.util.Scanner;

public class NhanVienHanhChinh extends NhanVien {

    public NhanVienHanhChinh()
    {

    }
    public NhanVienHanhChinh(String ma,String hoten,double luong)
    {
        super(ma,hoten,"Hanh Chinh",luong);
    }
    public void nhap(Scanner s)
    {
        super.nhap(s);
    }
    public void xuat()
    {
        super.xuat();
    }
    public double getThunhap()
    {
        return getLuong();
    }
}
