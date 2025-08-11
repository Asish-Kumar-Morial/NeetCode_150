//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

public class Top_K_FrequentElements {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter "+size+" elements into the array: ");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.print("Enter the value of k: ");
            int k = sc.nextInt();
            int[] result = topElements(nums, k);
            System.out.println(Arrays.toString(result));
        }
    }
    public static int[] topElements(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        k= Math.min(k,frequencyMap.size());

        @SuppressWarnings("unchecked")
        List<Integer>[] bucketList = (List<Integer>[]) new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            if (bucketList[freq] == null) {
                bucketList[freq] = new ArrayList<>();
            }
            bucketList[freq].add(entry.getKey());
        }

        List<Integer> resultSet = new ArrayList<>();
        for (int i = bucketList.length-1; i >= 0 && resultSet.size() < k; i--) {
            if (bucketList[i] != null)
                resultSet.addAll(bucketList[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = resultSet.get(i);
        }

        return result;
    }
}