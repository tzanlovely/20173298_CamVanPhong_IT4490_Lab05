package com.oms.serverapi.bookapi;

import com.oms.bean.Book;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author phong.cv173298
 * @created 29/12/2020 - 10:06 AM
 * @project oms
 */
public interface IBookAPI {
    public ArrayList<Book> getBooks(Map<String, String> queryParams);

    public Book updateBook(Book book);
}
