class Solution {
    public List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>> outer=new ArrayList<>();
        combos(0,target,c,new ArrayList<>(),outer);
        return outer;
    }

    void combos(int ind,int T,int[] c,List<Integer> inner,List<List<Integer>> outer){
        if(ind==c.length){
            if(T==0){
                outer.add(new ArrayList<>(inner));
            }
            return;
        }

        if(T>=c[ind]){
            inner.add(c[ind]);
            combos(ind,T-c[ind],c,inner,outer);
            inner.remove(inner.size()-1);
        }
        combos(ind+1,T,c,inner,outer);
    }
}