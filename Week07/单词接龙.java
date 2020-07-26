class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        Set<String> beginSet = new HashSet<String>(),
                    endSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
		if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        int len = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        int wlen = beginWord.length();
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> temp = new HashSet<String>();
            for(String word : beginSet) {
                char[] chars = word.toCharArray();
                for(int i = 0;i < wlen;i++) {
                    for(char c = 'a';c <= 'z';c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        if(endSet.contains(target)) {
                            return len + 1;
                        }
                        if(!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            len++;
            beginSet = temp;
        }
        return 0;
    }
}