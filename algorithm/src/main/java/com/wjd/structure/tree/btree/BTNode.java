package com.wjd.structure.tree.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * B-树节点
 *
 * @author weijiaduo
 * @since 2023/1/2
 */
public class BTNode<K extends Comparable<K>, V> {

    /**
     * m 阶 B 树
     */
    private final int m;
    /**
     * 节点元素阈值
     */
    private final int threshold;
    /**
     * 节点元素数组
     * <p>
     * 元素的第 0 位始终是一个占位元素，专门用于存放最左子节点
     * <p>
     * 所以一个节点能拥有的元素个数最多是 m - 1
     */
    private final Object[] elements;
    /**
     * 实际元素数量
     * <p>
     * 取值范围是 [0, m - 1]
     */
    private int size;

    public BTNode(int m) {
        this.m = m;
        // 半数阈值 ceil(m / 2) - 1
        this.threshold = (m + 1) / 2 - 1;
        elements = new Object[m];
        // 最左子节点占位
        elements[0] = new Entry<K, V>(null, null);
        size = 0;
    }

    /**
     * @return 元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 是否已满
     *
     * @return true已满/false未满
     */
    public boolean isFull() {
        return size == m - 1;
    }

    /**
     * 是否为空
     *
     * @return true为空/false非空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 节点是否合法
     * <p>
     * 节点的元素数量要求满足: >= ceil(m/2) - 1
     *
     * @return true合法/false非法
     */
    public boolean isLegal() {
        return size >= threshold;
    }

    /**
     * 是否可借用元素给别的节点
     * <p>
     * 当节点数量超过一半容量时，则可以外借元素
     *
     * @return true可借用/false不可借用
     */
    private boolean canBorrow() {
        return size > threshold;
    }

    /**
     * 是否是叶子节点
     *
     * @return true叶子节点/false内部节点
     */
    public boolean isLeaf() {
        for (int i = 0; i <= size; i++) {
            if (getChild(i) != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 所有元素
     *
     * @return 元素集合
     */
    public List<Entry<K, V>> entries() {
        List<Entry<K, V>> entries = new ArrayList<>(size);
        // 元素从索引 1 开始
        for (int i = 1; i <= size; i++) {
            entries.add(getEntry(i));
        }
        return entries;
    }

    /**
     * 所有 key
     *
     * @return key 集合
     */
    public List<K> keys() {
        List<K> keys = new ArrayList<>(size);
        // 元素从索引 1 开始
        for (int i = 1; i <= size; i++) {
            keys.add(getKey(i));
        }
        return keys;
    }

    /**
     * 所有 value
     *
     * @return value 集合
     */
    public List<V> values() {
        List<V> values = new ArrayList<>(size);
        // 元素从索引 1 开始
        for (int i = 1; i <= size; i++) {
            values.add(getValue(i));
        }
        return values;
    }

    /**
     * 获取指定位置的 key
     *
     * @param index 索引
     * @return key
     */
    public K getKey(int index) {
        return getEntry(index).key;
    }

    /**
     * 获取指定位置的 value
     *
     * @param index 索引
     * @return value
     */
    public V getValue(int index) {
        return getEntry(index).value;
    }

    /**
     * 设置指定位置的值
     *
     * @param index 索引
     * @param value 值
     */
    public void setValue(int index, V value) {
        getEntry(index).value = value;
    }

    /**
     * 所有子节点
     *
     * @return 子节点集合
     */
    public List<BTNode<K, V>> children() {
        List<BTNode<K, V>> children = new ArrayList<>(size + 1);
        // 子节点从索引 0 开始
        for (int i = 0; i <= size; i++) {
            children.add(getChild(i));
        }
        return children;
    }

    /**
     * @return 第一个子节点
     */
    public BTNode<K, V> firstChild() {
        return getChild(0);
    }

    /**
     * @return 最后一个子节点
     */
    public BTNode<K, V> lastChild() {
        return getChild(size);
    }

    /**
     * 获取指定位置的下一层子节点
     *
     * @param index 指定位置
     * @return 下一层子树根节点
     */
    public BTNode<K, V> getChild(int index) {
        return getEntry(index).pointer;
    }

    /**
     * 更新设置指定位置的子节点
     *
     * @param index 索引
     * @param node  子节点
     */
    public void setChild(int index, BTNode<K, V> node) {
        getEntry(index).pointer = node;
    }

    /**
     * 二分查找指定 key 的位置
     * <p>
     * 返回最后一个小于等于 key 的位置
     *
     * @param key key
     * @return key 的位置
     */
    public int binary(K key) {
        // 第 0 位是占位元素，还没算在内
        return 1 + binaryle(keys(), key);
    }

    /**
     * 二分查找，返回最后一个小于等于 key 的位置
     *
     * @param keys key 集合
     * @param key  指定 key
     * @return 最后一个小于等于 key 的位置/-1
     */
    private int binaryle(List<K> keys, K key) {
        int size = keys.size();
        int l = 0, r = size - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            K k = keys.get(m);
            if (k.compareTo(key) <= 0) {
                if (m == size - 1 || keys.get(m + 1).compareTo(key) > 0) {
                    return m;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    /**
     * 添加新元素
     *
     * @param key   key
     * @param value value
     */
    public BTNode<K, V> add(K key, V value) {
        BTNode<K, V> node = new BTNode<>(m);
        node.addEntry(new Entry<>(key, value));
        return add(key, node);
    }

    /**
     * 添加新节点到当前节点
     *
     * @param node 新节点
     * @return 添加后的当前节点
     */
    public BTNode<K, V> add(K key, BTNode<K, V> node) {
        if (node == null || node.size() == 0) {
            return this;
        }

        // key 的插入索引位置
        int index = binary(key);
        // 新子节点替代旧子节点的位置
        setChild(index, node.firstChild());

        // 1. 当前空间足够插入
        int newSize = size + node.size();
        if (newSize < m) {
            for (Entry<K, V> entry : node.entries()) {
                insertEntry(++index, entry);
            }
            return this;
        }

        // 2. 当前空间不够，需要分裂成 3 个节点
        List<Entry<K, V>> allEntries = new ArrayList<>(newSize);
        List<Entry<K, V>> curEntries = entries();
        for (int i = 0; i < index && i < size; i++) {
            allEntries.add(curEntries.get(i));
        }
        allEntries.addAll(node.entries());
        for (int i = index; i < size; i++) {
            allEntries.add(curEntries.get(i));
        }

        // 根节点
        int mid = newSize / 2;
        BTNode<K, V> root = new BTNode<>(m);
        for (int i = mid; i <= mid; i++) {
            root.addEntry(allEntries.get(i));
        }
        // 左子节点
        BTNode<K, V> left = new BTNode<>(m);
        for (int i = 0; i < mid; i++) {
            left.addEntry(allEntries.get(i));
        }
        // 右子节点
        BTNode<K, V> right = new BTNode<>(m);
        for (int i = mid + 1; i < newSize; i++) {
            right.addEntry(allEntries.get(i));
        }

        // 边界指针
        left.setChild(0, firstChild());
        right.setChild(0, root.lastChild());
        root.setChild(0, left);
        root.setChild(root.size, right);
        return root;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 索引
     * @return 删除后的根节点
     */
    public BTNode<K, V> delete(int index) {
        if (isEmpty() || index == 0) {
            throw new IllegalStateException(String.format("index: %d, size: %d", index, size));
        }

        if (isLeaf()) {
            // 叶子节点
            // 直接删除，删除后可能会变成元素为空的空节点
            // 空节点将由父节点的 underflow 处理掉，或者由根节点处理掉
            removeEntry(index);
            return this;
        }

        // 内部节点
        // 使用前驱节点或后驱节点进行替换
        int rpIndex = getReplacer(this, index);
        BTNode<K, V> child = getChild(rpIndex);
        BTNode<K, V> newChild;
        if (rpIndex < index) {
            // 前驱节点
            Entry<K, V> max = max(child);
            newChild = removeMax(child);
            setChild(rpIndex, newChild);
            setEntry(index, max);
        } else {
            // 后驱节点
            Entry<K, V> min = min(child);
            newChild = removeMin(child);
            setChild(rpIndex, newChild);
            setEntry(index, min);
        }

        // 移除后可能需要父节点下溢
        return underflow(rpIndex);
    }

    /**
     * 存在非法子节点时，可能需要对父节点进行下溢操作
     *
     * @param index 父节点索引
     * @return 根节点
     */
    public BTNode<K, V> underflow(int index) {
        // 验证子节点是否合法
        BTNode<K, V> cur = getChild(index);
        if (cur == null || cur.isLegal()) {
            return this;
        }

        // 1. 从兄弟节点借一个元素
        BTNode<K, V> left = null;
        if (index > 0) {
            left = getChild(index - 1);
            if (left != null && left.canBorrow()) {
                borrowLeft(index);
                return this;
            }
        }
        BTNode<K, V> right = null;
        if (index < size) {
            right = getChild(index + 1);
            if (right != null && right.canBorrow()) {
                borrowRight(index);
                return this;
            }
        }

        // 2. 合并父元素 + 左右子节点，然后往上递归
        if (left == null) {
            // 始终把当前节点作为合并时的右子节点
            index += 1;
            left = cur;
            cur = right;
        }
        // 父节点合并到左子节点
        Entry<K, V> parentEntry = getEntry(index);
        left.addEntry(parentEntry);
        // 右子节点合并到左子节点
        left.setChild(left.size, cur.firstChild());
        for (Entry<K, V> entry : cur.entries()) {
            left.addEntry(entry);
        }
        removeEntry(index);

        return this;
    }

    /**
     * 借用左子节点的值，实际就是右旋
     *
     * @param index 父节点索引
     */
    private void borrowLeft(int index) {
        BTNode<K, V> left = getChild(index - 1);
        BTNode<K, V> right = getChild(index);
        if (right == null) {
            right = new BTNode<>(m);
            setChild(index, right);
        }

        Entry<K, V> parentEntry = getEntry(index);
        Entry<K, V> leftEntry = left.getEntry(left.size);
        BTNode<K, V> leftRight = left.lastChild();

        // 父节点转到右子节点
        right.insertEntry(1, parentEntry);
        right.setChild(1, right.firstChild());
        // 左子节点转到父节点
        left.removeEntry(left.size);
        setEntry(index, leftEntry);
        setChild(index, right);
        right.setChild(0, leftRight);
    }

    /**
     * 借用右子节点的值，实际就是左旋
     *
     * @param index 父节点索引
     */
    private void borrowRight(int index) {
        BTNode<K, V> right = getChild(index + 1);
        BTNode<K, V> left = getChild(index);
        if (left == null) {
            left = new BTNode<>(m);
            setChild(index, left);
        }

        Entry<K, V> parentEntry = getEntry(index + 1);
        Entry<K, V> rightEntry = right.getEntry(1);
        BTNode<K, V> rightLeft = right.firstChild();

        // 父节点转到左子节点
        left.addEntry(parentEntry);
        // 右子节点转到父节点
        right.setChild(0, right.getChild(1));
        right.removeEntry(1);
        setEntry(index + 1, rightEntry);
        setChild(index + 1, right);
        left.setChild(left.size, rightLeft);
    }

    /**
     * 获取可替换子节点索引（前驱/后驱）
     *
     * @param root  当前根节点
     * @param index 当前索引
     * @return 可替换子节点索引
     */
    private int getReplacer(BTNode<K, V> root, int index) {
        BTNode<K, V> right = null;
        if (index <= root.size) {
            right = root.getChild(index);
        }
        if (right == null) {
            return index - 1;
        }
        BTNode<K, V> left = null;
        if (index > 0) {
            left = root.getChild(index - 1);
        }
        if (left == null) {
            return index;
        }

        if (left.canBorrow()) {
            return index - 1;
        } else {
            return index;
        }
    }

    /**
     * 获取最大值
     *
     * @param root 当前根节点
     * @return 最大值
     */
    private Entry<K, V> max(BTNode<K, V> root) {
        if (root == null) {
            return null;
        }

        if (root.isLeaf()) {
            return root.getEntry(root.size);
        }
        return max(root.lastChild());
    }

    /**
     * 移除最大值
     *
     * @param root 当前根节点
     * @return 移除后的根节点
     */
    private BTNode<K, V> removeMax(BTNode<K, V> root) {
        if (root == null) {
            return null;
        }

        if (root.isLeaf()) {
            return root.delete(root.size);
        }
        return removeMax(root.lastChild());
    }

    /**
     * 获取最小值
     *
     * @param root 当前根节点
     * @return 最小值
     */
    private Entry<K, V> min(BTNode<K, V> root) {
        if (root == null) {
            return null;
        }

        if (root.isLeaf()) {
            return root.getEntry(1);
        }
        return min(root.firstChild());
    }

    /**
     * 移除最小值
     *
     * @param root 当前根节点
     * @return 移除值后的根节点
     */
    private BTNode<K, V> removeMin(BTNode<K, V> root) {
        if (root == null) {
            return null;
        }

        if (root.isLeaf()) {
            return root.delete(1);
        }
        return removeMin(root.firstChild());
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    private Entry<K, V> getEntry(int index) {
        return (Entry<K, V>) elements[index];
    }

    /**
     * 添加新元素
     * <p>
     * 此处不执行节点分裂的情况，需要分裂时应调用 add() 方法
     *
     * @param entry 元素
     */
    private void addEntry(Entry<K, V> entry) {
        if (isFull()) {
            throw new IllegalStateException(String.format("size: %d", size));
        }

        elements[++size] = entry;
    }

    /**
     * 插入指定元素
     *
     * @param index 插入索引
     * @param entry 元素
     */
    private void insertEntry(int index, Entry<K, V> entry) {
        if (isFull() || index == 0) {
            throw new IllegalStateException(String.format("index: %d, size: %d", index, size));
        }

        if (size >= index) {
            System.arraycopy(elements, index, elements, index + 1, size - index + 1);
            elements[index] = entry;
            size++;
        } else {
            elements[index] = entry;
            size = index;
        }
    }

    /**
     * 移除指定位置的元素
     *
     * @param index 索引
     */
    private void removeEntry(int index) {
        if (isEmpty() || index == 0) {
            throw new IllegalStateException(String.format("index: %d, size: %d", index, size));
        }

        if (size > index) {
            System.arraycopy(elements, index + 1, elements, index, size - index);
        }
        elements[size] = null;
        size--;
    }

    /**
     * 设置指定元素
     *
     * @param index 索引
     * @param entry 元素
     */
    private void setEntry(int index, Entry<K, V> entry) {
        if (index == 0) {
            throw new IllegalStateException(String.format("index: %d, size: %d", index, size));
        }

        // 保留子节点，只替换元素的 key-value
        Entry<K, V> oldEntry = getEntry(index);
        elements[index] = entry;
        entry.pointer = oldEntry.pointer;
    }

    @Override
    public String toString() {
        String[] s = new String[size];
        for (int i = 1; i <= size; i++) {
            s[i - 1] = elements[i].toString();
        }
        return "[" + String.join(", ", s) + "]";
    }

    /**
     * 单个元素
     */
    static class Entry<K extends Comparable<K>, V> {
        /**
         * key
         */
        K key;
        /**
         * value
         */
        V value;
        /**
         * 右子节点指针，即大于 key 的子树
         */
        BTNode<K, V> pointer;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            pointer = null;
        }

        @Override
        public String toString() {
            return "{" + key + " : " + value + "}";
        }
    }

}
