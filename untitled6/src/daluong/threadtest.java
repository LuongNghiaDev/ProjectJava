package daluong;

import daluong.thread;

public class threadtest {
    public static void main(String[] args) {
        System.out.println("Main running: ");

        thread t1 = new thread("Thread-1-data");
        t1.start();

        thread t2 = new thread("Thread-2-email");
        t2.start();

        System.out.println("Main running stop");
    }
}
