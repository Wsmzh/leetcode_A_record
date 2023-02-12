# 剑指 Offer 49. 丑数

## Java

```Java
class Solution {
    public int nthUglyNumber(int n) {
        // 可以理解为指向3个有序链表头节点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为3个有序链表的头节点的值（第一个丑数都是1）
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        // 这个链表中的值 * 2 、 * 3 、 * 5都是丑数
        // 可以理解为三个链表
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并3个有序链表
        while(p <= n) {
            // 取3个链表的最小节点
            int min = Math.min(Math.min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min;
            p ++;
            
            // 前进对应有序链表的指针
            if(min == product2) {
                product2 = 2 * ugly[p2];
                p2 ++;
            }
            if(min == product3) {
                product3 = 3 * ugly[p3];
                p3 ++;
            }
            if(min == product5) {
                product5 = 5 * ugly[p5];
                p5 ++;
            }
        }
        return ugly[n];
    }
}
```