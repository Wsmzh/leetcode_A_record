# 460. LFU 缓存

## Java

```Java
// 最不经常使用
class LFUCache {
    // 为了get能够在O(1)运行，需维护KV表
    HashMap<Integer, Integer> keyToVal;

    // 在put时，也要更新访问次数，因此为了能够在O(1)运行
    // 需要维护key对应的freq表
    HashMap<Integer, Integer> keyToFreq;

    // 当要移除元素时，需要根据freq得到最小freq的列表，并选择最久未使用的删掉
    // 需要维护freq对应的keys表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    // 缓存的最大容量
    int cap;

    // 当前最小使用次数
    int minFreq;

    

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        // 如果不存在于缓存中，则返回-1
        if(!keyToVal.containsKey(key)) {
            return -1;
        }

        // 先加一次访问次数
        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {

        if (this.cap <= 0) return ;

        // 如果key已存在，则变更
        if(keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            // 同时增加一次访问次数
            increaseFreq(key);
            return ;
        }

        // 不存在时
        
        // 先判断，如果缓存已满
        if(keyToVal.size() >= this.cap){
            // 移除最不经常使用的项
            removeMinFreq();
        }

        // 插入KV对
        keyToVal.put(key, value);
        // 插入kf
        keyToFreq.put(key, 1);

        // 如果使用次数为1 对应的链表中没有节点，则创建
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        this.minFreq = 1;
    }

    // 实现增加访问次数的函数
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // 更新KF表
        keyToFreq.put(key, freq + 1);

        // 更新FK表
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        // 如果freq对应的表空了，则移除
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            // 如果这个freq正好是minfreq，则更新一下
            if(freq == this.minFreq){
                this.minFreq ++;
            }
        }

    }

    // 实现移除最不经常使用的项的函数
    private void removeMinFreq() {
        // 先获取freq最小的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);

        // 链头就是最旧的
        int deleted = keyList.iterator().next();  

        // 更新kv表
        keyToVal.remove(deleted);

        // 更新kf表
        keyToFreq.remove(deleted);
        
        // 更新fk表
        keyList.remove(deleted);
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```