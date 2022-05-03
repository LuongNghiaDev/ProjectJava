package com.company;

import java.util.Scanner;

public class NhanVienTiepThi extends NhanVien{
    private double doanhso;
    private double hoahong;

    public NhanVienTiepThi(){

    }
    public NhanVienTiepThi(String ma,String hoten,double luong,double doanhso,double hoahong){
        super(ma,hoten,"Tiep Thi",luong);
        this.doanhso=doanhso;
        this.hoahong=hoahong;
    }
    public void setDoanhso(double doanhso){
        this.doanhso=doanhso;
    }
    public double getDoanhso(){
        return doanhso;
    }
    public void setHoahong(double hoahong){
        this.hoahong=hoahong;
    }
    public double getHoahong(){
        return hoahong;
    }
    public void nhap(Scanner s){
        super.nhap(s);
        System.out.println("NHập doanh số: ");
        doanhso=s.nextDouble();
        System.out.println("Nhập hoa hồng: ");
        hoahong=s.nextDouble();
        s.nextLine();
    }
    public void xuat(){
        super.xuat();
        System.out.printf(" Doanh số: %f - Hoa Hồng: %f",doanhso,hoahong);
    }
    public double getThunhap(){
        return getLuong() + getDoanhso() * getHoahong() /100;
    }

}
