package com.wjd.pattern.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * @since 2021/12/14
 */
public class MacroCommand implements Command {

    private Stack commands = new Stack();

    @Override
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }

    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
