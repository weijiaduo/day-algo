package com.wjd.pattern.behavioral.chain;

/**
 * @since 2021/12/7
 */
public abstract class Support {

    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    /**
     * 解决问题的步骤
     */
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    /**
     * 解决问题的方法
     */
    protected abstract boolean resolve(Trouble  trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " can not be resolved.");
    }

    public String toString() {
        return "[" + name + "]";
    }

}
