package Cautruc;

import java.util.ArrayList;
import java.util.Queue;

public class StackAndQueue implements IStackQueue{
    //LinkedListSatck
    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

    Node topNode;
    StackAndQueue(){
        topNode=null;
    }

    @Override
    public boolean push(int value) {
        if(!isFull()){
            Node newNode = new Node(value);
            newNode.next=topNode;
            topNode=newNode;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int value = topNode.value;
        topNode = topNode.next;
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return topNode==null;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        Node temp = topNode;
        ArrayList<Integer> list = new ArrayList<>();
        while (temp != null){
            list.add(temp.value);
            temp=temp.next;
        }
        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.print(list.get(i)+ " ");
        }
        System.out.println();
    }

}

class QueueLinkedList implements IStackQueue{

    //Queue linkedList
    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

    Node headNode ,tailNode;

    QueueLinkedList(){
        headNode = tailNode = null;
    }

    @Override
    public boolean push(int value) {
        if(isFull()){
            return false;
        }
        Node newNode = new Node(value);
        if(isEmpty()){
            headNode=tailNode= newNode;
        }else {
            tailNode.next=newNode;
            tailNode = newNode;
        }
        return true;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int value = headNode.value;
        if(headNode == tailNode){
            headNode = tailNode = null;
        }else{
            headNode = headNode.next;
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return headNode == null && tailNode==null;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        Node cur = headNode;
        while(cur != null){
            System.out.print(cur.value+ " ");
            cur=cur.next;
        }
        System.out.println();
    }
}

//Stack mảng
class ArrayStack implements IStackQueue{

    private int[] array;
    private int SIZE;
    private int topIndex; //trỏ vào vị trí pt

    ArrayStack(int size){
        SIZE=size;
        array = new int[SIZE];
        topIndex=-1;
    }

    @Override
    public boolean push(int value) {
        if(!isFull()){
            topIndex++;
            array[topIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            int value = array[topIndex];
            topIndex--;
            return value;
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return topIndex == SIZE-1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            for (int i = 0; i <= topIndex; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
}
//Queue mảng vào từ tail ra từ head
class ArrayQueue implements IStackQueue{

    private int[] array;
    private int SIZE;
    private int headIndex,tailIndex;

    ArrayQueue(int size){
        SIZE=size;
        array = new int[SIZE];
        headIndex = tailIndex = -1;
    }

    @Override
    public boolean push(int value) {
        if(!isFull()){
            if(isEmpty()){
                headIndex++;
            }
            tailIndex++;
            array[tailIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        int value=-1;
        if(!isEmpty()){
            value=array[headIndex];
            headIndex++;
            if(headIndex > tailIndex){
                headIndex=tailIndex=-1;
            }
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return tailIndex==SIZE-1;
    }

    @Override
    public boolean isEmpty() {
        return headIndex== -1 && tailIndex== -1;
    }
    public int count(){
        if(isEmpty())
            return 0;
        return tailIndex-headIndex+1;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue is empty");
        }else{
            for (int i = headIndex; i <= tailIndex ; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
}

class Main{
    public static void main(String[] args) {
        StackAndQueue s = new StackAndQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.show();

        System.out.println(s.pop());
        s.show();
        System.out.println(s.pop());
        s.show();
        System.out.println(s.pop());
        s.show();
        System.out.println(s.pop());
        s.show();
    }
}
