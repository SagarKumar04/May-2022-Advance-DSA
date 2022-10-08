/*
Leetcode Link: https://leetcode.com/problems/word-ladder-ii/
 */

package Graph.Questions.Leetcode;

import java.util.*;

public class WordLadderIIOptimized {
    Map<String, Integer> wordLevelMap;
    List<List<String>> result;
    String beginWordCopy;

    private void buildResult(String word, List<String> sequence) {
        if(word.equals(beginWordCopy)) {
            List<String> sequenceCopy = new ArrayList<>(sequence);
            Collections.reverse(sequenceCopy);
            result.add(sequenceCopy);
        }

        int size = word.length();
        int levelNumber = wordLevelMap.get(word);

        for(int i = 0; i < size; i++) {
            StringBuilder newWord = new StringBuilder(word);

            for(char ch = 'a'; ch <= 'z'; ch++) {
                newWord.setCharAt(i, ch);

                String replacedString = newWord.toString();
                if(wordLevelMap.containsKey(replacedString)
                && wordLevelMap.get(replacedString) + 1 == levelNumber) {
                    sequence.add(replacedString);
                    buildResult(replacedString, sequence);
                    sequence.remove(sequence.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordLevelMap = new HashMap<>();
        result = new ArrayList<>();

        beginWordCopy = beginWord;

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        wordLevelMap.put(beginWord, 1);
        wordSet.remove(beginWord);

        int size = beginWord.length();

        while(!queue.isEmpty()) {
            String word = queue.poll();
            int levelNumber = wordLevelMap.get(word);

            for(int i = 0; i < size; i++) {
                StringBuilder newWord = new StringBuilder(word);

                for(char ch = 'a'; ch <= 'z'; ch++) {
                    newWord.setCharAt(i, ch);

                    String replacedString = newWord.toString();
                    if(wordSet.contains(replacedString)) {
                        queue.add(replacedString);
                        wordSet.remove(replacedString);
                        wordLevelMap.put(replacedString, levelNumber + 1);
                    }
                }
            }
        }

        if(wordLevelMap.containsKey(endWord)) {
            List<String> sequence = new ArrayList<>();
            sequence.add(endWord);
            buildResult(endWord, sequence);
        }

        return result;
    }
}
