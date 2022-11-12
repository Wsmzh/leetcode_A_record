# Trie树、前缀树、字典树

## Java

Trie树又叫字典树、前缀树、单词查找树，是一种二叉树衍生出来的高级数据结构，主要应用场景是处理字符串前缀相关的操作。

> 关于Map和Set，是两个抽象数据结构（接口），Map存储一个键值对集合，其中键不重复，Set存储一个不重复的元素集合。

> 常见的Map和Set的底层实现原理有哈希表和二叉搜索树两种，比如Java的HashMap/HashSet和C++的unordered_map/unordered_set底层就使用哈希表实现，而Java的TreeMap/TreeSet和C++的map/set底层使用红黑树这种自平衡BST实现的。

而本文实现的TrieSet/TrieMap底层则用Trie树这种结构来实现。

> 本质上Set可以视为一种特殊的Map，Set其实就是Map中的键。

## Trie树原理

Trie树本质上就是一颗从二叉树衍生出来的多叉树。

```Java
class TrieNode<V> {
    V val = null;
    TrieNode<V>[] children = new TrieNode[256];
}
```

children数组存储指向子节点的指针。数组的索引是有意义的，代表键中的一个字符。

形象理解就是，Trie树用树枝存储字符串（键），用节点存储字符串（键）对应的数据（值）。

## TrieMap/TrieSet API及实现

```Java
// 底层用Trie树实现的键值映射
// 键为String类型，值为类型V
class TrieMap<V> {
    // ASCII 码个数
    private static final int R = 256;

    // 当前存在map中的键值对个数
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

    // Trie树的根节点
    private TrieNode<V> root = null;

    // 工具函数
    // 从节点node开始搜索key，如果存在返回对应节点，否则返回null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        // 从节点node开始搜索key
        for(int i = 0 ; i < key.length() ; i ++) {
            if (p == null){
                // 无法向下搜索
                return null;
            }
            // 向下搜索
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }

    // 在Map中添加
    public void put(String key, V val) {
        if(!containsKey(key)) {
            size ++;
        }
        // 需要一个额外的辅助函数，并接受其返回值
        root = put(root, key, val, 0);
    }
    // 定义：向以node为根的Trie树中插入key，返回插入完成后的根节点
    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if(node == null) {
            // 如果树枝不存在，新建
            node = new TrieNode<>();
        }
        if(i == key.length()) {
            // key的路径已插入完成，将值val存入节点
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        // 递归插入子节点，并接收返回值
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }

    // 在Map中删除
    public void remove(String key) {
        if(!containsKey(key)) {
            return ;
        }
        // 递归修改数据结构要接收函数的返回值
        root = remove(root, key, 0);
        size --;
    }
    // 定义：在以node为根的Trie树中删除key，然后返回删除后的根节点
    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if(node == null) {
            return null;
        }
        if(i == key.length()) {
            node.val = null;
        } else {
            char c = key.charAt(i);
            node.children[c] = remove(node.children[c], key, i + 1);
        }
        // 后续位置
        if(node.val != null){
            return node;
        }
        // 检查该TireNode是否还有后缀
        for(int c = 0 ; c < R ; c ++){
            if(node.children[c] != null) {
                return node;
            }
        }
        // 即没有存储val，也没有后缀树枝，则该节点需要被清理
        return null;
    }

    // 搜索key对应的值，不存在则返回null
    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if(x == null || x.val == null){
            return null;
        }
        return x.val;
    }

    // 判断key是否存在于Map中
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    // 在map的所有键中搜索query的最短前缀
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        // 从节点node开始搜索key
        for(int i = 0 ; i < query.length() ; i ++) {
            if(p == null) {
                // 无法向下搜索
                return "";
            }

            if(p.val != null) {
                // 找到一个键是query的前缀
                return query.substring(0, i);
            }

            // 向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }

        if(p != null && p.val != null) {
            // 如果query本身就是一个键
            return query;
        }

        return "";
    }

    // 在map的所有键中搜索query的最长前缀
    public String longestPrefixOf(String query) {
        TrieNode<V> p = root;

        // 记录前缀的最大长度
        int max_len = 0;

        for(int i = 0 ; i < query.length() ; i ++) {
            if(p == null) {
                // 无法向下搜索
                break;
            }

            if(p.val != null) {
                // 找到一个键是query的前缀，更新前缀的最大长度
                max_len = i;
            }

            // 向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }

        if(p != null && p.val != null) {
            // 如果query本身就是一个键
            return query;
        }

        return query.substring(0, max_len);
    }

    // 搜索所有前缀为prefix的键
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new LinkedList<>();
        // 找到匹配prefix在Trie树中的那个节点
        TrieNode<V> x = getNode(root, prefix);
        if(x == null) {
            return res;
        }
        
        // DFS编译以x为根的这颗Trie树
        traverse(x, new StringBuilder(prefix), res);
        return res;
    }
    // 遍历以node节点为根的Trie树，找到所有键
    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if(node == null) {
            // 到达Trie树底部叶子节点
            return ;
        }

        if(node.val != null) {
            // 找到一个key，添加到结果列表中
            res.add(path.toString());
        }

        // 回溯算法遍历框架
        for(char c = 0; c < R ; c ++) {
            // 做选择
            path.append(c);
            traverse(node.children[c], path, res);
            // 撤销选择
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 判断是否存在前缀为prefix的键
    public boolean hasKeyWithPrefix(String prefix) {
        // 只要能找到prefix对应的节点，就是存在前缀
        return getNode(root, prefix) != null;
    }

    // 通配符 . 匹配任意字符，搜索所有匹配的键
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }
    // 遍历函数，尝试在以node为根的Trie树中，匹配pattern[i..]
    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
        if(node == null) {
            // 树枝不存在，即匹配失败
            return ;
        }

        if (i == pattern.length()) {
            // pattern匹配完成
            if(node.val != null) {
                // 如果这个节点存储这val，则找到一个匹配的键
                res.add(path.toString());
            }
            return ;
        }
        char c = pattern.charAt(i);
        if(c == '.') {
            // pattern[i] 是通配符，可以变化成任意字符
            for(char j = 0 ; j < R ; j ++){
                path.append(j);
                traverse(node.children[j], path, pattern, i + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            // pattern[i]是普通字符c
            path.append(c);
            traverse(node.children[c], path, pattern, i + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 通配符 . 匹配任意字符，判断是否存在匹配的键
    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }
    private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
        if(node == null) {
            return false;
        }
        if(i == pattern.length()) {
            return node.val != null;
        }
        char c = pattern.charAt(i);
        // 没有遇到通配符
        if(c != '.') {
            return hasKeyWithPattern(node.children[c], pattern, i + 1);
        }
        // 遇到通配符
        for(int j = 0 ; j < R ; j ++) {
            if(hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                return true;
            }
        }

        // 都没有匹配
        return false;
    }

    // 返回map中键值对的数量
    public int size() {
        return size;
    }

}
```