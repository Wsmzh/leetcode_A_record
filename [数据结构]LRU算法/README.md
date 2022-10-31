# LRU算法

LRU算法是一种缓存淘汰策略，全称是Least Recently Used，是一种常见的页面置换算法，选择最近最久未使用的页面予以淘汰。

## LRU算法设计

LRU算法作为一种缓存淘汰策略，在设计时需要关注一下几点：
1. 需要一个变量 `capacity` 来指定缓存区域的大小
2. 需要实现将页面调入缓存的API `put(key, value)`
3. 需要实现根据 `key` 获取页面内容的API `get(key)`
4. 上述 `get` 和 `put` 方法的时间复杂度控制为 O(1)

为了实现上述的关注点，我们可以推理出使用LRU算法实现的Cache数据结构需要满足：
1. cache中的元素必须有序，以区分最近使用的和久未使用的数据，容量满了之后要删除最久未使用的那个元素
2. 我们要在cache中快速找到某个key是否已经存在，并得到相应的val
3. 每次访问cache中的某个key，需要将该元素变成最近使用的，因此cache需要支持在任意位置快速插入和删除元素

>哈希表查找快，但是元素没有顺序关系；链表有顺序关系，插入和删除元素也快，但是不支持快速查找。因此，结合这两个数据结构的特点，哈希链表这种数据结构能够满足上述要求。

LRU缓存算法的核心数据结构就是哈希链表，双向链表和哈希表的结合体。
![哈希链表](https://labuladong.github.io/algo/images/LRU%e7%ae%97%e6%b3%95/4.jpg)

## LRU代码实现

很多编程语言都有内置的哈希链表或者类似LRU功能的库函数，但这里自己实现。

首先，先将双链表的节点类写出来，为了简化，key和val都认为是int类型。
```Java
class Node {
    public int key, val;
    public Node prev, next;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
```

然后基于Node节点类型，构建双链表，并且实现LRU算法必须的几个操作。
```Java
class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;

    public DoubleList(){
        // 初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点x，时间O(1)
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size ++;
    }

    // 删除链表中的x节点
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size --;
    }

    // 删除链表中的第一个节点，并返回该节点
    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回链表的长度
    public int size() {
        return size;
    }
}
```

有了双向链表的实现后，我们在LRU算法中将双向链表和哈希表结合起来。
```Java
class LRUCache {
    // 哈希表 key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // 链表
    private DoubleList cache;
    // 最大容量
    private int cap;

    // 构造函数
    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // 将某个key提升为最近使用的
    private void makeRecently(int key){
        Node x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val){
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在map中添加映射
        map.put(key, x);
    }

    // 删除某个key
    private void deleteKey(int key){
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从map中删除
        map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently(){
        // 链表头部的第一个元素就是最久未使用的
        Node deletedNode = cache.removeFirst();
        // 获取key后从map中删除
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    // ****************************************************
    // 最后实现get和put方法
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node x = map.get(key);
        // 将该数据提升为最近使用的
        makeRecently(key);
        return x.val;
    }
    public void put(int key, int val){
        // 若key已存在，则修改对应key的val，并将其提升为最近使用
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, val);
            return ;
        }

        // 若缓存满了，则先删除
        if(cache.size() >= this.cap){
            removeLeastRecently();
        }

        // 添加为最近使用的元素
        addRecently(key, val);
    }
}
```

> 在不做操作抽象时，只要有DoubleList和Map两个数据结构，也可以实现 `put` 和 `get` 这两个方法。

## 使用Java中的内置类型LinkedHashMap来实现

```Java
class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    
    public LRUCache(int capacity){
        this.cap = capacity;
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val){
        if(cache.containsKey(key)){
            cache.put(key, val);
            makeRecently(key);
            return ;
        }

        if(cache.size() >= this.cap){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, val);
    }

    private void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
```
