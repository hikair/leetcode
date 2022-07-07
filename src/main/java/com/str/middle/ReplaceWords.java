package com.str.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceWords {

    public String replaceWords2(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparingInt(String::length));
        return Arrays.stream(sentence.split(" "))
                .map(e -> {
                    for (String root : dictionary) {
                        if (e.startsWith(root)) {
                            return root;
                        }
                    }
                    return e;
                }).collect(Collectors.joining(" "));
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = buildTrie(dictionary);
        return Arrays.stream(sentence.split(" ")).map(e -> findRoot(trie, e)).collect(Collectors.joining(" "));
    }


    private String findRoot(Trie trie, String word) {
        StringBuilder sb = new StringBuilder();
        Trie temp = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children.containsKey('#')) {
                return sb.toString();
            }
            if (!temp.children.containsKey(c)) {
                return word;
            }
            sb.append(c);
            temp =  temp.children.get(c);
        }
        return sb.toString();
    }

    private Trie buildTrie(List<String> dictionary) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            Trie temp = trie;
            for (char c : root.toCharArray()) {
                temp.children.putIfAbsent(c, new Trie());
                temp = temp.children.get(c);
            }
            temp.children.put('#', null);
        }
        return trie;
    }

    private static class Trie {
        Map<Character, Trie> children;

        public Trie() {
            children = new HashMap<>();
        }
    }
}
