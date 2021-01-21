package Chapter1_base;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-19
 * 加权quick-union算法
 * 保证qu中的糟糕情况不出现
 * 通过记录每一棵树的大小并总是将较小的树连接到较大的树代替随意连接
 *
 */
public class J11UnionFindWQU {

    private int[] parent;   // 父连接数组
    private int[] size;     // 各根节点对应分量大小
    private int count;      // 连同分量数
    private static int cost = 0;

    public J11UnionFindWQU(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
            cost += 2;
        }
        cost++;
        return p;
    }

    @Deprecated
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 保证正确索引
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        cost += 5;
        count--;
    }

    private static void initStdDraw(){
        // 绘图
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(-20, 20);
        StdDraw.setPenRadius(.005);
        StdDraw.textLeft(0,1,"(0,1)");
        StdDraw.textLeft(0,18,"(0,18)");
        StdDraw.textLeft(0,-18,"(0,-18)");
        StdDraw.textRight(800,-18,"(800,18)");
        StdDraw.text(450,18,"weighted-quick-union");
    }

    private static void draw(int ops,int cost,double total){
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(ops, cost); // 绘制当前点
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(ops, total/ops); // 绘制当前均值
    }

    public static void main(String[] args) {
        initStdDraw();
        int ops = 0;
        double total = 0;
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            ops++;
            cost = 0;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) {
                continue;
            }
            uf.union(p, q);
            total += cost;
            draw(ops,cost,total);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
