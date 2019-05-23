package 数据结构.栈和队列;

/**
 *  栈：线性结构。
 *     ～只能从一端添加、取出元素，这一端称为栈顶。
 *     ～后进先出，Last In First Out(LIFO)
 *     ～应用：撤销（undo操作）、程序调用
 */

public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
