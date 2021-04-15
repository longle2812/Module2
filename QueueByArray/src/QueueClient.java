public class QueueClient {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(10);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(1);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(1);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println(myQueue);
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println(myQueue);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println(myQueue);
        myQueue.enqueue(2);
        System.out.println(myQueue);
    }
}
