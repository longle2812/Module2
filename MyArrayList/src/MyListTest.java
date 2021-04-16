public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>(4);
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);
        myList.add(3, 4);
        myList.add(3, 4);
        System.out.println(myList);
        System.out.println(myList.contains(3));
        System.out.println(myList.remove(3));
        System.out.println(myList.indexOf(2));
        System.out.println(myList);
        myList.clear();
        System.out.println(myList);
    }

}
