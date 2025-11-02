class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0)
        {
            columnNumber--;
            int r = columnNumber % 26;
            sb.append((char) ('A' + r));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
    public static void main(String[]args)
    {
        Solution obj= new Solution();
        System.out.println(obj.convertToTitle(1));
        System.out.println(obj.convertToTitle(28));
        System.out.println(obj.convertToTitle(701));
        System.out.println(obj.convertToTitle(52));
        System.out.println(obj.convertToTitle(703));
    }
}