package com.map.middle;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TopStudentsTest {

    TopStudents obj = new TopStudents();

    /**
     * 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is studious","the student is smart"], student_id = [1,2], k = 2
     * 输出：[1,2]
     * 解释：
     * 两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
     */
    @Test
    public void topStudents() {
        String[] positiveFeedback = new String[]{"smart", "brilliant", "studious"};
        String[] negativeFeedback = new String[]{"not"};
        String[] report = new String[]{"this student is studious", "the student is smart"};
        int[] student = new int[]{1, 2};
        List<Integer> students = obj.topStudents(positiveFeedback, negativeFeedback, report, student, 2);
        System.out.println(students);
    }

    /**
     * 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
     * 输出：[2,1]
     * 解释：
     * - ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
     * - ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
     * 学生 2 分数更高，所以返回 [2,1] 。
     */
    @Test
    public void topStudents2() {
        String[] positiveFeedback = new String[]{"smart", "brilliant", "studious"};
        String[] negativeFeedback = new String[]{"not"};
        String[] report = new String[]{"this student is not studious", "the student is smart"};
        int[] student = new int[]{1, 2};
        List<Integer> students = obj.topStudents(positiveFeedback, negativeFeedback, report, student, 2);
        System.out.println(students);
    }
}