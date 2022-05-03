package daluong;

public class thread extends Thread{
    private Thread t;
    private String sname;

    thread(String name){
        sname=name;
        System.out.println("create: "+sname);
    }

    @Override
    public void run() {
        System.out.println("Running: "+sname);
        try{
            for (int i=4;i>=0;i--){
                System.out.println("Thread: "+sname+" ,"+i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("Thread: "+sname+" inter");
        }
        System.out.println("Thread: "+sname+" exit");
    }

    @Override
    public synchronized void start() {
        System.out.println("Start: "+sname);
        if(t==null){
            t = new Thread(this,sname);
            t.start();
        }
    }
}
