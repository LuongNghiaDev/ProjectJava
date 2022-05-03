package Cautruc;

public class Dequy {
    public static int GiaiThua(int n){
        if(n==0){
            return 1;
        }
        return n * GiaiThua(n-1);
    }

    public static int fibonaci(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fibonaci(n-1)+fibonaci(n-2);
    }

    public static void print(int[] arr,int index){
        if(index<0 || index >= arr.length){
            return;
        }
        print(arr,index+1);
        System.out.println(arr[index]);
    }

    public static boolean swap(char[] arr, int i, int j){
        if(i<j){
            char t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            swap(arr,i+1,j-1);
        }
        return false;
    }

    public static void move(int n,char cotnguon,char cotdich,char cottrunggian){
        if(n==1){
            System.out.println("Di chuyển từ : "+ cotnguon +" tới cột đích: "+cotdich );
            return;
        }
        move(n-1,cotnguon,cottrunggian,cotdich);
        System.out.println("Di chuyển từ cột : "+ cotnguon +" tới cột đích: "+cotdich );
        move(n-1,cottrunggian,cotdich,cotnguon);
    }

    public static void main(String[] args) {
       // System.out.println(fibonaci(5));
       // int[] arr ={1,2,3,4,5,6,7,8,9};
       // print(arr,0);
       // char[] s = {'1','2','3','4','5'};
       // swap(s,0, s.length-1);
          int n = 4;
          move(n,'A','B','C');
    }

    //lập trình động
}
