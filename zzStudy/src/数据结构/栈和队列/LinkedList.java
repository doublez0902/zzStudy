package 数据结构.栈和队列;

/**
 * 链表：最简单的真正的动态数据结构。之前栈和队列通过resize()实现动态，底层仍是静态数组。
 *
 * 数据存储在"节点"(Node)中；
 *
 * 优点：真正的动态，不需要处理固定容量的问题。
 * 缺点：丧失随机访问的能力。
 *
 * 增删改查：O(n)； 只对链表头：增删查：O(1)
 */
public class LinkedList<E> {

    private class Node{

        public E e;
        public Node next;

        public Node(E e , Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e , null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

//    private Node head;

    //设置虚拟头节点
    private Node dummyhead;
    int size;

    public LinkedList(){
        //head = null;
        dummyhead = new Node(null,null);
        size = 0;
    }

    //获取链表中元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return isEmpty();
    }

    //在链表头添加新元素e
    public void addFront(E e){

        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        //上述简写
//        head = new Node(e,head);
//        size++;
        add(0,e);

    }

    //在链表中index处添加元素
    public void add(int index , E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("添加失败，index不合法！");

        /*if (index == 0)
            addFront(e);
        else {
            Node prev = head;
            for (int i = 0 ; i < index - 1 ; i++)
                prev = prev.next;

            *//*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*//*

            prev.next = new Node(e,prev.next);

            size++;
        }*/
        Node prev = dummyhead;
        for (int i = 0 ; i < index ; i++)
            prev = prev.next;
        prev.next = new Node(e,prev.next);
        size++;
    }

    //在链表尾添加新元素e
    public void addLast(E e){
        add(size , e);
    }

    //获取第index个元素
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("获取失败，index不合法！");
        Node cur = dummyhead.next;
        for (int i = 0 ; i < index ; i++)
            cur = cur.next;
        return cur.e;
    }

    //获取第一个元素
    public E getFirst(){
        return get(0);
    }

    //获取最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改第index个元素
    public void set(int index , E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("修改失败，index不合法！");
        Node cur = dummyhead.next;
        for (int i = 0 ; i < index ; i++)
            cur = cur.next;
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyhead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        Node cur = dummyhead.next;
        while (cur != null){
            sb.append(cur.e + " -> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    //删除第index个元素
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("删除失败，index不合法！");

        Node prev = dummyhead;
        for (int i = 0 ; i < index ; i++)
            prev = prev.next;

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        return delNode.e;
    }

    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }
}
