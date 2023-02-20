package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 6184. 统计共同度过的日子数
 *
 * @author weijiaduo
 * @since 2022/9/17
 */
public class CountDaysTogether implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String arriveAlice = "10-01";
        String leaveAlice = "10-31";
        String arriveBob = "11-01";
        String leaveBob = "12-31";
        int result = countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(result);
        return result;
    }

    final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a1 = day(arriveAlice);
        int a2 = day(leaveAlice);
        if (a2 < a1) {
            a2 += 365;
        }
        int b1 = day(arriveBob);
        int b2 = day(leaveBob);
        if (b2 < b1) {
            b2 += 365;
        }

        if (a1 <= b1) {
            if (b1 > a2) {
                return 0;
            } else {
                return Math.min(a2 - b1 + 1, b2 - b1 + 1);
            }
        } else {
            if (a1 > b2) {
                return 0;
            } else {
                return Math.min(b2 - a1 + 1, a2 - a1 + 1);
            }
        }
    }

    private int day(String dayStr) {
        String[] d = dayStr.split("-");
        int month = Integer.parseInt(d[0]);
        int monthDays = 0;
        for (int i = 0; i < month - 1; i++) {
            monthDays += days[i];
        }
        int dateDay = Integer.parseInt(d[1]);
        return monthDays + dateDay;
    }

}
