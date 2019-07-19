package com.dyq.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获取BookManager AIDL实例
            BookManager bookManager=BookManager.Stub.asInterface(service);
            try {
                List<Book> bookList=bookManager.getBookList();
                Log.e(TAG,"从服务端获取的bookList="+bookList.toString());

                bookManager.addBook(new Book("3","第一行代码第二版"));
                List<Book> books=bookManager.getBookList();
                Log.e(TAG,"调用BookManager AIDL接口添加一本书后,从服务端获取的bookList="+books);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定服务
        Intent intent=new Intent(this,AidlService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑服务
        unbindService(serviceConnection);
    }
}
