package com.wjd.pattern.behavioral.command;

import java.util.Stack;

/**
 * @since 2021/12/14
 */
public class MacroCommand implements Command {

    private final Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
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
