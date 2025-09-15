import java.util.Scanner;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        if (text == null || text.isEmpty()) return 0;

        boolean[] broken = new boolean[26];
        if (brokenLetters != null) {
            brokenLetters = brokenLetters.toLowerCase();
            for (char c : brokenLetters.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    broken[c - 'a'] = true;
                }
            }
        }

        int count = 0;
        String[] words = text.split("\\s+");

        outer:
        for (String word : words) {
            for (char c : word.toCharArray()) {   
                char lc = Character.toLowerCase(c);
                if (lc >= 'a' && lc <= 'z' && broken[lc - 'a']) {
                    continue outer; 
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        System.out.println("Enter broken letters:");
        String brokenLetters = sc.nextLine();

        Solution sol = new Solution();
        int result = sol.canBeTypedWords(text, brokenLetters); 
        System.out.println("Maximum number of words you can type: " + result);

        sc.close();
    }
}