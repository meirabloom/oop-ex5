package fileprocessing.order;

import java.io.File;
import java.util.Comparator;

public class TypeOrder extends Order {

    public TypeOrder(){
        orderBy = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String o1Path = o1.getAbsolutePath();
                String o2Path = o2.getAbsolutePath();
                return o1Path.compareTo(o2Path);
            }
        };
    }
}
