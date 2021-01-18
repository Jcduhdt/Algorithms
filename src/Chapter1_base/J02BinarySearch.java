package Chapter1_base;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-13
 * 二分查找
 * 使用方式
 * javac J02BinarySearch.java
 * java J02BinarySearch tinyAllowlist.txt < tinyText.txt
 * java J02BinarySearch largeAllowlist.txt < largeText.txt | more
 */
public class J02BinarySearch {

    /**
     * 二分
     * @param key 要找的值
     * @param a 排好序的数组
     * @return
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if
            (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]); // 白名单里的数进行读取
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1) {
                StdOut.println(key);
            }
        }
    }
}
