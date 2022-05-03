package nangcao;

import java.io.File;
import java.io.IOException;

public class IO {
    public static void main(String[] args) {
        String name = "/tmp/user/java/bin";
        File d = new File(name);
        d.mkdirs();

    }
}
class readd{
    public static void main(String[] args) {
        File file = null;
        String[] path;
        try{
            file=new File("/tmp");
            path=file.list();

            for (String paths: path){
                System.out.println(paths);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}