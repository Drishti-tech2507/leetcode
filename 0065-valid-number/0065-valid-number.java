class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean numS = false;
        boolean dotS = false;
        boolean eS = false;
        boolean numA = true;
        for(int i = 0; i < s.length(); i++)
        {
        char ch = s.charAt(i);
        if(Character.isDigit(ch))
        {
            numS = true;
            numA = true;
        }
        else if (ch == '.') {
            if(dotS || eS)return false;
            dotS = true;
        }
        else if (ch == 'e' || ch == 'E') {
            if(eS || !numS) return false;
            eS = true;
            numA = false;
        }
        else if (ch == '+' || ch == '-')
        {
            if(i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
            {
                return false;
            }
        }
        else {
            return false;
        }
    }
    return numS && numA;
}
}