package 数据结构.链表;

/**
 * 递归求和
 *
 * 递归本质：函数调用，把原问题转化为更小的问题。
 * 递归调用代价：函数调用 + 系统栈空间
 *
 * 几乎和链表相关的所有操作，都可以用递归完成。
 */
public class SumByDiGui {

    public static int sum(int[] arr){
        return sum(arr , 0);
    }

    //计算arr在[l...n)区间内数字之和
    public static int sum(int[] arr , int l){
        if (l == arr.length)
            return 0;

        return arr[l] + sum(arr , l + 1);
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        System.out.println(sum(a));
    }
}
