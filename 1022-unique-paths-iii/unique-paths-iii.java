class Solution {
    int[] ros={0,1,0,-1};
    int[] cols={1,0,-1,0};
    public int uniquePathsIII(int[][] grid) {
        int cells=1;
        int n=grid.length;
        int m=grid[0].length;
        int[] start={-1,-1};
        int[] dest={-1,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) cells++;

                else if(grid[i][j]==1){
                    start[0]=i;start[1]=j;
                }
            }
        }

        boolean[][] vis=new boolean[n][m];
        vis[start[0]][start[1]]=true;

        return countPaths(start[0],start[1],grid,cells,vis);
    }

    int countPaths(int r,int c,int[][] grid,int cells,boolean[][] vis){
        if(grid[r][c]==2 && cells==0) return 1;
        if(grid[r][c]==2) return 0;

        int res=0;

        for(int i=0;i<4;i++){
            int row=ros[i]+r;
            int col=cols[i]+c;

            if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]!=-1 && !vis[row][col]){
                vis[row][col]=true;
                res+=countPaths(row,col,grid,cells-1,vis);
                vis[row][col]=false;
            }
        }

        return res;
    }
}