class Solution {
    public int minDeletions(String s) {
        int[] charCount = new int[26]; // Assuming lowercase English letters

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        Set<Integer> uniqueCounts = new HashSet<>();
        int deletions = 0;

        for (int count : charCount) {
            while (count > 0 && !uniqueCounts.add(count)) {
                // Try decrementing the count until it becomes unique
                count--;
                deletions++;
            }
        }

        return deletions;
    }
}
