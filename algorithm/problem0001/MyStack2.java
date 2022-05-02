package problem0001;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum < this.getmin()){
            this.stackMin.push(newNum);
        }else{
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(5);
        myStack2.push(7);
        myStack2.push(4);
        myStack2.push(3);
        myStack2.push(8);
        myStack2.push(2);
        myStack2.push(13);
        System.out.println(myStack2.getmin());
        System.out.println(myStack2.pop());
    }
}
