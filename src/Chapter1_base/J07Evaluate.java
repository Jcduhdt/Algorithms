package Chapter1_base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-18
 * 双栈实现等式计算
 * 输入难受，一个字符一个字符的敲,或者用空格隔开( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 *
 */
public class J07Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("(")){

            }else if(s.equals("+")){
                ops.push(s);
            }else if(s.equals("-")){
                ops.push(s);
            }else if(s.equals("*")){
                ops.push(s);
            }else if(s.equals("/")){
                ops.push(s);
            }else if(s.equals("sqrt")){
                ops.push(s);
            }else if(s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")){
                    v = vals.pop() + v;
                }else if(op.equals("-")){
                    v = vals.pop() - v;
                }else if(op.equals("*")){
                    v = vals.pop() * v;
                }else if(op.equals("/")){
                    v = vals.pop() / v;
                }else if(op.equals("sqrt")){
                    v = Math.sqrt(v);
                }
                vals.push(v);
            }else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
