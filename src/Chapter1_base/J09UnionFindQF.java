package Chapter1_base;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-19
 * quick-find算法
 * 对每一个union操作都要遍历一遍数组
 */
public class J09UnionFindQF {

    private static int cost = 0;
    private int[] id; // 分量id
    private int count; // 分量数量

    public J09UnionFindQF(int N){
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
        cost++;
        return id[p];
    }

    public void union(int p,int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID){
                id[i] = qID;
                cost++;
            }
            cost++;
        }
        count--;
    }

    private static void initStdDraw(){
        // 绘图
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 1300);
        StdDraw.setPenRadius(.005);
        StdDraw.textLeft(0,650,"(0,650)");
        StdDraw.textLeft(0,50,"(0,50)");
        StdDraw.textLeft(0,1250,"(0,1250)");
        StdDraw.textRight(800,50,"(800,50)");
        StdDraw.text(450,1250,"quick-find");
    }

    private static void draw(int ops,int cost,double total){
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(ops, cost); // 绘制当前点
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(ops, total/ops); // 绘制当前均值
    }

    public static void main(String[] args) {
        initStdDraw();
        int ops = 0; // 操作数
        double total = 0; // 访问总次数

        int N = StdIn.readInt();
        J09UnionFindQF uf = new J09UnionFindQF(N);
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
