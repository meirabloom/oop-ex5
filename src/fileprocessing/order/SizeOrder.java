package fileprocessing.order;

import java.io.File;
import java.util.Comparator;

public class SizeOrder extends Order {

    private static final int CONVERT_TO_KB = 1024;

    public SizeOrder(){
        orderBy = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                double o1Size = o1.length() / CONVERT_TO_KB ;
                double o2Size = o2.length() / CONVERT_TO_KB;
                return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
                }
            };
        }
    }

