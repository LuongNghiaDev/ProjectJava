package com.company;

import java.util.Scanner;

public abstract class NhanVien {
    private String ma,hoten,loai;
    private double luong;

    public abstract double getThunhap();

    public NhanVien()
    {

    }

    public NhanVien(String ma,String hoten,String loai,double luong)
    {
        this.ma=ma;
        this.hoten=hoten;
        this.loai=loai;
        this.luong=luong;
    }
    public void nhap(Scanner s){
        System.out.println("Nhập mã: ");
        ma=s.nextLine();
        System.out.println("Nhập họ tên: ");
        hoten=s.nextLine();
        System.out.println("Nhập lương: ");
        luong=s.nextDouble();
        s.nextLine();
    }
    public void xuat(){
        System.out.printf("Mã: %s - Họ tên: %s - lương: %f Thu nhập: %f",ma,hoten,loai,luong,getThunhap());
    }
    public void setMa(String ma){
        this.ma=ma;
    }
    public String getMa(){
        return ma;
    }
    public void setHoten(String hoten){
        this.hoten=hoten;
    }
    public String getHoten(){
        return hoten;
    }
    public void setLoai(String loai){
        this.loai=loai;
    }
    public String getLoai(){
        return loai;
    }
    public void setLuong(double luong){
        this.luong=luong;
    }
    public double getLuong(){
        return luong;
    }

}
