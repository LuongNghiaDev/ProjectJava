package nangcao;

import java.io.*;

public class Serialization implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void check(){
        System.out.println("check: "+name+" "+address);
    }

    public static void main(String[] args) {
        Serialization e = new Serialization();

        e.name="nghia";
        e.address="haiduong";
        e.SSN=10101;
        e.number=014422;

        try {
            FileOutputStream file = new FileOutputStream("/tmp/Serialization");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(e);
            out.close();
            file.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
}
class Demo{
    public static void main(String[] args) {
        Serialization e = null;
        try {
            FileInputStream file = new FileInputStream("/tmp/Serialization");
            ObjectInputStream out = new ObjectInputStream(file);
            e = (Serialization) out.readObject();
            out.close();
            file.close();
        }catch (IOException i){
            i.printStackTrace();
            return;
        }catch (ClassNotFoundException c){
            System.out.println("NOt found");
            c.printStackTrace();
            return;
        }

        System.out.println("tutorial: ");
        System.out.println("Name: "+e.name);
        System.out.println("Address: "+e.address);
        System.out.println("SSD: "+e.SSN);
        System.out.println("number: "+e.number);

    }
}
