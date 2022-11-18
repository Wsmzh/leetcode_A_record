# 二叉堆

二叉堆（Binary Heap）

主要操作只有两个：`sink`下沉、`swim`上浮

主要应用也有两个：
+ 排序方法 —— 堆排序
+ 数据结构 —— 优先级队列

二叉堆是一种特殊的二叉树（完全二叉树），存放在数组里，使用数组索引作为指针

```Java
// 父节点的索引
int parent(int root) {
    return root / 2;
}
// 左孩子的索引
int left(int root) {
    return root * 2;
}
// 右孩子的索引
int right(int root) {
    return root * 2 + 1;
}
```

二叉堆又分为：
+ 大顶堆：每个节点都大于等于它的两个子节点
+ 小顶堆：每个节点都小于等于它的两个子节点


## 优先级队列

优先级队列（Priority Queue）

当你插入或删除元素的时候，元素会自动排序，这底层的原理就是二叉堆的操作

优先级队列主要有两个API：
+ `insert` 插入一个元素
+ `delMax` 删除最大元素（如果底层用小顶堆，则就是 `delMin`）

为什么需要有下沉和上浮两个操作，因为在插入和删除元素时，难免会破坏堆的性质，这就需要通过这两个操作恢复堆的性质

对于最大堆来说：
+ 如果某个节点A比他的字节点（中的一个）小，那么A就不配做父节点，应该下去，下面那个更大的节点上来做父节点。
+ 如果某个节点B比他的父节点大，那么B就不应该做字节点，应该把父节点换下来，自己去做父节点，这就是上浮。

### 具体实现

插入和删除的时间复杂度都为O(log K)，K为当前二叉堆中的元素总数

二叉堆就是一种完全二叉树，所以适合存放在数组中

```Java
public class MaxPQ <Key extends Comparable<Key>> {

    // 存放元素的数组
    private Key[] pq;

    // 当前pq中元素的个数
    private int N = 0;

    public MaxPQ(int cap) {
        // 索引0不用，所以多分配一个空间
        pq = new Key[cap + 1];
    } 

    // 返回当前队列中最大的元素
    public Key max() {
        return pq[1];
    }

    // 插入元素
    public void insert(Key e) {
        // 把要插入的元素放到堆底的最后，让其上浮
        N ++;
        pq[N] = e;
        swim(N);
    }

    // 删除并返回队列中最大的元素
    public Key delMax() {
        Key max = pq[1];
        // 换到最后
        swap(1, N);
        // 删除
        pq[N] = null;
        N --;
        // 将新换上来的元素下沉到正确位置
        sink(1);
        // 返回最大元素
        return max;
    }

    // 上浮第k个元素，以维护最大堆性质
    private void swim(int k) {
        // 如果浮到堆顶，就不能再浮了
        while(k > 1 && less(parent(k), k)){
            // 如果第k个元素比上层大，则换上去
            swap(parent(k), k);
            // 换完一次之后还要继续检查是否需要上浮
            k = parent(k);
        }
    }

    // 下沉第k个元素，以维护最大堆性质
    private void sink(int k) {
        // 如果沉到堆底了，就不能再沉了
        while(left(k) <= N) {
            // 先假设左边节点比较大
            int bigger = left(k);
            // 判断一下左边节点和右边节点（若存在的话）谁大
            if(right(k) <= N && less(bigger, right(k))){
                bigger = right(k);
            }
            // 如果比两个子节点都大，就不用下沉了
            if(less(bigger, k)) {
                break;
            }
            // 否则跟较大的子节点交换
            swap(k, bigger);
            // 看看是不是需要继续下沉
            k = bigger;
        }

    }

    // 交换数组中的两个元素
    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // pq[i]是否比pq[j]小
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 父节点的索引
    private int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    private int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    private int right(int root) {
        return root * 2 + 1;
    }

}
```

