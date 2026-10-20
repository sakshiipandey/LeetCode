class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1,
                    gcd = 0,
                    lcm = 1;
            for (int j = i; j < nums.length; j++) {
                prod = prod * nums[j];

                gcd = findGcd(gcd, nums[j]);
                lcm = findLcm(lcm, nums[j]);

                if (prod == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public int findGcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public int findLcm(int a, int b) {
        return (a / findGcd(a, b)) * b;
    }
}