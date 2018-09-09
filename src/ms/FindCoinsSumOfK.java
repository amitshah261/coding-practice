package ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given 4 coins of values 1, 5, 10, and 20, find all the combinations of coins that can add up to K.
 */
public class FindCoinsSumOfK {

    private List<List<Integer>> findSumWithoutDuplicates(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (k != 0) {
            backtrackWithoutDuplicates(nums, result, new ArrayList<>(), k, 0);
        }
        return result;
    }

    /* If reusing the same number is allowed.
    private void backtrackWithDuplicates(int[] nums, List<List<Integer>> result, List<Integer> tempList, int target, int index) {
        if (target < 0) {
            return;
        } else if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrackWithDuplicates(nums, result, tempList, target - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
    */

    private void backtrackWithoutDuplicates(int[] nums, List<List<Integer>> result, List<Integer> tempList, int target, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrackWithoutDuplicates(nums, result, tempList, target - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        FindCoinsSumOfK findSums = new FindCoinsSumOfK();
        int[] nums = {1, 1, 5, 1, 1, 1, 10, 20};
        System.out.println(findSums.findSumWithoutDuplicates(nums, 10));
        nums = new int[]{1, 1, 5, 1, 1, 1, 10, 20};
        System.out.println(findSums.findSumWithoutDuplicates(nums, 0));
        nums = new int[]{1, 5, 10, 20, 10};
        System.out.println(findSums.findSumWithoutDuplicates(nums, 20));
        nums = new int[]{20};
        System.out.println(findSums.findSumWithoutDuplicates(nums, 10));
    }
}
