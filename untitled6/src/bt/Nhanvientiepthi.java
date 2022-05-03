package bt;

import java.util.Scanner;

public class Nhanvientiepthi extends Nhanvien{
    private double hoahong;
    private double tienthem;

    public Nhanvientiepthi(){

    }
    public Nhanvientiepthi(String manv,String hoten,double luong,double hoahong,double tienthem){
        super(manv,hoten,"Nhanvientiepthi",luong);
        this.hoahong=hoahong;
        this.tienthem=tienthem;
    }

    public void Nhap(Scanner s){
        super.Nhap(s);
        System.out.println("Nhap hoahong: ");
        hoahong=s.nextDouble();
        System.out.println("Nhap tienthem: ");
        tienthem=s.nextDouble();
        s.nextLine();
    }

    public void Xuat(){
        super.Xuat();
        System.out.printf(" - hoahong: %f - tieenthem: %f - Tinhluong: %f",hoahong,tienthem,Tinhluong());
    }

    public double getHoahong() {
        return hoahong;
    }

    public void setHoahong(double hoahong) {
        this.hoahong = hoahong;
    }

    public double getTienthem() {
        return tienthem;
    }

    public void setTienthem(double tienthem) {
        this.tienthem = tienthem;
    }

    @Override
    public double Tinhluong() {
        return luong*(hoahong+tienthem)/2;
    }
}
