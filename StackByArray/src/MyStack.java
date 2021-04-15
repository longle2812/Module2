public class MyStack {
    public int[] arr;
    public int size;
    public int index = -1;

    public MyStack(int size) {
        this.size = size;
        arr = new int[this.size];
    }

    public void push(int element) {
        if (isEmpty()) {
            this.index++;
        }
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[index] = element;
            this.index++;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            this.index--;
        }
        return arr[this.index];
    }

    public boolean isFull() {
        if (this.index == this.size) {
            return true;
        } else return false;
    }

    public boolean isEmpty() {
        if (this.index == -1) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        String result = "";
        if (isFull()) {
            int newIndex = this.index - 1;
            for (int i = 0; i < newIndex; i++) {
                result += this.arr[i] + " ";
            }
        } else {
            for (int i = 0; i < this.index; i++) {
                result += this.arr[i] + " ";
            }
        }
        return result;
    }
}
