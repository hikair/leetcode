package com.map.middle;

import com.common.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2512. 奖励最顶尖的 K 名学生
 * <p>
 * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 * <p>
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 * <p>
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 * <p>
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 * <p>
 * https://leetcode.cn/problems/reward-top-k-students/description
 */
public class TopStudents {

    public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
        Map<String, Integer> wordScoreMap = new HashMap<>();
        for (String word : positiveFeedback) {
            wordScoreMap.put(word, 3);
        }
        for (String word : negativeFeedback) {
            wordScoreMap.put(word, -1);
        }
        int n = studentId.length;
        int[][] studentScore = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] words = report[i].split(" ");
            int score = 0;
            for (String word : words) {
                score += wordScoreMap.getOrDefault(word, 0);
            }
            studentScore[i] = new int[]{studentId[i], score};
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(studentScore, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        for (int i = 0; i < k; i++) {
            ans.add(studentScore[i][0]);
        }
        return ans;
    }

    public List<Integer> topStudents2(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
        Set<String> positiveFeedbackSet = Arrays.stream(positiveFeedback).collect(Collectors.toSet());
        Set<String> negativeFeedbackSet = Arrays.stream(negativeFeedback).collect(Collectors.toSet());

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1.getRight(), o2.getRight())) {
                return o1.getLeft() - o2.getLeft();
            }
            return o2.getRight() - o1.getRight();
        });
        int n = studentId.length;
        for (int i = 0; i < n; i++) {
            String[] words = report[i].split(" ");
            int score = 0;
            for (String word : words) {
                if (positiveFeedbackSet.contains(word)) {
                    score += 3;
                }
                if (negativeFeedbackSet.contains(word)) {
                    score--;
                }
            }
            queue.add(Pair.of(studentId[i], score));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().getLeft());
        }
        return ans;
    }
}
