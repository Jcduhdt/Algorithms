package Chapter1_base;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;


/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-13
 * 对StdDraw进行测试
 */
public class J03StdDrawTest {
    public static void main(String[] args) {
        // 函数值
        int N = 100;
//        StdDraw.setPenColor(StdDraw.BLUE); //设置画笔颜色
//        StdDraw.setXscale(0,N); // 设置X轴
//        StdDraw.setYscale(0,N*N); // 设置Y轴
//        StdDraw.setPenRadius(.01); // 设置画笔粗细半径
//        for (int i = 1; i <=N ; i++) {
//            StdDraw.point(i,i);
//            StdDraw.point(i,i*i);
//            StdDraw.point(i,i*Math.log(i));
//        }
        // emmm,为啥只能画一个图就进行不下去了
        // 随机数组
        N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }
//        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            double x = 1.0*i/N;
            double y = a[i]/2.0;
            double rw = 0.5/N;
            double rh = a[i]/2.0;
            // x,y矩形中心坐标
            // rw，rh矩形宽高的一半
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }
}
