package com.hlfc.set.tree.obj.compare;

import java.util.TreeSet;
/**
 *
 * 引用数据类型呢,比如自定义对象,又该如何排序呢?
 * 1.自然排序法
 * .Student类中实现 Comparable接口
 * 重写Comparable接口中的Compareto方法
 * @Author hxl
 * @Date  2019/7/18
 **/
public class HTest {
    public static void main(String[] args) {
        TreeSet<Student> ts=new TreeSet<Student>();
        //创建元素对象
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lis",22);
        Student s3=new Student("wangwu",24);
        Student s4=new Student("chenliu",26);
        Student s5=new Student("zhangsan",22);
        Student s6=new Student("qianqi",24);

        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历
        for(Student s:ts){
            System.out.println(s.getName()+"-----------"+s.getAge());
        }
    }
}
