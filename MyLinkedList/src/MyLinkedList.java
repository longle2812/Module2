public class MyLinkedList<E> {
    private Node head, tail;
    private int numNodes = 0;

    public MyLinkedList(Object data) {
        head = new Node(data);
        tail = head;
        numNodes++;
    }

    private static class Node {
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E e) {
        if (index == 0) addFirst(e); // Insert first
        else if (index >= numNodes) addLast(e); // Insert last
        else { // Insert in the middle
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(e);
            (current.next).next = temp;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        numNodes++; // Increase list size

        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    public void addLast(E e) {
        Node newNode = new Node(e); // Create a new node for e

        if (tail == null) {
            head = tail = newNode; // The only node in list
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = tail.next; // tail now points to the last node
        }

        numNodes++; // Increase size
    }

    public E remove(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node result = current;
        for (int i = index; i < numNodes-1; i++) {
            current = current.next;
        }
        tail = current;
        tail.next = null;
        numNodes--;
        return (E) result;
    }

    @Override
    public String toString() {
        String result = "";
        Node thisNode = null;
        for (int i = 0; i < numNodes; i++) {
            if (i == 0) {
                thisNode = head;
            } else {
                thisNode = thisNode.next;
            }
            result += thisNode.data + " ";
        }
        return result;
    }
}
