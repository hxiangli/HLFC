package com.hlfc.set.tree;

import java.util.TreeSet;

/**
 * 排序的引入(以基本数据类型的排序为例)
 * @Author hxl
 * @Date  2019/7/18
 **/
public class BaseTypeTest {

    public static void main(String[] args) {
        // 创建集合对象
        // 自然顺序进行排序
        TreeSet<Integer> ts = new TreeSet<Integer>();

        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }
    }
}
