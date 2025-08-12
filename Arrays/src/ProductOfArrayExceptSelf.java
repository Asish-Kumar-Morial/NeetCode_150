import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter "+size+" elements in to the array: ");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            int[] product = productArray(nums);
            System.out.println(Arrays.toString(product));
        }
    }

    public static int[] productArray(int[] nums) {
        int[] result = new int[nums.length];
        int pre = 1, post = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre = nums[i]*pre;
        }

        for (int i = nums.length-1; i >= 0 ; i--) {
            result[i] = post*result[i];
            post = post*nums[i];
        }

        return result;
    }
}
