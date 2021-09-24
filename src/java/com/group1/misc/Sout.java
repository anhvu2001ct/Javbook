/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.misc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public class Sout {
    public static void print(Object... args) {
        for (int i = 0; i < args.length; ++i) {
            System.out.print(args[i]);
            System.out.print(i == args.length-1 ? '\n': ' ');
        }
    }
    
    public static void iprint(int indent, Object... args) {
        while (indent-- > 0) System.out.print('\t');
        print(args);
    }
    
    public static void iprintf(int indent, String fmt, Object... args) {
        while (indent-- > 0) System.out.print('\t');
        System.out.println(String.format(fmt, args));
    }
    
    private static String arrToString(Object... array) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            res.append(array[i].toString());
            if (i < array.length-1) res.append(' ');
        }
        return res.toString();
    }
    
    private String title;
    private List<String> list;
    
    public Sout(String title) {
        this.title = title;
        list = new ArrayList<>();
    }
    
    public void add(Object... objects) {
        list.add(arrToString(objects));
    }
    
    public void addf(String fmt, Object... args) {
        list.add(String.format(fmt, args));
    }
    
    public void print() {
        System.out.printf("\n|=============================[ %s ]=============================|\n", title);
        list.forEach(str -> iprint(1, str));
        System.out.println();
    }
}
