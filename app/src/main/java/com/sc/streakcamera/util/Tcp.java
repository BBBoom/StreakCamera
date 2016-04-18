package com.sc.streakcamera.util;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Tcp {
    public PrintStream out;
    public InputStreamReader streamReader;
    Socket socket;
    BufferedReader reader;
    boolean isconnect = false;
    public  Tcp(String serverIP, int port) {
        try {
            socket = new Socket(serverIP,port);
//            socket = new Socket("192.168.1.104", 10001);
            out = new PrintStream(socket.getOutputStream());
            streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            isconnect = true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            isconnect = false;
            Looper.prepare();
            Toast.makeText(MyApplication.getContext(),"123",Toast.LENGTH_SHORT).show();
            Looper.loop();
        } catch (IOException e) {
            e.printStackTrace();
            isconnect = false;
            Looper.prepare();
            Toast.makeText(MyApplication.getContext(),"网络连接异常",Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }
    public boolean isconnect(){
        return isconnect;
    }

    public void send(String sendedMessage) {

        out.println(sendedMessage);
        out.flush();                       //清空缓存区，因为要等缓存区满或者flush才输出
        Log.d("send",sendedMessage);
    }
    public String receive(){

        String receivedMessage ="";
        String retData = "";
        try{
//            Log.d("receive","dfa"+(receivedMessage = reader.readLine())+"fsdfsd");
                while ((retData = reader.readLine())!=null) {             //分行读取
                    receivedMessage += retData;
                    Log.d("receive",retData);
                }


//            reader.close();
        }catch (UnknownHostException e1){
            e1.printStackTrace();
            Looper.prepare();
            Toast.makeText(MyApplication.getContext(),"网络连接异常",Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
        catch (IOException e){
            e.printStackTrace();
            Looper.prepare();
            Toast.makeText(MyApplication.getContext(),"无法连接至服务器",Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
        return receivedMessage;
    }
    public void close(){
        try {
            socket.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }

}





