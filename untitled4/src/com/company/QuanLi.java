package com.company;

import java.util.Scanner;

public class QuanLi extends NhanVien{

    private double doanhso;
    private double hoahong;

    public QuanLi()
    {

    }
    public QuanLi(String ma,String hoten,double luong,double doanhso,double hoahong)
    {
        super(ma,hoten,"Quan Li",luong);
        this.doanhso=doanhso;
        this.hoahong=hoahong;
    }
    public void nhap(Scanner s)
    {
        super.nhap(s);
        System.out.println("Nhập doanh số: ");
        doanhso=s.nextDouble();
        System.out.println("Nhập hoa hồng: ");
        hoahong=s.nextDouble();
        s.nextLine();
    }
    public void xuat()
    {
        super.xuat();
        System.out.printf(" Doanh số: %f - Hoa hồng: %f ",doanhso,hoahong);
    }
    public void setDoanhso(double doanhso)
    {
        this.doanhso=doanhso;
    }
    public double getDoanhso()
    {
        return doanhso;
    }
    public void setHoahong(double hoahong)
    {
        this.hoahong=hoahong;
    }
    public double getHoahong()
    {
        return hoahong;
    }
    public double getThunhap()
    {
        return getLuong() + getDoanhso() * getHoahong() /100;
    }
}
