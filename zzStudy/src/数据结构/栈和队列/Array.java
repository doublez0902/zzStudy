package 数据结构.栈和队列;

/**
 *
 *  数组：把数据码成一排进行存放
 *
 *  数组最大优点：快速查询
 *
 *  使用泛型：让数据结构可存放任何类型的数据；不能是基本数据类型，只能是类对象；但每个基本数据类型都有对应的包装类。
 *
 *  时间复杂度：O(1),O(n),O(lgn),O(nlogn),O(n^2)...
 *  O描述的是算法的运行时间和输入数据之间的关系。
 *
 *  添加操作：addFirst(e):O(n)  addLast(e):O(1)  add(index,e):O(n/2)=O(n)   总的来说：O(n)
 *  删除操作：removeFirst(e):O(n)  removeLast(e):O(1)  remove(index,e):O(n/2)=O(n)   总的来说：O(n)
 *  resize():O(n)
 *  修改操作：set(index,e):O(1)
 *  查找操作：get(index):O(1)  contains(e):O(n)  find(e):O(n)
 *
 *  所以：  ～动态数组的时间复杂度～
 *         ～增：O(n)  删：O(n)  改：已知索引O(1),未知索引O(n)  查：已知索引O(1),未知索引O(n)
 *
*/
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数：传入数组的容量capacity构造array
    public Array(int capacity){
        data = (E[]) new Object[capacity];

        size = 0;
    }

    // 无参数的构造函数，默认数组的容量为capacity=10
    public Array(){
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在第index个位置插入一个新元素e
    public void add(int index , E e){

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，需要size >= index >= 0");
        }

        if(size == data.length) {
            resize(2*data.length);
        }

        for (int i = size - 1 ; i >= index ; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    // 在所有元素后添加一个新元素「」
    public void addLast(E e){
        add(size , e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0 , e);
    }

    // 获取第index个元素
    public E get(int index){

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index不合法");
        }

        return data[index];
    }

    // 获取第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获取最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改第index个元素
    public void set(int index , E e){

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败，index不合法");
        }

        data[index] = e;
    }

    // 删除指定位置index的元素,返回删除元素
    public E remove(int index){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，需要size >= index >= 0");
        }

        E re = data[index];
        for (int i = index + 1 ; i < size ; i++) {
            data[i-1] = data[i];
        }

        size--;
        data[size] = null;

        if (size == data.length/4 && data.length/2 != 0) {
            resize(data.length/2);
        }
        return re;
    }

    // 删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组删除元素e
    public void removeElement(E e){
        int index = find(e);

        if (index != -1) {
            remove(index);
        }
    }

    // 查找数组是否包含元素e
    public boolean contains(E e){
        for (int i = 0 ; i < size ; i++){
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组是否包含元素e并返回其索引，若不存在，返回-1
    public int find(E e){
        for (int i = 0 ; i < size ; i++){
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 重写toString()方法
    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d ,capacity = %d\n",size,data.length));
        sb.append("[");
        for (int i = 0 ; i < size ; i++){
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }


    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0 ; i < size ; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

}
