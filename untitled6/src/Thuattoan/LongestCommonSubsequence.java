package Thuattoan;

import java.util.Scanner;

public class LongestCommonSubsequence {
    //chuỗi con chung dài nhất
    public static int getLength(char[] str1,char[] str2,int p,int v){
        if(p==0 || v==0){
            return 0;
        }
        if(str1[p-1] == str2[v-1]){
            return 1+getLength(str1,str2,p-1,v-1);
        }else {
            return maxValue(getLength(str1,str2,p,v-1),getLength(str1,str2,p-1,v));
        }
    }
    static int maxValue(int length1,int length2){
        if(length1 > length2){
            return length1;
        }else {
            return length2;
        }
    }
}

