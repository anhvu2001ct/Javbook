/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.misc;

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
}
