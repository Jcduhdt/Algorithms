package Chapter1_base;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-15
 * 用于测试J05VisualAccumulator.java
 * 使用：java TestVisualAccumulator 2000
 */
public class TestVisualAccumulator {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        J05VisualAccumulator a = new J05VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
