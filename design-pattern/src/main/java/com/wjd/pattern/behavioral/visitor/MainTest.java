package com.wjd.pattern.behavioral.visitor;

/**
 * @since 2021/12/13
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.addEntry(binDir);
        rootDir.addEntry(tmpDir);
        rootDir.addEntry(usrDir);
        binDir.addEntry(new File("vi", 10000));
        binDir.addEntry(new File("latex", 20000));
        rootDir.accept(new ListVisitor());

        System.out.println("");
        System.out.println("Making user entries...");
        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usrDir.addEntry(yuki);
        usrDir.addEntry(hanako);
        usrDir.addEntry(tomura);
        yuki.addEntry(new File("diary.html", 100));
        yuki.addEntry(new File("Composite.java", 300));
        hanako.addEntry(new File("memo.text", 400));
        tomura.addEntry(new File("game.doc", 500));
        tomura.addEntry(new File("junk.maik", 600));
        rootDir.accept(new ListVisitor());
    }

}
