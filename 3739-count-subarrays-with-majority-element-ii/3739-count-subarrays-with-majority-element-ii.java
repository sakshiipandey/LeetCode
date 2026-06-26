class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        int offset = n + 1;
        Fenwick ft = new Fenwick(2 * n + 5);

        long ans = 0;

        // Insert prefix sum 0
        ft.update(offset, 1);

        for (int i = 1; i <= n; i++) {
            int cur = pref[i] + offset;

            // Count previous prefix sums < current prefix sum
            ans += ft.query(cur - 1);

            ft.update(cur, 1);
        }

        return ans;
    }
}