package Chapter1_base;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-19
 * 路径压缩
 */
public class J12UnionFindC {
    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components
    private static int cost;

    public J12UnionFindC(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        validate(p);
        // 路径压缩，在每次找根的时候进行压缩
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
            cost += 5;
        }
        cost++;
        return p;
    }

    public int count() {
        return count;
    }

    @Deprecated
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // 树深
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
            cost += 3;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
            cost += 3;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
            cost += 4;
        }
        count--;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    private static void initStdDraw(){
        // 绘图
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 1300);
        StdDraw.setPenRadius(.005);
        StdDraw.textLeft(0,650,"625");
        StdDraw.textRight(800,50,"800");
        StdDraw.text(450,1250,"路径压缩");
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
        J12UnionFindC uf = new J12UnionFindC(n);
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
