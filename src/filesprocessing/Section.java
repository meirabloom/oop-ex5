package filesprocessing;

import filesprocessing.Filter.Filter;
import filesprocessing.order.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Section object that was created by the section factory, and contains it's filter
 * and order, and when given sourceDir file filter it and orders the filtered files
 */
public class Section {

    private Filter myFilter;
    private Order myOrder;
    private List<File> filteredFile;

    /**
     * the constructor
     * @param filter - the type of filter required
     * @param order - the type of order required
     */
    Section(Filter filter, Order order){
        this.myFilter = filter;
        this.myOrder = order;
    }

    /**
     * adds the files that pass the filter requirements into an array, and sorts them according to the
     * specific command
     * @param sourceDir the files
     */
    void getFile(File sourceDir){
        filteredFile = new ArrayList<>();
        File[] sourceDirFiles = sourceDir.listFiles(File::isFile);
        for (File file : sourceDirFiles) {
            if (myFilter.doFilter(file)) {
                filteredFile.add(file);
            }
        }
       myOrder.orderFiles(filteredFile);
    }

    /**
     * prints the names of the files that have passed the filter, in the sorted order
     */
    void printFile(){
        for (File aFilteredFile : filteredFile) {
            System.out.println(aFilteredFile.getName());
        }
    }

    /**
     * prints the warnings from each subsection
     */
    void printWarning(){
        myFilter.printWarning();
        myOrder.printWarning();
    }
}
