package bt;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Quanli {
    ArrayList<Nhanvien> list = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    public void Nhap(){
        System.out.println("Danh sach nhan vien: ");
        do {
            String loai;
            System.out.println("1.Nhanvienhc 2.Nhanvientt 3.truongphong 4.Thoat \n");
            loai=s.nextLine();
            if(loai.equals("")) {
                break;
            }
            int iloai = Integer.parseInt(loai);
            switch (iloai) {
                case 1:
                    Nhanvienhanhchinh nvhc = new Nhanvienhanhchinh();
                    nvhc.Nhap(s);
                    list.add(nvhc);
                    break;
                case 2:
                    Nhanvientiepthi nvtt = new Nhanvientiepthi();
                    nvtt.Nhap(s);
                    list.add(nvtt);
                    break;
                case 3:
                    Truongphong tp = new Truongphong();
                    tp.Nhap(s);
                    list.add(tp);
                    break;
                case 4:
                    System.exit(0);
            }
        }while (true);
    }
    public void Xuat(){
        System.out.println("Danh sach nhan vien: ");
        for (Nhanvien nv : list){
            if(nv instanceof Nhanvienhanhchinh){
                ((Nhanvienhanhchinh)nv).Xuat();
            }else if(nv instanceof Nhanvientiepthi){
                ((Nhanvientiepthi)nv).Xuat();
            }else if(nv instanceof Truongphong){
                ((Truongphong)nv).Xuat();
            }
        }
        System.out.println("=================");
    }
    public void themnv(){
        System.out.println("them nhanvien: ");
        String manv;
        manv= s.nextLine();
        Nhanvien nvfound =null;
        for (Nhanvien nv : list){
            if(nv.getManv().equalsIgnoreCase(manv)){
                nvfound=nv;
                break;
            }
        }
        if(nvfound!=null){
            System.out.println("Nhan vien đa dc them");
            list.add(nvfound);
        }else {
            System.out.println("ko tim thay ma nv");
        }
    }
    public void timnhanvien(){
        System.out.println("Tim nhan vien theo ma: ");
        String manv;
        manv=s.nextLine();
        Nhanvien nvfound=null;
        for (Nhanvien nv:list){
            if(nv.getManv().equalsIgnoreCase(manv)){
                nvfound=nv;
                break;
            }
        }
        if(nvfound!=null){
            System.out.println("Da tim thay nv: ");
            nvfound.Xuat();
        }else {
            System.out.println("ko tim thay");
        }
    }
    public void Xoanhanvien(){
        System.out.println("xoa nhan vien theo ma: ");
        String manv;
        manv=s.nextLine();
        Nhanvien nvfound=null;
        for (Nhanvien nv:list){
            if(nv.getManv().equalsIgnoreCase(manv)){
                nvfound=nv;
                break;
            }
        }
        if(nvfound!=null){
            System.out.println("Da tim thay nv: ");
            list.remove(nvfound);
        }else {
            System.out.println("xoa tim thay");
        }
    }
    public void Capnhatnv(){
        System.out.println("Cap nhat nhan vien theo ma: ");
        String manv;
        manv=s.nextLine();
        Nhanvien nvfound=null;
        for (Nhanvien nv:list){
            if(nv.getManv().equalsIgnoreCase(manv)){
                nvfound=nv;
                break;
            }
        }
        if(nvfound!=null){
            System.out.println("Da tim thay nv: ");
            if(nvfound instanceof Nhanvienhanhchinh){
                ((Nhanvienhanhchinh)nvfound).Nhap(s);
            }else if(nvfound instanceof Nhanvientiepthi){
                ((Nhanvientiepthi)nvfound).Nhap(s);
            }else if(nvfound instanceof Truongphong){
                ((Truongphong)nvfound).Nhap(s);
            }
        }else {
            System.out.println("ko tim thay");
        }
    }
    public void timkhoangluong(){
        System.out.println("Khoang luong lon: ");
        double max=s.nextDouble();
        System.out.println("Khoang luong thap: ");
        double min =s.nextDouble();
        Nhanvien nvfound=null;
        for (Nhanvien nv : list){
            if(min <= nv.Tinhluong() && nv.Tinhluong() <= max){
                nvfound=nv;
                break;
            }
        }
        if(nvfound!=null){
            System.out.println("Nhan vien theo luong: ");
            nvfound.Xuat();
        }else {
            System.out.println("ko tim thay");
        }
    }
    public void sapseptheoluong(){
        System.out.println("Sap sep: ");
        Collections.sort(list,(a,b)-> (int) (a.Tinhluong() - b.Tinhluong()));
    }
    public void sapseptheoten(){
        System.out.println("sap sep: ");
        Collections.sort(list,(a,b)-> a.getHoten().compareTo(b.getHoten()));
    }
    public void tim5nguoiluongcaonhat(){
        Collections.sort(list,(a,b)-> (int) (a.Tinhluong() - b.Tinhluong()));
        System.out.println("5 ngươi luongcao nhat: ");
        for (int i=0;i<5 && i<list.size();i++){
            list.get(i).Xuat();
        }
    }
}
