package collectionsAndMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CollectionsTest {
    public static void main(String[] args) {
        // compare() o1排在o2前面，则返回正数
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


    }
}
