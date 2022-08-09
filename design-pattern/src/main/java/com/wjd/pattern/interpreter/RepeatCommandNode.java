package com.wjd.pattern.interpreter;

/**
 * @since 2021/12/18
 */
public class RepeatCommandNode extends Node {

    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        // <repeat command> ::= repeat <number> <command list>
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[repeat " + number +  " " + commandListNode + "]";
    }
}
