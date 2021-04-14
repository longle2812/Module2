public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public class Node {
        int key;
        private Node next;

        public Node() {
        }

        public Node(int key) {
            this.key = key;
        }
    }

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
        }
        else {
            this.tail.next = temp;
            this.tail = temp;
        }

    }

    public Node dequeue() {
        if (this.head == null){
            return null;
        }
        else {
            Node temp = this.head;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return temp;
        }


    }
}
