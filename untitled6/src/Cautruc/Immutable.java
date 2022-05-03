package Cautruc;

public class Immutable {
    public static void main(String[] args) {
        //Immutable(String bất biến,ko thay đổi)
        String str1 = new String("first");

        String str2 = str1;
        str1 = str1.concat("second");

        //System.out.println("str1: "+str1);
        //System.out.println("str2: "+str2);

        //Mutable(String thay đổi)
        StringBuffer str3 = new StringBuffer("hello");

        StringBuffer str4 = str3;

        str3.append("second");
        System.out.println("str1: "+str3);
        System.out.println("str2: "+str4);
    }
}
