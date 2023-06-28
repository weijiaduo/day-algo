package com.wjd.practice.recruit.huya;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 实现一个栈，实现其中的add, delete, get方法
 *
 * 例子：
 *
 * 输入：
 * 6
 * add aaa
 * add bbb
 * add ccc
 * get
 * delete
 * get
 *
 * 输出：
 * ccc
 * bbb
 *
 */
public class First {

    public static void main(String[] args) {

        int n;
        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        if (n>0){
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLine();
            }
            parse(a);
        }

    }

    public static void parse(String[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        Stack stack = new Stack();

        for (int i = 0; i < a.length; i++) {
            String[] cmd = a[i].split(" ");
            if (cmd.length == 1) {
                if ("get".equals(cmd[0])) {
                    System.out.println(stack.get());
                } else if ("delete".equals(cmd[0])) {
                    stack.delete();
                } else {
                    return;
                }
            } else if (cmd.length == 2) {
                if ("add".equals(cmd[0])) {
                    stack.add(cmd[1]);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    static class Stack{

        private LinkedList<Object> stack = new LinkedList<>();

        public void add(Object obj){
            stack.push(obj);
        }

        public Object get(){
            if (stack.isEmpty()){
                return null;
            }
            return stack.peek();
        }

        public Object delete(){
            if (stack.isEmpty()){
                return null;
            }

            return stack.pop();
        }
    }
}
