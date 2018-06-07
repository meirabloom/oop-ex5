package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * a class extending the Order class, compares files by type
 */
public class TypeOrder extends Order {

    private static final String SPLIT_BY = "\\.";
    private static final String NO_TYPE = " ";

    /**
     * implements a comparator that compares each two files by type. if the files are of the same type,
     * compares by absolute path
     * @param reverse - true if reverse is requires, false otherwise
     * @param orderLineNumber - the line of the order command
     */
    public TypeOrder(boolean reverse, int orderLineNumber ){
        super(reverse, orderLineNumber);
        orderBy = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String[] o1Name = o1.getName().split(SPLIT_BY);
                String[] o2Name = o2.getName().split(SPLIT_BY);
                String o1Type = o1Name.length <= 1 ? NO_TYPE : o1Name[o1Name.length - 1];
                String o2Type = o2Name.length <= 1 ? NO_TYPE : o2Name[o2Name.length - 1];
                if (!o1Type.equals(o2Type)){
                    return o1Type.compareTo(o2Type);
                }
                else {
                    return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                }
            }
        };
    }
}
