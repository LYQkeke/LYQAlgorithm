package com.keke.queue_stack;

import java.util.Stack;

/**
 * Created by KEKE on 2018/10/12
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 *
 * 要求pop、push和getMin操作的时间复杂度都是O(1)
 */
public class P001 {

    public static void main(String[] args){
//        MyStack1 stack = new MyStack1();
        MyStack2 stack = new MyStack2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());

    }

}

class MyStack1{

    // 使用两个栈来实现要求
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack1(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int n){

        dataStack.push(n);
        if (minStack.isEmpty())
            minStack.push(n);
        else if (n<=minStack.peek())
            minStack.push(n);
    }

    public int pop(){
        if (dataStack.isEmpty())
            throw new RuntimeException("the stack is empty!!!");
        int value = dataStack.pop();
        if (value == minStack.peek())
            minStack.pop();
        return value;
    }

    public int getMin(){
        if (minStack.isEmpty()){
            throw new RuntimeException("the stack is empty!!!");
        }
        return minStack.peek();
    }

}

class MyStack2{

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack2(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int n){

        if (minStack.isEmpty()){
            minStack.push(n);
        }else {
            int value = minStack.peek();
            if (n<=value)
                minStack.push(n);
            else
                minStack.push(value);
        }
        dataStack.push(n);
    }

    public int pop(){

        if (dataStack.isEmpty())
            throw new RuntimeException("the stack is empty!!!");
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin(){

        if (minStack.isEmpty())
            throw new RuntimeException("the stack is empty!!!");
        return minStack.peek();
    }
}
