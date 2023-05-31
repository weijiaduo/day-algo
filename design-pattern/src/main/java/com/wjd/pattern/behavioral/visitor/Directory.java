package com.wjd.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @since 2021/12/13
 */
public class Directory extends Entry {

    private String name;
    private ArrayList<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Entry addEntry(Entry entry) {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator() {
        return dir.iterator();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            size += entry.getSize();
        }
        return size;
    }
}
