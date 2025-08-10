// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Scanner;

public class ValidAnagram {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the First String: ");
            String str1 = sc.nextLine();
            System.out.print("Enter the Second String: ");
            String str2 = sc.nextLine();
            System.out.println(isAnagram(str1,str2) ? "Both the strings are Anagram" : "Both the strings are not Anagram");
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int[] frequency = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i) - 'a']++;
            frequency[str2.charAt(i) - 'a']--;
        }

        for (int count : frequency) {
            if (count != 0)
                return false;
        }
        return true;
    }
}