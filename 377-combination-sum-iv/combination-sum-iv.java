class Solution {
    
    public int combinationSum4(int[] nums, int target) {
       Map<Integer,Integer> dp=new HashMap<>();
       return combos(nums,target,dp);
    }

    int combos(int[] nums,int target,Map<Integer,Integer> dp){
        if(target==0) return 1;

        if(dp.containsKey(target)) return dp.get(target);

        int res=0;
        for(int n:nums){
            if(target-n>=0){
                res+=combos(nums,target-n,dp);
            }
        }
        dp.put(target,res);
        return res;
    }
}

