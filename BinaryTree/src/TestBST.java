public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        //traverse tree
//        tree.inorder();
        tree.postorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        System.out.println(tree.search(2));
    }
}