package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * a class extending the Order class, compares files by Size
 */
public class SizeOrder extends Order {

    /**
     * implements a comparator that compares each two files by size. if the files are of the same size,
     * compares by absolute path
     * @param reverse - true if reverse is requires, false otherwise
     * @param orderLineNumber - the line of the order command
     */
    public SizeOrder(boolean reverse , int orderLineNumber){
        super(reverse, orderLineNumber);
        orderBy = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                long o1Size = o1.length();
                long o2Size = o2.length();
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
