# 剑指 Offer 40. 最小的k个数

## Java

```Java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 特判
        if(k == 0) {
            return new int[0];
        }

        // 定义一个k+1大小的数组
        int[] pq = new int[k + 1];

        // 遍历给的数组
        for(int i = 0 ; i < arr.length ; i ++) {
            // 如果大于等于k，则需要先判断是否要删
            if(i > k - 1) {
                if(arr[i] < pq[1]) {
                    pq[1] = arr[i];
                    // 下沉
                    int cur = 1;
                    while(2*cur <= k) {
                        int bigger = 2*cur;
                        if(2*cur + 1 <= k && pq[2*cur + 1] > pq[bigger]) {
                            bigger = 2*cur + 1;
                        }
                        if(pq[cur] > pq[bigger]) {
                            break;
                        }
                        int temp = pq[cur];
                        pq[cur] = pq[bigger];
                        pq[bigger] = temp;
                        cur = bigger;
                    }

                } else {
                    continue ;
                }
            }
            // 如果小于k，则插入pq上浮
            else {
                pq[i + 1] = arr[i];
                // 上浮
                int cur = i + 1;
                while(cur > 1 && pq[cur/2] < pq[cur]) {
                    int temp = pq[cur];
                    pq[cur] = pq[cur/2];
                    pq[cur/2] = temp;
                    cur = cur/2;
                }
            }
        }

        // 返回部分数组
        return Arrays.copyOfRange(pq, 1, k + 1);

    }
}
```