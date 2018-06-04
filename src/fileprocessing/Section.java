package fileprocessing;

import fileprocessing.Filter.Filter;
import fileprocessing.order.Order;

import java.lang.reflect.Array;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Section {

    Filter myFilter;
    Order myOrder;
    List<File> filteredFile;

    Section(Filter filter, Order order){
        this.myFilter = filter;
        this.myOrder = order;
    }

    void getFile(File sourceDir){
        File[] sourceDirFiles = sourceDir.listFiles(File::isFile);
        for (File file : sourceDirFiles) {
            if (myFilter.doFilter(file)) {
                filteredFile.add(file);
            }
        }
        myOrder.orderFiles(filteredFile);
    }

    void printFile(){
        for (Object aFilteredFile : filteredFile) {
            System.out.println(aFilteredFile.toString());
        }
    }

    void printWarning(){
        if (myFilter.hasWarning()){
            myFilter.printWarning();
        }
        //todo hasWarning, printWarning for order
    }
}
