public class DPAlgorithm {

    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;

        int res = nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            res = Math.max(max[i], res);
        }

        return res;
    }
}
