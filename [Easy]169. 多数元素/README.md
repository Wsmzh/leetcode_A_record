# 169. 多数元素

## Java

### 方法一

```Java
class Solution {
    public int majorityElement(int[] nums) {
        int e = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Integer key : map.keySet()) {
            if(map.get(key) > e) {
                return key;
            }
        }
        return 0;
    }
}
```

### 方法二

利用正负电子的特性。
可以把最终的众数看作是正电子，把其余的所有数看作是负电子，这样在这个正负电子混合的过程中，尽管整体的正负特性会有变化，但是最终会为正。
题目中指出了众数的个数是过半的。

```Java
class Solution {
    public int majorityElement(int[] nums) {
        int target = 0;

        int count = 0;

        for(int i : nums) {
            if(count == 0) {
                target = i;
                count ++;
            } else if (i == target) {
                count ++ ;
            } else {
                count --;
            }
        }

        return target;
    }
}
```