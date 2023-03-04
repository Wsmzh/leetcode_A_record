# 56. 合并区间

## Java

[//]: # (支持粘贴图片啦🎉🎉🎉)
[//]: # (保存的笔记可以在 CodeTop 微信小程序中查看)
## 解法1

```Java
class Solution {
    public int[][] merge(int[][] intervals) {
        // 判空
        if(intervals.length == 0) {
            return new int[0][0];
        }

        // 排序
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        // 记录结果
        List<int[]> res = new ArrayList<>();

        // 指向当前的区间
        int[] cur = intervals[0];

        // 遍历所有的区间
        for(int i = 1 ; i < intervals.length ; i ++) {
            // 如果相交则扩大区间
            if(cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 如果不相交，则把当前区间记录到结果集合中，并使用新的当前区间
                res.add(cur);
                cur = intervals[i];
            }
        }

        // 最后有一个区间需要添加进去，不能忘掉
        res.add(cur);

        return res.toArray(new int[res.size()][2]);
    }
}
```


## 解法2（自写，有冗余）

```Java
class Solution {
    public int[][] merge(int[][] intervals) {
        // 首先对区间进行起点升序，终点降序的排序
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return b[0] - a[0];
            }
            return a[0] - b[0];
        });

        // 左右区间
        int left = intervals[0][0];
        int right = intervals[0][1];

        // 存放结果
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1 ; i < intervals.length ; i ++) {
            // 完全覆盖的话则跳过
            if(intervals[i][0] >= left && intervals[i][1] <= right) {
                continue;
            }
            // 相交，则扩大区间范围
            if(right >= intervals[i][0] && right <= intervals[i][1]) {
                right = intervals[i][1];
            }
            // 完全不相交，新增一个记录区间，更新新的左右边界
            if(right < intervals[i][0]) {
                map.put(left, right);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        
        map.put(left, right);

        int[][] res = new int[map.size()][2];
        int i = 0;
        for(int key : map.keySet()) {
            res[i][0] = key;
            res[i][1] = map.get(key);
            i ++;
        }
        return res;
    }
}
```