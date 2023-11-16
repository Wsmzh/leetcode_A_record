# 986. 区间列表的交集

## Java

```Java
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 使用两个指针分别指向两个列表中的区间
        int i = 0;
        int j = 0;

        List<int[]> list = new ArrayList<>();

        while(i < firstList.length && j < secondList.length) {
            // 先判断不相交的情况
            if(firstList[i][1] < secondList[j][0] || firstList[i][0] > secondList[j][1]) {
                // 判断哪个指针往后移动
                if(firstList[i][1] < secondList[j][0]) {
                    i ++;
                } else if(firstList[i][0] > secondList[j][1]) {
                    j ++;
                }
            } else {
            // 与不相交相反，则为相交
                int left = Math.max(firstList[i][0], secondList[j][0]);
                int right = Math.min(firstList[i][1], secondList[j][1]);
                int[] temp = new int[]{left, right};
                list.add(temp);
                // 判断谁往后移动(根据区间终点判断)
                if(firstList[i][1] <= secondList[j][1]) {
                    i ++;
                } else {
                    j ++;
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for(int p = 0 ; p < list.size() ; p ++) {
            res[p][0] = list.get(p)[0];
            res[p][1] = list.get(p)[1];
        }
        return res;
    }
}
```