package 数据结构.链表;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0 ; i < 5 ; i++)
            ll.addFront(i);
        System.out.println(ll);

        ll.add(3,100);
        System.out.println(ll);
    }
}
