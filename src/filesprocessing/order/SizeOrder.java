package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

public class SizeOrder extends Order {

    private static final int CONVERT_TO_KB = 1024;

    public SizeOrder(boolean reverse , int orderLineNumber){
        super(reverse, orderLineNumber);
        orderBy = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                double o1Size = o1.length() / CONVERT_TO_KB;
                double o2Size = o2.length() / CONVERT_TO_KB;
                if (!(o1Size == o2Size)) {
                    return o1Size < o2Size ? -1 : 1;
                }
                else {
                    return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                }
            }
        };
    }
}