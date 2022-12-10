package com.wjd.pattern.interpreter;

/**
 * @since 2021/12/18
 */
public class ProgramNode extends Node {
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        // <program> ::= program <command list>
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[" + "program=" + commandListNode + "]";
    }
}
