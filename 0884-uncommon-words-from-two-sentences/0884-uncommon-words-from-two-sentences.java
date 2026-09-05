class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {

        String[] wordOne = s1.split("\\s+");
        String[] wordTwo = s2.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        int i = 0;

        while(i < wordOne.length) {
            map.put(wordOne[i], map.getOrDefault(wordOne[i], 0) + 1);
            i++;
        }

        i = 0;

        while(i < wordTwo.length) {
            map.put(wordTwo[i], map.getOrDefault(wordTwo[i], 0) + 1);
            i++;
        }

        ArrayList<String> ans = new ArrayList<>();

        for(String word : map.keySet()) {
            if(map.get(word) == 1) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }
}