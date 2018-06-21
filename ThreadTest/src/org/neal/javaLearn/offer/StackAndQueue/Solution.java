package org.neal.javaLearn.offer.StackAndQueue;

import org.neal.javaLearn.offer.StackAndQueue.impliment.StackImpl;

public class Solution {
    public boolean isValid(String s){
        StackImpl<Character> stack = new StackImpl<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if(c==')' && topChar!='(')
                    return false;
                if(c=='}' && topChar!='{')
                    return false;
                if(c==']' && topChar!='[')
                    return false;

            }
        }
        return stack.isEmpty();
    }
}
