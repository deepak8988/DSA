class Solution {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            while(true){
                if((nums[i]==i+1)||(nums[i]==-1))
                    break;
                if(nums[nums[i]-1]==nums[i]){
                    nums[i]=-1;
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-1)
                ans.add(i+1);
        }
        
        return ans;
        
    }
}
