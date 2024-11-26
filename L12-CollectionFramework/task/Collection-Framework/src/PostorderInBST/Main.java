package PostorderInBST;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.add(27);
        bst.add(14);
        bst.add(10);
        bst.add(35);
        bst.add(31);
        bst.add(19);
        bst.add(42);

        System.out.println("Duyệt theo post-order:");
        bst.postOrderTraversal();
    }
}

