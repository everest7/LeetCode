package Heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQueueEX {
    public static void main(String[] args) {

        // Set a custom comparator
        Comparator<String> stringLenComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        // Translate the above comparator into lambda expression
        // Natural order ranking

//        Comparator<String> stringLenComparator = (s1, s2) -> {
//            return s1.length() - s2.length();
//        };
        PriorityQueue<String> nameQueue = new PriorityQueue<>(stringLenComparator);


        nameQueue.add("cpp");
        nameQueue.add("java");
        nameQueue.add("angelina");
        nameQueue.add("swift");
        nameQueue.add("xxxx");
        nameQueue.add("sss");
        nameQueue.add("swifaat");
        Iterator<String> itr = nameQueue.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("=======");
//        while (!nameQueue.isEmpty()) {
//            System.out.println(nameQueue.remove());
//        }

//        System.out.println("Head of the queue: " + nameQueue.peek());

    }
}
