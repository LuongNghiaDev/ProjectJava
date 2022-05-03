package bt;

import java.util.Scanner;

public abstract class Nhanvien {
    String manv,loai,hoten;
    double luong;

    public abstract double Tinhluong();

    public Nhanvien(){

    }
    public Nhanvien(String manv,String hoten,String loai,double luong){
        this.manv=manv;
        this.hoten=hoten;
        this.loai=loai;
        this.luong=luong;
    }

    public void Nhap(Scanner s){
        System.out.println("Nhap manv: ");
        manv=s.nextLine();
        System.out.println("Nhap hoten: ");
        hoten=s.nextLine();
        System.out.println("Nhap luong: ");
        luong=s.nextDouble();
        s.nextLine();
    }
    public void Xuat(){
        System.out.printf("Manv: %s - hoten: %s - luong: %f - Tinhluong: %f",manv,hoten,luong,Tinhluong());
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}
