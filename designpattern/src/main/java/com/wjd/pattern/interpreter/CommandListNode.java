package com.wjd.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021/12/18
 */
public class CommandListNode extends Node {

    private List<Node> commandNodes = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        // <command list> ::= <command>* end
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing end");
            }
            if ("end".equals(context.currentToken())) {
                context.skipToken("end");
                break;
            }
            Node commandNode = new CommandNode();
            commandNode.parse(context);
            commandNodes.add(commandNode);
        }
    }

    @Override
    public String toString() {
        return commandNodes.toString();
    }
}
