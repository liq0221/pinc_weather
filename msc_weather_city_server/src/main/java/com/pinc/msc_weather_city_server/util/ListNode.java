package com.pinc.msc_weather_city_server.util;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x){
        val=x;
    }

    public  String show(){
        return this.val+"->"+(this.next==null?"null":this.next.show());
    }
}
