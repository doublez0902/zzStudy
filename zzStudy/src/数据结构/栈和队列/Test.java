package 数据结构.栈和队列;

import java.util.Random;

public class Test {
    public static void main(String[] args){


        int count = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue , count);
        System.out.println("数组队列："+time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue , count);
        System.out.println("数组循环队列："+time2);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time5 = testQueue(linkedListQueue , count);
        System.out.println("链表队列："+time5);

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time4 = testStack(arrayStack , count);
        System.out.println("ArrayStack数组栈："+time4);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time3 = testStack(linkedListStack , count);
        System.out.println("LinkedListStack链表栈："+time3);
    }

    //测试数组队列和循环队列运行dequeue和enqueue时间
    private static double testQueue(Queue<Integer> q , int count){

        long startTime = System.nanoTime();

        Random r = new Random();
        for (int i = 0 ; i <count ; i++)
            q.enqueue(r.nextInt(Integer.MAX_VALUE));
        for (int i = 0 ; i <count ; i++)
            q.dequeue();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    //测试数组栈和链表栈运行push和pop时间
    private static double testStack(Stack<Integer> s , int count){

        long startTime = System.nanoTime();

        Random r = new Random();
        for (int i = 0 ; i <count ; i++)
            s.push(r.nextInt(Integer.MAX_VALUE));
        for (int i = 0 ; i <count ; i++)
            s.pop();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
