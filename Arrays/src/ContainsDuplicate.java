//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { // Auto-closes scanner
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();

            int[] arr = new int[size];
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(
                    hasDuplicate(arr)
                            ? "The array contains duplicate elements"
                            : "The array doesn't contain duplicate elements"
            );
        }
    }

    public static boolean hasDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) { // add() returns false if already present
                return true;
            }
        }
        return false;
    }
}