# LFU算法

首先，LFU算法的全称为Least Frequently Used，同样作为一种淘汰算法，其淘汰策略是每次淘汰使用次数最少的数据，而且当使用次数最少的数据有多个时，淘汰最旧的那个数据。

## 算法描述
要求写一个类，接受一个 `capacity` 参数，实现 `get` 和 `put` 方法：
```Java
class LFUCache {
    // 构造一个容量为capacity的缓存
    public LFUCache(int capacity) { }
    // 在缓存中查询key
    public int get(int key) { }
    // 将 key 和 val 存入缓存
    public void put(int key, int val) { }
}
```

`get` 方法传入一个key值，会去缓存中查询键key，如果存在则会返回对应的val，同时访问次数加一；如果缓存中不存在键key，则返回-1。

`put` 方法接收一个key和val对，如果key已经存在，则将它的值修改为val，同时访问次数加一；如果key不存在，则插入新的KV对，并且其对应的访问次数为1.

在调用 `put` 方法时，需要有一个判断缓存是否已满的过程，如果缓存不满，则按照上述的流程；如果缓存满了，则需要找到访问次数最少且最旧的那个Key，将其从缓存中删除后，再按照上述流程走。

## 思路分析
先从上述的算法描述中，剥离出几个显而易见的事实：
1. 调用get(key)方法时，需要返回该key对应的val。
2. 无论是调用get还是put访问某个key，该key对应的访问次数freq都要加一。
3. 在容量满了之后，我们需要将freq最小的key删除，如果最小的freq对应多个key，则删除最旧的那一个。

>我们需要在O(1)的时间复杂度内解决上述这些需求

使用的数据结构如下：
1. 使用一个HashMap存储key到val的映射，这样可以快速计算get(key)
2. 使用一个HashMap存储key到freq的映射，这样可以快速操作key对应的freq
3. 首先肯定需要freq到key的映射，用来找到freq最小的key；为了在0(1)的时间复杂度内找到最小的freq，肯定不能遍历，因此需要一个变量minFreq来记录当前最小的freq；可能有多个key对应一个freq，因此freq和key应该是一对多的关系，即一个freq对应一个key列表；希望freq对应的key列表是存在时序的，这样便于查找并删除最旧的那个；希望能够快速删除key列表中的任何一个key，因此访问频次为freq的key被访问，那么他应该从当前freq对应的key列表中删除，添加到freq+q对应的key列表中。

为了解决第3点，使用`LinkedHashSet`数据结构。
该数据结构是链表和哈希集合的结合体。链表不能快速访问链表节点，但是插入的元素有时序；哈希集合中的元素无序，但是可以对元素进行快速的访问和删除。

因此，构建出LFU缓存的基本数据结构框架：
```Java
class LFUCache {
    // key到val的映射
    HashMap<Integer, Integer> keyToVal;
    // key到freq的映射
    HashMap<Integer, Integer> keyToFreq;
    // freq到key列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录当前最小的freq
    int minFreq;
    // 记录LFU缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) { }

    public void put(int key, int val) { }
}
```

## 代码框架
LFU的代码逻辑不难理解，但是因为要维护三个映射表，很容易出错，因此：
1. 应该自顶向下，先写清楚主函数的逻辑框架，然后再一步步实现细节
2. 搞清楚映射关系，不要遗漏
3. 复杂的逻辑流程，先画图再代码实现

下面分别实现 `get` 和 `put` 方法。

### get
```Java
public int get(int key) {
    // 若不存在，则返回-1
    if(!keyToVal.containsKey(key)) {
        return -1;
    }

    // 增加key对应的freq
    increaseFreq(key);

    // 返回val
    return keyToVal.get(key);
}
```

### put

```Java
public void put(int key, int val) {
    if(this.cap <= 0) return ;

    // 若key已存在，修改对应的val即可
    if(keyToVal.containsKey(key)){
        keyToVal.put(key, val);
        // key对应的freq加一
        increaseFreq(key);
        return ;
    }

    // key不存在，需要插入，插入前容量已满的话需要淘汰掉一个
    if(this.cap <= keyToVal.size()) {
        removeMinFreqKey();
    }

    // 执行插入逻辑
    // 插入KV表
    keyToVal.put(key, val);
    // 插入KF表
    keyToFreq.put(key, 1);
    // 插入FK表
    freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
    freqToKeys.get(1).add(key);
    // 插入新的key后，最小freq肯定是1
    this.minFreq = 1;
}
```

## 核心逻辑

上面实现了LFU算法的代码框架，其中有两个核心逻辑需要我们具体实现。
```Java
private void increaseFreq(int key) {
    int freq = keyToFreq.get(key);
    // 更新KF表
    keyToFreq.put(key, freq + 1);
    // 更新FK表
    freqToKeys.get(freq).remove(key);
    freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
    freqToKeys.get(freq + 1).add(key);

    //如果freq对应的列表空了，则移除
    if(freqToKeys.get(freq).isEmpty()){
        freqToKeys.remove(freq);
        // 如果这个freq正好是minFreq，则更新minFreq
        if(freq == this.minFreq) {
            this.minFreq ++;
        }
    }
}
```

```Java
private void removeMinFreq() {
    // 先获取freq最小的key列表
    LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
    // 其中最先插入的那个key就是该被淘汰的key
    int deletedKey = keyList.iterator().next();
    // 更新FK表
    keyList.remove(deletedKey);
    if(keyList.isEmpty()) {
        freqToKeys.remove(this.minFreq);
    }
    // 更新KV表
    keyToVal.remove(deletedKey);
    // 更新KF表
    keyToFreq.remove(deletedKey);

}
```