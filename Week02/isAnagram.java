//异位词
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // //暴力法
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();
        
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);

        // return Arrays.equals(sArr,tArr);
        
        if (s.length() != t.length() ) {
            return false;
        }
        // int counter[] = new int[26];
        // for (int i = 0;i < s.length();i++) {
        //     counter[s.charAt(i)-'a']++;
        //     counter[t.charAt(i)-'a']--;
        // }
        // for (int coun : counter) {
        //     if (coun != 0) {
        //         return false;
        //     }
        // }
        // return true;
        int table[] = new int[26];
        for (int i = 0;i < s.length();i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0;i < t.length();i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}