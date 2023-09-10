class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set=new HashSet<>();
        for(List<Integer> a:nums){
            for(int i=a.get(0);i<=a.get(1);i++) set.add(i);
        }

        return set.size();
    }
}