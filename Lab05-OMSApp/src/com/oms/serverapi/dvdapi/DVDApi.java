package com.oms.serverapi.dvdapi;

import com.oms.bean.DigitalVideoDisc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author phong.cv173298
 * @created 29/12/2020 - 10:19 AM
 * @project oms
 */
public class DVDApi implements IDVDApi {
    private static DVDApi dvdApi;

    public static final String PATH = "http://localhost:8080/";

    private Client client;

    private DVDApi() {
        client = ClientBuilder.newClient();
    }

    public static DVDApi getInstance() {
        if (dvdApi==null) {
            synchronized (DVDApi.class) {
                if (dvdApi==null) dvdApi = new DVDApi();
            }
        }

        return dvdApi;
    }

    @Override
    public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("dvds");


        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }


        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<DigitalVideoDisc> res = response.readEntity(new GenericType<ArrayList<DigitalVideoDisc>>() {});
        System.out.println(res);
        return res;
    }
}
