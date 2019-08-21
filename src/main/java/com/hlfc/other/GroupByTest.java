package com.hlfc.other;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * java 8 分组（groupby）
 * https://www.cnblogs.com/fengkunangel/p/10434735.html
 * @Auther: hxl
 * @Date: 2019/8/21 14:29
 */
public class GroupByTest {

    public static void main(String[] args) {

        test1();
    }

    private static void test1() {


        List<String> items = Arrays.asList(
                "apple", "apple",
                "orange", "orange", "orange",
                "blueberry",
                "peach", "peach", "peach", "peach"
        );

        // 分组，计数
        Map<String, Long> result = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        Map<String, Long> finalMap = new LinkedHashMap<>();
        // 排序
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);


        test2();


    }

    private static void test2() {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal(23.5)),
                new Item("apple", 20, new BigDecimal(32.5)),
                new Item("orange", 30, new BigDecimal(13.9)),
                new Item("orange", 20, new BigDecimal(33.5)),
                new Item("orange", 10, new BigDecimal(63.5)),
                new Item("orange", 50, new BigDecimal(41.5)),
                new Item("peach", 20, new BigDecimal(26.5)),
                new Item("peach", 30, new BigDecimal(42.5)),
                new Item("peach", 40, new BigDecimal(24.5)),
                new Item("peach", 10, new BigDecimal(12.5))
        );


        // 分组
        Map<String, List<Item>> group = items.stream()
                .collect(Collectors.groupingBy(Item::getName));
        System.out.println(group);


        // 分组，计数
        Map<String, Long> counting = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(counting);

        // 分组，计数，数量
        Map<String, Integer> sum = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(sum);
    }


}
