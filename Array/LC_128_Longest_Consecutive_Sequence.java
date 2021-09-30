class Solution {
    public int longestConsecutive(int[] nums) { 
        
        HashSet<Integer>S=new HashSet<>();
        for(int i:nums)
            S.add(i);
        int maxSeqLength=0;
        for(int i:S){
            if(!S.contains(i-1)){
                int curSeqlength=1;
                int num=i;
                while(S.contains(num+1)){
                    num++;
                    curSeqlength++;
                }
                maxSeqLength=Math.max(maxSeqLength,curSeqlength);
            }
        }
        
        return maxSeqLength;
        
    }
}
