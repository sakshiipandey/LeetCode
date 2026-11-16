class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans=new int[k];
        int[] stack=new int[nums.length];
        int top=0;
        int remove=nums.length-k;
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            while(top>0 && stack[top-1]>curr && remove>0){
                top--;
                remove--;
            }
            stack[top]=curr;
            top++;
        }
        top=top-remove;
        for(int i=0; i<k; i++){
            ans[i]=stack[i];
        }
        return ans;
    }
}