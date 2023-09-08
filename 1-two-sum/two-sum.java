
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int present=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        while(present<nums.length){
            if(map.containsKey(target-nums[present]))
                return new int[]{map.get(target-nums[present]),present};
            map.put(nums[present],present);
            present++;
        }
        return new int[]{0,1};
    }
}