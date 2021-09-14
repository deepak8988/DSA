class Solution {
    public void rotate(int[][] matrix) {
        
        int n=matrix.length;
        int xb=0,yb=0,xe=n-1,ye=n-1;
        
        for(int i=0;i<(n+1)/2;i++){
            
            for(int j=yb;j<ye;j++){
                
                int tmp=matrix[xb][j];
                matrix[xb][j]=matrix[n-1-j][yb];
                matrix[n-1-j][yb]=matrix[xe][n-1-j];
                matrix[xe][n-1-j]=matrix[j][ye];
                matrix[j][ye]=tmp;
            }
            xb++;xe--;yb++;ye--;
            
        }
        
    }
}
