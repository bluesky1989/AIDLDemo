// BookManager.aidl
package com.dyq.aidldemo;

// Declare any non-default types here with import statements

import com.dyq.aidldemo.Book;

interface BookManager {
    void addBook(in Book book);
    List<Book> getBookList();
}
