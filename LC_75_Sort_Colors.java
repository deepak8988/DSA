class Solution {
    public void sortColors(int[] arr) {
        int n=arr.length;
        int zero=0,two=n-1;
        
        for(int i=0;i<=two;){
            if(arr[i]==0){
                if(zero!=i){
                    swap(arr,i,zero);
                    zero++;
                    
                }
                else{
                    zero++;
                    i++;
                }
            }
            else if(arr[i]==2){
                if(two!=i){
                    swap(arr,i,two);
                    two--;
                }
                else{
                    two--;
                    i++;
                }
            }
            else
                i++;    //no need to do anything in case of 1
           
        }
    }
    
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
