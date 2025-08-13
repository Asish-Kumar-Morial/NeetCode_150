//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter "+size+" elements into the array: ");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            int result = longestSequence(nums);
            System.out.println("Longest Consecutive Sequence present in this array is: "+result);
        }
    }

    public static int longestSequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int lngst = 1;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int i : numSet) {
            if (!numSet.contains(i-1)) {
                int currentNum = i;
                int cur = 1;
                while (numSet.contains(currentNum+1)) {
                    currentNum++;
                    cur++;
                }
                lngst = Math.max(lngst,cur);
            }
        }
        return lngst;
    }
}
