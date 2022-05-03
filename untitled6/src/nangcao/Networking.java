package nangcao;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Networking {
    //khách kết nối với máy chủ(SocketClient)
    public static void main(String[] args) {
        String severName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            System.out.println("Conection: "+severName+"port: "+port);
            Socket client = new Socket();

            System.out.println("Just connection: "+client.getRemoteSocketAddress());
            //trả về địa chỉ điểm cuối của ổ cắm
            OutputStream out = client.getOutputStream();
            DataOutputStream data = new DataOutputStream(out);

            data.writeUTF("Hello: "+client.getLocalAddress());
            //lấy địa chỉ cục bộ đc liên kết

            InputStream inp = client.getInputStream();
            DataInputStream dataa = new DataInputStream(inp);

            System.out.println("say: "+dataa.readUTF());
            client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}


//máy chủ lắng nghe máy khách trên số cổng đc chỉ định bởi đối số dòng lệnh(SocketSever)
class Sever extends Thread{
    private ServerSocket serverSocket;

    public Sever(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run(){
        while (true){
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                //trả về số cổng đc kết nối sau khi ổ cắm đóng(nếu ổ cắm đóng)
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                //trả về địa chỉ điểm cuối của ổ cắm
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
                        + "\nGoodbye!");
                //lấy địa chỉ cục bộ đc liên kết
                server.close();
            }catch (SocketTimeoutException e){
                System.out.println("time out");
                break;
            }catch (IOException r){
                r.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try{
            Thread t = new Sever(port);
            t.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

