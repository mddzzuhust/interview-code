package problem0001;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if(this.stackMin.empty()){
            this.stackMin.push(newNum);
        }else if(newNum <= this.getmin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(5);
        myStack1.push(7);
        myStack1.push(4);
        myStack1.push(3);
        myStack1.push(8);
        myStack1.push(2);
        myStack1.push(13);
        System.out.println(myStack1.getmin());
        System.out.println(myStack1.pop());
    }
}
