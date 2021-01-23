package Chapter2_sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-23
 * 一个排序模板，让排序算法进行继承
 */
public class Example {

    /**
     * 排序方法
     * @param a
     */
    public static void sort(Comparable[] a){}

    /**
     * 元素比较，v是否小于w
     * @param v
     * @param w
     * @return
     */
    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * 元素交换，还是习惯swap
     * @param a
     * @param i
     * @param j
     */
    protected static void exch(Comparable[] a, int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印当前数组
     * @param a
     */
    protected static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * 判断数组是否有序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
}
