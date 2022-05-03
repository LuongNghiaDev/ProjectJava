package daluong;

public class vdđongboluog {
    private int bare=1000;

    public vdđongboluog(){
        System.out.println("Số tiền trong tk: "+bare);
    }
    public synchronized void show(int mount){
        System.out.println("Rút tiền: "+mount);
        while (bare<mount){
            System.out.println("KO rút đc");
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(e.toString());
            }
        }
        bare-=mount;
        System.out.println("đã rút đc tiền");
    }
    public synchronized void wai(int mount){
        System.out.println("Bắn tiền vào tk: "+mount);
        bare+=mount;
        System.out.println("đã bắn tiền: số tiền trong tk: "+bare);
        notify();
    }
}
