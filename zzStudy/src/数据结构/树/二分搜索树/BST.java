package 数据结构.树.二分搜索树;

/**
 * 二分搜索树（BinarySearchTree）：
 *      其每个节点，大于左子树所有节点的值，小于右子树所有节点的值。
 *      每一棵子树也是二分搜索树。
 *      存储的元素必须有可比性。
 *      一般不包含重复元素。
 *
 */
public class BST <E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left , right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return isEmpty();
    }

}
