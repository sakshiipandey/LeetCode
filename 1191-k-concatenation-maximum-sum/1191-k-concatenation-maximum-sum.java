class Solution {
public int kConcatenationMaxSum(int[] arr, int k) {

    int mod = 1000000007;
    int n = arr.length;

    long bestEnding = 0;
    long maxSum = 0;
    long totalSum = 0;

    for(int i = 0; i<n; i++) {
        totalSum += arr[i];
    }

    int times = Math.min(k, 2);

    for(int i = 0; i<n * times; i++) {
        int v = arr[i % n];

        bestEnding = Math.max(0, bestEnding + v);
        maxSum = Math.max(maxSum, bestEnding);
    }

    if(k > 2 && totalSum > 0) {
        maxSum += (long)(k - 2) * totalSum;
    }

    return (int)(maxSum % mod);
}
}
