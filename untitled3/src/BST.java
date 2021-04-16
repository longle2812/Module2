public class BST<E> {
    public TreeNode<E> root;
    private int size = 0;

    public BST() {
    }

    public BST(TreeNode<E> root) {
        this.root = root;
    }

    public void add(TreeNode node, int element) {
        if (this.root == null) {
            this.root = new TreeNode<>(element);
        } else {
            if (node == null) {
                node = new TreeNode<>(element);
            } else {
                if (element < node.value) {
                    add(node.left, element);
                } else if (element > node.value) {
                    add(node.right, element);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
