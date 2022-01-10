package nwpu.bruteForce;



import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *固定范围内最大值
 * Description
 * 给你一个整数数组，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看见在滑动窗口中的k个数字。滑动窗口每次向右移动一位。
 * 请输出每个窗口中的最大值。
 * Input
 * 输入包含三部分，数组的长度，数组中各元素，滑动窗口大小。例如：
 *
 * 8
 *
 * 1 3 -1 -3 5 3 6 7
 *
 * 3
 *
 *
 * Output
 * 输出每个滑动窗口中元素的最大值，元素间用空格分隔，如：
 *
 * [1  3  -1] -3  5  3  6  7       3
 *
 * 1 [3  -1  -3] 5  3  6  7       3
 *
 * 1  3 [-1  -3  5] 3  6  7       5
 *
 * 1  3  -1 [-3  5  3] 6  7       5
 *
 * 1  3  -1  -3 [5  3  6] 7       6
 *
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 输出：3 3 5 5 6 7
 *
 *
 * Sample Input 1
 *
 * 8
 * 1 3 -1 -3 5 3 6 7
 * 3
 * Sample Output 1
 *
 * 3 3 5 5 6 7
 * Hint
 *若数组长度小于窗口值，或窗口值为0，则输出为空。
 *
 */
public class P007 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < length; i++) {
            list.add(scanner.nextInt());
        }

        int window = scanner.nextInt();

        if (length < window || window == 0) {
            System.out.println();
            scanner.close();
            return;
        }


        int currentMax = 0;
        for (int i = 0; i < window; i++) {
            if (list.get(currentMax) <= list.get(i)) { //相等的话优先取右边的元素
                currentMax = i;
            }
        }
        res.add(list.get(currentMax));
        int head = 1;
        int tail = window;

        for (; tail < length; head++, tail++) {
            if (currentMax != head - 1) {
                if (list.get(currentMax) <= list.get(tail)) { //相等的话优先取右边的元素
                    currentMax = tail;
                }
            } else {
                currentMax = head;
                for (int i = head; i <= tail; i++) {
                    if (list.get(currentMax) <= list.get(i)) { //相等的话优先取右边的元素
                        currentMax = i;
                    }
                }
            }
            res.add(list.get(currentMax));
        }

        for (Integer re : res) {
            System.out.print(re);
            System.out.print(" ");
        }

        scanner.close();
    }
}
