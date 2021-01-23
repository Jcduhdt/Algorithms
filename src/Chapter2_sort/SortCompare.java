package Chapter2_sort;

import edu.princeton.cs.algs4.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-23
 * 排序算法的比较试验
 */
public class SortCompare {

    /**
     * 计算算法所需时间
     * @param alg 排序算法名称
     * @param a 待排序数组
     * @return 该算法所耗时间
     */
    public static double time(String alg,Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")){
            edu.princeton.cs.algs4.Insertion.sort(a);
        }
        if (alg.equals("Selection")){
            edu.princeton.cs.algs4.Selection.sort(a);
        }
        if (alg.equals("Shell")){
            Shell.sort(a);
        }
        if (alg.equals("Merge")){
            Merge.sort(a);
        }
        if (alg.equals("Quick")){
            Quick.sort(a);
        }
        if (alg.equals("Heap")){
            Heap.sort(a);
        }
        return timer.elapsedTime();
    }

    /**
     * 产生多组随机数组，并排序
     * @param alg 使用算法
     * @param N 数组长度
     * @param T 待排序组数
     * @return
     */
    public static double timeRandomInput(String alg,int N,int T){
        double total =0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n %s is",N,alg1);
        StdOut.printf(" %.1f times faster than %s\n",t2/t1,alg2);
    }
}
