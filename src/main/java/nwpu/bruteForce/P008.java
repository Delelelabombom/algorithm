package nwpu.bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/expression-add-operators/solution/gong-shui-san-xie-hui-su-suan-fa-yun-yon-nl9z/
 *
 * Description
 *
 * 在算式中适当地添加“+”，“-”，“*”，“/”四种运算符，使等式成立（不使用括号）。
 * 例如5 5 5 5 5 3，添加运算符之后为5-5/5-5/5=3，等式成立，则输出：5-5/5-5/5=3。
 * 不用考虑除数为零的情况，等式左边固定为5个操作数，若有多种情况则全部输出。
 *
 *
 * Input
 * 共输入六个数，之间用空格分开，如：1 2 3 4 5 15
 *
 * 前五个数为等式左边的五个数，最后一个数为等式右边的数。
 *
 *
 * Output
 * 添加运算符，若使得等式成立，则将成立的等式输出，如：
 *
 * 1+2+3+4+5=15
 *
 * 1-2*3+4*5=15
 *
 * 1*2*3+4+5=15
 *
 *
 * Sample Input 1
 *
 * 1 2 3 4 5 15
 * Sample Output 1
 *
 * 1+2+3+4+5=15
 * 1-2*3+4*5=15
 * 1*2*3+4+5=15
 * Hint
 * 注意输出顺序，符号按照+ - * /的优先顺序输出
 */
public class P008 {
    static List<String> result = new ArrayList<>();
    static ArrayList<Integer> integers = new ArrayList<>();
    static int target;

    static void dfs(int parameterIndex, long previous, long current, String string) {
        if(parameterIndex == integers.size()) {
            //System.err.println(string);
            if (current == target) {
                if (string.equals("1*3*5")){

                }

                result.add(string);
            }
            return;
        }

        for (int i = parameterIndex; i < integers.size(); i++) {

            long next = integers.get(i);
            if (parameterIndex == 0) {
                dfs(i + 1, next, next, "" + next);
            } else {
                dfs(i + 1, next, current + next, string + "+" + next);
                dfs(i + 1, -next, current - next, string + "-" + next);
                long x = previous * next;
                dfs(i + 1, x, current - previous + x, string + "*" + next);
                long y = previous / next;
                double y1 = Double.valueOf(previous) / Double.valueOf(next);
                if (Double.valueOf(y) == y1) {
                    dfs(i + 1, y, current - previous + y, string + "/" + next);
                }
            }
            break;//删掉即可遍历全部，如3*5
        }

    }





    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            integers.add(scanner.nextInt());
        }
        target = scanner.nextInt();
        dfs(0, 0, 0, "");
        for (String s : result) {
            System.out.println(s+"="+target);
        }


        scanner.close();
    }
}
