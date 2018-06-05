package filesprocessing.order;


import java.io.File;
import java.util.Comparator;
import java.util.List;

public abstract class Order {

    //the type of order in which to sort the files by//
    Comparator<File> orderBy;
    boolean hasWarning = false;
    int orderLineNumber;

    //true if the sorting is done in reverse, false otherwise
    boolean toReverse;

    public Order(int orderLineNumber){
        this.toReverse = false;
        this.hasWarning = true;
        this.orderLineNumber =orderLineNumber;
    }

    public Order(boolean reverse, int orderLineNumber){
        this.orderLineNumber =orderLineNumber;
        this.toReverse = reverse;
    }

    public void orderFiles(List<File> filesToOrder) {
        if (toReverse) {
            filesToOrder.sort(orderBy.reversed());
        }
        else {
        filesToOrder.sort(orderBy);}
    }

    /**
     * if order has warning, will print them as required
     */
    public void printWarning(){
        if (hasWarning){
            System.err.println("Warning in line "+ orderLineNumber);
        }
    }


}
