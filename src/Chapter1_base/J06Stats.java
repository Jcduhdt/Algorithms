package Chapter1_base;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-18
 * 背包集合的使用
 * 运行程序，输入数据，在IDEA中键入ctrl+d进行while循环的退出，使用命令行用ctrl+z退出
 * 结果：
 * 100
 * 99
 * 101
 * 120
 * 98
 * 107
 * 109
 * 81
 * 101
 * 90
 * ^D
 * Mean: 100.60
 * Std dev: 10.51
 */
public class J06Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        double sum = 0.0;
        for (Double x : numbers) {
            System.out.println(x);
            sum += x;
        }
        double mean = sum / N;
        sum = 0.0;
        for (Double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
