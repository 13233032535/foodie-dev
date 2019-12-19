package com.lm.test;

import java.util.ArrayList;

public class A {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("sss1");
        list.add("sss2");
        list.add("sss3");

//        for (String s : list) {
//            if (s.endsWith("sss1")) {
//                continue;
//            }
//            System.out.println("s :" + s);
//        }
        list.stream().forEach(s->{
            if(s.endsWith("sss1")){
                return;
            }
            System.out.println("s:"+s);
        });

    }
}
