package fileprocessing.order;


import java.io.File;
import java.util.Comparator;
import java.util.List;

public abstract class Order {

    //the type of order in which to sort the files by//
    Comparator<File> orderBy;

    //true if the sorting is done in reverse, false otherwise
    boolean toReverse;

    public Order(){
        this.toReverse = false;
    }

    public Order(boolean reverse){
        this.toReverse = reverse;
    }

    public void orderFiles(List<File> filesToOrder) {
        if (toReverse) {
            filesToOrder.sort(orderBy.reversed());
        }
        filesToOrder.sort(orderBy);
    }
}
