# 752. 打开转盘锁

## Java

### 传统 BFS
```Java
class Solution {
    public int openLock(String[] deadends, String target) {
        // 记录死亡数字
        Set<String> deads = new HashSet<>();
        for(String str : deadends) {
            deads.add(str);
        }
        // 记录尝试过的密码组合，避免走回头路
        Set<String> visited = new HashSet<>();
        // BFS所需的队列
        Queue<String> q = new LinkedList<>();
        // 开始状态下密码为0000，所以次数从0开始
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        // BFS
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0 ; i < sz ; i ++) {
                String str = q.poll();
                //判断是否是死亡数字
                if(deads.contains(str)) {
                    continue;
                }
                // 判断是否满足target
                if(str.equals(target)) {
                    // 最短距离在这里返回
                    return step;
                }

                // 将由该字符串延伸出的其余8中组合加入队列
                for(int j = 0 ; j < 4 ; j ++) {
                    String up = plusOne(str, j);
                    if(!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(str, j);
                    if(!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step ++;
        }
        // 前面没返回，则说明不能解锁
        return -1;
    }

    String plusOne(String str, int l) {
        char[] arr = str.toCharArray();
        if(arr[l] == '9') {
            arr[l] = '0';
        } else {
            arr[l] += 1;
        }
        return new String(arr);
    }

    String minusOne(String str, int l) {
        char[] arr = str.toCharArray();
        if(arr[l] == '0') {
            arr[l] = '9';
        } else {
            arr[l] -= 1;
        }
        return new String(arr);
    }
}
```

### 双向BFS
```Java
class Solution {
    public int openLock(String[] deadends, String target) {
        // 记录死亡数字
        Set<String> deads = new HashSet<>();
        for(String str : deadends) {
            deads.add(str);
        }
        // 记录尝试过的密码组合，避免走回头路
        Set<String> visited = new HashSet<>();
        // 双向BFS使用集合来代替队列
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        // 开始状态下密码为0000，所以次数从0开始
        int step = 0;
        q1.add("0000");
        q2.add(target);

        // BFS
        while(!q1.isEmpty() && !q2.isEmpty()) {
            //哈希集合在遍历过程中不能修改，用temp存储扩散结果
            Set<String> temp = new HashSet<>();
            // 小的优化技巧，挑那个小的队列进行扩展
            if(q1.size() > q2.size()) {
                Set<String> t = q1;
                q1 = q2;
                q2 = t;
            }

            // 将q1中的节点进行扩散
            for(String cur : q1) {
                //判断是否是死亡数字
                if(deads.contains(cur)) {
                    continue;
                }
                // 判断是否到达终点
                if(q2.contains(cur)) {
                    return step;
                }
                // 记录已经遍历过该节点
                visited.add(cur);

                // 将由该字符串延伸出的其余8中组合加入队列
                for(int j = 0 ; j < 4 ; j ++) {
                    String up = plusOne(cur, j);
                    if(!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if(!visited.contains(down)) {
                        temp.add(down);
                    }
                }

            }
            
            step ++;
            // 这里交换q1 q2，下一轮相当于遍历q2
            q1 = q2;
            q2 = temp;
        }
        // 前面没返回，则说明不能解锁
        return -1;
    }

    String plusOne(String str, int l) {
        char[] arr = str.toCharArray();
        if(arr[l] == '9') {
            arr[l] = '0';
        } else {
            arr[l] += 1;
        }
        return new String(arr);
    }

    String minusOne(String str, int l) {
        char[] arr = str.toCharArray();
        if(arr[l] == '0') {
            arr[l] = '9';
        } else {
            arr[l] -= 1;
        }
        return new String(arr);
    }
}
```