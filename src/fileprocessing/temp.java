package fileprocessing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class temp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(9);
        System.out.println(list);
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
            }
        };
        list.sort(c);
        System.out.println(list);
        System.out.println(list);

    }

}
