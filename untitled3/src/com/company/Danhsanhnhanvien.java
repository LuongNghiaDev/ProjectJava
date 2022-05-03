package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Danhsanhnhanvien {
    private ArrayList<NhanVien> list = new ArrayList<>();

    public void Nhap(){
        Scanner s = new Scanner(System.in);
        list.clear();
        do{
            System.out.println("Nhập loại nhân viên:(1.nvHanhchinh,2.nvTiepThi,3.TruongPhong,0.Thoat)");
            String loai = s.nextLine();

            if(loai != null || loai.equals("")){
                break;
            }
            int iloai = Integer.parseInt(loai);

            switch (iloai){
                case 1:
                    NhanVienHanhchinh nvhc = new NhanVienHanhchinh();
                    nvhc.nhap(s);
                    list.add(nvhc);
                    break;
                case 2:
                    NhanVienTiepThi nvtt = new NhanVienTiepThi();
                    nvtt.nhap(s);
                    list.add(nvtt);
                    break;
                case 3:
                    TruongPhong tp = new TruongPhong();
                    tp.nhap(s);
                    list.add(tp);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }while(true);
    }
    public void xuat(){
        System.out.println("Danh sách nhân viên: ");
        for(NhanVien nv : list){
            if(nv instanceof NhanVienHanhchinh){
                ((NhanVienHanhchinh)nv).xuat();
            }else if(nv instanceof NhanVienTiepThi){
                ((NhanVienTiepThi)nv).xuat();
            }else if(nv instanceof TruongPhong){
                ((TruongPhong)nv).xuat();
            }
        }
        System.out.println("=====================\n");
    }
    public void timnvtheoma(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên cần tìm: ");
        String ma = s.nextLine();

        NhanVien nvFound = null;
        for(NhanVien nv : list){
            if(nv.getMa().equalsIgnoreCase(ma)){
                nvFound=nv;
                break;
            }
        }
        if(nvFound != null){
            System.out.println("Nhân viên cần tìm theo mã là: ");
            nvFound.xuat();
        }else{
            System.out.printf("Không tim thấy nhân viên theo mã: ",ma);
        }
    }
    public void xoanvtheoma(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập mã nhân viền cần xóa: ");
        String ma = s.nextLine();

        NhanVien nvFound = null;
        for(NhanVien nv : list){
            if(nv.getMa().equalsIgnoreCase(ma)){
                nvFound=nv;
                break;
            }
        }
        if(nvFound != null){
            System.out.println("Nhân viên cần xóa theo mã: "+ma);
            list.remove(nvFound);
        }else {
            System.out.println("Không tìm thấy nhân viên theo mã: "+ma);
        }
    }
    public void capnhatvctheoma(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhân viên theo mã cần cập nhật: ");
        String ma = s.nextLine();

        NhanVien nvFound = null;
        for(NhanVien nv : list){
            if(nv.getMa().equalsIgnoreCase(ma)){
                nvFound=nv;
                break;
            }
        }
        if(nvFound != null){
            if(nvFound instanceof NhanVienHanhchinh){
                ((NhanVienHanhchinh)nvFound).nhap(s);
            }else if(nvFound instanceof NhanVienTiepThi){
                ((NhanVienTiepThi)nvFound).nhap(s);
            }else if(nvFound instanceof TruongPhong){
                ((TruongPhong)nvFound).nhap(s);
            }
        }else{
            System.out.println("Không tìm thấy nhân viên theo mã: "+ma);
        }
    }
    public void timkhoangluong(){
        Scanner s = new Scanner(System.in);
        System.out.println("Khoảng lương min: ");
        double min = s.nextDouble();
        System.out.println("Khoảng lương max: ");
        double max = s.nextDouble();

        boolean found = false;

        for(NhanVien nv : list){
            if(min <= nv.getLuong() && nv.getLuong() <= max){
                nv.xuat();
                System.out.println();
                found=true;
            }
        }
        if(found==false){
            System.out.println("Không tìm thấy khoảng lương của nhân viên");
        }
    }
    public void sapsepten(){
        Collections.sort(list,(a,b) -> a.getHoten().compareTo(b.getHoten()));
    }
    public void sapseptheothunhap(){
        Collections.sort(list,(a,b)->(int)(a.getThunhap()-b.getThunhap()));
    }
    public void top5(){
        Collections.sort(list,(a,b)->(int)(b.getThunhap()-a.getThunhap()));
        System.out.println("Top 5 nhân viên có thu nhập cao nhất: ");
        for(int i=0;i<=5 && i<=list.size();i++){
            list.get(i).xuat();
        }
    }

}
