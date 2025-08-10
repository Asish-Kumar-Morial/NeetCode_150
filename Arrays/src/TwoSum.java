//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter " + size + " elements into the array: ");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.print("Enter the target value: ");
            int target = sc.nextInt();
            int[] result = getSum(nums,target);
            System.out.println("Indices of the two numbers : ");
            for (int num : result) {
                System.out.println(num);
            }
        }
    }

    // Best Approach for unsorted array

    public static int[] getSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment),i};
            }
            map.put(nums[i],i);
        }
        return new int[] { };
    }


    // Best Approach for sorted array

    //Time Complexity: O(n)
    //Space Complexity: O(1)

/*   public static int[] getResult(int[] nums,int target) {
        int left = 0, right = nums.length - 1, sum;
        while (left < right) {
            sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else {
                right++;
            }
        }
        return new int[] { };
    }
 */

}
