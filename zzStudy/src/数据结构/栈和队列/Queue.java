package 数据结构.栈和队列;

/**
 *  队列：线性结构。
 *     ～只能从一端（队尾）添加，另一端（队首）取出元素。
 *     ～后进先出，First In First Out(FIFO)
 *     ～应用：
 */

public interface Queue<E> {

    int getSize();        //O(1)
    boolean isEmpty();    //O(1)
    void enqueue(E e);    //O(1)
    E dequeue();          //O(n),通过循环队列变O(1)
    E getFront();         //O(1)

}
