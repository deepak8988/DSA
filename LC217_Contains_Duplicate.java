class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        if(nums.length<=1)
            return false;
        
        Set<Integer> s=new HashSet<Integer>();
        
        for(int i:nums){
            if(!s.add(i))return true;
        }
        
        return false;
        
    }
}
