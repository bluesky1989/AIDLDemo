package com.dyq.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author:duyongqiang
 * mail: duyongqiang09@126.com
 * date:2019/7/9
 * Description:
 */
public class Book implements Parcelable {
    private String bookId;
    private String bookName;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookId);
        dest.writeString(this.bookName);
    }

    public Book(String bookId,String bookName) {
        this.bookId=bookId;
        this.bookName=bookName;
    }

    protected Book(Parcel in) {
        this.bookId = in.readString();
        this.bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
