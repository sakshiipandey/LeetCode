class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase()
                             .replaceAll("[^a-z ]", " ");

        String[] words = paragraph.split("\\s+");

        int maxCount = 0;
        String answer = "";

        for (int i = 0; i < words.length; i++) {

            // Check if current word is banned
            boolean isBanned = false;

            for (int k = 0; k < banned.length; k++) {
                if (words[i].equals(banned[k].toLowerCase())) {
                    isBanned = true;
                    break;
                }
            }

            if (isBanned) {
                continue;
            }

            int count = 0;

            // Count same words using j
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                answer = words[i];
            }
        }

        return answer;
    }
}