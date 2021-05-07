package com.company;

public class Main {

    public static void main(String[] args) {
        BlackList blackList = new BlackList();
        blackList.add(Integer.class);
        Stack<String> stack = new Stack<>(blackList);
        stack.push("1");
        stack.push("2");
        stack.push("3");

        stack.delete();

        System.out.println(stack.get());
    }
}
