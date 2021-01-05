package com.oms.serverapi.cdapi;

import com.oms.bean.CompactDisc;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author phong.cv173298
 * @created 29/12/2020 - 10:07 AM
 * @project oms
 */
public interface ICDApi {
    public ArrayList<CompactDisc> getCds(Map<String, String> queryParams);
}
