public class Queue<E> {
    private Node front;
    private Node rear;

    public class Node {
        private int data;
        public Node link;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + this.data +
                    ", link=" + this.link +
                    '}';
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            this.rear = this.front = temp;
        }
        else {
            this.rear.link = temp;
            this.rear = temp;
        }
        this.rear.link = this.front;

    }

    public int dequeue(){
        int value = this.front.data;
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        else if (this.front == this.rear) {
            value = this.front.data;
            this.front = this.rear = null;
        }
        else {
            value = this.front.data;
            this.front = this.front.link;
            this.rear.link = this.front;
        }
        return value;

    }

    private boolean isEmpty() {
        if (this.front == null) {
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "front=" + this.front.data +
                ", rear=" + this.rear.data +
                '}';
    }
}
