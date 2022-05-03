package Cautruc;

import java.util.Arrays;

public class Array {
    public static int remove(int[] a,int val){
        int n = a.length;

        for (int i=0;i < n;){
            if(a[i]==val){
                for (int j=i;j <= (n-2);j++){
                    a[j]=a[j+1];
                }
                n--;
            }else {
                i++;
            }
        }
        return n;
    }
    public static int removeContro(int[] a,int x){
        int k =0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] != x){
                a[k] = a[i];
                k++;
            }else {

            }
        }
        return k;
    }
    public static void addContro(int[] n1,int m,int[] n2,int n){
        int i = m-1;
        int j = n-1;
        int k = (m+n)-1;

        while (k >= 0){
            if (j < 0){
                n1[k] = n1[i];
                i--;
            }else if(i < 0){
                n1[k] = n2[j];
                j--;
            }else if(n1[i] > n2[j]){
                n1[k] = n1[i];
                i--;
            }else {
                n1[k] = n2[j];
                j--;
            }
            k--;
        }
    }

    //mảng  2 chiều
    public static int maximum(int[][] a){
        int soKhach = a.length;
        int songanhang = a[0].length;

        int max = 0;
        for (int i = 0; i < soKhach; i++) {
            int tonghang=0;
            for (int j = 0; j < songanhang; j++) {
                tonghang += a[i][j];
            }
            if(tonghang> max){
                max = tonghang;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {4,5,6};
        int[] a = {3,2,2,3};
     //   System.out.println(remove(a,2));
     //   addContro(n1,3,n2,3);

        int[][] b= {{1,2,3},{3,2,1}};
        maximum(b);
    }
}
