class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(row -> row.get(0)));       
        List<int[]> merged=new ArrayList<>();

        int start=nums.get(0).get(0);
        int end=nums.get(0).get(1);
        
        for(List<Integer> arr:nums){
            if(arr.get(0) <=end){
                end=Math.max(arr.get(1),end);
            }
            else{
                merged.add(new int[]{start,end});
                start=arr.get(0);
                end=arr.get(1);
            }
        }
        merged.add(new int[]{start,end});
        
        int res=0;
        for(int[] a:merged){
            res+=a[1]-a[0]+1;
        }
        
        return res;
    }
}