public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>("Long");
        myLinkedList.add(1, "Thanh");
        myLinkedList.add(2, "Duyet");
        myLinkedList.add(3, "Ngoc Anh");
        myLinkedList.add(4, "Thao");

        System.out.println(myLinkedList);
//        myLinkedList.remove(1;);
//        System.out.println(myLinkedList.removeLast());
//        System.out.println(myLinkedList.removeFirst());
//        System.out.println(myLinkedList);
        System.out.println(myLinkedList.contains("Ngoc Anh"));
        System.out.println(myLinkedList.indexOf("Ngoc Anh"));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());
    }

}
