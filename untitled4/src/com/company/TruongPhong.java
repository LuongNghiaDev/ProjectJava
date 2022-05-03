package com.company;

import java.util.Scanner;

public class TruongPhong extends NhanVien{

    private double luongtrachnhiem;

    public TruongPhong()
    {

    }
    public TruongPhong(String ma,String hoten,double luong,double luongtrachnhiem)
    {
        super(ma,hoten,"Truong Phong",luong);
        this.luongtrachnhiem=luongtrachnhiem;
    }
    public void nhap(Scanner s)
    {
        super.nhap(s);
        System.out.println("Nhập lương trách nhiệm: ");
        luongtrachnhiem=s.nextDouble();
        s.nextLine();
    }
    public void xuat()
    {
        super.xuat();
        System.out.printf(" Lương trách nhiệm: %f ",luongtrachnhiem);
    }
    public void setLuongtrachnhiem(double luongtrachnhiem)
    {
        this.luongtrachnhiem=luongtrachnhiem;
    }
    public double getLuongtrachnhiem()
    {
        return luongtrachnhiem;
    }
    public double getThunhap()
    {
        return getLuong() + getLuongtrachnhiem();
    }

}
