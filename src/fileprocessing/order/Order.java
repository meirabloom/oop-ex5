package fileprocessing.order;


import java.io.File;
import java.util.Comparator;
import java.util.List;

public abstract class Order {

    Comparator<File> orderBy;

    public void orderFiles(List<File> filesToOrder){
        filesToOrder.sort(orderBy);
    }
}
