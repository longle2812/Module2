public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(bst.root, 1);
        bst.add(bst.root, 2);
        bst.add(bst.root, 3);
        TreeNode current = bst.root;
        while (current != null){
            System.out.println(current);
            current = current.right;
        }
    }
}
