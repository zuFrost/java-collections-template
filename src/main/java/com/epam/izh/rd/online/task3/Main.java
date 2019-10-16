package com.epam.izh.rd.online.task3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new MyStringArrayList();

        System.out.println(list.isEmpty());

        list.add("Alice");
        list.add("Bob");
        list.add("Chloe");

        System.out.println(list.size() == 3);

        System.out.println(list.get(2));

        list.remove(0);

        System.out.println(list.get(1));
    }

}
