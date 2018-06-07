package filesprocessing;

import filesprocessing.Filter.Filter;
import filesprocessing.order.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a sub-Section, that contains it's filter and order, and when given sourceDir file
 * filter it and orders the filtered files
 */
public class Section {

    private Filter myFilter;
    private Order myOrder;
    private List<File> filteredFile;

    Section(Filter filter, Order order){
        this.myFilter = filter;
        this.myOrder = order;
    }

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

    void printFile(){
        for (File aFilteredFile : filteredFile) {
            System.out.println(aFilteredFile.getName());
        }
    }

    void printWarning(){
        myFilter.printWarning();
        myOrder.printWarning();
    }
}
