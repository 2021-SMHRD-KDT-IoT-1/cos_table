package kr.or.smhrd.a3rd_cos_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest extends AppCompatActivity {

    Socket socket;
    private String ip = ""; // 라파 ip 주소
    private  int port = 0; // 라파 포트 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_test);

        ConnectThread thread = new ConnectThread();
        thread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ConnectThread extends Thread{
        @Override
        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName(ip);
                socket = new Socket(serverAddr, port);

                String u_cos_data = "test";
                Log.d("u_cos_date", u_cos_data);

                //데이터 전송
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                out.println(u_cos_data);

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}