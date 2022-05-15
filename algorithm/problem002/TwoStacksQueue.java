package problem002;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

import java.util.Stack;

public class TwoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    private void pushToPop(){
        if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.add(pushInt);
        pushToPop();
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        System.out.println(twoStacksQueue.peek());
        twoStacksQueue.add(2);
        twoStacksQueue.add(3);
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
    }
}
