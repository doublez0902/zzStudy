package 数据结构.栈和队列;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue (){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder re = new StringBuilder();
        re.append("Queue: ");
        re.append("Front [");
        for (int i = 0 ; i < array.getSize() ; i++){
            re.append(array.get(i));
            if (i != array.getSize() - 1) {
                re.append(", ");
            }
        }

        re.append("] tail");
        return re.toString();
    }

}
