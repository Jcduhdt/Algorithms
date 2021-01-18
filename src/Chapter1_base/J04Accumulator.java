package Chapter1_base;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-15
 */
public class J04Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }
}
