public class StackClient {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        int l = myStack.pop();
        System.out.println(myStack);
    }
}
