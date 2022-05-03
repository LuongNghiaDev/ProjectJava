package Thuattoan;

import java.util.Arrays;

public class MegaSortAndQuickSort {
    //Sắp sếp trộn( chia mảng thành từng pt r sắp sếp trộn)
    //thời gian : log2n.n
    public int[] megar(int[] a1, int[] a2) {
        int n = a1.length + a2.length;
        int[] result = new int[n];
        int i = 0, i1 = 0, i2 = 0;
        while (i < n) {
            if (i1 < a1.length && i2 < a2.length) { //a1 a2 khác rỗng
                if (a1[i1] <= a2[i2]) {
                    result[i] = a1[i1];
                    i++;
                    i1++;
                } else {
                    result[i] = a2[i2];
                    i++;
                    i2++;
                }
            } else { //a1,a2 rỗng
                if (i1 < a1.length) {
                    result[i] = a1[i1];
                    i++;
                    i1++;
                } else {
                    result[i] = a2[i2];
                    i++;
                    i2++;
                }
            }
        }
        return result;
    }

    public int[] meSort(int a[], int l, int r) {
        if (l > r) {
            return new int[0];
        }
        if (l == r) {
            int[] singgle = {a[l]};
            return singgle;
        }
        //chia ra
        System.out.println("chia: " + l + "-" + r);
        int k = (l + r) / 2;
        int[] a1 = meSort(a, l, k);
        int[] a2 = meSort(a, k + 1, r);
        //trộn vào
        int[] result = megar(a1, a2);
        System.out.println("ketqua: " + Arrays.toString(result));
        return result;
    }

    public int[] sort(int[] nums) {
        return meSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        MegaSortAndQuickSort s1 = new MegaSortAndQuickSort();
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};
        int[] c = {1,5,3,2,8,7,6,4};
       // System.out.println(Arrays.toString(s1.megar(a,b)));
        System.out.println(Arrays.toString(s1.meSort(c,0,c.length-1)));

    }
}


class QuickSort{
    //sắp sếp nhanh(chọn ra key chia mảng ra r sắp sếp)
    //thời gian: nlogn,n^2
    public static void quickSort(int[] a,int l,int r){
        //đk dừng 1 phần tử
        if(l >= r) return;
        //chọn khóa
        int key = a[(l+r)/2];

        //phân bố mảng theo khóa
        int k = partition(a,l,r,key);
        System.out.println("L= "+ l + " R= " + r + " key= "+key+ " k= "+k);
        System.out.println(Arrays.toString(Arrays.copyOfRange(a,l,r+1)));
        System.out.println("===========");
        //chia đổi mảng
        quickSort(a,l,k-1);
        quickSort(a,k,r);

    }
    public static int partition(int[] a,int l,int r,int key){
        int iL = l;
        int iR = r;
        while (iL <= iR){
            //tìm để đổi chỗ
            while (a[iL] < key) iL++;
            while (a[iR] > key) iR--;
            //đổi chỗ 2 pt
            if(iL <= iR){
                int temp = a[iL];
                a[iL] = a[iR];
                a[iR] = temp;
                iL++;
                iR--;
            }
        }
        return iL;
    }

    public static void main(String[] args) {
        int[] a = {6,7,8,5,4,1,2,3};
        System.out.println(Arrays.toString(a));
        System.out.println("Start: ");
        quickSort(a,0,a.length-1);
        System.out.println("Finish: ");
        System.out.println(Arrays.toString(a));
    }
}
class SapSep{
    // sắp sếp nổi bọt(pt đứng trc lớn hơn pt đứng sau thì đổi)
    //thời gian: n , n^2
    public static void BubbleSort(int[] a){
        int n = a.length;
        for (int i = 0;i<n;i++){
            boolean isSorter = true;
            for (int j = 0;j<n-i-1;j++){ //j+1 < n-i
                if(a[j] > a[j+1]){
                    isSorter = false;
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
            print(i,a);
            if(isSorter){
                break;
            }
        }
    }
    public static void print(int no,int[] a){
        System.out.printf("%d: ", no);
        for (int i=0;i<a.length;i++){
            System.out.printf("%d ",a[i]);
        }
        System.out.println();
    }

    //sắp sếp chèn(chèn pt i(coi như pt0 đã sort) vào pt bên trái thích hợp của nó)
    //thời gian: n , n^2
    public static void insertSort(int[] a){
        int n = a.length;
        for (int i = 1;i<n;i++) {
            //chèn a[i] vào dãy 0 ->i-1
            int ai = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > ai){
                a[j+1] = a[j];
                j--;
            }
            a[j+1]=ai;
            print(i,a);
        }
    }

    //sắp sếp chọn(tìm phần tử nhở nhất bên phải và đổi chỗ cho a[i])
    //thời gian: n^2
    public static void selectSort(int[] a){
        int n = a.length;
        for (int i = 0;i<n-1;i++) {
            for (int j = i+1; j < n; j++) {
                int temp = a[i];
                if(a[i] > a[j]){
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            print(i,a);
        }
    }

    public static void main(String[] args) {
        int[] a = {5,3,2,7,8,1,2};
       // BubbleSort(a);
       // insertSort(a);
        selectSort(a);
    }
}

