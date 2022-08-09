package com.wjd.pattern.interpreter;

/**
 * @since 2021/12/18
 */
public class CommandNode extends Node {

    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        // <command> ::= <repeat command> | <primitive command>
        if ("repeat".equals(context.currentToken())) {
            node = new RepeatCommandNode();
        } else {
            node = new PrimitiveCommandNode();
        }
        node.parse(context);
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
