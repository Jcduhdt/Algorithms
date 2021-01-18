package Chapter1_base;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-15
 * 可视化的累加器
 */
public class J05VisualAccumulator {
    private double total;
    private int N;

    /**
     * 构造函数，根据输入设置画布的XY轴
     * @param trials
     * @param max
     */
    public J05VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val); // 绘制当前点
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, mean()); // 绘制当前均值
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }
}
