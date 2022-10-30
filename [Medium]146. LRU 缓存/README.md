# 146. LRU 缓存

## Java

```Java
class LRUCache {

    // LRU的容量
    int cap;
    // 哈希链表
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        // 如果关键字key不存在于缓存中，直接返回-1
        if(!cache.containsKey(key)){
            return -1;
        }
        // 将key变成最近使用
        makeRecently(key);
        // 返回key对应的val
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        // 如果缓存中已经存在关键字key
        if(cache.containsKey(key)){
            // 修改key的值（将更新操作合并进来）
            cache.put(key, value);
            // 将key变成最近使用
            makeRecently(key);
            return ;
        }

        // 如果缓存的大小超过了约束
        if(cache.size() >= this.cap){
            // 链表头部就是最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            // 删除掉这个最久未使用的key
            cache.remove(oldestKey);
        }

        // 将新的key和value添加到链表尾部
        cache.put(key, value);
    }

    // 自定义函数，使关键字key对应的节点更新到链表尾部（越靠近尾部代表越近使用过）
    private void makeRecently(int key){
        int val = cache.get(key);
        // 同样采用先删后添加的方式
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```