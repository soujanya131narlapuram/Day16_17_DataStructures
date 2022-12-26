package com.bridgelabz.orderedlist;

public class OrderedListMain {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList();
        list.add(10);
        list.add(15);
        list.remove(10);

        list.append(20);
        list.append(30);

        int index = list.index(30);
        if(index == -1){
            System.out.println("30 is not present in linked list");
        } else{
            System.out.println("30 is present at the index "+ index);
        }
    }
}