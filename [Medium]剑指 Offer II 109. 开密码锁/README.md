# 剑指 Offer II 109. 开密码锁

## Java

```Java
class Solution {
    public int openLock(String[] deadends, String target) {
        // 定义一个Set，记录所有的deadends
        Set<String> deads = new HashSet<>();
        for(String dead : deadends) {
            deads.add(dead);
        }
        // 定义一个包含所有访问过的密码组合，避免重复
        Set<String> used = new HashSet<>();
        // 定义一个队列
        Queue<String> q = new LinkedList<>();
        // 定义一个记录旋转次数
        int step = 0;
        q.offer("0000");
        used.add("0000");

        // BFS
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0 ; i < sz ; i ++) {
                String cur = q.poll();

                // 避开死亡数字
                if(deads.contains(cur)) {
                    continue;
                }

                //找到目标条件直接返回最小旋转次数，不再扩散
                if(cur.equals(target)) {
                    return step;
                }

                // 扩散
                for(int j = 0 ; j < 4 ; j ++) {
                    String up = upOne(cur, j);
                    if(!used.contains(up)) {
                        q.offer(up);
                        used.add(up);
                    }

                    String down = minusOne(cur, j);
                    if(!used.contains(down)) {
                        q.offer(down);
                        used.add(down);
                    }
                }
            }
            // 旋转次数在这里加1
            step ++;
        }
        // 如果前面没有返回，则说明没法解开，返回-1
        return -1;
    }

    String upOne(String str, int j) {
        char[] arr = str.toCharArray();
        if(arr[j] == '9') {
            arr[j] = '0';
        } else {
            arr[j] += 1;
        }
        return new String(arr);
    }

    String minusOne(String str, int j) {
        char[] arr = str.toCharArray();
        if(arr[j] == '0') {
            arr[j] = '9';
        } else {
            arr[j] -= 1;
        }
        return new String(arr);
    }
}
```