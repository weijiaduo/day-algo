package com.wjd.util;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * 格式化方法测试
 *
 * @author weijiaduo
 * @since 2023/1/7
 */
public class FormatterTest {

    @Test
    void testBool() {
        // null
        System.out.printf("null: %b, %B %n", null, null);
        // true/false
        System.out.printf("bool: %b, %B %n", true, false);
        // 其他类型
        System.out.printf("other: %b, %B %n", 1, "test");
    }

    @Test
    void testHash() {
        // null
        System.out.printf("null: %h, %H %n", null, null);
        // hash
        System.out.printf("hash: %h, %H %n", 12.0, "false");
    }

    @Test
    void testString() {
        // null
        System.out.printf("null: %s, %S %n", null, null);
        // string
        System.out.printf("string: %s, %S %n", 123, "string");
    }

    @Test
    void testChar() {
        // null
        System.out.printf("null: %c, %C %n", null, null);
        // char
        System.out.printf("char: %c, %C %n", 36, 'a');
    }

    @Test
    void testIntegral() {
        // null
        System.out.printf("null: %d %n", null);
        // 10-int
        System.out.printf("10-int: %d %n", 36);
        // 8-int
        System.out.printf("8-int: %o %n", 40);
        // 16-int
        System.out.printf("16-int: %x, %X %n", 46, 47);
    }

    @Test
    void testFloat() {
        // null
        System.out.printf("null: %f %n", null);
        // scientific
        System.out.printf("scientific: %e, %E %n", 360000000000000.0, 0.00002);
        // float
        System.out.printf("float: %f, %f %n", 40.0f, 100.2);
        // rounding
        System.out.printf("rounding: %g, %G %n", 0.0001, 0.00000000000001);
        // 16-float
        System.out.printf("16-float: %a, %A %n", 0.0001, 0.00000000000001);
    }

    @Test
    void testDateTime() {
        // null
        System.out.printf("null: %th %n", null);
        // year
        System.out.printf("year: %ty, %tY %n", new Date(), new Date());
        // month
        System.out.printf("month: %tM %n", new Date());
        // hour
        System.out.printf("hour: %tH %n", new Date());
        // second
        System.out.printf("second: %ts, %tS %n", new Date(), new Date());
    }

    @Test
    void testPercent() {
        // percent
        System.out.printf("percent: %% %n");
    }

    @Test
    void testLineSeparator() {
        // line separator
        System.out.printf("line separator: %n line separator");
    }

    @Test
    void testDate() {
        // year
        System.out.printf("year: %ty, %tY %n", new Date(), new Date());
        // month name
        System.out.printf("month name: %tb, %tB, %th %n", new Date(), new Date(), new Date());
        // month number
        System.out.printf("month number: %tm %n", new Date());
        // week
        System.out.printf("week: %ta, %tA %n", new Date(), new Date());
        // day
        System.out.printf("day: %td, %te %n", new Date(), new Date());
    }

    @Test
    void testTime() {
        Date date = new Date();
        date.setTime(new Date().getTime() - 4 * 60 * 60 * 1000);
        // hour
        System.out.printf("hour: %tH, %tI, %tk, %tl %n", date, date, date, date);
        // minute
        System.out.printf("minute: %tM %n", date);
        // second
        System.out.printf("second: %ts %tS %n", date, date);
        // millisecond
        System.out.printf("millisecond: %tL, %tQ %n", date, date);
        // nanosecond
        System.out.printf("nanosecond: %tN %n", date);
        // noon
        System.out.printf("noon: %tp %n", date);
    }

    @Test
    void testShortTime() {
        // HH:MM
        System.out.printf("HH:MM: %tR %n", new Date());
        // HH:MM:SS
        System.out.printf("HH:MM:SS: %tT %n", new Date());
        // mm/dd/yy
        System.out.printf("mm/dd/yy: %tD %n", new Date());
        // YYYY-mm-dd
        System.out.printf("YYYY-mm-dd: %tF %n", new Date());
        // date time
        System.out.printf("date time: %tc %n", new Date());
    }

    @Test
    void testFlags() {
        // left-justified
        System.out.printf("left-justified: ^%5d^, ^%-5d^ %n", 99, 99);
        // conversion-dependent
        System.out.printf("conversion-dependent: %f, %#f %n", 1.0, 1.0);
        System.out.printf("conversion-dependent: %o, %#o %n", 40, 40);
        System.out.printf("conversion-dependent: %X, %#X %n", 47, 47);
        // sign
        System.out.printf("sign: %d, %+d %n", 99, 99);
        // space
        System.out.printf("space: ^%d^, ^% 5d^ %n", 99, 99);
        // zero
        System.out.printf("zero: ^%4d^, ^%04d^ %n", 99, 99);
        // grouping separators
        System.out.printf("grouping separators: %d, %,d %n", 123456789, 123456789);
        // negative parentheses
        System.out.printf("negative parentheses: %d, %(d %n", -99, -99);
    }

    @Test
    void testWidth() {
        // width
        System.out.printf("width: ^%4d^ %n", 99);
        System.out.printf("width: %4s %n", "123456789");
    }

    @Test
    void testPrecision() {
        // general
        System.out.printf("general: %.6s %n", "123456789");
        // float
        System.out.printf("float: %.3f %n", 123.342235625345);
    }

}
