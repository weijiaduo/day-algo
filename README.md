# jode-day

一日复一日，明日何其多。

> https://weijiaduo.github.io/

# 一、数据结构和算法

## 1.1 数据结构

### 链表

- [单向链表](./algorithm/src/main/java/com/wjd/structure/list/SingleList.java)
- [双向链表](./algorithm/src/main/java/com/wjd/structure/list/DoubleList.java)
- [LRU 缓存](./algorithm/src/main/java/com/wjd/structure/list/LRUCache.java)

### 队列

- [顺序队列](./algorithm/src/main/java/com/wjd/structure/queue/ArrayQueue.java)
- [链式队列](./algorithm/src/main/java/com/wjd/structure/queue/ListQueue.java)
- [循环队列](./algorithm/src/main/java/com/wjd/structure/queue/CircularQueue.java)
- [循环双端队列](./algorithm/src/main/java/com/wjd/structure/queue/CircularDeque.java)

### 栈

- [顺序栈](./algorithm/src/main/java/com/wjd/structure/stack/ArrayStack.java)
- [链式栈](./algorithm/src/main/java/com/wjd/structure/stack/ListStack.java)

### 堆

- [堆](./algorithm/src/main/java/com/wjd/structure/tree/heap/HeapImpl.java)
- [索引堆](./algorithm/src/main/java/com/wjd/structure/tree/heap/IndexHeapImpl.java)
- [左倾堆]
- [斜堆]
- [二项堆]
- [斐波那契堆]

### 二叉搜索树

- [BST 二叉搜索树](./algorithm/src/main/java/com/wjd/structure/tree/bst/BSTreeImpl.java)
- [AVL 平衡二叉树](./algorithm/src/main/java/com/wjd/structure/tree/avl/AVLTreeImpl.java)
- [双偏向红黑树](./algorithm/src/main/java/com/wjd/structure/tree/redblack/BLRBTree.java)
- [左偏向红黑树](./algorithm/src/main/java/com/wjd/structure/tree/redblack/LLRBTree.java)
- [B-树](./algorithm/src/main/java/com/wjd/structure/tree/btree/BTreeImpl.java)
- [B+树](./algorithm/src/main/java/com/wjd/structure/tree/bplus/BPTreeImpl.java)

### 高级树

- [哈夫曼树](./algorithm/src/main/java/com/wjd/structure/tree/huffman/HuffmanTreeImpl.java)
- [并查集-数组](./algorithm/src/main/java/com/wjd/structure/tree/ufs/ArrayUnionFind.java)
- [并查集-映射](./algorithm/src/main/java/com/wjd/structure/tree/ufs/MapUnionFind.java)
- [树状数组（二叉索引树）](./algorithm/src/main/java/com/wjd/structure/tree/binaryindex/BinaryIndexTree.java)
- [线段树-数组](./algorithm/src/main/java/com/wjd/structure/tree/segment/ArraySegmentTree.java)
- [线段树-链表](./algorithm/src/main/java/com/wjd/structure/tree/segment/LinkSegmentTree.java)
- [字典树-字母](./algorithm/src/main/java/com/wjd/structure/tree/trie/LetterTrie.java)
- [字典树-字符](./algorithm/src/main/java/com/wjd/structure/tree/trie/CharacterTrie.java)

### 散列表

- [散列表-开放寻址法](./algorithm/src/main/java/com/wjd/structure/hashtable/LinkedHashTable.java)
- [散列表-拉链法](./algorithm/src/main/java/com/wjd/structure/hashtable/LinkedHashTable.java)

### 跳表

- [整数跳表-数组](./algorithm/src/main/java/com/wjd/structure/skiplist/SimpleSkipList.java)
- [跳表-数组](./algorithm/src/main/java/com/wjd/structure/skiplist/ArraySkipList.java)
- [跳表-链表](./algorithm/src/main/java/com/wjd/structure/skiplist/LinkedSkipList.java)

## 1.2 算法

### 数组

#### 排序

- [冒泡排序](./algorithm/src/main/java/com/wjd/algorithm/sort/BubbleSort.java)
- [选择排序](./algorithm/src/main/java/com/wjd/algorithm/sort/SelectSort.java)
- [插入排序](./algorithm/src/main/java/com/wjd/algorithm/sort/InsertSort.java)
- [希尔排序](./algorithm/src/main/java/com/wjd/algorithm/sort/ShellSort.java)
- [归并排序](./algorithm/src/main/java/com/wjd/algorithm/sort/MergeSort.java)
- [快速排序](./algorithm/src/main/java/com/wjd/algorithm/sort/QuickSort.java)
- [堆排序](./algorithm/src/main/java/com/wjd/algorithm/sort/HeapSort.java)
- [桶排序](./algorithm/src/main/java/com/wjd/algorithm/sort/BucketSort.java)
- [计数排序](./algorithm/src/main/java/com/wjd/algorithm/sort/CountSort.java)
- [基数排序](./algorithm/src/main/java/com/wjd/algorithm/sort/RadixSort.java)

#### 二分法

- [第一个等于](./algorithm/src/main/java/com/wjd/algorithm/binary/FirstEqualSearch.java)
- [第一个大于等于](./algorithm/src/main/java/com/wjd/algorithm/binary/FirstNotLessThanSearch.java)
- [最后一个等于](./algorithm/src/main/java/com/wjd/algorithm/binary/LastEqualSearch.java)
- [最后一个小于等于](./algorithm/src/main/java/com/wjd/algorithm/binary/LastNotGreatThanSearch.java)

### 树

#### 二叉树构建

- [层序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/build/LevelTreeBuilder.java)
- [中序+后序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/build/InAndPostTreeBuilder.java)
- [中序+前序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/build/PreAndInTreeBuilder.java)
- [前序线索树构建](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/build/PreorderThreadBuilder.java)
- [中序线索树构建](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/build/InorderThreadBuilder.java)
- [后序线索树构建](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/build/PostorderThreadBuilder.java)

#### 二叉树遍历

- [构建层序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/BuildLevelTraverse.java)
- [简单层序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/SimpleLevelTraverse.java)
- [前序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/PreorderTraverse.java)
- [中序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/InorderTraverse.java)
- [后序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/PostorderTraverse.java)
- [Z 形遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/PostorderTraverse.java)

### 图

#### 图的遍历

- [广度优先搜索（BFS）]
- [深度优先搜索（DFS）]
- [拓扑排序]

#### 最小生成树（MST）

- [Prim 算法]
- [Kruskal 算法]

#### 最短路径

- [Dijkstra 算法]
- [Floyd 算法]

### 字符串

#### 字符串匹配

- [BF 算法]
- [RK 算法]
- [BM 算法]
- [KMP 算法]
- [AC 自动机]
