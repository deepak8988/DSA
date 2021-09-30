class Solution {
    
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            
            while((nums[i]!=i+1) && (nums[i]!=nums[nums[i]-1]) ){
                swap(nums,i,nums[i]-1);
            }
            
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                ans.add(nums[i]);
        }
        
        return ans;
    }
}
//another better solution can be, whenever encountering an element for first time nums[i] change nums[nums[i]-1] to negative
//if you find a negative element present already means that element has appeared already
