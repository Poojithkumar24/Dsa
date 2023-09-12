class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int start=0;
        int end=mat[0].length-1;


        while(start<=end){
            int mid=start+(end-start)/2;
            int[] cell=findMax(mid,mat);
            int row=cell[0];
            int col=cell[1];

            if(isPeak(cell,mat)) return new int[]{row,col};

            if( col-1>=0 && mat[row][col] < mat[row][col-1]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return new int[]{-1,-1};

    }

    private  int[] findMax(int col,int[][] mat){
        
        int[] maxCell={0,col};

        for(int i=0;i<mat.length;i++){
           if(mat[i][col]> mat[maxCell[0]][maxCell[1]]){
               maxCell[0]=i;
           }
        }
        
        return maxCell;
    }

    private boolean isPeak(int[] cell,int[][] mat){
        int row=cell[0];
        int col=cell[1];

        int[] dr={1,0,-1,0};
        int[] dc={0,1,0,-1};

        for(int i=0;i<4;i++){
            int r=dr[i]+row;
            int c=dc[i]+col;
            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && mat[r][c]>mat[row][col]) return false;
        }

        return true;
    }
}