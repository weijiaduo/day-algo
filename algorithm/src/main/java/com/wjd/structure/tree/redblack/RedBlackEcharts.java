package com.wjd.structure.tree.redblack;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RedBlackEcharts {

    private static final String RED = "#c23531";
    private static final String BLACK = "#000";
    private static final String WHITE = "#fff";

    private static final int X_MAX = 1024;
    private static final int Y_MAX = 768;

    private RedBlackTree redBlackTree;
    private int treeHeight;

    private JsonObject option;
    private Map<Integer, JsonObject> nodes;

    // 根节点坐标
    private int rootX = 550;
    private int rootY = 550;

    // 节点大小和间距
    private int symbolSize = 30;
    private int xSymbolGap = symbolSize;
    private int ySymbolGap = symbolSize;

    public RedBlackEcharts(RedBlackTree redBlackTree) {
        this.redBlackTree = redBlackTree;
        treeHeight = redBlackTree.getHeight();
        nodes = new HashMap<>();
        initOption();
    }

    private void initOption() {
        initSymbolSize();
        rebuildOption();
    }

    /**
     * 初始化计算图形节点的大小，避免图形的节点交叉重叠
     */
    private void initSymbolSize() {
        int size = symbolSize;
        int maxLevelNodes = (int) Math.pow(2, treeHeight - 1);
        int x = (xSymbolGap + size) * maxLevelNodes;
        if (x > X_MAX) {
            size = X_MAX / maxLevelNodes;
            symbolSize = (int) (size * 0.8);
            xSymbolGap = size - symbolSize;
        }
    }

    private void rebuildOption() {
        int size = redBlackTree.size();
        if (size == 0) {
            return;
        }

        option = getDefaultOption();
        JsonArray series = option.getAsJsonArray("series");
        JsonObject seriesItem = getDefaultSeriesItem();
        JsonArray data = new JsonArray();
        JsonArray links = new JsonArray();

        // 按层次遍历所有节点
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(redBlackTree.getRoot());
        while (!nodeList.isEmpty()) {
            Node curNode = nodeList.pop();
            JsonObject nodeJson = toDataNode(curNode);
            data.add(nodeJson);
            nodes.put(curNode.getVal(), nodeJson);
            if (curNode.getLeft() != null) {
                nodeList.add(curNode.getLeft());
                JsonObject linkJson = toNodeLink(curNode.getLeft());
                links.add(linkJson);
            }
            if (curNode.getRight() != null) {
                nodeList.add(curNode.getRight());
                JsonObject linkJson = toNodeLink(curNode.getRight());
                links.add(linkJson);
            }
        }

        seriesItem.add("data", data);
        seriesItem.add("links", links);
        series.add(seriesItem);
    }

    /**
     * 获取默认的option
     * @return option json
     */
    private JsonObject getDefaultOption() {
        JsonObject optionJson = new JsonObject();
        optionJson.addProperty("animationDurationUpdate", 1500);
        optionJson.addProperty("animationEasingUpdate", "quinticInOut");

        // tooltip
        JsonObject tooltipJson = new JsonObject();
        tooltipJson.addProperty("formatter", "{b}");
        optionJson.add("tooltip", tooltipJson);

        // series
        JsonArray seriesJson = new JsonArray();
        optionJson.add("series", seriesJson);

        return optionJson;
    }

    /**
     * 获取默认的单个序列对象
     * @return 单个序列对象 json
     */
    private JsonObject getDefaultSeriesItem() {
        JsonObject itemJson = new JsonObject();

        // type
        itemJson.addProperty("type", "graph");
        itemJson.addProperty("layout", "none");
        itemJson.addProperty("symbolSize", symbolSize);
        itemJson.addProperty("roam", true);

        // label
        JsonObject labelJson = new JsonObject();
        boolean labelShow = symbolSize >= 16;
        labelJson.addProperty("show", labelShow);
        labelJson.addProperty("fontSize", 14);
        itemJson.add("label", labelJson);

        // lineStyle
        JsonObject lineStyleJson = new JsonObject();
        lineStyleJson.addProperty("opacity", 0.9);
        lineStyleJson.addProperty("width", 2);
        lineStyleJson.addProperty("curveness", 0);
        itemJson.add("lineStyle", lineStyleJson);

        return itemJson;
    }

    /**
     * 树节点转换成数据节点
     * @param node 树节点
     * @return 转换得到的数据节点
     */
    private JsonObject toDataNode(Node node) {
        JsonObject nodeJson = createDataNodeWithCoordinate(node);

        // name
        String name = getNodeName(node);
        nodeJson.addProperty("name", name);

        // label
        JsonObject labelJson = new JsonObject();
        labelJson.addProperty("color", WHITE);
        nodeJson.add("label", labelJson);

        // itemStyle
        JsonObject styleJson = new JsonObject();
        String styleColor;
        boolean isRed = node.isRed();
        if (isRed) {
            styleColor = RED;
        } else {
            styleColor = BLACK;
        }
        styleJson.addProperty("color", styleColor);
        nodeJson.add("itemStyle", styleJson);

        return nodeJson;
    }

    /**
     * 创建数据节点，并计算新节点的坐标
     * @param node 红黑树节点
     * @return 创建的数据节点
     */
    private JsonObject createDataNodeWithCoordinate(Node node) {
        JsonObject nodeJson = new JsonObject();
        Node parent = node.getParent();
        if (parent == null) {
            nodeJson.addProperty("x", rootX);
            nodeJson.addProperty("y", rootY);
            nodeJson.addProperty("level", 1);
        } else {
            JsonObject parentJson = nodes.get(parent.getVal());
            int x = parentJson.get("x").getAsInt();
            int y = parentJson.get("y").getAsInt();
            int level = parentJson.get("level").getAsInt();

            // 根据父子节点之间可能会有多少个子孙节点来计算偏移
            int xOffset = (int) ((symbolSize + xSymbolGap) * Math.pow(2, treeHeight - level - 1));
            int yOffset = (symbolSize + ySymbolGap) * treeHeight;

            int newX = x;
            if (node == parent.getLeft()) {
                newX -= xOffset;
            } else {
                newX += xOffset;
            }
            int newY = y + yOffset;
            int newLevel = level + 1;
            nodeJson.addProperty("x", newX);
            nodeJson.addProperty("y", newY);
            nodeJson.addProperty("level", newLevel);
        }
        return nodeJson;
    }

    /**
     * 树节点转换成点连接关系
     * @param node 树节点
     * @return 转换得到的点连接关系
     */
    private JsonObject toNodeLink(Node node) {
        JsonObject linkJson = new JsonObject();
        Node parent = node.getParent();
        String parentName = getNodeName(parent);
        String name = getNodeName(node);
        linkJson.addProperty("source", parentName);
        linkJson.addProperty("target", name);
        JsonArray symbolJson = new JsonArray();
        symbolJson.add("none");
        symbolJson.add("none");
        linkJson.add("symbol", symbolJson);
        return linkJson;
    }

    private String getNodeName(Node node) {
        String name = "";
        if (node != null) {
            name = String.valueOf(node.getVal());
        }
        return name;
    }

    public String getOption() {
        if (option == null) {
            rebuildOption();
        }
        return option.toString();
    }

    @Override
    public String toString() {
        return getOption();
    }
}
