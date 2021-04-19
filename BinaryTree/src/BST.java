public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = root;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false;
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            }
            else if (e.compareTo(parent.element) > 0) {
                parent.right = createNewNode(e);
            }
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    public boolean search(E element) {
        TreeNode<E> current = root;
        boolean check = false;
        while (current != null && !check) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else if (element == current.element) {
                check = true;
            }
        }
        return check;
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.element + " ");
        }
    }

}