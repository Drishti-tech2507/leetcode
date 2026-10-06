class Solution {
    public int minAddToMakeValid(String s) {
         int balance = 0;

        int insertions = 0;

        for (char ch : s.toCharArray()) {

            

            if (ch == '(') {

                balance++;

            } 

            else {

                if (balance > 0) {

                    balance--;

                } 

                else {

                    // No '(' available to match this ')'

                    insertions++;

                }

            }

        }

        // Remaining '(' need closing ')'

        return insertions + balance;
    }
}