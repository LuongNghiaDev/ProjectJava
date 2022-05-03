package daluong;


public class testdongbo extends Thread{
    private dongboluong t;
    private String sname;

    public testdongbo(dongboluong ts,String name){
        this.t=ts;
        this.sname=name;
    }

    @Override
    public void run() {
        t.show(sname);
    }
}
class test extends Thread{
    private String name;

    public test(String sname){
        this.name=sname;
    }

    @Override
    public void run() {
        methol.wai(name);
    }
}

