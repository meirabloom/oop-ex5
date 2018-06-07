package filesprocessing.order;


import java.io.File;
import java.util.Comparator;
import java.util.List;

/**
 * an abstract class representing the order object
 */
public abstract class Order {

    //the type of order in which to sort the files by//
    Comparator<File> orderBy;
    boolean hasWarning = false;
    int orderLineNumber;

    //true if the sorting is done in reverse, false otherwise
    boolean toReverse;

    /**
     * constructor for when there is a warning
     * @param orderLineNumber - the number of the line in which to order
     */
    public Order(int orderLineNumber){
        this.toReverse = false;
        this.hasWarning = true;
        this.orderLineNumber =orderLineNumber;
    }

    /**
     * constructor
     * @param reverse - checks if the order is done in reverse
     * @param orderLineNumber - the line in which the order type is specified
     */
    public Order(boolean reverse, int orderLineNumber){
        this.orderLineNumber =orderLineNumber;
        this.toReverse = reverse;
    }

    /**
     * sorts the files according the the order command (and if required, reverses the order)
     * @param filesToOrder - the files
     */
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
