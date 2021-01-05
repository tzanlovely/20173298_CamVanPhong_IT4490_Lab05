package com.oms.serverapi.dvdapi;

import com.oms.bean.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author phong.cv173298
 * @created 29/12/2020 - 10:08 AM
 * @project oms
 */
public interface IDVDApi {
    public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams);
}
