package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachNhanVien {

    private ArrayList<NhanVien> list = new ArrayList<>();

    public void Nhap()
    {
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Nhập lựa chọn: (1.Nvhanhchinh,2.Quanli,3.TruongPhong,4.Thoat)");
            String loai = s.nextLine();

            if (loai == null || loai.equals("")) {
                break;
            }
            int iloai = Integer.parseInt(loai);
            switch (iloai)
            {
                case 1:
                    NhanVienHanhChinh nvhc = new NhanVienHanhChinh();
                    nvhc.nhap(s);
                    list.add(nvhc);
                    break;
                case 2:
                    QuanLi ql = new QuanLi();
                    ql.nhap(s);
                    list.add(ql);
                    break;
                case 3:
                    TruongPhong tp = new TruongPhong();
                    tp.nhap(s);
                    list.add(tp);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
    public void Xuat()
    {
        System.out.println("Danh sách nhân viên: ");
        for(NhanVien nv : list)
        {
            if(nv instanceof NhanVienHanhChinh){
                ((NhanVienHanhChinh)nv).xuat();
            }else if(nv instanceof QuanLi){
                ((QuanLi)nv).xuat();
            }else if(nv instanceof TruongPhong){
                ((TruongPhong)nv).xuat();
            }
        }
        System.out.println("=====================\n");
    }
    public void timnvtheoma()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhân viên càn tìm theo mã: ");
        String ma = s.nextLine();

        NhanVien nvFound = null;
        for(NhanVien nv : list)
        {
            if(nv.getMa().equalsIgnoreCase(ma)){
                nvFound=nv;
                break;
            }
        }
        if(nvFound != null)
        {
            System.out.println("Nhân viên cần tìm theo mã: ");
            nvFound.xuat();
        }else{
            System.out.println("Không tìm thấy nhân viên theo mã"+ma);
        }
    }
    public void xoanvtheoma()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhân viên cần tìm theo mã :");
        String ma = s.nextLine();

        NhanVien nvFound = null;
        for(NhanVien nv : list)
        {
            if(nv.getMa().equalsIgnoreCase(ma)){
                nvFound=nv;
                break;
            }
        }
        if(nvFound != null){
            System.out.println("Nhân viên cần xóa theo mã: ");
            list.remove(nvFound);
        }else{
            System.out.println("KHông tìm thấy nv theo mã");
        }
    }
    public void Capnhatnv()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhân viên cần tìm theo mã :");
        String ma = s.nextLine();

        NhanVien nvFound = null;
        for(NhanVien nv : list)
        {
            if(nv.getMa().equalsIgnoreCase(ma)){
                nvFound=nv;
                break;
            }
        }
        if(nvFound != null){
            if(nvFound instanceof NhanVienHanhChinh){
                ((NhanVienHanhChinh)nvFound).nhap(s);
            }else if(nvFound instanceof QuanLi){
                ((QuanLi)nvFound).nhap(s);
            }else if(nvFound instanceof TruongPhong){
                ((TruongPhong)nvFound).nhap(s);
            }
        }else {
            System.out.println("KHông tìm thấy nv theo mã");
        }
    }
    public void timkhoangluong()
    {
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
        if(found == false){
            System.out.println("Không tìm thấy khoảng lương");
        }
    }
    public void sapsepten()
    {
        Collections.sort(list,(a,b)->a.getHoten().compareTo(b.getHoten()));
    }
    public void sapsepthunhap()
    {
        Collections.sort(list,(a,b)->(int)(a.getThunhap()-b.getThunhap()));
    }
    public void Top5()
    {
        System.out.println("Danh sách 5 nhân viên có thu nhập cao nhất: ");
        Collections.sort(list,(a,b)->(int)(b.getThunhap()-a.getThunhap()));
        for(int i=0;i<=5 && i<=list.size();i++){
            list.get(i).xuat();
        }
    }
}