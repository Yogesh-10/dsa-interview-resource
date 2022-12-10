package com.yogesh.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exercise {
    //1. Reverse a string.
    //when ever we do problems like reversal or we calculate from back, stacks are best
    public String stringReverse(String str){
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++)
            stack.push(str.charAt(i));

//        we can use this method, but this is more costly, because at each iteration
//        we concatenate to reversed, so at each time new string is created in memory
//        because strings are immutable in java. so, efficient is to use StringBuffer
//        String reversed = "";
//        while (!stack.isEmpty()){
//            reversed += stack.pop();
//        }

        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    //2. Balanced Expressions
    public boolean isBalanced(String str) {
            Stack<Character> stack = new Stack<>();

            for (char ch: str.toCharArray()){
                if (isLeftBracket(ch))
                    stack.push(ch);

                if (isRightBracket(ch)) {
                    if (stack.empty()) return false;
                    Character top = stack.pop();
                    if (bracketsMatch(top, ch)) return false;
                }
            }
            return stack.empty();
        }

        private boolean isLeftBracket(char ch){
            return ch == '(' || ch == '<' || ch == '[' || ch == '{';
        }
        private boolean isRightBracket(char ch){
            return ch == ')' || ch == '>' || ch == ']' || ch == '}';
        }

        private boolean bracketsMatch(char left, char right){
            return (right == ')' && left != '(' ||
                    right == '>' && left != '<' ||
                    right == ']' && left != '[' ||
                    right == '}' && left != '{');
    }
}
