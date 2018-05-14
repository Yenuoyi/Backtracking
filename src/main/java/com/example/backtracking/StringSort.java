package com.example.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:YeBing
 * 字符排列组合求解
 */
public class StringSort {
    private static int COUNT=0;
    public void back(List<String> list, StringBuffer stringBuffer){
        //如果list为空了，说明已经将组合成为一个新的字符串，否则继续递归加入新字符
        if(list.size()<=0){
            ++COUNT;
            System.out.println(stringBuffer.toString());
        }else{
            //循环排序替换当前字符
            for(int i=0;i<list.size();i++){
                //存储当前加入的字符
                String temp = list.get(0);
                list.remove(0);
                stringBuffer.append(temp);
                //递归剩下的字符串，将其加入到string中
                back(list, stringBuffer);
                //回溯从stringBuffer中删除当前已使用过的字符
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
                //将字符重新加入到list中
                list.add(temp);
            }
        }
    }
    public static void main(String[] args){
        String str = "ABCDEFG";
        String[] array = str.split("");
        StringSort stringSort = new StringSort();
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(array));
        StringBuffer stringBuffer = new StringBuffer();
        stringSort.back(list, stringBuffer);
        System.out.println("共有"+COUNT+"种组合！");
    }
}
