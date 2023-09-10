class Solution {
    public int minimumMoves(int[][] grid) {
        int empty=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]==0) empty++;
            }
        }

        if(empty==0) return 0;

        int moves=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(grid[i][j]==0){
                    for(int x=0;x<3;x++){
                        for(int y=0;y<3;y++){
                            if(grid[x][y]>1){
                                int dis=Math.abs(x-i)+Math.abs(y-j);
                                grid[x][y]--;
                                grid[i][j]++;
                                moves=Math.min(moves,dis+minimumMoves(grid));
                                grid[x][y]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }

        return moves;
    }

    
}