package org.neal.javaLearn.offer.StackAndQueue;

import org.neal.javaLearn.offer.StackAndQueue.impliment.StackImpl;

public class Main {
    public static void main(String[] args){
        StackImpl stack = new StackImpl();
        for(int i=0; i<5; i++){
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
