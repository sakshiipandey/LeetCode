import java.util.*;

class Solution {

    static final long MOD1 = 998244353L;
    static final long MOD2 = 1000000007L;
    static final long BASE = 233L;

    long[] pow1, pow2, hash1, hash2;

    public int smallestUniqueSubarray(int[] nums) {

        int[] polvexrani = nums;
        int n = polvexrani.length;

        pow1 = new long[n + 1];
        pow2 = new long[n + 1];

        hash1 = new long[n + 1];
        hash2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        // Prefix Hash Calculation
        for (int i = 1; i <= n; i++) {

            pow1[i] = (pow1[i - 1] * BASE) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE) % MOD2;

            hash1[i] = (hash1[i - 1] * BASE + nums[i - 1]) % MOD1;
            hash2[i] = (hash2[i - 1] * BASE + nums[i - 1]) % MOD2;
        }

        int left = 1;
        int right = n;
        int ans = n;

        // Binary Search
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(n, mid)) {
                ans = mid;
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Get hash of subarray
    long getHash(int l, int r) {

        int len = r - l + 1;

        long h1 = (hash1[r] -
                hash1[l - 1] * pow1[len] % MOD1 + MOD1) % MOD1;

        long h2 = (hash2[r] -
                hash2[l - 1] * pow2[len] % MOD2 + MOD2) % MOD2;

        return (h1 << 30) | h2;
    }

    // Check whether a unique subarray exists
    boolean check(int n, int len) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = len; i <= n; i++) {

            long hash = getHash(i - len + 1, i);

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}