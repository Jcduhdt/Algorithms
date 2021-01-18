package Chapter1_base;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-13
 * 欧几里得算法
 * 自然语言描述：计算两个非负整数p和q的最大公约数
 * 思想：
 * 若q为0，则最大公约数为p
 * 否则，p除以q得到余数r，p与q的最大公约数为r与q的最大公约数
 */
public class J01Gcd {
    public static void main(String[] args) {
        int q = 60;
        int p = 25;
        int ans = gcd(p, q);
        System.out.println("ans = " + ans);
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
