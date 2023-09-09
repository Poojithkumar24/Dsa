class Solution {
    public long countSubarrays(int[] nums, long k) {
    long count = 0;
    long sum = 0;
    int start = 0;

    for (int end = 0; end < nums.length; end++) {
        sum += nums[end];

        // If sum * len is greater than or equal to k, subtract the sum of the first element(s) until the condition is met.
        while (sum * (end - start + 1) >= k) {
            sum -= nums[start];
            start++;
        }

        // Add the count of subarrays ending at the current 'end' index.
        count += (end - start + 1);
    }

    return count;
}

}