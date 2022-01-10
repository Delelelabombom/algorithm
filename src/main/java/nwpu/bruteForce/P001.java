package nwpu.bruteForce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 *Description*
 * 已知两个有序整数数组a和b，将a，b合并到数组c中，合并后的数组c仍然是一个有序数组。
 *
 * Input
 * 输入包含4个变量，数组a的长度，数组a，数组b的长度，数组b。
 *
 * Output*
 * 输出包含1个变量，即数组c。
 *
 *
 * Sample Input 1
 * 3
 * 1 3 5
 * 4
 * 2 4 6 7
 * Sample Output 1
 * 1 2 3 4 5 6 7
 *
 *
 * Sample Input 2
 * 1
 * 1
 * 0
 * Sample Output 2
 * 1
 * Sample Input 3
 * 0
 * 1
 * 1
 * Sample Output 3
 * 1
 *
 * Hint
 *
 * 若数组长度为0，则下一行直接输入下一个数组的长度，或者不输入任何信息。
 *
 *
 *
 */
public class P001 {
    static ArrayList<Integer> a = new ArrayList<Integer>();
    static ArrayList<Integer> b = new ArrayList<Integer>();
    static ArrayList<Integer> result;
    static int aLength;
    static int bLength;

    public static void mergeSort() {
        if (aLength == 0 && bLength == 0) {
            result = new ArrayList<Integer>();
            return;
        }
        if (aLength == 0) {
            result = new ArrayList<Integer>(b);
        }
        if (bLength == 0) {
            result = new ArrayList<Integer>(a);
        }

        result = new ArrayList<Integer>();
        int i = 0, j = 0;
        for(; i < aLength && j < bLength; ) {
            if(a.get(i) <= b.get(j)) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }
        if(i < aLength) {
            for (; i < aLength; i++) {
                result.add(a.get(i));
            }
        }
        if(j < bLength) {
            for (; j < bLength; j++) {
                result.add(b.get(j));
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        aLength = scanner.nextInt();
        for (int i = 0; i < aLength; i++) {
            a.add(scanner.nextInt());
        }
        bLength = scanner.nextInt();
        for (int i = 0; i < bLength; i++) {
            b.add(scanner.nextInt());
        }

        mergeSort();
        String s = "";
        for (Integer integer : result) {
            s += integer + " ";
        }
        s = s.substring(0, s.length() - 1);
        System.out.print(s);
        scanner.close();
    }
}
