package com.keke.queue_stack;

import java.util.Stack;

/**
 * Created by KEKE on 2018/10/13
 */
public class P008 {

    public static void main(String[] args){

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.toString());
        reverseStack(s);
        System.out.println(s.toString());
    }

    public static void reverseStack(Stack<Integer> stack){

        if (stack.isEmpty())
            return;
        int i = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }

    private static int getAndRemoveLastElement(Stack<Integer> stack){

        int res = stack.pop();
        if (stack.isEmpty())
            return res;
        else {
            int i = getAndRemoveLastElement(stack);
            stack.push(res);
            return i;
        }
    }
}
