
import java.util.*;

class MedianFinder {

    // Max-heap for the smaller half
    PriorityQueue<Integer> small =
        new PriorityQueue<>(Collections.reverseOrder());

    // Min-heap for the larger half
    PriorityQueue<Integer> large =
        new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());

        // Keep small equal in size to large, or one element larger
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }

        return ((double) small.peek() + large.peek()) / 2.0;
    }
}
