package com.pinc.msc_weather_city_server.util;


public class Test {


    public ListNode resever(ListNode head){
        ListNode pre =null;
        ListNode curr = head;
        while(curr !=null){
            ListNode temp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        System.out.println("当前pre是"+pre.val);
        return pre;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(a.show());
        ListNode node = new Test().resever(a);
        System.out.println(node.show());
    }
}
