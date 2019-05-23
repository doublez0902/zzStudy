package 数据结构.数组;

public class Test {
    public  static void  main(String args[]){

        Array<Integer> arr = new Array<>();
        for (int i = 0 ; i < 10 ; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.set(3 , 100);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);
    }
}
