package Thuattoan;

import java.util.Scanner;

public class TravelingSalesman {
    //Khách du lịch thăm với đường đi ngắn nhất
    static int findHamliton(int[][] khoangcach,boolean[] ghetham,int cur,int cities,int count,int chiphi,int cycle){
        if(count==cities && khoangcach[cur][0]>0){
            cycle = Math.min(cycle,chiphi+khoangcach[cur][0]);
            return cycle;
        }
        for (int i=0;i<cities;i++){
            if(ghetham[i]==false && khoangcach[cur][0]>0){
                ghetham[i]=true;
                cycle=findHamliton(khoangcach,ghetham,i,cities,count+1,chiphi+khoangcach[cur][i],cycle);
                ghetham[i]=false;
            }
        }
        return cycle;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cities;
        System.out.println("Nhap so thanh pho: ");
        cities=s.nextInt();

        int khoangcach[][] = new int[cities][cities];
        for (int i=0;i<cities;i++){
            for (int j=0;j<cities;j++){
                System.out.println("Khoang cách từ:"+i+1+"đến thành phố: "+j+1);
                khoangcach[i][j]=s.nextInt();
            }
        }
        boolean[] ghetham = new boolean[cities];
        ghetham[0]=true;
        int cycle = Integer.MAX_VALUE;
        cycle = findHamliton(khoangcach,ghetham,0,cities,1,0,cycle);
        System.out.println(cycle);
    }
}
