import java.util.Arrays;

public class MyQueue {
    public int capacity;
    public int[] queueArr;
    public int head = 0;
    public int tail = -1;
    public int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        this.queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        if (this.currentSize == this.capacity) {
            return true;
        } else return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0) {
            return true;
        } else return false;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.printf("Queue is full");
        } else {
            if (isQueueEmpty()) {
                this.head = this.tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            this.tail++;
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty");
        }
        else {
            int[] newQueue = new int[this.capacity];
            for (int i = 0; i < capacity-1; i++) {
                newQueue[i] = queueArr[i+1];
            }
            queueArr = newQueue;
            this.head = 0;
            currentSize--;
            this.tail--;
        }
    }

    @Override
    public String toString() {
        String result="";
        for (int i = this.head; i < currentSize; i++) {
            result += queueArr[i] +" ";
        }
        return result;
    }
}
