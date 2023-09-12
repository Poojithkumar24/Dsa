class Solution {
    public int maxDistToClosest(int[] seats) {
        int max_dis=0;

        for(int i=0;i<seats.length;i++){
            if(seats[i]==0){
                max_dis=Math.max(max_dis,f(seats,i));
            }
        }

        return max_dis;
    }

    int f(int[] seats,int ind){
        int left=ind;
        int right=ind;

        for(int i=ind-1;i>=0;i--){
            if(seats[i]==1){
                left=i;
                break;
            }
        }
        for(int i=ind+1;i<seats.length;i++){
            if(seats[i]==1){
                right=i;
                break;
            }
        }

        if(ind==0) return right;
        if(ind==seats.length-1) return ind-left;

        return Math.min(right-ind,ind-left);
    }
}