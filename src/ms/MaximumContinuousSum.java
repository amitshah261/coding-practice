package ms;

/*
    Find max continuous sum in array?
*/

public class MaximumContinuousSum {
    int findMaxSum(int[] nums){
        if(nums.length < 1){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = nums[0];

        for(int i=1; i < nums.length; i++){
            if(nums[i] > currentSum + nums[i]){
                if(currentSum > maxSum ) {
                    maxSum = currentSum;
                }
                currentSum = nums[i];
            } else {
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                }
                currentSum += nums[i];
            }
        }
        if(currentSum > maxSum ) {
            maxSum = currentSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumContinuousSum mcs = new MaximumContinuousSum();
        int[] nums = {3, 4, 2, 1, -11, 7, 9};
        System.out.println(mcs.findMaxSum(nums));
        nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(mcs.findMaxSum(nums));
        nums = new int[] {-8, -2, -3, -1, -4};
        System.out.println(mcs.findMaxSum(nums));
    }
}
