package nwpu.recursionDivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
 *
 */
public class P033 {
    static int[] nums, temp;

    public static final int mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mi = (left + right) / 2;
        int result = mergeSort(1, mi) + mergeSort(mi + 1, right);

        int i = left, j = mi + 1;
        for (int k = left; k <= right; k++) {
            temp[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i == mi + 1) {
                nums[k] = temp[j++];
            }else if (j == right + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                result += mi - i + 1;
            }
        }
        return  result;
    }

    /**
     归并排序
     */
    static private int ans;
    static public int reversePairs(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    static public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = ((r - l) >> 1) + l;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    /**
     合并排序，从小到大
     */
    static public void merge(int[] nums, int l, int mid, int r) {
        // 第一组左边界
        int l1 = l;
        // 第二组左边界
        int l2 = mid + 1;
        // 临时数组保存排序结果
        int[] tmp = new int[r - l + 1];
        int count = 0;
        // 归并排序
        while (l1 <= mid && l2 <= r) {
            if (nums[l1] <= nums[l2]) {
                tmp[count++] = nums[l1++];
                // 这里前面的数字大于后面的数字，所以前面的这个数字后面都大于后面的这个数字
            } else {
                ans += (mid - l1 + 1);
                tmp[count++] = nums[l2++];
            }
        }
        while (l1 <= mid) {
            tmp[count++] = nums[l1++];
        }
        while (l2 <= r) {
            tmp[count++] = nums[l2++];
        }
        // 把临时数组拷贝回去
        for (int i = l; i <= r; i++) {
            nums[i] = tmp[i - l];
        }
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            string = string.substring(1, string.length() - 1);
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            nums = list;
            temp = new int[list.length];
            System.out.println(reversePairs(list));
            //System.out.println(mergeSort(0, nums.length - 1));

        }catch (IOException e) {

        }
    }

    class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");
        static String nextLine() throws IOException {
            return reader.readLine();
        }
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}


