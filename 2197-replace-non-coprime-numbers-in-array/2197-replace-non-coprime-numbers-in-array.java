class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer>stack = new ArrayList<>();
        for(int x:nums)
        {
            stack.add(x);
            while(stack.size() >= 2)
            {
                int a = stack.get(stack.size()-1);
                int b = stack.get(stack.size()-2);
                int g = gcd(a, b);
                if(g == 1)break;
                int lcm = a/g*b;
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add(lcm);
            }
        }
        return stack;
    }
    private int gcd(int a, int b)
    {
        while(b != 0)
        {
            int t = a%b;
            a = b;
            b = t;
        }
        return a;
    }
}