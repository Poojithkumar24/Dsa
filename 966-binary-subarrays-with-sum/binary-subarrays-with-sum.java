class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return atMost(nums,goal) - atMost(nums,goal-1);
    }

    private int atMost(int[] arr,int target){
        if(target<0) return 0;
        int start=0;
        int count=0;
        int sum=0;

        for(int end=0;end<arr.length;end++){
            if(target<0) return 0;
            sum+=arr[end];

            while(sum>target){
                sum-=arr[start++];
            }

            count+=end-start+1;
        }

        return count;
    }
}