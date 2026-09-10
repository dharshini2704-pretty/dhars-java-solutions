class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        int[] last = new int[256];

        for (int i = 0; i < 256; i++) {
            last[i] = -1;
        }

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (last[ch] >= left) {
                left = last[ch] + 1;
            }

            last[ch] = right;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
