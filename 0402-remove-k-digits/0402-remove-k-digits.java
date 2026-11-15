class Solution {
    //monotonic increasing
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<nums.length(); i++){
            char curr= nums.charAt(i);
        while(!st.isEmpty() && st.peek()>curr && k>0){
            st.pop();
            k--;
        }
        st.push(curr);
    }
    while(k>0){
        st.pop();
        k--;
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0;i<st.size();i++)
    {
        sb.append(st.get(i));
    }
    String ans = sb.toString();

    int i = 0;

    while(i<ans.length()&&ans.charAt(i)=='0')
    {
        i++;
}

ans=ans.substring(i);

return ans.isEmpty()?"0":ans;
}}