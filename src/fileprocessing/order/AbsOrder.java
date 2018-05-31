package fileprocessing.order;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AbsOrder extends Order {

    public AbsOrder(){
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
