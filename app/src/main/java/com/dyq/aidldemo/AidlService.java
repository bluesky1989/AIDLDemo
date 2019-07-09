package com.dyq.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class AidlService extends Service {

    private List<Book> list;

    //创建Binder对象(实现BookManager AIDL接口)
    private IBinder binder=new BookManager.Stub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            list.add(book);
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return list;
        }
    };

    public AidlService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化list
        list=new ArrayList<>();
        //向list中添加值
        list.add(new Book("1","Android开发艺术探索"));
        list.add(new Book("2","剑指offer Java版"));
    }
}
