package com.wjd.pattern.interpreter;

/**
 * @since 2021/12/18
 */
public class PrimitiveCommandNode extends Node {

    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        // <primitive command> ::= go | right | left
        name = context.currentToken();
        context.skipToken(name);
        if (!"go".equals(name) && !"right".equals(name) && !"left".equals(name)) {
            throw new ParseException(name + " is undefined");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
