package nwpu.bruteForce;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/3sum/
 *https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E5%93%88%E5%B8%8C%E8%A7%A3%E6%B3%95
 * https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E5%93%88%E5%B8%8C%E8%A7%A3%E6%B3%95
 *
 *Description
 *
 * 给你一个包含n个整数的数组，判断数组中是否存在三个元素a b c，使得a+b+c=0，请找出所有和为零且不重复的三元组。
 *
 *
 * Input
 * 输入数组的长度和数组的内容，数组元素之间用空格分隔。
 *
 *
 * Output
 * 输出满足条件的三元组，之间用空格分隔，（三元组末尾的数字之后也要有空格，否则和测试用例匹配不上），若没有三元组满足条件则不输出。
 *
 *
 * Sample Input 1
 *
 * 6
 * -1 0 1 2 -1 -4
 * Sample Output 1
 *
 * -1 -1 2
 * -1 0 1
 * Sample Input 2
 *
 * 8
 * -15 -5 10 5 3 8 -2 0
 * Sample Output 2
 *
 * -15 5 10
 * -5 0 5
 * Sample Input 3
 *
 * 2
 * 1 2
 * Sample Output 3
 *
 * (啥也不输出)
 * Hint
 * 1.输出的三元组是升序排列的
 * 2 若没有满足条件的三元组则不用输出
 * 3.输出的三元组不能重复
 * 4.只有当数组长度大于等于3时才有可能有答案
 * 5.若输出的结果的第一个数字相同，则比较第二个数字的大小，优先输出数值更小的一组，若仍相同则比较第三个数字
 *
 *
 */
public class P006 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                   right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left--;
                    }

                    right--;
                    left++;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}
