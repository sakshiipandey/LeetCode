class Solution {
public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

    long k = (long) k1 + k2;
    int n = nums1.length;

    int[] diff = new int[n];
    int max = 0;
    long sum = 0;

    for (int i = 0; i < n; i++) {
        diff[i] = Math.abs(nums1[i] - nums2[i]);
        max = Math.max(max, diff[i]);
        sum += diff[i];
    }

    if (sum <= k) {
        return 0;
    }

    long[] freq = new long[max + 1];

    for (int d : diff) {
        freq[d]++;
    }

    for (int d = max; d > 0; d--) {
        if (freq[d] == 0) {
            continue;
        }

        long operations = Math.min(k, freq[d]);

        // Move differences from d to d - 1
        long possible = Math.min(k / freq[d], d);

        if (possible > 0) {
            long move = Math.min(possible, d);
            freq[d] -= 0;
        }

        long count = freq[d];
        long move = Math.min(k, count);

        if (move < count) {
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        } else {
            freq[d - 1] += count;
            freq[d] = 0;
            k -= count;
        }

        if (k == 0) {
            break;
        }
    }

    long ans = 0;

    for (int d = 0; d <= max; d++) {
        ans += freq[d] * d * d;
    }

    return ans;
}

}
