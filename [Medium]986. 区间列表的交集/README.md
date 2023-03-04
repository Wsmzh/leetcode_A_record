# 986. 区间列表的交集

## Java

```Java
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 两个列表的长度
        int length1 = firstList.length;
        int length2 = secondList.length;

        // 判空
        if(length1 == 0 || length2 == 0) {
            return new int[0][0];
        }

        // 存放结果
        List<int[]> res = new ArrayList<>();

        // 两个指针，分别指向两个列表
        int p1 = 0, p2 = 0;
        
        while(p1 < length1 && p2 < length2) {
            // 无交集
            if(firstList[p1][1] < secondList[p2][0]) {
                p1 ++;
                continue;
            }
            if(secondList[p2][1] < firstList[p1][0]) {
                p2 ++;
                continue;
            }

            // 存在交集
            if(firstList[p1][1] >= secondList[p2][0] && firstList[p1][0] <= secondList[p2][1]) {
                int[] cur = new int[2];
                cur[0] = Math.max(firstList[p1][0], secondList[p2][0]);
                cur[1] = Math.min(firstList[p1][1], secondList[p2][1]);
                res.add(cur);
            }

            // 指针前进
            if(firstList[p1][1] <= secondList[p2][1]) {
                p1 ++;
            } else {
                p2 ++;
            }
            
        }

        return res.toArray(new int[res.size()][2]);
    }
}
```