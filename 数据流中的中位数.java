import java.util.*;

public class 数据流中的中位数 {
    class B {
        // 创建两个优先级队列保存偏大和偏小的数据
        public Queue<Integer> queue1;
        public Queue<Integer> queue2;
        public B() {
            queue1 = new PriorityQueue<>();  // 小顶堆  用来保存中间较大数字 3 4 5
            queue2 = new PriorityQueue<>((x,y)->(y-x));  // 大顶堆  用来保存中间较小数字 2 1
        }
        // 假设queue1中有 {2， 4}  queue2中有 {3, 1}
        // 拿到一个数字比如5，先放在queue2中排序，5会在堆顶，再将5弹出给queue1，5会在堆底，这样两个堆顶还是中间数
        public void addNum(int num) {
            if (queue1.size() == queue2.size()) {
                queue2.offer(num);
                queue1.offer(queue2.poll());
            } else {
                queue1.offer(num);
                queue2.offer(queue1.poll());
            }
        }
        public double findMedian() {
            double res;
            if (queue1.size() == queue2.size()) {
                res = (queue1.peek()+queue2.peek()) / 2.0;
            } else {
                res = queue1.peek();
            }
            return res;
        }
    }
    class A {
        public List<Integer> list;
        public A() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
            Collections.sort(list);
        }

        public double findMedian() {
            double res = 0;
            if (list.size()%2 == 1) {
                res = list.get(list.size()/2) / 1.0;
            } else {
                res = (list.get(list.size()/2)+list.get(list.size()/2-1))/2.0;
            }
            return res;
        }
    }

}
