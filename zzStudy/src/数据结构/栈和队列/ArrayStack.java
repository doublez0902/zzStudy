package 数据结构.栈和队列;

public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder re = new StringBuilder();
        re.append("Stack: ");
        re.append("[");
        for (int i = 0 ; i < array.getSize() ; i++){
            re.append(array.get(i));
            if (i != array.getSize() - 1) {
                re.append(", ");
            }
        }

        re.append("] top");
        return re.toString();
    }

}
