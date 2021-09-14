class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer>ans=new ArrayList<>();
        
        int rows=matrix.length;
        int cols=matrix[0].length;
        int Xb=0,Yb=0,Xe=rows-1,Ye=cols-1;
        for(int iterations=0;iterations<(rows+1)/2;iterations++){
            
            if(Yb<=Ye){
                for(int i=Yb;i<=Ye;i++){
                    ans.add(matrix[Xb][i]);
                }
                Xb++;
            }
            else{
                break;
            }
            
            if(Xb<=Xe){
                for(int i=Xb;i<=Xe;i++){
                    ans.add(matrix[i][Ye]);
                }
                Ye--;
            }
            else{
                break;
            }
            
            if(Ye>=Yb){
                for(int i=Ye;i>=Yb;i--){
                    ans.add(matrix[Xe][i]);
                }
                Xe--;
            }
            else{
                break;
            }
            
            if(Xe>=Xb){
                for(int i=Xe;i>=Xb;i--){
                    ans.add(matrix[i][Yb]);
                }
                Yb++;
            }
            else{
                break;
            }
            
        }
        return ans;
        
    }
}
