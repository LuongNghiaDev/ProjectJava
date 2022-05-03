package bt;

import java.util.Scanner;

public class Nhanvienhanhchinh extends Nhanvien{

    public Nhanvienhanhchinh(){

    }
    public Nhanvienhanhchinh(String manv,String hoten,double luong){
        super(manv,hoten,"Nhanvienhanhchinh",luong);
    }

    public void Nhap(Scanner s){
        super.Nhap(s);
    }
    public void Xuat(){
        super.Xuat();
    }
    @Override
    public double Tinhluong() {
        return this.luong;
    }
}
