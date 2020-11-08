package com.george.blog.web;


import java.util.*;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {

        this.val = 0;

        this.next = null;

    }

    public static boolean isLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

//如果存在空节点 ，说明不存在环
        if (head == null) {
            return false;
        }

//试想如果一个环，你是找不到空节点的，两个步长不一致的指针迟早要相遇
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public int depth() {


        if (this.next == null) {

            return 1;

        }
        if(isLoop(this.next)) {
            return 0;
        } else {
            return this.next.depth() + 1;
        }
    }

    public static List<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {

    list1.addAll(list2);

    Collections.sort(list1);

    return list1;

    }

    public static int findThirdMaxIndex(ArrayList<Integer> nums) {
        if(nums.size() < 3) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.size(); ++i) {
            int curr = nums.get(i);
            if(!pq.contains(curr)) {
                pq.add(curr);
                map.put(curr, i);
                if(pq.size() > 3) {
                    int x = pq.poll();
                    map.remove(x);
                }
            }
        }
        if(pq.size() < 3) {
            while(pq.size() > 1) pq.poll();
        }
        return map.get(pq.peek());
    }

    public static void main(String[] args) {
//        ListNode a = new ListNode();
//        a.next = new ListNode();
//        a.next.next = new ListNode();
//        a.next.next.next= a;
//        System.out.println(a.depth());

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        list1.add(6);
        list1.add(7);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(-3);
        list2.add(-4);
        list2.add(-6);
        list2.add(-7);
        list2.add(0);

        List<Integer> ans = merge(list1, list2);
        System.out.println(ans);

        int res = findThirdMaxIndex(list1);
        System.out.println(res);
    }

}