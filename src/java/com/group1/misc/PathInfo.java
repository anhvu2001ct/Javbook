/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public class PathInfo {
    public int size;
    public String[] path;
    
    public PathInfo(String str) {
        if (str == null) return;
        StringTokenizer st = new StringTokenizer(str, "/");
        size = st.countTokens();
        path = new String[size];
        for (int i = 0; i < size; ++i) path[i] = st.nextToken();
    }
    
    public static Map<String, String> getUrlParams(String url) {
        Map<String, String> res = new HashMap<>();
        StringTokenizer st = new StringTokenizer(url, "&");
        while (st.hasMoreTokens()) {
            StringTokenizer param = new StringTokenizer(st.nextToken(), "=");
            String key = param.nextToken();
            res.put(key, param.nextToken());
        }
        return res;
    }
    
    public static String toUrlParams(Map<String, String> params) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            res.append(entry.getKey()).append('=').append(entry.getValue());
            if (++cnt < params.size()) res.append('&');
        }
        return res.toString();
    }
}
