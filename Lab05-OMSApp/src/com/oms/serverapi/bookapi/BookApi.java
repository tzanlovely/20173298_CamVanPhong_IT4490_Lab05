package com.oms.serverapi.bookapi;

import com.oms.bean.Book;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author phong.cv173298
 * @created 29/12/2020 - 10:08 AM
 * @project oms
 */
public class BookApi implements IBookAPI {
    private static BookApi bookApi;

    public static final String PATH = "http://localhost:8080/";

    private Client client;

    private BookApi() {
        client = ClientBuilder.newClient();
    }

    public static BookApi getInstance() {
        if (bookApi==null) {
            synchronized (BookApi.class) {
                if (bookApi==null) bookApi = new BookApi();
            }
        }
        return bookApi;
    }

    @Override
    public ArrayList<Book> getBooks(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("books");


        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }


        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<Book> res = response.readEntity(new GenericType<ArrayList<Book>>() {});
        System.out.println(res);
        return res;
    }

    @Override
    public Book updateBook(Book book) {
        WebTarget webTarget = client.target(PATH).path("books").path(book.getId());

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));

        Book res = response.readEntity(Book.class);
        return res;
    }
}
