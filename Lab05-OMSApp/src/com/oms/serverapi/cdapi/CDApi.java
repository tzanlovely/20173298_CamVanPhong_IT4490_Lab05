package com.oms.serverapi.cdapi;

import com.oms.bean.CompactDisc;

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
public class CDApi implements ICDApi {
    private static CDApi cdApi;

    public static final String PATH = "http://localhost:8080/";

    private Client client;

    private CDApi() {
        client = ClientBuilder.newClient();
    }

    public static CDApi getInstance() {
        if (cdApi==null) {
            synchronized (CDApi.class) {
                if (cdApi==null) cdApi = new CDApi();
            }
        }
        return cdApi;
    }

    @Override
    public ArrayList<CompactDisc> getCds(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("cds");


        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }


        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<CompactDisc> res = response.readEntity(new GenericType<ArrayList<CompactDisc>>() {});
        System.out.println(res);
        return res;
    }
}
