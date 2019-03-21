package com.keke.SwordOffer;

import java.util.Stack;

/**
 * Created by KEKE on 2019/3/21
 *
 * 用两个栈实现队列
 */
public class N005 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        while (stack2.isEmpty()&&!stack1.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }
    public static void main(String[] args) {

    }
}
