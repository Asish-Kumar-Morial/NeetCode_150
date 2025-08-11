//Time Complexity: O(n.k)
//Space Complexity: O(n.k)

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of Strings you want to insert: ");
            int size = Integer.parseInt(sc.nextLine());
            String[] str = new String[size];
            System.out.println("Enter "+size+" Strings : ");
            for (int i = 0; i < size; i++) {
                str[i] = sc.nextLine();
            }
            List<List<String>> result = isAnagram(str);
            System.out.println(result);
        }
    }

    public static List<List<String>> isAnagram(String[] str) {
        if (str.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int freq : count) {
                sb.append('#').append(freq);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
               map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
