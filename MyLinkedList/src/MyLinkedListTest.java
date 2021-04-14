public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>("Long");
        myLinkedList.add(2,"Thanh");
        myLinkedList.add(3, "Duyet");
        myLinkedList.add(4,"Ngoc Anh");
        System.out.println(myLinkedList);
        myLinkedList.remove(2);
        System.out.println(myLinkedList);
    }

}
