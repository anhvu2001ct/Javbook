/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.misc;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Random;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public class Serect {
    private static String decode(Decoder dc, String str, boolean rev) {
        StringBuilder res = new StringBuilder(new String(dc.decode(str)));
        if (rev) res.reverse();
        return res.toString();
    }

    public static String encode1(String s) {
        Encoder ec = Base64.getUrlEncoder().withoutPadding();
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        str = new StringBuilder(ec.encodeToString(ec.encode(str.toString().getBytes())));
        str.reverse();
        return ec.encodeToString(str.toString().getBytes());
    }
    
    public static String decode1(String s) {
        Base64.Decoder dc = Base64.getUrlDecoder();
        s = decode(dc, s, true);
        s = decode(dc, s, false);
        return decode(dc, s, true);
    }
    
    private static final Random rng = new Random();
    private static final int FIRST = 7 + rng.nextInt(7);
    private static final int LAST = 7 + rng.nextInt(7);
    
    public static String encode2(String s) {
        Encoder ec = Base64.getUrlEncoder().withoutPadding();
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < FIRST; ++i) str.append(rng.nextInt(10));
        str.append(s);
        for (int i = 0; i < LAST; ++i) str.append(rng.nextInt(10));
        str.reverse();
        str = new StringBuilder(ec.encodeToString(ec.encode(str.toString().getBytes())));
        return str.reverse().toString();
    }
    
    public static String decode2(String s) {
        Decoder dc = Base64.getUrlDecoder();
        StringBuilder str = new StringBuilder(s);
        s = str.reverse().toString();
        s = decode(dc, s, false);
        s = decode(dc, s, true);
        return s.substring(FIRST, s.length() - LAST);
    }
}
