package com.sc.streakcamera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sc.streakcamera.R;
import com.sc.streakcamera.util.Tcp;


/**
 * Created by Administrator on 2016/4/6.
 */
public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private Button register;
    private EditText serverIdEdit;
    private EditText portEdit;
    private Button connect;
    Tcp tcpClient;
    private Handler handler = new Handler() {
       @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 0X001:

                    Toast.makeText(LoginActivity.this,"连接成功",Toast.LENGTH_SHORT).show();
//                    if(tcpClient.receive().equals("1")) {
                    if(true) {

                        Intent intent = new Intent(LoginActivity.this, DeviceListFragment.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this,"服务器无响应",Toast.LENGTH_SHORT).show();
                    }

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        serverIdEdit = (EditText)findViewById(R.id.serveridEdit);
        portEdit = (EditText)findViewById(R.id.portEdit);
        connect = (Button)findViewById(R.id.connect);
        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);
        //点击连接服务器按钮
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(receive).start();
            }
        });


//        点击登录按钮
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(loginThread).start();                //运行登录子线程，防止报主进程网络错误
            }
        });
        //点击注册按钮
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        tcpClient.send("客户端断开连接");
        tcpClient.close();
    }
    Runnable receive = new Runnable() {
        @Override
        public void run() {
            do{
                tcpClient = new Tcp("192.168.1.108",10002);
//                    tcpClient = new Tcp(serverIdEdit.getText().toString(),
//                            Integer.parseInt(portEdit.getText().toString()));
            }while(!tcpClient.isconnect());

            tcpClient.receive();


        }

    };
    /**
     * 登录子线程
     */
    Runnable loginThread = new Runnable() {
        @Override
        public void run() {
//            TCPClient tcpClient = new TCPClient("192.168.1.104",8081);
//            do{
//                tcpClient = new Tcp("192.168.1.125",10002);
//            }while(!tcpClient.isconnect());

            tcpClient.send("账号:"+accountEdit.getText().toString());
            tcpClient.send("密码:" + passwordEdit.getText().toString());
            Message msg = new Message();
//            Bundle bundle=new Bundle();
//            bundle.putString("account", accountEdit.getText().toString());         //会返回自己的用户名密码，没什么卵用
//            bundle.putString("password",passwordEdit.getText().toString());
//            msg.setData(bundle);

            msg.what = 0x001;
            handler.sendMessage(msg);
        }
    };
}
