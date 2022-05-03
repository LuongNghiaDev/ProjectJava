package Thuattoan;

import java.util.Scanner;

public class sangnguyento {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = s.nextInt();
        boolean bool[] = new boolean[num];

        for (int i=0;i<bool.length;i++){
            bool[i]=true;
        }
        for (int i=2;i<Math.sqrt(num);i++){
            if(bool[i]==true){
                for (int j=i*i;j<num;j=j+i){
                    bool[j]=false;
                }
            }
        }
        for (int i=2;i<num;i++){
            if(bool[i]==true){
                System.out.println(i);
            }
        }
    }
}
