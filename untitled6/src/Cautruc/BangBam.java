package Cautruc;

import java.util.ArrayList;
import java.util.Objects;

public class BangBam {
    //HashSet quản lí key
    private final int size = 1000;
    private ArrayList<Integer> Bucket[];

    BangBam(){
        Bucket = new ArrayList[size];
        for (int i = 0; i < Bucket.length; i++) {
            Bucket[i]= new ArrayList<>();
        }//từng pt 1 Array
    }
    //chuyển về hashValue
    private int hashFunction(int key){
        return key%size;
    }

    public void add(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = Bucket[hashValueIndex];//chứa những key
        int keyIndex = bucket.indexOf(key); //trả về vị trí xuất hiện
        if(keyIndex < 0){
            bucket.add(key);
        }
    }

    public void remove(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = Bucket[hashValueIndex];
        int keyIndex = bucket.indexOf(key);
        if(keyIndex >= 0){
            bucket.remove(keyIndex);
        }
    }

    private boolean contains(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = Bucket[hashValueIndex];
        int keyIndex = bucket.indexOf(key);
        return keyIndex >= 0;
    }

    public static void main(String[] args) {
        BangBam m = new BangBam();
        m.add(1);
        m.add(1);
        m.add(2);
        System.out.println("contains: "+m.contains(1));
        m.remove(1);
        System.out.println("contains: "+m.contains(1));
    }

}
class HashMap{
    //HashMap quản lí key-value

    private class Data{ //obj chứa key,value
        int key;
        int value;
        Data(int key,int value){
            this.key=key;
            this.value=value;
        }

        @Override //so sánh key
        public boolean equals(Object other) {
            if(other instanceof  Data)
                return this.key==((Data) other).key;
            return false;
        }
    }

    private final int size=1000;
    private  ArrayList<Data> Bucket[];

    HashMap(){
        Bucket = new ArrayList[size];
        for (int i = 0; i < Bucket.length; i++) {
            Bucket[i]= new ArrayList<>();
        }//khởi tạo từng pt 1 Array
    }

    private int hashFunction(int key){
        return key%size;
    }

    public void put(int key,int value){
        int hashValueIndex = hashFunction(key);
        ArrayList<Data> bucket = Bucket[hashValueIndex];
        Data newData = new Data(key,value); //tạo obj có cùng key
        int keyIndex = bucket.indexOf(newData);
        if(keyIndex >= 0){ //index từ 0
            bucket.get(keyIndex).value = value;
        }else {
            bucket.add(newData);
        }
    }

    public void remove(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Data> bucket = Bucket[hashValueIndex];
        Data deleteData = new Data(key,0); //tạo obj có cùng key
        bucket.remove(deleteData);
    }

    public int get(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Data> bucket = Bucket[hashValueIndex];
        Data findData = new Data(key,0); // tạo obj có cùng key
        int keyIndex = bucket.indexOf(findData);
        if(keyIndex >=0){
            return bucket.get(keyIndex).value;
        }
        return -1;
    }

    public static void main(String[] args) {
        HashMap s = new HashMap();
        s.put(1,1);
        s.put(1,2);
        s.put(10,2);
        System.out.println("s.get(1)):  "+s.get(1));
        System.out.println("s.get(2)):  "+s.get(2));
        s.remove(1);
        System.out.println("s.get(1)):  "+s.get(1));
        System.out.println("s.get(10)):  "+s.get(10));
    }
}

