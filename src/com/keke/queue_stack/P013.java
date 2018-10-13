package com.keke.queue_stack;

import java.util.Stack;

/**
 * Created by KEKE on 2018/10/13
 *
 * 用一个栈来实现另一个栈的排序
 *
 * 栈顶到栈底从大到小
 */
public class P013 {

    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(2);
        s.push(4);
        s.push(3);
        s.push(1);
        System.out.println(s.toString());
        sortStackByStack(s);
        System.out.println(s.toString());
    }

    public static void sortStackByStack(Stack<Integer> stack){

        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while(!helper.isEmpty()&&cur>helper.peek()){
                stack.push(helper.pop());
            }
            helper.push(cur);
        }
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
    }

}
