import java.util.Arrays;
import java.util.HashMap;

public class ArrayAlgorithm {

    /**
     * 128 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // 空间换时间
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int cur = left + right + 1;
                res = Math.max(res, cur);
                map.put(n, cur);
                map.put(n - left, cur);
                map.put(n + right, cur);
            }
        }

        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                res += 1;
            }
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayAlgorithm alg = new ArrayAlgorithm();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(alg.longestConsecutive(nums));
    }
}
