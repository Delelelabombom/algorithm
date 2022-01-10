package nwpu.bruteForce;

import java.util.Scanner;

/**
 * Description
 *
 * 现在某个题库中有M道题,题号分别是1，2，3......M，有N个学生去做，每个人都做了一部分，求这N个学生都未做过的题目数量。
 *
 * 每个学生做的第一道题可能不同，但每个学生做过的题目序号是连续的，并且不同学生做过的题可能重叠。
 *
 *
 * Input
 * 输入包括多组数据，第一行有两个数分别是，题目总数M(0<M<1000)，学生总数N;
 *
 * 接下来的N行，每行包含两个不同的整数，用空格分隔开，
 *
 * 表示每个学生做过的题目起始位置和结束位置（这两个位置的题都被做过）。
 *
 *
 * Output
 * 输出包括一行，这一行只包含一个整数，表示这N个学生都未做过的题目数量。
 *
 *
 * Sample Input 1
 *
 * 500 3
 * 150 300
 * 100 200
 * 470 471
 * Sample Output 1
 *
 * 297
 * Sample Input 2
 *
 * 300 0
 * Sample Output 2
 *
 * 300
 */
public class P003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionNum = scanner.nextInt();
        int [] bitmap = new int [questionNum + 1];
        int i = scanner.nextInt();
        int begin, end;
        for (int j = 0; j < i; j++) {
            begin = scanner.nextInt();
            end = scanner.nextInt();
            for (int k = begin; k <= end; k++) {
                bitmap[k] = 1;
            }
        }
        int result = 0;
        for (int j = 1; j <= questionNum; j++) {
            if (bitmap[j] == 0) {
                result++;
            }
        }

        System.out.print(result);
        scanner.close();
    }
}
