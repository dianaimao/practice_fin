package com.kzk.deep_study_springboot.basic;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class StringPra {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("wodasdfsaf");
        stringBuilder.append("sadfasfasf");
        System.out.println(stringBuilder);
//        Scanner scanner=new Scanner();
    String name="kzk";
    int  age=55;
    String message=String.format("%s is very beatiful and age is %1$s",name,age);
        System.out.printf(message);
        String[] list=new String[]{"8","8","98","99"};
        int[] intList={1,7,8,34};
        //两个变量引用同一个数组
        int[] intList2=intList;
        intList[0]=9999;
        System.out.println("this is intList2:"+Arrays.toString(intList2));
        Arrays.sort(intList);
        Arrays.fill(intList,99);
        String a="你好";
        String b="kkz";
        System.out.println(a.concat(b));
        System.out.println(String.join("-",list));
        //数组快速打印
        System.out.println(Arrays.toString(intList));
        System.out.println(Arrays.toString(args));
        System.out.println((int)(Math.random()*9));
        System.out.println(Arrays.equals(new int[]{777},new int[]{777}));
        System.out.println(new Date());
    }


}
