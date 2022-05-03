package Cautruc;

import javax.security.sasl.SaslClient;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackQueue {
    public boolean isValid(String s){
        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                myStack.push(c);
            }else {
                if(myStack.isEmpty()){
                    return false;
                }
                char openPeek = myStack.peek();
                if(c==')' && openPeek =='(' || c=='}' && openPeek =='{' || c==']' && openPeek =='['){
                    myStack.pop();
                }else{
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    private Queue<Integer> myQueue = new LinkedList<>();
    public int ping(int t){
        myQueue.add(t);
        while (myQueue.peek() < (t-3000)){
            myQueue.remove();
        }
        return myQueue.size();
    }



}
