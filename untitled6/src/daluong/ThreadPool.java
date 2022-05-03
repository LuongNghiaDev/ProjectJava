package daluong;

public class ThreadPool implements Runnable {
    private String message;

    public ThreadPool(String s){
        this.message=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" message: "+message);
        poss();
        System.out.println(Thread.currentThread().getName()+" end");
    }

    private void poss(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
