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
        if (index < 0 || index >= numNodes) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == numNodes - 1) return removeLast(); // Remove last
        else {
        Node previous = head;
        for (int i = 0; i < index-1; i++) {
            previous = previous.next;
        }
        Node current = previous.next;
        previous.next = current.next;
        numNodes--;
        return (E) current.getData();}
    }

    public E removeLast() {
        if (numNodes == 0) return null; // Nothing to remove
        else if (numNodes == 1) { // Only one element in the list
            Node temp = head;
            head = tail = null; // list becomes empty
            numNodes = 0;
            return (E) temp.getData();
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.getData();
        }
    }

    public E removeFirst() {
        if (numNodes == 0) return null; // Nothing to delete
        else {
            Node temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            numNodes--; // Reduce size by 1
            if (head == null) tail = null; // List becomes empty
            return (E) temp.getData(); // Return the deleted element
        }
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

    public int size(){
        return numNodes;
    }

    public E clone() {
        return (E) head.data;
    }

    public boolean contains(E o) {
        boolean check = false;
        Node current = head;
        while( current != null) {
            if (current.getData().equals(o)) {
                check = true;
                break;
            }
            current = current.next;
        }
        return check;
    }

    public int indexOf(E o){
        int index = -1;
        if (contains(o)) {
            Node current = head;
            for (int i = 0; i < numNodes; i++) {
                if (current.getData().equals(o)) {
                    index = i;

                }
                current = current.next;
            }
        }
        return index;
    }

    public E get (int i) {
        int index = 0;
        E result = null;
        Node current = head;
        while (index <= i) {
            if (index == i) {
                result = (E) current.getData();
            }
            index++;
            current =current.next;
        }
        return result;
    }

    public E getFirst() {
        return (E) head.getData();
    }

    public E getLast() {
        return (E) tail.getData();
    }

    public void clear(){
        head = tail = null;
        numNodes = 0;
    }
}
