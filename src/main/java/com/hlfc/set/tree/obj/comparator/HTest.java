package com.hlfc.set.tree.obj.comparator;

import java.util.TreeSet;
/**
 * 比较器排序法
 * 1.单独创建一个比较类，这里以MyComparator为例，并且要让其继承Comparator接口
 * 2.重写Comparator接口中的Compare方法
 * @Author hxl
 * @Date  2019/7/18
 **/
public class HTest {

    public static void main(String[] args) {
        //创建集合对象
        //TreeSet(Comparator<? super E> comparator) 构造一个新的空 TreeSet，它根据指定比较器进行排序。
        TreeSet<Student> ts=new TreeSet<Student>(new MyComparator());

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