package daluong;

public class dongboluong {
    public synchronized void show(String name){
        for(int i=0;i<=5;i++){
            System.out.println(name+" "+i);
        }
    }
}
class methol{
    public static synchronized void wai(String name){
        for(int i=0;i<=5;i++){
            System.out.println(name+" "+i);
        }
    }
}
class block{
    public void blockk(String name){
        synchronized (this){
            for(int i=0;i<=5;i++){
                System.out.println(name+" "+i);
            }
        }
    }
}


