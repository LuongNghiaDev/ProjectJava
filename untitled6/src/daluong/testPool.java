package daluong;

import daluong.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class testPool {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(6);
        for (int i=0;i<6;i++){
            Runnable r = new ThreadPool(" "+ i);
            ex.execute(r);
        }
        try{
            ex.awaitTermination(1, TimeUnit.DAYS); //thoi gian song
        }catch (Exception e){
            e.printStackTrace();
        }
        ex.shutdown();
        while (!ex.isTerminated()){ }
        System.out.println("");
    }
}
