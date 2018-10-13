package com.keke.queue_stack;

import java.util.Stack;

/**
 * Created by KEKE on 2018/10/12
 *
 * 编写一个类，用两个栈来实现队列，支持队列的基本操作---add、poll、peek
 */
public class P005 {

    public static void main(String[] args){
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(3);
        queue.add(2);
        queue.add(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class TwoStackQueue{

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TwoStackQueue(){

        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void add(int n){
        pushStack.push(n);
    }

    public int poll(){
        adjust();
        return popStack.pop();
    }

    public int peek(){
        adjust();
        return popStack.peek();
    }

    private void adjust(){
        if (pushStack.isEmpty()&&popStack.isEmpty())
            throw new RuntimeException("this queue is empty!!!");
        else if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }
}
