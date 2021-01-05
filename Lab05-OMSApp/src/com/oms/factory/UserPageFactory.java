package com.oms.factory;

import com.oms.components.abstractdata.controller.ADataPageController;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author phong.cv173298
 * @created 02/01/2021 - 2:47 PM
 * @project oms
 */
public class UserPageFactory {
    private static Map<String, JPanel> m_RegisteredPage = new HashMap<>();

    private UserPageFactory() {

    }

    public synchronized static void register(String type, JPanel panel) {
        m_RegisteredPage.put(type, panel);
    }

    public static JPanel createPane(String type) {
        return m_RegisteredPage.get(type);
    }
}
