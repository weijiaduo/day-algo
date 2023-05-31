package com.wjd.pattern.behavioral.visitor;

import java.util.Iterator;

/**
 * @since 2021/12/13
 */
public abstract class Entry implements Element {

    public abstract String getName();
    public abstract int getSize();

    public Entry addEntry(Entry entry) {
        throw new FileTreatmentException();
    }

    public Iterator iterator() {
        throw new FileTreatmentException();
    }

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
