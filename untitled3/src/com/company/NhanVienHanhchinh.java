package com.company;

import java.util.Scanner;

public class NhanVienHanhchinh extends NhanVien{

    public NhanVienHanhchinh(){

    }
    public NhanVienHanhchinh(String ma,String hoten,double luong){
        super(ma,hoten,"Hanh chinh",luong);
    }
    public void nhap(Scanner s){
        super.nhap(s);
    }
    public void xuat(){
        super.xuat();
    }
    public double getThunhap(){
        return getLuong();
    }

}
