package com.wjd.practice.io;

import java.io.*;
import java.nio.file.Files;

/**
 * @author weijiaduo
 * @since 2023/9/20
 */
public class FileTest {

    static String ascii = "D:\\Projects\\Study\\first-os\\tolset\\28g\\haribote\\hankaku.bin";
    static String chinese = "D:\\Projects\\Study\\BitmapFont-master\\font\\HZK16S";
    static String total = "D:\\Projects\\Study\\first-os\\src\\nihongo\\chgb2312.fnt";

    public static void main(String[] args) throws Exception {
        readFnt();
    }

    public static void readFnt() throws Exception {
        int[] word = new int[]{0xC9, 0xFD, 0xB4, 0xEF, 0xBE, 0xAD, 0xC3, 0xB3, 0xB9, 0xDC, 0xC0, 0xED, 0xD1, 0xA7, 0xD4, 0xBA};
        int[] key = new int[]{0x80, 0x40, 0x20, 0x10, 0x08, 0x04, 0x02, 0x01};
        RandomAccessFile file = new RandomAccessFile(total, "r");
        byte[] buf = new byte[32];
        for (int i = 0; i < word.length / 2; i++) {
            // 将文件指针移动到所需的位置
            int offset = 256 * 16 + (94 * (word[i * 2] - 0xa1) + (word[i * 2 + 1] - 0xa1)) * 32;
            System.out.println(offset);
            file.seek(offset);
            file.read(buf, 0, 32);
            for (int k = 0; k < 16; k++) {
                for (int j = 0; j < 2; j++) {
                    for (int x = 0; x < 8; x++) {
                        int f = buf[k * 2 + j] & key[x];
                        System.out.print(f > 0 ? "*" : ".");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void writeFnt() throws Exception {
        InputStream asc = Files.newInputStream(new File(ascii).toPath());
        InputStream ch = Files.newInputStream(new File(chinese).toPath());
        OutputStream t = Files.newOutputStream(new File(total).toPath());
        byte[] ascBytes = new byte[4096];
        byte[] chBytes = new byte[165440];
        asc.read(ascBytes);
        ch.read(chBytes);
        t.write(ascBytes);
        t.write(chBytes);
        t.close();
        ch.close();
        asc.close();
    }

}
