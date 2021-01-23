package Chapter2_sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-23
 * 插入排序
 * 文件 tiny.txt,words3.txt
 */
public class Insertion extends Example {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int lb = i;// 记录插入位置leftboard
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                lb = j - 1;
            }
            draw(a, lb, i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StdDraw.clear();
        }
        draw(a, N, N);
    }

    /**
     * 可视化
     * 每次插入所交换的位置为黑色，当前数据更新位置为红色，其余为灰色
     * @param a 排序数组
     * @param lb 当前插排左边界
     * @param rb 当前插排右边界
     */
    public static void draw(Comparable[] a, int lb, int rb) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = (double) a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = (double) a[i] / 2.0;
            if (i == lb) {                                //红色
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledRectangle(x, y, rw, rh);
            } else if (lb < i && i <= rb) {               //黑色
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(x, y, rw, rh);
            } else {                                     //灰色
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.filledRectangle(x, y, rw, rh);
            }
        }
    }

    public static void main(String[] args) {
//        String[] a = In.readStrings();

        Comparable[] a = new Comparable[100];
        for (int i = 0; i < 100; i++) {
            a[i] = Math.random();
        }
        sort(a);
        assert isSorted(a);
//        show(a);
    }
}
