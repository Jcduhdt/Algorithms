package Chapter1_base;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-19
 * quick-union算法
 * 根节点
 * 并不能保证所有情况都比quick-find快得多
 * 在有序情况，所需find复杂度趋近于N平方
 */
public class J10UnionFindQU {

    private int[] id; // 分量id
    private int count; // 分量数量
    private static int cost = 0;

    public J10UnionFindQU(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int getCount(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public int find(int p){
        // 找根节点
        while (p != id[p]){
            p = id[p];
            cost += 2;
        }
        cost++;
        return p;
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        id[pRoot] = qRoot;
        cost++;
        count--;
    }

    private static void initStdDraw(){
        // 绘图
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 300);
        StdDraw.setPenRadius(.005);
        StdDraw.textLeft(0,280,"(0,280)");
        StdDraw.textRight(800,10,"(800,10)");
        StdDraw.text(450,280,"quick-union");
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
        int N = StdIn.readInt();
        J10UnionFindQU uf = new J10UnionFindQU(N);
        while (!StdIn.isEmpty()){
            ops++;
            cost = 0;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)){
                continue;
            }
            uf.union(p,q);
            total += cost;
            draw(ops,cost,total);
            StdOut.println(p +" " + q);
        }
        StdOut.println(uf.getCount() + "components");
    }
}
