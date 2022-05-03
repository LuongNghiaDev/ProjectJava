package bt;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Scanner;

public class Truongphong extends Nhanvien{
    private double luongtrachnhiem;

    public Truongphong(){

    }
    public Truongphong(String manv,String hoten,double luong,double luongtrachnhiem){
        super(manv,hoten,"Truongphong",luong);
        this.luongtrachnhiem=luongtrachnhiem;
    }
    public void Nhap(Scanner s){
        super.Nhap(s);
        System.out.println("Nhap luong trachnhiem: ");
        luongtrachnhiem=s.nextDouble();
        s.nextLine();
    }
    public void Xuat(){
        super.Xuat();
        System.out.printf("- luongtrachnhiem: %f - Tinhluong: %f",luongtrachnhiem,Tinhluong());
    }

    public double getLuongtrachnhiem() {
        return luongtrachnhiem;
    }

    public void setLuongtrachnhiem(double luongtrachnhiem) {
        this.luongtrachnhiem = luongtrachnhiem;
    }

    @Override
    public double Tinhluong() {
        return luong+luongtrachnhiem;
    }
}
